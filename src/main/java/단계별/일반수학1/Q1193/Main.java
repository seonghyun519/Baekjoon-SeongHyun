package 단계별.일반수학1.Q1193;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int i = 0;
        int val = 0;
        while(val < X) {
            i++;
            val += i;
        }

        if(i % 2 == 0) {
            System.out.println((i - (val - X)) + "/" + (i + (((val - i) - X) + 1)));
        }else {
            System.out.println((i + (((val - i) - X) + 1)) + "/" + (i - (val - X)));
        }
    }
}