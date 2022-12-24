package com.company;

public class ArgentinaPlayerDecorator extends PlayerDecorator{

    public ArgentinaPlayerDecorator(Player decoratedPlayer) {
        super(decoratedPlayer);
    }

    @Override
    public void show() {
        decoratedPlayer.show();
        setNation(decoratedPlayer);
    }

    private void setNation(Player decoratedPlayer) {
        System.out.println("я из Аргентины");
    }
}
