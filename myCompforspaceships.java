package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;

public class myCompforspaceships implements Comparator<Spaceship>{

	@Override
	public int compare(Spaceship o1, Spaceship o2) {
		// TODO Auto-generated method stub
		if(o1.getFirePower()!=o2.getFirePower()) {
			return Integer.compare(o2.getFirePower(),o1.getFirePower());
		}
		if(o1.getCommissionYear()!=o2.getCommissionYear()) {
			return Integer.compare(o2.getCommissionYear(), o1.getCommissionYear());
		}
		return o1.getName().compareTo(o2.getName());
	}
}
