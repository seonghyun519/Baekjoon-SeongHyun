package 단계별.일반수학1.Q2903;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int width = 3;
        int[] star = new int[16];
        for(int i=1; i<star.length; i++) {
            star[i] = width * width;
            width = width + (width-1);
        }
        sb.append(star[N]);
        System.out.println(sb);
    }
}