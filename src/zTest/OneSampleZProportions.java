package zTest;
import java.lang.Math;
import org.apache.commons.math3.special.Erf;

public class OneSampleZProportions implements ZScore{
	private double sd;
	private double zScore;
	private double phat;
	private double p;
	private int size;
	boolean normal;
	
	public OneSampleZProportions(double p, double phat, int n) {
		this.p =p;
		this.phat = phat;
		this.size = n;
		this.sd = sd();
		this.normal = normality();
		this.zScore = score();
	}
	
	public double score() {
		double z = (phat-p)/sd;
		return z;
	}

	public double sd() {
		double sd = p*(1-p)/size;
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
		if (size*p >= 5) {
			successes = true;
		}
		else {
			successes = false;
		}
		
		if (size*(1-p)>=5) {
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
		return phat;
	}

	@Override
	public double getHypothesis() {
		return p;
	}

	@Override
	public int getSize() {
		return size;
	}

}
