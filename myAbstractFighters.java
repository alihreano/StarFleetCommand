package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class myAbstractFighters extends myAbstractSpaceship {
	protected List<Weapon> weapons; 
	public myAbstractFighters(String name, int CommisionYear, float MaximalSpeed, int FirePower,
			Set<? extends CrewMember> CrewMember,List<Weapon> weapons) {
		super(name, CommisionYear, MaximalSpeed, FirePower, CrewMember);
		this.weapons=weapons;
	}
	public List<Weapon> getWeapon() {
		return this.weapons;
	}
	public int getFirePower() {
		int total=0;
		for(Weapon weapon:weapons) {
			total=total+weapon.getFirePower();
		}
		return  total+10;
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
	@Override
	public String toString() {
		return super.toString()+"\n\tFirePower="+this.getFirePower()+"\n\tCrewMembers="+this.getCrewMembers().size()
				+"\n\tAnnualMaintenanceCost="+this.getAnnualMaintenanceCost()+"\n\tWeaponArray="+this.weapons;
	}
}
