package org.java8features.streams;

public class ConcertTicket {
    private String userName;
    private int price;
    private boolean isVip;
    private SeatType seatType;

    public ConcertTicket(String userName, int price, String isVip) {
        this.userName = userName;
        this.price = price;
        this.isVip = isVip.equalsIgnoreCase("Yes");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    @Override
    public String toString() {
        return "ConcertTicket { " +
                "Name = '" + userName + '\'' +
                ", Price = '" + price + '\'' +
                ", Seat Type = " + seatType +
                " }";
    }
}
