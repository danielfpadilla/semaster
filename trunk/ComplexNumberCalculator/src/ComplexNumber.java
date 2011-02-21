
public class ComplexNumber
{
	public double real = 0.0;
	public double m_imaginary = 0.0;
	
	private final double delta = 0.01;

	public ComplexNumber(double real, double imaginary)
	{
		this.real = real;
		m_imaginary = imaginary;
	}
	
	public void f() {}
	
	public ComplexNumber()
	{
	}
	
	// number1.equals(number2)
	// public class Object {
	//   public boolean equals(Object otherObject)
	
	public boolean equals(Object otherObject)
	{
		ComplexNumber otherNumber = (ComplexNumber)otherObject;
		if (Math.abs(real - otherNumber.real) < delta &&
		    Math.abs(m_imaginary - otherNumber.m_imaginary) < delta)
		    return true;
		else
			return false;
		
	}
	
	public String toString()
	{
		return "real = " + Double.toString(real) + " imaginary = " + Double.toString(m_imaginary);
	}
}
