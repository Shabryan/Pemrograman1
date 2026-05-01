/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.latihan1;

/**
 *
 * @author Shabryan
 */
import java.util.Scanner;

public class Latihan1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String grade;
        
        System.out.print("Input Kehadiran: ");
        int absen = input.nextInt();
        
        System.out.print("Input Total: ");
        int total = input.nextInt();
        
        input.close();
        float validasi = 21*75/100;
        
        if(total >=80) {
            grade = "A"; }
        else if(total >=70){
            grade = "B"; }
        else if(total >=60){
            grade = "C";}
        else if(total >=55) {
            grade= "D"; }
        else{
            grade = "E";}
        
        if (absen >= validasi){
            System.out.println("Total : " + total + "& grade: " + grade);
      }else if(absen < validasi) {
          if(total >= 55){
              grade = "D";
              System.out.println("Kamu mendapatkan Grade: " + grade);
              System.out.println("Kamu tidak lulus");
          }else if(total < 55) {
              grade = "E";
              System.out.println("Kamu mendapat Grade: " + grade);
              System.out.println("Kamu tidak lulus");
          }
      }
      
                 
    }
}
