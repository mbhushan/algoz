import java.io.*;
import java.util.*;

public class FindAnagrams{
    static final int SIZE = 26;
    static final int DICT_SIZE = 45425;
    static Map primeMap  = new HashMap(SIZE);
    static Map dictionaryMap = new HashMap(DICT_SIZE);
    
public static void main(String [] args) throws IOException{
    int [] primeArr = new int[SIZE];
    int c = 'a';   
    getPrimes(primeArr);
    
    for(int i=0;i<SIZE;i++){        
        primeMap.put(new Integer(c+i), new Integer(primeArr[i]));        
    }       
    File dictionary = new File("C:\\manib_lib\\dictionaryFile.txt");
    genAnagrams(dictionary);    
}
private static void genAnagrams(File dictionary) throws IOException{
    StringBuffer contents = new StringBuffer();       
    long key = 1;
    String line = null;
    
    try{
        BufferedReader input = new BufferedReader(new FileReader(dictionary));
        try{            
            while((line = input.readLine()) != null){                
                key = genKey(line);
                String kStr = Long.toString(key);                    
                Collection list = new ArrayList();
                if(dictionaryMap.containsKey((Object)kStr)){                     
                     list = (ArrayList)dictionaryMap.get((Object)kStr);
                     list.add(line);
                    dictionaryMap.put(kStr,list);                        
                }else{                    
                    list.add(line);
                    dictionaryMap.put(kStr, list);                    
                }
            }
        }finally{
            input.close();
        }
    }catch(IOException ioe){
        ioe.printStackTrace();
    }    
    
     BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
     System.out.println("Enter the string : ");  
     System.out.flush();               
     if((line = stdin.readLine())  != null){
                key = genKey(line);
     }         
   Collection lookList = new ArrayList();
   if(dictionaryMap.containsKey(Long.toString(key))){
    lookList = (Collection)dictionaryMap.get(Long.toString(key));
    Iterator iter = lookList.iterator();
    System.out.println("Anagram(s) from dictionary are : ");
    while(iter.hasNext()){
        String s = (String)iter.next();   
        if(0 != line.compareToIgnoreCase(s)){
            System.out.println(s);                
        }            
    }    
   }else{
       System.out.println("No anagrams present !");
   }   
}
private static long genKey(String str){
    long key = 1;
    int len = str.length();
    str = str.toLowerCase(); 
    
    for(int i=0;i<len;i++){    
        if(primeMap.containsKey(new Integer(str.charAt(i)))){
        Integer prime = (Integer)primeMap.get(new Integer(str.charAt(i)));
        int value = prime.intValue();
        key = key * value;
        }
    }
    return key;
}
private static void getPrimes(int [] primeArr){
    int j,i,count;
    i = j = count = 0;
    boolean isPrime = true;
    
    primeArr[0] = 2;
    
    for(i=3; count < 26;i++){
        for(int k=0; k<=j; k++){
            if(i%primeArr[k] == 0){
                isPrime = false;
            }
        }
        if(isPrime){  
            ++j;
            primeArr[j] = i;
            count = j+1;            
        }
        else{
            isPrime = true;
        }       
    }
}
}
