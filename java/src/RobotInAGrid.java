import java.util.*;

/**
 * From Greenbook
 */
public class RobotInAGrid {

    // time O(mn), space O(mn)
    public ArrayList<Point> getPath(boolean[][] maze){
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> blocked = new HashSet<>();
        if(getPath(maze, maze.length - 1, maze[0].length - 1, path, blocked)){
            return path;
        }
        return new ArrayList<>();
    }

    private static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> blocked){
        if(row < 0 || col < 0 || !maze[row][col]){
            return false;
        }

        Point newPoint = new Point(row, col);
        if(blocked.contains(newPoint)){
            return false;
        }

        boolean isStart = (row == 0) && (col == 0);

        if(isStart || getPath(maze, row - 1, col, path, blocked) ||
        getPath(maze, row, col - 1, path, blocked)) {
            path.add(newPoint);
            return true;
        }

        blocked.add(newPoint);
        return false;
    }
}

class Point {
    private int row;
    private int column;

    public Point(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return row == point.row && column == point.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
