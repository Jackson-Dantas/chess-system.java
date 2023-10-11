package boardgame;

public class Board {
    private int rows, columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if(rows < 1 || columns < 1){
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column!");
        }
        this.rows = rows;
        this.columns = columns;
        this.pieces = new Piece[rows][columns];
    }
//Specific methods:

    public Piece piece(int rows, int columns){
        if(!existsAux(rows, columns)){
            throw new BoardException("Position not on the board");
        }
            return pieces[rows][columns];
    }

    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece inputPiece, Position inputPosition){
        if(thereIsAPiece((inputPosition))){
            throw new BoardException("There is already a piece on position " + inputPosition);
        }
        this.pieces[inputPosition.getRow()][inputPosition.getColumn()] = inputPiece;
        inputPiece.position = inputPosition;
    }
    private boolean existsAux(int row, int column){
        return row >= 0 && row < this.rows && column >= 0 && column < this.columns;
    }
    public boolean positionExists(Position position){
        return existsAux(position.getRow(), position.getColumn());
    }
    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }

//Special methods Getters and Setters
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

}
