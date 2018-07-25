package in.pune.amanora.idemia.stepsImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonParser;
import in.pune.amanora.idemia.util.TestProp;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.seleniumhq.jetty9.http.HttpStatus;


public class ShelfTestStepsImpl extends ScenarioSteps {
		private static final long serialVersionUID = 1L;
		
		long count;
		Date updateDate;
		
		@Step
		public void create(String url) {
			Map<String, String> requestHeaders = new HashMap<String, String>();
			requestHeaders.put("Content-Type", "application/json");
			
			Map<String,Object> object = new HashMap<String, Object>();
			object.put("id", "101");
			object.put("capacity", "10");
			object.put("books", null);
			
			Response res = SerenityRest.given().headers(requestHeaders)
		        	.contentType(ContentType.JSON)
		        	.body(object)
		        	.when().post(url).thenReturn();
			
			String resBody = res.getBody().asString();
			JsonObject resBodyJson = new JsonParser().parse(resBody).getAsJsonObject();
			TestProp.writeProp("api.id",resBodyJson.get("id").toString());
		}
		
		@Step
		public void testCreate() {
			Assert.assertTrue(TestProp.readProp("api.id") != null);
		}
		
		@Step
		public void testStatus() {
			assertThat("Response status code", SerenityRest.then().extract().statusCode() ,equalTo(HttpStatus.OK_200));
		}
		
		@Step
		public void whenreadOne(String url) {
			url = url +"/"+ TestProp.readProp("api.id");
			Map<String , String> requestHeaders2 = new HashMap<String, String>();
			requestHeaders2.put("ContentType", "application/json");	
			SerenityRest.given().headers(requestHeaders2).contentType(ContentType.JSON).when().get(url).thenReturn();

		}
		
		@Step
		public void thenReadOne() {
			assertThat(SerenityRest.then().extract().body().jsonPath().get("id").toString(), equalTo(TestProp.readProp("api.id").toString()));
		
		}
		
		@Step
		public void whenReadAll(String url) {
			Map<String, String> requestHeader3 = new HashMap<String, String>();
			requestHeader3.put("ContentType", "application/json");
			SerenityRest.given().headers(requestHeader3).contentType(ContentType.JSON).when().get(url).thenReturn();
		}
		
		@Step
		public void thenReadAll()
		{
			List<Object> list = SerenityRest.then().extract().body().jsonPath().get("id");
			assertTrue(list.size() >0);
		}
		
		@Step
		public void whenUpdateShelf(String url)
		{
			url = url +"/"+TestProp.readProp("api.id");
			Map<String, String> requestHeader4 =new HashMap<String, String>();
			requestHeader4.put("ContentType", "application/json");
			
			List<Object> bookList = new ArrayList<>();
			Map<String,Object> updateObject = new HashMap<String,Object>();
			updateObject.put("id", TestProp.readProp("api.id"));
			updateObject.put("capacity", "20");
			updateObject.put("books", bookList);
			
			//String resBody = rec.getBody().toString();
			SerenityRest.given().headers(requestHeader4)
        	.contentType(ContentType.JSON)
        	.body(updateObject)
        	.when().put(url);
		}
		
		@Step
		public void thenUpdateShelf()
		{
			Assert.assertTrue(SerenityRest.then().extract().response().getBody().jsonPath().get("capacity").toString().equals("20"));
		}
		
		@Step
		public void whenDeleteShelf(String url)
		{
			url=url+"/"+TestProp.readProp("api.id");
			
			Map<String, String> requestHeader5 =new HashMap<String, String>();
			requestHeader5.put("ContentType", "application/json");
			
			SerenityRest.given().headers(requestHeader5).contentType(ContentType.JSON).when().delete(url).thenReturn();
		}
		
		@Step
		public void thenDeleteShelf()
		{
			Assert.assertTrue(true);
			
		}

}
