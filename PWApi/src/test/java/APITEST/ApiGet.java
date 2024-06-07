package APITEST;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

public class ApiGet 
{

	Playwright playwright;
	APIRequest Req;
	APIRequestContext ApiReq;

	
@BeforeClass
public void SetUp() 
{

	 playwright = Playwright.create();
	 Req = playwright.request();
	 ApiReq = Req.newContext();
}
	
@Test
public void GetApi() throws IOException 
{
	
	
APIResponse ApiUrl = ApiReq.get("https://reqres.in/api/users?page=2");

  //status code
int StatusCode = ApiUrl.status();
	//System.out.println(StatusCode);


	Assert.assertEquals(StatusCode, 200);
               //or
//another way to verifying status code
Assert.assertEquals(ApiUrl.ok(), true);

	//status text
	String statustext = ApiUrl.statusText();
	
//System.out.println(StatusText);
Assert.assertEquals(statustext, "OK");

 // This will print response body
//System.out.println(ApiUrl.text());



	
//verifying values of body
byte[] body = ApiUrl.body();
String Values = "{\n"
		+ "  \"page\" : 2,\n"
		+ "  \"per_page\" : 6,\n"
		+ "  \"total\" : 12,\n"
		+ "  \"total_pages\" : 2,\n"
		+ "  \"data\" : [ {\n"
		+ "    \"id\" : 7,\n"
		+ "    \"email\" : \"michael.lawson@reqres.in\",\n"
		+ "    \"first_name\" : \"Michael\",\n"
		+ "    \"last_name\" : \"Lawson\",\n"
		+ "    \"avatar\" : \"https://reqres.in/img/faces/7-image.jpg\"\n"
		+ "  }, {\n"
		+ "    \"id\" : 8,\n"
		+ "    \"email\" : \"lindsay.ferguson@reqres.in\",\n"
		+ "    \"first_name\" : \"Lindsay\",\n"
		+ "    \"last_name\" : \"Ferguson\",\n"
		+ "    \"avatar\" : \"https://reqres.in/img/faces/8-image.jpg\"\n"
		+ "  }, {\n"
		+ "    \"id\" : 9,\n"
		+ "    \"email\" : \"tobias.funke@reqres.in\",\n"
		+ "    \"first_name\" : \"Tobias\",\n"
		+ "    \"last_name\" : \"Funke\",\n"
		+ "    \"avatar\" : \"https://reqres.in/img/faces/9-image.jpg\"\n"
		+ "  }, {\n"
		+ "    \"id\" : 10,\n"
		+ "    \"email\" : \"byron.fields@reqres.in\",\n"
		+ "    \"first_name\" : \"Byron\",\n"
		+ "    \"last_name\" : \"Fields\",\n"
		+ "    \"avatar\" : \"https://reqres.in/img/faces/10-image.jpg\"\n"
		+ "  }, {\n"
		+ "    \"id\" : 11,\n"
		+ "    \"email\" : \"george.edwards@reqres.in\",\n"
		+ "    \"first_name\" : \"George\",\n"
		+ "    \"last_name\" : \"Edwards\",\n"
		+ "    \"avatar\" : \"https://reqres.in/img/faces/11-image.jpg\"\n"
		+ "  }, {\n"
		+ "    \"id\" : 12,\n"
		+ "    \"email\" : \"rachel.howell@reqres.in\",\n"
		+ "    \"first_name\" : \"Rachel\",\n"
		+ "    \"last_name\" : \"Howell\",\n"
		+ "    \"avatar\" : \"https://reqres.in/img/faces/12-image.jpg\"\n"
		+ "  } ],\n"
		+ "  \"support\" : {\n"
		+ "    \"url\" : \"https://reqres.in/#support-heading\",\n"
		+ "    \"text\" : \"To keep ReqRes free, contributions towards server costs are appreciated!\"\n"
		+ "  }\n"
		+ "}";
//ObjectMapper to convert this byte into string
ObjectMapper objcetmapper = new ObjectMapper();
JsonNode readtree = objcetmapper.readTree(body);
String PString = readtree.toPrettyString();
//System.out.println(PString);
Assert.assertEquals(PString, Values);

//headers
Map<String, String> headers = ApiUrl.headers();
//System.out.println(headers);
Assert.assertEquals(headers.get("content-type"), "application/json; charset=utf-8");
Assert.assertEquals(headers.get("server"), "cloudflare");

}


@Test
public void ForSpecipicUser() throws IOException 
{
	APIResponse ApiUrl = ApiReq.get("https://reqres.in/api/users?page=2", RequestOptions.create()
			.setQueryParam("id", 8).setQueryParam("first_name", "Lindsay"));
	 //status code
	int StatusCode = ApiUrl.status();
		//System.out.println(StatusCode);


		Assert.assertEquals(StatusCode, 200);
	               //or
	//another way to verifying status code
	Assert.assertEquals(ApiUrl.ok(), true);

		//status text
		String statustext = ApiUrl.statusText();
		
	//System.out.println(StatusText);
	Assert.assertEquals(statustext, "OK");
                   
	 // This will print response body
	//System.out.println(ApiUrl.text());



		
	//verifying values of body
	byte[] body = ApiUrl.body();
	//ObjectMapper to convert this byte into string
	ObjectMapper objcetmapper = new ObjectMapper();
	JsonNode readtree = objcetmapper.readTree(body);
	String PString = readtree.toPrettyString();
	System.out.println("this is an single user" +PString);

	

} 


}

