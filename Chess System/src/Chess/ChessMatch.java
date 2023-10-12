package Chess;

import Chess.Pieces.King;
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

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());

    }

    private void initialSetup(){

        placeNewPiece('b', 6, new Rook(board, Color.WHITE));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
    }
}
