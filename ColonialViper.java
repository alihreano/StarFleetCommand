package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends myAbstractFighters  {
	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,10,crewMembers,weapons);
	}
	@Override
	public int getAnnualMaintenanceCost() {
		int numofcrew=this.getCrewMembers().size();
		int total=0;
		for(Weapon weapon:this.weapons) {
			total=total+weapon.getAnnualMaintenanceCost();
		}
		return 4000+total+500*numofcrew+(int)(this.getMaximalSpeed()*500);
	}
	public String toString() {
		return "ColonialViper\n"+super.toString();
	}
	
	
}
