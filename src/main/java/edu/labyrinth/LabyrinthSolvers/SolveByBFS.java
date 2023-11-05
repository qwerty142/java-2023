package edu.labyrinth.LabyrinthSolvers;

import edu.labyrinth.Cell;
import edu.labyrinth.Coordinate;
import edu.labyrinth.Maze;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolveByBFS extends BaseSolver {
    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        checkInput(maze, start, end);

        Deque<Coordinate> way = new ArrayDeque<>();
        Map<Coordinate, List<Coordinate>> ways = new HashMap<>();
        way.push(start);
        ways.put(start, List.of(start));

        while (!way.isEmpty()) {
            Coordinate current = way.pollFirst();
            if (current.equals(end)) {
                break;
            }

            for (var elem : ableMoves) {
                Coordinate ableMove = new Coordinate(current.row() + elem.row(), current.col() + elem.col());
                if (checkCoordinateOnValid(ableMove, maze.height, maze.width)
                    && maze.grid[ableMove.row()][ableMove.col()].type() == Cell.Type.PASSAGE) {
                    checkCoordinate(ways, way, current, ableMove, maze);
                }
            }
        }
        return ways.get(end);
    }

    private void checkCoordinate(Map<Coordinate, List<Coordinate>> ways,
        Deque<Coordinate> way,
        Coordinate current,
        Coordinate ableCoordinate,
        Maze maze) {
        if (!ways.containsKey(ableCoordinate)) {
            List<Coordinate> currentWay = new ArrayList<>(ways.get(current));
            currentWay.add(ableCoordinate);
            ways.put(ableCoordinate, currentWay);
            way.offer(ableCoordinate);
        }
    }
}
