public class sun
{
	OrbitingBodyBehavior mySun;
	BodyInfo	         sunInfo;
	planet               myPlanets[];
	int amountOfPlanets;
	
	public sun()
	{
		amountOfPlanets = 0;
	}
	
	public void storePlanetsInfo()
	{
			// store planet information 
	}
	
	public void display()
	{
			// display the sun 
	
	}
	
	public void displayPlanets()
	{
		for(int i = 0 ; i < amountOfPlanets; i++)
			myPlanets[i].displayPlanet();
	}
	
	public int doesPlanetExist(string planetName)
	{
		for(int i = 0 ; i < amountOfPlanets; i++)
		{
			if(myPlanets[i] == planetName)
			{
				return i;
			}
		}
		return -1;	// planet was not found 
	}
	
	public String deletePlanet(String planetName)
	{
		return "Planet deleted";
	}
	
	public String createPlanet(String planetName,double size,double radius,double velocity,double location)
	{
		if(doesPlanetExist(planetName) == -1)
		{
			myPlanets[amountOfPlanets] = planet.setPlanetInfo(“Name of Planet”, size, radius, velocity, location)
			amountOfPlanets++;
			return "Planet made"
		}
		else
		{
			return "Planet creation failed"	
		}
	}
}