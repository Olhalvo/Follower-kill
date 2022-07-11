package me.wellthatssad.plugins.games.followerkill.follow_kill.classtypes;

public class User {
    //Gson utility class
    public String id;
    public String login;
    public String display_name;
    public String type;

    public String broadcaster_type;

    public String description;

    public User(String id, String login, String display_name, String type, String broadcaster_type, String description, String profile_image_url, String offline_image_url, int view_count, String email, String created_at) {
        this.id = id;
        this.login = login;
        this.display_name = display_name;
        this.type = type;
        this.broadcaster_type = broadcaster_type;
        this.description = description;
        this.profile_image_url = profile_image_url;
        this.offline_image_url = offline_image_url;
        this.view_count = view_count;
        this.email = email;
        this.created_at = created_at;
    }

    public String profile_image_url;
    public String offline_image_url;
    public int view_count;
    public String email;
    public String created_at;

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getType() {
        return type;
    }

    public String getBroadcaster_type() {
        return broadcaster_type;
    }

    public String getDescription() {
        return description;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public String getOffline_image_url() {
        return offline_image_url;
    }

    public int getView_count() {
        return view_count;
    }

    public String getEmail() {
        return email;
    }

    public String getCreated_at() {
        return created_at;
    }
    // kill me kill me kill me
}
