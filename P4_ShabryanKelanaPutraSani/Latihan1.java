import java.util.Scanner;

public class Latihan1 {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
    
        float realisasi, kehadiran, tugas, uts, uas;
        float b_kehadiran,  b_tugas, b_uts, b_uas, total;

        System.out.print("Input Realisasi: ");
        realisasi =  input.nextFloat();

        System.out.print("Input Kehadiran: ");
        kehadiran = input.nextFloat();

        System.out.print("Input Nilai Tugas: ");
        tugas = input.nextFloat();

        System.out.print("Input Nilai UTS: ");
        uts = input.nextFloat();

        System.out.print("Input Nilai UAS: ");
        uas = input.nextFloat();

        b_kehadiran = (kehadiran/realisasi) * 10;
        b_tugas = tugas * 20/100;
        b_uts = uts * 30/100;
        b_uas = uas * 40/100;
        total = b_kehadiran +  b_tugas + b_uts + b_uas;

        System.out.println("Kehadiran: " + kehadiran + "dari realisasi: " + realisasi);
        System.out.println("Nilai Tugas: " + tugas);
        System.out.println("Nilai UTS: " + uts);
        System.out.println("Nilai UAS: " + uas);
        System.out.println("Total Nilai: " + total);

        input.close();

    }
}