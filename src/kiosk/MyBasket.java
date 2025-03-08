package kiosk;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyBasket {


    // 사용자가 장바구니에 담은 메뉴와 수량을 저장하는 맵
    public Map<Integer, Integer> basketList = new LinkedHashMap<>();

    public void changeQuantity(int menuNumber, int quantity) { // 장바구니 수량 변경 혹은 삭제
        basketList.put(menuNumber, quantity);
    }

    public void changeQuantity(int menuNumber, char x) { // 메뉴 번호와 x 입력시 메뉴 삭제
        basketList.remove(menuNumber);
    }


}
