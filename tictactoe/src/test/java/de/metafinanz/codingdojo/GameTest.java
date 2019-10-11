package de.metafinanz.codingdojo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Vector;

import org.junit.jupiter.api.Test;

public class GameTest 
{
    @Test
    public void printWorks()
    {
        Game game = new Game();
        
        assertEquals(
        " A B C\n"+
        "0 | | \n"+
        " -+-+- \n"+ 
        "1 | | \n"+
        " -+-+- \n"+
        "2 | | ", game.toString());
    }

    @Test
    public void playerTurn1A0(){
        Game game = new Game();
        Vector<Character> v = new Vector<>(2);
        v.add('A');
        v.add('0');
        game.playerTurn(v);


        assertEquals(
        " A B C\n"+
        "0O| | \n"+
        " -+-+- \n"+ 
        "1 | | \n"+
        " -+-+- \n"+
        "2 | | ", game.toString());
    }

    @Test
    public void playerTurn1C1(){
        Game game = new Game();
        Vector<Character> v = new Vector<>(2);
        v.add('C');
        v.add('1');
        game.playerTurn(v);

        assertEquals(
        " A B C\n"+
        "0 | | \n"+
        " -+-+- \n"+ 
        "1 | |O\n"+
        " -+-+- \n"+
        "2 | | ", game.toString());
    }

    @Test
    public void playerTurn2B1(){
        Game game = new Game();
        Vector<Character> v = new Vector<>(2);
        v.add('C');
        v.add('1');
        game.playerTurn(v);
        Vector<Character> v2 = new Vector<>(2);
        v2.add('B');
        v2.add('1');
        game.playerTurn(v2);

        assertEquals(
        " A B C\n"+
        "0 | | \n"+
        " -+-+- \n"+ 
        "1 |X|O\n"+
        " -+-+- \n"+
        "2 | | ", game.toString());
    }
}
