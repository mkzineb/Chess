import java.util.ArrayList;
import java.util.List;

public abstract class Piece
{
    protected Coordinates position;
    protected Player owner;
    private int x;
    private int y;

    public Piece(int x, int y, Player owner){
        this.position = new Coordinates(x,y);
        this.owner = owner;
        this.x=x;
        this.y=y;
    }


    public enum Type {
        KING,
        QUEEN,
        ROOK,
        BISHOP,
        KNIGHT,
        PAWN
    }

    public void setPosition(Coordinates destination){ this.position = destination;

    }

    
    public Player getOwner(){
	return owner;
    }

    public ChessColor getColor(){ return owner.color; }

    public Coordinates getPosition(){
	return position;
    }

    public int getX(){ return this.x ; } // not sure it's correct
    
    public int getY(){ return this.y ;} // same here

    public List<Move> getAllMoves(Board board) {
        List<Move> allMoveslist = new ArrayList<>();
        for (Coordinates position : board.getAllCoordinates()){
            if(this.isMoveAuthorized(board,position)){
                allMoveslist.add(new Move(board, getOwner().getFromTo()));
            }
            return allMoveslist;
        }
        return null;
    }

    public boolean sameColor(Piece piece){
	    if (piece.getColor()== owner.getColor())
           return true;
	    else return false;
    }

    public abstract boolean isMoveAuthorized(Board board, Coordinates destination);

    public abstract Type getType();
    public abstract int getValue();
    

}
