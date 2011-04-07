
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
	public void processExpectationAction() 
	{	
		if(m_view.m_type == 1)
		{			
			double[] array;
			int size = Integer.parseInt(m_view.m_size);
			array = new double[size];
			for(int i = 0; i < size; i++)
			{
				array[i] = m_view.m_arrayOfValue[i];
			}
			
			double result = m_statistics.expectationForEquiprobabilityDistribution(array);
			m_view.m_result = String.valueOf(result);	
		} else
		{
			double[] arrayOfValue;
			double[] arrayOfProbability;
			int size = Integer.parseInt(m_view.m_size);
			arrayOfValue = new double[size];
			arrayOfProbability = new double[size];
			for(int i = 0; i < size; i++)
			{
				arrayOfValue[i] = m_view.m_arrayOfValue[i];
				arrayOfProbability[i] = m_view.m_arrayOfProbability[i];				
			}
			
			double result = m_statistics.expectationForDiscreteDistribution(arrayOfValue, arrayOfProbability);
			m_view.m_result = String.valueOf(result);			
		}
	}	
	
	public void processVarianceAction()
	{
		if(m_view.m_type == 1)
		{			
			double[] array;
			int size = Integer.parseInt(m_view.m_size);
			array = new double[size];
			for(int i = 0; i < size; i++)
			{
				array[i] = m_view.m_arrayOfValue[i];
			}
			
			double result = m_statistics.varianceForEquiprobabilityDistribution(array);
			m_view.m_result = String.valueOf(result);	
		} else
		{
			double[] arrayOfValue;
			double[] arrayOfProbability;
			int size = Integer.parseInt(m_view.m_size);
			arrayOfValue = new double[size];
			arrayOfProbability = new double[size];
			for(int i = 0; i < size; i++)
			{
				arrayOfValue[i] = m_view.m_arrayOfValue[i];
				arrayOfProbability[i] = m_view.m_arrayOfProbability[i];				
			}
			
			double result = m_statistics.varianceForDiscreteDistribution(arrayOfValue, arrayOfProbability);
			m_view.m_result = String.valueOf(result);			
		}		
	}
	
	public void processThirdInitialMomentAction()
	{
		if(m_view.m_type == 1)
		{			
			double[] array;
			int size = Integer.parseInt(m_view.m_size);
			array = new double[size];
			for(int i = 0; i < size; i++)
			{
				array[i] = m_view.m_arrayOfValue[i];
			}
			
			double result = m_statistics.thirdInitialMomentForEquiprobabilityDistribution(array);
			m_view.m_result = String.valueOf(result);	
		} else
		{
			double[] arrayOfValue;
			double[] arrayOfProbability;
			int size = Integer.parseInt(m_view.m_size);
			arrayOfValue = new double[size];
			arrayOfProbability = new double[size];
			for(int i = 0; i < size; i++)
			{
				arrayOfValue[i] = m_view.m_arrayOfValue[i];
				arrayOfProbability[i] = m_view.m_arrayOfProbability[i];				
			}
			
			double result = m_statistics.thirdInitialMomentForDiscreteDistribution(arrayOfValue, arrayOfProbability);
			m_view.m_result = String.valueOf(result);			
		}		
	}
	
	public void processFourthInitialMomentAction()
	{
		if(m_view.m_type == 1)
		{			
			double[] array;
			int size = Integer.parseInt(m_view.m_size);
			array = new double[size];
			for(int i = 0; i < size; i++)
			{
				array[i] = m_view.m_arrayOfValue[i];
			}
			
			double result = m_statistics.fourthInitialMomentForEquiprobabilityDistribution(array);
			m_view.m_result = String.valueOf(result);	
		} else
		{
			double[] arrayOfValue;
			double[] arrayOfProbability;
			int size = Integer.parseInt(m_view.m_size);
			arrayOfValue = new double[size];
			arrayOfProbability = new double[size];
			for(int i = 0; i < size; i++)
			{
				arrayOfValue[i] = m_view.m_arrayOfValue[i];
				arrayOfProbability[i] = m_view.m_arrayOfProbability[i];				
			}
		
			double result = m_statistics.fourthInitialMomentForDiscreteDistribution(arrayOfValue, arrayOfProbability);
			m_view.m_result = String.valueOf(result);
		}
	}

	@Override
	public void processThirdCentralMomentAction()
	{
		double[] arrayOfValue;
		double[] arrayOfProbability;
		int size = Integer.parseInt(m_view.m_size);
		arrayOfValue = new double[size];
		arrayOfProbability = new double[size];
		for(int i = 0; i < size; i++)
		{
			arrayOfValue[i] = m_view.m_arrayOfValue[i];
			arrayOfProbability[i] = m_view.m_arrayOfProbability[i];				
		}
		
		double result = m_statistics.thirdCentralMoment(arrayOfValue, arrayOfProbability);
		m_view.m_result = String.valueOf(result);	
	}

	@Override
	public void processFourthCentralMomentAction()
	{
		double[] arrayOfValue;
		double[] arrayOfProbability;
		int size = Integer.parseInt(m_view.m_size);
		arrayOfValue = new double[size];
		arrayOfProbability = new double[size];
		for(int i = 0; i < size; i++)
		{
			arrayOfValue[i] = m_view.m_arrayOfValue[i];
			arrayOfProbability[i] = m_view.m_arrayOfProbability[i];				
		}
		
		double result = m_statistics.fourthCentralMoment(arrayOfValue, arrayOfProbability);
		m_view.m_result = String.valueOf(result);
		
	}

	@Override
	public void processSkewnessAction() 
	{
		double[] arrayOfValue;
		double[] arrayOfProbability;
		int size = Integer.parseInt(m_view.m_size);
		arrayOfValue = new double[size];
		arrayOfProbability = new double[size];
		for(int i = 0; i < size; i++)
		{
			arrayOfValue[i] = m_view.m_arrayOfValue[i];
			arrayOfProbability[i] = m_view.m_arrayOfProbability[i];				
		}
		
		double result = m_statistics.skewness(arrayOfValue, arrayOfProbability);
		m_view.m_result = String.valueOf(result);		
	}

	@Override
	public void processExcessAction() 
	{
		double[] arrayOfValue;
		double[] arrayOfProbability;
		int size = Integer.parseInt(m_view.m_size);
		arrayOfValue = new double[size];
		arrayOfProbability = new double[size];
		for(int i = 0; i < size; i++)
		{
			arrayOfValue[i] = m_view.m_arrayOfValue[i];
			arrayOfProbability[i] = m_view.m_arrayOfProbability[i];				
		}
		
		double result = m_statistics.excess(arrayOfValue, arrayOfProbability);
		m_view.m_result = String.valueOf(result);
		
	}

	@Override
	public void processClearAction() 
	{
		/*if(m_view.m_type == 1)
		{			
			double[] array;
			array = new double[size];
			int size = Integer.parseInt(m_view.m_size);
			for(int i = 0; i < size; i++)
			{
				//array[i] = 0.0;
				m_view.m_arrayOfValue[i] = 0.0;
			}
			int size = Integer.parseInt(m_view.m_size);
			size = 0;*/
			m_view.m_size = "0";			
			m_view.m_value = " ";
			m_view.m_probability = " ";
		//	m_view.m_type = 0;
			
					
			
		/*		
		} else
		{
			double[] arrayOfValue;
			double[] arrayOfProbability;
			int size = Integer.parseInt(m_view.m_size);
			arrayOfValue = new double[size];
			arrayOfProbability = new double[size];
			for(int i = 0; i < size; i++)
			{
				arrayOfValue[i] = m_view.m_arrayOfValue[i];
				arrayOfProbability[i] = m_view.m_arrayOfProbability[i];				
			}
		
			double result = m_statistics.fourthInitialMomentForDiscreteDistribution(arrayOfValue, arrayOfProbability);
			m_view.m_result = String.valueOf(result);
		}		*/
	}

	@Override
	public void processParseArgumentAction()
	{
		m_view.value = m_view.m_value.split("\\,");
		m_view.m_arrayOfValue = new double[m_view.size];
		for(int i = 0; i < m_view.size; i++)
		{
			m_view.m_arrayOfValue[i] = Double.parseDouble(m_view.value[i]);
		}
		if(m_view.m_type == -1)
		{
			m_view.probability = m_view.m_probability.split("\\,");
			m_view.m_arrayOfProbability = new double[m_view.size];
			
			for(int i = 0; i < m_view.size; i++)
			{
				m_view.m_arrayOfProbability[i] = Double.parseDouble(m_view.probability[i]);
			}
		}
		
		
	}
	
	
	
}
