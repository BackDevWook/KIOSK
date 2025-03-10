package kiosk;


import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum KioskPage {
    StartPage { // 키오스크 초기 화면
        public void display() {
            io.displayKioskStart(); // 화면 출력
        }
        public KioskPage runProcess(String input) {
            switch (input) {
                case "start" : return KioskPage.MealMethodSelectPage;
                default : return this;
            }
        }
    },
    MealMethodSelectPage { // 식사 방법 선택 화면
        public void display() {
            io.displaySelectHow();
        }
        public KioskPage runProcess(String input) {
            switch (input) {
                case "hall", "takeout": return KioskPage.SingleMenuPage;
                default : return this;
            }
        }
    },
    BeverageMenuPage { // 음료 메뉴 선택 화면
        public void display() {
            io.displayBeverageMenu();
        }
        public KioskPage runProcess(String input) {
            switch (input) { // 페이지 전환 , 주문 및 담기
                case "back" : return KioskPage.MealMethodSelectPage;
                case "cancel" : return KioskPage.StartPage;
                case ">", "single" : return KioskPage.SingleMenuPage;
                case "side" : return KioskPage.SideMenuPage;
                case "basket" : return KioskPage.BasketPage;
                case "0","1","2","3","4" :
                    menuManagement.menuNumbering(); // 각 메뉴 별로 번호 매기기
                    io.yourSelect(menuManagement.findMenu(Integer.valueOf(input), menuManagement.getBeverNumber()), menuManagement.getBeverPrice(Integer.valueOf(input))); // 선택한 주문의 이름과 가격 출력
                    price = menuManagement.getBeverPrice(Integer.valueOf(input)); // 인스턴스 변수에 선택한 메뉴의 금액 저장
                    orderMenuName = menuManagement.findMenu(Integer.valueOf(input), menuManagement.getBeverNumber()); // 인스턴스 변수에 선택한 메뉴의 이름 저장
                    return KioskPage.CheckOrderPage;
                default: return this;
            }
        }
    },
    SingleMenuPage { // 단품 메뉴 선택 화면 - 중심
        public void display() {
            io.displaySingleMenu();
        }
        public KioskPage runProcess(String input) {
            System.out.println();
            switch (input) { // 페이지 전환 , 주문 및 담기
                case "back" : return KioskPage.MealMethodSelectPage;
                case "cancel" : return KioskPage.StartPage;
                case "side", ">" : return KioskPage.SideMenuPage;
                case "bever", "<" : return KioskPage.BeverageMenuPage;
                case "basket" : return KioskPage.BasketPage;
                case "0","1","2","3","4" :
                    menuManagement.menuNumbering(); // 각 메뉴 별로 번호 매기기
                    io.yourSelect(menuManagement.findMenu(Integer.valueOf(input), menuManagement.getSingleNumber()), menuManagement.getSinglePrice(Integer.valueOf(input))); // 선택한 주문의 이름과 가격 출력
                    price = menuManagement.getSinglePrice(Integer.valueOf(input)); // 인스턴스 변수에 선택한 메뉴의 금액 저장
                    orderMenuName = menuManagement.findMenu(Integer.valueOf(input), menuManagement.getSingleNumber()); // 인스턴스 변수에 선택한 메뉴의 이름 저장
                    return KioskPage.CheckOrderPage;
                default: return this;
            }
        }
    },
    SideMenuPage { // 사이드 메뉴 선택 화면
        public void display() {
            io.displaySideMenu();
        }
        public KioskPage runProcess(String input) {
            switch (input) { // 페이지 전환 , 주문 및 담기
                case "back" : return KioskPage.MealMethodSelectPage;
                case "cancel" : return KioskPage.StartPage;
                case "single", "<" : return KioskPage.SingleMenuPage;
                case "bever" : return KioskPage.BeverageMenuPage;
                case "basket" : return KioskPage.BasketPage;
                case "0","1","2","3","4" :
                    menuManagement.menuNumbering(); // 각 메뉴 별로 번호 매기기
                    io.yourSelect(menuManagement.findMenu(Integer.valueOf(input), menuManagement.getSideNumber()), menuManagement.getSidePrice(Integer.valueOf(input))); // 선택한 주문의 이름과 가격 출력
                    price = menuManagement.getSidePrice(Integer.valueOf(input)); // 인스턴스 변수에 선택한 메뉴의 금액 저장
                    orderMenuName = menuManagement.findMenu(Integer.valueOf(input), menuManagement.getSideNumber()); // 인스턴스 변수에 선택한 메뉴의 이름 저장
                    return KioskPage.CheckOrderPage;
                default: return this;
            }
        }

    },
    CheckOrderPage { // 주문 확정 or 장바구니 담기 선택 화면
        public void display() {
            io.displayCheckOrder();
        }
        public KioskPage runProcess(String input) {
            switch (input) {
                case "back" : return KioskPage.SingleMenuPage;
                case "cancel" : return KioskPage.StartPage;
                case "order" : return KioskPage.PaymentPage_SINGLE;
                case "keep" : basket.addBasketList(new basketForm(orderMenuName, quantity, price));
                            return KioskPage.SingleMenuPage;
                default: return this;
            }
        }
    },
    BasketPage { // 장바구니 화면
        public void display() {
            io.displayMyBasket();
        }
        public KioskPage runProcess(String input) {
            switch (input) {
                case "back" : return KioskPage.SingleMenuPage;
                case "cancel" : return KioskPage.StartPage;
                default: return this;
            }
        }
    },
    PaymentPage_SINGLE { // 단품 결제 화면
        public void display() {
            io.displayPayment();
        }
        public KioskPage runProcess(String input) {
            switch (input) {
                case "back" : return KioskPage.SingleMenuPage;
                case "cancel" : return KioskPage.StartPage;
                case "bill":
                    io.displayBillPayment();
                    return KioskPage.StartPage;
                case "card" : return KioskPage.ReceiptSelectPage_SINGLE;
                default: return this;
            }
        }
    },
    PaymentPage_BAKSET { // 장바구니 결제 화면
        public void display() {

        }
        public KioskPage runProcess(String input) {
            return null;
        }
    },
    ReceiptSelectPage_SINGLE { // 단일 메뉴 주문 시 영수증 출력 유무 화면
        public void display() {
            io.displaySelectReceipt();
        }
        public KioskPage runProcess(String input) {
            switch (input) {
                case "yes" : return KioskPage.ReceiptPage_SINGLE;
                case "no" :
                    System.out.println("결제가 완료되었습니다. 감사합니다.");
                    return KioskPage.StartPage;
                default: return this;
            }
        }
    },
    ReceiptSelectPage_BASKET { // 장바구니 메뉴 주문 시 영수증 출력 화면
        public void display() {
            io.displaySelectReceipt();
        }
        public KioskPage runProcess(String input) {
            switch (input) {
                case "yes" : return KioskPage.ReceiptPage_BASKET;
                case "no" :
                    System.out.println("결제가 완료되었습니다. 감사합니다.");
                    return KioskPage.StartPage;
                default: return this;
            }
        }
    },
    ReceiptPage_SINGLE { // 단일 메뉴 영수증 화면
        public void display() {
            io.displayReceipt(price, Map.of(orderMenuName, quantity));
        }
        public KioskPage runProcess(String input) {
            switch (input) {
                case "check" :
                    System.out.println("감사합니다.");
                    return KioskPage.StartPage;
                default: return this;
            }
        }
    },
    ReceiptPage_BASKET { // 장바구니 영수증 화면
        public void display() {

        }
        public KioskPage runProcess(String input) {
            switch (input) {
                case "check" : return KioskPage.StartPage;
                default: return this;
            }
        }
    };


    private static int price; // 즉시 주문 시 사용할 금액 변수
    private final static int quantity = 1; // 즉시 주문 시 사용할 주문 수량 = 1
    private static String orderMenuName; // 즉시 주문 시 사용할 메뉴명


    public abstract void display(); // 출력 메서드
    public abstract KioskPage runProcess(String input); // 페이지 전환 메서드



    IO io = new IO(); // 출력 클래스
    MenuManagement menuManagement = new MenuManagement(); // 메뉴 관리 메서드
    static MyBasket basket = new MyBasket();
}
