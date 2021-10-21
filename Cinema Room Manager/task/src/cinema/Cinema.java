package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = Integer.parseInt(sc.nextLine());

        Theater theater = new Theater(rows, seatsPerRow);

        while (true) {
            int command = menu(sc);
            if (command == 0) {
                break;
            }
            if (command == 1) {
                theater.printTheater();
            }
            if (command == 2) {
                buyTicket(sc, theater);
            }
            if (command == 3) {
                statistics(theater);
            }
        }
    }

    public static void buyTicket(Scanner sc, Theater theater){//, int rows, int seatsPerRow ) {
        while (true) {
            try {
                System.out.println("Enter a row number:");
                int rowNumber = Integer.parseInt(sc.nextLine());
                System.out.println("Enter a seat number in that row:");
                int seatNumber = Integer.parseInt(sc.nextLine());
                if (theater.seatPurchased(rowNumber, seatNumber)) {
                    System.out.println("That ticket has already been purchased!");
                } else {
                    Ticket ticket = new Ticket(rowNumber, seatNumber, theater);
                    theater.bookSeat(ticket);
                    theater.addSale(ticket);
                    System.out.println("cinema.Ticket price: $" + ticket.getPrice());
                    System.out.println("");
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Wrong input!");
            }
        }
    }

    public static int menu(Scanner sc){
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        int command = Integer.parseInt(sc.nextLine());
        return command;
    }

    public static void statistics(Theater theater) {
        System.out.println("Number of purchased tickets: " + theater.getTicketsSold());
        System.out.println("Percentage: " + String.format("%.2f", theater.percentageTicketsSold() * 100) + "%");
        System.out.println("Current income: " + "$" + theater.getRevenue());
        System.out.println("Total income: " + "$" + theater.getTotalRevenue());
    }

}