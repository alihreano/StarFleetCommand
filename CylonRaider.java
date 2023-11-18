package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends myAbstractFighters {

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
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
		return 3500+total+500*numofcrew+(int)(this.getMaximalSpeed()*1200);
	}
	public String toString() {
		return "CylonRaider\n"+super.toString();
	}
	

}
