package il.ac.tau.cs.sw1.ex9.starfleet;

public abstract class myAbstractCrewMember implements CrewMember {
	private int age;
	private String name;
	private int yearsinservice;
	public myAbstractCrewMember(int age, int yearsInService, String name) {
		this.age=age;
		this.name=name;
		this.yearsinservice=yearsInService;
	}
	@Override
	public int getAge() {
	return age;
	}
	@Override
	public String getName() {
	return name;
	}
	@Override
	public int getYearsInService() {
	return yearsinservice;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + yearsinservice;
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
		myAbstractCrewMember other = (myAbstractCrewMember) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (yearsinservice != other.yearsinservice)
			return false;
		return true;
	}
}
