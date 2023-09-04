/*
package dynamic;
import java.util.*;

public class Demo {
    public static int calculateMaxUnits(List<Long> boxes, List<Long> unitPerBox, int truckCapacity) {
        // Combine boxes and unitPerBox arrays into a single 2D array of products
        int[][] products = new int[boxes.size()][2];
        for (int i = 0; i < boxes.length; i++) {
            products[i][0] = boxes[i];
            products[i][1] = unitPerBox[i];
        }

        // Sort the products based on units per box in descending order
        Arrays.sort(products, (a, b) -> Integer.compare(b[1], a[1]));

        int totalUnitsPacked = 0;
        int boxesUsed = 0;

        for (int[] product : products) {
            int boxesToPack = Math.min(product[0], truckCapacity - boxesUsed);
            int unitsPacked = boxesToPack * product[1];
            totalUnitsPacked += unitsPacked;
            boxesUsed += boxesToPack;

            if (boxesUsed == truckCapacity) {
                break;
            }
        }

        return totalUnitsPacked;
    }

    public static void main(String[] args) {
        int[] boxes = {1, 2, 3};
        int[] unitPerBox = {3, 2, 1};
        int truckCapacity = 3;

        int maxUnits = calculateMaxUnits(boxes, unitPerBox, truckCapacity);
        System.out.println("Maximum units that can be shipped: " + maxUnits);
    }
}
*/
