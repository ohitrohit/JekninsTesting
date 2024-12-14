package Testing;

import org.testng.annotations.Test;

import GenericUtilities.BaseClass;

public class DiffrentName extends BaseClass{

	@Test
	public void name() {
		
		String name = "Rohit"+jUtil.getRandomNumber();
		System.out.println(name);
		
		pUtil.setProperty("Name", name);
	}
}
