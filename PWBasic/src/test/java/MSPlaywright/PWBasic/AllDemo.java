package MSPlaywright.PWBasic;

import java.nio.file.Paths;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class AllDemo {

	public static void main(String[] args)
	
	{
		//creating playwright
        Playwright playwright = Playwright.create();
        
        //setup of a browser
     LaunchOptions lp = new LaunchOptions();
     
     //mention which browser want to open
     lp.setChannel("chrome");
     
     //headless action need visible if it is false
     lp.setHeadless(false);
     
     //launching browser   
       Browser browser = playwright.chromium().launch(lp);
       
       //this for browser context to use multiple pages  to open 
       /*  BrowserContext context = browser.newContext();
       
     //tracing and capturing screenshot
      context.tracing().start(new Tracing.StartOptions()
    		   .setScreenshots(true)
    		   .setSnapshots(true)
    		   .setSources(true));*/
       
       //opening new page
       Page page = browser.newPage();
       
       //navigating to Url
       page.navigate("https://www.facebook.com");
       
       //printing page title
       System.out.println(page.title());
       
       //click action on button
      page.click("(//a[@role=\"button\"])[2]"); 
      
      //fill details in name text field
      page.fill("//input[@name=\"firstname\"]", "Asrith");
      
      page.press("//input[@name=\\\"firstname\\\"]", "Tab");
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
       // Stop tracing and export it into a zip archive.
     /* context.tracing().stop(new Tracing.StopOptions()
    		  .setPath(Paths.get("trace.zip"))); */
      //after completing script refresh the project to get this file on project 
      
      //to open zip file use this command on terminal or open link by navigating to this project
     /* https://trace.playwright.dev (or)
      *  mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace trace.zip"*/
       
       
       //closing page 
       page.close();
       
       //closing browser
       browser.close();
	}

}
