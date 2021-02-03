package model;

import model.exceptions.AlreadyOccupiedException;
import model.exceptions.InvalidPointException;
import org.junit.Test;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void testGetSize() {
        final Field field = new Field(3);

        assertEquals(3, field.getSize());
    }

    @Test
    public void testSetFigure() throws Exception {
        final Field field = new Field(3);
        final Point point = new Point(1, 2);
        final Figure figure = Figure.X;

        field.setFigure(point, figure);
        final Figure actualFigure = field.getFigure(point);

        assertEquals(figure, actualFigure);
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception{
        final Field field = new Field(3);
        final Point point = new Point(1, 2);

        final Figure actualFigure = field.getFigure(point);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenYIsLessZero() throws Exception{
        final Field field = new Field(3);
        final Point point = new Point(1, -1);

        try{
            field.getFigure(point);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenXIsLessZero() throws Exception{
        final Field field = new Field(3);
        final Point point = new Point(-1, 0);

        try{
            field.getFigure(point);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenYIsMoreThenSize() throws Exception{
        final Field field = new Field(3);
        final Point point = new Point(1, field.getSize() + 1);

        try{
            field.getFigure(point);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenXIsMoreThenSize() throws Exception{
        final Field field = new Field(3);
        final Point point = new Point(field.getSize() + 1, 0);

        try{
            field.getFigure(point);
            fail();
        } catch (final InvalidPointException e) {}
    }

//    @Test
//    public void testSetFigureInNotNullField() throws Exception{
//        final Field field = new Field();
//        final Point point = new Point(0, 0);
//        final Figure figureX = Figure.X;
//        final Figure figureO = Figure.O;
//
//        field.setFigure(point, figureX);
//
//        try{
//            field.setFigure(point, figureO);
//            fail();
//        } catch (final AlreadyOccupiedException e) {}
//    }
}