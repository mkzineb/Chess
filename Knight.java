import java.util.List;

public class Knight extends Piece{
    public Knight(int x, int y, Player owner) {
        super(x, y, owner);
        owner.setKnight(this);
    }
    /**
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
        return Type.KNIGHT ;
    }


    /** a function that
     * @return the value of each piece
     * */
    @Override
    public int getValue() {
        return 3;
    }



    /** a function that returns a list of all the moves of the piece
     * */
    public List<Move> getAllMoves(Board board) { return null;
    }
}
