public class BoardCell {
    boolean anchor;
    boolean occupied;
    char letter;

    public BoardCell() {
        occupied = false;
        anchor = false;
        letter = '\u0000'; //null
    }

    public void setLetter(char letter) {
        occupied = true;
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    public void setAnchor() {
        anchor = !anchor;
    }

    public boolean isAnchor() {
        return (anchor);
    }

    public boolean canBeAnchor() {
        return (!occupied && !anchor) ;
    }
}
