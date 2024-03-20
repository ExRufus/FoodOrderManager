package chapter1.utils;

import java.util.Scanner;

public class CheckInteger {
    private static final Scanner input = new Scanner(System.in);

    public static int intCheck() {
        while (true) {
            System.out.print("=> ");

            try {
                int answer = input.nextInt();
                input.nextLine();
                return answer;
            } catch (Exception e) {
                System.out.println("Input tidak valid. Mohon masukkan bilangan bulat.");
                input.nextLine();
            }
        }
    }
}
