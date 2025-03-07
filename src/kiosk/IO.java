package kiosk;

public class IO {

    // 키오스크 시작 문구
    public void displayKioskStart() {
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println(" \n\n                     [시작하기]  \n\n");
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("\"시작하기\"를 입력해 주세요.");
    }

    // 키오스크 (매장식사, 포장하기) 선택 문구
    public void displaySelectHow() {
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("\n\n                [매장식사]   [포장하기] \n\n");

        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("매장에서 식사를 원하시는 분은 \"매장식사\"를, 포장을 원하신다면 \"포장하기\"를 입력해 주세요.");
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
        System.out.println("────────────────────────────────────────────────────────");
    }

    // 메뉴 주문 확정 or 장바구니 담기 선택 화면
    public void displayCheckOrder() {
        System.out.println();
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("바로 주문을 원하신다면 \"order\"를 입력해 주세요.");
        System.out.println("장바구니에 담으시려면 \"keep\"을 입력해 주세요.");
        System.out.println("────────────────────────────────────────────────────────");
    }

    // 장바구니 목록
    public void displayMyBasket() {
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("                      <장바구니 목록>                     ");
        //장바구니 리스트 일단 만들자...

    }

    //



}
