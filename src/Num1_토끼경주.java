/**
 * 문제
 토끼는 앞다리에 비해 뒷다리가 길고 튼튼하다. 뒷다리가 길어 높이 뛰어오를 수
 있으며 오르막도 곧잘 오르지만 내리막은 잘 달리지 못한다.
 A는 머리를 식힐겸 5마리의
 토끼가 경주를 벌이는 토끼 경주장을 방문했다. A는 5마리의 토끼 중 얼마나
 많은 토끼가 경주장을 완주할 수 있는지 알아보려고 한다.
 경주장은 오르막길과 내리막길이 있으며, 각 지점마다 높이가 정해진다.
 경주장의 각 지점의 높이 Hi 는 0보다 크거나 같고 100보다 작거나 같다.
 경주장의 길이는 10이며 아래는 경주장 샘플이다.
 0 20 50 70 50 60 40 50 30 0
 이 샘플 경주장에서 1번째 지점에서 2번째 지점으로의 오르막은 20미터, 2번째
 지점에서 3번째 지점으로의 오르막은 30미터, 그리고 9번째 지점에서 10번째
 지점으로의 내리막은 30미터이다.
 경주장을 뛸 5마리의 토끼의 오르막 점프 한계치와 내리막 점프 한계치를 가지며,
 오르막과 내리막의 높이가 토끼의 점프 한계치와 동일한 경우에는 점프가 가능하지만
 자신이 가진 한계치보다 높은 오르막 혹은 내리막은 이동하지 못한다. 5마리의
 귀여운 토끼 중 몇 마리의 토끼가 경주장을 완주할 수 있을지 검사하는 프로그램을
 작성하시오.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 [예제 입력]
 2
 0 20 50 70 50 60 40 50 30 0
 30 20
 60 40
 50 30
 40 40
 100 0
 100 90 90 90 90 90 90 90 90 50
 30 20
 60 40
 50 30
 40 40
 100 0
 [출력 예시]
 #1 3
 #2 2
 */

public class Num1_토끼경주 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] raceTrack = new int[10]; // 경주장 정보

        int T = Integer.parseInt(br.readLine());

        String[] temp;

        for (int t = 1; t <= T; t++) {
            int answer = 0;

            // 입력
            temp = br.readLine().split(" ");
            for (int i = 0; i < 10; i++) {
                raceTrack[i] = Integer.parseInt(temp[i]);
            }

            int up, down;
            for (int i = 0; i < 5; i++) {
                temp = br.readLine().split(" ");
                up = Integer.parseInt(temp[0]); // 오르막
                down = Integer.parseInt(temp[1]); // 내리막

                int count = 0;
                int step;

                while (count < 9) {
                    step = raceTrack[count + 1] - raceTrack[count];

                    if (step >= 0 && up >= step) { // 오르막이면
                        count++;
                    } else if (step < 0 && (down >= (step) * (-1))) { // 내리막이면
                        count++;
                    } else {
                        break;
                    }
                }

                // 완주했으면
                if (count == 9) {
                    answer++;
                }
            }
            sb.append("#").append(t).append(" ").append(answer);
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
