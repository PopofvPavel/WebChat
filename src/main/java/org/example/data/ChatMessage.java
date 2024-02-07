package org.example.data;

public class ChatMessage {
    private final String message;
    private final User user;


    public ChatMessage(String message, User user) {
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return user.toString() + " : " + message;
    }
}
