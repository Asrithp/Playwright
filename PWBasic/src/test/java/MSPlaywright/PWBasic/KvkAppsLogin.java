package MSPlaywright.PWBasic;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class KvkAppsLogin 
{
 Playwright palywright;
 Browser browser;
 
 String Url = "https://kvkapps-angular-poc.azurewebsites.net/";
 String username = "//input[@id='mat-input-0']";
 String password = "//input[@id='mat-input-1']";
 String loginButton = "//span[text()='Login']";
 String checkbox = "//span[@class=\"check\"]";
 
 @BeforeClass
 public void setup() 
 {
	 Playwright playwright = Playwright.create();

     // Browser launching
     LaunchOptions lop = new LaunchOptions();
     lop.setChannel("chrome");
     lop.setHeadless(false);
     browser = playwright.chromium().launch(lop);
 }

 @Test
public void testSuccessfulLogin() 
{
	 Page page = browser.newPage();

     // Web site launching
     page.navigate(Url);

     // Verifying title
     Assert.assertEquals(page.title(), "KVKApps - Angular Demo Application");
     
             // User name
             Locator UN = page.locator(username);
             UN.clear();
             UN.fill("admin@software.com");

             // Password
             Locator pass = page.locator(password);
             pass.clear();
             pass.fill("admin@123");

             // Login button
             Locator Lb = page.locator(loginButton);
             Lb.click();

             String HP = page.locator("//span[text()='KVKApps']").textContent();
             
             Assert.assertEquals(HP, "KVKApps", "Login Successful Tc -1 passed");
           
        //closing page
        page.close();
}

 @Test
public void testFailedLoginWithIncorrectPassword() 
{
	 Page page1 = browser.newPage();

     // Web site launching
     page1.navigate(Url);

     Assert.assertEquals(page1.title(), "KVKApps - Angular Demo Application");

    
             // User name
             Locator UN1 = page1.locator(username);
             UN1.clear();
             UN1.fill("admin@software.com");

             // Password
             Locator pass1 = page1.locator(password);
             pass1.clear();
             pass1.fill("admin@1234");

             // Login button
             Locator Lb1 = page1.locator(loginButton);
             Lb1.click();
			
			 String HP1 = page1.locator("//div[text()=\"Username or password is incorrect\"]").textContent();
			
			Assert.assertEquals(HP1, "Username or password is incorrect", "Login failed Tc-2 passed");
			
    //closing page
    page1.close();
}

 @Test
public void FailedLoginwithUnregisteredUsername() 
{
	 Page page2 = browser.newPage();

     // Web site launching
     page2.navigate(Url);

     Assert.assertEquals(page2.title(), "KVKApps - Angular Demo Application");
     
             // User name
             Locator UN2 = page2.locator(username);
             UN2.clear();
             UN2.fill("admin@software");

             // Password
             Locator pass2 = page2.locator(password);
             pass2.clear();
             pass2.fill("admin@1234");

             // Login button
             Locator Lb2 = page2.locator(loginButton);
             Lb2.click();
			
			 String HP2 = page2.locator("//div[text()=\"Username or password is incorrect\"]").textContent();
			Assert.assertEquals(HP2, "Username or password is incorrect", "Login failed Tc-3 passed");
			
    //closing page
    page2.close();

}

 public void InvalidLoginAttemptwithEmptyFields() 
 {
	 Page page3 = browser.newPage();

     // Web site launching
     page3.navigate(Url);

     Assert.assertEquals(page3.title(), "KVKApps - Angular Demo Application");

             // User name
             Locator UN3 = page3.locator(username);
             UN3.clear();
             

             // Password
             Locator pass3 = page3.locator(password);
             pass3.clear();

             //check box 
           Locator cb3 = page3.locator(checkbox);
           cb3.click();
             
		//error text fields
			String UNE3 = page3.locator("//mat-error[text()=\" Username is required \"]").textContent();
			 
			 String PassE3 = page3.locator("//mat-error[text()=\" Password is required \"]").textContent();
			
			 
			page3.locator("//span[@class=\"check\"]").click();
			
			Assert.assertEquals(UNE3, " Username is required ");
			Assert.assertEquals(PassE3, " Password is required ", "login failed Tc -4 passed");
			
			
    //closing page
    page3.close();
 }

 @Test
 public void testInvalidLoginWithOnlyUsernameFilled() {
     Page page4 = browser.newPage();
     page4.navigate(Url);
     Assert.assertEquals(page4.title(), "KVKApps - Angular Demo Application");

     Locator UN4 = page4.locator(username);
     UN4.clear();
     UN4.fill("admin@software.com");

     Locator pass4 = page4.locator(password);
     pass4.clear();

     Locator cb4 = page4.locator(checkbox);
     cb4.click();

     String PassE4 = page4.locator("//mat-error[text()=\" Password is required \"]").textContent();

     page4.locator("//span[@class=\"check\"]").click();

     Assert.assertEquals(PassE4, " Password is required ", "login failed Tc -5 passed");

     page4.close();
 }

 @Test
 public void testInvalidLoginWithOnlyPasswordFilled() {
     Page page5 = browser.newPage();
     page5.navigate(Url);
     Assert.assertEquals(page5.title(), "KVKApps - Angular Demo Application");

     Locator UN5 = page5.locator(username);
     UN5.clear();

     Locator pass5 = page5.locator(password);
     pass5.clear();
     pass5.fill("admin@123");

     Locator cb5 = page5.locator(checkbox);
     cb5.click();

     String UNE5 = page5.locator("//mat-error[text()=\" Username is required \"]").textContent();

     page5.locator("//span[@class=\"check\"]").click();

     Assert.assertEquals(UNE5, " Username is required ", "login failed Tc -6 passed");

     page5.close();
 }

 @Test
 public void testSuccessfulLoginAndLogout() {
     Page page6 = browser.newPage();
     page6.navigate(Url);
     Assert.assertEquals(page6.title(), "KVKApps - Angular Demo Application");

     Locator UN6 = page6.locator(username);
     UN6.clear();
     UN6.fill("admin@software.com");

     Locator pass6 = page6.locator(password);
     pass6.clear();
     pass6.fill("admin@123");

     Locator Lb6 = page6.locator(loginButton);
     Lb6.click();

     String HP6 = page6.locator("//span[text()='KVKApps']").textContent();
     Assert.assertEquals(HP6, "KVKApps");

     page6.locator("//span[text()=\"Ella Jones\"]").click();
     page6.locator("//span[text()=\"Logout \"]").click();

     Assert.assertEquals(page6.title(), "KVKApps - Angular Demo Application", "logout Successful Tc -7 passed");

     page6.close();
 }




@AfterClass
public void teardown() 
{
	browser.close();
}


}
