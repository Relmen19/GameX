package controle;

import model.Field;
import model.Figure;
import model.Point;
import model.exceptions.InvalidPointException;
import org.junit.Test;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void currentMoveFirstXWhenONext() {
        Field field = new Field(3);

        try {
            field.setFigure(new Point(0, 0), Figure.X);
            field.setFigure(new Point(0, 1), Figure.O);
            field.setFigure(new Point(0, 2), Figure.X);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        CurrentMoveController currentMoveController = new CurrentMoveController();
        assertEquals(Figure.O, currentMoveController.currentMoveFirstX(field));
    }

    @Test
    public void currentMoveFirstXWhenXNext() {
        Field field = new Field(3);

        try {
            field.setFigure(new Point(0, 0), Figure.O);
            field.setFigure(new Point(0, 1), Figure.X);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        CurrentMoveController currentMoveController = new CurrentMoveController();
        assertEquals(Figure.X, currentMoveController.currentMoveFirstX(field));
    }

    @Test
    public void currentMoveFirstXWhenBoardFull() {
        Field field = new Field(3);

        try {
            for(int i = 0; i < field.getSize(); i++){
                for(int j = 0; j < field.getSize(); j++) {
                    field.setFigure(new Point(i, j), Figure.X);
                }
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        CurrentMoveController currentMoveController = new CurrentMoveController();
        assertNull(currentMoveController.currentMoveFirstX(field));
    }
}