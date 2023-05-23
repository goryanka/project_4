import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java. util.Arrays;

public class Project4{
	
	public static void main (String[] args)throws Exception
	{
		if(args.length < 1)
			System.out.println("Missing input file. Try again");
			
			
	//Step #0
 	    
    	ArrayList<String> dWords = new ArrayList<String>();
		ArrayList<String> dCanons = new ArrayList<String>();
		BufferedReader infile = new BufferedReader(new FileReader(args[0]));
		BufferedReader  jFile= new BufferedReader(new FileReader(args[1]));
		
		ArrayList<String> pairs  = new ArrayList<String>();
		 while(infile.ready()){
			 String word = infile.readLine();
		     pairs.add( cannonical(word) + " " + word);
		 }
			 
	   Collections.sort(pairs);
	
     	for(String p: pairs ){
		    String[]pair = p.split("\\s+");
			dCanons.add(pair[0]);
			dWords.add(pair[1]);
		}
	
		//Step #5
	    ArrayList<String> jWords = new ArrayList<String>();
		while(jFile.ready()){
			jWords.add(jFile.readLine());
		}
		jFile.close();
		Collections.sort(jWords);
		//Step #6
		for(String jWord: jWords)
		{
			System.out.print(jWord + " ");
			String jCanon = cannonical(jWord);
			
			int index = Collections.binarySearch(dCanons, jCanon);
			//System.out.println(index);
			
			 if (index >= 0)// found a match, might be just 1 or in the middle of the block
		  {
				while(index > 0 && dCanons.get(index).equals(jCanon))
				    --index; // will stop at one BEFORE the top
				++index; // step back on to the first match on dCanons
				while(index < dCanons.size() && dCanons.get(index).equals(jCanon) ){
					System.out.print(dWords.get(index)+ " ");
					++index;
			   }
		  }
		   System.out.print("\n");
		}
}
	static String cannonical(String s){
		char [] letters = s.toCharArray();
		Arrays.sort(letters);
		return new String(letters);
		
	}
	
	
	
	
}