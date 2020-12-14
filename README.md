# Dolldrawgame #  
  

You can enter an integer from 0 to 100 or less in the array of [n][n].  
Afterwards, the numbers that determine the row to be retrieved from the. top of the array are input as an array.  
After all inputs are received, the number is sequentially accumulated by moving a fixed number to the moving array.  
If the same number is overlapped among the stacked numbers, both numbers are removed.  
At this time, it is a problem that calculates and outputs the number of disappeared numbers by overlapping the same number.  

## Input and output examples ##  
  
### Input ###
[[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]  
[1,5,3,5,1,2,1,4]  
  
### Output ###  
  
4  
  

## Requirements ##  
  
The board array is a two-dimensional array whose size is 5 x 5 or more and 30 x 30 or less.  
Each cell of the board contains an integer from 0 to 100.  
0 represents a blank space.  
Each number from 1 to 100 represents a different doll shape, and the same number represents a doll of the same shape.  
The size of the moves array is 1 or more and 1,000 or less.  
Each element in the moves array has a value greater than or equal to 1 and is a natural number less than or equal to the horizontal size of the board array.  
  
  
## Code detail ##  
  
### 1. Command input part ###  
  
 * The first array (the number is mixed) and the second array (the number that determines the column to be extracted) are entered separately in two separate steps.  
 * It was processed so that only the correct answer was output without printing the separate array.  
 * A separate method was implemented to determine the size of the array by finding only the numbers excluding "[","]","," among the input strings and inputting into the array.  
```java
private static int[] moves(String inputMoves) {
        int[] moves = new int[arraysMoves(inputMoves)];
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
        return moves;
    }
```


### 2.Processing ###  
  
 * Using the number in the moves array, the number in the board is extracted and saved.  
```java
for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] != 0) {
                    list.add(board[j][moves[i] - 1]);
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }
```
 * Then, create a method to find the correct answer by counting and removing overlapping numbers in the stored number.
```java
int start = 0;

        while (start < list.size() - 1) {
            if (list.get(start) == list.get(start + 1)) {
                list.remove(start);
                list.remove(start);
                answer += 2;
                if (start == 0) {
                    continue;
                } else {
                    start--;
                }
            } else {
                start++;
            }
        }
        return answer;
```