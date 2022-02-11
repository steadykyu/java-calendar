package honux.calendar;

public class Calendar {

    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public boolean isLeapYear(int year){
        if(year % 4 ==0 && (year % 100 !=0 || year % 400 == 0) ){
            return true;
        }
        else
            return false;
    }

    public int getMaxDaysOfMonth(int year, int month) {
        if (isLeapYear(year)){
            return LEAP_MAX_DAYS[month -1];
        } else{
            return MAX_DAYS[month - 1];
        }

    }

    public void printSampleCalendar(int year, int month, String day) {
        System.out.printf("    <<%4d년%3d월>>\n",year,month);
        System.out.println("  SU MO TU WE TH FR SA");
        System.out.println("--------------------");

        int maxDay = getMaxDaysOfMonth(year, month);
        for(int i = 1; i <= maxDay ; i++){
            System.out.printf("%3d",i);
            if(i % 7 == 0)
                System.out.println();
        }
        System.out.println("");
//        System.out.println("1   2   3   4   5   6   7");
//        System.out.println("8   9  10  11  12  13  14");
//        System.out.println("15 16  17  18  19  20  21");
//        System.out.println("22 23  24  25  26  27  28");
    }
}




//    public static void main(String[] args) {
//        //숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
//        Scanner scanner = new Scanner(System.in);
//        String s1 = scanner.next();
//        int month = Integer.parseInt(s1);
//        switch (month){
//            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
//                System.out.printf("%d월 의 최대 일수는 31일 입니다.",month);
//                break;
//            case 2:
//                System.out.printf("%d월 의 최대 일수는 28일 입니다.",month);
//                break;
//            case 4: case 6: case 9: case 11:
//                System.out.printf("%d월 의 최대 일수는 30일 입니다.",month);
//                break;
//            default:
//                System.out.printf("잘못 입력된 값입니다.");
//        }
//        scanner.close();
//    }

