import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Board{
    private Piece[][] array;


    public Board(String fileName, Player white, Player black){
	int pieceType;
	int col;
	int row;
	String nextWord;
	Player owner;
	
	this.array = new Piece[8][8];
	try {
	    File file = new File(fileName);
    	    if(file.exists()==false) {
		System.err.println("Error: Cannot find file "+ fileName);
		System.exit(1);		
            } 

	    Scanner in = new Scanner(file);
	    while(in.hasNext()) {
		if ((nextWord = in.nextLine()).length()>2) {
		    pieceType = nextWord.charAt(0);
		    col = nextWord.charAt(1)-'0';
		    row = nextWord.charAt(2)-'0';

		    owner = black;
		    if (pieceType >= 'a' && pieceType <= 'z')
		    	owner = white;
		    switch(pieceType) {
		    case 'K' : case 'k':
    			{ this.addPiece(new King(col, row, owner)); break;}
    			case 'Q' : case'q':
				{ this.addPiece(new Queen(col, row, owner)); break;}
				case 'B' : case 'b':
				{ this.addPiece(new Bishop(col, row, owner)); break;}
				case 'N' : case 'n':
				{ this.addPiece(new Knight(col, row, owner)); break;}
				case 'P' : case 'p':
				{ this.addPiece(new Pawn(col, row, owner)); break;}
				case 'R' : case 'r':
				{ this.addPiece(new Rook(col, row, owner)); break;}
		    }
	    	}
	    }
	    in.close();
	}
	catch(FileNotFoundException e) {
	    System.err.println("Error file not found : "+e);
	    System.exit(1);	
	}
    }
    
    public List<Coordinates> getAllCoordinates(){
    	ArrayList<Coordinates> coordinates = new ArrayList();
		for (int i = 1; i < array.length; i++) {
			for (int j = 1; j < array.length; j++) {
				coordinates.add(new Coordinates(i, j));
			}
		}
		return coordinates;
	}
    
    public List<Piece> getPieces(Player player) {
		ArrayList<Piece> listofplayerpieces = new ArrayList();
		for (int i = 1; i < array.length; i++) {
			for (int j = 1; j < array.length; j++) {
				if(array[i][j].getOwner() == player)
					listofplayerpieces.add(array[i][j]);
			}
		}
		return listofplayerpieces;
    }

    public List<Piece> getPieces() {
		List list = new ArrayList();
		for(Piece[] arr : array)
			for(Piece p : arr){
				if (p==null)
					continue;
				list.add(p);
			}
		return list;
    }

    public void addPiece(Piece piece){
    	array[piece.getX()][piece.getY()]= piece;
    }

    public Piece getPiece(Coordinates coordinates){
		return array[coordinates.getX()][coordinates.getY()];
    }

    public Piece getPiece(int x, int y){
		return array[x][y];
    }

    /** a function that deletes the piece in coordinates
	 * */
    public void emptyCell(Coordinates coordinates){
    	if(isEmptyCell(coordinates) == false){// ! negation
    		array[coordinates.getX()][coordinates.getY()]= null;
		}
    }


    
    public boolean isEmptyCell(Coordinates coordinates){
    	if (array[coordinates.getX()][coordinates.getY()]== null)
			return true;
    	else return false;
    }

    public boolean isEmptyCell(int x, int y){
		if (array[x][y]== null)
			return true;
		else return false;
    }
    
    public boolean sameColumnNothingBetween(Coordinates origin, Coordinates destination){
		Boolean check = false;
		for (int i =origin.getY();i<destination.getY();i++) {
			if (array[i][origin.getX()] == null) {
				check = true;
			}
		}
		return check;

	}
    
    public boolean sameRowNothingBetween(Coordinates origin, Coordinates destination){
		Boolean check=false;
		if (origin.getY()==destination.getY()){
			for (int i=origin.getX()+1;i<destination.getX();i++){
				check= isEmptyCell(origin.getX(), i);
			}
		}
		return check;
	}


    public boolean sameDiagonalNothingBetween(Coordinates origin, Coordinates destination){
		Boolean check=false;
		if (destination.getY()>origin.getY() && destination.getX()>origin.getX()){
			for(int l=origin.getX()+1;l<destination.getX();l++){
				for(int m=origin.getY()+1;m<destination.getY();m++){
					if (l==destination.getX() && m==destination.getY()){
						for(int i=origin.getX()+1;i<destination.getX()-1;i++){
							for(int k=origin.getY()+1;k<destination.getY()-1;k++){
								check=isEmptyCell(i,k);

							}
						}
					}}}}
		if (destination.getY()<origin.getY() && destination.getX()>origin.getX()){
			for(int l=origin.getX()+1;l<destination.getX();l++){
				for(int m=origin.getY()-1;m<destination.getY();m--){
					if (l==destination.getX() && m==destination.getY()){
						for(int i=origin.getX()+1;i<destination.getX()-1;i++){
							for(int k=origin.getY()-1;k<destination.getY()+1;k++){
								check=isEmptyCell(i,k);
							}
						}
					}}}}
		if (destination.getY()>origin.getY() && destination.getX()<origin.getX()){
			for(int l=origin.getX()-1;l<destination.getX();l--){
				for(int m=origin.getY()+1;m<destination.getY();m++){
					if (l==destination.getX() && m==destination.getY()){
						for(int i=origin.getX()-1;i<destination.getX()+1;i++){
							for(int k=origin.getY()+1;k<destination.getY()+1;k++){
								check=isEmptyCell(i,k);
							}
						}
					}}}}
		if (destination.getY()>origin.getY() && destination.getX()>origin.getX()){
			for(int l=origin.getX()+1;l<destination.getX();l++){
				for(int m=origin.getY()+1;m<destination.getY();m++){
					if (l==destination.getX() && m==destination.getY()){
						for(int i=origin.getX()+1;i<destination.getX()-1;i++){
							for(int k=origin.getY()+1;k<destination.getY()-1;k++){
								check=isEmptyCell(i,k);

							}
						}
					}}}}
		if (destination.getY()>origin.getY() && destination.getX()>origin.getX()){
			for(int l=origin.getX()-1;l<destination.getX();l--){
				for(int m=origin.getY()-1;m<destination.getY();m--){
					if (l==destination.getX() && m==destination.getY()){
						for(int i=origin.getX()-1;i<destination.getX()-1;i--){
							for(int k=origin.getY()-1;k<destination.getY()-1;k--){
								check=isEmptyCell(i,k);

							}
						}
					}}}}




		return check;

	}
}
