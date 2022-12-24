package com.company;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println(
                        "введите число кратное 10, до 1000 ");
                int amount = scanner.nextInt();
                if (isValid(amount)) {
                    ATMWithdrawal.withdraw(new PaperCurrency(amount));
                }
            } while (true);
        }
    }
    private static boolean isValid(int amount) {
        if (amount <= 0) {
            System.out.println("меньше нуля");
            return false;
        } else if (amount > 1000) {
            System.out.println("Больше 1000");
            return false;
        } else if (amount % 10 != 0) {
            System.out.println("не делится на 10");
            return false;
        }
        return true;
    }
}
