package view;

import model.Field;
import model.Point;
import model.exceptions.AlreadyOccupiedException;
import model.exceptions.InvalidPointException;

import java.util.Random;

public class RandomCoordinateGetter implements ICoordinateGetter{

    public Point coordinateGetter(Field field) throws InvalidPointException, AlreadyOccupiedException {
        Random random = new Random();
        while(true){
            Point point = new Point(random.nextInt(3), random.nextInt(3));
            if(field.getFigure(point) == null) return point;
        }
    }
}
