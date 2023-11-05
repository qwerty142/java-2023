package edu.labyrinth.LabyrinthGenerators;

import edu.labyrinth.Cell;
import edu.labyrinth.Coordinate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static edu.labyrinth.Cell.Type.PASSAGE;

public abstract class BaseGeneratorFuncs implements Generator {
    public static final int MINIMUM_SIZE  = 4;

    public  List<Coordinate> ableMoves = List.of(
        new Coordinate(0, 1),
        new Coordinate(1, 0),
        new Coordinate(-1, 0),
        new Coordinate(0, -1)
    );

    public void checkSize(int height, int width) {
        if (height < MINIMUM_SIZE || width < MINIMUM_SIZE) {
            throw new IllegalArgumentException("Params for field should be bigger than 3");
        }
    }

    public void createEmptyMaze(Cell[][] maze) {

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j] = new Cell(i, j, Cell.Type.WALL);
            }
        }
    }

    public boolean checkInBoards(Coordinate coordinate, int height, int width) {
        return coordinate.row() >= 1
            && coordinate.row() < height - 1
            && coordinate.col() >= 1
            && coordinate.col() < height - 1;
    }

    public Cell getRandomStart(int height, int width) {
        Random random = new Random();
        return new Cell(random.nextInt(1, height - 1), 0, PASSAGE);
    }

    public Cell getRandomEnd(Cell[][] maze, int height, int width) {
        Random random = new Random();
        List<Integer> variations = new ArrayList<>();

        for (int i = 1; i < height - 1; i++) {
            if (maze[i][width - 2].type() == PASSAGE) {
                variations.add(i);
            }
        }
        return new Cell(variations.get(random.nextInt(0, variations.size())), width - 1, PASSAGE);
    }
}
