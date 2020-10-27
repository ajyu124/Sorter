import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;

public class Sorter {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    Sorter s = new Sorter();
    s.run();
  }

  public void run() {
    Scanner inputData = OpenFile.openToRead("InputData.txt");
    PrintWriter outputSortedRanking = OpenFile.openToWrite("OutputSortedRanking.txt");
    
  }
}