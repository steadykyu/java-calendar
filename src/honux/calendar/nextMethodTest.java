package honux.calendar;

import java.util.Scanner;

public class nextMethodTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String date = s.next();
        String text = s.nextLine(); //자동으로 공백을 입력함;
        System.out.println(text);

//        while (true){
//            String word = s.next();
//            text += word + " ";
//            System.out.println(text);
//            if (word.endsWith(";")){
//                break;
//            }
//        }
    }
}
