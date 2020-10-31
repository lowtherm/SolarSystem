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
        
        public double GetCentreOfRotationDistance()
        {
         return centreOfRotationDistance;   
        }

        public double GetCentreOfRotationAngle()
        {
         return centreOfRotationAngle;   
        }

        public void GetCentreOfRotationDistance(double newDistance)
        {
         centreOfRotationDistance = newDistance;   
        }

        public void GetCentreOfRotationAngle(double newAngle)
        {
         centreOfRotationAngle = newAngle;   
        }


}