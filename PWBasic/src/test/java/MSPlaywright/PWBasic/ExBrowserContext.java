package MSPlaywright.PWBasic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ExBrowserContext {

	public static void main(String[] args) 
	{
       
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	   
		//browser page 1
		BrowserContext B1 = browser.newContext();
		Page page1 = B1.newPage();
	    page1.navigate("https://www.facebook.com");
	    System.out.println(page1.title());
	    
	    
	    
	    
	    //browser page 2
	   BrowserContext B2 = browser.newContext();
	 Page page2 = B2.newPage();
	 page2.navigate("http://www.google.com");
	 System.out.println(page2.title());
	 
	 page1.close();
	 B1.close();
     page2.close();
     B2.close();
     
     browser.close();
	}

}
