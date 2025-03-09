package kiosk;

import java.util.LinkedHashMap;
import java.util.Map;

public class MenuManagement {

    // 메뉴와 메뉴 번호 값을 매겨줄 컬렉션
    private Map<String, Integer> beverNumber = new LinkedHashMap<>();
    private Map<String, Integer> sideNumber = new LinkedHashMap<>();
    private Map<String, Integer> singleNumber = new LinkedHashMap<>();

    // 메뉴 카테고리별 가격 게터
    public int getBeverPrice(int number) {
        for (BeverageMenu menu : BeverageMenu.values()) {
            if (number == menu.ordinal()) {
                return menu.getPrice();
            }
        }
        return -1;
    }
    public int getSinglePrice(int number) {
        for (SingleMenu menu : SingleMenu.values()) {
            if (number == menu.ordinal()) {
                return menu.getPrice();
            }
        }
        return -1;
    }
    public int getSidePrice(int number) {
        for (SideMenu menu : SideMenu.values()) {
            if (number == menu.ordinal()) {
                return menu.getPrice();
            }
        }
        return -1;
    }

    // 메뉴 번호 매기기
    public void menuNumbering() {
        // 음료 메뉴 번호 매기기
        for(BeverageMenu beverage : BeverageMenu.values()) {
            beverNumber.put(beverage.name(), beverage.ordinal());
        }

        // 사이드 메뉴 번호 매기기
        for(SideMenu single : SideMenu.values()) {
            sideNumber.put(single.name(), single.ordinal());
        }

        // 단품 메뉴 번호 매기기
        for(SingleMenu side : SingleMenu.values()) {
            singleNumber.put(side.name(), side.ordinal());
        }
    }

    // 맵 게터
    public Map<String, Integer> getSingleNumber() {
        return singleNumber;
    }

    public Map<String, Integer> getSideNumber() {
        return sideNumber;
    }

    public Map<String, Integer> getBeverNumber() {
        return beverNumber;
    }

    // 주문한 번호와 일치한 메뉴 찾기
    public String findMenu(Integer input, Map<String, Integer> menuNumbers) {
        for (Map.Entry<String, Integer> entry : menuNumbers.entrySet()) {
            if(entry.getValue().equals(input)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
