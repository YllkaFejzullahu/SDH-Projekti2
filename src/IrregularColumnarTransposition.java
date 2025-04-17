import java.util.Arrays;
import java.util.Comparator;

public class IrregularColumnarTransposition {

    public String encrypt(String message, String key) {
        message = message.toUpperCase().replaceAll("[^A-Z]", "");
        key = key.toUpperCase();


        int[] columnOrder = new int[key.length()];
        Character[] keyChars = new Character[key.length()];
        for (int i = 0; i < key.length(); i++) {
            keyChars[i] = key.charAt(i);
            columnOrder[i] = i;
        }

        Arrays.sort(keyChars, Comparator.comparingInt(c -> c));
        for (int i = 0; i < key.length(); i++) {
            for (int j = 0; j < key.length(); j++) {
                if (key.charAt(j) == keyChars[i]) {
                    columnOrder[i] = j;
                    break;
                }
            }
        }


        int columns = key.length();
        int rows = (int) Math.ceil((double) message.length() / columns);


        char[][] matrix = new char[rows][columns];
        int messageIndex = 0;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (messageIndex < message.length()) {
                    matrix[i][j] = message.charAt(messageIndex++);
                } else {
                    matrix[i][j] = 'X';
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int col : columnOrder) {
            for (int row = 0; row < rows; row++) {
                result.append(matrix[row][col]);
            }
        }
        return result.toString();
    }

}
