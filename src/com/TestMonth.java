package com;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestMonth {
public static void main(String[] args) {
	Date date = new Date();
	DateFormat monthdf = new SimpleDateFormat("MMMM");
	DateFormat yeardf = new SimpleDateFormat("YYYY");
	Calendar c = Calendar.getInstance();
    c.add(Calendar.MONTH, 1);  //adding a month directly - gives the start of next month.
    String firstDate = monthdf.format(c.getTime());
    System.out.println(firstDate);
    System.out.println(yeardf.format(c.getTime()));
}
}
