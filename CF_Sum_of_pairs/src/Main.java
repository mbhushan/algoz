import java.io.IOException;
import java.util.*; 

public class Main {
	
	public int array_Size = 0;
	public int [] number_array;
	
			
	@SuppressWarnings("unchecked")
	public void computeGoodArray() {
		
		Hashtable<Integer, List> pairMap = new Hashtable<Integer, List>();
		Hashtable<Integer, List> pairMapFirstIndex = new Hashtable<Integer, List>();
		List<Integer> pairList = new ArrayList<Integer>();		
		
		int maxSet = 0;		
		
		Arrays.sort(number_array);
		
		for (int i=0; i < this.array_Size - 1; i++) {
			for (int j=i+1; j < this.array_Size; j++) {
				
				int pairSum = number_array[i] + number_array[j];
				
				List<Integer> firstIndexList = new ArrayList<Integer>();
				List<Integer> secondIndexList = new ArrayList<Integer>();
				
				
				if (!pairList.contains(pairSum)) {
					pairList.add(pairSum);

					firstIndexList.add(i);
					secondIndexList.add(j);

					pairMap.put(pairSum, secondIndexList);
					pairMapFirstIndex.put(pairSum, firstIndexList);

				} else {

					firstIndexList = (ArrayList<Integer>) pairMapFirstIndex.get(pairSum);
					secondIndexList = (ArrayList) pairMap.get(pairSum);

					if (!secondIndexList.contains(j)
							&& !firstIndexList.contains(i)) {
						firstIndexList.add(i);
						secondIndexList.add(j);

						List<Integer> intersection = new ArrayList<Integer>(
								firstIndexList);
						intersection.retainAll(secondIndexList);

						if (intersection.size() == 0) {
							pairMap.put(pairSum, secondIndexList);
							pairMapFirstIndex.put(pairSum, firstIndexList);

						} else {
							firstIndexList.remove(Integer.valueOf(i));
							secondIndexList.remove(Integer.valueOf(j));
						}
					}

				}
			}			
		}
		
		Iterator<Integer> itr = pairList.iterator(); 
		
		while (itr.hasNext()) {
			List<Integer> pairsVal = (ArrayList<Integer>)pairMap.get((Integer)itr.next());
			if ( pairsVal.size() > maxSet) {
				maxSet = pairsVal.size();
			}
		}
		
		System.out.println(Integer.valueOf(maxSet*2));
	}
	
	public static void main(String [] args) throws IOException{
		Main obj = new Main();	
		
		int in = 0;
		
		Scanner sc = new Scanner(System.in);	
		
		while (sc.hasNextInt()) {
			obj.array_Size = sc.nextInt();				
			obj.number_array = new int[obj.array_Size];
			
			while (in != obj.array_Size) {
				obj.number_array[in] = sc.nextInt();
				in = in + 1;
			}
			obj.computeGoodArray();
			in = 0;
		}
		
	}
}
