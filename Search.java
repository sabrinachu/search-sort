import java.util.Arrays;

public class Search {
  //Returns a pseudorandom int n in the range
  //min <= n <= max
  public static void seed(int[] array, int min, int max) {
    for (int i = 0; i < array.length; i++) {
      array[i] = min + (int)(Math.random() * (max-min+1));
    }
  }
  
  public static void seedSorted(int[] array) {
    array[0] = 0;
    for (int i = 1; i < array.length; i++)
      array[i] = array[i-1] + (int)(Math.random() * 3);
  }
  
  public static boolean contains(int[] array, int value) {
    for (int x : array)
      if (x == value)
        return true;
    return false;
  }
  
  public static int seqSearch(int[] array, int value) {
    for (int i = 0; i < array.length; i++)
      if (array[i] == value)
        return i;
    return -1;
  }
  
  public static int binarySearch(int[] array, int value) {
    int minIndex = 0; 
    int maxIndex = array.length - 1;  

    while(minIndex <= maxIndex)
    {
      int middle = (minIndex + maxIndex)/2; //always calculates the middle of the current range 
      if(array[middle] > value)
      {
        if(maxIndex == middle) //if the value does not exist in the array, it will exit
        {
          break; 
        }
        maxIndex = middle; //sets the new max
      }
      else if(array[middle] < value)
      {
        if(minIndex == middle) //if the value does not exist in the array, it will exit
        {
          break;
        }
        minIndex = middle; //sets the new min
      }
      else if (array[middle] == value)
      {
        return middle; 
      }
      
    }
    
    return -1; //if the value does not exist in the array, returns -1
  }
  
  public static void main(String[] args) {
    int[] data = new int[1];
    seedSorted(data);
    System.out.println(Arrays.toString(data));
    int index = seqSearch(data, 37);
    if (index == -1)
      System.out.println("37 not found.");
    else
      System.out.println("37 found at location " + index);
    System.out.println(binarySearch(data, 3));
  }
  
  
}