package com.bridgelabz.SortUsingBinaryRepresentation;

import java.util.Scanner;
import java.util.Stack;

public class UpdatedSortUsingBinaryRepresentation {
    public static int bitCount(int number){
        Stack<Integer> stack = new Stack<>();
        while (number > 0){
            stack.push(number % 2);
            number = number / 2;
        }

        int count = 0;
        while (!(stack.isEmpty())){
            int bit = stack.pop();
            if (bit == 1)
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

        for (int i=0 ; i < num ; i++){
            for (int j=i+1 ; j < num ; j++){
                if(bitCount(array[i]) > bitCount(array[j])){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                } else if(bitCount(array[i]) == bitCount(array[j])){
                    if(array[i] > array[j]){
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }

        System.out.println("Sorted Array By Bits: ");
        for (int i : array) System.out.println(i);
    }
}
