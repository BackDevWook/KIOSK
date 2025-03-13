package kiosk.basket;

public class BasketForm {

    private String selectMenuName; // 선택된 메뉴의 이름
    private int quantity; // 주문 수량
    private int price; // 가격 ( 1개 가격 * 수량 )
    private int totalPrice; // 수량 x 가격

    // 생성자
    public BasketForm(String selectMenuName, int quantity, int price) {
        this.selectMenuName = selectMenuName; // 선택한 메뉴 이름
        this.quantity = quantity; // 양
        this.price = price; // 1개 가격
        this.totalPrice = price; // 주문한 수량만큼의 총 가격
    }

    // 주문 수량 조절
    public void controlQuantity(int quantity) {
        this.quantity = quantity;
        this.totalPrice = price * quantity;
    }

    @Override
    public String toString() { // 해시태그 출력 방지
        return selectMenuName + " " + quantity + "ea " + totalPrice + "원";
    }

    // 장바구니 메뉴 수량에 따른 합산된 가격 게터
    public int getTotalPrice() {
        return this.totalPrice;
    }

    // 장바구니 메뉴 별 수량 게터
    public int getQuantity() {
        return this.quantity;
    }

    // 장바구니 메뉴 이름 게터
    public String getSelectMenuName() {
        return selectMenuName;
    }

}
