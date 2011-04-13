package Presentation;

import java.util.Random;
import java.util.Collections; 
import Model.MergeSort;
import Model.QuickSort;
import Model.Sorting;



public class Presenter
{
	private Iview m_view;
	private Sorting m_sorting;
	private MergeSort m_mergeSort;
	private QuickSort m_quickSort;
	public Presenter(Iview view)
	{
		m_view = view;
		m_view.generateRandomArray(new IActionHandler()
		{
			
			@Override
			public void processAction()
			{
				Presenter.this.generateArrayRandomNumbers();
				
			}//
		}
		m_view.sortArray(new IActionHandler()
		{
			
			@Override
			public void processAction()
			{
				Presenter.this.sortingProcess();
				
			}
		}
		//
	}
	public void sortingProcess()
	{
		
		m_view.getSortingMethod();
		for(int i = 0; i < Integer.parseInt(m_view.getArraySize()); i++)
		{
			// parse a string to an array of integers!
			
			String m_myArray = new m_ArrayList(); 
			String[] m_myStringArray = new String[] {" "," ", " ", " "}; 
            Collections.addAll(m_myArray, m_myStringArray); 
			
			}
		m_view.setSortedArray(m_quickSort.sortingArray(Integer.parseInt(m_view.getUnsortedArray())));
		m_view.setSortedArray(m_mergeSort.sortingArray(Integer.parseInt(m_view.getUnsortedArray())));
	}
	public void generateArrayRandomNumbers()
	{
		int m_arraySize;
		m_arraySize = Integer.parseInt(m_view.getArraySize());
		Random rand = new Random();
		m_view.setUnsortedArray("");
		for(int i = 0; i < m_arraySize; i++)
		{
			m_view.setUnsortedArray("" + rand.nextInt(1000));
		}
		
	}
}
