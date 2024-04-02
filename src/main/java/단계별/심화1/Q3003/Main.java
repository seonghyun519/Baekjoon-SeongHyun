package 단계별.심화1.Q3003;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] pice = {1, 1, 2, 2, 2, 8};
        for (int i = 0; i < pice.length; i++) {
            sb.append(pice[i] - Integer.parseInt(st.nextToken()));
        }
        System.out.println(sb);
    }
}