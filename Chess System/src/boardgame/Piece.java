package boardgame;

public class Piece {
    protected Position position; //Protected: Only subClass and class at same package can accesss this instance field
    private Board board; //Private: Only Class Itself can access!!

    public Piece(Board board) {
        this.board = board;
    }

    protected Board getBoard() {
        return board;
    }
}
