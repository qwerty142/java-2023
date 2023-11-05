package edu.labyrinth;

import edu.labyrinth.LabyrinthGenerators.GenerateByDFS;
import edu.labyrinth.LabyrinthGenerators.GenerateByPrim;
import edu.labyrinth.LabyrinthGenerators.Generator;
import edu.labyrinth.LabyrinthSolvers.SolveByBFS;
import edu.labyrinth.LabyrinthSolvers.SolveByDFS;
import org.junit.jupiter.api.Test;
import static edu.labyrinth.Cell.Type.WALL;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class TestLabyrinthGenerator {
    private static Stream<Arguments> Generators() {
        return Stream.of(
            Arguments.of(new GenerateByDFS()),
            Arguments.of(new GenerateByPrim())
        );
    }
    @ParameterizedTest
    @MethodSource("Generators")
    public void TestGeneratorDFS(Generator generator) {
        Maze maze = generator.generate(5, 5);

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                assertThat(maze.grid[i][j].row()).isEqualTo(i);
                assertThat(maze.grid[i][j].col()).isEqualTo(j);

                if(i == 0 || i == 4) {
                    assertThat(maze.grid[i][j].type()).isEqualTo(WALL);
                }
            }
        }

    }
}
