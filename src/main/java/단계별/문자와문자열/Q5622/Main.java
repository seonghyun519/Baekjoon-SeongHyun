package 단계별.문자와문자열.Q5622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int a = 0;
        int b = str.length();

        for(int i = 0; i<b; i++){
            switch(str.charAt(i)){
                case 'A' : case 'B' : case 'C' :
                    a += 3;
                    break;
                case 'D' : case 'E' : case 'F' :
                    a += 4;
                    break;
                case 'G' : case 'H' : case 'I' :
                    a += 5;
                    break;
                case 'J' : case 'K' : case 'L' :
                    a += 6;
                    break;
                case 'M' : case 'N' : case 'O' :
                    a += 7;
                    break;
                case 'P' : case 'Q' : case 'R' : case 'S' :
                    a += 8;
                    break;
                case 'T' : case 'U' : case 'V' :
                    a += 9;
                    break;
                case 'W' : case 'X' : case 'Y' : case 'Z' :
                    a += 10;
                    break;
            }
        }
        System.out.print(a);
    }
}
