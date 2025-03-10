package menu;

public enum SingleMenu {

    //메뉴명(초기 재고, 가격, 예상 소요 시간(분))
    힘줄을_108시간_조려만든_소_힘줄_파스타(89900, 15),
    삭힌_레드와인_소스를_곁들인_우둔_스테이크( 56500, 10),
    화이트_와인_비네거를_곁들인_72시간_건조오염_관자샐러드(42000, 15),
    반달곰이_뜯어먹다_남은_돼지_심장탕( 102000, 5),
    최고급_설향딸기를_42시간_우려서_만든_삼계탕(138000, 20);

    // 메뉴 별 인스턴스 상수
    private final int price;
    private final int cookTime;

    // 메뉴 별 생성자
    SingleMenu(int price, int cookTime) {
        this.price = price;
        this.cookTime = cookTime;
    }



    public int getPrice() {
        return price;
    }

    public int getCookTime() {
        return cookTime;
    }
}
