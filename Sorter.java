import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class Sorter {

  public static void main(String[] args) {
    Sorter s = new Sorter();
    s.run();
  }

  int currentComparisonNum = 1;

  public void run() {
    
    Random rand = new Random();
    Scanner inputData = OpenFile.openToRead("InputData.txt");
    PrintWriter outputSortedRanking = OpenFile.openToWrite("OutputSortedRanking.txt");
    ArrayList<String> elements = new ArrayList<String>();

    while (inputData.hasNext()) {
        elements.add(inputData.nextLine());
    }

    System.out.println("\n------------------------\n");
    System.out.println("Welcome to the Sorter!\n");
    System.out.println("------------------------");

    MergeSort sorter = new MergeSort(elements);
    sorter.sortGivenArray();
    ArrayList<String> elementsRanked = sorter.getSortedArray();
    int numOfElements = elementsRanked.size();

    outputSortedRanking.write("RESULTS: \n");
    for (int ind = 0; ind < elementsRanked.size(); ind++) {
        outputSortedRanking.write((ind+1)+": "+elementsRanked.get(ind)+"\n");
    }

    System.out.println("\n\n-----------------------------");
    System.out.println("Your ranking is complete! Check OutputSortedRanking.txt.");
    System.out.println("It took a total of "+(sorter.currentComparisonNum-1)+" comparisons to sort "+numOfElements+" elements.\n\n");

    outputSortedRanking.close();
    
  }

}