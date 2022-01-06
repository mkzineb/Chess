import java.util.Objects;

public class Coordinates{
    private int x;
    private int y;
    private Objects o;
    
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }


    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this && o instanceof Coordinates)   {
            return true;
        } else return false;
    }

}
