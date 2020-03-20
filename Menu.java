package bg.swift.TeamWorkGameBattle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> personInfo = new ArrayList<>();
		List<String> trollInfo = new ArrayList<>();
		List<Person> people = new ArrayList<>();
		List<Troll> trolls = new ArrayList<>();

		System.out.println("Please enter the number of Players (people and trolls):");
		int players = scanner.nextInt();
		for (int i = 0; i < players; i++) {
			System.out.println("Please enter person ID: ");
			int personID = scanner.nextInt();
			personInfo = ConnectionDataBase.getPersonCharachteristics(personID);
			Person person = new Person(personInfo.get(0), Integer.parseInt(personInfo.get(1)),
					Integer.parseInt(personInfo.get(2)));
			people.add(person);
		}

		for (int i = 0; i < players; i++) {
			System.out.println("Please enter troll ID: ");
			int trollID = scanner.nextInt();
			trollInfo = ConnectionDataBase.getTrollCharachteristics(trollID);
			Troll troll = new Troll(trollInfo.get(0), Integer.parseInt(trollInfo.get(1)),
					Integer.parseInt(trollInfo.get(2)));
			trolls.add(troll);
		}

		scanner.close();
		int numberOfBattles = 1;
		ConnectionDataBase.setInfoFromBattle(people.size(), trolls.size(), 0, 0);

		while (people.size() > 0 && trolls.size() > 0) {
			Battle battle = new Battle(trolls.get(0), people.get(0));
			battle.createBattle();
			Player player = battle.getAliveHero();
			if (player instanceof Person) {
				trolls.remove(0);
				ConnectionDataBase.setInfoFromBattle(people.size(), trolls.size(), Battle.getPersonScore(),
						Battle.getTrollScore());
			} else if (player instanceof Troll) {
				people.remove(0);
				ConnectionDataBase.setInfoFromBattle(people.size(), trolls.size(), Battle.getPersonScore(),
						Battle.getTrollScore());
			}
			numberOfBattles++;
		}
		ConnectionDataBase.printInfo(numberOfBattles);
	}
}
