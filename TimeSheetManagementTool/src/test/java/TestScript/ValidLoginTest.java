package TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import GenericLib.BaseTest;
import GenericLib.Flib;
import PomPages.LoginPage;

public class ValidLoginTest extends BaseTest {
	
	@Test(groups = "ST")
	public void login() throws EncryptedDocumentException, IOException
	{
		Flib lib = new Flib();
		String username = lib.getDataFromExcelSheet(Excel_Path, SHEETNAME , 1, 0);
		String password = lib.getDataFromExcelSheet(Excel_Path, SHEETNAME, 1, 1);
		LoginPage lp = new LoginPage(driver);
		lp.ValidLogin(username,password);
	}

}
