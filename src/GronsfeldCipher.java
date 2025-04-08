public class GronsfeldCipher {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encrypt(String message, String key) {
        message = message.toUpperCase();
        StringBuilder result = new StringBuilder();
        int keyIndex = 0;

        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                int shift = Character.getNumericValue(key.charAt(keyIndex % key.length()));
                int charIndex = ALPHABET.indexOf(c);
                int newIndex = (charIndex + shift) % 26;
                result.append(ALPHABET.charAt(newIndex));
                keyIndex++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
