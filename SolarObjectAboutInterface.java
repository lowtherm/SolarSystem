/**
 * This is an interface which specifies what the asteroid and moon class must include as methods.
 * This provides total abstraction.
 */
public interface SolarObjectAboutInterface
{
    void SetCentreOfRotationDistance(double n);
    void SetCentreOfRotationAngle(double n);

    double GetCentreOfRotationDistance();
    double GetCentreOfRotationAngle();
}
