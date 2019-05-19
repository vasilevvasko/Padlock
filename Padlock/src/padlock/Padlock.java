package padlock;

import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Padlock {

    public static void main(String[] args) {
      
      // Declaring scanner and fetching user input  
      Scanner sc = new Scanner(System.in); 
      String cipherText = sc.nextLine();
      
      // Declaring character arrays, result used for outpit, textArray used to fill Hashmap
      char [] result = new char[4];
      char [] textArray = cipherText.toCharArray();
      
      // Declaring LinkedHashMap(keep track of order of characters) instance and Map instance(find the most common characters)
      HashMap<Character, Integer> HMap = new LinkedHashMap<>();      
      Map.Entry<Character, Integer> maxEntry = null;
      
       // Fills the hashmap
       fillMap(HMap, textArray);
       
       // Visualizes the hashmap, commented out as it is not a requrement.
//       visualizeMap(HMap);
       
       // Finds the 4 most common occrences in the hashmap and stores them in the result array
       findFourMostCommontOccureences(HMap, maxEntry, result);
       
       // Outputs the result array
       printResult(result); 
    } 
    
    
 public static void fillMap(HashMap <Character, Integer> HMap, char [] textArray) {
     
     // A loop iterates through the text array which stores the user input,
     // Increases the value corresponding to each character(key), creates a new key (character) for each character not found in the hashmap 
     for (int i = 0; i < textArray.length; i++) {
            if(HMap.containsKey(textArray[i])) {
                HMap.put(textArray[i], HMap.get(textArray[i]) + 1);
            }
            else {
                HMap.put(textArray[i], 1);
            }
        }
 }
 
 public static void findFourMostCommontOccureences(HashMap <Character, Integer> HMap, Map.Entry<Character, Integer> maxEntry, char [] result) {
     
     //Iterates through the hashmap 4 times, finds the greatest value and stores its corresponding key (character) in the result array,
     //Sets the max value to 0 so that it does not interfere with the next loop
     for (int i = 0; i < 4; i++) 
        {
            for (Map.Entry<Character, Integer> entry : HMap.entrySet())
            {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)               
                    maxEntry = entry;                                                     
            } 
        result[i] = maxEntry.getKey();
                maxEntry.setValue(0);

        }
 }
 
 public static void printResult(char [] result) {
     
     //Prints the result array
     for (int i = 0; i < 4; i++) {
            System.out.print(result[i]);
        }
        System.out.println();
 }
 
 public static void visualizeMap(HashMap <Character, Integer> HMap) {
     
     //Prints the keys and values of the hash map
      for (Map.Entry<Character, Integer> entry: HMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + " : " + value);
        }
 }
 
}
    
