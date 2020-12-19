import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class rentSportswear {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int allNumber = scan.nextInt();
        String lost = scan.next();
        String reserve = scan.next();

        Integer[] lostNumber = Arrays.stream(lostCheck(lost)).boxed().toArray(Integer[]::new);
        Integer[] reserveNumber = Arrays.stream(reserveCheck(reserve)).boxed().toArray(Integer[]::new);

        ArrayList<Integer> getLostNumber = new ArrayList<>(Arrays.asList(lostNumber));
        ArrayList<Integer> getReserveNumber = new ArrayList<>(Arrays.asList(reserveNumber));

        for(int i=0;i< getLostNumber.size();i++){
            for(int j=0;j< getReserveNumber.size();j++){
                if(getLostNumber.get(i)== getReserveNumber.get(j)){
                    getLostNumber.remove(i);
                    getReserveNumber.remove(j);
                    i--;
                    break;
                }
            }
        }
        for(int i=0;i<getLostNumber.size();i++){
            for(int j=0;j<getReserveNumber.size();j++){
                if(getLostNumber.get(i).equals(getReserveNumber.get(j)) || getLostNumber.get(i) == getReserveNumber.get(j)-1 || getLostNumber.get(i) == getReserveNumber.get(j)+1){
                    getLostNumber.remove(i);
                    getReserveNumber.remove(j);
                    i--;
                    break;
                }
            }
        }
        allNumber = allNumber-getLostNumber.size();
        System.out.println(allNumber);

    }
    private static int[] lostCheck(String lost){    //도난당한 학생의 배열 정리하는 메소드
        int count =0;
        for(int i=0;i<lost.length();i++){
            if(lost.charAt(i)=='[' || lost.charAt(i)==']' || lost.charAt(i)==',') {
                continue;
            }
            else{
                count++;
            }
        }
        int[] lostnumber = new int[count];
        count=0;
        for(int i=0;i<lost.length()-1;i++){
            if(lost.charAt(i)=='[' || lost.charAt(i)==']' || lost.charAt(i)==',') {
                continue;
            }
            else{
                lostnumber[count]=Integer.parseInt(lost.substring(i,i+1));
                count++;
            }
        }
        return lostnumber;

    }
    private static int[] reserveCheck(String reserve){      //여분의 운동복를 가지고 있는 학생의 배열을 정리하여 저장하는 메소드
        int count =0;
        for(int i=0;i<reserve.length();i++){
            if(reserve.charAt(i)=='[' || reserve.charAt(i)==']' || reserve.charAt(i)==',') {
                continue;
            }
            else{
                count++;
            }
        }
        int[] reservenumber = new int[count];
        count=0;
        for(int i=0;i<reserve.length()-1;i++){
            if(reserve.charAt(i)=='[' || reserve.charAt(i)==']' || reserve.charAt(i)==',') {
                continue;
            }
            else{
                reservenumber[count]=Integer.parseInt(reserve.substring(i,i+1));
                count++;
            }
        }
        return reservenumber;
    }
}
