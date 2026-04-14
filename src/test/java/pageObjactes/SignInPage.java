package pageObjactes;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

	public SignInPage(WebDriver driver) {
		super(driver);
	}
	Actions act=new Actions(driver);
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	@FindBy(xpath="//div[@id='nav-link-accountList']/child::a") WebElement hello;
	@FindBy(xpath="//span[text()='Sign in']") WebElement signIn;
	@FindBy(xpath="//input[@type='email']") WebElement email;
	@FindBy(xpath="//h1[@class='a-size-medium-plus a-spacing-small']") WebElement clk;
	@FindBy(xpath="//input[@type='email']") WebElement contButton;
	@FindBy(xpath="//input[@id='ap_password']") WebElement password;
	@FindBy(xpath="//input[@id='signInSubmit']") WebElement sign;
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']") WebElement confirmationmsg;
	public void move() {
		act.moveToElement(hello).moveToElement(signIn).click().build().perform();
	}
	public void input(String mail) {
		email.sendKeys(mail);
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		//js.executeScript("arguments[0].click();", clk);
		//act.moveToElement(contButton).click().perform();
	}
	public void password(String pass) {
		this.password.sendKeys(pass);
		sign.click();
	}
	
	public String message() {
		return confirmationmsg.getText();
	}
}
