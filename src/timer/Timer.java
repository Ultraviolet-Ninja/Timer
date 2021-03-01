package timer;

public class Timer implements TimerInterface{
    private double startTime, stopTime;

    public Timer() {
        startTime = 0;
        stopTime = 0;
    }

    @Override
    public void start() {
        startTime = System.nanoTime();
    }

    @Override
    public void stop() {
        stopTime = System.nanoTime();
    }

    @Override
    public double getDiffNanos() throws IllegalArgumentException {
        if (conditions()) return stopTime - startTime;
        throw new IllegalArgumentException("Timer hasn't started or stopped");
    }

    @Override
    public double getDiffMicros() throws IllegalArgumentException {
        return getDiffNanos() / METRIC_CONVERTER;
    }

    @Override
    public double getDiffMillis() throws IllegalArgumentException {
        return getDiffMicros() / METRIC_CONVERTER;
    }

    @Override
    public double getDiffSec() throws IllegalArgumentException {
        return getDiffMillis() / METRIC_CONVERTER;
    }

    @Override
    public String getFormattedNanos() throws IllegalArgumentException {
        return null;
    }

    @Override
    public String getFormattedMicros() throws IllegalArgumentException {
        return SUB_SECOND_FORMAT.format(getDiffMicros()) + " microseconds";
    }

    @Override
    public String getFormattedMillis() throws IllegalArgumentException {
        return SUB_SECOND_FORMAT.format(getDiffMillis()) + " milliseconds";
    }

    @Override
    public String getFormattedSec() throws IllegalArgumentException {
        return SECOND_FORMAT.format(getDiffSec()) + " seconds";
    }

    @Override
    public String getFormattedMinute() throws IllegalArgumentException {
        double total = getDiffSec();
        double minutes = total / MINUTE_CONSTANT;
        double seconds = total % MINUTE_CONSTANT;
        return MINUTE_FORMAT.format(minutes) + ":" + SECOND_FORMAT.format(seconds);
    }

    private boolean conditions() {
        return startTime != 0 && stopTime != 0 && startTime < stopTime;
    }
}
