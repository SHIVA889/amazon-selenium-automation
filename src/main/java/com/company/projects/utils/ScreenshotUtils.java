package com.company.projects.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	
	private ScreenshotUtils() {
		// prevent object creation 
	}
	
	public static String  captureScreenshot(WebDriver driver, String screenshotName) {
		
		if(driver== null) {
			throw new IllegalArgumentException(" driver can't be null ");
		}
		
		String timeStamp =
				LocalDateTime.now().format(
						DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")
						);
		String fileName = 
				screenshotName + "_" + timeStamp + ".png";
		
		String screenshotDirectory  = "test-output/screenshort";
		
		Path directoryPath = Paths.get(screenshotDirectory);
		
		try {
			Files.createDirectories(directoryPath);
			
			File source = 
					((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			
			Path destination = directoryPath.resolve(fileName);
			Files.copy(source.toPath() , destination);
			
			return destination.toString();
			
		}catch (IOException e) {
			throw new RuntimeException(" Failed to capture screenshort ", e );
		}
				
	}
}
