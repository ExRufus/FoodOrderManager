package chapter1.services;

import java.util.HashMap;
import java.util.Map;

public class MenuItems {
    public static Map<String, MenuItem> menu = new HashMap<>();

    public static void initializeMenu() {
        menu.put("Nasi Goreng", new MenuItem("Nasi Goreng", 15000));
        menu.put("Mie Goreng", new MenuItem("Mie Goreng", 13000));
        menu.put("Nasi + Ayam", new MenuItem("Nasi + Ayam", 18000));
        menu.put("Es Teh Manis", new MenuItem("Es Teh Manis", 3000));
        menu.put("Es Jeruk", new MenuItem("Es Jeruk", 5000));
    }
}

