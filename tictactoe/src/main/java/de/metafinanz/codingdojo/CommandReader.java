package de.metafinanz.codingdojo;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Vector;

public class CommandReader {

    BufferedReader input;

    public CommandReader(BufferedReader reader) {
        this.input = reader;
    }

    public Pair<Command, Vector<Character>> readNextCommand() throws IOException, IllegalArgumentException {

        String line = this.input.readLine();
        switch (line) {
        case "new game":
            return new Pair<Command, Vector<Character>>(Command.NEW_GAME, new Vector<>());
        case "end":
            return new Pair<Command, Vector<Character>>(Command.END, new Vector<>());
        default: {
            if (line.length() != 2) {
                throw new IllegalArgumentException("Wrong Coordinates");
            }
            Vector<Character> vector = new Vector<>();
            vector.add(line.charAt(0));
            vector.add(line.charAt(1));
            return new Pair<Command, Vector<Character>>(Command.PLAYER_TURN, vector);
        }
        }
    }
}