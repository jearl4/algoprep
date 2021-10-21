package Subsets.DTO;

public class AbbreviatedWord {
    public StringBuilder str;
    public int start;
    public int count;
  
    public AbbreviatedWord(StringBuilder str, int start, int count) {
      this.str = str;
      this.start = start;
      this.count = count;
    }
}
