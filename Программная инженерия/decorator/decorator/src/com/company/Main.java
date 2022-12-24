package com.company;

public class Main {
    public static void main(String[] args)
    {
        Player messi = new Messi();
        Player messiArg = new ArgentinaPlayerDecorator(new Messi());
        messi.show();
        System.out.println(" ");
        messiArg.show();
    }
}
