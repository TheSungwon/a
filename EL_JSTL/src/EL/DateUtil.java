package EL;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat fm = new SimpleDateFormat("yy-MM-dd-hh-mm-ss");
	
	public static String format(Date date) {
		return fm.format(date);
	}

}
