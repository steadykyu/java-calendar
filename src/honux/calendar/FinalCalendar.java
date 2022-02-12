package honux.calendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class FinalCalendar {

    public void promptformat(){
        System.out.printf("> ");
    }
    public void printMenuEx (){
        ArrayList<String> scheduleDay = new ArrayList<>();
        ArrayList<String> scheduleList = new ArrayList<>();
        HashMap<String,String> schedule = new HashMap<>();
        System.out.println(
                "+----------------------+\n" +
                        "| 1. 일정 등록           \n" +
                        "| 2. 일정 검색           \n" +
                        "| 3. 달력 보기\n" +
                        "| h. 도움말 q. 종료\n" +
                        "+----------------------+");
        while(true) {
            System.out.println("명령 (1, 2, 3, h, q)");
            promptformat();
            Scanner scanner = new Scanner(System.in);
            String command = scanner.next();
            if (command.equals("1")) {
                System.out.println("[일정 등록] 날짜를 입력하세요.");
                String putday = scanner.next();
                scheduleDay.add(putday);
                System.out.println("");
                System.out.println("일정을 입력하세요");
                String putschedule = scanner.next();
                scheduleList.add(putschedule);
                System.out.println("일정이 등록되었습니다.");
                System.out.println("");
                schedule.put(putday, putschedule);
            } else if (command.equals("2")) {
                System.out.println("날짜를 입력하세요");
                String dayPut = scanner.next();
                if (scheduleDay.contains(dayPut)) {
                    System.out.println("1개의 일정이 있습니다.");
                    System.out.println(schedule.get(dayPut));
                } else {
                    System.out.println("Bye");
                }
            } else if(command.equals("q")) {
                System.out.println("일정프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 명령입니다.");
            }
        }
    }
}
