package Chess;

import Chess.Pieces.King;
import Chess.Pieces.Rook;
import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

import java.util.ArrayList;
import java.util.List;

public class ChessMatch {
    private int turn;
    private Color currentPlayer;
    private Board board;
    private List<Piece> piecesOnTheBoard, capturedPieces;

    public ChessMatch(){
        this.board = new Board(8,8);
        this.turn = 1;
        this.currentPlayer = Color.WHITE;
        initialSetup();
        piecesOnTheBoard = new ArrayList<>();
        capturedPieces = new ArrayList<>();
    }

    public int getTurn(){
        return turn;
    }

    public Color getCurrentPlayer(){
        return currentPlayer;
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

    public boolean[][] possibileMoves(ChessPosition sourcePosition){
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }
    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
        nextTurn();
        return (ChessPiece) capturedPiece;
    }
    private Piece makeMove(Position source, Position target){
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);

        if(capturedPiece != null){
            piecesOnTheBoard.remove(capturedPiece);
            capturedPieces.add(capturedPiece);
        }

        return  capturedPiece;
    }
    private void validateSourcePosition(Position position){
        if(!board.thereIsAPiece(position)){
            throw new ChessException("There is no piece on source position");
        }
        if(this.currentPlayer != ((ChessPiece)board.piece(position)).getColor()){
            throw new ChessException("The chosen piece isn't yours!!");
        }
        if(!board.piece(position).isThereAnyPossibleMove()){
            throw new ChessException("There is no possible moves for the chosen");
        }
    }

    private void validateTargetPosition(Position source, Position target){
        if(!board.piece(source).possibleMove(target)){
            throw new ChessException("The chosen piece can't move to target position");
        }
    }

    private void nextTurn(){
        this.turn++;
        this.currentPlayer = (this.currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
        piecesOnTheBoard.add(piece);
    }

    private void initialSetup(){
        placeNewPiece('b', 6, new Rook(board, Color.WHITE));
        placeNewPiece('e', 8, new King(board, Color.BLACK));

    }
}
