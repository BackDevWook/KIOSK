package kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

class basketForm {

    private String selectMenuName; // 선택된 메뉴의 이름
    private int quantity; // 주문 수량
    private int price; // 가격 ( 1개 가격 * 수량 )

    basketForm() {}

    // 생성자
    basketForm(String selectMenuName, int quantity, int price) {
        this.selectMenuName = selectMenuName;
        this.quantity = 1;
        this.price = price * quantity;
    }

    // 주문 수량 조절
    public void controlQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return selectMenuName + " " + quantity + "ea " + price + "원";
    }
}
public class MyBasket {
    Scanner sc = new Scanner(System.in);

    private List<basketForm> basketList; // 장바구니 담은 메뉴들을 보관할 리스트

    // 생성자
    MyBasket() {
        this.basketList = new ArrayList<>();
    }

    // 장바구니 리스트 출력을 위한 게터
    public List<basketForm> getBasketList() {
        return basketList;
    }

    // 장바구니에 메뉴 추가하기
    public void addBasketList(basketForm basketForm) {
        basketList.add(basketForm);
    }


}
