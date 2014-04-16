package round1;

public class Single_Number {

	public static void main(String[] args) {
		Single_Number s = new Single_Number();
		System.out.println(s.singleNumber(new int[]{1,1,2,3,3,2}));
	}
    public int singleNumber(int[] A) {
        int ans = 0;
        for(int i=0;i<A.length;i++)
        	ans ^= A[i];
        return ans;
    }	
}
