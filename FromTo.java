public class FromTo {
    public  final Coordinates from ;
    public  final Coordinates to;


    public FromTo(int ox, int oy, int dx, int dy) {
	this.from = new Coordinates(ox,oy);
	this.to = new Coordinates(ox+dx,oy+dy);
    }

    public Coordinates getFrom() {
        return from;
    }

    public Coordinates getTo() {
        return to;
    }
}
