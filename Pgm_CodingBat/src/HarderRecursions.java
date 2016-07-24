
public class HarderRecursions {
	private static GroupSum gs;
	private static GroupSum6 gs6;
	private static GroupNoAdj gna;
	private static GroupSum5 gs5;
	private static GroupSumClump gsc;
	private static SplitArray sa;
	
	public static void main(String [] args) {
		//groupSumCall();
		//groupSum6Call();
		//groupNoAdj();
		//groupSum5Call();
		//groupSumClump();
		//splitArray();
	}
	
	public static void splitArray() {
		sa = new SplitArray();
		int [] A = {2, 2};
		int [] B = {2, 3};
		int [] C = {5, 2, 3};
		System.out.println(sa.splitArray(A));
		System.out.println(sa.splitArray(B));
		System.out.println(sa.splitArray(C));
	}
	
	public static void groupSumClump() {
		int [] A = {2, 4, 8};
		int [] B = {1, 2, 4, 8, 1};
		int [] C = {2, 4, 4, 8};
		gsc = new GroupSumClump();
		
		System.out.println("Group sum clump? " + gsc.groupSumClump(0, A, 10));
		System.out.println("Group sum clump? " + gsc.groupSumClump(0, B, 14));
		System.out.println("Group sum clump? " + gsc.groupSumClump(0, C, 14));
	}
	
	public static void groupSum5Call() {
		int [] nums = {2, 5, 10, 4};
		int [] A = {2, 5, 4, 10};
		gs5 = new GroupSum5();
		System.out.println("Group sum 5 ? " + gs5.groupSum5(0, A, 12));
		System.out.println("Group sum 5 ? " + gs5.groupSum5(0, nums, 19));
		System.out.println("Group sum 5 ? " + gs5.groupSum5(0, nums, 17));
		System.out.println("Group sum 5 ? " + gs5.groupSum5(0, nums, 12));
	}
	
	public static void groupNoAdj() {
		int [] nums = {2, 5, 10, 4};
		gna = new GroupNoAdj();
		System.out.println("groupNoAdj ? " + gna.groupNoAdj(0, nums, 12));
		System.out.println("groupNoAdj ? " + gna.groupNoAdj(0, nums, 14));
		System.out.println("groupNoAdj ? " + gna.groupNoAdj(0, nums, 7));
	}
	
	public static void groupSum6Call() {
		int [] nums = {5, 6, 2};
		gs6 = new GroupSum6();
		System.out.println("Group sum 6 ? " + gs6.groupSum6(0, nums, 8));
		System.out.println("Group sum 6 ? " + gs6.groupSum6(0, nums, 9));
		System.out.println("Group sum 6 ? " + gs6.groupSum6(0, nums, 7));
	}
	
	public static void groupSumCall() {
		int [] nums = {2, 4, 8};
		gs = new GroupSum();
		//System.out.println("Group sum possible? " + gs.groupSum(0,nums,10));
		System.out.println("Group sum possible1? " + gs.groupSum1(0,nums,10));
		System.out.println("Group sum possible1? " + gs.groupSum1(0,nums,14));
		System.out.println("Group sum possible1? " + gs.groupSum1(0,nums,9));
	}
}
