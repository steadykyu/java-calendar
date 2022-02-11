package honux.calendar;

import java.util.Scanner;

public class Prompt {
    public void runPrompt() {

        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();

        int month = -1;
        int year = -1;
        String day = "";
        while (true) {
            System.out.println("년도를 입력하세요");
            System.out.print("Year> ");
            year = scanner.nextInt();
            System.out.println("달을 입력하세요");
            System.out.print("MONTH> ");
            month = scanner.nextInt();
            System.out.println("첫째 날의 요일을 입력하세요");
            System.out.print("WEEKDAY> ");
            day = scanner.next();
            if(month == -1){
                break;
            }
            if(month > 12){
                continue;
            }
            cal.printSampleCalendar(year ,month,day);
        }
    }

    public static void main(String[] args) {
            Prompt prompt = new Prompt();
            prompt.runPrompt();
    }
}
