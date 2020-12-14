import java.util.Scanner;

public class dolldrawgame {
    public static void main(String[] args) {
        String inputBoard;
        String inputMoves;

        int arrayFirstBoard = 0;
        int arraySecondBoard = 0;
        int arrayMoves = 0;

        Scanner scan = new Scanner(System.in);

        inputBoard = scan.nextLine();       //배열값 받기
        inputMoves = scan.nextLine();       //움직임값 받기

        for (int i = 0; i < inputBoard.length(); i++) {     //인형을 담는 통의 첫배열 길이 구하기
            char cheakBoard = inputBoard.charAt(i);
            if (cheakBoard == ']') {
                arrayFirstBoard++;
            }
        }
        arrayFirstBoard--;
        for (int j = 0; j < inputBoard.length(); j++) {   //인형을 담는통 이중배열중 두번째 배열의 길 구하기
            char checkBoard = inputBoard.charAt(j);
            if (checkBoard == '[' || checkBoard == ']' || checkBoard == ',') {
                continue;
            } else {
                arraySecondBoard++;
            }
        }
        arraySecondBoard = arraySecondBoard / arrayFirstBoard;
        for (int k = 0; k < inputMoves.length(); k++) {     //움직이는 숫자의 배열의 길이 구하
            char checkMoves = inputMoves.charAt(k);
            if (checkMoves == '[' || checkMoves == ']' || checkMoves == ',') {
                continue;
            } else {
                arrayMoves++;
            }

        }

        int[][] board = new int[arrayFirstBoard][arraySecondBoard];
        int number1 = 0;
        int number2 = 0;
        String cheakBoard = null;

        for (int i = 0; i < inputBoard.length() - 1; i++) {       //구한 배열의 길이에 맞춰 인형의 값을 배열에 정리함

            cheakBoard = inputBoard.substring(i, i + 1);

            if (cheakBoard.equals("[") || cheakBoard.equals(",")) {
                continue;
            } else if (cheakBoard.equals("]")) {
                number1++;
                number2 = 0;
            } else {
                board[number1][number2] = Integer.parseInt(cheakBoard);
                number2++;
            }
        }

        int[] moves = new int[arrayMoves];
        String checkMoves = null;
        int number3 = 0;

        for (int i = 0; i < inputMoves.length() - 1; i++) {     //구한 배열에 맞춰서 움직이는 수를 배열에 넣어줌
            checkMoves = inputMoves.substring(i, i + 1);
            if (checkMoves.equals("[") || checkMoves.equals(",") || checkMoves.equals("]")) {
                continue;
            } else {
                moves[number3] = Integer.parseInt(checkMoves);
                number3++;
            }
        }
        for (int i = 0; i < arrayFirstBoard; i++) {
            for (int j = 0; j < arraySecondBoard; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        for (int j = 0; j < arrayMoves; j++) {
            System.out.print(moves[j]);
        }
    }
}