package kiosk.menumanagement;

public enum Sale { // 경우에 따른 할인율을 부여하는 클래스
    일반인(0, 0),
    현역군인(10, 1),
    어린이(30, 2),
    VIP(15, 3),
    직원할인(10, 4);

    private final int saleRatio; // 할인율
    private final int saleCode; // 할인 코드

    // 생성자
    Sale(int saleRatio , int saleCode) {
        this.saleRatio = saleRatio; // 할인 비율
        this.saleCode = saleCode; // 고유 할인 코드
    }

    // 게터
    public int getSaleRatio() {
        return saleRatio;
    }
    public int getSaleCode() {
        return saleCode;
    }


}
