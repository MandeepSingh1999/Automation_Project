package TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import GenericLib.BaseTest;
import GenericLib.Flib;
import GenericLib.WorkLib;
import PomPages.ActiveProjectAndCustomers;
import PomPages.HomePage;
import PomPages.LoginPage;
import PomPages.createNewCustomerPage;
import PomPages.openTaskPage;

public class CreateCustomerAndProjectTest extends BaseTest {
	
	@Test(groups = "RT")
	public void createCustomerAndProject() throws EncryptedDocumentException, IOException
	{
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

				// click on create new customer button
				ActiveProjectAndCustomers apac = new ActiveProjectAndCustomers(driver);
				apac.clickOnCreateNewCustomerButton();

				// create customer and project
				WorkLib wlib = new WorkLib();
				String customerName = lib.getDataFromExcelSheet(Excel_Path, CUSTPROJSHEET, 1, 0) + wlib.getRandomNo();
				String ProjectName = lib.getDataFromExcelSheet(Excel_Path, CUSTPROJSHEET, 1, 1) + wlib.getRandomNo();
				createNewCustomerPage ancp = new createNewCustomerPage(driver);
				ancp.createCustomerAndProject(customerName, driver, ProjectName);

	}

}
