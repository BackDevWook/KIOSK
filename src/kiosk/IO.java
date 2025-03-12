package kiosk;

import kiosk.basket.BasketForm;
import kiosk.menumanagement.Sale;
import kiosk.menumanagement.SoldOut;
import menu.BeverageMenu;
import menu.SideMenu;
import menu.SingleMenu;

import java.util.List;
import java.util.Map;

public class IO {
    SoldOut soldOut = new SoldOut();

    // 글씨 색 바꾸기
    String red = "\u001B[31m";
    String green = "\u001B[32m";
    String yellow = "\u001B[33m";
    String blue = "\u001B[34m";
    String reset = "\u001B[0m"; // 색상 초기화
    String purple = "\u001B[95m";
    String cyan = "\u001B[36m";
    String white = "\u001B[97m";
    String black = "\u001B[30m";


    // 키오스크 시작 문구
    public void displayKioskStart() {
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        System.out.println(yellow + "미슐랭 ★★★              ∇ 심 연 ∇            |괴식 다이닝|" + reset);
        System.out.println(green + " \n                        [시작하기]  \n" + reset);
        System.out.println(yellow + "롯데 시그니엘 24년 총주방장 경력 \"김하늘\" 쉐프의 소문난 레스토랑!" + reset);
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        System.out.println(green + "\"start\""+ reset + "를 입력해 주세요.");
        System.out.println(green + "\"cancel\"" + reset + "입력시 초기 화면으로 돌아갈 수 있습니다.");
        System.out.println(green + "\"back\"" + reset + " 입력시 전 화면으로 돌아갈 수 있습니다. (결제 완료 후 불가능)");
    }

    // 키오스크 (매장식사, 포장하기) 선택 문구
    public void displaySelectHow() {
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        System.out.println(blue +"\n\n                [매장식사]   [포장하기] \n\n" + reset);
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        System.out.println("매장에서 식사를 원하시는 분은 " + green + "\"hall\" " + reset + "를, 포장을 원하신다면 " + green + "\"takeout\"" + reset + "를 입력해 주세요.");
    }

