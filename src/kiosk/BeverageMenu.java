package kiosk;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public enum BeverageMenu {

    //메뉴명(초기 재고, 가격, 예상 소요 시간(분))
    팔성_사이다( 2000, 0),
    제로_확씨( 2000, 0),
    레드_와인( 8000, 5),
    화이트_와인(8000, 5),
    백년된_위스키( 88000, 3);

    private final int price;
    private final int cookTime;

    // 생성자
    BeverageMenu(int price, int cookTime) {
        this.price = price;
        this.cookTime = cookTime;
    }

    // 게터

    public int getCookTime() {
        return cookTime;
    }

    public int getPrice() {
        return price;
    }


}
