package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseClass {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	//identify user link
	@FindBy(xpath = "//a[@class='content users']")
	private WebElement usersLink;
	
	//identify Task Link
	@FindBy(xpath = "//a[contains(@class,'content tasks')]")
	private WebElement tasksLink;

	public WebElement getUsersLink() {
		return usersLink;
	}

	public WebElement getTasksLink() {
		return tasksLink;
	}
	
	public void clickonUserLink()
	{
		usersLink.click();
	}
	
	public void clickonTaskLink()
	{
		tasksLink.click();
	}

}
