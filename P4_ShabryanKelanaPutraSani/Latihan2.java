import java.util.Scanner;

public class Latihan2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double makan, transport, belanja;
        double total,pMakan, pTransport, pBelanja;

        System.out.print("Masukkan Makan: ");
        makan = input.nextDouble();
        System.out.print("Masukkan Transport: ");
        transport = input.nextDouble();
        System.out.print("Masukkan belanja: ");
        belanja =  input.nextDouble();
        total = makan + transport + belanja;

        pMakan = (makan/total) *100;
        pTransport = (transport/total) *100;
        pBelanja = (belanja/total) *100;

        System.out.println("\nData:");
        System.out.println("Makan = " + makan);
        System.out.println("Transport =" + transport);
        System.out.println("Belanja = " + belanja);

        System.out.println("\nTotal = " + makan + " + " +  transport + " + " + belanja + " = " + total);
        System.out.println("\nPersentase: ");
        System.out.println("Makan = " + pMakan + "%");
        System.out.println("Transport = " + pTransport + "%");
        System.out.println("Belanja = " + pBelanja + "%");

        input.close();
    }
    
}