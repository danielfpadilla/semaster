package presentation;

public interface IView
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
   public void sortingArray(IActionHandler handler);
}
