package controle;

import model.Field;
import model.Figure;
import model.Point;
import model.exceptions.InvalidPointException;
import org.junit.Test;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void getWinnerWhenWinnerRow() throws InvalidPointException {
        Field field = new Field(3);
        try {
            for (int i = 0; i < field.getSize(); i++)
                    field.setFigure(new Point(i, 0), Figure.X);

            final WinnerController winnerController = new WinnerController();

            assertEquals(Figure.X, winnerController.getWinner(field));
        }catch (InvalidPointException e){ }
    }

    @Test
    public void getWinnerWhenWinnerColumn() throws InvalidPointException {
        Field field = new Field(3);
        try {
            for (int i = 0; i < field.getSize(); i++)
                    field.setFigure(new Point(0, i), Figure.X);
            final WinnerController winnerController = new WinnerController();

            assertEquals(Figure.X, winnerController.getWinner(field));
        }catch (InvalidPointException e){ }
    }

    @Test
    public void getWinnerWhenWinnerDiagonal1() throws InvalidPointException {
        Field field = new Field(3);
        try {
            for (int i = 0; i < field.getSize(); i++) {
                field.setFigure(new Point(i, i), Figure.X);
            }
            final WinnerController winnerController = new WinnerController();

            assertEquals(Figure.X, winnerController.getWinner(field));
        }catch (InvalidPointException e){ }
    }

    @Test
    public void getWinnerWhenWinnerDiagonal2() throws InvalidPointException {
        Field field = new Field(3);
        try {
            for (int i = 0; i < field.getSize(); i++) {
                field.setFigure(new Point(i, field.getSize() - i - 1), Figure.X);
            }
            final WinnerController winnerController = new WinnerController();

            assertEquals(Figure.X, winnerController.getWinner(field));
        }catch (InvalidPointException e){ }
    }

    @Test
    public void getWinnerWhenNoWinnerRow() throws InvalidPointException {
        Field field = new Field(3);
        try {
            field.setFigure(new Point(0, 0), Figure.O);
            field.setFigure(new Point(1, 0), Figure.O);
            field.setFigure(new Point(2, 0), Figure.X);

            final WinnerController winnerController = new WinnerController();

            assertNull(winnerController.getWinner(field));
        }catch (InvalidPointException e){ }
    }

    @Test
    public void getWinnerWhenNoWinnerColumn() throws InvalidPointException {
        Field field = new Field(3);
        try {
            field.setFigure(new Point(0, 0), Figure.X);
            field.setFigure(new Point(0, 1), Figure.O);
            field.setFigure(new Point(0, 2), Figure.X);

            final WinnerController winnerController = new WinnerController();

            assertNull(winnerController.getWinner(field));
        }catch (InvalidPointException e){ }
    }

    @Test
    public void getWinnerWhenNoWinnerDiagonal1() throws InvalidPointException {
        Field field = new Field(3);
        try {
            field.setFigure(new Point(0, 0), Figure.X);
            field.setFigure(new Point(1, 1), Figure.X);
            field.setFigure(new Point(2, 2), Figure.O);

            final WinnerController winnerController = new WinnerController();

            assertNull(winnerController.getWinner(field));
        }catch (InvalidPointException e){ }
    }

    @Test
    public void getWinnerWhenNoWinnerDiagonal2() throws InvalidPointException {
        Field field = new Field(3);
        try {
            field.setFigure(new Point(0, 2), Figure.X);
            field.setFigure(new Point(1, 1), Figure.O);
            field.setFigure(new Point(2, 0), Figure.X);

            final WinnerController winnerController = new WinnerController();

            assertNull(winnerController.getWinner(field));
        }catch (InvalidPointException e){ }
    }
}

