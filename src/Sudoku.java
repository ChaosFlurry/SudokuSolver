public class Sudoku {
    public static void main(String[] args) {
        int[][] tiles = new int[8][8];
        for (int i = 0; i < 8; i++) {
            int[] column = new int[8];
            for (int j = 0; j < 8; j++) {
                // actually these are rows
                column[j] = j;
            }
            tiles[i] = column;
        }
        for (int m = 0; m < 8; m++) {
            for (int n = 0; n < 8; n++) {
                System.out.print(tiles[m][n]);
            }
            System.out.println("");
        }
        System.out.println("");
        Board test = new Board(tiles);
        int[] testRow = test.getRow(2);
        for (int k : testRow) {
            System.out.print(k);
        }
        System.out.println("");
        int[] testColumn = test.getColumn(2);
        for (int k : testRow) {
            System.out.print(k);
        }
        System.out.println("");
        System.out.println(test.getTile(2, 2));
        System.out.println(test.getTile(2, 3));
        System.out.println(test.getTile(3, 2));
    }
}
