package com.techacademy;

import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

	//http://localhost:8080/dayofweek/指定日
	@GetMapping("/dayofweek/{yyyymmdd}")
    public String dayofweek(@PathVariable String yyyymmdd) {
		String date = yyyymmdd;
		String year = date.substring(0,4);
	    String month = date.substring(4,6);
	    String day = date.substring(6,8);


	    // 年、月、日を整数型に変換
        int intYear = Integer.parseInt(year);
        int intMonth = Integer.parseInt(month) - 1;  // 月は0から始まるため、1月は0として設定
        int intDay = Integer.parseInt(day);

        // Calendarインスタンスを使用して曜日を計算
        Calendar calendar = Calendar.getInstance();
        calendar.set(intYear, intMonth, intDay);

        // 曜日を取得
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // 曜日を文字列で取得
        String dayOfWeekString = "";
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                dayOfWeekString = "Sunday";
                break;
            case Calendar.MONDAY:
                dayOfWeekString = "Monday";
                break;
            case Calendar.TUESDAY:
                dayOfWeekString = "Tuesday";
                break;
            case Calendar.WEDNESDAY:
                dayOfWeekString = "Wednesday";
                break;
            case Calendar.THURSDAY:
                dayOfWeekString = "Thursday";
                break;
            case Calendar.FRIDAY:
                dayOfWeekString = "Friday";
                break;
            case Calendar.SATURDAY:
                dayOfWeekString = "Saturday";
                break;
        }

        // 結果を返す

		return "Tuesday";
	}


	@GetMapping("/plus/{val1}/{val2}")
	public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
		int res = 0;
		res = val1 + val2;
		return "計算結果:" + res;
	}

	 @GetMapping("/minus/{val1}/{val2}")
     public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
	    int res = 0;
        res = val1 - val2;
		return "計算結果：" + res;
	}

	  @GetMapping("/times/{val1}/{val2}")
	    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
	        int res = 0;
	        res = val1 * val2;
	        return "計算結果：" + res;
	  }

	  @GetMapping("/divide/{val1}/{val2}")
	    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
	        int res = 0;
	        res = val1 / val2;
	        return "計算結果：" + res;
	  }


}
