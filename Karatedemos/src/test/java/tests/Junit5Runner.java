package tests;

import com.intuit.karate.junit5.Karate;

public class Junit5Runner {
	
	@Karate.Test
	Karate karateTest() {
		return Karate.run("classpath:tests/Sampletest.feature").relativeTo(getClass());
	}
}


