package lab1;

import java.util.Scanner;
public class Numbers {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in); //Khai báo đối tượng nhập dữ liệu
        System.out.print("First number: ");
        double a = keyboard.nextDouble();
        System.out.print("Second number: ");
        double b = keyboard.nextDouble();
        System.out.println("Sum: " +(a+b));
        System.out.println("Sub: " +(a-b));
        System.out.println("Mul: " +(a*b));
        System.out.println("Div: " +(a/b));
    }
}