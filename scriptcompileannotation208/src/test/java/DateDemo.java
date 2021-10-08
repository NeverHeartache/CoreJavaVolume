import org.springframework.format.datetime.DateFormatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

public class DateDemo {

    /**
     * 比较两个日期的大小，
     * 如果sourceDate > targetDate,则返回正数，
     * 如果sourceDate < targetDate，则返回负数，
     * 相等，则返回0；
     * @param sourceDate 日期
     * @param targetDate 日期
     * @return 整数
     */
    public static int compareDate(Date sourceDate, Date targetDate){
        Calendar sourceCal = Calendar.getInstance();
        sourceCal.setTime(sourceDate);
        int sourceYear = sourceCal.get(Calendar.YEAR);
        int sourceDay = sourceCal.get(Calendar.DAY_OF_YEAR);

        Calendar targetCal = Calendar.getInstance();
        targetCal.setTime(targetDate);
        int targetYear = targetCal.get(Calendar.YEAR);
        int targetDay = targetCal.get(Calendar.DAY_OF_YEAR);

        return (sourceYear - targetYear) * 365 + (sourceDay - targetDay);
    }

    public static void main(String[] args) {
        Date today = new Date();
        try {
            Date expireDate1 = new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01");//过期日期
            Date expireDate2 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-10-01");//过期日期

            Date forwardDays1 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-10-01");//购票日期晚于今天
            Date forwardDays2 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-10-20");//购票日期早于今天

            System.out.println(expireDate1.toString());
            System.out.println(expireDate2.toString());

            System.out.println("购票日期晚于今天:"+compareDate(today, forwardDays1));//购票日期晚于今天
            System.out.println("购票日期早于今天"+compareDate(today, forwardDays2));//购票日期早于今天

            System.out.println("过期日期晚于今天"+compareDate(expireDate1, today));//过期日期
            System.out.println("过期日期早于今天"+compareDate(expireDate2, today));//过期日期
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
