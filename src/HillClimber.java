/**
* A hill climbing algorithm.
*/
public class HillClimber {

	private Chromosome chromosome;

	public HillClimber() {
		chromosome = new Chromosome();
	}

	/**
	* Runs the algorithm.
	*/
	public void run() {
		int steps = 0;
		for (int i = 0; i < Main.NUMBER_OF_CHARACTERS; i++) {
			boolean terminate = false;
			do {
				// Uncomment to watch each tick.
				// try {
				// Thread.sleep(10);
				// } catch (InterruptedException e) {
				// e.printStackTrace();
				// }
				System.out.println(steps + " " + chromosome.string);
				char[] leftCharacters = chromosome.string.toCharArray();
				if (leftCharacters[i] > 32) {
					leftCharacters[i] -= 1;
				}
				Chromosome leftChromosome = new Chromosome(String.valueOf(leftCharacters));
				char[] rightCharacters = chromosome.string.toCharArray();
				if (rightCharacters[i] < 126) {
					rightCharacters[i] += 1;
				}
				Chromosome rightChromosome = new Chromosome(String.valueOf(rightCharacters));
				if (leftChromosome.fitness < chromosome.fitness) {
					chromosome = leftChromosome;
					steps++;
				} else if (rightChromosome.fitness < chromosome.fitness) {
					chromosome = rightChromosome;
					steps++;
				} else {
					terminate = true;
				}
			} while (!terminate);
		}
		System.out.print("The hill climber took " + steps + " steps and ");
	}

}
