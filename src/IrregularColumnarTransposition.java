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
    public String decrypt(String encryptedMessage, String key) {
        key = key.toUpperCase();

        int columns = key.length();
        int rows = (int) Math.ceil((double) encryptedMessage.length() / columns);

        // Krijimi i renditjes së kolonave
        int[] columnOrder = new int[columns];
        Character[] keyChars = new Character[columns];
        for (int i = 0; i < columns; i++) {
            keyChars[i] = key.charAt(i);
            columnOrder[i] = i;
        }

        Arrays.sort(keyChars, Comparator.comparingInt(c -> c));
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < columns; j++) {
                if (key.charAt(j) == keyChars[i]) {
                    columnOrder[i] = j;
                    break;
                }
            }
        }

        // Përgatitja e matricës për mbushje kolonë pas kolone
        char[][] matrix = new char[rows][columns];
        int index = 0;

        for (int i = 0; i < columns; i++) {
            int col = columnOrder[i];
            for (int row = 0; row < rows; row++) {
                if (index < encryptedMessage.length()) {
                    matrix[row][col] = encryptedMessage.charAt(index++);
                }
            }
        }

        // Leximi i matricës rresht pas rreshti për të marrë mesazhin origjinal
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                decrypted.append(matrix[i][j]);
            }
        }

        // Hiq X që mund të jenë shtuar në fund si mbushës
        return decrypted.toString().replaceAll("X+$", "");
    }

}
