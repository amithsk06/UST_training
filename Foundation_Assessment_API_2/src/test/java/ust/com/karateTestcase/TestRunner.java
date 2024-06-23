package ust.com.karateTestcase;

import com.intuit.karate.junit5.Karate;

public class TestRunner {

	@Karate.Test
	public Karate KarateTest() {
		return Karate.run("freefakeapi.feature").relativeTo(getClass());
	}
}
