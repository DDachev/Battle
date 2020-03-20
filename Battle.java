package bg.swift.TeamWorkGameBattle;

public class Battle {
	public static int personScore = 0;
	public static int trollScore = 0;
	public int rounds;
	Troll troll;
	Person person;

	public Battle(Troll troll, Person person) {
		this.troll = troll;
		this.person = person;
	}

	public void createBattle() {
		while (person.getEndurance() > 0 && troll.getEndurance() > 0) {
			rounds++;
			if (rounds % 2 == 1) {
				person.setEndurance(person.getEndurance() - troll.getPower());
			} else if (rounds % 2 == 0) {
				troll.setEndurance(troll.getEndurance() - person.getPower());
			}
		}
		updateScore();
	}

	private void updateScore() {
		Player hero = getAliveHero();
		if (hero instanceof Troll) {
			trollScore++;
		} else if (hero instanceof Person) {
			personScore++;
		}
	}

	public Player getAliveHero() {
		if (troll.getEndurance() > 0) {
			return troll;
		} else if (person.getEndurance() > 0) {
			return person;
		}
		return null;
	}

	public int getRounds() {
		return rounds;
	}

	public static int getPersonScore() {
		return personScore;
	}

	public static int getTrollScore() {
		return trollScore;
	}

	public Troll getTroll() {
		return troll;
	}

	public Person getPerson() {
		return person;
	}
}
