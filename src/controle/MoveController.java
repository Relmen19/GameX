package controle;

import model.Field;
import model.Figure;
import model.Point;
import model.exceptions.AlreadyOccupiedException;
import model.exceptions.InvalidPointException;

public class MoveController {

    public void applyFigure(Field field, Point point, Figure figure) throws InvalidPointException,
                                                                            AlreadyOccupiedException {
        if(field.getFigure(point) != null) throw new AlreadyOccupiedException();
        field.setFigure(point, figure);
    }
}
