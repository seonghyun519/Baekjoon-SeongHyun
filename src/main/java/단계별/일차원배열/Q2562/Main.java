package 단계별.일차원배열.Q2562;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] array = new int[9];

        for(int i = 0 ; i < 9 ; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        int max = 0;
        int n = 0;

        int count = 0;

        for(int value : array) {
            count++;
            if(value > max) {
                max = value;
                n = count;
            }
        }
        sb.append(max + "\n");
        sb.append(n);
        System.out.println(sb);
    }
}