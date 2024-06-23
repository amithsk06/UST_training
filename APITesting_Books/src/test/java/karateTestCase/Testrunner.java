package karateTestCase;

import com.intuit.karate.junit5.Karate;

public class Testrunner {

	@Karate.Test
	Karate KarateTest() {
		return Karate.run("classpath:karateTestCase/fakerestapi_books.feature").relativeTo(getClass());
	}
}
