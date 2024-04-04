package hanghae.day7.Q2002;

import java.io.*;
import java.util.*;
/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * 입력 총 2N + 1
 * 차량의 대수 N
 * 둘쨋줄부터 N+1까지 대근이
 * N+2째 줄부터 마지막까지 영식이
 * 5
 * ZG508OK PU305A (2) 추월
 * PU305A ZG232ZF(5) 추월
 * RI604B ZG206A(4) 추월
 * ZG206A ZG508OK(1) 정상
 * ZG232ZF RI604B(3) 정상
 *
 * 5
 * (1)ZG206A (5)ZG5962J추월
 * (2)PU234Q (3)OS945CK추월
 * (3)OS945CK (1)ZG206A정상
 * (4)ZG431SN (2)PU234Q정상
 * (5)ZG5962J (4)ZG431SN정상
 *
 *
 *
 *대근이 HashMap으로 받고 키는 차량번호 받은 순서 value
 *영식이 순서대로 받을 때 순서 값이 같거나 자신이 낮은수면 pass 인덱스가 자신이 높은수면 과속!
 *추월을 했는데 추월당한 차가 있을 경우 자신보다 높은 차량이 추월했을 경우 계산

 *
 --------------------------------------------------

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            hashMap.put(key, i);
        }
        int overPassCount = 0;
        String overPassCarNum[] = new String[N];
        //단속중
        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            if (hashMap.get(key) > i) {
                overPassCarNum[overPassCount] = key; //추월 차량 번호판 저장
                overPassCount++;// 추월 차량 개수 추가
            } else {
                int overPassCountTemp = 0; //현재 차량를 추월한 차량이 있는지 확인
                for (int j = 0; j < overPassCount; j++) {
                    if (hashMap.get(key) < hashMap.get(overPassCarNum[j])) {
                        overPassCountTemp++;
                    }
                }
                if (hashMap.get(key) + overPassCountTemp > i) {
                    overPassCarNum[overPassCount] = key;
                    overPassCount++;
                }
            }
        }
        sb.append(overPassCount);
        System.out.println(sb);
    }
}