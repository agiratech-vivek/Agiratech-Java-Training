package org.miniproject.watercan;

public class WaterCan {
    private int oneLitre;
    private int fiveLitre;
    private int tenLitre;
    private int twentyFiveLitre;

    public WaterCan() {
    }

    public WaterCan(int oneLitre, int fiveLitre, int tenLitre, int twentyFiveLitre) {
        this.oneLitre = oneLitre;
        this.fiveLitre = fiveLitre;
        this.tenLitre = tenLitre;
        this.twentyFiveLitre = twentyFiveLitre;
    }

    public int getOneLitre() {
        return oneLitre;
    }

    public void setOneLitre(int oneLitre) {
        this.oneLitre = oneLitre;
    }

    public int getFiveLitre() {
        return fiveLitre;
    }

    public void setFiveLitre(int fiveLitre) {
        this.fiveLitre = fiveLitre;
    }

    public int getTenLitre() {
        return tenLitre;
    }

    public void setTenLitre(int tenLitre) {
        this.tenLitre = tenLitre;
    }

    public int getTwentyFiveLitre() {
        return twentyFiveLitre;
    }

    public void setTwentyFiveLitre(int twentyFiveLitre) {
        this.twentyFiveLitre = twentyFiveLitre;
    }

    @Override
    public String toString() {
        return "Water-Can Stock: " +
                "\n1 Litre Bottle: " + oneLitre +
                "\n5 Litre Can: " + fiveLitre +
                "\n10 Litre Can: " + tenLitre +
                "\n25 Litre Can: " + twentyFiveLitre;
    }

    public int totalWaterCans(){
        return oneLitre + fiveLitre + tenLitre + twentyFiveLitre;
    }
}
