import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.TimeUnit;


//I decided to make this its own class for encapsulation and so that I could subclass it with the different solar objects.
public class SolarObject
{
    //Variables that don't change once set like colour, diameter and distance are set to final so they don't change.
	private final double distance;
	private double angle;
	private final double diameter;
	private final String col;
    private double x;
    private double y;
    

	public SolarObject(double distance, double angle, double diameter, String col)
	{
		this.distance = distance;
		this.angle = angle;
		this.diameter = diameter;
		this.col = col;
	}
    //I made get and set methods for all non-final variables so that if anyone wants to add to the code they can alter these values without changing the code.
    public final double GetDistance()
    {
        return distance;   
    }

    public final double GetAngle()
    {
        return angle;   
    }

    public final double GetDiameter()
    {
        return diameter;   
    }

    public final String GetColour()
    {
        return col;   
    }

    public final double GetX()
    {
        return x;   
    }

    public final double GetY()
    {
        return y;   
    }

    public final void SetAngle(double newAngle)
    {
        angle = newAngle;   
    }

    public final void SetX(double newX)
    {
        x = newX;   
    }

    public final void SetY(double newY)
    {
        y = newY;   
    }
}