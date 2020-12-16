# notFinishPlayer #  
  
Numerous marathon runners took part in the marathon. All but one athlete completed the marathon.  
When given an array participant containing the names of the athletes who participated in the marathon and an array completion containing the names of the athletes who finished, write a solution function to return the names of the athletes who did not finish.  
  
## Requirements ##  
  
The number of runners participating in the marathon race is from 1 to 100,000.  
The length of completion is 1 less than the length of the participant.  
The participant's name consists of at least 1 and no more than 20 lowercase alphabetic characters.  
Some of the participants may have the same name.  
  
## Code detail ##  
  
### 1. Command input part ###  
  
 * Implement a method that receives two arrays of participant and completion and saves them as Arraylist.  
  
 * Separate the two "[" and"," and select and save only the words between them.  
 * If the input form is different, only the method can be modified and applied.  
```java
private static ArrayList<String> getParticipant(String participant) {
        int countFirst = 0;
        ArrayList<String> name = new ArrayList<String>();

        for (int i = 0; i < participant.length(); i++) {
            if (participant.charAt(i) == ',') {
                name.add(participant.substring(1, i));
                break;
            }
        }
        for (int i = 0; i < participant.length(); i++) {
            if ((participant.charAt(i) == '[' || participant.charAt(i) == ' ') && countFirst == 0) {
                countFirst = i;
            } else if ((participant.charAt(i) == ',' || participant.charAt(i) == ']') && countFirst != 0) {
                name.add(participant.substring(countFirst + 1, i));
                countFirst = 0;
            }
        }
        return name;
    }

    private static ArrayList<String> getCompletion(String completion) {
        int countFirst = 0;
        ArrayList<String> name = new ArrayList<String>();

        for (int i = 0; i < completion.length(); i++) {
            if (completion.charAt(i) == ',') {
                name.add(completion.substring(1, i));
                break;
            }
        }
        for (int i = 0; i < completion.length(); i++) {
            if ((completion.charAt(i) == '[' || completion.charAt(i) == ' ') && countFirst == 0) {
                countFirst = i;
            } else if ((completion.charAt(i) == ',' || completion.charAt(i) == ']') && countFirst != 0) {
                name.add(completion.substring(countFirst + 1, i));
                countFirst = 0;
            }
        }
        return name;
    }
```
  
### 2.Processing ###  
  
 * The use of loops is minimized to increase efficiency.  
 * After changing both arrays in ascending order, compare the values ​​of each order by the size of the small array.  
```java
for (int i = 0; i < setCompletion.size(); i++) {
            if (!setParticipant.get(i).equals(setCompletion.get(i))) {
                answer = setParticipant.get(i);
                break;
            }
        }
```
 * If there is the same name, the corresponding logic can find the correct answer, but if. there is no same name, the name in the last order of the array is the correct answer.  
```java
if (answer.equals("")) {
            answer = setParticipant.get(setParticipant.size() - 1);
        }
```