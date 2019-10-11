package de.metafinanz.codingdojo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Vector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandReaderTest {

    @Test
    public void testNewGameCommandIsParsed() throws Exception {
        String test = "new game";
        Reader inputString = new StringReader(test);
        BufferedReader reader = new BufferedReader(inputString);
        CommandReader commandReader = new CommandReader(reader);
        Pair<Command, Vector<Character>> result = commandReader.readNextCommand();
        assertEquals(Command.NEW_GAME, result.getLeft());
    }
    @Test
    public void testPlayer1CommandIsParsed() throws Exception {
        String test = "new game\nA0";
        Reader inputString = new StringReader(test);
        BufferedReader reader = new BufferedReader(inputString);
        CommandReader commandReader = new CommandReader(reader);
        commandReader.readNextCommand();
        Pair<Command, Vector<Character>> result = commandReader.readNextCommand();
        assertEquals(Command.PLAYER_TURN, result.getLeft());
    }
    @Test
    public void testPlayer2CommandIsParsed() throws Exception {
        String test = "new game\nA0\nA1";
        Reader inputString = new StringReader(test);
        BufferedReader reader = new BufferedReader(inputString);
        CommandReader commandReader = new CommandReader(reader);
        commandReader.readNextCommand();
        commandReader.readNextCommand();
        Pair<Command, Vector<Character>> result = commandReader.readNextCommand();
        assertEquals(Command.PLAYER_TURN, result.getLeft());
    }

    @Test
    public void testEndCommandIsParsed() throws Exception {
        String test = "new game\nA0\nA1\nend";
        Reader inputString = new StringReader(test);
        BufferedReader reader = new BufferedReader(inputString);
        CommandReader commandReader = new CommandReader(reader);
        commandReader.readNextCommand();
        commandReader.readNextCommand();
        commandReader.readNextCommand();
        Pair<Command, Vector<Character>> result = commandReader.readNextCommand();
        assertEquals(Command.END, result.getLeft());
    }

    @Test()
    public void testCoordinatesWrong() throws Exception {
        String test = "new game\nA0\nA15\nend";
        Reader inputString = new StringReader(test);
        BufferedReader reader = new BufferedReader(inputString);
        CommandReader commandReader = new CommandReader(reader);
        commandReader.readNextCommand();
        commandReader.readNextCommand();
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            commandReader.readNextCommand();
        });
    }
}
