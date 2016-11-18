import java.util.Scanner;

/**
 * John Horton Conway , game of life with 10 dimension
 */
public class Life {
    public static void show(boolean[][] grid) {
        String screenString = "";
        for (boolean[] row : grid) {
            for (boolean val : row) {
                if (val) {
                    screenString += "*";
                } else {
                    screenString += ".";
                }
            }
            screenString += "\n";
        }
        System.out.println(screenString);
    }

    public static boolean[][] generateInitialWorld() {
        boolean[][] grid = new boolean[10][10];
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                if (Math.random() > 0.7) {
                    grid[row][column] = true;
                }
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        boolean[][] world = generateInitialWorld();
        show(world);
        System.out.println();
        world = runNextGeneration(world);
        show(world);
        Scanner s = new Scanner(System.in);
        while (s.nextLine().length() == 0) {
            System.out.println();
            world = runNextGeneration(world);
            show(world);

        }
    }

    public static boolean[][] runNextGeneration(boolean[][] oldWorld) {
        boolean[][] newWorld
                = new boolean[oldWorld.length][oldWorld[0].length];
        int num;
        for (int row = 0; row < oldWorld.length; row++) {
            for (int column = 0; column < oldWorld[0].length; column++) {
                num = getNumberOfAliveNeighbors(oldWorld, row, column);
                if (shouldLiveOrNot(num, oldWorld[row][column])) {
                    newWorld[row][column] = true;
                }
            }
        }
        return newWorld;
    }

    public static boolean shouldLiveOrNot(int numberOfAliveNeighbors, boolean liveOrDead) {
        if (liveOrDead && (numberOfAliveNeighbors == 2 || numberOfAliveNeighbors == 3)) {
            return true;
        } else {
            if (!liveOrDead && numberOfAliveNeighbors == 3) {
                return true;
            } else {
                return false;
            }
        }
    }

    private static int getNumberOfAliveNeighbors(boolean[][] world, int row, int col) {
        int numberOfAliveNeighbors = world[row][col] ? -1 : 0;// this is for make cell exception for calculation live neighbors
        for (int r = row - 1; r <= row + 1; r++){
            for (int c = col - 1; c <= col + 1; c++){
                if (isValidIndex(world, r, c) && world[r][c])
                    numberOfAliveNeighbors++;
            }
        }

        return numberOfAliveNeighbors;
    }

    private static boolean isValidIndex(boolean[][] world, int row, int column) {
        return row >= 0 && row < world.length && column >= 0 &&
                column < world[0].length;
    }


}