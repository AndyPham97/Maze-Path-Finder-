import javafx.geometry.Point2D;
import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    private static final byte  OPEN = 0;
    private static final byte  WALL = 1;
    private static final byte  VISITED = 2;

    private int         rows, columns;
    private byte[][]    grid;

    // A constructor that makes a maze of the given size
    public Maze(int r, int c) {
        rows = r;
        columns = c;
        grid = new byte[r][c];
        for(r=0; r<rows; r++) {
            for (c = 0; c<columns; c++) {
                grid[r][c] = WALL;
            }
        }
    }

    public int getRows() { return rows; }
    public int getColumns() { return columns; }

    // Return true if a wall is at the given location, otherwise false
    public boolean wallAt(int r, int c) {
        return grid[r][c] == WALL;
    }

    // Return true if this location has been visited, otherwise false
    public boolean visitedAt(int r, int c) {
        return grid[r][c] == VISITED;
    }

    // Put a visit marker at the given location
    public void placeVisitAt(int r, int c) {
        grid[r][c] = VISITED;
    }

    // Remove a visit marker from the given location
    public void removeVisitAt(int r, int c) {
        grid[r][c] = OPEN;
    }

    // Put a wall at the given location
    public void placeWallAt(int r, int c) {
        grid[r][c] = WALL;
    }

    // Remove a wall from the given location
    public void removeWallAt(int r, int c) {
        grid[r][c] = 0;
    }

    // Carve out a maze
    public void carve() {
        int startRow = (int)(Math.random()*(rows-2))+1;
        int startCol = (int)(Math.random()*(columns-2))+1;
        carve(startRow, startCol);
    }

    // Directly recursive method to carve out the maze
    public void carve(int r, int c) {
        // Write your code here

        if (((r == rows-1 || c == columns - 1) || (r == 0 || c == 0)) || grid[r][c] == OPEN) {

        }

       else {
            ArrayList<Integer> rowOffsets = new ArrayList<Integer>(Arrays.asList(-1, 1, 0, 0));
            ArrayList<Integer> colOffsets = new ArrayList<Integer>(Arrays.asList(0, 0, -1, 1));

            int rand = (int) (Math.random() * 4);

                if (wallAt(r + 1, c) && wallAt(r - 1, c) && wallAt(r, c - 1)) {
                    ArrayList<Integer> picked = new ArrayList<Integer>();
                    picked.add(rand);
                    grid[r][c] = OPEN;
                    carve(r + rowOffsets.get(rand), c + colOffsets.get(rand));

                    while (picked.contains(rand))
                        rand = (int) (Math.random() * 4);
                    picked.add(rand);
                    carve(r + rowOffsets.get(rand), c + colOffsets.get(rand));
                    while (picked.contains(rand))
                        rand = (int) (Math.random() * 4);
                    picked.add(rand);
                    carve(r + rowOffsets.get(rand), c + colOffsets.get(rand));
                    while (picked.contains(rand))
                        rand = (int) (Math.random() * 4);
                    picked.add(rand);
                    carve(r + rowOffsets.get(rand), c + colOffsets.get(rand));
                }
                if (wallAt(r + 1, c) && wallAt(r, c + 1) && wallAt(r, c - 1)) {
                    ArrayList<Integer> picked = new ArrayList<Integer>();
                    picked.add(rand);
                    grid[r][c] = OPEN;
                    carve(r + rowOffsets.get(rand), c + colOffsets.get(rand));

                    while (picked.contains(rand))
                        rand = (int) (Math.random() * 4);
                    picked.add(rand);
                    carve(r + rowOffsets.get(rand), c + colOffsets.get(rand));
                    while (picked.contains(rand))
                        rand = (int) (Math.random() * 4);
                    picked.add(rand);
                    carve(r + rowOffsets.get(rand), c + colOffsets.get(rand));
                    while (picked.contains(rand))
                        rand = (int) (Math.random() * 4);
                    picked.add(rand);
                    carve(r + rowOffsets.get(rand), c + colOffsets.get(rand));
            }
                 if (wallAt(r - 1, c) && wallAt(r, c + 1) && wallAt(r, c - 1)) {
                     ArrayList<Integer> picked = new ArrayList<Integer>();
                     picked.add(rand);
                    grid[r][c] = OPEN;
                    carve(r + rowOffsets.get(rand), c + colOffsets.get(rand));

                     while (picked.contains(rand))
                         rand = (int) (Math.random() * 4);
                     picked.add(rand);
                     carve(r + rowOffsets.get(rand), c + colOffsets.get(rand));
                     while (picked.contains(rand))
                         rand = (int) (Math.random() * 4);
                     picked.add(rand);
                     carve(r + rowOffsets.get(rand), c + colOffsets.get(rand));
                     while (picked.contains(rand))
                         rand = (int) (Math.random() * 4);
                     picked.add(rand);
                     carve(r + rowOffsets.get(rand), c + colOffsets.get(rand));
            }
                if (wallAt(r + 1, c) && wallAt(r - 1, c) && wallAt(r, c + 1)) {
                    ArrayList<Integer> picked = new ArrayList<Integer>();
                    picked.add(rand);
                    grid[r][c] = OPEN;
                    carve(r + rowOffsets.get(rand), c + colOffsets.get(rand));

                    while (picked.contains(rand))
                        rand = (int) (Math.random() * 4);
                    picked.add(rand);
                    carve(r + rowOffsets.get(rand), c + colOffsets.get(rand));
                    while (picked.contains(rand))
                        rand = (int) (Math.random() * 4);
                    picked.add(rand);
                    carve(r + rowOffsets.get(rand), c + colOffsets.get(rand));
                    while (picked.contains(rand))
                        rand = (int) (Math.random() * 4);
                    picked.add(rand);
                    carve(r + rowOffsets.get(rand), c + colOffsets.get(rand));
                }

        }
    }

    // Determine the longest path in the maze from the given start location
    public ArrayList<Point2D> longestPath() {
        int startRow = (int)(Math.random()*(rows-2))+1;
        int startCol = (int)(Math.random()*(columns-2))+1;
        while (wallAt(startRow, startCol)) {
            startRow = (int)(Math.random()*(rows-2))+1;
            startCol = (int)(Math.random()*(columns-2))+1;
        }
        return longestPathFrom(startRow, startCol);
    }

    // Determine the longest path in the maze from the given start location
    public ArrayList<Point2D> longestPathFrom(int r, int c) {
        ArrayList<Point2D> path = new ArrayList<Point2D>();

        // Write your code here
            if (wallAt(r,c) || visitedAt(r,c))
                return path;
            else {
                placeVisitAt(r,c);

                ArrayList<Point2D> up = longestPathFrom(r-1,c);
                ArrayList<Point2D> down = longestPathFrom(r+1,c);
                ArrayList<Point2D> left = longestPathFrom(r,c-1);
                ArrayList<Point2D> right = longestPathFrom(r,c+1);

                if (up.size() > down.size() && up.size() > left.size() && up.size() > right.size())
                    path = up;
                else if (down.size() > up.size() && down.size() > left.size() && down.size() > right.size())
                    path = down;
                else if (right.size() > down.size() && right.size() > left.size() && right.size() > up.size())
                    path = right;
                else if (left.size() > down.size() && left.size() > up.size() && left.size() > right.size())
                    path = left;

                removeVisitAt(r,c);
                path.add(new Point2D(r,c));
        }
        return path;
    }
}
