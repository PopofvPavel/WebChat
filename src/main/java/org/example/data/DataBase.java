package org.example.data;

import java.util.ArrayList;
import java.util.List;

public final class DataBase {

    private static final List<User> users = new ArrayList<User>();
    private static final List<ChatMessage> messages = new ArrayList<ChatMessage>();

    private DataBase() {
    }

    public static void init() {
        System.out.println("Установка соединения с Базой Данных");
        users.add(new User("admin", "admin", "Arsen", UserType.ADMIN));
        users.add(new User("user1", "user1", "Akakiy", UserType.CLIENT));
        users.add(new User("user2", "user2", "Artemiy", UserType.CLIENT));

    }

    public static User getUserByLogin(String login) {
        return users.stream().filter(u -> u.getLogin().equals(login)).findFirst().orElse(null);

    }

    public static List<ChatMessage> getMessages() {
        return messages;
    }

    public static List<User> getUsers() {
        System.out.println("GEt users = " + users);
        return users;
    }

    public static void close() {
        System.out.println("Закрытие соединения с Базой Данных");
    }
}
