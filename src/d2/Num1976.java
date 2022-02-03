package d2;// 1976 - 시각 덧셈

import java.util.Scanner;

public class Num1976 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {

            int hour1 = sc.nextInt();
            int minute1 = sc.nextInt();
            int hour2 = sc.nextInt();
            int minute2 = sc.nextInt();


            int resultHour = hour1 + hour2;
            int resultMinute = minute1 + minute2;

            if (resultMinute >= 60) {
                resultMinute -= 60;
                resultHour++;
            }
            if (resultHour > 12) {
                resultHour = resultHour - 12;
            }

            System.out.println("#" + (i + 1) + " " + resultHour + " " + resultMinute);
        }
    }
}
