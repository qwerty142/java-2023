package edu.labyrinth.LabyrinthGenerators;

import edu.labyrinth.Cell;
import edu.labyrinth.Coordinate;
import edu.labyrinth.Maze;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GenerateByPrim extends BaseGeneratorFuncs {
    @Override
    public Maze generate(int height, int width) {
        checkSize(height, width);
        Cell[][] maze = new Cell[height][width];
        createEmptyMaze(maze);
        LinkedList<Coordinate> walls = new LinkedList<>();
        Cell start = getRandomStart(height, width);
        Coordinate startCoordinate = new Coordinate(start.row(), start.col());
        List<Coordinate> ableMove = new ArrayList<>(ableMoves);

        tryVisit(maze, startCoordinate, walls, ableMove);
        while (!walls.isEmpty()) {
            Collections.shuffle(ableMove);
            Coordinate current = walls.poll();

            if (checkInBoards(current, height, width)) {
                tryVisit(maze, current, walls, ableMove);
            }
        }

        Cell end = getRandomEnd(maze, height, width);
        maze[end.row()][end.col()] = end;

        return new Maze(height, width, maze);
    }

    @SuppressWarnings({"checkstyle:ReturnCount", "checkstyle:LineLength"})
    private void tryVisit(Cell[][] maze, Coordinate coordinate, LinkedList<Coordinate> walls, List<Coordinate> ableMove) {

        if (maze[coordinate.row()][coordinate.col()].type() == Cell.Type.PASSAGE) {
            return;
        }
        List<Coordinate> toAdd = new ArrayList<>();
        int amountOfWalls = 0;
        for (var elem : ableMove) {
            Coordinate current = new Coordinate(coordinate.row() + elem.row(), coordinate.col() + elem.col());
            if (checkInBoards(current, maze.length, maze[0].length)) {
                if (maze[current.row()][current.col()].type() == Cell.Type.WALL) {
                    toAdd.add(current);
                    amountOfWalls++;
                }
            } else {
                amountOfWalls++;
            }
        }

        if (amountOfWalls < MINIMUM_SIZE - 1) {
            return;
        }

        maze[coordinate.row()][coordinate.col()] = new Cell(coordinate.row(), coordinate.col(), Cell.Type.PASSAGE);
        walls.addAll(toAdd);

    }
}
