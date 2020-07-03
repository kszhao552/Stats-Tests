package zTest;

import org.apache.commons.math3.special.Erf;

public class TwoSampleZMeans implements ZScore{
	private double sd1;
	private double sd2;
	private double sd;
	private double zScore;
	//combined total proportion used to calculate sd in the z test
	private double xbar1;
	private double xbar2;
	
	private int size1;
	private int size2;
	private int size;
	boolean normal;
	
	public TwoSampleZMeans(double xbar1, double xbar2, int n1, int n2, double sd1, double sd2) {
		this.xbar1 =xbar1;
		this.xbar2 = xbar2;
		this.size1 = n1;
		this.size2 = n2;
		this.size = n1+n2;
		this.sd1 = sd1;
		this.sd2 = sd2;
		this.sd = sd();
		this.normal = normality();
		this.zScore = score();
	}
	
	public double score() {
		double z = (xbar1-xbar2)/sd;
		return z;
	}

	public double sd() {
		double sd = Math.pow(sd1, 2)/size1 + Math.pow(sd2, 2)/size2;
		sd = Math.sqrt(sd);
		return sd;
	}

	public double prob(double score) {
		// normalCdf(x) = 1/2 + 1/2 * erf(x / sqrt(2))
		return .5 + .5* Erf.erf(score/Math.sqrt(2));
	}

	public boolean normality() {
		return size1>30 && size2>30;
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
		return xbar1-xbar2;
	}

	@Override
	public double getHypothesis() {
		return 0;
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
