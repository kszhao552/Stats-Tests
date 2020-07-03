package zTest;

public interface ZScore {
	boolean normality();
	/*
	 * Checks to see if the given sample comes from a random distribution through the Central Limit Theorem. 
	 * If it is passes the conditions for the theorem, it will return true, otherwise false.
	 */
	double score();
	/*
	 * Returns the z score that is calculated by the program
	 */
	double sd();
	/*
	 * Calculates the Standard Deviation for the given sample.
	 */
	double prob(double score);
	/*
	 * converts the z-score into probability of happening. 
	 */
	
	public double getZScore(); //
	public double getsd();	//
	public double getTestStat(); //
	public double getHypothesis(); //
	public int getSize(); //
	public boolean getNormality();
	/*
	 * Access methods in order to retrieve encapsulated variables.
	 */
}
