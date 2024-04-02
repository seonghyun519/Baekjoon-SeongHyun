package 단계별.이차원배열.Q10798;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[][] result = new char[5][15];

        for(int i=0; i<5; i++) {
            result[i] = br.readLine().toCharArray();
        }
        for(int i=0; i<15; i++) {
            for(int j=0; j<5; j++) {
                if(result[j].length > i) {
                    sb.append(result[j][i]);
                }
            }
        }
        System.out.println(sb);
    }
}
