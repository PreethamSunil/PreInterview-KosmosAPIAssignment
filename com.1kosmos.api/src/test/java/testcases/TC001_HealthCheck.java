package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.APIBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_HealthCheck extends APIBase {

	
	@BeforeClass
	public void HealthCheckConfig()
	{
		log.info("----TC001 API Validation test started----");	
		
		RestAssured.baseURI = "https://1k-dev.1kosmos.net/healthz";
		httpRequest = RestAssured.given();
		httpRequest.header("content/type", "application/json; charset=UTF-8"); 
		httpResponse = httpRequest.request(Method.GET,""); // response	
	}
	
	@Test(priority = 1)
	public void HealthcheckTest()
	{
		log.info("----TC001 API Validation test started for HealthCheck----");	
		
		log.info("Step001: Validate Status Code Started");
		int statuscode = httpResponse.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		log.info("----Status Code for Health Check is " + statuscode );
		log.info("Step001: Validate Status Code Completed");
		
	}
}
