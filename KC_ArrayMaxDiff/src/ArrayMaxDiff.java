
public class ArrayMaxDiff {
	
	public static void main(String[] args) {
		int [] A = {6,5,9,15,29,7,4};
		int len = A.length;
		Data [] dataArr = new Data[len];
		
		for (int i=0; i<len; i++) {
			dataArr[i] = new Data(i, A[i]);
		}
		maxDistance(dataArr);
	}
	
	public static void maxDistance(Data [] D) {
		int len = D.length;
		Data [] minArr = new Data[len-1];
		Data [] maxArr = new Data[len-1];
		
		int k=0;
		for (int i=1; i<len; i++) {
			if (D[i].value <= D[i-1].value) {
				minArr[k] = new Data(D[i].id, D[i].value);
			} else {
				minArr[k] = new Data(D[i-1].id, D[i-1].value);
			}
			++k;
		}
		
		k=len-2;
		for (int i=len-2; i>=0; i--) {
			if (D[i].value >= D[i+1].value) {
				maxArr[k] = new Data(D[i].id, D[i].value);
			} else {
				maxArr[k] = new Data(D[i+1].id, D[i+1].value);
			}
			--k;
		}
		
		int j=0, i=0;
		int arrLen = maxArr.length;
		int maxDist = 0;
		int startIndex = 0;
		int endIndex = 0;
		while (i<arrLen && j<arrLen) {
			if (minArr[i].value < maxArr[j].value) {
				if (maxDist <= (j-i)) {
					maxDist = j-i;
					startIndex = minArr[i].id; endIndex = maxArr[j].id;
				}
				++j;
			} else {
				++i;
			}
		}
		System.out.println("Max Distance: " + maxDist);
		System.out.println("i:" + startIndex + "   j:" + endIndex);
	}

}

class Data {
	int id;
	int value;
	
	public Data(int id, int value) {
		this.id = id;
		this.value = value;
	}
}
