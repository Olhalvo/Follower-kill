package me.wellthatssad.plugins.games.followerkill.follow_kill.exceptions;

public class HttpCodeException extends Exception{
    //The sole creation of this exception started in the original get followers project bcuz I wanted to learn
    //how to use custom exceptions, it works, but it's lowkey useless when you think abt it
    public int code;
    public HttpCodeException(int code){
        super();
        this.code = code;
    }

    public HttpCodeException(int code, String message){
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
