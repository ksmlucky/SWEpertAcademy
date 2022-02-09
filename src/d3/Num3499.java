// 3499 - 퍼펙트 셔플

package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num3499 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] strArr = new String[N];
            ArrayList<String> arrayList = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                strArr[i] = st.nextToken();
            }
            String[] arr1, arr2;
            if (N % 2 == 0) {
                arr1 = new String[N / 2];
                arr2 = new String[N / 2];
                for (int i = 0; i < strArr.length / 2; i++) {
                    arr1[i] = strArr[i];
                }
                for (int i = 0; i < strArr.length / 2; i++) {
                    arr2[i] = strArr[strArr.length / 2 + i];
                }
                for (int i = 0; i < strArr.length / 2; i++) {
                    arrayList.add(arr1[i]);
                    arrayList.add(arr2[i]);
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i)).append(" ");
                }
            } else {
                arr1 = new String[N / 2 + 1];
                arr2 = new String[N / 2];
                for (int i = 0; i < strArr.length / 2 + 1; i++) {
                    arr1[i] = strArr[i];
                }
                for (int i = 0; i < strArr.length / 2; i++) {
                    arr2[i] = strArr[strArr.length / 2 + 1 + i];
                }
                for (int i = 0; i < strArr.length / 2; i++) {
                    arrayList.add(arr1[i]);
                    arrayList.add(arr2[i]);
                }
                arrayList.add(arr1[arr1.length - 1]);
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i)).append(" ");
                }
            }
            sb.setLength(sb.length() - 1);
            System.out.println("#" + t + " " + sb);
        }
    }
}
