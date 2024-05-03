package edu.hw2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    static Arguments[] Tests() {
        return new Arguments[] {
            Arguments.of(10, 10),
            Arguments.of(-10, -10),
            Arguments.of(0, 0),
            Arguments.of(15.6, 15.6)
        };
    }
    @ParameterizedTest
    @MethodSource("Tests")
    public void Constant_evaluate_shouldReternSameValueAsGot(double value, double expectedResult){
        var result = new Expr.Constant(value);

        assertThat(result.evaluate()).isEqualTo(expectedResult);
    }

    static Arguments[] TestsForNegate() {
        return new Arguments[] {
            Arguments.of(new Expr.Constant(10), new Expr.Constant(-10)),
            Arguments.of(new Expr.Constant(-10), new Expr.Constant(10)),
            Arguments.of(new Expr.Constant(0), new Expr.Constant(0)),
            Arguments.of(new Expr.Constant(15.6), new Expr.Constant(-15.6))
        };
    }
    @ParameterizedTest
    @MethodSource("TestsForNegate")
    public void Negate_shouldReturnNegationOfGotValue(Expr.Constant value, Expr.Constant expectedResult){
        var result = new Expr.Negate(value);

        assertThat(result.evaluate()).isEqualTo(expectedResult.evaluate());
    }

    static Arguments[] TestsForExponent() {
        return new Arguments[] {
            Arguments.of(new Expr.Constant(10), 2, new Expr.Constant(100)),
            Arguments.of(new Expr.Constant(-10), 1, new Expr.Constant(-10)),
            Arguments.of(new Expr.Constant(0), 10, new Expr.Constant(0)),
            Arguments.of(new Expr.Constant(-10), 2, new Expr.Constant(100))
        };
    }
    @ParameterizedTest
    @MethodSource("TestsForExponent")
    public void Exponent_shouldReturnExponentOfGotValue(Expr.Constant value, double step, Expr.Constant expectedResult){
        var result = new Expr.Exponent(value, step);

        assertThat(result.evaluate()).isEqualTo(expectedResult.evaluate());
    }

    static Arguments[] TestsForMult() {
        return new Arguments[] {
            Arguments.of(new Expr.Constant(10), new Expr.Constant(-10), -100),
            Arguments.of(new Expr.Constant(10), new Expr.Constant(10), 100),
            Arguments.of(new Expr.Constant(0), new Expr.Constant(5), 0),
            Arguments.of(new Expr.Constant(15.6), new Expr.Constant(2), 31.2)
        };
    }
    @ParameterizedTest
    @MethodSource("TestsForMult")
    public void Multiplication_shouldReturnMultiplicationOfGotValue(Expr.Constant left, Expr.Constant right, double expect){
        var result = new Expr.Multiplication(left, right);

        assertThat(result.evaluate()).isEqualTo(expect);
    }

    static Arguments[] TestsForAddition() {
        return new Arguments[] {
            Arguments.of(new Expr.Constant(10), new Expr.Constant(100), 110),
            Arguments.of(new Expr.Constant(-10), new Expr.Constant(10), 0),
            Arguments.of(new Expr.Constant(0), new Expr.Constant(0), 0),
            Arguments.of(new Expr.Constant(-10), new Expr.Constant(100), 90)
        };
    }
    @ParameterizedTest
    @MethodSource("TestsForAddition")
    public void Addition_shouldReturnAdditionOfGotValue(Expr.Constant left, Expr.Constant right, double expect){
        var result = new Expr.Addition(left, right);

        assertThat(result.evaluate()).isEqualTo(expect);
    }

    @Test
    public void MultiTest(){
        var two = new Expr.Constant(2); //2
        var four = new Expr.Constant(4); //4
        var negOne = new Expr.Negate(new Expr.Constant(1)); //-1
        var sumTwoFour = new Expr.Addition(two, four); //6
        var mult = new Expr.Multiplication(sumTwoFour, negOne); //-6
        var exp = new Expr.Exponent(mult, 2); //36
        var res = new Expr.Addition(exp, new Expr.Constant(1)); //37

        assertThat(res.evaluate()).isEqualTo(37);
    }

    static Arguments[] TestsForString() {
        return new Arguments[] {
            Arguments.of(new Expr.Constant(6), "6.0"),
            Arguments.of(new Expr.Exponent(new Expr.Constant(6), 1), "6.0^1.0"),
            Arguments.of(new Expr.Negate(new Expr.Constant(6)), "-6.0"),
            Arguments.of(new Expr.Multiplication(new Expr.Constant(6), new Expr.Constant(6)), "6.0*6.0"),
            Arguments.of(new Expr.Addition(new Expr.Constant(6), new Expr.Constant(6)), "6.0+6.0")
        };
    }
    @ParameterizedTest
    @MethodSource("TestsForString")
    public void TestToString(Expr value, String expectedResult) {
        assertThat(value.toString()).isEqualTo(expectedResult);
    }
}
