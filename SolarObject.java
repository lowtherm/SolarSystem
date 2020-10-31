import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.TimeUnit;


//I decided to make this its own class for encapsulation and so that I could subclass it with the different solar objects.
public class SolarObject
{
	private double distance;
	private double angle;
	private double diameter;
	private String col;
    private double x;
    private double y;
    

	public SolarObject(double distance, double angle, double diameter, String col)
	{
		this.distance = distance;
		this.angle = angle;
		this.diameter = diameter;
		this.col = col;
	}
    //I made get and set methods for all variables so that if anyone wants to add to the code they can alter these values without changing the code.
    public double GetDistance()
    {
        return distance;   
    }

    public double GetAngle()
    {
        return angle;   
    }

    public double GetDiameter()
    {
        return diameter;   
    }

    public String GetColour()
    {
        return col;   
    }

    public double GetX()
    {
        return x;   
    }

    public double GetY()
    {
        return y;   
    }

    public void SetDistance(double newDistance)
    {
        distance = newDistance;   
    }

    public void SetAngle(double newAngle)
    {
        angle = newAngle;   
    }

    public void SetDiameter(double newDiameter)
    {
        diameter = newDiameter;   
    }

    public void SetColour(String newColour)
    {
        col = newColour;   
    }

    public void SetX(double newX)
    {
        x = newX;   
    }

    public void SetY(double newY)
    {
        y = newY;   
    }
}