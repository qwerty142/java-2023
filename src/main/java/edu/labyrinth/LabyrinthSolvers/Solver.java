package edu.labyrinth.LabyrinthSolvers;

import edu.labyrinth.Coordinate;
import edu.labyrinth.Maze;
import java.util.List;

public interface Solver {
    List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end);
}