    // 단품 메뉴 선택 화면
    // 1.] 대충메뉴이름이나오는곳 - 가격 - 예상소요시간
    public void displaySingleMenu() {
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        for (SingleMenu menu : SingleMenu.values()) {
            if(soldOut.getIsSoldout().get(menu.name())) {
                System.out.println(menu.ordinal() + ".] " + cyan + menu.name() + reset +  " - " + yellow + menu.getPrice() + "원" + reset + " - " + red + menu.getCookTime() + "분" + reset);
            } else {
                System.out.println("\u001B[9m" + menu.ordinal() + ".] "+ cyan + menu.name() + reset + " - " + yellow + menu.getPrice() + "원" + reset + " - " + red + menu.getCookTime() + "분\u001B[0m" + reset + blue + " - Sold out" + reset ); // 품절일시 취소선
            }
        }
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset + "       " + purple + "[적용 중인 할인코드 : " + KioskPage.getSaleCode() + "]" + reset);
        System.out.println("주문하실 음식의 번호를 입력해주세요.");
        System.out.println("장바구니로 가시고 싶다면 " + green + "\"basket\"" + reset + "을 입력해 주세요.");
        System.out.println(green + "\"<\", \">\" , \"bever\", \"side\"" + reset + "로 페이지를 바꿀 수 있습니다.");
        System.out.println(green + "\"sale\"" + reset + "을 입력하시면 할인 대상자 페이지로 넘어갑니다.");
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
    }

    // 음료 메뉴 선택 화면
    public void displayBeverageMenu() {
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        for (BeverageMenu menu : BeverageMenu.values()) {
            if(soldOut.getIsSoldout().get(menu.name())) {
                System.out.println(menu.ordinal() + ".] " + cyan + menu.name() + reset +  " - " + yellow + menu.getPrice() + "원" + reset + " - " + red + menu.getCookTime() + "분" + reset);
            } else {
                System.out.println("\u001B[9m" + menu.ordinal() + ".] "+ cyan + menu.name() + reset + " - " + yellow + menu.getPrice() + "원" + reset + " - " + red + menu.getCookTime() + "분\u001B[0m" + reset + blue + " - Sold out" + reset ); // 품절일시 취소선
            }
        }
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset + "           " + purple + "[적용 중인 할인코드 : " + KioskPage.getSaleCode() + "]" + reset);
        System.out.println("주문하실 음식의 번호를 입력해주세요.");
        System.out.println("장바구니로 가시고 싶다면 " + green + "\"basket\"" + reset + "을 입력해 주세요.");
        System.out.println(green + "\"<\", \">\" , \"single\", \"side\"" + reset + "로 페이지를 바꿀 수 있습니다.");
        System.out.println(green + "\"sale\"" + reset + "을 입력하시면 할인 대상자 페이지로 넘어갑니다.");
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
    }

    // 사이드 메뉴 선택 화면
    public void displaySideMenu() {
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        for (SideMenu menu : SideMenu.values()) {
            if(soldOut.getIsSoldout().get(menu.name())) {
                System.out.println(menu.ordinal() + ".] " + cyan + menu.name() + reset +  " - " + yellow + menu.getPrice() + "원" + reset + " - " + red + menu.getCookTime() + "분" + reset);
            } else {
                System.out.println("\u001B[9m" + menu.ordinal() + ".] "+ cyan + menu.name() + reset + " - " + yellow + menu.getPrice() + "원" + reset + " - " + red + menu.getCookTime() + "분\u001B[0m" + reset + blue + " - Sold out" + reset ); // 품절일시 취소선
            }
        }
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset + "           " + purple + "[적용 중인 할인코드 : " + KioskPage.getSaleCode() + "]" + reset);
        System.out.println("주문하실 음식의 번호를 입력해주세요.");
        System.out.println("장바구니로 가시고 싶다면 " + green + "\"basket\"" + reset + "을 입력해 주세요.");
        System.out.println(green + "\"<\", \">\" , \"single\", \"bever\"" + reset + "로 페이지를 바꿀 수 있습니다.");
        System.out.println(green + "\"sale\"" + reset + "을 입력하시면 할인 대상자 페이지로 넘어갑니다.");
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
    }

    // 메뉴 주문 확정 or 장바구니 담기 선택 화면
    public void displayCheckOrder() {
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        System.out.println("바로 주문을 원하신다면 " + green + "\"order\"" + reset + "를 입력해 주세요.");
        System.out.println("장바구니에 담으시려면 " + green + "\"keep\"" + reset + "을 입력해 주세요.");
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
    }

    // 선택한 메뉴가 무엇인지 보여주기
    public void yourSelect(String menuName, int price) {
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        System.out.println("선택 하신 메뉴 : " + cyan + menuName + reset);
        System.out.println("금액 : " + yellow + price + "원" + reset);
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
    }

    // 장바구니 목록
    public void displayMyBasket() {
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        System.out.println(blue + "                      <장바구니 목록>                     " + reset);
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        for (int i = 0; i < KioskPage.basket.getBasketList().size(); i++) {
            System.out.println(i + ".] " + cyan + KioskPage.basket.getBasketList().get(i) + reset);
        }
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        System.out.println("메뉴 편집을 원하시면 " + green + "\"mod\"" + reset + "를 입력해 주세요.");
        System.out.println("장바구니의 메뉴를 주문하시려면 " + green + "\"order\"" + reset + "를 입력해 주세요.");
    }

    // 결제 화면 - SINGLE
    public void displayPaymentSINGLE() {
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        System.out.println();
        System.out.println();
        System.out.println(blue + "               [카드결제]         [현금결제]               " + reset);
        System.out.println();
        System.out.println();
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        System.out.println("결제 방식을 선택해 주세요. " + blue + "[카드 : card] , [현금 : bill]" + reset + " 입력");
    }

    // 결제 화면 - BASKET
    public void displayPaymentBASKET() {
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        System.out.println();
        System.out.println();
        System.out.println(blue + "               [카드결제]         [현금결제]               " + reset);
        System.out.println();
        System.out.println();
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        System.out.println("결제 방식을 선택해 주세요. " + blue + "[카드 : card] , [현금 : bill]" + reset + " 입력");
    }

    // 현금 결제 선택 시
    public void displayBillPayment() {
        System.out.println("카운터로 가서 다시 주문하세요 ^-^");
    }

    // 영수증 출력 유무 화면
    public void displaySelectReceipt() {
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        System.out.println();
        System.out.println("                영수증을 출력 하시겠습니까?");
        System.out.println();
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        System.out.println("출력을 원하신다면 " + green + "\"yes\"" + reset + " 아니라면 " + green + "\"no\"" + reset + "를 입력해 주세요.");
    }

    // 영수증 화면 - SINGLE
    public void displayReceiptSINGLE(int totalPrice, Map<String, Integer> orderList, int saleCode) {
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        System.out.println(white + "                        [영수증]                         " + reset);
        for (String menu : orderList.keySet()) {
            System.out.println(cyan + "[" + menu + "] " + reset + white + orderList.get(menu) + "ea" + reset);
        }
        System.out.println();
        System.out.println(yellow + "주문 금액 : " + totalPrice + "원" + reset);
        if (saleCode != 0) {
            System.out.println(yellow + "할인된 금액 : " + (totalPrice * (100 - Sale.values()[saleCode].getSaleRatio())) / 100 + "원" + reset);
        }
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        System.out.println(green + "\"check\"" + reset + "를 입력해 주세요.");
    }

    // 영수증 화면 - BASKET
    public void displayReceiptBASKET(int totalPrice, List<BasketForm> list, int saleCode) {
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        System.out.println(white + "                        [영수증]                         " + reset);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ".] " + cyan + list.get(i) + reset);
        }
        System.out.println();
        System.out.println(yellow + "주문 금액 : " + totalPrice + "원" + reset);
        if (saleCode != 0) {
            System.out.println(yellow + "할인된 금액 : " + (totalPrice * (100 - Sale.values()[saleCode].getSaleRatio())) / 100 + "원" + reset);
        }
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        System.out.println(green + "\"check\"" + reset + "를 입력해 주세요.");
    }

    // 세일 화면
    public void displaySale() {
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);
        System.out.println("할인 대상에 해당될 경우 선택해 주세요. (기본 : " + purple + "일반인" + reset + ")");
        for (int i = 0; i < Sale.values().length; i++) {
            System.out.println(i + ".] " + purple + Sale.values()[i].name() + reset +  " " + yellow + Sale.values()[i].getSaleRatio() + "%" + reset);
        }
        System.out.println(cyan + "────────────────────────────────────────────────────────" + reset);

    }

    // 관리자 기능 화면
    public void displayManager() {
        System.out.println(black + "---------------------------------------------------------" + reset);
        System.out.println(purple + "                     || 관리자 기능 ||                     " + reset);
        System.out.println(blue);
        System.out.println("1.품절 관리");
        System.out.println("2.전원");
        System.out.println("3.착한 사람에게만 보인다는 전설의 버튼 ( 누르지 말 것 )" + reset);
        System.out.println(black + "---------------------------------------------------------" + reset);
        System.out.println("수행하실 기능의 " + green + "번호" + reset + "를 입력해 주세요.");
    }

    // 관리자 비밀번호 입력 화면
    public void displayManagerPassword() {
        System.out.println(green + "---------------------------------------------------------");
        System.out.println("                  비밀번호를 입력해 주세요.                  ");
        System.out.println("---------------------------------------------------------" + reset);
    }

    // 품절 기능 화면
    public void displaySoldOut() {
        System.out.println(black + "---------------------------------------------------------" + reset);
        for(Map.Entry<String, Boolean> entry : soldOut.getIsSoldout().entrySet()) {
            System.out.println("|| " + cyan + entry.getKey() + " - " + entry.getValue() + reset);
        }
        System.out.println(black + "---------------------------------------------------------" + reset);
        System.out.println(green + "\"so\"" + reset + "를 입력하시면 편집모드로 돌입합니다.");
        System.out.println(red + "메뉴의 이름을 입력하시면 토글식으로 on/off (true/false) 변경" + reset + "이 가능합니다.");
        System.out.println(black + "---------------------------------------------------------" + reset);
    }

    // 키오스크 전원 관리 화면
    public void displayKioskPower() {
        System.out.println(black + "---------------------------------------------------------" + reset);
        System.out.println();
        System.out.println(red + "                 키오스크를 종료 하시겠습니까?" + reset               );
        System.out.println("                 종료 " + green + "\"yes\"" + reset + "    취소 " + green + "\"no\"" + reset);
        System.out.println();
        System.out.println(black + "---------------------------------------------------------" + reset);
    }
}
