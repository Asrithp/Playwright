package MSPlaywright.PWBasic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelector {

	public static void main(String[] args) 
	{
      Playwright playwright = Playwright.create();
   LaunchOptions Cl = new  LaunchOptions();
   Cl.setChannel("chrome");
  Cl.setHeadless(false);
      Browser browser = playwright.chromium().launch(Cl);
      Page page = browser.newPage();
      page.navigate("https://docs.opencart.com/en-gb/store-front/");
      
      Locator home = page.locator("//a[text()='Home']").last();
    home.click();
       String Intro = page.locator("//h1[text()='Introduction']").textContent();
      if (Intro.equals("Introduction")) 
        {
		  System.out.println(Intro);
		  
		   Locator oc = page.locator("//h2[text()='OpenCart']");
		    
				String tex = oc.innerText();
			System.out.println(tex);
			
			//this method for get text from source and printing
		     String op = page.getByText("OpenCart is free open source").textContent();
              System.out.println(op);
            String re = page.getByText("This guide serves as a resource").textContent();
          System.out.println(re);
        }
      else 
        {
		 System.out.println("failed");
	    }
    
      page.close();
      browser.close();
	}

}
