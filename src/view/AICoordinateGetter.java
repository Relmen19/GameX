package view;

import model.Field;
import model.Figure;
import model.Point;
import model.exceptions.InvalidPointException;

public class AICoordinateGetter implements ICoordinateGetter {

    @Override
    public Point coordinateGetter(final Field field) throws InvalidPointException {
        if(field.getFigure(new Point(1, 1)) == null) return new Point(1, 1);

        if(field.getFigure(new Point(0, 0)) == null && field.getFigure(new Point(2, 2)) == null) return new Point(0, 0);
        else if(field.getFigure(new Point(0, 0)) == Figure.X && field.getFigure(new Point(2, 2)) == null) return new Point(2, 2);
        else if (field.getFigure(new Point(0, 0)) == Figure.X && field.getFigure(new Point(2, 2)) == Figure.O) {

            if(field.getFigure(new Point(0, 2)) == Figure.O && field.getFigure(new Point(2, 0)) == null) {
                if(field.getFigure(new Point(1, 2)) == null) return new Point(1, 2);
                else if(field.getFigure(new Point(1, 0)) == null) return new Point(1, 0);
                else if(field.getFigure(new Point(1, 0)) == Figure.O) {
                    if(field.getFigure(new Point(2, 1)) == null) return new Point(2, 1);
                    else if(field.getFigure(new Point(0, 1)) == null) return new Point(0, 1);
                    else if(field.getFigure(new Point(0, 1)) == Figure.O) return new Point(2, 0);
                }
            }

            if(field.getFigure(new Point(2, 0)) == Figure.O && field.getFigure(new Point(0, 2)) == null){
                if(field.getFigure(new Point(2, 1)) == null) return new Point(2, 1);
                else if(field.getFigure(new Point(0, 1)) == null) return new Point(0, 1);
                else if(field.getFigure(new Point(0, 1)) == Figure.O) {
                    if(field.getFigure(new Point(1, 2)) == null) return new Point(1, 2);
                    else if(field.getFigure(new Point(1, 0)) == null) return new Point(1, 0);
                    else if(field.getFigure(new Point(1, 0)) == Figure.O) return new Point(0, 1);
                }
            }

            if(field.getFigure(new Point(1, 2)) == Figure.O || field.getFigure(new Point(1, 0)) == Figure.O) {
                if(field.getFigure(new Point(0, 2)) == null) return new Point(0, 2);
                if(field.getFigure(new Point(0, 1)) == null) return new Point(0, 1);
                if(field.getFigure(new Point(2, 0)) == null) return new Point(2, 0);
            }

            if(field.getFigure(new Point(2, 1)) == Figure.O || field.getFigure(new Point(0, 1)) == Figure.O) {
                if(field.getFigure(new Point(2, 0)) == null) return new Point(2, 0);
                if(field.getFigure(new Point(1, 0)) == null) return new Point(1, 0);
                if(field.getFigure(new Point(0, 2)) == null) return new Point(0, 2);
            }
        }


        if(field.getFigure(new Point(0, 2)) == null && field.getFigure(new Point(2, 0)) == null) return new Point(0, 2);
        else if(field.getFigure(new Point(0, 2)) == Figure.X && field.getFigure(new Point(2, 0)) == null) return new Point(2, 0);
        else if(field.getFigure(new Point(0, 2)) == Figure.X && field.getFigure(new Point(2, 0)) == Figure.O) {

            if(field.getFigure(new Point(2, 2)) == Figure.O && field.getFigure(new Point(0, 0)) == null) {
                if(field.getFigure(new Point(2, 1)) == null) return new Point(2, 1);
                else if(field.getFigure(new Point(0, 1)) == null) return new Point(0, 1);
                else if(field.getFigure(new Point(0, 1)) == Figure.O) {
                    if(field.getFigure(new Point(1, 0)) == null) return new Point(1, 0);
                    else if(field.getFigure(new Point(1, 2)) == null) return new Point(1, 2);
                    else if(field.getFigure(new Point(1, 2)) == Figure.O) return new Point(0, 0);
                }
            }

            if(field.getFigure(new Point(0, 0)) == Figure.O && field.getFigure(new Point(2, 2)) == null){
                if(field.getFigure(new Point(1, 0)) == null) return new Point(1, 0);
                else if(field.getFigure(new Point(1, 2)) == null) return new Point(1, 2);
                else if(field.getFigure(new Point(1, 2)) == Figure.O) {
                    if(field.getFigure(new Point(2, 1)) == null) return new Point(2, 1);
                    else if(field.getFigure(new Point(0, 1)) == null) return new Point(0, 1);
                    else if(field.getFigure(new Point(0, 1)) == Figure.O) return new Point(2, 2);
                }
            }

            if(field.getFigure(new Point(1, 2)) == Figure.O || field.getFigure(new Point(1, 0)) == Figure.O) {
                if(field.getFigure(new Point(0, 0)) == null) return new Point(0, 0);
                if(field.getFigure(new Point(0, 1)) == null) return new Point(0, 1);
                if(field.getFigure(new Point(2, 2)) == null) return new Point(2, 2);
            }

            if(field.getFigure(new Point(2, 1)) == Figure.O || field.getFigure(new Point(0, 1)) == Figure.O) {
                if(field.getFigure(new Point(2, 2)) == null) return new Point(2, 2);
                if(field.getFigure(new Point(1, 2)) == null) return new Point(1, 2);
                if(field.getFigure(new Point(0, 0)) == null) return new Point(0, 0);
            }
        }
        return new Point(1, 1);
    }

}
