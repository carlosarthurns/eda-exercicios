import java.util.*;

class radix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int[] arr = new int[line.length];
        for (int i = 0; i < line.length; i++) arr[i] = Integer.parseInt(line[i]);
        int d = sc.nextInt();

        radixx(arr, d);
    }
    public static void sort(int[] v, int exp){
        int[] aux = new int[v.length];
        int[] freq = new int[100];

        int digit;
        for (int i = 0; i < v.length; i++){
            digit = (int) (v[i] % Math.pow(10, exp));
            digit = (int) (digit / Math.pow(10, exp - 2));
            freq[digit]++;
        }

        for (int i = 1; i < freq.length; i++)
            freq[i] += freq[i-1];

        for (int i = v.length -1; i >= 0; i--){
            digit = (int) (v[i] % Math.pow(10, exp));
            digit = (int) (digit / Math.pow(10, exp - 2));

            aux[freq[digit] - 1] = v[i];
            freq[digit]--;
        }
        for (int i = 0; i < v.length; i++){
            v[i] = aux[i];
        }
    }

    public static void radixx(int[] v, int d){
        for (int i = 2; i <= d; i += 2){
            sort(v, i);
            System.out.println(Arrays.toString(v));
        }
    }
}
