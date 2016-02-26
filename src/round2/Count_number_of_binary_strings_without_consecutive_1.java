package round2;
//Count number of binary strings without consecutive 1¡¯s.
//(http://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/).

public class Count_number_of_binary_strings_without_consecutive_1 {
    public static void main(String[] args) {
        Count_number_of_binary_strings_without_consecutive_1 c =
                new Count_number_of_binary_strings_without_consecutive_1();
        System.out.println(c.countStrings(4));
    }
    public int countStrings(int n) {
        if (n <= 0) {
            return n;
        }
        int end0[] = new int[n];
        int end1[] = new int[n];
        end0[0] = 1;
        end1[0] = 1;
        for (int i = 1; i < n; i++) {
            end0[i] = end0[i - 1] + end1[i - 1];
            end1[i] = end0[i - 1];
        }
        return end0[n - 1] + end1[n - 1];
    }
}
