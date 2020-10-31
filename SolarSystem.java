import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * This class provides a graphical user interface to a model of the solar system
 * @author Joe Finney
 */
public class SolarSystem extends JFrame 
{
	private int width = 300;
	private int height = 300;
    private boolean exiting = false;
    private Map<RenderingHints.Key, Object> renderingHints;

	private ArrayList<SolarObject> things = new ArrayList<SolarObject>();

	/**
	 * Create a view of the Solar System.
	 * Once an instance of the SolarSystem class is created,
	 * a window of the appropriate size is displayed, and
	 * objects can be displayed in the solar system
	 *
	 * @param width the width of the window in pixels.
	 * @param height the height of the window in pixels.
	 */
	public SolarSystem(int width, int height)
	{
		this.width = width;
		this.height = height;

		this.setTitle("The Solar System");
		this.setSize(width, height);
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);		
        
        renderingHints = new HashMap<>();
		renderingHints.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		renderingHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		renderingHints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		renderingHints.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		renderingHints.put(RenderingHints.KEY_FRACTIONALMETRICS,RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		renderingHints.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		renderingHints.put(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		renderingHints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
		
		//This runs an infinite loop to keep all of the objects in the solar system moving.
		int i = 0;
		while (true)
		{
			//This runs a loop to 360 to allow the planets to complete rotation before resetting the counter, we reset it to avoid an overflow with i.
			if (i < 360)
			{
				//This instantiates all of the planets, moons and asteroids.
				SolarObject sun = new SolarObject(0, 0, 50, "YELLOW");
				drawSolarObject(sun);
				
				Planet mercury = new Planet(50, 5*i, 7, "WHITE");
				drawSolarObject(mercury);
				
				Planet venus = new Planet(80, 4*i + 50, 15, "ORANGE");
				drawSolarObject(venus);
				
				Planet earth = new Planet(120, 3*i, 20, "BLUE");
				drawSolarObject(earth);
	
				Moon moon = new Moon(20, 7*i, 5, "WHITE", 120, 3*i);
				drawMoonAbout(moon);
				
			    Planet mars = new Planet(160, 3*i + 156, 17, "RED");
				drawSolarObject(mars);

				Moon marsmoon1 = new Moon(12, 7*i, 2, "WHITE", 160, 3*i + 156);
				drawMoonAbout(marsmoon1);

				Moon marsmoon2 = new Moon(16, 5*i + 50, 3, "WHITE", 160, 3*i + 156);
				drawMoonAbout(marsmoon2);
	            
				//Array used for the asteroids to reduce code needed to instantiate them all.
				Asteroid[][] asteroidBelt = new Asteroid[360][5];
				for(int j=0; j<5; j++)
				{
				    for(int k=0; k<60; k++)
				    {
						asteroidBelt[k][j] = new Asteroid((double) (180 + 3*j), (double) (6*k + 2*j + 5 + i), (double) 1, "LIGHT_GRAY", (double) 0, (double) 0);
						drawAsteroidAbout(asteroidBelt[k][j]); 

					}
				}

				Planet jupiter = new Planet(220, 2 * i, 35, "GRAY");
				drawSolarObject(jupiter);

				Planet saturn = new Planet(280, 2 * i, 30, "DARK_GRAY");
				drawSolarObject(saturn);

				Asteroid[][] saturnRing = new Asteroid[360][5];
				for(int j=0; j<3; j++)
				{
				    for(int k=0; k<30; k++)
				    {
						saturnRing[k][j] = new Asteroid((double) (20 + 3 * j), (double) (12*k + 3*j + 5 + i), (double) 1, "LIGHT_GRAY", (double) 280, (double) 2 * i);
						drawAsteroidAbout(saturnRing[k][j]); 

					}
				}

				Planet uranus = new Planet(340, i, 20, "CYAN");
				drawSolarObject(uranus);

				Planet neptune = new Planet(370, i + 68, 18, "BLUE");
				drawSolarObject(neptune);

				//This was used to slow down the rotation of all of the planets.
				finishedDrawing();
				try{ Thread.sleep(45); } catch (Exception e) {}
				i = i + 1;

			}
			else
			{
			 i = 0;
			}
		}

	}

	/**
	 * A method called by the operating system to draw onto the screen - <p><B>YOU DO NOT (AND SHOULD NOT) NEED TO CALL THIS METHOD.</b></p>
	 */
	public void paint (Graphics gr)
	{
		if (renderingHints == null)
			return;

		BufferedImage i = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = i.createGraphics();
        Graphics2D window = (Graphics2D) gr;
        g.setRenderingHints(renderingHints);
        window.setRenderingHints(renderingHints);
		
		synchronized (this)
		{
			if (!this.exiting)
			{
				g.clearRect(0,0,width,height);
				for(SolarObject t : things)
				{
					double rads = Math.toRadians(t.GetAngle());
					g.setColor(getColourFromString(t.GetColour()));
					g.fillOval( (int) t.GetX(), (int) t.GetY(), (int) t.GetDiameter(), (int) t.GetDiameter());

					//try{ Thread.sleep(0); } catch (Exception e) {} 
				}
			}
			
			window.drawImage(i, 0, 0, this);
		}
	}

	//
	// Shouldn't really handle colour this way, but the student's haven't been introduced
	// to constants properly yet, and Color.getColor() doesn't seem to work... hmmm....
	// 
	private Color getColourFromString(String col)
	{
		Color color;
		
		if (col.charAt(0) == '#')
		{
			color = new Color(
    	        Integer.valueOf( col.substring( 1, 3 ), 16 ),
        	    Integer.valueOf( col.substring( 3, 5 ), 16 ),
            	Integer.valueOf( col.substring( 5, 7 ), 16 ) );
		} 
		else 
		{
			try 
			{
				java.lang.reflect.Field field = Color.class.getField(col);
				color = (Color)field.get(null);
			} catch (Exception e) {
				color = Color.WHITE;
			}
		}
		return color;
	}
	
	/**
	 * Draws a round shape in the window at the given co-ordinates that represents an object in the solar system.
	 * The SolarSystem class uses <i>Polar Co-ordinates</i> to represent the location
	 * of objects in the solar system.
	 *
	 * @param distance the distance from the sun to the object.
	 * @param angle the angle (in degrees) that represents how far the planet is around its orbit of the sun.
	 * @param diameter the size of the object.
	 * @param col the colour of this object, as a string. Case insentive. <p>One of: BLACK, BLUE, CYAN, DARK_GRAY, GRAY, GREEN, LIGHT_GRAY, 
	 * MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW. Alternatively, a 24 bit hexadecimal string representation of an RGB colour is also accepted, e.g. "#FF0000"</p>
	 */

	 //This method now uses SolarObject as its only parameter and SolarObjects are a different class. This makes the program more secure(encapsulation) and easier to understand. 
	 //I also made it private as you only need to access it in this class.
	private void drawSolarObject(SolarObject newSolarObject)
	{
		Color colour = getColourFromString(newSolarObject.GetColour());

		double rads = Math.toRadians(newSolarObject.GetAngle());
		newSolarObject.SetX((int) ((width / 2) + newSolarObject.GetDistance() * Math.sin(rads)) - newSolarObject.GetDiameter() / 2);
		newSolarObject.SetY((int) ((height / 2) + newSolarObject.GetDistance() * Math.cos(rads)) - newSolarObject.GetDiameter() / 2);

		synchronized (this)
		{
			if (things.size() > 1000)
			{
				System.out.println("\n\n");
				System.out.println(" ********************************************************* ");
				System.out.println(" ***** Only 1000 Entities Supported per Solar System ***** ");
				System.out.println(" ********************************************************* ");
				System.out.println("\n\n");
				System.out.println("If you are't trying to add this many things");
				System.out.println("to your SolarSystem, then you have probably");
				System.out.println("forgotten to call the finishedDrawing() method");
				System.out.println("See the JavaDOC documentation for more information");
				System.out.println("\n-- Joe");
				System.out.println("\n\n");

				this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			}
			else
			{
				things.add(newSolarObject);
			}
		}
	}

	/**
	 * Draws a round shape in the window at the given co-ordinates. 
	 * The SolarSystem class uses <i>Polar Co-ordinates</i> to represent the location
	 * of objects in the solar system. This method operates in the same fashion as drawSolarObject, but
	 * provides additional co-ordinates to allow the programmer to use an arbitrary point about which
	 * the object orbits (e.g. a planet rather than the sun).
	 *
	 * @param distance the distance from this object to the point about which it is orbiting.
	 * @param angle the angle (in degrees) that represents how far the object is around its orbit.
	 * @param diameter the size of the object.
	 * @param col the colour of this object, as a string. Case insentive. <p>One of: BLACK, BLUE, CYAN, DARK_GRAY, GRAY, GREEN, LIGHT_GRAY, 
	 * MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW</p>
	 * @param centreOfRotationDistance the distance part of the polar co-ordinate about which this object orbits.
	 * @param centreOfRotationAngle the angular part of the polar co-ordinate about which this object orbits.
	 */
	private void drawMoonAbout(Moon newMoon)
	{
		Color colour = getColourFromString(newMoon.GetColour());
		double centrerads = Math.toRadians(newMoon.GetCentreOfRotationAngle());
		double centreOfRotationX = (((double) width) / 2.0) + newMoon.GetCentreOfRotationDistance() * Math.sin(centrerads); 
		double centreOfRotationY = (((double) height) / 2.0) + newMoon.GetCentreOfRotationDistance() * Math.cos(centrerads); 

		double rads = Math.toRadians(newMoon.GetAngle());
		newMoon.SetX((int) (centreOfRotationX + newMoon.GetDistance() * Math.sin(rads)) - newMoon.GetDiameter() / 2);
		newMoon.SetY( (int) (centreOfRotationY + newMoon.GetDistance() * Math.cos(rads)) - newMoon.GetDiameter() / 2);

		synchronized (this)
		{
			if (things.size() > 1000)
			{
				System.out.println("\n\n");
				System.out.println(" ********************************************************* ");
				System.out.println(" ***** Only 1000 Entities Supported per Solar System ***** ");
				System.out.println(" ********************************************************* ");
				System.out.println("\n\n");
				System.out.println("If you are't trying to add this many things");
				System.out.println("to your SolarSystem, then you have probably");
				System.out.println("forgotten to call the finishedDrawing() method");
				System.out.println("See the JavaDOC documentation for more information");
				System.out.println("\n-- Joe");
				System.out.println("\n\n");

				this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			}
			else
			{
				things.add(newMoon);
			}
		}
	}
    //I decided to reuse the drawMoonAbout method for drawAsteroid about. I could have made Asteroid a subclass of Moon however, 
	//I didn't want to do this as moons and asteroids have different properties. This makes it easier for others to understand 
	//and change the moon or asteroid class.

	private void drawAsteroidAbout(Asteroid newAsteroid)
	{
		Color colour = getColourFromString(newAsteroid.GetColour());
		double centrerads = Math.toRadians(newAsteroid.GetCentreOfRotationAngle());
		double centreOfRotationX = (((double) width) / 2.0) + newAsteroid.GetCentreOfRotationDistance() * Math.sin(centrerads); 
		double centreOfRotationY = (((double) height) / 2.0) + newAsteroid.GetCentreOfRotationDistance() * Math.cos(centrerads); 

		double rads = Math.toRadians(newAsteroid.GetAngle());
		newAsteroid.SetX((int) (centreOfRotationX + newAsteroid.GetDistance() * Math.sin(rads)) - newAsteroid.GetDiameter() / 2);
		newAsteroid.SetY( (int) (centreOfRotationY + newAsteroid.GetDistance() * Math.cos(rads)) - newAsteroid.GetDiameter() / 2);

		synchronized (this)
		{
			if (things.size() > 1000)
			{
				System.out.println("\n\n");
				System.out.println(" ********************************************************* ");
				System.out.println(" ***** Only 1000 Entities Supported per Solar System ***** ");
				System.out.println(" ********************************************************* ");
				System.out.println("\n\n");
				System.out.println("If you are't trying to add this many things");
				System.out.println("to your SolarSystem, then you have probably");
				System.out.println("forgotten to call the finishedDrawing() method");
				System.out.println("See the JavaDOC documentation for more information");
				System.out.println("\n-- Joe");
				System.out.println("\n\n");

				this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			}
			else
			{
				things.add(newAsteroid);
			}
		}
	}
	

	/**
     * Updates the window to show all objects that have recently been drawn using
     * drawSolarObject() or drawSolarObjectAbout().
     * 
     * The method also waits for 20 milliseconds (1/50th of one second) and then
     * clears the screen.
	 */
	private void finishedDrawing()
	{
		try
		{
			this.repaint();
			Thread.sleep(20);
			synchronized (this)
			{
				things.clear();
			}
		}
		catch (Exception e) { }
	}
}
