package timer;

public class StaticTimer {
    private static double startTime, stopTime;

    /** No initialization needed*/
    private StaticTimer(){}

    public static void start(){
        startTime = System.nanoTime();
    }

    public static void stop() {
        stopTime = System.nanoTime();
    }

    public static double getDiffNanos() throws IllegalArgumentException {
        if (conditions()) return stopTime - startTime;
        throw new IllegalArgumentException("Timer hasn't started or stopped");
    }

    public static double getDiffMicros() throws IllegalArgumentException {
        return getDiffNanos() / TimerInterface.METRIC_CONVERTER;
    }

    public static double getDiffMillis() throws IllegalArgumentException {
        return getDiffMicros() / TimerInterface.METRIC_CONVERTER;
    }

    public static double getDiffSec() throws IllegalArgumentException {
        return getDiffMillis() / TimerInterface.METRIC_CONVERTER;
    }

    private static boolean conditions() {
        return startTime != 0 && stopTime != 0 && startTime < stopTime;
    }
}