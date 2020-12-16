import java.util.ArrayList;
import java.util.Scanner;

public class notFinishPlayer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String participant = scan.nextLine();
        String completion = scan.nextLine();

        ArrayList<String> setParticipant = getParticipant(participant);
        ArrayList<String> setCompletion = getCompletion(completion);

        for(int i=0;i<setParticipant.size();i++){
            for(int j=0;j<setCompletion.size();j++){
                if(setParticipant.get(i).equals(setCompletion.get(j))){
                    setParticipant.remove(i);
                    i--;
                    break;
                }
            }
        }
        System.out.println(setParticipant.get(0));
    }
    private static ArrayList<String> getParticipant(String participant){
        int countFirst=0;
        ArrayList<String> name = new ArrayList<String>();

        for(int i=0;i<participant.length();i++){
            if(participant.charAt(i)==','){
                name.add(participant.substring(1,i));
                break;
            }
        }
        for(int i=0;i<participant.length();i++){
            if((participant.charAt(i) == '[' || participant.charAt(i)==' ') && countFirst==0){
                countFirst=i;
            }else if((participant.charAt(i)==',' || participant.charAt(i)==']') && countFirst!=0){
                name.add(participant.substring(countFirst+1,i));
                countFirst=0;
            }
        }
        return name;
    }
    private static ArrayList<String> getCompletion(String completion){
        int countFirst=0;
        ArrayList<String> name = new ArrayList<String>();

        for(int i=0;i<completion.length();i++){
            if(completion.charAt(i)==','){
                name.add(completion.substring(1,i));
                break;
            }
        }
        for(int i=0;i<completion.length();i++){
            if((completion.charAt(i) == '[' || completion.charAt(i)==' ') && countFirst==0){
                countFirst=i;
            }else if((completion.charAt(i)==',' || completion.charAt(i)==']') && countFirst!=0){
                name.add(completion.substring(countFirst+1,i));
                countFirst=0;
            }
        }
        return name;
    }
}
