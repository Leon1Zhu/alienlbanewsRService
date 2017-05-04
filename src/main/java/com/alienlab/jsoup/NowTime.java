package com.alienlab.jsoup;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NowTime {
	//("yyyy-MM-dd")
	public static String getNowTime(String format){
        Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);//可以方便地修改日期格式
		String today = dateFormat.format(now); 
		return today;
	}
}
