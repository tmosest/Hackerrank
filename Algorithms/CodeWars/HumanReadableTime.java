package CodeWars;
/**
 * Human Readable Time
 * @author tmosest
 */
public class HumanReadableTime {
	private static final int secsInHour = 3600;
	private static final int secsInMin = 60;
	
	public static String makeReadable(int seconds) {
	    int hours = seconds / secsInHour;
	    seconds %= secsInHour;
	    int minutes = seconds / secsInMin;
	    seconds %= secsInMin;
	    
	    StringBuilder sb = new StringBuilder();
	    if(hours < 10) {
	    	sb.append('0');
	    }
	    sb.append(String.valueOf(hours));
	    sb.append(':');
	    if(minutes < 10) {
	    	sb.append('0');
	    }
	    sb.append(String.valueOf(minutes));
	    sb.append(':');
	    if(seconds < 10) {
	    	sb.append('0');
	    }
	    sb.append(String.valueOf(seconds));
		return sb.toString();
	}
}