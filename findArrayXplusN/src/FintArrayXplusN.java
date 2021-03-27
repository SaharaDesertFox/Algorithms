import java.util.ArrayList;
import java.util.Arrays;

public class FintArrayXplusN {
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 7, 1, 2, 3, 5, 7, 81, 232, 35, 235, 43, 41,
                4124, 12, 41, 24, 36, 47, 85, 9, 9, 59, 4, 1, 4, 1, 53, 47569, 7};
        int n = 3;
        ArrayList<int[]> result = getPairsCount(arr, n);
        System.out.print("Array:\n");
        int arrlength = arr.length;
        for (int i = 0; i < arrlength; i++) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < arrlength; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\nPairs:\n");
        for (int[] indexes : result) {
            System.out.print("{");
            for (int index : indexes) {
                System.out.printf("%s: %s, ", index, arr[index]);
            }
            System.out.print("}\n");
        }
        System.out.printf("Pairs number = %s", result.size());
    }

    private static ArrayList<int[]> getPairsCount(int[] arr, int n) {
        ArrayList<int[]> result = new ArrayList<int[]>();
        Arrays.sort(arr);
        int itemsCount = arr.length;
        int i = 0;
        int j = 0;
        while (j < itemsCount) {
            int sumIplusN = arr[i] + n;
            int valJ = arr[j];
            if (sumIplusN > valJ) {
                ++j;
            } else if (sumIplusN < valJ) {
                ++i;
            } else {
                int[] pair = {i, j};
                result.add(pair);
                ++i;
                ++j;
            }
        }

        return result;
    }
}
