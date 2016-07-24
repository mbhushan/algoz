import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;


public class MainClass {

	static int[] array = null;
	static int maxValueOfData = 1000000;

	static int[] mapArr = new int[maxValueOfData];;
	
	
	static long consoleReadTime;
	
	public static void main(String[] args) throws Exception{
//		generateRandom();
//		sort();
		
		
		sortFromConsole();
		
		long time = System.currentTimeMillis();

		print();
		
//		System.out.println("ConsoleReadTime" + consoleReadTime);
//		System.out.println("PrintTime" + (System.currentTimeMillis()-time));
		
	}
	
	public static void sort(){
		for(int i=0;i<array.length;i++){
			mapArr[array[i]]++;
		}
	}
	
	public static void print(){
		StringBuffer stringBuffer = new StringBuffer();
		for(int i=0;i<mapArr.length;i++){
			if(mapArr[i]!=0){
				for(int j=0;j<mapArr[i];j++){
//					System.out.println(i);
					stringBuffer.append(Integer.toString(i) + '\n');
				}
			}
		}
		
		System.out.println(stringBuffer.toString());
	}

	
	public static void generateRandom(){
		Random generator = new Random(); 
		array = new int[1000000];
		
		for (int i=0; i<array.length; i++) {
			array[i] = generator.nextInt(maxValueOfData);
		}
	}
	
	public static void sortFromConsole() throws Exception{
		
		long startTime = -1;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in),1000000);
		int noOfElements = Integer.parseInt(br.readLine());
		
		for(int i=0;i<noOfElements;i++){
			int inData = Integer.parseInt(br.readLine());
			
			if(startTime==-1){
				startTime = System.currentTimeMillis();
			}
			
			mapArr[inData]++;
		}
		
		consoleReadTime = System.currentTimeMillis()-startTime;
	}
}
