package Practice_Program;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Find_Anagrams_In_File {
	public static void main(String[] args) {

        try {

            Map<String, List<String>> mainMap = 
                   new HashMap<String, List<String>>();
            Set anagrams = new HashSet<String>();
            
            Scanner scan = new Scanner(new File("F:\\My_Programs\\test_file.txt"));//please use your file
            while (scan.hasNext()) {
                String word = scan.next().toLowerCase();
		word=word.replaceAll("[^a-zA-Z0-9]", "");
                String alpha = sorting(word);
                Scanner scan1 = new Scanner(new File("F:\\My_Programs\\test_file.txt"));//please use your file
              
                while (scan1.hasNext()) {
                	
                    String word1 = scan1.next().toLowerCase();
		    word1=word1.replaceAll("[^a-zA-Z0-9]", "");
                    String alpha1 = sorting(word1);
                    if(alpha.equalsIgnoreCase(alpha1))
                    {
                    	anagrams.add(word1);
                    }
                    
                }
             
                anagrams.add(word);
                List anagramsTemp = new ArrayList(anagrams);
                if(anagramsTemp.size()>1)
                {
                	mainMap.put(alpha.toLowerCase(), anagramsTemp);
                }
                anagrams.removeAll(anagrams);
            }
            System.out.println("---------------------------------------------------------------------------");
            System.out.println(mainMap);
            System.out.println("---------------------------------------------------------------------------");
            for (String tempString : mainMap.keySet()) {
				System.out.println(tempString+" group count="+mainMap.get(tempString).size());
			}
            System.out.println("---------------------------------------------------------------------------");

        } 
    catch (Exception e) {
            System.out.println(e);
        }

    }

    public static String sorting(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
	
}
