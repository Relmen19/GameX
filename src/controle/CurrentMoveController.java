package controle;

import model.Field;
import model.Figure;
import model.Point;
import model.exceptions.InvalidPointException;

import static model.Figure.*;

public class CurrentMoveController {

    public Figure currentMoveFirstX(final Field field) {
        int counterFigure = 0;
        for (int i = 0; i < field.getSize(); i++) {
            counterFigure += figureCounterInRow(field, i);
        }

        if (counterFigure == field.getSize() * field.getSize()) return null;
        if (counterFigure % 2 == 0) return Figure.X;
        return Figure.O;
    }

    private int figureCounterInRow(Field field, final int row) {
        int counterFigure = 0;
        for (int i = 0; i < field.getSize(); i++) {
            try {
                if (!(field.getFigure(new Point(row, i)) == null)) {
                    counterFigure++;
                }
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return counterFigure;
    }
}