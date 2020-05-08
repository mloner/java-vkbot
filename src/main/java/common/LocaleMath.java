package common;

public class LocaleMath {

    public static int randInt(int minValue, int maxValue){
        return (int)(Math.random()*maxValue) + minValue;
    }
}
