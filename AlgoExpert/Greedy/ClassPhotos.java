package AlgoExpert.Greedy;

import java.util.ArrayList;
import java.util.Collections;

/*
 * given 2 arrays, redHeight and blueHeight write a function that returns wither
 * class photo can be taken. All students wearing red are in same row, all blue
 * are in same row. Each student in back row must be taller than student
 * directly in front of them. Arrays have same length and will be >= 2
 */
public class ClassPhotos {
    public boolean canTakePhoto(ArrayList<Integer> redShirts, ArrayList<Integer> blueShirts) {
        Collections.sort(redShirts, Collections.reverseOrder());
        Collections.sort(blueShirts, Collections.reverseOrder());

        String shirtColorInFirstRow = (redShirts.get(0) < blueShirts.get(0)) ? "RED" : "BLUE";
        for (int i = 0; i < redShirts.size(); i++) {
            int redShirt = redShirts.get(i);
            int blueShirt = blueShirts.get(i);

            if (shirtColorInFirstRow == "RED") {
                if (redShirt >= blueShirt) {
                    return false;
                }
            } else {
                if(blueShirt >= redShirt){
                    return false;
                }
            }
        }
        return true;
    }
}