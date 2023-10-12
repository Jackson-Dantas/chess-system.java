package boardgame;

public abstract class Piece {
    protected Position position; //Protected: Only subClass and class at same package can accesss this instance field
    private Board board; //Private: Only Class Itself can access!!

    public Piece(Board board) {
        this.board = board;
    }

    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMoves();
            public boolean possibleMove(Position position){
                return possibleMoves()[position.getRow()][position.getColumn()];
        }
    public boolean isThereAnyPossibleMove(){
         boolean[][] mat = possibleMoves();
         for(int i = 0; i < mat.length; i++){
             for (int j = 0; j < mat.length; j++) {
                 if(mat[i][j]){
                     return true;
                 }
             }
         }
         return false;
    }
}
