package common;

/**
 * Local Math
 * <br>
 * ѕодстроенные под специфические нужды класс, дл¤ работы с методами {@link Math}
 * @author Arthur Kupriyanov
 */
public class LocaleMath {

    /**
     * ¬озвращает случайное число в диапозоне от <code>minValue</code> до <code>maxValue</code>
     * @param minValue нижн¤¤ граница (включительно)
     * @param maxValue верхн¤¤ граница (включительно)
     * @return рандомное число в указанном диапозоне
     */
    public static int randInt(int minValue, int maxValue){
        return (int)(Math.random()*maxValue) + minValue;
    }
}
