import com.sun.source.tree.CaseTree;
import model.*;
import model.exceptions.AlreadyOccupiedException;
import model.exceptions.InvalidPointException;
import view.ConsoleView;

import java.util.Scanner;

public class CLI {

    public static void main(String[] args) throws AlreadyOccupiedException, InvalidPointException {
        final int mode = askMode();

        final Player player = new Player("Andrew", Figure.X);
        final Field field = new Field(3);
        final Game game = new Game(player, field);

        ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);
        while(consoleView.move(game, mode)){
            consoleView.show(game);
        }

    }

    private static int askMode(){
        System.out.println("Please, input game mode: 1 or 2  ");
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
}
