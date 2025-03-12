package kiosk;


import kiosk.menumanagement.MenuHelper;
import kiosk.menumanagement.Sale;
import kiosk.menumanagement.SoldOut;
import menu.BeverageMenu;
import menu.SideMenu;
import menu.SingleMenu;

import java.util.InputMismatchException;
import java.util.Map;

public enum KioskPage {
    StartPage { // 키오스크 초기 화면

        public void display() {
            io.displayKioskStart(); // 화면 출력
        }

        public KioskPage runProcess(String input) {
            switch (input) {
                case "start":
                    return KioskPage.MealMethodSelectPage;
                case "manage":
                    return KioskPage.M_PasswordPage;
                default:
                    return this;
            }
        }
    },
    MealMethodSelectPage { // 식사 방법 선택 화면

        public void display() {
            io.displaySelectHow();
        }

        public KioskPage runProcess(String input) {
            switch (input) {
                case "hall", "takeout":
                    return KioskPage.SingleMenuPage;
                default:
                    return this;
            }
        }
    },
    BeverageMenuPage { // 음료 메뉴 선택 화면

        public void display() {
            io.displayBeverageMenu();
        }

        public KioskPage runProcess(String input) {
            switch (input) { // 페이지 전환 , 주문 및 담기
                case "back":
                    return KioskPage.MealMethodSelectPage;
                case "cancel":
                    return KioskPage.StartPage;
                case ">", "single":
                    return KioskPage.SingleMenuPage;
                case "side":
                    return KioskPage.SideMenuPage;
                case "basket":
                    return KioskPage.BasketPage;
                case "sale":
                    return KioskPage.SalePage;
                case "0", "1", "2", "3", "4":
                    if (soldOut.getIsSoldout().get(BeverageMenu.values()[Integer.parseInt(input)].toString())) { // 입고 상태일 경우 주문이 가능하고 품절일 경우 불가능
                        menuHelper.menuNumbering(); // 각 메뉴 별로 번호 매기기
                        io.yourSelect(menuHelper.findMenu(Integer.valueOf(input), menuHelper.getBeverNumber()), menuHelper.getBeverPrice(Integer.parseInt(input))); // 선택한 주문의 이름과 가격 출력
                        price = menuHelper.getBeverPrice(Integer.parseInt(input)); // 인스턴스 변수에 선택한 메뉴의 금액 저장
                        orderMenuName = menuHelper.findMenu(Integer.valueOf(input), menuHelper.getBeverNumber()); // 인스턴스 변수에 선택한 메뉴의 이름 저장
                        return KioskPage.CheckOrderPage;
                    } else {
                        System.out.println("해당 상품은 매진되었습니다.");
                        return this;
                    }
                default:
                    return this;
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
                case "back":
                    return KioskPage.MealMethodSelectPage;
                case "cancel":
                    return KioskPage.StartPage;
                case "side", ">":
                    return KioskPage.SideMenuPage;
                case "bever", "<":
                    return KioskPage.BeverageMenuPage;
                case "basket":
                    return KioskPage.BasketPage;
                case "sale":
                    return KioskPage.SalePage;
                case "0", "1", "2", "3", "4":
                    if (soldOut.getIsSoldout().get(SingleMenu.values()[Integer.parseInt(input)].toString())) { // 입고 상태일 경우 주문이 가능하고 품절일 경우 불가능
                        menuHelper.menuNumbering(); // 각 메뉴 별로 번호 매기기
                        io.yourSelect(menuHelper.findMenu(Integer.valueOf(input), menuHelper.getSingleNumber()), menuHelper.getSinglePrice(Integer.parseInt(input))); // 선택한 주문의 이름과 가격 출력
                        price = menuHelper.getSinglePrice(Integer.parseInt(input)); // 인스턴스 변수에 선택한 메뉴의 금액 저장
                        orderMenuName = menuHelper.findMenu(Integer.valueOf(input), menuHelper.getSingleNumber()); // 인스턴스 변수에 선택한 메뉴의 이름 저장
                        return KioskPage.CheckOrderPage;
                    } else {
                        System.out.println("해당 상품은 매진되었습니다.");
                        return this;
                    }
                default:
                    return this;
            }
        }
    },
    SideMenuPage { // 사이드 메뉴 선택 화면

        public void display() {
            io.displaySideMenu();
        }

        public KioskPage runProcess(String input) {
            switch (input) { // 페이지 전환 , 주문 및 담기
                case "back":
                    return KioskPage.MealMethodSelectPage;
                case "cancel":
                    return KioskPage.StartPage;
                case "single", "<":
                    return KioskPage.SingleMenuPage;
                case "bever":
                    return KioskPage.BeverageMenuPage;
                case "basket":
                    return KioskPage.BasketPage;
                case "sale":
                    return KioskPage.SalePage;
                case "0", "1", "2", "3", "4":
                    if (soldOut.getIsSoldout().get(SideMenu.values()[Integer.parseInt(input)].toString())) { // 입고 상태일 경우 주문이 가능하고 품절일 경우 불가능
                        menuHelper.menuNumbering(); // 각 메뉴별로 번호 매기기
                        io.yourSelect(menuHelper.findMenu(Integer.valueOf(input), menuHelper.getSideNumber()), menuHelper.getSidePrice(Integer.parseInt(input))); // 선택한 주문의 이름과 가격 출력
                        price = menuHelper.getSidePrice(Integer.parseInt(input)); // 인스턴스 변수에 선택한 메뉴의 금액 저장
                        orderMenuName = menuHelper.findMenu(Integer.valueOf(input), menuHelper.getSideNumber()); // 인스턴스 변수에 선택한 메뉴의 이름 저장
                        return KioskPage.CheckOrderPage;
                    } else {
                        System.out.println("해당 상품은 매진되었습니다.");
                        return this;
                    }
                default:
                    return this;
            }
        }

    },
    CheckOrderPage { // 주문 확정 or 장바구니 담기 선택 화면

        public void display() {
            io.displayCheckOrder();
        }

        public KioskPage runProcess(String input) {
            switch (input) {
                case "back":
                    return KioskPage.SingleMenuPage;
                case "cancel":
                    return KioskPage.StartPage;
                case "order":
                    return KioskPage.PaymentPage_SINGLE;
                case "keep":
                    basket.addBasketList(new basketForm(orderMenuName, quantity, price));
                    return KioskPage.SingleMenuPage;
                default:
                    return this;
            }
        }
    },
    BasketPage { // 장바구니 화면

        public void display() {
            io.displayMyBasket();
        }

        public KioskPage runProcess(String input) {

                switch (input) {
                    case "back":
                        return KioskPage.SingleMenuPage;
                    case "cancel":
                        return KioskPage.StartPage;
                    case "order":
                        return KioskPage.PaymentPage_BAKSET;
                    case "mod":
                        basket.basketModify(input);
                        return this;
                    default:
                        return this;
                }
        }
    },
    PaymentPage_SINGLE { // 단품 결제 화면

        public void display() {
            io.displayPaymentSINGLE();
        }

        public KioskPage runProcess(String input) {
            switch (input) {
                case "back":
                    return KioskPage.SingleMenuPage;
                case "cancel":
                    return KioskPage.StartPage;
                case "bill":
                    io.displayBillPayment();
                    return KioskPage.StartPage;
                case "card":
                    return KioskPage.ReceiptSelectPage_SINGLE;
                default:
                    return this;
            }
        }
    },
    PaymentPage_BAKSET { // 장바구니 결제 화면

        public void display() {
            io.displayPaymentBASKET();
        }

        public KioskPage runProcess(String input) {
            switch (input) {
                case "back":
                    return KioskPage.SingleMenuPage;
                case "cancel":
                    return KioskPage.StartPage;
                case "bill":
                    io.displayBillPayment();
                    return KioskPage.StartPage;
                case "card":
                    return KioskPage.ReceiptSelectPage_BASKET;
                default:
                    return this;
            }
        }
    },
    ReceiptSelectPage_SINGLE { // 단일 메뉴 주문 시 영수증 출력 유무 화면

        public void display() {
            io.displaySelectReceipt();
        }

        public KioskPage runProcess(String input) {
            switch (input) {
                case "yes":
                    return KioskPage.ReceiptPage_SINGLE;
                case "no":
                    System.out.println("결제가 완료되었습니다. 감사합니다.");
                    basket.getBasketList().clear(); // 결제 완료후 장바구니 초기화
                    saleCode = 0; // 코드도 초기화
                    return KioskPage.StartPage;
                default:
                    return this;
            }
        }
    },
    ReceiptSelectPage_BASKET { // 장바구니 메뉴 주문 시 영수증 출력 화면

        public void display() {
            io.displaySelectReceipt();
        }

        public KioskPage runProcess(String input) {
            switch (input) {
                case "yes":
                    return KioskPage.ReceiptPage_BASKET;
                case "no":
                    System.out.println("결제가 완료되었습니다. 감사합니다.");
                    basket.getBasketList().clear(); // 결제 완료후 장바구니 초기화
                    saleCode = 0; // 코드도 초기화
                    return KioskPage.StartPage;
                default:
                    return this;
            }
        }
    },
    ReceiptPage_SINGLE { // 단일 메뉴 영수증 화면

        public void display() {
            io.displayReceiptSINGLE(price, Map.of(orderMenuName, quantity), saleCode);
        }

        public KioskPage runProcess(String input) {
            switch (input) {
                case "check":
                    System.out.println("감사합니다.");
                    basket.getBasketList().clear(); // 결제 완료후 장바구니 초기화
                    saleCode = 0; // 코드도 초기화
                    return KioskPage.StartPage;
                default:
                    return this;
            }
        }
    },
    ReceiptPage_BASKET { // 장바구니 영수증 화면

        public void display() {
            io.displayReceiptBASKET(basket.basketTotalPrice(), basket.getBasketList(), saleCode);
        }

        public KioskPage runProcess(String input) {
            switch (input) {
                case "check":
                    System.out.println("감사합니다.");
                    basket.getBasketList().clear(); // 결제 완료후 장바구니 초기화
                    saleCode = 0; // 코드도 초기화
                    return KioskPage.StartPage;
                default:
                    return this;
            }
        }
    },
    SalePage { // 할인 페이지

        public void display() {
            io.displaySale();
        }

        public KioskPage runProcess(String input) {
            switch (input) {
                case "back":
                    return KioskPage.SingleMenuPage;
                case "cancel":
                    return KioskPage.StartPage;
                case "1", "2", "3", "4":
                    saleCode = Sale.values()[Integer.parseInt(input)].getSaleCode();
                    return KioskPage.SingleMenuPage;
                default:
                    return this;
            }
        }
    },
    ManagerPage { // 관리자 페이지

        public void display() {
            io.displayManager();
        }

        public KioskPage runProcess(String input) {
            switch (input) {
                case "back":
                    return KioskPage.StartPage;
                case "1":
                    return KioskPage.M_SoldOutPage;
                case "2":
                    return M_KioskPowerPage;
                default:
                    return this;
            }
        }
    },
    M_PasswordPage { // 관리자 페이지 접속 시 비밀번호 입력 가능한 페이지

        public void display() {
            io.displayManagerPassword();
        }

        public KioskPage runProcess(String input) {
            switch (input) {
                case "back":
                    return StartPage;
                case "12345678":
                    return ManagerPage;
                default:
                    System.out.println("잘못 입력하셨습니다.");
                    return this;
            }
        }
    },
    M_SoldOutPage { // 메뉴 품절관리 페이지

        public void display() {
            io.displaySoldOut();
        }

        public KioskPage runProcess(String input) {
            switch (input) {
                case "back":
                    return ManagerPage;
                case "so":
                    System.out.println("메뉴 이름을 입력하세요. (영어 메뉴 이름 추천)");
                    soldOut.menuOnOff();
                    return this;
                default:
                    return this;
            }
        }
    },
    M_KioskPowerPage {
        public void display() {
            io.displayKioskPower();
        }

        public KioskPage runProcess(String input) {
            switch (input) {
                case "back", "no":
                    return ManagerPage;
                case "yes":
                    power.powerOff();
                default:
                    return this;
            }
        }
    };


    private static int price; // 즉시 주문 시 사용할 금액 변수
    private final static int quantity = 1; // 즉시 주문 시 사용할 주문 수량 = 1
    private static String orderMenuName; // 즉시 주문 시 사용할 메뉴명
    private static int saleCode = 0; // 할인 코드 [초기 설정은 0(일반인)]


    public abstract void display(); // 출력 메서드

    public abstract KioskPage runProcess(String input); // 페이지 전환 메서드


    IO io = new IO(); // 출력 클래스
    MenuHelper menuHelper = new MenuHelper(); // 메뉴 관리 메서드
    static MyBasket basket = new MyBasket(); // 장바구니 관리
    SoldOut soldOut = new SoldOut(); // 메뉴 품절 관리
    KioskPower power = new KioskPower(); // 키오스크 전원

    public static int getSaleCode() { // 출력을 위한 할인코드 게터
        return saleCode;
    }
}
