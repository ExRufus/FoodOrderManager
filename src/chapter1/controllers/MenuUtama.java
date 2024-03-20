package chapter1.controllers;

import chapter1.services.MenuItems;
import chapter1.services.MenuItem;
import chapter1.services.Orders;
import chapter1.utils.CheckInteger;
import chapter1.utils.ExitApp;
import chapter1.utils.FormatBarrier;

import java.util.Scanner;

public class MenuUtama {
    private static MenuItems menuItem;
    private static FormatBarrier formatBarrier = new FormatBarrier();
    private static final Scanner input = new Scanner(System.in);

    public MenuUtama(MenuItems menu) {
        menuItem = menu;
    }

    public static void mainMenu() {
        System.out.println(formatBarrier.twoFormatBarrier("Selamat datang di BinarFud"));
        System.out.println("Silahkan pilih makanan : ");
        menuItem.initializeMenu();
        int index = 1;
        for (String itemName : menuItem.menu.keySet()) {
            MenuItem item = menuItem.menu.get(itemName);
            System.out.printf("%d. %-16s | %d%n", index++, item.getName(), item.getPrice());
        }
        System.out.println("99. Pesan dan Bayar");
        System.out.println("0. Keluar Aplikasi");
        System.out.println();

        while (true) {
            int choice = CheckInteger.intCheck();
            System.out.print(choice);
            System.out.println();

            if (choice == 0) {
                ExitApp.exitApplication();
                break;
            } else if (choice >= 1 && choice <= MenuItems.menu.size()) {
                ConfirmationMenuWithQuantity.quantityMenu(choice);
                break;
            } else if (choice == 99) {
                if (Orders.returnTotalOrder().isEmpty()) {
                    System.out.println("Anda belum memesan apa pun.");
                } else {
                    new ConfirmationMenu().menuConfirmasi();
                    break;
                }
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
