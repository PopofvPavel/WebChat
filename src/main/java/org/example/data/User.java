package org.example.data;

public class User {

    private final String login;
    private final String password;
    private final String name;
    private final UserType userType;
    private boolean online = false;
    private boolean isBanned = false;

    public User(String login, String password, String name, UserType userType) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.userType = userType;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public UserType getUserType() {
        return userType;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return name + " (" + userType + ")";
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }
}
