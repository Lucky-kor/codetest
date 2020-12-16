import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class arrayTwoPickSum {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String scanWords = scan.nextLine();

        printWord(arrayCompareList(arrayAllSum(scanWords)));


    }

    private static int arraysSize(String scanWords) {   //배열의 크기 구하기
        int arraySizes = 0;
        for (int k = 0; k < scanWords.length(); k++) {
            char checkWords = scanWords.charAt(k);
            if (checkWords == '[' || checkWords == ']' || checkWords == ',') {
                continue;
            } else {
                arraySizes++;
            }
        }
        return arraySizes;
    }

    private static int[] arrayWords(String scanWords) {     //배열안의 숫자 구해넣기
        int[] words = new int[arraysSize(scanWords)];
        String checkWords = null;
        int count = 0;

        for (int i = 0; i < scanWords.length() - 1; i++) {
            checkWords = scanWords.substring(i, i + 1);
            if (checkWords.equals("[") || checkWords.equals(",") || checkWords.equals("]")) {
                continue;
            } else {
                words[count] = Integer.parseInt(checkWords);
                count++;
            }
        }
        return words;
    }
    private static ArrayList<Integer> arrayAllSum(String scanWords){

        ArrayList<Integer> arraySumList = new ArrayList<Integer>();

        for (int i = 0; i < arrayWords((scanWords)).length - 1; i++) {      //배열내 모든 숫자를 순차적으로 더해 List로 저장
            for (int j = i + 1; j < arrayWords(scanWords).length; j++) {
                arraySumList.add(arrayWords(scanWords)[i] + arrayWords(scanWords)[j]);
            }
        }
        return arraySumList;
    }
    private static ArrayList<Integer> arrayCompareList(ArrayList<Integer> arrayAllList){
        for (int i = 0; i < arrayAllList.size() - 1; i++) {     //List내 같은숫자 찾아내서 제거하기
            for (int j = i + 1; j < arrayAllList.size(); j++) {
                if (arrayAllList.get(i).equals(arrayAllList.get(j))) {
                    arrayAllList.remove(j);
                    j--;
                } else {
                    continue;
                }
            }
        }
        arrayAllList.sort(Comparator.naturalOrder());
        return arrayAllList;
    }
    private static void printWord(ArrayList<Integer> arrayCompareList){
        System.out.print("[");
        for (int i = 0; i < arrayCompareList.size(); i++) {
            if(i!=arrayCompareList.size()-1) {
                System.out.print(arrayCompareList.get(i)+",");
            }else{
                System.out.print(arrayCompareList.get(i));
            }
        }
        System.out.println("]");
    }
}
