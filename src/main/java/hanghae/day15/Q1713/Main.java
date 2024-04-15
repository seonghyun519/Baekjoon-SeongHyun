package hanghae.day15.Q1713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * 학생회장 후보 일정기간 동안 전체 학생 추천으로 정해진 수만큼 선정됨
 * 학생사진 게시 할수 있는 사진틀 후보 수만큼
 * 추천받은 학생 사진 게시 추천받은 횟수 표기
 *
 * 학생 추천 시작전 모든 사진 비어있음
 * 학생이 특정 학생 추천하면 추천 받은 학생 반드시 사진 게시
 * 비어 있는 사진틀이 없는 경우 현재까지 추천 받은 횟수가 가장 적은 학생 사진 삭제 그자리에 새롭게 새롭게 추천받은 학생 사진 게시(최저 추천 동률 오래된 사진 삭제)
 * 현재 사진이 게시된 학생 다른 학생 추천 받은 경우 추천 받은만큼 횟수 증가
 * 사진틀에 게시된 사진이 삭제된 경우 삭제된 학생 추천 횟수 0 초기화
 * 후보의 수 즉, 사진틀의 개수와 전체 학생의 추천 결과가 추천받은 순서대로 주어졌을 때, 최종 후보가 누구인지 결정하는 프로그램을 작성하시오.
 *
 * 입력
 * 사진 틀 N(최종 후보 인원)
 * 전체 학생의 총 추천 횟수
 * 2, 1, 4
 * 2(삭제), 1,4,3
 * 1(삭제), 4,3,5
 * 4(삭제), 3,5,6
 * 3(삭제), 5,6,2
 * 5(삭제), 6,2,7
 * 6,2(2),7
 * sort
 * 2,6,7
 --------------------------------------------------

 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());//사진틀(최종 후보 인원)
        int C = Integer.parseInt(br.readLine());//추천 횟수
        ArrayList<Student> list = new ArrayList<>();
        boolean[] students = new boolean[101];//현재 등록 되어있는지 확인 /학생을 나타내는 번호는 1부터 100까지의 자연수
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            int studentNum = Integer.parseInt(st.nextToken());
            if (list.size() < N) {//최종 후보 인원 만큼 등록 되었는지 체크 //학생들이 추천을 시작하기 전에 모든 사진틀은 비어있다.
                if (!students[studentNum]) {// 첫 등록
                    list.add(new Student(studentNum, 1, i));
                    students[studentNum] = true; //현재 등록 상태 true
                }else {//이미 추천 받은 상태
                    for (Student s : list) {
                        if (s.getNum() == studentNum){
                            s.setLike(s.getLike()+1);//추천 수 추가
                        }
                    }
                }
            }else { //최종 후보 자리가 없으면
                if (students[studentNum]) { //등록된 상태
                    for (Student s : list) {
                        if (s.getNum() == studentNum) {
                            s.setLike(s.getLike() + 1);
                        }
                    }
                }else {//자리 없는 상태에서 첫 등록
                    Collections.sort(list);//정렬 먼저 안해서 터짐!
                    students[list.get(0).getNum()] = false;//후보자 제외
                    list.remove(0);//정렬 후 like 같으면 먼저 등록한 순, like 낮은 순
                    list.add(new Student(studentNum, 1, i));
                    students[studentNum] = true;//후보자 등록
                }
            }
        }
        for (int i = 0; i < 101; i++) {
            if (students[i]){
                System.out.print(i + " ");
            }
        }
//        int[] result = new int[N];//index 터짐!
//        for (int j = 0; j < result.length; j++) {
//            result[j] = list.get(j).getNum();
//        }
//        Arrays.sort(result);
//        for (int r : result) {
//            System.out.println(r + " ");
//        }
    }
    static class Student implements Comparable<Student>{
        int num;//추천 받은 학생 번호
        int like;//추천수
        int time;//등록 시간(0~)


        public Student(int num, int like, int time) {
            this.num = num;
            this.like = like;
            this.time = time;
        }

        public int getNum() {
            return num;
        }

        public int getLike() {
            return like;
        }

        public void setLike(int like) {
            this.like = like;
        }

        @Override
        public int compareTo(Student o) {
            if (this.like == o.like) {//추천수가 같으면 먼저 등록된 순서 정렬
                return this.time - o.time;
            }
            return this.like - o.like;//추천수가 낮은 순으로 정렬
        }
    }
}
