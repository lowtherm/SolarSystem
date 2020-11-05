import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;

/**
 * This is the driver class. It is used to start the program.
 */
public class Driver
{
	/**
	 * This is the main method that runs when the program starts.
	 * It runs an infinite loop which constantly redraws the position of all of the planets,moons and asteroids.
	 * 
	 */
    public static void main(String args[])
    {
        SolarSystem solar = new SolarSystem(850,850);
		
		//This runs an infinite loop to keep all of the objects in the solar system moving.
		int i = 0;
		Planet sun = new Planet(0, 0, 50, "YELLOW");
              
		while (true)
		{
			//This runs a loop to 360 to allow the planets to complete rotation before resetting the counter, we reset it to avoid an overflow with i.
			if (i < 360)
			{
				//This instantiates all of the planets, moons and asteroids and then draws them.
				solar.drawSolarObject(sun.GetDistance(), sun.GetAngle(), sun.GetDiameter(), sun.GetColour());
				
				Planet mercury = new Planet(50, 5*i, 7, "WHITE");
				solar.drawSolarObject(mercury.GetDistance(), mercury.GetAngle(), mercury.GetDiameter(), mercury.GetColour());
				
				Planet venus = new Planet(80, 4*i + 50, 15, "ORANGE");
				solar.drawSolarObject(venus.GetDistance(), venus.GetAngle(), venus.GetDiameter(), venus.GetColour());
				
				Planet earth = new Planet(120, 3*i, 20, "BLUE");
				solar.drawSolarObject(earth.GetDistance(), earth.GetAngle(), earth.GetDiameter(), earth.GetColour());
	
				Moon moon = new Moon(20, 7*i, 5, "WHITE", 120, 3*i);
				solar.drawSolarObjectAbout(moon.GetDistance(), moon.GetAngle(), moon.GetDiameter(), moon.GetColour(), moon.GetCentreOfRotationDistance(), moon.GetCentreOfRotationAngle());
				
			    Planet mars = new Planet(160, 3*i + 156, 17, "RED");
				solar.drawSolarObject(mars.GetDistance(), mars.GetAngle(), mars.GetDiameter(), mars.GetColour());

				Moon marsMoon1 = new Moon(12, 7*i, 2, "WHITE", 160, 3*i + 156);
				solar.drawSolarObjectAbout(marsMoon1.GetDistance(), marsMoon1.GetAngle(), marsMoon1.GetDiameter(), marsMoon1.GetColour(), marsMoon1.GetCentreOfRotationDistance(), marsMoon1.GetCentreOfRotationAngle());

				Moon marsMoon2 = new Moon(16, 5*i + 50, 3, "WHITE", 160, 3*i + 156);
				solar.drawSolarObjectAbout(marsMoon2.GetDistance(), marsMoon2.GetAngle(), marsMoon2.GetDiameter(), marsMoon2.GetColour(), marsMoon2.GetCentreOfRotationDistance(), marsMoon2.GetCentreOfRotationAngle());
	            
				//Array used for the asteroids to reduce code needed to instantiate them all.
				Asteroid[][] asteroidBelt = new Asteroid[360][5];
				for(int j=0; j<5; j++)
				{
				    for(int k=0; k<60; k++)
				    {
						asteroidBelt[k][j] = new Asteroid((double) (180 + 3*j), (double) (6*k + 2*j + 5 + i), (double) 1, "LIGHT_GRAY", (double) 0, (double) 0);
						solar.drawSolarObjectAbout(asteroidBelt[k][j].GetDistance(), asteroidBelt[k][j].GetAngle(), asteroidBelt[k][j].GetDiameter(), asteroidBelt[k][j].GetColour(), asteroidBelt[k][j].GetCentreOfRotationDistance(), asteroidBelt[k][j].GetCentreOfRotationAngle()); 

					}
				}

				Planet jupiter = new Planet(220, 2 * i, 35, "GRAY");
				solar.drawSolarObject(jupiter.GetDistance(), jupiter.GetAngle(), jupiter.GetDiameter(), jupiter.GetColour());

				Planet saturn = new Planet(280, 2 * i, 30, "DARK_GRAY");
				solar.drawSolarObject(saturn.GetDistance(), saturn.GetAngle(), saturn.GetDiameter(), saturn.GetColour());

				Asteroid[][] saturnRing = new Asteroid[360][5];
				for(int j=0; j<3; j++)
				{
				    for(int k=0; k<30; k++)
				    {
						saturnRing[k][j] = new Asteroid((double) (20 + 3 * j), (double) (12*k + 3*j + 5 + i), (double) 1, "LIGHT_GRAY", (double) 280, (double) 2 * i);
						solar.drawSolarObjectAbout(saturnRing[k][j].GetDistance(), saturnRing[k][j].GetAngle(), saturnRing[k][j].GetDiameter(), saturnRing[k][j].GetColour(), saturnRing[k][j].GetCentreOfRotationDistance(), saturnRing[k][j].GetCentreOfRotationAngle()); 

					}
				}

				Planet uranus = new Planet(340, i, 20, "CYAN");
				solar.drawSolarObject(uranus.GetDistance(), uranus.GetAngle(), uranus.GetDiameter(), uranus.GetColour());

				Planet neptune = new Planet(370, i + 68, 18, "BLUE");
                solar.drawSolarObject(neptune.GetDistance(), neptune.GetAngle(), neptune.GetDiameter(), neptune.GetColour());
                
				try
				{
					Thread.sleep(40);
				}
				catch (Exception e)
				{
				 	
				}
                solar.finishedDrawing();
				i = i + 1;

			}
			else
			{
			 i = 0;
			}
		}

    }
}