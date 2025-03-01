package lab1;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int size = keyboard.nextInt();
        int[] myArray = new int[size];
        
        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            myArray[i] = keyboard.nextInt();
        }
        
        System.out.println("Original: " + Arrays.toString(myArray));
        Arrays.sort(myArray);
        System.out.println("Sorted: " + Arrays.toString(myArray));

        int sum = 0;
        for (int num : myArray) {
            sum += num;
        }
        double average = (double) sum / size;

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}