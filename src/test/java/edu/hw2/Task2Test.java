package edu.hw2;

import edu.hw2.Task2.Rectangle;
import edu.hw2.Task2.Square;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {
    static Arguments[] rectangles() {
        return new Arguments[]{
            Arguments.of(new Rectangle()),
            Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    public void IfTestForRectangleShouldCreateRectangle(Rectangle rectangle){
        rectangle = Rectangle.constructor.setWidth(10).setHeight(20).construct();

        assertThat(rectangle.area()).isEqualTo(200);
    }

    @Test
    public void SquareAreaTest(){
        Square square = new Square();
        square = Square.constructor.setSide(10).construct();

        assertThat(square.area()).isEqualTo(100);
    }

    @Test
    public void RectangleAreaTest(){
        Rectangle rectangle = new Rectangle();
        rectangle = Rectangle.constructor.setHeight(10).setWidth(30).construct();

        assertThat(rectangle.area()).isEqualTo(300);
    }

    @Test
    public void ExceptionTest(){

        assertThrows(IllegalArgumentException.class, () -> new Square(-10));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-10, 10));
    }
}
