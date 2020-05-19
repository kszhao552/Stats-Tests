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

	public int prob(int score) {
		// TODO Auto-generated method stub
		return 0;
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

}
