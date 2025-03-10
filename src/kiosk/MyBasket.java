package kiosk;

import java.util.*;

class basketForm {



    private String selectMenuName; // 선택된 메뉴의 이름
    private int quantity; // 주문 수량
    private int price; // 가격 ( 1개 가격 * 수량 )

    // 생성자
    basketForm(String selectMenuName, int quantity, int price) {
        this.selectMenuName = selectMenuName;
        this.quantity = quantity;
        this.price = price;
    }

    // 주문 수량 조절
    public void controlQuantity(int quantity) {
        this.quantity = quantity;
        this.price = this.quantity * this.price;
    }

    @Override
    public String toString() { // 해시태그 출력 방지
        return selectMenuName + " " + quantity + "ea " + price + "원";
    }

    // 장바구니 메뉴 별 가격 게터
    public int getPrice() {
        return this.price;
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

    // 장바구니에 메뉴 추가하기 ( 중복 될 경우 quantity +1 )
    public void addBasketList(basketForm form) {
       for (basketForm basket : basketList) {
           if(basket.getSelectMenuName().equals(form.getSelectMenuName())) {
               basket.controlQuantity(basket.getQuantity() + 1);
               return;
           }
       }
        basketList.add(form);
    }

    @Override
    public boolean equals(Object obj) {
        return (this == obj);
    }

    // "mod"를 입력받으면 편집기능 실행 ( 구매수량 조절, 삭제 )
    public void basketModify(String mod) {
        if (mod.equals("mod")) {
            System.out.println("수량 수정을 원하는 메뉴의 번호를 입력해 주세요.");
                    int num = sc.nextInt();
                    if (num < 0 || num > basketList.size()) { // 장바구니에 해당 번호가 존재하지 않으면 안내문 출력
                        System.out.println("해당 번호는 존재하지 않습니다.");
                    } else if (num < basketList.size()) {
                        System.out.println("수량을 바꾸시길 원한다면 정수를, 삭제를 원하신다면 'x'를 입력해 주세요.");
                        System.out.println("수량은 메뉴별로 최대 9개까지 가능합니다.");
                        Character num2 = sc.next().trim().charAt(0);
                        if (num2.equals('x')) { // 'x'입력시 리스트에서 삭제
                            basketList.remove(num);
                        } else { // 정수 입력시 수량 및 가격 초기화
                            basketList.get(num).controlQuantity(num2 - '0');
                        }
                    }
            }
        }


    // 장바구니 메뉴 총 금액 구하기
    public int basketTotalPrice() {
       return basketList.stream().map(x -> x.getPrice()).reduce(0, (x, y) -> x + y);
    }
}
