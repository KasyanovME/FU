package com.company;

public abstract class PlayerDecorator implements Player {

    protected Player decoratedPlayer;

    public PlayerDecorator(Player decoratedPlayer) {
        this.decoratedPlayer = decoratedPlayer;
    }

    public void show() {
        decoratedPlayer.show();
    }
}
