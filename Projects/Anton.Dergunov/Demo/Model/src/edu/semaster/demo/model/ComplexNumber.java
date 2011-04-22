package edu.semaster.demo.model;

public class ComplexNumber
{
	private double m_real;
	private double m_imaginary;

	public ComplexNumber(double real, double imaginary)
	{
		this.setReal(real);
		this.m_imaginary = imaginary;
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
		this.m_real = real;
	}

	public double getReal()
	{
		return m_real;
	}

	public void setImaginary(double imaginary)
	{
		this.m_imaginary = imaginary;
	}

	public double getImaginary()
	{
		return m_imaginary;
	}

	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(Double.toString(m_real));
		buffer.append(m_imaginary < 0 ? " - " : " + ");
		buffer.append(Double.toString(Math.abs(m_imaginary)) + "i");
		return buffer.toString();
	}
}
