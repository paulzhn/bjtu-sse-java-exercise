package mod05.exercise1;

public class TestArrays {
    public static void main(String[] args) {
        int[] array1 = {2, 3, 5, 7, 11, 13, 17, 19};
        int[] array2 = array1;
        for (int i = 0; i < 4; i++) {
            array2[i * 2] = i * 2;
        }
        printArray(array1);
        System.out.println("");

        int[][] matrix = new int[5][];
        for (int i = 0; i < 5; i++) {
            matrix[i] = new int[i];
            for (int j = 0; j < i; j++) {
                matrix[i][j] = i * j;
            }
            System.out.print("matrix[" + i + "] is ");
            printArray(matrix[i]);
            System.out.println("");
        }


    }

    public static void printArray(int[] array) {
        System.out.print('<');
        for (int i = 0; i < array.length; i++) {
            // print an element
            System.out.print(array[i]);
            // print a comma delimiter if not the last element
            if ((i + 1) < array.length) {
                System.out.print(", ");
            }
        }
        System.out.print('>');
    }
}
