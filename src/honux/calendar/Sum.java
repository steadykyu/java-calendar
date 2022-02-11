package honux.calendar;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        int a, b;
        Scanner scanner = new Scanner(System.in);
        String s1, s2;
        s1 = scanner.next();
        s2 = scanner.next();
        a = Integer.parseInt(s1);
        b = Integer.parseInt(s2);

        System.out.printf("%d와 %d의 합은 %d입니다.",a,b,a + b);
        scanner.close();    //닫는 습관을 가지는 것이 좋다.
    }
}
