package me.wellthatssad.plugins.games.followerkill.follow_kill.classtypes;

public class Follower {
    //Gson utility class
    public String from_id;
    public String from_login;
    public String from_name;
    public String to_id;

    public String getFrom_id() {
        return from_id;
    }

    public String getFrom_login() {
        return from_login;
    }

    public String getFrom_name() {
        return from_name;
    }

    public String getTo_id() {
        return to_id;
    }

    public String getTo_name() {
        return to_name;
    }

    public String getFollowed_at() {
        return followed_at;
    }

    public String to_name;
    public String followed_at;

    public Follower(String from_id, String from_login, String from_name, String to_id, String to_name, String followed_at) {
        this.from_id = from_id;
        this.from_login = from_login;
        this.from_name = from_name;
        this.to_id = to_id;
        this.to_name = to_name;
        this.followed_at = followed_at;
    }
}
