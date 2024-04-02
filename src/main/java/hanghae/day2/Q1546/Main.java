package hanghae.day2.Q1546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrLength = Integer.parseInt(br.readLine());

        float[] arr = new float[arrLength];
        StringTokenizer strTo = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(strTo.nextToken());
        }

        float max = 0, sum = 0, avg = 0;

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] / max) * 100;
            sum += arr[i];
        }
        avg = sum / arr.length;
        System.out.println(avg);
    }
}