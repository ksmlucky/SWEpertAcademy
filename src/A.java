public class A {
    public static void main(String[] args) {
        printArray();
    }

    static int arr[] = {10, 20, 30};

    private static void printArray() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }


}
