package bg.swift.TeamWorkGameBattle;

public abstract class Player {
	private String name;
	private int power;
	private int endurance;

	public Player(String name, int power, int endurance) {
		this.name = name;
		this.power = power;
		this.endurance = endurance;
	}

	public String getName() {
		return name;
	}

	public int getPower() {
		return power;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}
}
