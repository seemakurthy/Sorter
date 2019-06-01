package model;

public class ZipRange {

    private int lowerRange;
    private int upperRange;

    public ZipRange(int lowerRange, int upperRange) {
        this.lowerRange = lowerRange;
        this.upperRange = upperRange;
    }

    public int getLowerRange() {
        return lowerRange;
    }


    public void setLowerRange(int lowerRange) {
        this.lowerRange = lowerRange;
    }


    public int getUpperRange() {
        return upperRange;
    }

    public void setUpperRange(int upperRange) {
        this.upperRange = upperRange;
    }


    @Override
    public boolean equals(Object obj) {
        ZipRange zrange = (ZipRange) obj;
        return this.lowerRange == zrange.lowerRange && this.upperRange == zrange.upperRange;
    }

    @Override
    public String toString() {
        return "[" + this.lowerRange + "," + this.upperRange + "]";
    }


}
