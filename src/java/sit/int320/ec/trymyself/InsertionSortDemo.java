package sit.int320.ec.trymyself;

public class InsertionSortDemo {

    public static void insertionSort(int array[]) {
        int n = array.length;

        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }

    public static void main(String args[]) {
        int[] arr1 = {21, 92, 54, 42, 7, 23, 44, 61, 100, 45, 37};
        System.out.print("Before Insertion Sort : ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        insertionSort(arr1);
        System.out.print("After Insertion Sort : ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println("");
    }

}
