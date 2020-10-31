import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Moon extends SolarObject
{
    private double centreOfRotationDistance;
	private double centreOfRotationAngle;

	public Moon(double distance, double angle, double diameter, String col, double centreOfRotationDistance, double centreOfRotationAngle)
	{
        super(distance, angle, diameter, col);
		this.centreOfRotationDistance = centreOfRotationDistance;
		this.centreOfRotationAngle = centreOfRotationAngle;
	}
        
    public final double GetCentreOfRotationDistance()
    {
        return centreOfRotationDistance;   
    }

    public final double GetCentreOfRotationAngle()
    {
        return centreOfRotationAngle;   
    }

    public final void SetCentreOfRotationDistance(double newDistance)
    {
        centreOfRotationDistance = newDistance;   
    }

    public final void SetCentreOfRotationAngle(double newAngle)
    {
        centreOfRotationAngle = newAngle;   
    }


}