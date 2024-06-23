package apiTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import payload.Book_model;
import ust.com.endpoints.Endpoints;
import utilities.DataProviders;

public class DatadrivenTest {

	@Test(priority = 1, dataProvider = "data", dataProviderClass = DataProviders.class)
	public void testPostuser(String id, String title, String desc, String pagecount, String excerpt, String date) {
		Book_model bookPayload = new Book_model();
		bookPayload.setId(Long.parseLong(id));
		bookPayload.setTitle(title);
		bookPayload.setDescription(desc);
		bookPayload.setPageCount(Integer.parseInt(pagecount));
		bookPayload.setExcerpt(excerpt);
		bookPayload.setPublishDate(date);
		Response response = Endpoints.createBook(bookPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
