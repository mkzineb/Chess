public class ChessBot extends Player{
    public ChessBot(ChessColor color) {
        super(color);
        this.color = ChessColor.BLACK;
    }

    @Override
    public FromTo getFromTo() {
        return null;
    }
}
