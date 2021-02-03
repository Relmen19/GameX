package model;

public class Game {
    private final Player player;
    private final Field field;

    public Game(Player player, Field field) {
        this.player = player;
        this.field = field;
    }

    public Player getPlayer() {
        return player;
    }

    public Field getField() {
        return field;
    }
}
