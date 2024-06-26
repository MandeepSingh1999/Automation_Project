package TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import GenericLib.BaseTest;
import GenericLib.Flib;
import GenericLib.WorkLib;
import PomPages.HomePage;
import PomPages.LoginPage;
import PomPages.UserListPage;
import PomPages.createNewUserPage;

public class CreateUserTest extends BaseTest {
	
	@Test(groups = "RT")
	public void createUser() throws EncryptedDocumentException, IOException, InterruptedException {

		// login
		Flib lib = new Flib();
		String username = lib.getDataFromExcelSheet(Excel_Path, SHEETNAME, 1, 0);
		String password = lib.getDataFromExcelSheet(Excel_Path, SHEETNAME, 1, 1);
		LoginPage lp = new LoginPage(driver);
		lp.ValidLogin(username, password);

		// click on user link
		HomePage hp = new HomePage(driver);
		hp.clickonUserLink();

		// click on create new user button
		UserListPage usp = new UserListPage(driver);
		usp.clickOnCreateNewCustomer();

		// fill all the details and click on create user button
		WorkLib wlib = new WorkLib();
		String usn = lib.getDataFromExcelSheet(Excel_Path, USERSHEET, 1, 0) + wlib.getRandomNo();
		String pwd = lib.getDataFromExcelSheet(Excel_Path, USERSHEET, 1, 1) + wlib.getRandomNo();
		String fn = lib.getDataFromExcelSheet(Excel_Path, USERSHEET, 1, 2) + wlib.getRandomNo();
		String ln = lib.getDataFromExcelSheet(Excel_Path, USERSHEET, 1, 3) + wlib.getRandomNo();

		createNewUserPage cnup = new createNewUserPage(driver);
		cnup.createNewUser(usn, pwd, fn, ln);

	}


}
