package kiosk;

public enum SingleMenu {

    //메뉴명(초기 재고, 가격, 예상 소요 시간(분))
    둘이_먹다_둘이_죽을_스테이크(10, 50000, 15),
    특제_마약제조_파스타(20, 38000, 10),
    네달_방치한_관자_스테이크(50, 19000, 15),
    이름도_모를_나물무침(100, 9900, 5),
    김하늘_특제_수제버거(30, 36000, 20);

    // 메뉴 별 인스턴스 상수
    private final int earlyStock;
    private final int price;
    private final int cookTime;

    // 메뉴 별 생성자
    SingleMenu(int stock, int price, int cookTime) {
        this.earlyStock = stock;
        this.price = price;
        this.cookTime = cookTime;
    }

    public int getEarlyStock() {
        return earlyStock;
    }

    public int getPrice() {
        return price;
    }

    public int getCookTime() {
        return cookTime;
    }
}
