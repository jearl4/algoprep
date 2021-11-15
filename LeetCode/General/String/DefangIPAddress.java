package LeetCode.General.String;

public class DefangIPAddress {
    public String defangIPaddr(String address) {
        StringBuilder str = new StringBuilder();
        int end = address.length();
        for (int i = 0; i < end; i++){
            char curr = address.charAt(i);
            if (curr == '.'){
                str.append("[.]");
            } else {
                str.append(curr);
            }
        }
        return str.toString();
    }
}
