import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class TransformWords {
	private String start;
	private String end;
	private Set<String> wordSet;
	
	public static void main(String[] args) {
		TransformWords tw = new TransformWords();
		
		tw.readInput();
		tw.findPath();
	}
	
	
	
	public void findPath() {
		Queue<String> qu = new LinkedList<String>();
		Map<String, String> wordParent = new HashMap<String,String>();
		
		qu.add(start);
		wordParent.put(start, null);
		int k = 0;
		
		boolean done = false;
		while (!qu.isEmpty()) {
			Iterator<String> setIter = wordSet.iterator();
			String src = qu.poll();
			while (setIter.hasNext()) {
				String target = setIter.next();
				if (!wordParent.containsKey(target)) {
					if (isOneLetterAway(src, target))  {
						qu.add(target);
						wordParent.put(target, src);
						System.out.println("Src: " + src +  "   .Target: " + target);
						
						if (target.equals(end)) {
							System.out.println("Ending " + k);
							done = true;
							break;
						}
					}
				}	
			}
			if (done) { break; }
			++k;
			Iterator<String> it = qu.iterator();
			while (it.hasNext()) {
				String s = it.next();
				wordSet.remove(s);
				System.out.println("removed from set: " + s);
			}
		}
		String str = end;
		Stack<String> stack = new Stack<String>();
		stack.push(str);
		while (!str.equals(start)) {
			str = (String)wordParent.get(str);
			if (str == null) {
				break;
			}
			stack.push(str);
		}
		System.out.println("Word path: ");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
	}
	
	public boolean isOneLetterAway(String src, String target) {
		int srcLen = src.length();
		int targetLen = target.length();
		
		if (srcLen != targetLen) {
			return false;
		} 
		
		if (src.equals(target))  { return false; }
		
		int numOfDiff = 0;
		
		for (int i=0; i<srcLen; i++) {
			if (src.charAt(i) != target.charAt(i)) {
				++numOfDiff;
			}
		}
		
		if (numOfDiff == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		wordSet = new HashSet<String>();
		
		try {
			start = br.readLine();
			end = br.readLine();
			
			int n = Integer.parseInt(br.readLine());
			
			while(n>0) {
				String [] str = br.readLine().split(" ");
				for (int i=0; i<str.length; i++) {
					wordSet.add(str[i]);
				}
				--n;
			}
			
			//print the input.
			
//			Iterator<String> iter = wordSet.iterator();
//			System.out.println("Printing input: ");
//			while (iter.hasNext()) {
//				System.out.print(iter.next() + " ");
//			}
//			System.out.println();
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
