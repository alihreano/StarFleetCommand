package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends myAbstractSpaceship{
	int CargoCapacity;
	int PassengerCapacity;
	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name,commissionYear,maximalSpeed,10,crewMembers);
		this.CargoCapacity=cargoCapacity;
		this.PassengerCapacity=passengerCapacity;
	}
	public int getCargoCapacity() {
		return CargoCapacity;
	}
	public int getPassengerCapacity() {
		return PassengerCapacity;
	}
	@Override
	public int getAnnualMaintenanceCost() {
		return 3000+(this.CargoCapacity*5)+(this.PassengerCapacity*3) ;
	}
	public String toString() {
		return "TransportShip\n"+super.toString()+"\n\tFirePower="+this.getFirePower()+"\n\tCrewMembers="+this.getCrewMembers().size()
				+"\n\tAnnualMaintenanceCost="+this.getAnnualMaintenanceCost()+"\n\tCargoCapacity="+this.getCargoCapacity()
				+"\n\tPassengerCapacity="+this.getPassengerCapacity();
	}
	
	}


