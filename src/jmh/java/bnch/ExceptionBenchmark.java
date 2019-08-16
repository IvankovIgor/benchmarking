package bnch;

import main.ExceptionTest;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.All)
@OutputTimeUnit(value = TimeUnit.NANOSECONDS)
@Warmup(iterations = 1, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 2, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Fork(value = 1)
public class ExceptionBenchmark {

    @Setup(Level.Iteration)
    public void setup() {}

    @Benchmark
    public void newException() {
        ExceptionTest exceptionTest = new ExceptionTest();
        exceptionTest.throwNewException();
    }

    @Benchmark
    public void privateException() {
        ExceptionTest exceptionTest = new ExceptionTest();
        exceptionTest.throwPrivateException();
    }
}

