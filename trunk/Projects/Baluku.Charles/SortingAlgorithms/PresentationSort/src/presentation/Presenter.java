package presentation;

import java.util.Random;
import sortingAlgorithms.MergeSort;
import sortingAlgorithms.QuickSort;


public class Presenter
{
	private IView m_view;
	private MergeSort m_mergeSort = new MergeSort();
	private QuickSort m_quickSort = new QuickSort();


	public Presenter(IView view)
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
		m_view.selectedArraySize(new IActionHandler()
		{

			@Override
			public void processAction()
			{
				Presenter.this.arraySizeParsing();

			}
		});
	}

	public void arraySizeParsing()
	{
		int arraySize;
		arraySize = Integer.parseInt(m_view.getArraySize());
		if (arraySize <= 0)
		{
			throw new IllegalArgumentException();
		}
	}

	public void sortingProcess()
	{
		if (m_view.mergeSortIsSelected())
		{

			m_view.setSortedArray(convertIntArrayToString(m_mergeSort
					.sortInternal(convertStringToIntArray(m_view
							.getUnsortedArray()))));

		}
		if (m_view.quickSortIsSelected())
		{

			m_view.setSortedArray(convertIntArrayToString(m_quickSort
					.sortInternal(convertStringToIntArray(m_view
							.getUnsortedArray()))));

		}
	}

	private static String convertIntArrayToString(int[] arrayInts)
	{
		String arrayString = "";
		for (int i : arrayInts)
		{
			arrayString += i + " ";
		}
		return arrayString;
	}

	private static int[] convertStringToIntArray(String arrayString)
	{
		String[] arrayStringList = arrayString.split(",");
		int[] arrayInts = new int[arrayStringList.length];
		int i = 0;
		for (String s : arrayStringList)
		{
			arrayInts[i++] = Integer.parseInt(s);
		}
		return arrayInts;
	}

	public void generateArrayRandomNumbers()
	{
		
		int m_arraySize;
		m_arraySize = Integer.parseInt(m_view.getArraySize());
		Random rand = new Random();
		m_view.setUnsortedArray(",");
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < m_arraySize; i++)
		{
			m_view.setUnsortedArray("," + rand.nextInt(100));
			 buffer.append(rand.nextInt(100) + ",");
		}
		 m_view.setUnsortedArray(buffer.toString());

	}
}
