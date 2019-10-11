package de.metafinanz.codingdojo;

import java.util.Vector;

/**
 * CommandHandler
 */
public class CommandHandler {

    public static Game doMagic(Game game, Pair<Command, Vector<Character>> command) {

        switch (command.getLeft()) {
        case PLAYER_TURN:
            game.playerTurn(command.getRight());
            return game;
        case NEW_GAME:
        default:
            return new Game();
        }
    }
}