package garage.SeleniumFramework;

import java.util.Collection;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import garage.utility.SeleniumConstants;


public abstract class PageObject {
    private WebDriver driver;
	protected String title;
	protected static By body = By.xpath("//body");
	protected static By xpathTitle = By.xpath("//title");
	public SeleniumConstants seleniumConstants = new SeleniumConstants();
	public String URL = seleniumConstants.getUrl();
	
	public PageObject(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement find(By by)
	{
		return driver.findElement(by);
	}
	
	public void clear(By by){
		find(by).clear();
	}
	
	public void sendKeys(By by, String value){
		find(by).sendKeys(value);
	}
	
	public void clearAndSendKeys(By by, String value)
	{
		clear(by);
		sendKeys(by, value);
	}
	
	public void click(By by){
		find(by).click();
	}
	
	public Collection<WebElement> findAll(By by){
		return driver.findElements(by);
	}
	
	public String getInnerHtml(By by){
		return find(by).getAttribute("innerHTML");
	}
	
	public String getText(By by){
		return find(by).getText();
	}
	
	public String getTitle(){
		return getInnerHtml(xpathTitle);
	}
	
	public String getUrl(){
		return driver.getCurrentUrl();
	}
	
	public void goTo(String url){
		driver.get(url);
	}
	
	public void submit(By by)
	{
		find(by).submit();
	}
	
	public void selectByText(By by, String optionText){
		Select select = new Select(find(by));
		if (!select.equals(null))
		{
			try
			{
				select.selectByVisibleText(optionText);
			}
			catch (Exception ex)
			{
				String errMsg = String.format(
						"PageObject: There is no option '%s' in '%s'.",
						optionText, by);
			}
		}
	}

	
}
