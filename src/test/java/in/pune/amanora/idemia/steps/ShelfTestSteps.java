package in.pune.amanora.idemia.steps;
import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;



import in.pune.amanora.idemia.stepsImpl.ShelfTestStepsImpl;
import in.pune.amanora.idemia.util.TestProp;

public class ShelfTestSteps {
	

		String url;
		Long count;
		String xauthtoken;
		
		@Steps
		ShelfTestStepsImpl shelfTestStepsImpl;
		
		@Given("API for creating new shelf '$apiUrl'")
		public void given(String apiUrl) {
			
			TestProp.initTestProp();
			TestProp.setBaseUrl();
			TestProp.setApiUrl(apiUrl);
			this.url = TestProp.getBaseUrl() + TestProp.getApiUrl();
		}
		
		@When("create request is sent for shelf")
		public void whenCreate() {
			shelfTestStepsImpl.create(this.url);
		}
		
		@Then("shelf should be created")
		public void thenCreate() {
			shelfTestStepsImpl.testCreate();
		}
	
		@Then("Status code should be 200")
		public void thenTestSatusCode() {
			shelfTestStepsImpl.testStatus();
		}
		
		@Given("API for shelf details '$apiUrl'")
		public void given2(String apiUrl) {
			TestProp.setBaseUrl();
			this.url = TestProp.getBaseUrl() + TestProp.getApiUrl();
		}
		
		@When("Read request is sent for specified shelf")
		public void whenreadOne() {
			shelfTestStepsImpl.whenreadOne(this.url);
		}
		
		@Then("Fetch details for specified shelf")
		public void thenReadOne() {
			shelfTestStepsImpl.thenReadOne();
		}

		
		@When("Read request is sent for shelves")
		public void whenReadAll() {
			shelfTestStepsImpl.whenReadAll(this.url);
		}
		
		@Then("Fetch details for all shelves")
		public void thenReadAll()
		{
			shelfTestStepsImpl.thenReadAll();
		}
		
		@When("Update request is sent for shelf")
		public void whenUpdateShelf()
		{
			shelfTestStepsImpl.whenUpdateShelf(this.url);
		}
		
		@Then("shelf data should get updated")
		public void thenUpdateShelf()
		{
			shelfTestStepsImpl.thenUpdateShelf();
		}
		
		@When("delete request is sent for specified shelf")
		public void whenDeleteShelf()
		{
			shelfTestStepsImpl.whenDeleteShelf(this.url);
		}
		
		@Then("shelf should get deleted")
		public void thenDeleteShelf()
		{
			shelfTestStepsImpl.thenDeleteShelf();
		}
		
}
