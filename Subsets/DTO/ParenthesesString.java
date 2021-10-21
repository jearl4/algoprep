package Subsets.DTO;

public class ParenthesesString {
    public String str;
    public int openCount; // open parentheses count
    public int closeCount; // close parentheses count
  
    public ParenthesesString(String s, int openCount, int closeCount) {
      str = s;
      this.openCount = openCount;
      this.closeCount = closeCount;
    }
  }
