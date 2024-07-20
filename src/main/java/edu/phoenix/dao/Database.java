package edu.phoenix.dao;

import edu.phoenix.model.UserNotFoundException;
import edu.phoenix.model.User;

import java.util.ArrayList;
import java.util.List;

public class Database {
  public static List<User> dataBase = new ArrayList<>();

  public static void addUser(String name, String login, String password) {
    try {
      if (login.isEmpty()) {
          throw new UserNotFoundException("login не может быть пустым");
      }
    }
    finally {}
    dataBase.add(new User(name, login, password));
  }

  public static User getUser(String login, String password) {
    try {
      if (login.isEmpty()) {
        throw new UserNotFoundException("Пустой login");
      }

    } catch (Exception e) {
        System.out.println(e.getMessage());
        return null;
    }
      return dataBase.stream()
            .filter(obj -> obj.getLogin().equals(login))
            .findFirst()
            .orElse(null);
  }

  public static void deleteUser(String login) {
    dataBase.remove(getUser(login, ""));
  }

  public static void updateUser(User user) {
    int index_user = dataBase.indexOf(getUser(user.getLogin(), user.getPassword()));
    dataBase.set(index_user, user);
  }

}
