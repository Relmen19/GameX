package model;

public class Player {

    final private String name;

    final private Figure figure;

    public Player(final String name, final Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    public Figure getFigure() {
        return figure;
    }

    public String getName() {
        return name;
    }
}
