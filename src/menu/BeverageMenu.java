package menu;

public enum BeverageMenu {

    //메뉴명(초기 재고, 가격, 예상 소요 시간(분))
    하늘_보리( 4000, 0),
    하늘하늘_쉐이크( 16000, 10),
    아이시클_용과_플레이버( 12000, 0),
    하늘추천_민트_초코_프라페(22000, 10),
    백년동안_뚜껑_열린_위스키( 102000, 10);

    private final int price; // 가격
    private final int cookTime; // 조리시간

    // 생성자
    BeverageMenu(int price, int cookTime) {
        this.price = price;
        this.cookTime = cookTime;
    }

    // 게터
    public int getCookTime() {
        return cookTime;
    }

    public int getPrice() {
        return price;
    }


}
