package com.foxminded;

public class DivisionStep {

    private int minuend;
    private int subtrahend;

    public void setMinuend(int minuend) {

        this.minuend = minuend;
    }

    public void setSubtrahend(int subtrahend) {

        this.subtrahend = subtrahend;
    }

    public int getMinuend() {

        return minuend;
    }

    public int getSubtrahend() {

        return subtrahend;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DivisionStep other = (DivisionStep) obj;
        if (minuend != other.minuend)
            return false;
        if (subtrahend != other.subtrahend)
            return false;
        return true;
    }
}
