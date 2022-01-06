import java.util.Stack;

public class GameUI {
    public Board board;
    private Player white;
    private Player black;
    private Player currentPlayer;
    private ChessUI ui;
    private Stack<Move> history;
    
    public GameUI(ChessUI ui, String boardConfigFileName, Player white, Player black){
        this.board = new Board(boardConfigFileName, white, black);
        this.white = white;
        this.black = black;
        this.currentPlayer = white;
        this.ui = ui;
	    this.history = new Stack<Move>();
        for(Piece p : board.getPieces())
            this.ui.placePiece(p.getType(), p.getColor(), p.getPosition());
    }

    public Board getBoard(){ return board;
    }

    public boolean undo(){
        if(this.history.empty()) return false;
        Move move = this.history.pop();
        board.emptyCell(move.destination);
        ui.removePiece(move.destination);
        if(move.pieceAtDestination != null){
            move.pieceAtDestination.setPosition(move.destination);
            board.addPiece(move.pieceAtDestination);
            ui.placePiece(move.pieceAtDestination.getType(), move.pieceAtDestination.getColor(), move.pieceAtDestination.getPosition());
        }
        board.emptyCell(move.origin);
        ui.removePiece(move.origin);
        move.pieceAtOrigin.setPosition(move.origin);
        board.addPiece(move.pieceAtOrigin);
        ui.placePiece(move.pieceAtOrigin.getType(), move.pieceAtOrigin.getColor(), move.pieceAtOrigin.getPosition());

        currentPlayer = move.pieceAtOrigin.getOwner();
        if(move.pieceAtDestination != null)
            currentPlayer.removeFromScore(move.pieceAtDestination.getValue());
        return true;
    }


    /**
     *
     * @param gameMove
     * @return verifie si un mouvement ne provoquera pas la capture du roi
     */
    public boolean isMovePlayable(Move gameMove){
        Piece p = board.getPiece(gameMove.origin);
        if(p.getOwner() != currentPlayer) return false;
        return p.isMoveAuthorized(board,gameMove.destination);

    }
    
    public void applyMove(Move move){
        // cond1 && cond2
    }

    public void switchPlayers(){
        if(currentPlayer.color == ChessColor.WHITE){
            currentPlayer = black;
        }else currentPlayer = white;
    }

    public Player getOpponent(Player player){

        if(currentPlayer.color == ChessColor.WHITE){
            return  black;
        }else return white;
    }

    public boolean isPrey(Piece prey){
	return false;
    }

    public boolean isCheck(Player player){
	return false;
    }

    public boolean isCheckMate(Player player){
	return false;
    }
    
    public void determineWinner(){
    }
    
    public void play(){
        int numberOfHits = 0;
        while(numberOfHits < 10){
            Move move = new Move(board,currentPlayer.getFromTo());
            if(! isMovePlayable(move)) continue;
            numberOfHits ++;
            switchPlayers();
        }
    }
}
