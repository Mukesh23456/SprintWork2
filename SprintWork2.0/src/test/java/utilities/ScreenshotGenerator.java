package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenshotGenerator extends ReportGenerator{
	static int i = 1;

	public void takeScreenshot(WebDriver driver) throws IOException {
		File srcFile;
		srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile, new File("D:\\capgemini\\selenium\\selenium demo\\SprintWork2.0\\src\\test\\resources\\Screenshots\\img" + i + ".jpeg"));
		i++;
	}
}
