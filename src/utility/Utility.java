package utility;

public class Utility {
    public static String arrayToString(Integer[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int x : array)
            stringBuilder.append(x).append(" ");
        return stringBuilder.append("}").toString();
    }

    public static String intArrayToString(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int x : array)
            stringBuilder.append(x).append(" ");
        return stringBuilder.append("}").toString();
    }
}