package zTest;

import org.apache.commons.math3.special.Erf;

public class OneSampleZMeans implements ZScore{
	private double sd;
	private double zScore;
	private double xbar;
	private double mu;
	private int size;
	boolean normal;
	
	public OneSampleZMeans(double xbar, double mu, int n, double sd) {
		this.mu =mu;
		this.xbar = xbar;
		this.size = n;
		this.sd = sd;
		this.normal = normality();
		this.zScore = score();
	}
	
	public double score() {
		double z = (xbar-mu)/sd();
		return z;
	}

	public double sd() {
		return sd/Math.sqrt((size));
	}
	public double prob(double score) {
		// normalCdf(x) = 1/2 + 1/2 * erf(x / sqrt(2))
		return .5 + .5* Erf.erf(score/Math.sqrt(2));
	}

	public boolean normality() {
		if (size>=30) {
			return true;
		}
		return false;
	}

	@Override
	public double getZScore() {
		return zScore;
	}

	@Override
	public double getsd() {
		return sd;
	}

	@Override
	public double getTestStat() {
		return xbar;
	}

	@Override
	public double getHypothesis() {
		return mu;
	}

	@Override
	public int getSize() {
		return size;
	}
	
	public boolean getNormality()
	{
		return normal;
	}
}