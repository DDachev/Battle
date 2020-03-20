package bg.swift.TeamWorkGameBattle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionDataBase {

	public static List<String> getPersonCharachteristics(int personId) {
		List<String> personInfo = new ArrayList<>();
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/battle", "root", "1234567890");
				PreparedStatement ps = con.prepareStatement("select * from battle.people where person_id = ?;")) {
			ps.setInt(1, personId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				personInfo.add(rs.getString(2));
				personInfo.add(rs.getString(3));
				personInfo.add(rs.getString(4));
			}

		} catch (SQLException ex) {
			System.out.println("Cannot get this person, because " + ex.getMessage());
		}
		return personInfo;
	}

	public static List<String> getTrollCharachteristics(int trollId) {
		List<String> trollInfo = new ArrayList<>();
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/battle", "root", "1234567890");
				PreparedStatement ps = con.prepareStatement("select * from battle.trolls where troll_id = ?;")) {
			ps.setInt(1, trollId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				trollInfo.add(rs.getString(2));
				trollInfo.add(rs.getString(3));
				trollInfo.add(rs.getString(4));
			}

		} catch (SQLException ex) {
			System.out.println("Cannot get this troll, because " + ex.getMessage());
		}
		return trollInfo;
	}

	public static void setInfoFromBattle(int numberOfPeople, int numberOfTrolls, int peoplePoints, int trollsPoints) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/battle", "root", "1234567890");
				PreparedStatement ps = con.prepareStatement(
						"insert into battle.batlle_information (people_number, trolls_number, people_points, trolls_points) values (?, ?, ?, ?) ;")) {
			ps.setInt(1, numberOfPeople);
			ps.setInt(2, numberOfTrolls);
			ps.setInt(3, peoplePoints);
			ps.setInt(4, trollsPoints);
			ps.execute();
		} catch (SQLException ex) {
			System.out.println("Cannot set info, because " + ex.getMessage());
		}
	}

	public static void printInfo(int id) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/battle", "root", "1234567890");
				PreparedStatement ps = con.prepareStatement("select * from battle.batlle_information where id = ?;")) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int numberOfPeople = rs.getInt(2);
				int numberOfTrolls = rs.getInt(3);
				int winBattlesFromPeople = rs.getInt(4);
				int winBattlesFromTrolls = rs.getInt(5);
				System.out.printf("%nThe result is:%nPeople win - %d battles%nTrolls win - %d battles%n",
						winBattlesFromPeople, winBattlesFromTrolls);
				if (winBattlesFromPeople < winBattlesFromTrolls) {
					System.out.printf("%nTROLLS WIN THE GAME, WITH %d ALIVE!", numberOfTrolls);
				} else if (winBattlesFromPeople > winBattlesFromTrolls) {
					System.out.printf("%nPEOPLE WIN THE GAME, WITH %d ALIVE!", numberOfPeople);
				} else {
					System.out.println("Equality!");
				}
			}
			deleteResultFromBattle();
		} catch (SQLException ex) {
			System.out.println("Cannot get info, because " + ex.getMessage());
		}
	}

	private static void deleteResultFromBattle() {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/battle", "root", "1234567890");
				PreparedStatement ps = con.prepareStatement("truncate battle.batlle_information;")) {
			ps.execute();
		} catch (SQLException ex) {
			System.out.println("Cannot delete information for result, because " + ex.getMessage());
		}
	}
}
