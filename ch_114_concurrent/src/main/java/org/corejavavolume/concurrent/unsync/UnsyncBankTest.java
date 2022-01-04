package org.corejavavolume.concurrent.unsync;

/**
 * 非同步银行测试
 */
public class UnsyncBankTest {
     public static final int NACCOUNT = 10;//账户数量
     public static final double INITIAL_BALANCE = 1000;//初始金额
     public static final double MAX_AMOUNT = 100;//最大数量
     public static final int DELAY = 10;//

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNT, INITIAL_BALANCE);
        for (int i=0; i<NACCOUNT; i++){
            int fromAccount = i;
            Runnable r = () -> {
                int m = 0;
                while (m<10) {
                    try {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    m++;
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}


/*
Thread[Thread-1,5,main]
Thread[Thread-0,5,main]
Thread[Thread-3,5,main]
Thread[Thread-2,5,main]
Thread[Thread-4,5,main]
Thread[Thread-7,5,main]
Thread[Thread-9,5,main]
Thread[Thread-6,5,main]
     89.75 from 6 to 5.
Thread[Thread-8,5,main]
Thread[Thread-5,5,main]
     93.85 from 8 to 4.
     48.05 from 9 to 6.
     93.93 from 7 to 1.
     84.82 from 4 to 2.
     61.69 from 2 to 8.
     77.70 from 3 to 6.
     11.88 from 0 to 7.
     70.50 from 1 to 9.
     83.31 from 5 to 3.
Total balance is :   10000.00

Total balance is :   10000.00

Total balance is :   10000.00

Total balance is :   10000.00

Total balance is :   10000.00

Total balance is :   10000.00

Total balance is :   10000.00

Total balance is :   10000.00

Total balance is :   10000.00

Total balance is :   10000.00

Thread[Thread-0,5,main]
Thread[Thread-7,5,main]
     43.69 from 0 to 7.
      8.84 from 7 to 4.
Total balance is :    9991.16

Total balance is :   10000.00

Thread[Thread-3,5,main]
Thread[Thread-1,5,main]
     54.73 from 3 to 0.
     13.21 from 1 to 5.
Total balance is :    9986.79

Total balance is :   10000.00

Thread[Thread-3,5,main]
     17.31 from 3 to 5.
Total balance is :   10000.00

Thread[Thread-0,5,main]
     60.01 from 0 to 1.
Total balance is :   10000.00

Thread[Thread-4,5,main]
Thread[Thread-2,5,main]
     55.84 from 4 to 1.
     67.99 from 2 to 0.
Total balance is :    9932.01

Total balance is :   10000.00

Thread[Thread-8,5,main]
     81.50 from 8 to 6.
Thread[Thread-0,5,main]
Total balance is :   10000.00

     54.20 from 0 to 8.
Total balance is :   10000.00

Thread[Thread-2,5,main]
     30.05 from 2 to 8.
Thread[Thread-7,5,main]
Total balance is :   10000.00

     51.70 from 7 to 1.
Total balance is :   10000.00

Thread[Thread-5,5,main]
Thread[Thread-9,5,main]
      0.16 from 5 to 7.
      2.20 from 9 to 0.
Total balance is :    9997.80

Total balance is :   10000.00

Thread[Thread-6,5,main]
     74.41 from 6 to 1.
Total balance is :   10000.00

Thread[Thread-2,5,main]
     45.05 from 2 to 5.
Total balance is :   10000.00

Thread[Thread-6,5,main]
Thread[Thread-9,5,main]
     87.56 from 9 to 2.
Thread[Thread-5,5,main]
Total balance is :    9923.66

     76.34 from 6 to 3.
      2.09 from 5 to 4.
Thread[Thread-1,5,main]
Total balance is :   10000.00

Total balance is :    9997.91

     98.88 from 1 to 7.
Total balance is :   10000.00

Thread[Thread-0,5,main]
Thread[Thread-2,5,main]
Thread[Thread-3,5,main]
     27.49 from 2 to 5.
     45.59 from 0 to 8.
Total balance is :    9931.08

     23.33 from 3 to 3.
Thread[Thread-7,5,main]
Total balance is :    9976.67

Total balance is :    9952.78

     47.22 from 7 to 7.
Thread[Thread-9,5,main]
Total balance is :   10000.00

Thread[Thread-8,5,main]
     52.61 from 8 to 7.
Thread[Thread-4,5,main]
Total balance is :    9947.06

     52.94 from 9 to 2.
     51.00 from 4 to 6.
Total balance is :    9949.00

Thread[Thread-5,5,main]
Total balance is :   10000.00

     43.90 from 5 to 8.
Total balance is :   10000.00

Thread[Thread-1,5,main]
     28.14 from 1 to 1.
Total balance is :   10000.00

Thread[Thread-1,5,main]
      8.03 from 1 to 5.
Total balance is :   10000.00

Thread[Thread-0,5,main]
Thread[Thread-3,5,main]
     14.12 from 0 to 4.
     54.94 from 3 to 3.
Total balance is :    9945.06

Total balance is :   10000.00

Thread[Thread-2,5,main]
     22.68 from 2 to 5.
Total balance is :   10000.00

Thread[Thread-6,5,main]
Thread[Thread-7,5,main]
     84.15 from 6 to 8.
     92.64 from 7 to 2.
Total balance is :    9907.36

Total balance is :   10000.00

Thread[Thread-7,5,main]
     80.05 from 7 to 9.
Total balance is :   10000.00

Thread[Thread-8,5,main]
     77.72 from 8 to 4.
Thread[Thread-4,5,main]
Total balance is :   10000.00

     32.09 from 4 to 6.
Total balance is :   10000.00

Thread[Thread-5,5,main]
Thread[Thread-9,5,main]
Thread[Thread-1,5,main]
      8.10 from 9 to 1.
     15.28 from 5 to 0.
Total balance is :    9955.58

     29.14 from 1 to 1.
Total balance is :    9970.86

Total balance is :   10000.00

Thread[Thread-2,5,main]
Thread[Thread-9,5,main]
     93.63 from 2 to 1.
     84.19 from 9 to 5.
Total balance is :    9915.81

Total balance is :   10000.00

Thread[Thread-7,5,main]
     56.14 from 7 to 4.
Total balance is :   10000.00

Thread[Thread-3,5,main]
Thread[Thread-0,5,main]
Thread[Thread-8,5,main]
Thread[Thread-2,5,main]
     16.51 from 2 to 1.
     35.20 from 8 to 7.
     63.20 from 0 to 9.
     14.84 from 3 to 7.
Total balance is :   10000.00

Thread[Thread-9,5,main]
Thread[Thread-4,5,main]
Total balance is :    9985.16

Total balance is :    9921.96

Total balance is :    9886.76

     94.65 from 4 to 8.
     17.59 from 9 to 2.
Thread[Thread-3,5,main]
     56.91 from 3 to 5.
Thread[Thread-6,5,main]
     55.95 from 6 to 8.
Total balance is :   10000.00

Total balance is :    9982.41

Thread[Thread-5,5,main]
     96.26 from 5 to 9.
Total balance is :   10000.00

Thread[Thread-1,5,main]
     89.74 from 1 to 9.
Total balance is :   10000.00

Total balance is :   10000.00

Total balance is :   10000.00

Thread[Thread-8,5,main]
Thread[Thread-3,5,main]
Thread[Thread-5,5,main]
     48.43 from 3 to 8.
     80.94 from 8 to 7.
Total balance is :    9895.51

     23.56 from 5 to 9.
Total balance is :    9976.44

Total balance is :   10000.00

Thread[Thread-8,5,main]
     25.37 from 8 to 7.
Total balance is :   10000.00

Thread[Thread-0,5,main]
     49.81 from 0 to 3.
Total balance is :   10000.00

Thread[Thread-1,5,main]
     61.71 from 1 to 9.
Total balance is :   10000.00

Thread[Thread-4,5,main]
Thread[Thread-7,5,main]
     59.94 from 4 to 0.
     29.10 from 7 to 3.
Total balance is :    9970.90

Total balance is :   10000.00

Thread[Thread-4,5,main]
     64.14 from 4 to 0.
Total balance is :   10000.00

Thread[Thread-2,5,main]
Thread[Thread-3,5,main]
Thread[Thread-9,5,main]
     23.03 from 3 to 7.
     26.54 from 2 to 0.
Total balance is :    9944.88

     28.58 from 9 to 3.
Total balance is :    9971.42

Total balance is :   10000.00

Thread[Thread-2,5,main]
     54.95 from 2 to 6.
Thread[Thread-4,5,main]
Thread[Thread-1,5,main]
     51.29 from 1 to 1.
     11.81 from 4 to 2.
Total balance is :   10000.00

Total balance is :   10000.00

Total balance is :    9988.19

Thread[Thread-5,5,main]
      8.86 from 5 to 5.
Total balance is :   10000.00

Thread[Thread-8,5,main]
Thread[Thread-6,5,main]
     60.61 from 8 to 9.
     34.42 from 6 to 6.
Total balance is :    9965.58

Total balance is :   10000.00

Thread[Thread-9,5,main]
     24.16 from 9 to 1.
Total balance is :   10000.00

Thread[Thread-7,5,main]
     25.52 from 7 to 2.
Total balance is :   10000.00

Thread[Thread-0,5,main]
     32.27 from 0 to 1.
Total balance is :   10000.00

Thread[Thread-5,5,main]
     60.46 from 5 to 2.
Total balance is :   10000.00

Thread[Thread-1,5,main]
     30.50 from 1 to 7.
Thread[Thread-3,5,main]
     76.15 from 3 to 8.
Total balance is :   10000.00

Total balance is :   10000.00

Thread[Thread-0,5,main]
     50.43 from 0 to 9.
Total balance is :   10000.00

Thread[Thread-7,5,main]
     67.54 from 7 to 9.
Total balance is :   10000.00

Thread[Thread-9,5,main]
     12.79 from 9 to 9.
Total balance is :   10000.00

Thread[Thread-4,5,main]
     15.13 from 4 to 6.
Total balance is :   10000.00

Thread[Thread-6,5,main]
     62.02 from 6 to 0.
Thread[Thread-8,5,main]
     57.07 from 8 to 8.
Total balance is :   10000.00

Total balance is :   10000.00

Thread[Thread-5,5,main]
     55.03 from 5 to 0.
Total balance is :   10000.00

Thread[Thread-4,5,main]
     47.87 from 4 to 6.
Total balance is :   10000.00

Thread[Thread-6,5,main]
     70.99 from 6 to 3.
Total balance is :   10000.00

Thread[Thread-6,5,main]
Thread[Thread-8,5,main]
     33.11 from 6 to 8.
     47.75 from 8 to 5.
Total balance is :    9952.25

Total balance is :   10000.00

Thread[Thread-6,5,main]
     70.34 from 6 to 2.
Total balance is :   10000.00
 */