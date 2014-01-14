import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class Stats {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/nums.txt"));
			ArrayList<Double> list = new ArrayList<Double>();
			
			String str = null;
			double val = 0.0;
			while ((str = br.readLine()) != null) {
				val = Double.parseDouble(str);
				list.add(val);
			}
			
			int len = list.size();
			double sum = 0.0;
			for (Double d: list) {
				sum += d;
			}
			double mean = sum/len;
			
			sum = 0.0;
			for (Double d: list) {
				sum += ((d - mean) * (d - mean));
			}
			double std = Math.sqrt(sum/(len-1));
			DecimalFormat df = new DecimalFormat("#.##");
			System.out.println("Mean: " + df.format(mean));
			System.out.println("Std Deviation: " + df.format(std));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
