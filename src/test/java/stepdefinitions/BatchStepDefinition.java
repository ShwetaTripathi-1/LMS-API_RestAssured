package stepdefinitions;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import pojo.AddPrograme;
import resources.APIResources;
import resources.TestData;
import resources.Utils;
import pojo.AddBatch;

public class BatchStepDefinition extends Utils {
	
	RequestSpecification res;
	ResponseSpecification resspec;
	 Response response;
	 TestData data = new TestData();
	 
	 @Given("Add Batch Payload with {string} , {string},{string},{string},{string},{string}")
	 public void add_batch_payload_with(String creationTime, String lastModTime, String batchName, String batchDescription, String batchNoOfClasses, String programId) throws IOException {
		
	res=given().spec(requestSpecification()).body(data.addBatchPayload(creationTime,lastModTime,batchName,batchDescription,batchNoOfClasses,programId));
	    
	}

	@When("User call {string} with {string} request")
	public void user_call_with_post_request(String resource, String method) {
     APIResources resourseAPI=	APIResources.valueOf(resource);
     resourseAPI.getResourse();
     
		resspec = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
	     response = res.when().post(resourseAPI.getResourse()).then().spec(resspec).extract().response();
	}

	@Then("responce API call got success with status code {int}")
	public void responce_api_call_got_success_with_status_code(Integer int1) {
		
		assertEquals(response.getStatusCode(),201);
	
	}
	

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String Expectedvalue) {
		
	  String resp=  response.asString();
	  JsonPath js = new JsonPath(resp);
	 assertEquals( getJsonPath(response,key),Expectedvalue);
	}

	

		@Then("verify {string} created maps with {string}")
		public void verify_created_maps_with(String expectedBatchName, String resourse) throws IOException {
			
		    String batch_id= getJsonPath(response,"Batch_Id");
		    res = given().spec(requestSpecification()).queryParam("batch_id", batch_id);
		    user_call_with_post_request(resourse,"GET");
		    String actual_batch_name= getJsonPath(response,"batchName");
		    assertEquals(actual_batch_name,expectedBatchName);
		    
		}

}
