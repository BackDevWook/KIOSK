package kiosk.main;

import kiosk.KioskPage;
import kiosk.KioskPower;

import java.util.Scanner;

public class KioskRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 스캐너
        KioskPage currentPage = KioskPage.StartPage; // 키오스크 초기 화면으로 시작


        while(true) { // 키오스크는 항상 실행

            if(!KioskPower.getIsPower()) { // 전원을 끄면 키오스크 종료
                break;
            }

            currentPage.display(); // 화면 출력

            // 페이지 출력
            String input = sc.next().trim(); // 각 페이지에서 인풋을 전달받아 기능 수행
            currentPage = currentPage.runProcess(input); // 인풋을 통해 기능이 수행이 되면 해당 페이지로 전환

        }

    }
}
