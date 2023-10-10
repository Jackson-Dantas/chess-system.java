package boardgame;

public class Board {
    private int rows, columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.pieces = new Piece[rows][columns];
    }
//Specific methods:

public Piece piece(int rows, int columns){
        return pieces[rows][columns];
}

    public Piece piece(Position position){
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece inputPiece, Position inputPosition){
        this.pieces[inputPosition.getRow()][inputPosition.getColumn()] = inputPiece;
        inputPiece.position = inputPosition;
    }

//Special methods Getters and Setters
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
}
