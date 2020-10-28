import java.util.ArrayList;
import java.io.*;
import java.util.*;
 
public class MergeSort {

  // Modified version from GeeksForGeeks

    private ArrayList<String> inputArray;
    public int currentComparisonNum = 1;
    Scanner consoleScanner = new Scanner(System.in);
    
    public ArrayList<String> getSortedArray() {
        return inputArray;
    }
 
    public MergeSort(ArrayList<String> inputArray){
        this.inputArray = inputArray;
    }
    
    public void sortGivenArray(){       
        divide(0, this.inputArray.size()-1);
    }
    
    public void divide(int startIndex,int endIndex){
        
        //Divide till you breakdown your list to single element
        if(startIndex<endIndex && (endIndex-startIndex)>=1){
            int mid = (endIndex + startIndex)/2;
            divide(startIndex, mid);
            divide(mid+1, endIndex);        
            
            //merging Sorted array produce above into one sorted array
            merger(startIndex,mid,endIndex);            
        }       
    }   
    
    public void merger(int startIndex,int midIndex,int endIndex){
        
        //Below is the mergedarray that will be sorted array Array[i-midIndex] , Array[(midIndex+1)-endIndex]
        ArrayList<String> mergedSortedArray = new ArrayList<String>();
        
        int leftIndex = startIndex;
        int rightIndex = midIndex+1;
        
        while(leftIndex<=midIndex && rightIndex<=endIndex){
            //if(inputArray.get(leftIndex)<=inputArray.get(rightIndex)){
              if(isLessThan(inputArray.get(leftIndex),inputArray.get(rightIndex))){
                mergedSortedArray.add(inputArray.get(leftIndex));
                leftIndex++;
            }else{
                mergedSortedArray.add(inputArray.get(rightIndex));
                rightIndex++;
            }
        }       
        
        //Either of below while loop will execute
        while(leftIndex<=midIndex){
            mergedSortedArray.add(inputArray.get(leftIndex));
            leftIndex++;
        }
        
        while(rightIndex<=endIndex){
            mergedSortedArray.add(inputArray.get(rightIndex));
            rightIndex++;
        }
        
        int i = 0;
        int j = startIndex;
        //Setting sorted array to original one
        while(i<mergedSortedArray.size()){
            inputArray.set(j, mergedSortedArray.get(i++));
            j++;
        }
    }

    public boolean isLessThan(String element1, String element2) {

      System.out.print("\n#"+ currentComparisonNum + " || 1: "+element1 + " | 2: " + element2 + " || ====> ");
      String response = consoleScanner.nextLine();
      while (!response.equalsIgnoreCase("1") && !response.equalsIgnoreCase("2")) {
            System.out.println("Invalid input. Try again.");
            System.out.print("\n#"+ currentComparisonNum + " || 1: "+element1 + " | 2: " + element2 + " || ====> ");
            response = consoleScanner.nextLine();
      }
      currentComparisonNum++;
      if (response.equalsIgnoreCase("1")) {
          return true;
      } else {
          return false;
      }

  }

}