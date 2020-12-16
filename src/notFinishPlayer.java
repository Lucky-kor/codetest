import java.util.ArrayList;
import java.util.Scanner;

public class notFinishPlayer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String participant = scan.nextLine();
        String completion = scan.nextLine();

//    for(int i=0;i<getParticipant(participant).size();i++){
//        System.out.println(getParticipant(participant).get(i));
//    }
//        System.out.println("------------------");
//    for(int i=0;i<getParticipant(participant).size();i++){
//        System.out.println(getCompletion(participant).get(i));
//    }
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
