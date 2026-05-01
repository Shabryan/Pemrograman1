/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tugas1;

/**
 *
 * @author Shabryan
 */
import java.util.Scanner;

public class Tugas1 {

    public static void main(String[] args) {
        String grade;
        float realisasi;
        float absensi;
        float tugas;
        float uts;
        float uas;
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Input Realisasi(total pertemuan kuliah): ");
            realisasi = input.nextFloat();
            System.out.print("Input absesi: ");
            absensi = input.nextFloat();
            System.out.print("Input nilai tugas: ");
            tugas = input.nextFloat();
            System.out.print("Input nilai UTS: ");
            uts = input.nextFloat();
            System.out.print("Input nilai UAS: ");
            uas = input.nextFloat();
        }
        
        float validasi = realisasi * 75/100;
        float total;
        
        if (absensi < validasi){
            float b_absensi = absensi/realisasi * 10;
            float b_tugas = tugas * 20/100;
            float b_uts = uts * 30/100;
            float b_uas = uas * 40/100;
            total = b_absensi + b_tugas + b_uts + b_uas;
            
            if(total > 55){
                total = 55;
            }
        }else{
            float b_absensi = absensi/realisasi * 10;
            float b_tugas = tugas * 20/100;
            float b_uts = uts * 30/100;
            float b_uas = uas * 40/100;
            total = b_absensi + b_tugas + b_uts + b_uas;
        }
        
        if (total >= 80){
            grade = "A";
        } else if (total >= 70){
            grade = "B";
        } else if (total >= 60){
            grade = "C";
        } else if (total >= 55){
            grade = "D";
        } else {
            grade = "E";
        }
        
        System.out.println("Kehadiran  : " + absensi + " dari realisasi: " + realisasi);
        System.out.println("Nilai Tugas: " + tugas);
        System.out.println("Nilai UTS  : " + uts);
        System.out.println("Nilai UAS  : " + uas);
        System.out.println("Total      : " + total);
        
        if (total >= 60){
            System.out.println("Selamat kamu lulus dengan grade " + grade);
        } else {
            System.out.println("Kamu tidak lulus, grade kamu " + grade);
        }
        }
}
