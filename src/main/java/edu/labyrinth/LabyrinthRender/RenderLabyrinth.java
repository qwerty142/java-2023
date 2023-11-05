package edu.labyrinth.LabyrinthRender;

import edu.labyrinth.Cell;
import edu.labyrinth.Coordinate;
import edu.labyrinth.Maze;
import java.util.List;

public class RenderLabyrinth implements Renderer {
    private static final Character PASSAGE = '•';
    private static final Character WALL = '☒';
    private static final Character PASS = ' ';

    @Override
    public Character[][] render(Maze maze) {
        return render(maze, List.of());
    }

    @Override
    public Character[][] render(Maze maze, List<Coordinate> path) {
        Character[][] labyrinth = new Character[maze.height][maze.width];

        for (int i = 0; i < maze.height; i++) {
            for (int j = 0; j < maze.width; j++) {
                if (maze.grid[i][j].type() == Cell.Type.PASSAGE) {
                    labyrinth[i][j] = PASS;
                } else {
                    labyrinth[i][j] = WALL;
                }
            }
        }

        for (var elem : path) {
            labyrinth[elem.row()][elem.col()] = PASSAGE;
        }

        return labyrinth;
    }
}
