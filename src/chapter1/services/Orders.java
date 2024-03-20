package chapter1.services;

import chapter1.utils.FormatBarrier;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private final MenuItem menuItem;
    private int quantity;
    private static final List<Orders> ordersList = new ArrayList<>();
    private static FormatBarrier formatBarrier = new FormatBarrier();


    public Orders(MenuItem menu, int quantity) {
        this.menuItem = menu;
        this.quantity = quantity;
        ordersList.add(this);
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public static String returnTotalOrder() {
        StringBuilder output = new StringBuilder();
        int totalQty = 0;
        int totalPrice = 0;

        if (ordersList.isEmpty()) {
            return "Belum ada pesanan.";
        }

        for (Orders order : ordersList) {
            MenuItem menuItem = order.menuItem;
            int price = menuItem.getPrice() * order.getQuantity();
            String qty = Integer.toString(order.getQuantity());
            totalPrice += price;
            totalQty += order.getQuantity();

            output.append(String.format(
                    "%s - Qty: %s, Price: %d\n",
                    menuItem.getName(),
                    qty,
                    price
            ));
        }
        output.append(String.format("Total Quantity: %d\nTotal Price: %d", totalQty, totalPrice));
        return output.toString();
    }

    public static String returnReceipt() {
        if (ordersList.isEmpty()) {
            return "Belum ada pesanan.";
        }

        return formatBarrier.twoFormatBarrier("BinarFud") +
                "Terima kasih sudah memesan\n" +
                "di BinarFud\n\n" +
                "Di bawah ini adalah pesanan anda\n" +
                returnTotalOrder() +
                "\nPembayaran : BinarCash\n" +
                formatBarrier.twoFormatBarrier("\nSimpan struk ini sebagai\nbukti pembayaran");
    }
}
