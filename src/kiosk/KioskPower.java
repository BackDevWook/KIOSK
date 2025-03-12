package kiosk;

public class KioskPower {


    private static boolean power; // 키오스크 전원

    public KioskPower() { // 전원 켜져있는 상태
        this.power = true;
    }

    public void powerOff() { // 전원 차단 메서드
        this.power = false;
    }

    public static boolean getIsPower() { // 전원 상태 게터
        return power;
    }

}
