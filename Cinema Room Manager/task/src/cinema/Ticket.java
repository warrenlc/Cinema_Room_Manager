package cinema;

public class Ticket {
    private int[][] ticket;
    private int row;
    private int seat;
    public Theater theater;
    public int price;

    public Ticket(int row, int seat, Theater theater) {
        this.ticket = new int[seat][row];
        this.row = row;
        this.seat = seat;
        this.theater = theater;
    }

    public int getRow() {
        return this.row;
    }

    public int getSeat() {
        return this.seat;
    }

    public int getPrice() {
        this.price = 10;
        if (this.theater.getSize() > 60) {
            if (this.getRow() <= theater.getRows() / 2) {
                return this.price;
            } else {
                this.price = 8;
            }
        }
        return this.price;
    }

}
