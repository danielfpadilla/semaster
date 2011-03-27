
public class Presenter implements IEventHandler
{	
	private View m_view;
	
	public Presenter(View view)
	{
		m_view = view;
		m_view.m_handler = this;
	}
	
	@Override
	public void processAddAction() 
	{
		int result = Integer.parseInt(m_view.m_number1) + Integer.parseInt(m_view.m_number2);
		m_view.m_result = String.valueOf(result);
				
	}

}
