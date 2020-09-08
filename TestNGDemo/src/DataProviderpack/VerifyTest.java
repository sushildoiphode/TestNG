package DataProviderpack;

import org.testng.annotations.Test;

public class VerifyTest {
	@Test(dataProvider="CredentialsData", dataProviderClass=DataFeeder.class)
	public void verifyLoginWithDifferentCredential(String uname,String pass) {
		System.out.println("Username: "+uname+"  Passwd:"+pass);

	}
}
