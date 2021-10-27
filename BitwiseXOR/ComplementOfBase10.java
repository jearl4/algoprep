package BitwiseXOR;

public class ComplementOfBase10 {
    public static int bitwiseComplement(int num) {
        int bitCount = 0;
        int n = num;
        while (n > 0) {
            bitCount++;
            n = n >> 1;
        }

        int allBitsSet = (int) Math.pow(2, bitCount) - 1;
        return num ^ allBitsSet;
    }

    public static void main(String[] args) {
        System.out.println("Bitwise complement is: " + bitwiseComplement(8));
        System.out.println("Bitwise complement is: " + bitwiseComplement(10));
    }
}
