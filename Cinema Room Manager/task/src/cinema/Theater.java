package cinema;

import java.util.ArrayList;
import java.util.List;

public class Theater {
    private String[][] theater;
    private int rows;
    private int seatsPerRow;
    private int theaterSize;
    private List<Integer> sales;

    public Theater(int rows, int seatsPerRow) {
        this.theater = new String[seatsPerRow][rows];
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.theaterSize = rows * seatsPerRow;
        this.sales = new ArrayList<Integer>();

        for (int seat = 0; seat < seatsPerRow; seat++) {
            for (int row = 0; row < rows; row++) {
                theater[seat][row] = "S ";
            }
        }
    }

    public int getRows() {
        return this.rows;
    }

    public int getSize() {
        return this.theaterSize;
    }

    public void printTheater() {
        System.out.println("Cinema:");
        for (int k = 0; k <= this.seatsPerRow; k ++) {
            if (k == 0) {
                System.out.print("  ");
            } else {
                System.out.print(k + " ");
            }
        }
        System.out.println("");

        for (int row = 1; row <= this.rows; row++) {
            System.out.print(row + " ");
            for (int seat = 0; seat < this.seatsPerRow; seat++) {
                System.out.print(this.theater[seat][row-1] + "");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public boolean isLarge() {
        if (this.theaterSize > 60) {
            return true;
        }
        else {
            return false;
        }
    }

    public void bookSeat(Ticket ticket) {
        theater[ticket.getSeat() - 1][ticket.getRow() - 1] = "B ";

    }

    public void addSale(Ticket ticket) {
        this.sales.add(ticket.getPrice());
    }

    public int getTicketsSold() {
        return sales.size();
    }

    public int getRevenue() {
        int frontSeats = 0;
        int backSeats = 0;
        for (Integer sale: this.sales) {
            if (sale == 8) {
                backSeats++;
            }
            if (sale == 10) {
                frontSeats++;
            }
        }
        int total = frontSeats * 10 + backSeats * 8;
        return total;
    }

    public int getTotalRevenue() {
        int total = 0;
        if (!this.isLarge()) {
            total = this.theaterSize * 10 ;
        } else {
            total = (this.getRows() / 2) * this.seatsPerRow * 10 + ((this.getRows() / 2) + 1) * this.seatsPerRow * 8;
        }
        return total;
    }

    public double percentageTicketsSold() {
        return this.getTicketsSold() * (1.0) / this.theaterSize;
    }

    public boolean seatPurchased(int row, int seat) {

        if (this.theater[seat - 1][row -1].contains("B ")) {
            return true;
        } else {
            return false;
        }
    }


}
