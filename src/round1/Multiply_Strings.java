package round1;

public class Multiply_Strings {
	public static void main(String[] args) {
		String ans = new Multiply_Strings().multiply("123","234");
		System.out.println(ans);
	}
	
    public String multiply(String num1, String num2) {
    	java.math.BigInteger big1 = new java.math.BigInteger(num1);
    	java.math.BigInteger big2 = new java.math.BigInteger(num2);
    	java.math.BigInteger mul = big1.multiply(big2);
        return mul.toString();
    }
}
