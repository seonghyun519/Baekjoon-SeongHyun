package 단계별.문자와문자열.Q1152;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st= new StringTokenizer(br.readLine());
        sb.append(st.countTokens());
        System.out.println(sb);
    }
}
