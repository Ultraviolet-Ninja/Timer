package timer;

import java.text.DecimalFormat;

public interface TimerInterface {
    DecimalFormat SUB_SECOND_FORMAT = new DecimalFormat("###.0###");
    DecimalFormat SECOND_FORMAT = new DecimalFormat("##.###");
    DecimalFormat MINUTE_FORMAT = new DecimalFormat("###");
    double METRIC_CONVERTER = 1000.0;
    double MINUTE_CONSTANT = 60;

    void start();
    void stop();
    double getDiffNanos();
    double getDiffMicros();
    double getDiffMillis();
    double getDiffSec();

    String getFormattedNanos();
    String getFormattedMicros();
    String getFormattedMillis();
    String getFormattedSec();
    String getFormattedMinute();
}
