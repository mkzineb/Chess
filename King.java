import java.util.List;

public class King extends Piece {

    public King(int x, int y, Player owner){
		super(x, y, owner);
		owner.setKing(this);
    }
    /**
     * */
    public boolean isMoveAuthorized(Board board, Coordinates destination){
        if(destination.getX() < 0 || destination.getY() < 0 ||
                destination.getX() > 7 || destination.getY() >7) {
            return false;
        }
        return true;
    }
    /** a function that gets the piece type.
     * */
    @Override
    public Type getType() {
	return Type.KING;
    }

    /** a function that
     * @return the value of each piece
     * */
    @Override
    public int getValue() {
	        return 0; }

    public List<Move> getAllMoves(Board board) { return null;
    }
}
