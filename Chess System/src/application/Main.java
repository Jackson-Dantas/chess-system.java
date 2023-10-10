package application;

import Chess.ChessMatch;
import boardgame.Position;

public class Main {
    public static void main(String[] args) {

        ChessMatch chess = new ChessMatch();
        UI.printBoard(chess.getPieces());
    }
    //just to remember reverse String Algo.
    static String reverse(String inputString, String reversedString, int index){

        if(inputString == null || index <= 0){
            return reversedString + inputString.charAt(0);
        }
        return reverse(inputString, reversedString + inputString.charAt(index), index -1);
    }
}