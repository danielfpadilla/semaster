
public class ParameterValueException extends Exception 
{
	private int detail = 0;
	public ParameterValueException(){}
	public ParameterValueException(int parameter)
	{
		this.detail = parameter;
	}
	public String toString()
	{
		return "ParameterValueException[" + this.detail + "]";
	}
}
