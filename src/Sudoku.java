public class Sudoku {
    public static void main(String[] args) {
        int[][] tiles = new int[9][9];
        for (int i = 0; i < 9; i++) {
            int[] column = new int[9];
            for (int j = 0; j < 9; j++) {
                // actually these are rows
                column[j] = j + 1;
            }
            tiles[i] = column;
        }
        Board test = new Board(tiles);
        test.display();
    }
}
