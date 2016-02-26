package round2;

public class test201 {
    public static void main(String[] args) {
        System.out.println(new test201().rangeBitwiseAnd(5, 7));
        System.out.println(new test201().rangeBitwiseAnd(13, 14));
        System.out.println(new test201().rangeBitwiseAnd(0, Integer.MAX_VALUE));
    }

    public int rangeBitwiseAnd(int m, int n) {
        int p = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            p++;
        }
        return m << p;
    }
}
