package AlgoExpert.Array;

public class RunningProduct {
    public static int[] runningProduct(int[] array) {
        int[] products = new int[array.length];

        var leftProduct = 1;
        for (int i = 0; i < array.length; i++) {
            products[i] = leftProduct;
            leftProduct *= array[i];
        }

        var rightProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            products[i] *= rightProduct;
            rightProduct *= array[i];
        }

        return products;
    }
}
