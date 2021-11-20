package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	// write your code here

        Scanner sc = new Scanner(new BufferedReader(new FileReader("C:\\Users\\serhi\\OneDrive\\Робочий стіл\\Теорія прийняття рішень\\lab_4\\parametr.txt")));
        int rows = 5;
        int columns = 6;
        double [][] arr = new double[rows][columns];
        while(sc.hasNextLine()) {
            for (int i=0; i<arr.length; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j=0; j<line.length; j++) {
                    arr[i][j] = Double.parseDouble(line[j]);
                }
            }
        }
        String[] name = {"weight", "A", "B", "C", "D", "E"};
        for (int i = 0; i <= rows; i++) {
            System.out.printf("%7s", name[i]);
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("%7s", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n"+"Перемножена матриця на коефіцієнти");
        multiplication(arr);

        double concl[] = new double[5];
        System.out.print("Сума");
        add(arr, concl);
        double max = 0;
        int max_i = 0;
        for(int i = 0; i < concl.length; i++){
            if (concl[i] > max){
                max = concl[i];
                max_i = i;
            }
        }

        System.out.println();
        switch (max_i){
            case 0:
                System.out.println("A");
            case 1:
                System.out.println("B");
            case 2:
                System.out.println("C");
            case 3:
                System.out.println("D");
            case 4:
                System.out.println("Winner is E, which has " + concl[4] + " points");
        }

    }

    public static double[][] multiplication(double[][] arr){
        System.out.print("    ");
        String[] name = {"A", "B", "C", "D", "E"};
        for (int i = 0; i <= 4; i++) {
            System.out.printf("%8s", name[i]);
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print("    ");
            for (int j = 1; j < 6; j++) {
                arr[i][j]*=arr[i][0];
                System.out.printf("%8s", (Math.round(arr[i][j]*100.0))/100.0);
            }
            System.out.println();
        }
        return arr;
    }

    public static double[] add(double[][] arr, double[] concl){
        int k = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j <= 4; j++) {
                concl[k] += arr[j][i];
            }
            System.out.printf("%8s", (Math.round(concl[k]*100.0))/100.0);
            k++;
        }
        return concl;
    }
}
