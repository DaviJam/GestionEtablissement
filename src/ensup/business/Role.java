package ensup.business;

import java.util.ArrayList;
import java.util.List;

public enum Role
{
	DIRECTOR (1, "Director"),
	MANAGER  (2, "Manager"),
	TEACHER  (3, "Teacher"),
	STUDENT  (4, "Student");

	private int    numRole;
	private String name;

	private Role(int numRole, String name)
	{
		this.numRole = numRole;
		this.name = name;
	}

	public int    getNum()  { return this.numRole; }
	public String getName() { return this.name; }

	public Role getRoleByName(String name)
	{
		switch(name)
		{
			case "Director": return this.DIRECTOR;
			case "Manager": return this.MANAGER;
			case "Teacher": return this.TEACHER;
			default: return this.STUDENT;
		}
	}

	static public Role getRoleByNum(int num)
	{
		switch(num)
		{
			case 1: return DIRECTOR;
			case 2: return MANAGER;
			case 3: return TEACHER;
			default: return STUDENT;
		}
	}

	public List<Role> getAllRoles()
	{
		List<Role> lRole = new ArrayList<Role>();

		lRole.add(this.DIRECTOR);
		lRole.add(this.MANAGER);
		lRole.add(this.TEACHER);
		lRole.add(this.STUDENT);

		return lRole;
	}
}
