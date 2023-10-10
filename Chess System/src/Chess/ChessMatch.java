package Chess;

import Chess.Pieces.Rook;
import boardgame.Board;
import boardgame.Position;

public class ChessMatch {
    private Board board;

    public ChessMatch(){

        this.board = new Board(8,8);
        initialSetup();
    }

    public ChessPiece[][] getPieces(){

        ChessPiece[][] array2D = new ChessPiece[board.getRows()][board.getColumns()];

        for (int outerLoop = 0; outerLoop < board.getRows(); outerLoop++) {
            for (int innerLoop = 0; innerLoop < board.getColumns(); innerLoop++) {
                array2D[outerLoop][innerLoop] = (ChessPiece) board.piece(outerLoop, innerLoop);
            }

        }

        return array2D;
    }

    private void initialSetup(){
        this.board.placePiece(new Rook(board, Color.WHITE), new Position(2,1));
    }
}
