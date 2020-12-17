import java.util.ArrayList;
import java.util.Scanner;

public class mathExample {
    public static void main(String[] args) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = {0, 0, 0};
        Scanner scan = new Scanner(System.in);
        String allAnswer = scan.nextLine();

        int[] answer = answer(allAnswer);
        ArrayList<Integer> setList = getList(answer, student1, student2, student3, scores);
        print(setList);
    }

    private static int[] answer(String allAnswer) {          //전체정답을 입력받아 구분하는 메소드
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        for (int i = 0; i < allAnswer.length() - 1; i++) {
            if (allAnswer.charAt(i) == '[' || allAnswer.charAt(i) == ']' || allAnswer.charAt(i) == ',') {
                continue;
            } else {
                answerList.add(Integer.parseInt(allAnswer.substring(i, i + 1)));
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    private static ArrayList<Integer> getList(int[] answer, int[] student1, int[] student2, int[] student3, int[] scores) {
        int max = 0;
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == student1[i % student1.length]) scores[0]++;
            if (answer[i] == student2[i % student2.length]) scores[1]++;
            if (answer[i] == student3[i % student3.length]) scores[2]++;
        }
        for (int i = 0; i < scores.length - 1; i++) {
            max = Math.max(scores[0], scores[i + 1]);
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < scores.length; i++) {
            if (max == scores[i]) list.add(i + 1);
        }
        return list;
    }

    private static void print(ArrayList<Integer> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.print(list.get(i));
            } else {
                System.out.print(list.get(i) + ",");
            }
        }
        System.out.println("]");
    }
}
