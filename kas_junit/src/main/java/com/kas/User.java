package com.kas;

import java.util.*;

public class User {
    private int id;
    private String name;
    private int age;
    private Gender gender;

    private static Map<Integer, User> allUsers;

    private static int countId = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(user, user.name) &&
                gender == user.gender;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, gender);
    }

    public User(String name, int age, Gender gender) {
        if (allUsers == null){
            allUsers = new HashMap<>();
        }

        this.name = name;
        this.age = age;
        this.gender = gender;

        if (!hasUser()){
            countId++;
            this.id = countId;
            allUsers.put(id, this);
        }
    }

    private boolean hasUser() {
        for (User user : allUsers.values()){
            if (user.equals(this) && user.hashCode() == this.hashCode()){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + gender +
                '}';
    }
    public static List<User> getAllUsers(){
        return new ArrayList<>(allUsers.values());
    }

    public static List<User> getAllUsers(Gender gender){
        List<User> listAllUsers = new ArrayList<>();
        for (User user : allUsers.values()){
            if (user.gender == gender){
                listAllUsers.add(user);
            }
        }
        return listAllUsers;
    }

    public static int getHowManyUsers(){
        return allUsers.size();
    }

    public static int getHowManyUsers(Gender gender){
        return getAllUsers(gender).size();
    }

    public static int getAllAgeUsers(){
        int countAge = 0;
        for (User user : allUsers.values()){
            countAge += user.age;
        }
        return countAge;
    }

    public static int getAllAgeUsers(Gender gender){
        int countAge = 0;
        for (User user : getAllUsers(gender)){
            countAge += user.age;
        }
        return countAge;
    }

    public static int getAverageAgeOfAllUsers(){
        return getAllAgeUsers() / getHowManyUsers();
    }

    public static int getAverageAgeOfAllUsers(Gender gender){
        return getAllAgeUsers(gender) / getHowManyUsers(gender);
    }
}
