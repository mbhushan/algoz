import java.util.Scanner;


public class Main {

      static int[][] matrix;
      static int[] merger;
      static int noOfInputLines;
      
      static Scanner reader;
      
      static StringBuffer outputBuffer = new StringBuffer();
      
      public static void main(String[] args) {

    	  reader = new Scanner(System.in);
    	  
    	  int noOfTest = reader.nextInt();
    	  
    	  for(int i=0;i<noOfTest;i++){
    		  executeTest();
    	  }
    	  
          System.out.print(outputBuffer.toString());

      }
      
      static void executeTest(){
            readInput();
            
            process();
            
            print();
            
            check();
            
      }
      
      
      static void readInput(){
            noOfInputLines = reader.nextInt();
            matrix = new int[26][26];
            merger = new int[26];
            
            for(int i=0;i<noOfInputLines;i++){
                  String line = reader.next();
                  
                  int startChar = line.charAt(0)-97;
                  int endChar = line.charAt(line.length()-1)-97;
                  matrix[startChar][endChar]++;
            }
      }
      
      
      static void process(){

            int index = 0;
            
            int failureCount = 0;
            
            while(true){
            	
            	boolean found = false;
//            	System.out.println("Index: " + index); 
                  int x = index/26;
                  int y = index%26;

                  // ignore if it is 0
                  if(matrix[x][y]!=0){
                        
                        // check for diagonal numbers
                        if(x==y && merger[x]==1){
                              matrix[x][y] = 0;
                              found = true;
//                              System.out.println("Setting last position1 "  + lastPosition);
                        }else if(x==y && matrix[x][y]>1){
                        	merger[y]=1;
                            matrix[x][y] = 1;
                            found = true;
//                            System.out.println("Setting last position2 "  + lastPosition);
                        }else{

                              for(int i=0;i<26;i++){
                              
                                    if(x==y && y==i) continue;
                                    
                                    if(matrix[y][i]!=0){
                                          // merge this two element, and set the value in merger
                                          matrix[x][y]--;
                                          matrix[y][i]--;
                                          matrix[x][i]++;

                                          merger[y]=1;
                                          found = true;
//                                          System.out.println("Setting last position3 "  + lastPosition);
                                          break;
                                    }
                              }
                        }
                  }

                  if(!found){
                	  failureCount++;
                  }else{
                	  failureCount = 0;
                  }
                  
                  if(failureCount>(26*26+1)){
                	  break;
                  }
                  
                  index++;
                  index = index%(26*26);

                  
//                  if(!found && lastPosition == index){
//                	  System.out.println("Breaking");
//                        break;
//                  }
            }
      }
      
      static void print(){
            for(int i=0;i<matrix.length;i++){
                  for(int j=0;j<matrix[i].length;j++){
                        System.out.print(matrix[i][j]+" ");
                  }
                  System.out.println('\n');
            }

            System.out.println("===================");

            for(int j=0;j<merger.length;j++){
                  System.out.print(merger[j]+" ");
            }
            
            System.out.println('\n');
      }
      
      static void check(){
            
            int points = 0;
            
            for(int i=0;i<matrix.length;i++){
                  for(int j=0;j<matrix[i].length;j++){
                        points+=matrix[i][j];
                  }
            }
            
            if(points>1){
            	outputBuffer.append("The door cannot be opened.\n");
            }else{
            	outputBuffer.append("Ordering is possible.\n");
            }
      }
}

