package tests;

import org.testng.annotations.Listeners;

import com.intuit.karate.junit5.Karate;

@Listeners(utilities.ExtentReportsListener.class)
public class JUnitRunner {
	
	@Karate.Test
	Karate karateTest() {
		return Karate.run("classpath:tests/SampleTest.feature").relativeTo(getClass());
		
	}
 
}
 