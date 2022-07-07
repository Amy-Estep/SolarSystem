/*
Feedback response:
Based upon the feedback from the previous coursework i have made sure not avoid the use of break 
statements, improving the readability and maintainability of my work. i have also positioned comments
so that they line up with the code.
*/
import java.util.ArrayList;

public class SolarSystem {
    
    private final String name;
    private final double luminosity;
    private final ArrayList<Planet> planets = new ArrayList<Planet>();
    private final double luminosityFactor; 
    private static final  double HABITABLE_FACTOR_MIN = 0.75; /* used to calculate minimum habitable conditions,
    must be defined as 0.75 is a magic number */
    private static final double HABITABLE_MASS_MIN = 0.6; /* minimum mass for planet to be habitable, must be 
    defined as 0.6 is a magic number */
    private static final double HABITABLE_MASS_MAX = 7.0; /* maximum mass for planet to be habitable , must 
    be defined as 7.0 is a magic number */
    private static final String HABIT_DEFAULT = "no";
    
    public SolarSystem(String name, double lumiosity) { //class constructor
        this.name = name;
        this.luminosity = lumiosity;
        luminosityFactor = Math.sqrt(luminosity);
    }
    
    public void addPlanet(String name, double mass, double radius, double distance) {
        Planet planetToAdd = new Planet(name, mass, radius, distance); //new planet object
        planets.add(planetToAdd); 
    }

     @Override
    public String toString(){
        String outputStr = name+" has luminosity: "+luminosity;
        String habitable = HABIT_DEFAULT;
        for (int i = 0; i < planets.size(); i++) {
            double habitMin = HABITABLE_FACTOR_MIN*luminosityFactor;
            double habitMax = 2.0 * luminosityFactor;
            if (planets.get(i).getDistance() >= habitMin && planets.get(i).getDistance() <= habitMax) { /* first
                condition for the planet to be habitable */
                if (planets.get(i).getMass()>=HABITABLE_MASS_MIN  && planets.get(i).getMass() <= HABITABLE_MASS_MAX) { 
                    /*second condition for the planet to be habitable*/
                     habitable = "yes";
                }else {
                    habitable = HABIT_DEFAULT;
                }    
            }
            String currentPlanet = planets.get(i).toString();
            outputStr = outputStr+"\n"+currentPlanet+habitable; //adds the string of info for each planet in the array
        }
        outputStr = outputStr+"\n";
        return outputStr;
    }  
}
