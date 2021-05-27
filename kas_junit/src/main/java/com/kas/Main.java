package com.kas;

public class Main {
    public static void main(String[] args) {
        new User("Артем", 20, Gender.MALE);
        new User("Леша", 18, Gender.MALE);
        new User("Антон", 4, Gender.FEMALE);


        System.out.println("All users: ");
        User.getAllUsers().forEach(System.out::println);
        System.out.println("All users Male: ");
        User.getAllUsers(Gender.MALE).forEach(System.out::println);
        System.out.println("All users Female: ");
        User.getAllUsers(Gender.FEMALE).forEach(System.out::println);
        System.out.println("user's amount: ");
        System.out.println(User.getHowManyUsers());
        System.out.println("user's amount Male: ");
        System.out.println(User.getHowManyUsers(Gender.MALE));
        System.out.println("user's amount Female: ");
        System.out.println(User.getHowManyUsers(Gender.FEMALE));
        System.out.println("avg all users age: ");
        System.out.println(User.getAllAgeUsers());
        System.out.println("avg all users age Male: ");
        System.out.println(User.getAllAgeUsers(Gender.MALE));
        System.out.println("avg all users age Female: ");
        System.out.println(User.getAllAgeUsers(Gender.FEMALE));
        System.out.println("avg amount users age: ");
        System.out.println(User.getAverageAgeOfAllUsers());
        System.out.println("avg amount users age Male: ");
        System.out.println(User.getAverageAgeOfAllUsers(Gender.MALE));
        System.out.println("avg amount users age Female: ");
        System.out.println(User.getAverageAgeOfAllUsers(Gender.FEMALE));
    }
}
