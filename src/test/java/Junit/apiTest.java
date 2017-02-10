package test.java.Junit;

import static org.junit.Assert.*;

import java.io.*;
import java.net.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class apiTest {
	
	public String url="http://192.168.30.120:28080";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	public static String getHTML(String urlToRead) throws Exception {
	      StringBuilder result = new StringBuilder();
	      URL url = new URL(urlToRead);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      String line;
	      while ((line = rd.readLine()) != null) {
	         result.append(line);
	      }
	      rd.close();
	      return result.toString();
	   }	
	
	@Test
	public void test4() throws Exception{
//		System.out.println("---------------------------");
//		fail("Not yet implemented");
		
		String input="1";
		String output="1";
		
		String value = "/count?num="+input;
	      
		assertEquals(output, getHTML(url+value));
	}

	@Test
	public void test5() throws Exception {
		String input="5";
		String output="5";
		
		String value = "/num?num="+input;
	      
		assertEquals(output, getHTML(url+value));
	}
	
	@Test
	public void test6() throws Exception {
		String input="5";
		String output="12345";
		
		String value = "/count?num="+input;
	      
		assertEquals(output, getHTML(url+value));
	}
}
