package base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIBase {

	public static RequestSpecification httpRequest;
	public static Response httpResponse;
	
	public Logger log;
	
	@BeforeSuite
	public void initialSetup()
	{
		System.out.println("API Initial Setup is Started");
		log = Logger.getLogger("APIAssignment"); //Comment -- Create a logger 
		PropertyConfigurator.configure("log4j.properties"); 
		log.setLevel(Level.INFO);
	}
	

}
