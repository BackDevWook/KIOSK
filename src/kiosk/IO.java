package kiosk;

import menu.BeverageMenu;
import menu.SideMenu;
import menu.SingleMenu;

import java.util.List;
import java.util.Map;

public class IO {
     // 장바구니 출력을 위한 클래스 호출

    // 키오스크 시작 문구
    public void displayKioskStart() {
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("미슐랭 ★★★              ∇ 심 연 ∇            |괴식 다이닝|");
        System.out.println(" \n                        [시작하기]  \n");
        System.out.println("롯데 시그니엘 24년 총주방장 경력 \"김하늘\" 쉐프의 소문난 레스토랑!");
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("\"start\"를 입력해 주세요.");
        System.out.println("\"cancel\" 입력시 초기 화면으로 돌아갈 수 있습니다.");
        System.out.println("\"back\" 입력시 전 화면으로 돌아갈 수 있습니다. (결제 완료 후 불가능)");
    }

    // 키오스크 기능 설명 문구
    public void displayKioskExplanation() {

    }
    // 키오스크 (매장식사, 포장하기) 선택 문구
    public void displaySelectHow() {
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("\n\n                [매장식사]   [포장하기] \n\n");
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("매장에서 식사를 원하시는 분은 \"hall\"를, 포장을 원하신다면 \"takeout\"를 입력해 주세요.");
    }

    // 단품 메뉴 선택 화면
    // 1.] 대충메뉴이름이나오는곳 - 가격 - 예상소요시간
    public void displaySingleMenu() {
        System.out.println("────────────────────────────────────────────────────────");
        for (SingleMenu menu : SingleMenu.values()) {
            System.out.println(menu.ordinal() + ".] " + menu.name() + " - " + menu.getPrice() + "원 - " + menu.getCookTime() + "분" );
        }
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("주문하실 음식의 번호를 입력해주세요.");
        System.out.println("장바구니로 가시고 싶다면 basket을 입력해 주세요.");
        System.out.println("\"<\", \">\" , \"bever\", \"side\"로 페이지를 바꿀 수 있습니다.");
        System.out.println("────────────────────────────────────────────────────────");
    }
    // 음료 메뉴 선택 화면
    public void displayBeverageMenu() {
        System.out.println("────────────────────────────────────────────────────────");
        for (BeverageMenu menu : BeverageMenu.values()) {
            System.out.println(menu.ordinal() + ".] " + menu.name() + " - " + menu.getPrice() + "원 - " + menu.getCookTime() + "분" );
        }
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("주문하실 음식의 번호를 입력해주세요.");
        System.out.println("장바구니로 가시고 싶다면 basket을 입력해 주세요.");
        System.out.println("\"<\", \">\" , \"single\", \"side\"로 페이지를 바꿀 수 있습니다.");
        System.out.println("────────────────────────────────────────────────────────");
    }
    // 사이드 메뉴 선택 화면
    public void displaySideMenu() {
        System.out.println("────────────────────────────────────────────────────────");
        for (SideMenu menu : SideMenu.values()) {
            System.out.println(menu.ordinal() + ".] " + menu.name() + " - " + menu.getPrice() + "원 - " + menu.getCookTime() + "분" );
        }
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("주문하실 음식의 번호를 입력해주세요.");
        System.out.println("장바구니로 가시고 싶다면 basket을 입력해 주세요.");
        System.out.println("\"<\", \">\" , \"single\", \"bever\"로 페이지를 바꿀 수 있습니다.");
        System.out.println("────────────────────────────────────────────────────────");
    }

    // 메뉴 주문 확정 or 장바구니 담기 선택 화면
    public void displayCheckOrder() {
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("바로 주문을 원하신다면 \"order\"를 입력해 주세요.");
        System.out.println("장바구니에 담으시려면 \"keep\"을 입력해 주세요.");
        System.out.println("────────────────────────────────────────────────────────");
    }
    // 선택한 메뉴가 무엇인지 보여주기
    public void yourSelect(String menuName, int price) {
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("선택 하신 메뉴 : " + menuName);
        System.out.println("금액 : " + price + "원");
        System.out.println("────────────────────────────────────────────────────────");
    }
    // 장바구니 목록
    public void displayMyBasket() {
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("                      <장바구니 목록>                     ");
        for(int i = 0; i < KioskPage.basket.getBasketList().size(); i++) {
            System.out.println( i + ".] " + KioskPage.basket.getBasketList().get(i));
        }
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("메뉴 편집을 원하시면 \"mod\"를 입력해 주세요.");
        System.out.println("장바구니의 메뉴를 주문하시려면 \"order\"를 입력해 주세요.");
    }

    // 결제 화면 - SINGLE
    public void displayPaymentSINGLE() {
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println();
        System.out.println();
        System.out.println("               [카드결제]         [현금결제]               ");
        System.out.println();
        System.out.println();
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("결제 방식을 선택해 주세요. [카드 : card] , [현금 : bill] 입력");
    }

    // 결제 화면 - BASKET
    public void displayPaymentBASKET() {
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println();
        System.out.println();
        System.out.println("               [카드결제]         [현금결제]               ");
        System.out.println();
        System.out.println();
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("결제 방식을 선택해 주세요. [카드 : card] , [현금 : bill] 입력");
    }
    // 현금 결제 선택 시
    public void displayBillPayment() {
        System.out.println("카운터로 가서 다시 주문하세요 ^-^");
    }

    // 영수증 출력 유무 화면
    public void displaySelectReceipt() {
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println();
        System.out.println("                영수증을 출력 하시겠습니까?");
        System.out.println();
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("출력을 원하신다면 \"yes\" 아니라면 \"no\"를 입력해 주세요.");
    }
    // 영수증 화면 - SINGLE
    public void displayReceiptSINGLE(int totalPrice, Map<String, Integer> orderList) {
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("                        [영수증]                         ");
        for(String menu : orderList.keySet()) {
            System.out.println("[" + menu + "] " + orderList.get(menu) + "ea");
        }
        System.out.println();
        System.out.println("주문 금액 : " + totalPrice + "원");
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("\"check\"를 입력해 주세요.");
    }

    // 영수증 화면 - BASKET
    public void displayReceiptBASKET(int totalPrice, List<basketForm> list) {
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("                        [영수증]                         ");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(i + ".] " + list.get(i));
        }
        System.out.println();
        System.out.println("주문 금액 : " + totalPrice + "원");
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("\"check\"를 입력해 주세요.");
    }


}
