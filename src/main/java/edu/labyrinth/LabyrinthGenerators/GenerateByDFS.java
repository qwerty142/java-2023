package edu.labyrinth.LabyrinthGenerators;

import edu.labyrinth.Cell;
import edu.labyrinth.Coordinate;
import edu.labyrinth.Maze;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("checkstyle:LineLength") public class GenerateByDFS extends BaseGeneratorFuncs {

    @Override
    public Maze generate(int height, int width) {
        checkSize(height, width);
        Cell[][] maze = new Cell[height][width];
        createEmptyMaze(maze);
        Set<Coordinate> visited = new HashSet<Coordinate>();
        Deque<Coordinate> toVisit = new ArrayDeque<Coordinate>();
        Cell cell = getRandomStart(height, width);
        maze[cell.row()][cell.col()] = cell;
        Coordinate currCoordinate = new Coordinate(cell.row(), cell.col());
        toVisit.add(currCoordinate);
        visited.add(currCoordinate);
        List<Coordinate> ableMove = new ArrayList<>(ableMoves);

        while (!toVisit.isEmpty()) {
            Coordinate current = toVisit.getLast();
            boolean change = false;
            Collections.shuffle(ableMove);

            for (var elem : ableMove) {
                Coordinate filed = new Coordinate(
                    current.row() + elem.row(),
                    current.col() + elem.col());
                if (checkInBoards(filed, height, width)
                    && tryVisit(maze, visited, toVisit, filed, ableMove)) {
                    change = true;
                    break;
                }
            }

            if (!change) {
                toVisit.pollLast();
            }
        }

        Cell end = getRandomEnd(maze, height, width);
        maze[end.row()][end.col()] = end;

        return new Maze(height, width, maze);
    }

    private boolean tryVisit(Cell[][] maze, Set<Coordinate> visited, Deque<Coordinate> toVisit, Coordinate coordinate, List<Coordinate> ableMove) {
        int amountOfVisitedFields = 0;

        for (var elem : ableMove) {
            Coordinate filed = new Coordinate(
                coordinate.row() + elem.row(),
                coordinate.col() + elem.col());
            if (visited.contains(filed)) {
                amountOfVisitedFields++;
            }
        }

        if (!visited.contains(coordinate) && amountOfVisitedFields < 2) {
            maze[coordinate.row()][coordinate.col()] = new Cell(coordinate.row(), coordinate.col(), Cell.Type.PASSAGE);
            visited.add(coordinate);
            toVisit.offer(coordinate);
            return true;
        }
        return false;
    }
}
