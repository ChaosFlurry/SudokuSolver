import java.util.ArrayList;
import java.util.stream.IntStream;

public class Board {
    private int[][] tiles;

    public Board(int[][] tiles) {
        this.tiles = new int[9][9];
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
        for (int i = 0; i < 9; i++) {
            tiles[row - 1][i] = elements[i];
        }
    }

    public int[] getColumn(int column) {
        int[] elements = new int[9];
        for (int i = 0; i < 9; i++) {
            elements[i] = tiles[i][column - 1];
        }
        return elements;
    }

    public void setColumn(int column, int[] elements) {
        for (int i = 0; i < 9; i++) {
            tiles[i][column - 1] = elements[i];
        }
    }

    public int getTile(int row, int column) {
        return tiles[row - 1][column - 1];
    }

    public void setTile(int row, int column, int value) {
        tiles[row - 1][column - 1] = value;
    }

    public int[] getRegion(int region) {
        int[] elements = new int[9];
        int x = 0;
        int y = 0;
        if (region == 1) {
            x = 1;
            y = 1;
        } else if (region == 2) {
            x = 1;
            y = 4;
        } else if (region == 3) {
            x = 1;
            y = 7;
        } else if (region == 4) {
            x = 4;
            y = 1;
        } else if (region == 5) {
            x = 4;
            y = 4;
        } else if (region == 6) {
            x = 4;
            y = 7;
        } else if (region == 7) {
            x = 7;
            y = 1;
        } else if (region == 8) {
            x = 7;
            y = 4;
        } else if (region == 9) {
            x = 7;
            y = 7;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                elements[3 * i + j] = this.getTile(x + i, y + j);
            }
        }
        return elements;
    }

    public void setRegion(int region, int[] elements) {
        int x = 0;
        int y = 0;
        if (region == 1) {
            x = 1;
            y = 1;
        } else if (region == 2) {
            x = 1;
            y = 4;
        } else if (region == 3) {
            x = 1;
            y = 7;
        } else if (region == 4) {
            x = 4;
            y = 1;
        } else if (region == 5) {
            x = 4;
            y = 4;
        } else if (region == 6) {
            x = 4;
            y = 7;
        } else if (region == 7) {
            x = 7;
            y = 1;
        } else if (region == 8) {
            x = 7;
            y = 4;
        } else if (region == 9) {
            x = 7;
            y = 7;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.setTile(x + i, y + j, elements[3 * i + j]);
            }
        }
    }

    public void display() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 0 || j == 3 || j == 6) {
                    System.out.print("|\t");
                }
                int value = this.getTile(i + 1, j + 1);
                if (value == 0) {
                    System.out.print(" \t");
                } else {
                    System.out.print(value + "\t");
                }
            }
            System.out.print("|");
            System.out.print("\n");
            if (i == 2 || i == 5) {
                System.out.println("-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-");
            }
        }
    }

    public boolean isValidRow(int row) {
        int[] elements = this.getRow(row);
        return IntStream.of(elements).filter(i -> i > 0).count() == IntStream.of(elements).filter(i -> i > 0).distinct().count();
    }

    public boolean isValidColumn(int column) {
        int[] elements = this.getColumn(column);
        return IntStream.of(elements).filter(i -> i > 0).count() == IntStream.of(elements).filter(i -> i > 0).distinct().count();
    }

    public boolean isValidRegion(int region) {
        int[] elements = this.getRegion(region);
        return IntStream.of(elements).filter(i -> i > 0).count() == IntStream.of(elements).filter(i -> i > 0).distinct().count();
    }

    public boolean isValidBoard() {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(i + 1)) {
                return false;
            }
            if (!isValidColumn(i + 1)) {
                return false;
            }
            if (!isValidRegion(i + 1)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isFilledRow(int row) {
        int[] elements = this.getRow(row);
        return IntStream.of(elements).filter(x -> x > 0).count() == 0;
    }
    
    public boolean isFilledColumn(int column) {
        int[] elements = this.getColumn(column);
        return IntStream.of(elements).filter(x -> x > 0).count() == 0;
    }
    
    public boolean isFilledRegion(int region) {
        int[] elements = this.getRegion(region);
        return IntStream.of(elements).filter(x -> x > 0).count() == 0;
    }
    
    public boolean isFilledBoard() {
        for (int i = 0; i < 9; i++) {
            if (!isFilledRow(i)) {
                return false;
            }
            if (!isFilledColumn(i)) {
                return false;
            }
            if (!isFilledRegion(i)) {
                return false;
            }
        }
        return true;
    }
    
    public Board solve() {
        Board copy = new Board(this.getTiles());
        ArrayList<int[]> emptyTiles = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int tile = copy.getTile(i + 1, j + 1);
                if (tile == 0) {
                    emptyTiles.add(new int[]{i + 1, j + 1});
                }
            }
        }
        
        for (int i = 0; i < emptyTiles.size(); i++) {
            int r = emptyTiles.get(i)[0];
            int c = emptyTiles.get(i)[1];
            int value = copy.getTile(r, c);
            
            if (value == 9) {
                copy.setTile(r, c, 0);
                i -= 2;
                continue;
            }
            
            for (int j = value; j < 10; j++) {
                if (copy.isValidBoard()) {
                    break;
                }
                
                if (j == 9) {
                    // go to previous empty tile
                    // increment by 1
                    // if value is 9
                        // set to 0
                        // decrement i
                        // increment i by 1
                    
                    i -= 2;
                    break;
                }
            }
        }
        
        
        for (int i = 0; i < emptyTiles.size(); i++) {
            int value = copy.getTile(emptyTiles.get(i)[0], emptyTiles.get(i)[1]);
            if (value > 0) {
                value--;
            }
            for (int j = value; j < 9; j++) {
                if (value != 0) {
                    copy.setTile(emptyTiles.get(i)[0], emptyTiles.get(i)[1], j);
                    continue;
                } else {
                    copy.setTile(emptyTiles.get(i)[0], emptyTiles.get(i)[1], j + 1);
                }
                this.display();
                System.out.println("");
                System.out.println("Valid:" + copy.isValidBoard());
                if (copy.isValidBoard()) {
                    break;
                }
                if (j + 1 == 9) {
                    copy.setTile(emptyTiles.get(i)[0], emptyTiles.get(i)[1], 0);
                    System.out.println("waiting");
                    i -= 2;
                }
            }
            //this.display();
            //System.out.println("");
        }
        return copy;
    }
}
