import java.util.Scanner;

public class Tugas1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float p, l, luas;

        System.out.print("Masukkan Panjang: ");
        p = input.nextFloat();
        System.out.print("Masukkan Lebar: ");
        l = input.nextFloat();
        luas = p*l;

        input.close();

        System.out.println("Panjang: " + p);
        System.out.println("Lebar: " + l);
        System.out.println("Luas: " + luas);
    }
}