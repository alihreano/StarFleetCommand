package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends myAbstractFighters {
	
	public Fighter(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons){
		super(name,commissionYear,maximalSpeed,10,crewMembers,weapons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		int total=0;
		for(Weapon weapon:weapons) {
			total=total+weapon.getAnnualMaintenanceCost();
		}
		int cost=(int)(this.getMaximalSpeed()*1000);
		return cost+total+2500;
	}
	public String toString() {
		return "Fighter\n"+super.toString();
	}
	
	
}
