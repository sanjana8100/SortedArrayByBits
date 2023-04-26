package com.bridgelabz.SortUsingBinaryRepresentation;

import java.util.Scanner;

public class SortUsingBinaryRepresentation {

    public static int countBits(String number){
        char[] array = number.toCharArray();
        int count = 0;
        for (int i=0 ; i < array.length ; i++){
            if(array[i] == '1')
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int num = in.nextInt();

        int[] array = new int[num];
        System.out.println("Enter the elements in the array: ");
        for (int i=0 ; i < num ; i++)
            array[i] = in.nextInt();

        int[] countArray = new int[num];
        for (int i=0 ; i < num ; i++){
            String binary = Integer.toBinaryString(array[i]);
            countArray[i] = countBits(binary);
        }

        for (int i=0 ; i < num ; i++){
            for (int j=i+1 ; j < num ; j++){
                if(countArray[i] > countArray[j]){
                    int temp = countArray[i];
                    countArray[i] = countArray[j];
                    countArray[j] = temp;
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                } else if(countArray[i] == countArray[j]){
                    if(array[i] > array[j]){
                        int temp = countArray[i];
                        countArray[i] = countArray[j];
                        countArray[j] = temp;
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }

        System.out.println("Sorted Array By Bits: ");
        for (int i=0 ; i < array.length ; i++)
            System.out.println(array[i]);
    }
}
