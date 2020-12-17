# mathExample #  
  
Abandoner is short for a person who has given up on math.  
Three inmates are trying to take all math problems for the practice test. The blisters.  
are recorded from question 1 to the last question as follows.  
Student1 answers : 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...  
Student2 answers : 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...  
student3 answers : 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...  
Enter the array answers in which the correct answers from the first question to the last question were received in order, find out who answered the most questions, and print them out.  
  
## Input and output examples ##  
  
### Input ###
  
[1,2,3,4,5]  
[1,3,2,4,2]  
  
### Output ###  
  
[1]  
[1,2,3]  
  
## I/O example explanation ##  
  
### I/O example #1 ###  
Student 1 got all the questions right.  
Student 2 is all wrong.  
Student 3 is all wrong.  
  
Therefore, the person who got the most questions was Student 1.  
  
### I/O example #2 ###  
  
Everyone got 2 questions at a time.  
  
## Requirements ##  
  
The exam consists of up to 10,000 questions.  
The correct answer to the question is one of 1, 2, 3, 4, 5.  
If there are multiple people with the highest score, please sort the output values ​​in ascending order.  
  
## Code detail ##   
  
### 1. Command input part ###  
  
 * Implement a method that receives all correct answers and stores only numbers excluding special characters in an array.  
```java
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
```
  
### 2.Processing ###  
  
 * Implement a method to check scores by comparing all correct answers with students' individual correct answers.  
```java
for (int i = 0; i < answer.length; i++) {
            if (answer[i] == student1[i % student1.length]) scores[0]++;
            if (answer[i] == student2[i % student2.length]) scores[1]++;
            if (answer[i] == student3[i % student3.length]) scores[2]++;
        }
        for (int i = 0; i < scores.length - 1; i++) {
            max = Math.max(scores[0], scores[i + 1]);
        }
```
 * The highest value among the students' scores was calculated, and the tied scorers were. checked using Arraylist, saved and returned.  
```java
ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < scores.length; i++) {
            if (max == scores[i]) list.add(i + 1);
        }
        return list;
```
 * Simplify the code of the main method by creating a separate output method.  
```java
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
```

