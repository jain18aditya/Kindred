package com.kindred.utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.kindred.base.WebDriverBase;

public class WebUIUtil {
	static WebDriverBase wd = new WebDriverBase();
	static Logger log = Logger.getLogger(WebUIUtil.class);
	static WebDriver driver = wd.getWebDriver();

	public static void captureScreenShot(String fileName) {
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			log.log(Level.INFO, ConfigUtil.getRootDir() + "/lib/screenshots/" + fileName + ".jpg");
			FileUtils.copyFile(scrFile, new File(ConfigUtil.getRootDir() + "/lib/screenshots/" + fileName + ".jpg"));
		} catch (IOException e) {
			log.log(Level.ERROR, "Failed to capture screenshot", e);
		}
	}
}
