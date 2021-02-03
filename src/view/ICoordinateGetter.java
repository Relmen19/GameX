package view;

import model.Field;
import model.Point;
import model.exceptions.AlreadyOccupiedException;
import model.exceptions.InvalidPointException;

public interface ICoordinateGetter {
     Point coordinateGetter(Field field) throws InvalidPointException, AlreadyOccupiedException;
}
