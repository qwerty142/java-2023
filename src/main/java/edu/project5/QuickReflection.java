package edu.project5;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaConversionException;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

/*
Benchmark                          Mode  Cnt   Score   Error  Units
QuickReflection.directAccess       avgt       11,130          ns/op
QuickReflection.lambdaMetafactory  avgt       13,344          ns/op
QuickReflection.method             avgt       15,531          ns/op
QuickReflection.methodHandles      avgt       14,110          ns/op
 */
@SuppressWarnings({"checkstyle:HideUtilityClassConstructor", "checkstyle:InnerTypeLast"})
@State(Scope.Thread)
public class QuickReflection {

    @SuppressWarnings({"checkstyle:UncommentedMain", "checkstyle:MagicNumber"})
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
            .include(QuickReflection.class.getSimpleName())
            .shouldFailOnError(true)
            .shouldDoGC(true)
            .mode(Mode.AverageTime)
            .timeUnit(TimeUnit.NANOSECONDS)
            .forks(1)
            .warmupForks(1)
            .warmupIterations(1)
            .warmupTime(TimeValue.seconds(5))
            .measurementIterations(1)
            .measurementTime(TimeValue.seconds(5))
            .build();

        new Runner(options).run();
    }

    record Student(String name, String surname) {
        public String getStudent() {
            return name + " " + surname;
        }
    }

    private Student student;
    private Method method;
    private MethodHandle methodHandle;
    private CallSite callSite;

    @SuppressWarnings({"checkstyle:MultipleStringLiterals", "checkstyle:InnerTypeLast"})
    @Setup
    public void setup() throws NoSuchMethodException, IllegalAccessException, LambdaConversionException {
        student = new Student("Alexander", "Biryukov");
        method = Student.class.getMethod("getStudent");

        MethodHandles.Lookup lookup = MethodHandles.lookup();
        methodHandle = lookup.findVirtual(Student.class, "getStudent", MethodType.methodType(String.class));
        callSite = LambdaMetafactory.metafactory(
            lookup,
            "apply",
            MethodType.methodType(Function.class),
            MethodType.methodType(Object.class, Object.class),
            methodHandle,
            methodHandle.type()
        );
    }

    @Benchmark
    public void directAccess(Blackhole blackhole) {
        blackhole.consume(student.getStudent());
    }

    @Benchmark
    public void method(Blackhole blackhole) throws InvocationTargetException, IllegalAccessException {
        blackhole.consume(method.invoke(student));
    }

    @Benchmark
    public void methodHandles(Blackhole blackhole) throws Throwable {
        blackhole.consume(methodHandle.invoke(student));
    }

    @Benchmark
    public void lambdaMetafactory(Blackhole blackhole) throws Throwable {
        Function<Student, String> function = (Function<Student, String>) callSite.getTarget().invokeExact();
        String name = function.apply(student);
        blackhole.consume(name);
    }
}
