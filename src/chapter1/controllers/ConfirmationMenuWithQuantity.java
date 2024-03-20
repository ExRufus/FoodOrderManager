package chapter1.controllers;

import chapter1.services.Orders;
import chapter1.services.MenuItems;
import chapter1.services.MenuItem;
import chapter1.utils.CheckInteger;
import chapter1.utils.FormatBarrier;

import java.util.ArrayList;
import java.util.List;

public class ConfirmationMenuWithQuantity {
    private static final FormatBarrier formatBarrier = new FormatBarrier();
    private static final List<Orders> orderList = new ArrayList<>();

    public static void quantityMenu(int choice) {
        MenuItems menuItem = new MenuItems();
        MenuItems.initializeMenu();

        String twoFormat = formatBarrier.twoFormatBarrier("Berapa pesanan anda");

        System.out.println("\n" + twoFormat + "\n");
        MenuItem selectedMenuItem = menuItem.menu.get(menuItem.menu.keySet().toArray()[--choice]);
        System.out.printf(
                "%-16s | %s%n",
                selectedMenuItem.getName(),
                selectedMenuItem.getPrice());
        System.out.println("(Input 0 untuk kembali) \n");
        System.out.print("qty ");

        while (true) {
            int qty = CheckInteger.intCheck();
            if (qty == 0) {
                MenuUtama.mainMenu();
                break;
            } else if (qty > 0) {
                boolean found = false;
                for (Orders order : orderList) {
                    if (order.getMenuItem().getName().equals(selectedMenuItem.getName())) {
                        order.addQuantity(qty);
                        found = true;
                        break;
                    }
                }
                if (!found) orderList.add(new Orders(selectedMenuItem, qty));
                MenuUtama.mainMenu();
                break;
            } else {
                System.out.print("Mohon input angka positif.");
            }
        }
    }
}
