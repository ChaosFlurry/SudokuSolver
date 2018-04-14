import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sudoku {
    /*
    Test Board:
    530070000
    600195000
    098000060
    800060003
    400803001
    700020006
    060000280
    000419005
    000080079
    
    Solution:
    534678912
    672195348
    198342567
    859761423
    426853791
    713924856
    961537284
    287419635
    345286179
     */
    
    public static void main(String[] args) {
        int[][] tiles = new int[9][9];
        for (int i = 0; i < 9; i++) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.print("R" + (i + 1) + ": ");
                String input = br.readLine();
                String[] parsed = input.split("");
                int[] values = new int[9];
                for (int j = 0; j < 9; j++) {
                    values[j] = Integer.parseInt(parsed[j]);
                }
                tiles[i] = values;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Board test = new Board(tiles);
        test.display();
        test.solve();
    }
}