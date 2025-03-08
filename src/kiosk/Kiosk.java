package kiosk;

import java.util.Scanner;

public class Kiosk {
    IO io = new IO();

    // "시작하기" 입력시 식사 방법 선택 화면으로 이동
    public void kioskStartToSelect(String input) {
        io.displaySelectHow();
    }
    // "cancel" 입력 시 초기 화면으로 돌아가기

    // "매장식사" 또는 "포장하기" 입력시 메뉴 선택 화면으로 이동

    // "<", ">" 혹은 메뉴 카테고리 입력 시 해당 메뉴 목록으로 이동

    // 메뉴 선택 시 주문할 수량을 선택하기

    // 주문할 수량을 선택하면 바로 주문할지, 장바구니에 담을지 선택하기

    // 뒤로 가기

    // 결제 화면 띄우기

}
