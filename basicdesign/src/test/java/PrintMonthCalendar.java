import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * @description 打印当前月的日历，头部是星期几，然后每一天对应周几，按照日期顺序进行排列；
 * Mon Tue Wed Thu Fri Sat Sun
 *                          1
 * 2    3   4   5   6   7   8
 * 9    10  11  12  13  14  15
 * 16   17  18  19  20  21  22
 * 23   24  25  26* 27  28  29
 * 30
 *
 * 第一步，打印表头
 * 第二步，打印空格
 * 第三步，打印日期，考虑换行
 * 第四步，在第三步的过滤条件中判断*星号
 *
 */
public class PrintMonthCalendar {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDate monthDay = LocalDate.of(localDate.getYear(), localDate.getMonth(), 1);
        int month = localDate.getMonthValue();
        int today = localDate.getDayOfMonth();
        //  第一步
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        //  第二步
        DayOfWeek dayOfWeek = monthDay.getDayOfWeek();
        int dayOfWeekValue = dayOfWeek.getValue();
        for (int i=1; i < dayOfWeekValue; i++) System.out.print("    ");
        //  第三步
        while (monthDay.getMonthValue() == month) {
            System.out.printf("%3d",monthDay.getDayOfMonth());
            if (monthDay.getDayOfMonth() == today) {
                System.out.print("*");
            }
            else {
                System.out.print(" ");
            }
            monthDay = monthDay.plusDays(1);
            if (monthDay.getDayOfWeek().getValue() == 1) System.out.println();//    周日是每周的第一天啊！
        }
        if (monthDay.getDayOfWeek().getValue() != 1) System.out.println();
    }
}
