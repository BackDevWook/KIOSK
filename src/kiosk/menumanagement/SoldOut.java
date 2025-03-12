package kiosk.menumanagement;

import menu.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SoldOut { // 메뉴 품절 상태 관리
    Scanner sc = new Scanner(System.in); // 품절할 메뉴 입력에 쓸 스캐너

    /* true 일 경우 주문 가능
       false 일 경우 품절  */

    // 메뉴 별 품절 여부를 체크할 맵
    private static Map<String, Boolean> isSoldout;

    // 맵 게터
    public Map<String, Boolean> getIsSoldout() {
        return isSoldout;
    }

    // 생성자
    public SoldOut() {
        isSoldout = new HashMap<>();
        menuIntoIsSoldOut();
    }

    // 현재 있는 메뉴들을 맵 안에 넣기
    private void menuIntoIsSoldOut() {
        for (BeverageMenu menu : BeverageMenu.values()) {
            isSoldout.put(menu.name(), Boolean.TRUE);
        }
        for (SingleMenu menu : SingleMenu.values()) {
            isSoldout.put(menu.name(), Boolean.TRUE);
        }
        for (SideMenu menu : SideMenu.values()) {
            isSoldout.put(menu.name(), Boolean.TRUE);
        }
    }

    // 메뉴 on/off
    public void menuOnOff() {
        String menuName = sc.nextLine().trim();
        if (isSoldout.get(menuName)) {
            isSoldout.put(menuName, false);
        } else {
            isSoldout.put(menuName, true);
        }
    }


}
