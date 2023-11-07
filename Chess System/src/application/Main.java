package application;

import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;
import boardgame.Position;

import java.util.*;

public class Main {
    public static void main(String[] args) {

     /* Map<Integer, String> map = new Hashtable<>();
        map.put(1, "Hi");
        boolean contain = map.containsValue("Hi");
        */

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while (!chessMatch.getCheckMate()){
            try{
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);



                boolean [][] possibleMoves = chessMatch.possibileMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);
                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                if(capturedPiece != null){
                    captured.add(capturedPiece);
                }


            } catch (ChessException exception){

                System.out.println(exception.getMessage());
                sc.nextLine();

            } catch (InputMismatchException exception){

                System.out.println(exception.getMessage());
                sc.nextLine();
            }

        }

        UI.clearScreen();
        UI.printMatch(chessMatch, captured);

    }
    //just to remember reverse String Algo.
    static String reverse(String inputString, String reversedString, int index){

        if(inputString == null || index <= 0){
            return reversedString + inputString.charAt(0);
        }
        return reverse(inputString, reversedString + inputString.charAt(index), index -1);
    }
}