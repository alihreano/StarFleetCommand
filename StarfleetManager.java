package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;


public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		List<Spaceship> list = new ArrayList<Spaceship>(fleet);
		Collections.sort(list,new myCompforspaceships());
		List<String> res=new ArrayList<String>();
		for(Spaceship ship:list) {
			res.add(ship.toString());
		}
		return res;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		List<Spaceship> list = new ArrayList<Spaceship>(fleet);
		Map<String, Integer> res=new HashMap<String,Integer>();
		for(Spaceship ship:list) {
			String name=ship.getClass().getSimpleName();
			if(res.containsKey(name)) {
			int num=res.get(name);
			res.replace(name,num+1);
			}
			else {
			res.put(name,1);
			}
		}
		return res;

	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		List<Spaceship> list = new ArrayList<Spaceship>(fleet);
		int res=0;
		for(Spaceship ship:list) {
			res=res+ship.getAnnualMaintenanceCost();
		}
		return res;

	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		List<Spaceship> list = new ArrayList<Spaceship>(fleet);
		Set<String> res=new HashSet<String>();
		for(Spaceship ship:list) {
			if(ship.getClass().getSimpleName().equals("TransportShip"))
				continue;
			for(Weapon weapon_per_ship:((myAbstractFighters)ship).getWeapon()) {
				res.add(weapon_per_ship.getName());
			}
		}
		return res;
	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		List<Spaceship> list = new ArrayList<Spaceship>(fleet);
		int res=0;
		for(Spaceship ship:list) {
			res=res+ship.getCrewMembers().size();
		}
		return res;

	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		List<Spaceship> list = new ArrayList<Spaceship>(fleet);
		int res=0;
		int count=0;
		for(Spaceship ship:list) {
			for(CrewMember member:ship.getCrewMembers()) {
				if(member.getClass().getSimpleName().equals("Officer")) {
					count++;
					res=res+member.getAge();
				}
			}
		}
		
		return (float)res/count;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		List<Spaceship> list = new ArrayList<Spaceship>(fleet);
		Map<Officer, Spaceship> res=new HashMap<Officer,Spaceship>();
		for(Spaceship ship:list) {
			OfficerRank rank=null;
			Officer name=null;
			for(CrewMember member:ship.getCrewMembers()) {
				if(member.getClass().getSimpleName().equals("Officer")) {
					if(rank==null) {
						rank=((Officer)member).getRank();
						name=((Officer)member);
					}
					else {
						if(((Officer)member).getRank().compareTo(rank)>0) { //if the current rank is bigger than rank
							rank=((Officer)member).getRank();
							name=((Officer)member);
						}
					}
				}
			}
			if(rank!=null) {
			res.put(name,ship);
			rank = null;
			}
			
		}
		return res;

	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		List<Spaceship> list = new ArrayList<Spaceship>(fleet);
		Map<OfficerRank, Integer> res=new HashMap<OfficerRank, Integer>();
		for(Spaceship ship:list) {
			OfficerRank rank=null;
			for(CrewMember member:ship.getCrewMembers()) {
				if(member.getClass().getSimpleName().equals("Officer")) {
					 rank=((Officer)member).getRank();
					 if(res.containsKey(rank)) {
						 res.put(rank,res.get(rank)+1);
					 }
					 else {
						 res.put(rank,1);
					 }
				}
		}
		}
		
		List<Map.Entry<OfficerRank,Integer>> list3=new ArrayList<Entry<OfficerRank, Integer>>();
		for (Entry<OfficerRank, Integer> entry: res.entrySet()) {
			list3.add(entry);
			}	
		Collections.sort(list3,new myCompforofficers());
		return list3;
		}
	}


