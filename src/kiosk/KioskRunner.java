package kiosk;

public class KioskRunner {
    public static void main(String[] args) {
        MenuManagement menuManagement = new MenuManagement();
        IO io = new IO();

        menuManagement.menuNumbering();

        System.out.println(menuManagement.getBeverNumber());
        System.out.println(menuManagement.getSideNumber());
        System.out.println(menuManagement.getSingleNumber());


        io.displaySelectHow();




    }
}
