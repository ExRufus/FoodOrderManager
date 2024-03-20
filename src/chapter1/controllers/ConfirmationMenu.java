package chapter1.controllers;

import chapter1.services.Orders;
import chapter1.utils.CheckInteger;
import chapter1.utils.ExitApp;
import chapter1.utils.FormatBarrier;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ConfirmationMenu   {
    private final String totalOrder = Orders.returnTotalOrder();
    private final FormatBarrier formatBarrier = new FormatBarrier();

    public void menuConfirmasi() {
        FormatBarrier formatBarrier = new FormatBarrier();

        System.out.println(formatBarrier.twoFormatBarrier("Konfirmasi & Pembayaran"));
        System.out.println(totalOrder);
        System.out.println("1. Konfirmasi dan Bayar");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("0. Keluar aplikasi");

        while (true) {
            int choice = CheckInteger.intCheck();

            if (choice == 1) {
                receiptMenu();
                break;
            } else if (choice == 2) {
                MenuUtama.mainMenu();
                break;
            } else if (choice == 0) {
                ExitApp.exitApplication();
                break;
            } else {
                System.out.print("Pilihan tidak valid");
            }
        }
    }

    public void receiptMenu() {
        System.out.println(PaymentReceipt.returnReceipt());

        try {
            File receiptFile = new File("receipt.txt");
            int fileCounter = 1;
            while (receiptFile.exists()) {
                receiptFile = new File("receipt(" +fileCounter + ").txt");
                fileCounter++;
            }

            PrintWriter receipt = new PrintWriter(receiptFile);
            receipt.println(totalOrder);
            receipt.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
