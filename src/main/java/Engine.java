

public class Engine {
    final int sizeOfBoard = 15;
    private BoardCell[][] board = new BoardCell[sizeOfBoard][sizeOfBoard];
    private char[] pickedTiles = new char[7];

    Engine() {
        initializeBoard();
        setTestBoard();
        setPickedTiles();
        findAnchors();
        printBoard();

    }


    public void initializeBoard() {
        for (int i = 0; i < sizeOfBoard; i++) {
            for (int j = 0; j < sizeOfBoard; j++) {
                board[i][j] = new BoardCell();
            }
        }

    }

    public void setTestBoard() {
        board[7][3].setLetter('t');
        board[7][4].setLetter('e');
        board[7][5].setLetter('s');
        board[7][6].setLetter('t');
        board[7][7].setLetter('a');
        board[7][8].setLetter('a');

        board[4][4].setLetter('g');
        board[5][4].setLetter('a');
        board[6][4].setLetter('m');

        board[8][6].setLetter('a');
        board[9][6].setLetter('a');
        board[10][6].setLetter('a');
        board[11][6].setLetter('a');
        board[12][6].setLetter('a');

    }

    public void setPickedTiles() {
        pickedTiles[0] = 'a';
        pickedTiles[1] = 'b';
        pickedTiles[2] = 'c';
        pickedTiles[3] = 'd';
        pickedTiles[4] = 'e';
        pickedTiles[5] = 'f';
        pickedTiles[6] = 'g';
    }


    public void printBoard() {

        for (int i = 0; i < sizeOfBoard; i++) {
            for (int j = 0; j < sizeOfBoard; j++) {
                if (board[i][j].getLetter() == '\u0000') {
                    if (board[i][j].isAnchor()) {
                        System.out.print("X");
                    } else {
                        System.out.print('-');
                    }
                } else {
                    System.out.print(board[i][j].getLetter());
                }
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    private void findAnchors() {
        //todo: in final version anchors should be added after adding a new word to board
        //todo: this loop doesnt check anchors on border of board
        for (int i = 1; i < (sizeOfBoard - 1); i++) {
            for (int j = 1; j < (sizeOfBoard - 1); j++) {
                if (board[i][j + 1].occupied && board[i][j].canBeAnchor()) {
                    board[i][j].setAnchor();
                }
                if (board[i][j - 1].occupied && board[i][j].canBeAnchor()) {
                    board[i][j].setAnchor();
                }
                if (board[i + 1][j].occupied && board[i][j].canBeAnchor()) {
                    board[i][j].setAnchor();
                }
                if (board[i - 1][j].occupied && board[i][j].canBeAnchor()) {
                    board[i][j].setAnchor();
                }
            }
        }
    }

    private void transposeBoard() {

    }




}
