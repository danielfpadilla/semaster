package edu.semaster.checkers.view;

public class Position
{
public int x;
public int y;

public Position (){}
public Position (int x,int y)
{ 
this.x=x;
this.y=y;
}

public void setx(int x)
{ 
	this.x=x;	
}
public void sety(int y)
{ 
	this.y=y;	
}
public int getx()
{ 
	return x;	
}
public int gety( )
{ 
	return y;	
}

}
