

public class WordDistance {
	
	private String first;
	private String second;
	private Map<String,List> wordCount = new HashMap<String, List>();	
	private static int index = 1;
	
	public static void main(String[] args) {
		WordDistance wd  = new WordDistance();
		wd.readInput();
		wd.calculateDistance();
	}
	
	public void calculateDistance() {
		ArrayList<Integer> fList = (ArrayList<Integer>)wordCount.get(first);
		ArrayList<Integer> sList = (ArrayList<Integer>)wordCount.get(second);
		int [] a = new int[fList.size()];
		int [] b = new int[sList.size()];
		
		for (int i=0; i<a.length; i++)  {
			a[i] = fList.get(i);
		}
		
		for (int i=0; i<b.length; i++)  {
			b[i] = sList.get(i);
		}
		
		int i = 0;
		int j = 0;
		int minDist = Integer.MAX_VALUE;
		while (i<a.length && j<b.length){
			int dist  = 0;
			if (a[i] < b[j]){
				dist = b[j]-a[i] + 1;
				++i;
			} else {
				dist = a[i]-b[j] + 1;
				++j;
			}
			if (dist < minDist)  {
				minDist = dist;
			}
		}
		
		System.out.println("Min Distance is: " + minDist );
	}
	
	public void readInput () {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			first = br.readLine();
			second = br.readLine();
			
			int n = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			
			while (n > 0) {
				String [] s = br.readLine().split(" ");
				
				for (int i=0; i<s.length; i++) {
					if (!wordCount.containsKey(s[i])) {
						List<Integer> indexList = new ArrayList<Integer>();
						indexList.add(index);
						wordCount.put(s[i], indexList);
					} else {
						List<Integer> indexList = (ArrayList<Integer>)wordCount.get(s[i]);
						indexList.add(index);
						wordCount.put(s[i], indexList);
					}
					++index;
				}
				--n;
			}
			//print the word indices;
			Iterator iter = wordCount.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry<String, ArrayList> pair = (Map.Entry<String, ArrayList>)iter.next();
				ArrayList<Integer> indices = (ArrayList<Integer>)pair.getValue();
				System.out.print(pair.getKey() + ": ");
				Iterator it = indices.iterator();
				while  (it.hasNext()) {
					Integer i  = (Integer)it.next();
					System.out.print(i +  " ");
				}
				System.out.println();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
