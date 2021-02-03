package controle;

import model.Field;
import model.Figure;
import model.Point;
import model.exceptions.InvalidPointException;
import org.jetbrains.annotations.NotNull;

public class WinnerController {

    public Figure getWinner(final Field field) throws InvalidPointException {

        try {

            for (int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(i, 0), p -> {
                    final Point point = new Point(p.getX(), p.getY() + 1);
                    return point;
                })) {
                    return field.getFigure(new Point(i, 0));
                }
            }

            for (int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(0, i), p -> new Point(p.getX() + 1, p.getY())))
                    return field.getFigure(new Point(0, i));
            }

            for (int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(0, 0), p -> new Point(p.getX() + 1, p.getY() + 1)))
                    return field.getFigure(new Point(1, 1));
            }

            for (int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(0, 2), p -> new Point(p.getX() + 1, p.getY() - 1)))
                    return field.getFigure(new Point(1, 1));
            }

        } catch(InvalidPointException e){
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(@NotNull Field field, Point startPoint, final IPointChanger pointChanger) throws InvalidPointException{

        if(field.getFigure(startPoint) != null){
            Point p1 = pointChanger.next(startPoint);
            if(field.getFigure(startPoint) == field.getFigure(p1)) {
                if (p1.getX() == (field.getSize() - 1) || p1.getY() == (field.getSize() - 1)) return true;
                return check(field, p1, pointChanger);
            }
        }

        return false;
    }


    private interface IPointChanger {
        Point next(final Point p);
    }
}
