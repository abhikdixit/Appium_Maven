package pk_appium;

import org.testng.annotations.DataProvider;

public class AppTestData {
	
	@DataProvider(name = "EriBank_MakePayment")
	public Object[][] getDataforEriBank() {
		// Multidimensional Object
		// 3X3 or 4X3 or 4X5
		return new Object[][] {

				{"111111111", "Abhi","10","India"},
				{"222222222", "Adarsh","15","USA"},
				{"333333333", "Deepika","20","Norway"}
				};

	}
	
	@DataProvider(name = "EriBank")
	public Object[][] getDataforEriBankOnly() {
		// Multidimensional Object
		// 3X3 or 4X3 or 4X5
		return new Object[][] {

				{"111111111", "Abhi","10"},
				{"222222222", "Adarsh","15"},
				{"333333333", "Deepika","20"}
				};

	}
}
