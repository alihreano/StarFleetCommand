package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends myAbstractFighters{
	private int NumberOfTechnicians;
	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name,commissionYear,maximalSpeed,10,crewMembers,weapons);
		this.NumberOfTechnicians=numberOfTechnicians;
	}

	public int getNumberOfTechnicians() {
		return this.NumberOfTechnicians;
	}
	public int getAnnualMaintenanceCost() {
		int total=0;
		for(Weapon weapon:weapons) {
			total=total+weapon.getAnnualMaintenanceCost();
		}
		
		int cost=(int) (total*((10-this.NumberOfTechnicians)*0.1));
		return 5000+cost;
	}
	@Override
	public String toString() {
		return "Bomber\n"+super.toString()+"\n\tNumberOfTechnicians="+this.getNumberOfTechnicians();
	}
}
