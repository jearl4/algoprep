package String;

public class EncodedLength {
    public static String encodedRunLength(String string){
        StringBuilder encoded = new StringBuilder();
        int count = 1;

        for (int i = 1; i < string.length(); i++) {
            if((string.charAt(i) != string.charAt(i-1))||count == 9){
                encoded.append(Integer.toString(count));
                encoded.append(string.charAt(i-1));
                count = 0;
            }
            count += 1;
        }

        encoded.append(Integer.toString(count));
        encoded.append(string.charAt(string.length()-1));
        return encoded.toString();
    }
}
