package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public abstract  class myAbstractSpaceship implements Spaceship {
	private String name;
	private int CommissionYear;
	private float MaximalSpeed;
	private Set<? extends CrewMember> CrewMember;
	public myAbstractSpaceship(String name,int CommisionYear,float MaximalSpeed,int FirePower,Set<? extends CrewMember> CrewMember) {
		this.name=name;
		this.CommissionYear=CommisionYear;
		this.MaximalSpeed=MaximalSpeed;
		this.CrewMember=CrewMember;
	}
	@Override
	public String getName() {
	return name;
	}
	@Override
	public int getCommissionYear() {
		return CommissionYear;
	}
	@Override
	public int getFirePower() {
		return 10;
	}
	@Override
	public float getMaximalSpeed() {
		return MaximalSpeed;
	}
	@Override
	public Set<? extends CrewMember> getCrewMembers() {
		return CrewMember;
	}
	@Override
	public int getAnnualMaintenanceCost() {
		return 0;
	}
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("\tName=").append(this.name);
		str.append("\n\tCommissionYear=").append(this.CommissionYear);
		str.append("\n\tMaximalSpeed=").append(this.MaximalSpeed);
		return str.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CommissionYear;
		result = prime * result + ((CrewMember == null) ? 0 : CrewMember.hashCode());
		result = prime * result + Float.floatToIntBits(MaximalSpeed);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		myAbstractSpaceship other = (myAbstractSpaceship) obj;
		if (CommissionYear != other.CommissionYear)
			return false;
		if (CrewMember == null) {
			if (other.CrewMember != null)
				return false;
		} else if (!CrewMember.equals(other.CrewMember))
			return false;
		if (Float.floatToIntBits(MaximalSpeed) != Float.floatToIntBits(other.MaximalSpeed))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
}
