package chapter1;

import chapter1.controllers.MenuUtama;
import chapter1.services.MenuItems;

public class Main {

    public static void main(String[] args) {
        MenuItems menu = new MenuItems();
        MenuUtama menuUtama = new MenuUtama(menu);
        MenuUtama.mainMenu();
    }
}
