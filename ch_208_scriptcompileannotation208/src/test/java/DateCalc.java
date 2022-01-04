import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCalc {
    public static void main(String[] args) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date originDate = sdf.parse("2021-09-12");
            Calendar destinyCal = Calendar.getInstance();
            destinyCal.setTime(originDate);
            int day = destinyCal.get(Calendar.DAY_OF_YEAR);
            day += 100;
            destinyCal.set(Calendar.DAY_OF_YEAR, day);
            Date destinyDate = destinyCal.getTime();
            System.out.println(sdf.format(destinyDate));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
