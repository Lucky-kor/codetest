# arrayTwoPickSum #  

It takes an array of integers. It is a problem of outputting all the numbers that can be made by extracting and adding two numbers at different indexes in the input array in ascending order.  
  
## Input and output examples ##  
  
### Input example ###  
  
[2,1,3,4,1]  
  
### Output example ###  
  
[2,3,4,5,6,7]

### I/O example explanation ###  
  
2 = 1 + 1 (There are two 1s in numbers.)  
3 = 2 + 1  
4 = 1 + 3  
5 = 1 + 4 = 2 + 3  
6 = 2 + 4  
7 = 3 + 4  
Therefore, [2,3,4,5,6,7] should be output.  
  
## Requirements ##  
  
 * numbers must be 2 or more and 100 or less in length.  
 * All numbers in numbers are 0 or more and 100 or less.  
  
## Code detail ##
  
### 1. Command input part ###. 
  
 * Create a method to determine the size of an array by dividing only numbers from the input strings.  
```java
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
```
 * 
Implement a method that separates only numbers among input strings and stores them in an array.  
```java
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
```
  
### 2.Processing ###  
  
 * 
Implement a method that adds all the numbers in the array and stores them in the arraylist.  
 * 
Implement a method to sort in ascending order after removing the same number from the saved list.  
```java
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
```