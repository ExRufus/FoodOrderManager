package chapter1.controllers;

import chapter1.services.Orders;
import chapter1.utils.FormatBarrier;

public class PaymentReceipt {
    private static final FormatBarrier formatBarrier = new FormatBarrier();

    public static String returnReceipt() {
        return formatBarrier.twoFormatBarrier("BinarFud") +
                "\n\nTerima kasih sudah memesan di BinarFud\n\n" +
                "Dibawah ini adalah pesanan anda\n\n" +
                Orders.returnTotalOrder() +
                "\nPembayaran: binarCash\n" +
                formatBarrier.twoFormatBarrier("Simpan struk ini sebagai bukti pembayaran");
    }
}