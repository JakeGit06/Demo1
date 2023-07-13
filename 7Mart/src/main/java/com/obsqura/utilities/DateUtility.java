package com.obsqura.utilities;

import java.util.*;
import java.text.*;
import java.time.LocalDateTime;

public class DateUtility {

	Date d1;

	public String currentDate() {
		d1 = new Date();
		return (d1.toString());
	}

	public String SingleFormatDate() {
		d1 = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		return (ft.format(d1));
	}

	public String currentTimeDate() {
		LocalDateTime myObj = LocalDateTime.now();
		String localtimedate = myObj.toString();
		return (localtimedate);
	}

}
