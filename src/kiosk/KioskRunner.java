package kiosk;

import java.util.Scanner;

public class KioskRunner {
    public static void main(String[] args) {
        IO io = new IO();
        Kiosk kiosk = new Kiosk();
        Scanner sc = new Scanner(System.in);





        KioskPage currentPage = KioskPage.StartPage; // 키오스크 초기 화면으로 시작


        while(true) { // 키오스크는 항상 실행
            currentPage.display();

            String input = sc.next().trim();
            currentPage = currentPage.runProcess(input);


        }

    }
}
