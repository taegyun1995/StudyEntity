package study.ignorance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_2715 {

    public static void main(String[] args) throws IOException {
        백준_2715 t = new 백준_2715();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int num : t.solution(arr)) {
            System.out.println(num);
        }
    }

    public int[] solution(int[] arr) {
        return Arrays.stream(arr).sorted().toArray();
    }

}