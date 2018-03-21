public class Board {
    private int[][] tiles;

    public Board(int[][] tiles) {
        this.tiles = new int[8][8];
        this.tiles = tiles;
    }

    // All arguments are 1-indexed
    // 0s in the array stand for blank spaces
    public int[][] getTiles() {
        return tiles;
    }

    public void setTiles(int[][] tiles) {
        this.tiles = tiles;
    }

    public int[] getRow(int row) {
        return tiles[row - 1];
    }

    public void setRow(int row, int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            tiles[row - 1][i] = elements[i];
        }
    }

    public int[] getColumn(int column) {
        int[] elements = new int[tiles.length];
        for (int i = 0; i < tiles.length; i++) {
            elements[i] = tiles[i][column - 1];
        }
        return elements;
    }

    public void setColumn(int column, int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            tiles[i][column - 1] = elements[i];
        }
    }

    public int getTile(int row, int column) {
        return tiles[row - 1][column - 1];
    }

    public void display() {

    }
}
