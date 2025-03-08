package kiosk;

import java.util.LinkedHashMap;
import java.util.Map;

public class MenuManagement {

    // 메뉴와 메뉴 번호 값을 매겨줄 컬렉션
    private Map<String, Integer> beverNumber = new LinkedHashMap<>();
    private Map<String, Integer> sideNumber = new LinkedHashMap<>();
    private Map<String, Integer> singleNumber = new LinkedHashMap<>();

    // 메뉴 번호 매기기
    public void menuNumbering() {
        // 음료 메뉴 번호 매기기
        for(BeverageMenu beverage : BeverageMenu.values()) {
            beverNumber.put(beverage.name(), beverage.ordinal());
        }

        // 단품 메뉴 번호 매기기
        for(SingleMenu single : SingleMenu.values()) {
            sideNumber.put(single.name(), single.ordinal());
        }

        // 사이드 메뉴 번호 매기기
        for(SideMenu side : SideMenu.values()) {
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
    public static String findMenu(Integer input, Map<String, Integer> menuNumbers) {
        for (Map.Entry<String, Integer> entry : menuNumbers.entrySet()) {
            if(entry.getValue().equals(input)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
