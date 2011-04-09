package presentation;

public interface Iview
{
   public String getUnsortedArray();
   public void setUnsortedArray(String sortedArray);
   public String getSortingMethod();
   public void setSortedArray(String sortedArray);
   public String getArraySize();
   public void generateRandomArray(IActionHandler handler);
   public void sortArray(IActionHandler handler);
}
