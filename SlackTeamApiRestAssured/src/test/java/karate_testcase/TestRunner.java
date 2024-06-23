package karate_testcase;

import com.intuit.karate.junit5.Karate;

public class TestRunner {

	@Karate.Test
	Karate KarateTest() {
		return Karate.run("classpath:karate_testcase/karate.feature").relativeTo(getClass());
}
	}



