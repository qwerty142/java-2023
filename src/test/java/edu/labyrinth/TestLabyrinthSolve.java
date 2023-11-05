package edu.labyrinth;
import edu.labyrinth.LabyrinthSolvers.SolveByBFS;
import edu.labyrinth.LabyrinthSolvers.SolveByDFS;
import edu.labyrinth.LabyrinthSolvers.Solver;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Stream;
import static edu.labyrinth.Cell.Type.PASSAGE;
import static edu.labyrinth.Cell.Type.WALL;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.predicate;

public class TestLabyrinthSolve {
    private static Stream<Arguments> Solvers() {
        return Stream.of(
            Arguments.of(new SolveByDFS()),
            Arguments.of(new SolveByBFS())
        );
    }
    private Cell wall = new Cell(0, 0, WALL);
    private Cell pass = new Cell(0, 0, PASSAGE);
    @ParameterizedTest
    @MethodSource("Solvers")
    public void ShouldFindPass(Solver solver) {
        // Given
        Maze maze = new Maze(3, 6, new Cell[][] {
            {wall, wall, wall, wall, wall, wall},
            {pass, pass, pass, pass, pass, pass},
            {wall, wall,  wall, wall, wall, wall}
        });
        Coordinate start = new Coordinate(1, 0);
        Coordinate end = new Coordinate(1, 5);
        List<Coordinate> expect = List.of(new Coordinate(1, 0),
            new Coordinate(1, 1),
            new Coordinate(1, 2),
            new Coordinate(1, 3),
            new Coordinate(1, 4),
            new Coordinate(1, 5));

        // When
        var result = solver.solve(maze, start, end);

        // Then
        assertThat(result).isEqualTo(expect);
    }
}
