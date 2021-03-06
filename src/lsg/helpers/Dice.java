package lsg.helpers;
import java.util.*;


public class Dice {
	
	protected int faces;
	//protected java.util.Random random;
	protected Random random = new Random();
	
	public Dice(int nbFaces) {
		this.faces = nbFaces;
	}
	
	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public int getFaces() {
		return faces;
	}

	public void setFaces(int faces) {
		this.faces = faces;
	}

	public int roll() {
		return random.nextInt(this.faces);
	}
	
	public void test() {
		int i;
		int min = 0;
		int max = 0;
		for (i = 1; i <= 500; i++) {
			int var = random.nextInt(this.faces);
			if (var == 0) {
				min = var;
			}
			if (var == this.faces-1) {
				max = var;
			}
			
		}
		System.out.println("Min : "+min);
		System.out.println("Max : "+max);
	}
	
}
