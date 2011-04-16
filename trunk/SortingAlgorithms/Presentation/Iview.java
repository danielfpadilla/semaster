package Presentation;

public interface Iview
{
   public String getUnsortedArray();
   public void setUnsortedArray(String unsortedArray);
   public boolean mergeSortIsSelected();
   public boolean quickSortIsSelected();
   public void setSortedArray(String sortedArray);
   public String getArraySize();
   public void generateRandomArray(IActionHandler handler);
   public void selectedArraySize(IActionHandler handler);
   public void sortArray(IActionHandler handler);
}
