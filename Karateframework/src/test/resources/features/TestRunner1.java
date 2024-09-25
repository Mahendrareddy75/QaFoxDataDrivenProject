package features;

import org.junit.runner.RunWith;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.junit4.Karate;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

@RunWith(Karate.class)
@KarateOptions( tags = {"@postExample23"} )
public class TestRunner1 {
	
	/*@BeforeClass
	public static void before(){
		System.setProperty("karate.env", "test");
	}*/
	@Test
	public void test(){
		Results results = Runner.parallel(getClass(),5);
		 assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
	}

}
