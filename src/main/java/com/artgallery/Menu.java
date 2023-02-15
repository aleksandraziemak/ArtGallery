package com.artgallery;

import java.util.Scanner;

public class Menu {

    private static final ArtService artService = new ArtService();

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        while (true) {
            printMenu();
            option = scanner.nextInt();
            manageOptions(option);
        }
    }

    private static void printMenu() {
        System.out.println("Art Gallery");
        System.out.println("1. Show Art collection");
        System.out.println("2. Show Artists");
        System.out.println("3. Edit Art collection");
        System.out.println("4. Buy Painting");
        System.out.println("5. Sell Painting");
        System.out.println("6. Bank balance");
        System.out.println("0. Exit");
        System.out.println("Choose option:");
    }

    private static void manageOptions(int option) {
        switch (option) {
            case 1:
                System.out.println("Your Art collection");
                artService.showMyCollection();
                break;
            case 2:
                System.out.println("Your Artists");
                artService.showMyArtists();
                break;
            case 3:
                artService.editPainting();
                break;
            case 4:
                artService.buyPainting();
                break;
            case 5:
                artService.sellPainting();
                break;
            case 6:
                System.out.println("Your Bank balance");
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Choose a number between 1 and 5.");
                break;
        }
    }
}