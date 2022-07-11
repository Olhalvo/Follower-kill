package me.wellthatssad.plugins.games.followerkill.follow_kill.imports;

import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;
import me.wellthatssad.plugins.games.followerkill.follow_kill.Main;
import me.wellthatssad.plugins.games.followerkill.follow_kill.classtypes.*;
import me.wellthatssad.plugins.games.followerkill.follow_kill.exceptions.HttpCodeException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

// this is the heart of this entire plugin, and the class that took the most research and work to make
// I hate myself for ever deciding to start this project
// but hey when it's done at least I can flex I spent hours reading the api of the "gamer" streaming platform
public class GetFollowerClass {
    static Main main = Main.getInstance();
    //omg I am using the Google json library
    public static final Gson gson = new Gson();

    public final Dotenv dotenv = Dotenv.configure().load();
    //and .env s what is up with me :O:O:O:O

    public final String OAUTHKEY = dotenv.get("OAUTH_KEY");
    //not my proudest moment, it took me HOURS to learn how to use oauth
    public final String CLIENTID = dotenv.get("CLIENT_ID");
    public String name;
    static List<Integer> errorCodes = new ArrayList<Integer>();


    public int getFolowerTotal(String id) throws IOException
    {
        // Yes I split the general operation in two functions bcuz I am a rebel
        HttpURLConnection connection;
        connection = connect("https://api.twitch.tv/helix/users/follows?to_id=" + id);
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Client-ID", this.CLIENTID);
        connection.setRequestProperty("Authorization", String.format("Bearer %s", this.OAUTHKEY));
        // HOLY MOTHER OF GOD IT TOOK ME A **WHILE** TO LEARN HOW TO USE HEADERS
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder buff = new StringBuilder();
        while ((inputLine = reader.readLine()) != null) {
            buff.append(inputLine);
        }
        // ^ stolen code, don't mind me, thank you random guy on Grepper
        String Json = buff.toString();
        reader.close();
        Formatter formatter = new Formatter("buffer.json");
        formatter.format("%s", Json);
        connection.disconnect();
        formatter.close();
        //^ really like the way I implemented the buffer json file
        Reader fileReader = Files.newBufferedReader(Paths.get("buffer.json"));
        FollowersData data = gson.fromJson(fileReader, FollowersData.class);
        clearBuffer();//yessir a method to clean the .json so I don't overuse about 500bytes of plain text data
        return data.getTotal();
    }


    public static void handleResponseCode(int code)throws HttpCodeException{
        if(errorCodes.contains(code)){
            throw new HttpCodeException(code);
        }
        // me wanting to be funny

    }

    public static HttpURLConnection connect(String urlString) throws IOException {
        URL url = new URL(urlString);
        return (HttpURLConnection) url.openConnection();
        // this made this surprisingly convenient to understand
    }

    public GetFollowerClass(String name){
        this.name = name;
        errorCodes.add(400);
        errorCodes.add(401);
        errorCodes.add(403);
        errorCodes.add(404);
        errorCodes.add(408);
        errorCodes.add(409);
        errorCodes.add(500);
        errorCodes.add(502);
        errorCodes.add(504);
        // goofy ahh constructor
    }

    public static void handleException(HttpCodeException e){
        switch (e.getCode()) {
            case 400 -> main.getLogger().info("Code 400, Bad Request");
            case 401 -> main.getLogger().info("Code 401, Unauthorized");
            case 403 -> main.getLogger().info("Code 403, Forbidden");
            case 404 -> main.getLogger().info("Code 404, Not Found");
            case 408 -> main.getLogger().info("Code 408, Request Timeout");
            case 409 -> main.getLogger().info("Code 409, Conflict");
            case 429 -> main.getLogger().info("Code 429, Rate Limited");
            case 500 -> main.getLogger().info("Code 500, Internal Server Error");
            case 502 -> main.getLogger().info("Code 502, Bad Gateway");
            case 504 -> main.getLogger().info("Code 504, Gateway Timeout");
            default -> main.getLogger().info("Code " + e.getCode() + ", undefined");
        }

    }

    public static void clearBuffer() throws FileNotFoundException {
        File file = new File("buffer.json");
        PrintWriter writer = new PrintWriter(file);
        writer.print("\u0000");
        writer.close();
        // yessir would you look at that clean file buffer clearing
    }


    public int run(){
        try{
            // this is basically the same whole ordeal of the getting the follower total class
            HttpURLConnection connection = connect("https://api.twitch.tv/helix/users?login=" + this.name);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Client-ID", this.CLIENTID);
            connection.setRequestProperty("Authorization", String.format("Bearer %s", this.OAUTHKEY));
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder buff = new StringBuilder();
            while ((inputLine = reader.readLine()) != null) {
                buff.append(inputLine);
            }
            String Json = buff.toString();
            reader.close();
            Formatter formatter = new Formatter("buffer.json");
            formatter.format("%s", Json);
            formatter.close();
            connection.disconnect();
            Reader fileReader = Files.newBufferedReader(Paths.get("buffer.json"));
            UserData userData = gson.fromJson(fileReader, UserData.class);
            User user = userData.getData()[0];
            clearBuffer();
            return getFolowerTotal(user.getId());

        }
        catch(Exception e){
            /*
            I could spend hours explaining how genius and lazy this catch statement is
            this has got to be one of the weirdest, if not the weirdest, piece of code I have ever written
            I love it so much, but I hate it at the same it's so cheesy
             */
            String message = e.getMessage();
            String[] split = message.split(" ");
            if(split.length >= 6 &&split[4].equalsIgnoreCase("code:") ) {
                int code = Integer.parseInt(split[5]);
                try{
                    handleResponseCode(code);
                }
                catch(HttpCodeException codeException) {
                    handleException(codeException);
                }
            }
            else {
                e.printStackTrace();
            }
        }
        return -1;
    }

}
