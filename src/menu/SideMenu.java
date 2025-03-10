package menu;

public enum SideMenu {

    //메뉴명(초기 재고, 가격, 예상 소요 시간(분))
    초콜릿_바비큐_돼지갈비( 22900, 15),
    소_가죽을_곁들인_선지수프( 36900, 10),
    얼음_모양_불가사리_젤리( 26900, 1),
    루왁_커피_원산지는_불분명_주의( 10900, 30),
    김치_치즈_피자_탕수육_마라탕_탕후루_맛_해물파전(28900,22);

    private final int price;
    private final int cookTime;

    SideMenu(int price, int cookTime) {
        this.price = price;
        this.cookTime = cookTime;
    }

    public int getCookTime() {
        return cookTime;
    }

    public int getPrice() {
        return price;
    }

}
