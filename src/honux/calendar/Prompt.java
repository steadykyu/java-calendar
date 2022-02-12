package honux.calendar;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Prompt {

    public void printMenu () {
        System.out.println(
                "+----------------------+\n" +
                        "| 1. 일정 등록           \n" +
                        "| 2. 일정 검색           \n" +
                        "| 3. 달력 보기\n" +
                        "| h. 도움말 q. 종료\n" +
                        "+----------------------+");
    }
    public int parseDay(String week){
      switch(week) {
          case "su":
              return 0;
//              break; 메서드에서는 return하면 메서드 밖으로 나가기 때문에, break문이 필요없다.오히려 에러남.
          case "mo":
              return 1;

          case "tu":
              return 2;

          case "we":
              return 3;

          case "th":
              return 4;

          case "fr":
              return 5;

          case "sa":
              return 6;

          default:
              System.out.println("잘못 입력된 값입니다.");
              return 99;
      }
    }

    public void runPrompt() {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();

        while (true){
            System.out.println("명령(1, 2, 3, h, q)");
            String cmd = scanner.next();
            if(cmd.equals("1")) cmdRegister(scanner, cal);
            else if(cmd.equals("2")) cmdSearch(scanner, cal);
            else if(cmd.equals("3")) cmdCal(scanner, cal);
            else if(cmd.equals("h")) printMenu();
            else if(cmd.equals("q")) break;
            else System.out.println("잘못된 값 입력입니다.");;
        }
        System.out.println("Bye");
        scanner.close();
    }
    private void cmdCal(Scanner s, Calendar cal) {
            int year = 2000;
            int month = 1;
            System.out.println("년도를 입력하세요");
            System.out.print("Year> ");
            year = s.nextInt();
            System.out.println("달을 입력하세요");
            System.out.print("MONTH> ");
            month = s.nextInt();
            if(month > 12 || month < 1){
                System.out.println("잘못된 입력입니다.");
                return;                                 //리턴으로 함수를 종료시킬 수 있다.
            }
            cal.printSampleCalendar(year ,month);
    }


    private void cmdSearch(Scanner s, Calendar c) {
        System.out.println("[일정 검색]");
        System.out.println("날짜를 입력하세요");
        String date = s.next();
        String plan = null;
        try {
            plan = c.searchPlan(date);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("일정 검색중 오류가 발생했습니다.");
        }
        System.out.println(plan);
    }
    // next는 공백을 기준으로 문자를 가져옴. nextLine은 한 라인을 가져옴.
    // next 다음에 공백구간이 존재 같다. nextMethodTest 확인.
    private void cmdRegister(Scanner s, Calendar c) {
        System.out.println("[일정 등록] 날짜를 입력하세요(yyyy-MM-dd).");
        String date = s.next();
        String schedule = "";
        s.nextLine(); // ignore one newline (바로 schdule에 nextLine() 하니까 공백이 들어감. next()로 값넣은 후에. 공백이 있나봄.)
        System.out.println("일정을 입력하세요");
        schedule = s.nextLine();
        try {
            c.registerPlan(date,schedule);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("일정이 등록되었습니다.");
    }

    public static void main(String[] args) {
            Prompt prompt = new Prompt();
            prompt.runPrompt();
    }
}
