package MSPlaywright.PWBasic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ElementAndElements {

	public static void main(String[] args) 
	{
      
	Playwright playwright = Playwright.create();
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page = browser.newPage();
	page.navigate("https://www.orangehrm.com/30-day-free-trial/");
	
	/*//single locator 
	page.click("text = Form_getForm_Country new account");
	System.out.println(page.title());*/

    //multiple locators 
	Locator day = page.locator("select#Form_getForm_Country option");
    System.out.println(day.count());
    
    
	//to print all available
    for(int i=0; i<day.count(); i++) 
    {
    	String totalday = day.nth(i).textContent();
    	System.out.println(totalday);
    }
    
	
	
	page.close();
	browser.close();
	
	/*//single element:
Locator contactSales = page. locator ("text = CONTACT SALES");
contactSales.hover(); contactSales.click();

Locator loginBtn = page. locator("text = Login");
int totalLogins = loginBtn.count();
System.out-println (totalLogins); loginBtn.first().click();

//mutliple elements:
Locator countryOptions = page. locator ("select#Form_submitForm_Country option");
System.out.println(country0ptions.count());

for(int i=0; i<countryOptions.count(); i++) {
String text = countryOptions.nth(i).textContent ();
System.out. println(text);*/
		
	}

}
