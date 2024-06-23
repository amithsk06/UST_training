package karateTestcase;

import com.intuit.karate.junit5.Karate;

public class Testrunner {

	@Karate.Test
	Karate KarateTest() {
        return Karate.run("classpath:karateTestcase/bookstest.feature").relativeTo(getClass());
    }
}
