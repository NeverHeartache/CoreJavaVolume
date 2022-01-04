import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 练习LocalDate的使用方法
 */
public class LocalDateTest {
    private LocalDate localDate;

    public LocalDateTest(int year, int month, int day) {
        localDate = LocalDate.of(year, month, day);
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTest localDateTest = new LocalDateTest(2021, 9, 12);
        LocalDate today = localDateTest.getLocalDate();
        LocalDate aThousandDaysLater = today.plusDays(100);
        System.out.println(today.format(formatter));
        System.out.println(aThousandDaysLater.format(formatter));
    }
}
