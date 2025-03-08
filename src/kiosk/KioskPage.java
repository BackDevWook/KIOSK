package kiosk;


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
            switch (input) {
                case "back" : return KioskPage.MealMethodSelectPage;
                case "cancel" : return KioskPage.StartPage;
                case ">", "single" : return KioskPage.SingleMenuPage;
                case "side" : return KioskPage.SideMenuPage;
                case "0","1","2","3","4" :
                    menuManagement.menuNumbering(); // 각 메뉴 별로 번호 매기기
                    io.yourSelect(menuManagement.findMenu(Integer.valueOf(input), menuManagement.getBeverNumber()));
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
            switch (input) {
                case "back" : return KioskPage.MealMethodSelectPage;
                case "cancel" : return KioskPage.StartPage;
                case "side", ">" : return KioskPage.SideMenuPage;
                case "bever", "<" : return KioskPage.BeverageMenuPage;
                case "0","1","2","3","4" :
                    menuManagement.menuNumbering(); // 각 메뉴 별로 번호 매기기
                    io.yourSelect(menuManagement.findMenu(Integer.valueOf(input), menuManagement.getSingleNumber()));
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
            switch (input) {
                case "back" : return KioskPage.MealMethodSelectPage;
                case "cancel" : return KioskPage.StartPage;
                case "single", "<" : return KioskPage.SingleMenuPage;
                case "bever" : return KioskPage.BeverageMenuPage;
                case "0","1","2","3","4" :
                    menuManagement.menuNumbering(); // 각 메뉴 별로 번호 매기기
                    io.yourSelect(menuManagement.findMenu(Integer.valueOf(input), menuManagement.getSideNumber()));
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
                case "order" : return KioskPage.PaymentPage;
                case "keep" :
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
    PaymentPage { // 결제 화면
        public void display() {
            io.displayPayment();
        }
        public KioskPage runProcess(String input) {
            switch (input) {
                case "back" : return KioskPage.SingleMenuPage;
                case "cancel" : return KioskPage.StartPage;
                default: return this;
            }
        }
    },
    ReceiptSelectPage { // 영수증 출력 유무 화면
        public void display() {
            io.displaySelectReceipt();
        }
        public KioskPage runProcess(String input) {
            switch (input) {
                case "yes" : return KioskPage.ReceiptPage;
                case "no" : return KioskPage.StartPage;
                default: return this;
            }
        }
    },
    ReceiptPage { // 영수증 화면
        public void display() {
            io.displayReceipt();
        }
        public KioskPage runProcess(String input) {
            switch (input) {
                case "check" : return KioskPage.StartPage;
                default: return this;
            }
        }
    };

    public abstract void display();
    public abstract KioskPage runProcess(String input);





    IO io = new IO(); // 출력 클래스
    MenuManagement menuManagement = new MenuManagement();

}
