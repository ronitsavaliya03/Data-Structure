import java.util.Arrays;

public class DeleteDuplicates {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1, 2, 4, 5, 2, 2};

        System.out.println("Original Array: " + Arrays.toString(array));

        int[] resultArray = removeDuplicates(array);

        System.out.println("Array after removing duplicates: " + Arrays.toString(resultArray));
    }

    public static int[] removeDuplicates(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int[] tempArray = new int[array.length];
        int uniqueCount = 0;

        for (int i = 0; i < array.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < uniqueCount; j++) {
                if (array[i] == tempArray[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                tempArray[uniqueCount] = array[i];
                uniqueCount++;
            }
        }

        int[] resultArray = new int[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            resultArray[i] = tempArray[i];
        }

        return resultArray;
    }
}
