package com.example;

import org.testng.annotations.Test;

import api.utilities.DataProviders;

public class TestCase {

	@Test(priority = 1, dataProvider = "data", dataProviderClass = DataProviders.class)
    public void testPostUser(String id, String name, String email, String gender, String status) {
      System.out.println(id);
      System.out.println(name);
	  System.out.println(email);
	  System.out.println(gender);
	  System.out.println(status);
    }
}