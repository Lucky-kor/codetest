import java.util.ArrayList;
import java.util.Scanner;

public class mathExample {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String allAnswer = scan.nextLine();
        int[] answer = answer(allAnswer);

    }
    private static int[] answer(String allAnswer){
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        for(int i=0;i<allAnswer.length()-1;i++){
            if(allAnswer.charAt(i)=='[' || allAnswer.charAt(i)==']' || allAnswer.charAt(i)==','){
                continue;
            }else{
                answerList.add(Integer.parseInt(allAnswer.substring(i,i+1)));
            }
        }
        int[] answer = new int[answerList.size()];
        for(int i=0;i<answerList.size();i++){
            answer[i]=answerList.get(i);
        }
        return answer;
    }
}
