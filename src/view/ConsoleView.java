package view;

import controle.CurrentMoveController;
import controle.MoveController;
import controle.WinnerController;
import model.Field;
import model.Figure;
import model.Game;
import model.Point;
import model.exceptions.AlreadyOccupiedException;
import model.exceptions.InvalidPointException;

import java.math.MathContext;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();

    private final RandomCoordinateGetter randomCoordinateGetter = new RandomCoordinateGetter();

    private final AICoordinateGetter aiCoordinateGetter = new AICoordinateGetter();

    public void show(Game game){
        final Field field = game.getField();
        for(int x = 0; x < field.getSize(); x++){
            if (x != 0) printSeparator();
            printLine(field, x);
        }
    }

    public boolean move(Game game, int gameMode){
        final Field field = game.getField();

        final Figure currentFigure = currentMoveController.currentMoveFirstX(field);
        final Figure winner = winnerController.getWinner(field);

        if(currentFigure == null && winner == null){
            System.out.println("No winner no move!");
            return false;
        }

        if(winner != null) {
            System.out.format("Winner is: %s\n", winner);
            return false;
        }


        Point point = null;

        switch (currentFigure) {
            case X:
                System.out.format("Please enter coordinate for figure: %s\n", currentFigure);
                point = askPoint();
                try {
                    moveController.applyFigure(field, point, currentFigure);
                } catch (InvalidPointException | AlreadyOccupiedException e) {
                    System.out.println("Invalid coordinate, pls enter correct coordinate\n");
                }
                break;
            case O:
                if(gameMode == 1) point = randomCoordinateGetter.coordinateGetter(field);
                if(gameMode == 2) point = aiCoordinateGetter.coordinateGetter(field);
                moveController.applyFigure(field, point, currentFigure);
                System.out.println();
                break;
        }

        return true;
    }


    private Point askPoint(){
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String coordinateName){
        System.out.format("Please, input: %s  ", coordinateName);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    private void printLine(Field field, int x){
        for(int y = 0; y < field.getSize(); y++) {
            if (y != 0) System.out.print("|");
            System.out.print(" ");
            Figure figure;
            try {
                figure = field.getFigure(new Point(x, y));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure == null ? " ": figure);
            System.out.print(" ");
        }
        System.out.println();
    }

    private void printSeparator(){
        System.out.println("~~~~~~~~~~~");
    }

}
