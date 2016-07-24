import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class Scheduler {
	private static Job [] jobs ;
	
	public static void main(String [] args) {
		readInput();
		//printJobs();
		//weightedCompletionTimeDiffApproach();
		weightedCompletionRatioApproach();
	}
	
	public static void weightedCompletionRatioApproach() {
		Arrays.sort(jobs, new JobRatioComparator());
		//System.out.println("after applying RATIO comparator: ");
		//printJobs();
		
		int n = jobs.length;
		long [] C = new long[n];
		
		C[0] = jobs[0].length;
		
		long wSum = C[0] * jobs[0].weight;
		//System.out.print(C[0] + " ");
		for (int i=1; i<n; i++) {
			C[i] = C[i-1] + jobs[i].length;
			wSum += C[i] * jobs[i].weight;
			//System.out.print(C[i] + " ");
		}
		//System.out.println();
		System.out.println("Weighted SUM: " + wSum);
	}
	
	public static long weightedCompletionTimeDiffApproach() {
		Arrays.sort(jobs, new JobDiffComparator());
		//System.out.println("after applying comparator: ");
		//printJobs();
		int n = jobs.length;
		long [] C = new long[n];
		
		C[0] = jobs[0].length;
		
		long wSum = C[0] * jobs[0].weight;
		//System.out.print(C[0] + " ");
		for (int i=1; i<n; i++) {
			C[i] = C[i-1] + jobs[i].length;
			wSum += C[i] * jobs[i].weight;
			//System.out.print(C[i] + " ");
		}
		//System.out.println();
		System.out.println("Weighted SUM: " + wSum);
		
		return 0;
	}
	
	public static void printJobs() {
		int len = jobs.length;
		
		for (int i=0; i<len; i++) {
			System.out.println("W: " + jobs[i].weight + ":: L: " + jobs[i].length);
		}
	}
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			jobs = new Job[n];
			
			int index = 0;
			while (n > 0) {
				String [] strArr = br.readLine().trim().split(" ");
				int w = Integer.parseInt(strArr[0]);
				int len = Integer.parseInt(strArr[1]);
				jobs[index] = new Job(w, len);
				++index;
				--n;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class Job {
	int weight;
	int length;
	
	public Job(int w, int len) {
		this.weight = w;
		this.length = len;
	}
}

class JobRatioComparator implements Comparator<Job> {
	public int compare(Job j1, Job j2) {
		double ratio1 = (double)j1.weight / j1.length;
		double ratio2 = (double)j2.weight / j2.length;
		if (ratio1 < ratio2) {
			return 1;
		} else if (ratio1 > ratio2) {
			return -1;
		} else {
			if (j1.weight >= j2.weight) {
				return -1;
			}
			if (j1.weight < j2.weight) {
				return 1;
			}
		}
		return 0;
	}
}

class JobDiffComparator implements Comparator<Job> {
	public int compare(Job j1, Job j2) {
		int diff1 = j1.weight - j1.length;
		int diff2 = j2.weight - j2.length;
		if (diff1 < diff2) {
			return 1;
		} else if (diff1 > diff2) {
			return -1;
		} else {
			if (j1.weight > j2.weight) {
				return -1;
			}
			if (j1.weight < j2.weight) {
				return 1;
			}
		}
		return 0;
	}
}