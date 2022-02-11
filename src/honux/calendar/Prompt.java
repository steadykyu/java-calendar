package honux.calendar;

import java.util.Scanner;

public class Prompt {
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

        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();

        int month = -1;
        int year = -1;
        int weekday = 0;
        while (true) {
            System.out.println("년도를 입력하세요");
            System.out.print("Year> ");
            year = scanner.nextInt();
            System.out.println("달을 입력하세요");
            System.out.print("MONTH> ");
            month = scanner.nextInt();
            if(month == -1){
                break;
            }
            if(month > 12){
                continue;
            }
            cal.printSampleCalendar(year ,month);
        }
    }

    public static void main(String[] args) {
            Prompt prompt = new Prompt();
            prompt.runPrompt();
    }
}
