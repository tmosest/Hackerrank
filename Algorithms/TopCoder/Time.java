package TopCoder;
/**
 * TopCoder -> Practice -> SRM 144 Div 1
 * 200
 * @author tmosest
 */
import java.lang.StringBuilder

public class Time
{
    private static final int secondsToHours = 3600;
    private static final int secondsToMinutes = 60;

    public String whatTime(int seconds)
    {
        return String.format("%s:%s:%s", seconds / 60 / 60, (seconds / 60) % 60, seconds % 60);
    }
}