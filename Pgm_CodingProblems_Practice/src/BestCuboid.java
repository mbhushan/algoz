import java.util.Arrays;
import java.util.Comparator;


public class BestCuboid {
	
	class Cube {
		int x; int y; int z;
		public Cube() {}
		public Cube(int x, int y, int z) {
			this.x = x; this.y = y; this.z = z;
		}
	}
	
	public int findBestCubeFit() {
		Cube [] cubes = new Cube[4];
		int len = cubes.length;
		int [] best = new int[len];
		
		for (int i=0; i<len; i++)  {
			cubes[i] = new Cube();
			best[i] = 1;
		}
		cubes[0].x = 7; cubes[0].y = 8; cubes[0].z = 9;
		cubes[1].x = 5; cubes[1].y = 6; cubes[1].z = 8;
		cubes[2].x = 5; cubes[2].y = 8; cubes[2].z = 7;
		cubes[3].x = 4; cubes[3].y = 4; cubes[3].z = 4;
		
		Arrays.sort(cubes, new LengthComparator());
		printCubeDimen(cubes);
		int ans = 1;
		
		for (int i=0; i<len; i++) {
			for (int j=0; j<i; j++)  {
				if (cubes[i].x >= cubes[j].x && cubes[i].y >= cubes[j].y
						&& cubes[i].z >= cubes[j].z) {
					best[i] = Math.max(best[i], best[j]+1);
				}
			}
			ans = Math.max(ans, best[i]);
		}
		
		return ans;
	}
	
	public void printCubeDimen(Cube [] cubes) {
		int len  = cubes.length;
		for (int i=0; i<len; i++) {
			System.out.println(cubes[i].x + " " + cubes[i].y + " " + cubes[i].z);
		}
		System.out.println();
	}
	
	public class LengthComparator implements Comparator<Cube> {

		@Override
		public int compare(Cube o1, Cube o2) {
			if (o1.x < o2.x) {
				return -1;
			} else if (o1.x > o2.x) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}
