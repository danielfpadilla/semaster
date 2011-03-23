package Presentation;

import sortingAlgorithms.MergeSort;
import sortingAlgorithms.QuickSort;

public class Presenter
{
   private MergeSort m_mergeSort;
   private QuickSort m_quickSort;
   public Iview m_view;



public Presenter(FakeView m_view)
{
	return;
}

public void setM_mergeSort(MergeSort m_mergeSort)
{
	this.m_mergeSort = m_mergeSort;
}

public MergeSort getM_mergeSort()
{
	return m_mergeSort;
}

public void setM_quickSort(QuickSort m_quickSort)
{
	this.m_quickSort = m_quickSort;
}

public QuickSort getM_quickSort()
{
	return m_quickSort;
}
   
}
