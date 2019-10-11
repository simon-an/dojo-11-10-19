package de.metafinanz.codingdojo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CommandReader command = new CommandReader(reader);
        boolean end = false;
        Game game = null;
        while (!end) {
            try {

                Pair<Command, Vector<Character>> currentCommand = command.readNextCommand();
                System.out.println(currentCommand.getLeft());
                System.out.println(currentCommand.getRight());

                if (currentCommand.getLeft().equals(Command.END)) {
                    end = true;
                }

                game = CommandHandler.doMagic(game, currentCommand);
            } catch (Exception ex) {
                System.out.println("try again");
            }
            game.print(System.out);
            String playerWon = game.checkGameWon();
            if (playerWon != null) {
                System.out.println(playerWon);
                end = true;
            }
        }
    }
}
