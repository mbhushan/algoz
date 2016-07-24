
public class ListOperations {
	private static LinkListBasic singlyList;
	private static int N = 7;
	
	public static void main(String[] args) {
		singlyList = new LinkListBasic();
		
		singlyList.buildList(N);
		singlyList.printList();
		
		System.out.println("No. of nodes in the list is: " + singlyList.countNodes());
		System.out.println("Nth node: " + singlyList.getNthNode(4));
		
		//list deleted.
		singlyList.deleteList();
		singlyList.printList();
		
		singlyList.buildList(N);
		singlyList.printList();
		
		System.out.println("Inserting nodes in list");
		singlyList.insertNth(9);
		singlyList.printList();
		
//		System.out.println("Popped: "  + singlyList.popFromList());
//		singlyList.printList();
//		System.out.println("Popped: "  + singlyList.popFromList());
//		singlyList.printList();
//		System.out.println("Popped: "  + singlyList.popFromList());
//		singlyList.printList();
	}
}
