package me.wellthatssad.plugins.games.followerkill.follow_kill.classtypes;

public class FollowersData {
    //Gson utility class
    int total;
    Follower[] data;

    public FollowersData(int total, Follower[] data) {
        this.total = total;
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public Follower[] getData() {
        return data;
    }
}
