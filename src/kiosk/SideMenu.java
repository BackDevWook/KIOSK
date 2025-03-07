package kiosk;

public enum SideMenu {

    //메뉴명(초기 재고, 가격, 예상 소요 시간(분))
    폭탄_스틱(80, 6600, 10),
    두바이_춰콜렛(30, 28000, 5),
    단단한_얼음(1000, 1000, 1),
    아웃백에서_훔쳐온_부쉬맨_브레드(100, 10900, 12),
    고급진_짜파구리(80,14100,15);

    private final int earlyStock;
    private final int price;
    private final int cookTime;

    SideMenu(int stock, int price, int cookTime) {
        this.earlyStock = stock;
        this.price = price;
        this.cookTime = cookTime;
    }

    public int getCookTime() {
        return cookTime;
    }

    public int getPrice() {
        return price;
    }

    public int getEarlyStock() {
        return earlyStock;
    }
}
