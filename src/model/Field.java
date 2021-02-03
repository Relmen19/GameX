package model;

import model.exceptions.AlreadyOccupiedException;
import model.exceptions.InvalidPointException;

import java.security.InvalidParameterException;

public class Field {

    private static final int  MIN_FIELD_SIZE = 0;
    private final Figure[][] field;

    public Field(int MAX_FIELD_SIZE) {
        this.field = new Figure[MAX_FIELD_SIZE][MAX_FIELD_SIZE];
    }

    public int getSize(){
        return field.length;
    }

    public Figure getFigure(Point point) throws InvalidPointException {
        if(!checkPoint(point)) throw new InvalidPointException();
        return field[point.getX()][point.getY()];
    }

    public void setFigure(Point point, Figure figure) throws InvalidPointException{
        if(!checkPoint(point)) throw new InvalidPointException();

        field[point.getY()][point.getX()] = figure;
    }

    private boolean checkPoint(final Point point){
        return checkCoordinate(point.getX()) && checkCoordinate(point.getY());
    }

    private boolean checkCoordinate(final int coordinate){
        return coordinate >= MIN_FIELD_SIZE && coordinate <= field.length;
    }
}
