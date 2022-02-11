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
    //그레고리력 기준으로 첫일(인덱스) 찾기
    // 특정 년도의 1월 1일의 요일에서 그 다음 년도의 1월 1일의 요일은 평년일 때 1일, 윤년일 때 2일 오른쪽으로 이동한다.
    // 첫 표준 그레고리력의 1583년 1월 1일은 토요일이다.
   public int findJanFirstday(int year){
       int sum = 0;
       int firstday;
       int standardDay = 6;                 // 첫날 토요일이라 6(인덱스)로 시작.
        for(int i = 1583; i < year; i++){
            if(isLeapYear(i)){
                sum += 2;
            }else {
                sum += 1;
            }
        }
        firstday = (standardDay+sum) % 7;
       System.out.println(firstday);
        return firstday;
    }
    //특정 월의 1일의 요일에서 그 다음 월의 1일의 요일은 해당 월의 총 일수를 7로 나눈 나머지만큼 오른쪽으로 이동한다.
    //이동한만큼의 일수 찾기.
    public int plusfirstDay(int year, int month){
       int sum = 0;
       int plusday;
       for(int i = 1; i < month; i++){
           sum += getMaxDaysOfMonth(year,i);
       }
       plusday = sum % 7;
        System.out.println(plusday);
       return plusday;
    }


    public int getMaxDaysOfMonth(int year, int month) {
        if (isLeapYear(year)){
            return LEAP_MAX_DAYS[month -1];
        } else{
            return MAX_DAYS[month - 1];
        }

    }

    public void printSampleCalendar(int year, int month) {
        System.out.printf("    <<%4d년%3d월>>\n",year,month);
        System.out.println("  SU MO TU WE TH FR SA");
        System.out.println("--------------------");
        int monthFirstDay = (findJanFirstday(year) + plusfirstDay(year,month)) % 7;
        //pring blank space
        for(int i = 0; i < monthFirstDay ; i++){
            System.out.print("   ");
        }

        //print first line
        int count = 7 - monthFirstDay;
        for(int i = 1; i <= count; i++){
            System.out.printf("%3d",i);
        }
        System.out.println("");
        //print second line to last
        int maxDay = getMaxDaysOfMonth(year, month);
        int linecount = 0;
        for(int i = count + 1; i <= maxDay ; i++){
            System.out.printf("%3d",i);
            linecount++;
            if(linecount % 7 == 0)
                System.out.println();
        }
        System.out.println("");
        System.out.println("");
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

