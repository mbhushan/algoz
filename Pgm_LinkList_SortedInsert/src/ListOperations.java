
public class ListOperations {
	private static SinglyLinkList aList;
	private static SinglyLinkList bList;
	private static int N = 7;
	
	public static void main(String[] args) {
		aList = new SinglyLinkList();
		bList = new SinglyLinkList();
		aList.builList(N);
		aList.printList();
		
		System.out.println("Doing sorted insert :)");
		bList.sortedInsert(N);
		System.out.println();
		bList.printList();
		
		System.out.println("Printing out the appended list:");
		appendList(aList, bList);
		aList.printList();
	}
	
	public static void appendList(SinglyLinkList a, SinglyLinkList b) {
		SinglyLinkList.Node aNode = a.getHead();
		
		while(aNode.link != null) {
			aNode = aNode.link;
		}
		aNode.link = b.getHead();
	}
}
