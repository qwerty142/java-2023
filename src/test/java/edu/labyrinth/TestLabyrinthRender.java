package edu.labyrinth;

import edu.labyrinth.LabyrinthGenerators.GenerateByDFS;
import edu.labyrinth.LabyrinthGenerators.GenerateByPrim;
import edu.labyrinth.LabyrinthRender.RenderLabyrinth;
import edu.labyrinth.LabyrinthRender.Renderer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
public class TestLabyrinthRender {
    private static final Character PASSAGE = '•';
    private static final Character WALL = '☒';
    private static final Character PASS = ' ';
    private static final Cell wall = new Cell(0, 0, Cell.Type.WALL);
    private static final Cell pass = new Cell(0, 0, Cell.Type.PASSAGE);
    private static Arguments[] Labyrinths() {
        return new Arguments[] {
            Arguments.of((Object) new Cell[][] {
                {wall, wall, wall, wall, wall, wall},
                {pass, pass, wall, pass, pass, pass},
                {wall, pass, pass, pass, wall, wall},
                {wall, wall, wall, wall, wall, wall}
            },
                new Character[][] {
                    {WALL, WALL, WALL, WALL, WALL, WALL},
                    {PASSAGE, PASSAGE, WALL, PASSAGE, PASSAGE, PASSAGE},
                    {WALL, PASSAGE, PASSAGE, PASSAGE, WALL, WALL},
                    {WALL, WALL, WALL, WALL, WALL, WALL}
            },
                List.of(
                    new Coordinate(1,0),
                    new Coordinate(1, 1),
                    new Coordinate(2, 1),
                    new Coordinate(2, 2),
                    new Coordinate(2, 3),
                    new Coordinate(1, 3),
                    new Coordinate(1, 4),
                    new Coordinate(1, 5)
                )
            ),
            Arguments.of((Object) new Cell[][] {
                {wall, wall, wall},
                {wall, wall, wall},
                {pass, pass, pass},
                {wall, pass, wall},
                {wall, wall, wall}
            },
                new Character[][] {
                    {WALL, WALL, WALL},
                    {WALL, WALL, WALL},
                    {PASSAGE, PASSAGE, PASSAGE},
                    {WALL, PASS, WALL},
                    {WALL, WALL, WALL}
                },
                List.of(
                    new Coordinate(2, 0),
                    new Coordinate(2, 1),
                    new Coordinate(2, 2)
                ))
        };
    }
    @ParameterizedTest
    @MethodSource("Labyrinths")
    public void renderShouldPrintLabyrinthWithPass(Cell[][] labyrinth, Character[][] output, List<Coordinate> way) {
        // Given
        Renderer renderer = new RenderLabyrinth();
        // When
        Character[][] result = renderer.render(new Maze(labyrinth.length, labyrinth[0].length, labyrinth), way);
        // Then
        assertThat(result).isEqualTo(output);
    }
}
