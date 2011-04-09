package presentation;

import java.util.Random;

import sortingAlgorithms.MergeSort;
import sortingAlgorithms.QuickSort;
import sortingAlgorithms.Sorting;


public class Presenter
{
	private Iview m_view;
	private sortingAlgorithms.Sorting m_sorting;
	private sortingAlgorithms.MergeSort m_mergeSort;
	private sortingAlgorithms.QuickSort m_quickSort;
	public Presenter(Iview view)
	{
		m_view = view;
		m_view.generateRandomArray(new IActionHandler()
		{
			
			@Override
			public void processAction()
			{
				Presenter.this.generateArrayRandomNumbers();
				
			}
		});
		m_view.sortArray(new IActionHandler()
		{
			
			@Override
			public void processAction()
			{
				Presenter.this.sortingProcess();
				
			}
		});
	}
	public void sortingProcess()
	{
		
		m_view.getSortingMethod();
		for(int i = 0; i < Integer.parseInt(m_view.getArraySize()); i++)
		{
		  // To do - how to parse a string to an array if integers!
		}
		m_view.setSortedArray(m_quickSort.sortArray(Integer.parseInt(m_view.getUnsortedArray())));
		m_view.setSortedArray(m_mergeSort.sortArray(Integer.parseInt(m_view.getUnsortedArray())));
	}
	public void generateArrayRandomNumbers()
	{
	}
	}
