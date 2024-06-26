package TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import GenericLib.BaseTest;
import GenericLib.Flib;
import PomPages.ActiveProjectAndCustomers;
import PomPages.HomePage;
import PomPages.LoginPage;
import PomPages.openTaskPage;

public class DeleteAllProjectAndCustomerTest extends BaseTest {
	
	@Test(groups = {"RT","IT"})
	public void deleteCustomerAndProject() throws EncryptedDocumentException, IOException {

		// login
		Flib lib = new Flib();
		String username = lib.getDataFromExcelSheet(Excel_Path, SHEETNAME, 1, 0);
		String password = lib.getDataFromExcelSheet(Excel_Path, SHEETNAME, 1, 1);
		LoginPage lp = new LoginPage(driver);
		lp.ValidLogin(username, password);

		// click on task link
		HomePage hp = new HomePage(driver);
		hp.clickonTaskLink();

		// click on projectandCustomer
		openTaskPage otp = new openTaskPage(driver);
		otp.clickOnProjectAndCustomer();

		// delete all
		ActiveProjectAndCustomers apac = new ActiveProjectAndCustomers(driver);
		apac.deleteProjectAndCustomer();

	}

}
