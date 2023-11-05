package edu.labyrinth.LabyrinthSolvers;

import edu.labyrinth.Coordinate;
import edu.labyrinth.Maze;
import java.util.List;

public abstract class BaseSolver implements Solver {
    public List<Coordinate> ableMoves = List.of(
        new Coordinate(0, 1),
        new Coordinate(1, 0),
        new Coordinate(-1, 0),
        new Coordinate(0, -1)
    );

    public void checkInput(Maze maze, Coordinate start, Coordinate end) {
        if (start.col() != 0 || start.row() == 0 || start.row() == maze.grid.length - 1) {
            throw new IllegalArgumentException();
        }
        if (end.col() != maze.grid[0].length - 1 || end.row() == 0 || end.row() == maze.grid.length - 1) {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkCoordinateOnValid(Coordinate coordinate, int height, int width) {
        if (coordinate.row() >= 0
            && coordinate.row() <= height - 1
            && coordinate.col() >= 0
            && coordinate.col() <= width - 1) {
            return true;
        }
        return false;
    }
}
