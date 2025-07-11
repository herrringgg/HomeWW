package Homeworks.homework03;

public class Task1 {
    public static void main(String[] args) {

        TV myTV = new TV("Samsung", 65, 68, "qled", "Direct LED");
        System.out.println(myTV);
        System.out.println(myTV.getCompanyFirm());

        TV youTV = new TV("Sber SDX-50U4125", 50, 60);
        System.out.println(youTV);
        youTV.setDiagonal(79);
        System.out.println(youTV.getDiagonal());

        TV bazaTV = new TV();
        System.out.println(bazaTV);
    }
}
