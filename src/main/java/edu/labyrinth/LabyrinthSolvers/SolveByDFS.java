package edu.labyrinth.LabyrinthSolvers;

import edu.labyrinth.Cell;
import edu.labyrinth.Coordinate;
import edu.labyrinth.Maze;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolveByDFS extends BaseSolver {

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        checkInput(maze, start, end);

        Set<Coordinate> visited = new HashSet<>();
        Deque<Coordinate> way = new ArrayDeque<>();

        way.add(start);

        while (!way.isEmpty()) {
            Coordinate coordinate = way.getLast();

            if (coordinate.equals(end)) {
                break;
            }

            boolean moved = false;
            for (var move : ableMoves) {
                Coordinate current = new Coordinate(coordinate.row() + move.row(), coordinate.col() + move.col());
                if (checkCoordinate(visited, way, current, maze)) {
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                way.pollLast();
                visited.add(coordinate);
            }
        }

        return way.stream().toList();
    }

    private boolean checkCoordinate(Set<Coordinate> visited, Deque<Coordinate> way, Coordinate coordinate, Maze maze) {
        if (!way.contains(coordinate)
            && !visited.contains(coordinate)
            && checkCoordinateOnValid(coordinate, maze.height, maze.width)
            && maze.grid[coordinate.row()][coordinate.col()].type() == Cell.Type.PASSAGE) {
            way.offer(coordinate);
            visited.add(coordinate);
            return true;
        }
        return false;
    }
}
