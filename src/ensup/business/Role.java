package ensup.business;

import java.util.ArrayList;
import java.util.List;

public enum Role
{
	DIRECTOR (1, "Director"),
	MANAGER (2, "Manager"),
	TEACHER (3, "Teacher"),
	STUDENT (4, "Student");
	
	private int numRole;
	private String name;
	
	private Role(int numRole, String name)
	{
		this.numRole = numRole;
		this.name = name;
	}
	
	public int    getNum()  { return this.numRole; }
	public String getName() { return this.name; }
	
	public Role getNumByName(String name)
	{
		switch(name)
		{
			case "Director": return this.DIRECTOR;
			case "Manager": return this.MANAGER;
			case "Teacher": return this.TEACHER;
			default: return this.STUDENT;
		}
	}
	
	public List<Role> getAllRoles()
	{
		return new ArrayList<Role>();
	}
}
