package hanghae.day12.Q1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
//알려준 주어진 코드 틀림





//-----------
public class Main {

    static int L, C;
    static char[] input;
    static char[] password;

    static Set<Character> moms = Set.of('a', 'e', 'i', 'o', 'u');

    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var tokenizer = new StringTokenizer(br.readLine());

        L = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());

        input = new char[C + 1];

        tokenizer = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            input[i] = tokenizer.nextToken().charAt(0);
        }
        Arrays.sort(input);

        password = new char[L + 1];

        combination(0, L, 0, 0);

        System.out.println(answer);
    }

    private static void combination(
            int start,
            int r,
            int momCount,
            int sonCount
    ) {
        if (r == 0) {
            if (momCount >= 1 && sonCount >= 2) {
                answer.append(new String(password)).append("\n");
            }
            return;
        }

        for (int i = start; i < input.length; i++) {
            char curChar = input[i];
            password[L - r] = curChar;

            if (moms.contains(curChar)) {
                combination(i + 1, r - 1, momCount + 1, sonCount);
            } else {
                combination(i + 1, r - 1, momCount, sonCount + 1);
            }
        }
    }
}
