import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Asteroid extends SolarObjectAbout
{
    private double centreOfRotationDistance;
	private double centreOfRotationAngle;

	public Asteroid(double distance, double angle, double diameter, String col, double centreOfRotationDistance, double centreOfRotationAngle)
	{
        super(distance, angle, diameter, col, centreOfRotationDistance, centreOfRotationAngle);
	}

}