import java.util.List;

public class Bishop extends Piece {


    public Bishop(int x, int y, Player owner) {
        super(x, y, owner);
        owner.setBishop(this);
    }

    /** a function that determines whether the bishop is moving diagnolly
     * */
    @Override
    public boolean isMoveAuthorized(Board board, Coordinates destination) {
        int dx = destination.getX();
        int dy = destination.getY();
        int ox = this.getX();
        int oy = this.getY();
        if (Math.abs(dx - ox)==Math.abs(dy - oy)){
            return true;}
        else return false;
    }
    /** a function that gets the piece type.
     * */
    @Override
    public Type getType() {
        return Type.BISHOP;
    }

    /** a function that
     * @return the value of each piece
     * */
    @Override
    public int getValue() {
        return 3;
    }

    public List<Move> getAllMoves(Board board) { return null;
    }
}
