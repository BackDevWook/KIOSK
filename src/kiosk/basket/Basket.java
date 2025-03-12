package kiosk.basket;

import java.util.*;

public class Basket {
    Scanner sc = new Scanner(System.in);

    private List<BasketForm> basketList; // 장바구니 담은 메뉴들을 보관할 리스트

    // 생성자
    public Basket() {
        this.basketList = new ArrayList<>();
    }

    // 장바구니 리스트 출력을 위한 게터
    public List<BasketForm> getBasketList() {
        return basketList;
    }

    // 장바구니에 메뉴 추가하기 ( 중복 될 경우 quantity +1 )
    public void addBasketList(BasketForm form) {
        for (BasketForm basket : basketList) {
            if (basket.getSelectMenuName().equals(form.getSelectMenuName())) {
                basket.controlQuantity(basket.getQuantity() + 1);
                return;
            }
        }
        basketList.add(form);
    }

    // "mod"를 입력받으면 편집기능 실행 ( 구매수량 조절, 삭제 )
    public void basketModify(String mod) {
        while (true) {
            if (mod.equals("mod")) {
                System.out.println("수량 수정을 원하는 메뉴의 번호를 입력해 주세요.");
                int num = 0;
                try {
                    num = sc.nextInt();
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("잘못 입력하셨습니다.");
                    sc.nextLine();
                    continue;
                }
                if (num < 0 || num > basketList.size()) { // 장바구니에 해당 번호가 존재하지 않으면 안내문 출력
                    System.out.println("해당 번호는 존재하지 않습니다.");
                    continue;
                } else if (num < basketList.size()) {
                    System.out.println("수량을 바꾸시길 원한다면 정수를, 삭제를 원하신다면 'x'를 입력해 주세요.");
                    System.out.println("수량은 메뉴별로 최대 9개까지 가능합니다.");
                    while (true) {
                        String answer = sc.nextLine().trim(); //
                        Character c = answer.charAt(0);
                        // 10 이상 입력하면 1로 인식되는 점 수정 요망
                        if (answer.length() != 1) {
                            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
                            continue;
                        } else if (c.equals('x')) { // 'x'입력시 리스트에서 삭제
                            basketList.remove(num);
                        } else if (Character.isDigit(c)) { // 범위 내 정수 입력시 수량 및 가격 초기화
                            basketList.get(num).controlQuantity(c - '0');
                        } else { // Character 변수인 num2 에 대해 아스키 코드가 입력되는 것을 경우 방지
                            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
                            continue;
                        }
                        break; // 코드가 정상 실행이 될 경우 반복문 탈출
                    }
                }
            }
            break; // 코드가 한 번 정상적으로 실행 됬을 경우 반복문을 빠져나오기
    }   }

    // 장바구니 메뉴 총 금액 구하기
    public int basketTotalPrice() {
        return basketList.stream().map(x -> x.getTotalPrice()).reduce(0, (x, y) -> x + y);
    }
}
