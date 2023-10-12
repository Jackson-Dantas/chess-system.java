package application;

import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;
import boardgame.Position;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true){
            try{
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                System.out.println();

                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            } catch (ChessException exception){

                System.out.println(exception.getMessage());
                sc.nextLine();

            } catch (InputMismatchException exception){

                System.out.println(exception.getMessage());
                sc.nextLine();
            }

        }


    }
    //just to remember reverse String Algo.
    static String reverse(String inputString, String reversedString, int index){

        if(inputString == null || index <= 0){
            return reversedString + inputString.charAt(0);
        }
        return reverse(inputString, reversedString + inputString.charAt(index), index -1);
    }
}