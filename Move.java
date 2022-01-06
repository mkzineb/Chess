public class Move {
	public Coordinates origin;
	public Coordinates destination;
	public Piece pieceAtOrigin;
	public Piece pieceAtDestination;

	public Move(Board board, Coordinates origin, Coordinates destination) {
		this.origin = origin;
		this.destination = destination;
		this.pieceAtOrigin = board.getPiece(origin);
		this.pieceAtDestination = board.getPiece(destination.getX(), destination.getY());
	}
    
    public Move(Coordinates origin, Coordinates destination, Piece pieceAtOrigin, Piece pieceAtDestination){
	this.origin = origin;
	this.destination = destination;
	this.pieceAtOrigin = pieceAtOrigin;
	this.pieceAtDestination = pieceAtDestination;
    }
    
    public Move(Board board, FromTo ft){
	this(board, ft.from, ft.to);
	}

}