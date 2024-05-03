package edu.labyrinth.LabyrinthGenerators;

import edu.labyrinth.Maze;

public interface Generator {
    Maze generate(int height, int width);
}
