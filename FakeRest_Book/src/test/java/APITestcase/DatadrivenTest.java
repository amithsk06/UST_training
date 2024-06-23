package APITestcase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Endpoints.BookEndpoints;
import Payload.Book_modal;
import io.restassured.response.Response;
import utilities.DataProviders;

public class DatadrivenTest {

	@Test(priority = 1, dataProvider = "data", dataProviderClass = DataProviders.class)
	public void testPostuser(String id, String title, String desc, String pagecount, String excerpt, String date) {
		Book_modal bookPayload = new Book_modal();
		bookPayload.setId(Long.parseLong(id));
		bookPayload.setTitle(title);
		bookPayload.setDescription(desc);
		bookPayload.setPageCount(Integer.parseInt(pagecount));
		bookPayload.setExcerpt(excerpt);
		bookPayload.setPublishDate(date);
		Response response = BookEndpoints.createUser(bookPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
