package testCases;

import org.testng.annotations.Test;

import pageObjactes.SignInPage;

public class TC_SignIN extends BaseTest{

	@Test
	public void test() {
		try {
			SignInPage sp=new SignInPage(driver);
			sp.move();
			sp.input(P.getProperty("email"));
			sp.password(P.getProperty("password"));
			System.out.println(sp.message());
		}
		catch(Exception e){
			System.out.println("Exception handled successfully");
		}
	}
}
