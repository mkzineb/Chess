import java.util.List;

public class Queen extends Piece {
    public Queen(int x, int y, Player owner) {
        super(x, y, owner);
        owner.setQueen(this);
    }


    /** a function that determines whether the move is authorized by the
     * piece Queen
     * @return true if the move is valid and false if it's not
     * */
    @Override
    public boolean isMoveAuthorized(Board board, Coordinates destination) {
        int dx = destination.getX();
        int dy = destination.getY();
        int ox = this.getX();
        int oy = this.getY();
        return true;
    }


    /** a function that gets the piece type.
     * */
    @Override
    public Type getType() {
        return Type.QUEEN;
    }




    /** a function that
     * @return the value of each piece
     * */
    @Override
    public int getValue() {
        return 9;
    }



    /** a function that returns a list of all the moves of the piece
     * */
    public List<Move> getAllMoves(Board board) { return null;
    }
}
