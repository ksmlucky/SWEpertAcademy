// 2050 - 알파벳을 숫자로 변환

package d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2050_알파벳을숫자로변환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - ('A' - 1);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
