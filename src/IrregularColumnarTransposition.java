import java.util.Arrays;
import java.util.Comparator;

public class IrregularColumnarTransposition {

    public String encrypt(String message, String key) {
        message = message.toUpperCase().replaceAll("[^A-Z]", "");
        key = key.toUpperCase();

        int[] columnOrder = getColumnOrder(key);

        int columns = key.length();
        int rows = (int) Math.ceil((double) message.length() / columns);

        char[][] matrix = new char[rows][columns];
        int messageIndex = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (messageIndex < message.length()) {
                    matrix[i][j] = message.charAt(messageIndex++);
                } else {
                    matrix[i][j] = 'X'; // Standard padding character
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

    public String decrypt(String encryptedMessage, String key) {
        key = key.toUpperCase();
        int columns = key.length();
        int rows = (int) Math.ceil((double) encryptedMessage.length() / columns);

        int[] columnOrder = getColumnOrder(key);

        int[] inverseOrder = new int[columns];
        for (int i = 0; i < columns; i++) {
            inverseOrder[columnOrder[i]] = i;
        }

        char[][] matrix = new char[rows][columns];
        int index = 0;

        for (int col : columnOrder) {
            for (int row = 0; row < rows; row++) {
                if (index < encryptedMessage.length()) {
                    matrix[row][col] = encryptedMessage.charAt(index++);
                } else {
                    matrix[row][col] = 'X'; // Padding if needed
                }
            }
        }

        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                decrypted.append(matrix[i][j]);
            }
        }

        String result = decrypted.toString();
        return result.replaceAll("X+$", "");
    }

    private int[] getColumnOrder(String key) {
        // Create an array of indices
        Integer[] indices = new Integer[key.length()];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Character.compare(key.charAt(a), key.charAt(b));
            }
        });

        int[] order = new int[key.length()];
        for (int i = 0; i < order.length; i++) {
            order[i] = indices[i];
        }

        return order;
    }
}
