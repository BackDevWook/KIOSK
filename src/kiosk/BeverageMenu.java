package kiosk;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public enum BeverageMenu {

    //메뉴명(초기 재고, 가격, 예상 소요 시간(분))
    팔성_사이다(500, 2000, 0),
    제로_확씨(500, 2000, 0),
    레드_와인(200, 8000, 5),
    화이트_와인(200, 8000, 5),
    백년된_위스키(20, 88000, 3);

    private final int earlyStock;
    private final int price;
    private final int cookTime;

    // 생성자
    BeverageMenu(int earlyStock, int price, int cookTime) {
        this.earlyStock = earlyStock;
        this.price = price;
        this.cookTime = cookTime;
    }

    // 게터
    public int getEarlyStock() {
        return earlyStock;
    }

    public int getCookTime() {
        return cookTime;
    }

    public int getPrice() {
        return price;
    }


}
