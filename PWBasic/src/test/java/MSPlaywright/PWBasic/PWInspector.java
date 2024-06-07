package MSPlaywright.PWBasic;


	import com.microsoft.playwright.*;
	import com.microsoft.playwright.options.*;
	import com.microsoft.playwright.BrowserContext;

	

	public class PWInspector 
	{
	  public static void main(String[] args) {
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch();
	      BrowserContext context = browser.newContext();
	      Page page = context.newPage();
	      page.navigate("https://www.saucedemo.com/");
	      page.locator("[data-test=\"username\"]").click();
	      page.locator("[data-test=\"username\"]").fill("standard_user");
	      page.locator("[data-test=\"password\"]").click();
	      page.locator("[data-test=\"password\"]").fill("secret_sauce");
	      page.locator("[data-test=\"login-button\"]").click();
	      page.locator("[data-test=\"add-to-cart-sauce-labs-backpack\"]").click();
	      page.locator("[data-test=\"add-to-cart-sauce-labs-bike-light\"]").click();
	      page.locator("[data-test=\"add-to-cart-sauce-labs-fleece-jacket\"]").click();
	      page.locator("[data-test=\"add-to-cart-sauce-labs-onesie\"]").click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open Menu")).click();
	      page.locator("[data-test=\"inventory-sidebar-link\"]").click();
	      page.locator("[data-test=\"shopping-cart-link\"]").click();
	      page.locator("[data-test=\"checkout\"]").click();
	      page.locator("[data-test=\"firstName\"]").click();
	      page.locator("[data-test=\"firstName\"]").fill("asrith");
	      page.locator("[data-test=\"lastName\"]").click();
	      page.locator("[data-test=\"lastName\"]").fill("kumar");
	      page.locator("[data-test=\"postalCode\"]").click();
	      page.locator("[data-test=\"postalCode\"]").fill("500072");
	      page.locator("[data-test=\"continue\"]").click();
	      page.locator("[data-test=\"finish\"]").click();
	      page.locator("[data-test=\"back-to-products\"]").click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open Menu")).click();
	      page.locator("[data-test=\"logout-sidebar-link\"]").click();
	    }
	  }
	}

