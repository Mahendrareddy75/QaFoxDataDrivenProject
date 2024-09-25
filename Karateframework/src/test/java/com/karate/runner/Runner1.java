package com.karate.runner;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.intuit.karate.cucumber.CucumberRunner;
import com.intuit.karate.cucumber.KarateStats;
import com.intuit.karate.junit5.Karate;

import cucumber.api.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

@CucumberOptions(tags={"@postExample23"},features = "")
public class Runner1 {
	
	@BeforeClass
	public static void before(){
		System.setProperty("karate.env", "test");
	}
	
	@Test
	public void testRunner(){
		String karateOutputPath = "target/surefire-reports";
		KarateStats stats= CucumberRunner.parallel(getClass(), 5, karateOutputPath);
		generateReport(karateOutputPath);
	}

	public static void generateReport(String karateOutputPath) {
		 Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
//		 List<String> jsonPaths = new ArrayList(jsonFiles.size());
//		 jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
		 Configuration config = new Configuration(new File("target"), "Karate API Testing");
//		 ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
//		 reportBuilder.generateReports();
	}
	
	
	
}

