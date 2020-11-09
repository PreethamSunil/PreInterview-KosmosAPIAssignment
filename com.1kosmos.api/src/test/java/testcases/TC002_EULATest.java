package testcases;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.APIBase;
import io.restassured.RestAssured;



public class TC002_EULATest extends APIBase{

	@BeforeClass
	public void EULAConfig()
	{
	log.info("----TC002 API Validation test started for EULA----");	
	RestAssured.baseURI = "https://1k-dev.1kosmos.net/api/v3/rest/default";
	httpRequest = RestAssured.given();
	httpRequest.header("content/type", "application/json; charset=UTF-8"); 
	httpResponse = httpRequest.queryParam("tenant", "1kosmos") .get("/eula");

	}
	
	@Test(priority = 1)
	public void ValidateStatus()
	{
		log.info("----TC002: Status Code Check----");	
		log.info("Step001: Validate Status Code Started");
		int statuscode = httpResponse.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		log.info("----Status Code for EULA call is " + statuscode );
		log.info("Step001: Validate Status Code Completed");
	}
	
	@Test(priority = 2)
	public void ValidateResponce()
	{
		log.info("----TC002: Response Check----");	
		log.info("Step001: Validate Response is not null");
		String responcebody = httpResponse.getBody().asString();
		Assert.assertNotNull(responcebody, "Responce Body");
		log.info("----Responce Code for EULA call is " + responcebody );
		log.info("Step002: Validate response is Completed");
	}
	
	@Test (priority=3)
	public void Validateschema()
	{
		log.info("Step003: Validate Schema Started");
		httpResponse.then().body(matchesJsonSchemaInClasspath("targetschema.json")); 
		log.info(httpResponse.getBody().asString());
		log.info("Step003: Validate Schema Completed");
	}
	
}
