
public class Presenter implements IEventHandler
{	
	private View m_view;
	private Statistics m_statistics = new Statistics();
	
	public Presenter(View view)
	{
		m_view = view;
		m_view.m_handler = this;
	}
	
	@Override
	public void processAddAction() 
	{
		double result = Double.parseDouble(m_view.m_number1) + Double.parseDouble(m_view.m_number2);
		m_view.m_result = String.valueOf(result);
				
	}

	@Override
	public void processMultiplyAction()
	{
		double result = Double.parseDouble(m_view.m_number1) * Double.parseDouble(m_view.m_number2);
		m_view.m_result =String.valueOf(result);		
	}

	@Override
	public void processExpectationAction() 
	{	
		/*if(m_view.m_type == 1)
		{*/
			
			double[] array;
			int size = Integer.parseInt(m_view.m_size);
			array = new double[size];
			for(int i = 0; i < size; i++)
			{
				array[i] =m_view.m_array[i];
			}
			
			double result = m_statistics.expectationForEquiprobabilityDistribution(array);
			m_view.m_result = String.valueOf(result);	
		/*} else
		{
			double number1 = Double.parseDouble(m_view.m_number1);
			double number2 = Double.parseDouble(m_view.m_number2);
			double probability1 = Double.parseDouble(m_view.m_probability1);
			double probability2 = Double.parseDouble(m_view.m_probability2);
			double[] arrayOfValue;
			double[] arrayOfProbability;
			arrayOfValue = new double[2];
			arrayOfProbability =new double[2];
			arrayOfValue[0] = number1;
			arrayOfValue[1] = number2;
			arrayOfProbability[0] = probability1;
			arrayOfProbability[1] = probability2;
			double result = m_statistics.expectationForDiscreteDistribution(arrayOfValue, arrayOfProbability);
			m_view.m_result = String.valueOf(result);
			
		}*/
	}	
	
	public void processVarianceAction()
	{
		double[] array;
		int size = Integer.parseInt(m_view.m_size);
		array = new double[size];
		for(int i = 0; i < size; i++)
		{
			array[i] =m_view.m_array[i];
		}
		
		double result = m_statistics.varianceForEquiprobabilityDistribution(array);
		m_view.m_result = String.valueOf(result);		
	}
	
	public void processThirdInitialMomentAction()
	{
		double[] array;
		int size = Integer.parseInt(m_view.m_size);
		array = new double[size];
		for(int i = 0; i < size; i++)
		{
			array[i] =m_view.m_array[i];
		}
		
		double result = m_statistics.thirdInitialMomentForEquiprobabilityDistribution(array);
		m_view.m_result = String.valueOf(result);
	}
	
	public void processFourthInitialMomentAction()
	{
		double[] array;
		int size = Integer.parseInt(m_view.m_size);
		array = new double[size];
		for(int i = 0; i < size; i++)
		{
			array[i] =m_view.m_array[i];
		}
		
		double result = m_statistics.fourthInitialMomentForEquiprobabilityDistribution(array);
		m_view.m_result = String.valueOf(result);
	}
	
	public void processSkewnessAction()
	{
		double[] array;
		int size = Integer.parseInt(m_view.m_size);
		array = new double[size];
		for(int i = 0; i < size; i++)
		{
			array[i] =m_view.m_array[i];
		}
		
		double result = m_statistics.skewness(arrayOfValue, arrayOfProbability)
		m_view.m_result = String.valueOf(result);
	}
	
}
