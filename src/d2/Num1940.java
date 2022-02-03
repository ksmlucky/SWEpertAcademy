// 1940 - 가랏! RC카!

package d2;

import java.util.Scanner;

public class Num1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int speed = 0;
            int totalDistance = 0;

            for (int i = 0; i < N; i++) {
                int command = sc.nextInt();
                if (command != 0) {
                    int accel = sc.nextInt();

                    if(command == 1) {
                        speed += accel;
                    } else {
                        if(speed < accel) {
                            speed = 0;
                        } else {
                            speed -= accel;
                        }
                    }
                }

                totalDistance += speed;
            }

            System.out.println("#" + t + " " + totalDistance);
        }
    }
}
