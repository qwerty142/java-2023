package edu.labyrinth.LabyrinthRender;

import edu.labyrinth.Coordinate;
import edu.labyrinth.Maze;
import java.util.List;

public interface Renderer {
    Character[][] render(Maze maze);

    Character[][] render(Maze maze, List<Coordinate> path);
}
