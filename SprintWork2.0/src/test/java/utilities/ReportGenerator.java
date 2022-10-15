package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportGenerator {
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static int i = 1;

	public void startReport() {
		extent = new ExtentReports("C:\\Users\\MUKESH\\git\\repository\\SprintWork2.0\\src\\test\\resources\\report\\report.html",
				true);
	}

	public void startTest() {
		logger = extent.startTest("test" + i);
		logger.log(LogStatus.PASS, "Test is pass");
		i++;
	}

	public void endTest() {
		extent.flush();
		extent.endTest(logger);
	}

	public void endReport() {
		extent.close();
	}

}
