import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class arrayTwoPickSum {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String scanWords = scan.nextLine();
        ArrayList<Integer> arraySumList = new ArrayList<Integer>();

        for (int i = 0; i < arrayWords((scanWords)).length - 1; i++) {
            for (int j = i + 1; j < arrayWords(scanWords).length; j++) {
                arraySumList.add(arrayWords(scanWords)[i] + arrayWords(scanWords)[j]);
            }
        }

        for (int i = 0; i < arraySumList.size() - 1; i++) {
            for (int j = i + 1; j < arraySumList.size(); j++) {
                if (arraySumList.get(i).equals(arraySumList.get(j))) {
                    arraySumList.remove(j);
                    j--;
                } else {
                    continue;
                }
            }
        }
        arraySumList.sort(Comparator.naturalOrder());

        for (int i = 0; i < arraySumList.size(); i++) {
            System.out.println(arraySumList.get(i));
        }

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
}
