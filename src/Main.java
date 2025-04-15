import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final GronsfeldCipher gronsfeldCipher = new GronsfeldCipher();
    private static final IrregularColumnarTransposition columnarTransposition = new IrregularColumnarTransposition();

    public static void main(String[] args) {
        while(true){
            System.out.println("\nClassic Cipher Algorithms");
            System.out.println("1. Gronsfeld Cipher");
            System.out.println("2. Irregular Columnar Transposition");
            System.out.println("3. Exit");
            System.out.print("Select an option (1-3): ");

            int choice = getIntInput();

            switch(choice){
                case 1:
                    handleGronsfeldCipher();
                    break;
                case 2:
                    handleColumnarTransposition();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void handleGronsfeldCipher() {
        System.out.println("\nGronsfeld Cipher");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.print("Select an option (1-2): ");

        int choice = getIntInput();
        System.out.print("Enter message: ");
        String message = scanner.nextLine();
        System.out.print("Enter numeric key: ");
        String key = scanner.nextLine();

        if (!key.matches("\\d+")) {
            System.out.println("Error: Key must contain only digits.");
            return;
        }

        String result;
        if (choice == 1) {
            result = gronsfeldCipher.encrypt(message, key);
            System.out.println("Encrypted message: " + result);
        } else if (choice == 2) {
            result = gronsfeldCipher.decrypt(message, key);
            System.out.println("Decrypted message: " + result);
        } else {
            System.out.println("Invalid option.");
        }
    }

    }
