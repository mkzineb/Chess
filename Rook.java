import java.util.List;

public class Rook extends Piece{
    public Rook(int x, int y, Player owner) {
        super(x, y, owner);
        owner.setRook(this);
    }
    /**
     * */
    @Override
    public boolean isMoveAuthorized(Board board, Coordinates destination) {
        int dx = destination.getX();
        int dy = destination.getY();
        int ox = this.getX();
        int oy = this.getY();
        if (ox == dx || oy==dy){
            return true;
        }
        else return false;
    }


    /** a function that gets the piece type.
     * */
    @Override
    public Type getType() {
        return Type.ROOK;
    }


    /** a function that
     * @return the value of each piece
     * */
    @Override
    public int getValue() {
        return 5;
    }


    /** a function that gets the piece type.
     * */
    public List<Move> getAllMoves(Board board) { return null;
    }
}
