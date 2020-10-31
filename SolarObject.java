import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class SolarObject
{
		private double distance;
		private double angle;
		private double diameter;
		private String col;

		public SolarObject(double distance, double angle, double diameter, String col)
		{
			this.distance = distance;
			this.angle = angle;
			this.diameter = diameter;
			this.col = col;
		}

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
}