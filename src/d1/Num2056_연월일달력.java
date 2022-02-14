// 2056 - 연월일 달력

package d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2056_연월일달력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String str = br.readLine();
            String yearStr = str.substring(0, 4);
            String monthStr = str.substring(4, 6);
            String dayStr = str.substring(6, 8);
            int year = Integer.parseInt(yearStr);
            int month = Integer.parseInt(monthStr);
            int day = Integer.parseInt(dayStr);

            if (year > 0) {
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    if (day >= 1 && day <= 31) {
                        System.out.println("#" + t + " " + yearStr + "/" + monthStr + "/" + dayStr);
                    } else {
                        System.out.println("#" + t + " -1");
                    }
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (day >= 1 && day <= 30) {
                        System.out.println("#" + t + " " + yearStr + "/" + monthStr + "/" + dayStr);
                    } else {
                        System.out.println("#" + t + " -1");
                    }
                } else if (month == 2) {
                    if (day >= 1 && day <= 28) {
                        System.out.println("#" + t + " " + yearStr + "/" + monthStr + "/" + dayStr);
                    } else {
                        System.out.println("#" + t + " -1");
                    }
                } else {
                    System.out.println("#" + t + " -1");
                }
            } else {
                System.out.println("#" + t + " -1");
            }
        }
    }
}
