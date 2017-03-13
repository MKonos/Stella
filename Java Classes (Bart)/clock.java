public interface clock
{
	private double currentTime;
	private double multiplier;
	
	public double getCurrentTime()
	{
		return currentTime;
	}
	
	public double setTimeMultipler(double multiply)
	{
		multiplier = multiplier * multiply;
		return multiplier; 
	}
}