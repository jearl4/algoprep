package LeetCode.General.Array;

public class RemoveVowelsFromString {
    public String removeVowels(String s) {
        StringBuilder sb = new StringBuilder(s.length());

        for(int i = 0; i < s.length(); i++){
            if(!isVowel(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public boolean isVowel(char c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
