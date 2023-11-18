package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends myAbstractFighters {
	public static int numofstealth;
	private static List<Weapon> lazer=Arrays.asList(new Weapon("Laser Cannons",10,100));
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,10,crewMembers,weapons);
		this.numofstealth++;
		
	}
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		super(name,commissionYear,maximalSpeed,10,crewMembers,lazer);
		this.numofstealth++;
	}
	public int getAnnualMaintenanceCost() {
		int total=0;
		for(Weapon weapon:weapons) {
			total=total+weapon.getAnnualMaintenanceCost();
		}
		int cost=(int)(this.getMaximalSpeed()*1000);
		return cost+total+2500+50*(numofstealth);
	}
	
	
	public String toString() {
		return "StealthCruiser\n"+super.toString();
	}

	
}
