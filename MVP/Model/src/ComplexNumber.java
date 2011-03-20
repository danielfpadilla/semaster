public class ComplexNumber
{

	private double real;
	private double imaginary;

	public ComplexNumber(double real, double imaginary)
	{
		this.setReal(real);
		this.imaginary = imaginary;
	}

	public boolean equals(Object object)
	{
		ComplexNumber number = (ComplexNumber) object;
		if (number.getReal() == getReal()
				&& number.getImaginary() == getImaginary())
			return true;
		else
			return false;
	}

	public ComplexNumber add(ComplexNumber other)
	{
		return new ComplexNumber(other.getReal() + getReal(),
				other.getImaginary() + getImaginary());
	}

	public ComplexNumber multiply(ComplexNumber other)
	{
		return new ComplexNumber(
				other.getReal() * getReal() - other.getImaginary() * getImaginary(), 
				other.getReal() * getImaginary() + other.getImaginary() * getReal());
	}

	public void setReal(double real)
	{
		this.real = real;
	}

	public double getReal()
	{
		return real;
	}

	public void setImaginary(double imaginary)
	{
		this.imaginary = imaginary;
	}

	public double getImaginary()
	{
		return imaginary;
	}

	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(Double.toString(real));
		buffer.append(imaginary < 0 ? " - " : " + ");
		buffer.append(Double.toString(Math.abs(imaginary)) + "i");
		return buffer.toString();
	}
}
