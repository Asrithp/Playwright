package MSPlaywright.PWBasic;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class KvkApps {


    public static void main(String[] args) {
        Playwright playwright = Playwright.create();

        // Browser launching
        LaunchOptions lop = new LaunchOptions();
        lop.setChannel("chrome");
        lop.setHeadless(false);
        Browser browser = playwright.chromium().launch(lop);
         
        //web site URL
        String Url = "https://kvkapps-angular-poc.azurewebsites.net/";
        
        String username = "//input[@id='mat-input-0']";
        String password = "//input[@id='mat-input-1']";
        String loginButton = "//span[text()='Login']";
        String checkbox = "//span[@class=\"check\"]";
        
        
// Test Case 1: Successful Login
        Page page = browser.newPage();

        // Web site launching
        page.navigate(Url);

        // Verifying title
        String title = page.title();
        
        if (title.equals("KVKApps - Angular Demo Application")) 
        {
            String SI = page.locator("//h2[text()='Sign in']").textContent();

            if (SI.equals("Sign in")) 
            {
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
                if (HP.equals("KVKApps"))
                {
                   System.out.println("Login Successful Tc -1 passed ");
                }
    		  }
    	   }
          else 
          {
    		System.out.println("Tc -2 failed");
    	   }       
           
           //closing page
           page.close();
          
        
        
        
        

// Test Case 2: Failed Login with Incorrect Password
        Page page1 = browser.newPage();

        // Web site launching
        page1.navigate(Url);

        // Verifying title
        String title1 = page1.title();
        
        if (title1.equals("KVKApps - Angular Demo Application")) 
        {
            String SI1 = page1.locator("//h2[text()='Sign in']").textContent();

            if (SI1.equals("Sign in")) 
            {
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
			if (HP1.equals("Username or password is incorrect")) 
			{
				System.out.println("Login failed Tc-2 passed");
			}
		  }
	   }
      else 
      {
		System.out.println("Tc -2 failed");
	   }       
       
       //closing page
       page1.close();
      
       
       
       
//Test Case 3: Failed Login with Unregistered User name
       Page page2 = browser.newPage();

       // Web site launching
       page2.navigate(Url);

       // Verifying title
       String title2 = page2.title();

       if (title2.equals("KVKApps - Angular Demo Application")) 
       {
           String SI2 = page2.locator("//h2[text()='Sign in']").textContent();

           if (SI2.equals("Sign in")) 
           {
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
			if (HP2.equals("Username or password is incorrect")) 
			{
				System.out.println("Login failed Tc-3 passed");
			}
		  }
	   }
     else 
     {
		System.out.println("Tc -3 failed");
	   }       
      
      //closing page
      page2.close();
      
       
       
       
       
       
// Test Case 4: Invalid Login Attempt with Empty Fields
       
       Page page3 = browser.newPage();

       // Web site launching
       page3.navigate(Url);

       // Verifying title
       String title3 = page3.title();

       if (title3.equals("KVKApps - Angular Demo Application")) 
       {
           String SI3 = page3.locator("//h2[text()='Sign in']").textContent();

           if (SI3.equals("Sign in")) 
           {
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
			
			if (UNE3.equals(" Username is required ") && PassE3.equals(" Password is required ")) 
			{
					System.out.println("login failed Tc -4 passed");
			}
		 }
	   }
     else 
     {
		System.out.println("Tc -4 failed");
	   }       
      
      //closing page
      page3.close();
       
      
      
       
//Test Case 5: Invalid Login Attempt with Only User name Filled 
        
        Page page4 = browser.newPage();

        // Web site launching
        page4.navigate(Url);

        // Verifying title
        String title4 = page4.title();

        if (title4.equals("KVKApps - Angular Demo Application")) 
        {
            String SI4 = page4.locator("//h2[text()='Sign in']").textContent();

            if (SI4.equals("Sign in")) 
            {
                // User name
                Locator UN4 = page4.locator(username);
                UN4.clear();
                UN4.fill("admin@software.com");
                
                // Password
                Locator pass4 = page4.locator(password);
                pass4.clear();

                //check box 
              Locator cb4 = page4.locator(checkbox);
              cb4.click();
 			 
 			 String PassE4 = page4.locator("//mat-error[text()=\" Password is required \"]").textContent();
 			
 			page4.locator("//span[@class=\"check\"]").click();
 			
 			if (PassE4.equals(" Password is required ")) 
 			{
 					System.out.println("login failed Tc -5 passed");
 			}
 		  }
 	   }
      else 
      {
 		System.out.println("Tc -5 failed");
 	   }       
       
       //closing page
       page4.close();
       
       
       
 // Test Case 6: Invalid Login Attempt with Only Password Filled

       Page page5 = browser.newPage();

       // Web site launching
       page5.navigate(Url);

       // Verifying title
       String title5 = page5.title();

       if (title5.equals("KVKApps - Angular Demo Application")) 
       {
           String SI5 = page5.locator("//h2[text()='Sign in']").textContent();

           if (SI5.equals("Sign in")) 
           {
               // User name
               Locator UN5 = page5.locator(username);
               UN5.clear();

               // Password
               Locator pass5 = page5.locator(password);
               pass5.clear();
               pass5.fill("admin@123");

               //check box 
             Locator cb5 = page5.locator(checkbox);
             cb5.click();
			 
 			String UNE5 = page5.locator("//mat-error[text()=\" Username is required \"]").textContent();
			 
			page5.locator("//span[@class=\"check\"]").click();
			
			if (UNE5.equals(" Username is required "))
			{
					System.out.println("login failed Tc -6 passed");
			}
		  }
	   }
     else 
     {
		System.out.println("Tc -6 failed");
	   }       
      
      //closing page
      page5.close();
         
      
      
       
//Test Case 7: Successful Login and Logout
      
        Page page6 = browser.newPage();

        // Web site launching
        page6.navigate(Url);

        // Verifying title
        String title6 = page6.title();

        if (title6.equals("KVKApps - Angular Demo Application")) 
        {
            String SI6 = page6.locator("//h2[text()='Sign in']").textContent();

            if (SI6.equals("Sign in")) 
            {
                // User name
                Locator UN6 = page6.locator(username);
                UN6.clear();
                UN6.fill("admin@software.com");

                // Password
                Locator pass6 = page6.locator(password);
                pass6.clear();
                pass6.fill("admin@123");

                // Login button
                Locator Lb6 = page6.locator(loginButton);
                Lb6.click();

                String HP6 = page6.locator("//span[text()='KVKApps']").textContent();
                if (HP6.equals("KVKApps"))
                {
                   page6.locator("//span[text()=\"Ella Jones\"]").click();
                   page6.locator("//span[text()=\"Logout \"]").click();
                   
                   if (title6.equals("KVKApps - Angular Demo Application")) 
                   {
                	  System.out.println("logout Successful Tc -7 passed "); 
                   }
                }
    		  }
    	   }
          else 
          {
    		System.out.println("Tc -7 failed");
    	   }       
           
           //closing page
           page6.close();
        
           
      //browser closing 
       browser.close();
        
	}

}
