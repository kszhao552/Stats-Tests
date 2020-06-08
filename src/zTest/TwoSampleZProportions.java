package zTest;
import java.lang.Math;
import org.apache.commons.math3.special.Erf;

public class TwoSampleZProportions implements ZScore{
	private double sd;
	private double zScore;
	//combined total proportion used to calculate sd in the z test
	private double phat;
	private double phat1;
	private double phat2;
	private double p;
	
	private int size1;
	private int size2;
	private int size;
	boolean normal;
	
	public TwoSampleZProportions(double p1, double p2, int n1, int n2) {
		this.phat1 =p1;
		this.phat2 = p2;
		this.phat = (p1*n1+p2*n2)/(n1+n2);
		this.p = 0;
		this.size1 = n1;
		this.size2 = n2;
		this.size = n1+n2;
		this.sd = sd();
		this.normal = normality();
		this.zScore = score();
	}
	
	public double score() {
		double z = (phat1-phat2)/sd;
		return z;
	}

	public double sd() {
		double sd = phat*(1-phat)/size;
		sd = Math.sqrt(sd);
		return sd;
	}

	public double prob(double score) {
		// normalCdf(x) = 1/2 + 1/2 * erf(x / sqrt(2))
		return .5 + .5* Erf.erf(score/Math.sqrt(2));
	}

	public boolean normality() {
		boolean successes;
		boolean failures;
		if (size1*phat1 >= 5 && size2*phat2>=5) {
			successes = true;
		}
		else {
			successes = false;
		}
		
		if (size1*(1-phat1)>=5 && size2*(1-phat2)>=5) {
			failures = true;
		}
		else {
			failures = false;
		}
		return successes && failures;
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
		return phat1-phat2;
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
