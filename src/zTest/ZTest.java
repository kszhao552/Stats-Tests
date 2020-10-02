package zTest;
import java.util.Scanner;
import javax.swing.*;
public class ZTest 
{
	public static void main(String[] args) {
		JFrame frame = new JFrame ("simple GUI");
		System.out.println("Please input an option:\n(1) One Sample with Proportions\n(2) One Sample with Means"
				+ "\n(3) Two Sample with Proportions\n(4) Two Sample with Means\nThe tests with means will assume a standard deviation of the population");
		Scanner input = new Scanner(System.in);
		int option;
		do {
		option = input.nextInt();
			if (option <=0||option >=5) {
				System.out.println("Input is invalid, please try again");
			}
		}while (option <=0|| option>=5);

		//initialize the variables outside switch statement to be able to refer to the object outside of it with the same name
		ZScore test;
		double testValue1 = 0;
		double testValue2 =0;
		double hypValue =0;
		int size1 =0;
		int size2 =0;
		double sd1 =0;
		double sd2 =0;
		
		//The switch statement will take the user input and take the current test object and create a new one that fits the specifications.
		switch(option) {
		case 1:
			System.out.println("Test Value?");
			testValue1 = input.nextDouble();
			System.out.println("Hypothesis Value?");
			hypValue = input.nextDouble();
			System.out.println("Sample Size?");
			size1 = input.nextInt();

			test = new OneSampleZProportions(testValue1, hypValue, size1);
			break;
		case 2:
			System.out.println("Test Value?");
			testValue1 = input.nextDouble();
			System.out.println("Hypothesis Value?");
			hypValue = input.nextDouble();
			System.out.println("Sample Size?");
			size1 = input.nextInt();
			System.out.println("Standard Deviation?");
			sd1 = input.nextDouble();
			test = new OneSampleZMeans(testValue1, hypValue, size1, sd1);
			break;
		case 3:
			System.out.println("First Test Value?");
			testValue1 = input.nextDouble();
			System.out.println("Second Test Value?");
			testValue2 = input.nextDouble();
			System.out.println("Sample Size of First Group?");
			size1 = input.nextInt();
			System.out.println("Sample Size of Second Group?");
			size2 = input.nextInt();
			System.out.println("Standard Deviation of First Group?");
			sd1 = input.nextDouble();
			System.out.println("Standard Deviation of Second Group?");
			sd2 = input.nextDouble();
			test = new TwoSampleZProportions(testValue1, testValue2, size1, size2);
			break;
		case 4: 
			System.out.println("First Test Value?");
			testValue1 = input.nextDouble();
			System.out.println("Second Test Value?");
			testValue2 = input.nextDouble();
			System.out.println("Sample Size of First Group?");
			size1 = input.nextInt();
			System.out.println("Sample Size of Second Group?");
			size2 = input.nextInt();
			System.out.println("Standard Deviation of First Group?");
			sd1 = input.nextDouble();
			System.out.println("Standard Deviation of Second Group?");
			sd2 = input.nextDouble();
			test = new TwoSampleZMeans(testValue1, testValue2, size1, size2, sd1, sd2);
			break;
		default:
			test = new OneSampleZProportions(0,0,0);
		}
		
		//checks the normality of the sampling distribution
		if (test.getNormality()) {
			System.out.println("Sampling Distribution is approximately normal");
		}else {
			System.out.println("Sampling Distribution is not approximately normal, use cation when interpretting results");
		}
		
		//results of the test
		System.out.println("The sample standard deviation used in calculations is " + test.sd());
		double score = test.score();
		System.out.println("The z-score calculated is " + score);
		System.out.println("The probability of a score this extreme or lower occuring is " + test.prob(score));
		System.out.println("The probability of a score this extreme or higher occuring is " + (1-test.prob(score)));
		
	}
}
