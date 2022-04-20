import java.util.Random;

public class LuckyRate {
    private static int count = 1;
    public static void main(String[] args) {
        while (true) {
            count++;
            System.out.print("已执行 " +count+ "次：\t");
            long resLong = (long)(Math.random() * 1000);
            if (0 <= resLong && resLong <= 300) {
                System.out.println("谢谢参与！");
            }
            if (resLong > 301 && resLong <= 400) {
                System.out.println("恭喜获得10积分");
            }
            if (resLong > 401 && resLong <= 600) {
                System.out.println("恭喜获得30积分");
            }
            if (resLong > 601 && resLong <= 950) {
                System.out.println("谢谢参与");
            }
            if (resLong > 951 && resLong < 999) {
                System.out.println("恭喜获得100积分");
            }
            if (resLong == 999) {
                System.out.println("恭喜获得保温杯一个！");
            }
            if (resLong == 999) break;
        }
//        Runnable r = () -> {
//
//        };
//        for (int i = 0; i < 20; i++) {
//            Thread t = new Thread(r);
//            t.start();
//        }
    }
}
