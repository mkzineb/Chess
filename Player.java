import java.util.ArrayList;
import java.util.List;

public abstract class Player{
    protected ChessColor color;
    private int score;
    private King king;
    private Bishop bishop;
    public boolean isCheck;
    public boolean isCheckMate;

    public Player(ChessColor color){
        this.color = color;

    }

    public ChessColor getColor(){
	return color;
    }

    public int getScore(){
	return score;
    }

    public void addToScore(int value){
        score += value;
    }
    
    public void removeFromScore(int value){
        score -= value;
    }
    
    public abstract FromTo getFromTo();

    public Piece getKing(){
	return king;
    }
    

    
    public boolean isCheckMate(Board board){
	return false;
    }

    public void setCheck(){
        this.isCheckMate = true;
    }

    public void unSetCheck(){
        this.isCheckMate= false;
    }
    
    public List<Move> getAllMoves(Board board) {return null;
    }

    @Override
    public String toString() {
        return "Player{" +
                "color=" + color +
                ", score=" + score +
                ", king=" + king +
                ", isCheck=" + isCheck +
                ", isCheckMate=" + isCheckMate +
                '}';
    }

    public void setKing(King king){
    }
    public void setBishop(Bishop bishop){
    }
    public void setRook(Rook rook){
    }
    public void setQueen(Queen queen){
    }
    public void setKnight( Knight knight){
    }
    public void setPawn(Pawn pawn){
    }
}
