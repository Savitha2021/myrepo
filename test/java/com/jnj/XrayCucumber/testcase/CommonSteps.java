package com.jnj.XrayCucumber.testcase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.AssumptionViolatedException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.jnj.XrayCucumber.libraries.CukeReporter;
import com.jnj.XrayCucumber.libraries.DriverNotConfiguredException;
import com.jnj.XrayCucumber.libraries.ReportScreenshots;
import com.jnj.XrayCucumber.libraries.SharedState;
import com.jnj.XrayCucumber.libraries.TestConstants;
import com.jnj.XrayCucumber.libraries.TestConstants.DRIVERS;
import com.jnj.XrayCucumber.libraries.XrayUpload;

import applicationUtils.CreateNewFormulaUtils;
import applicationUtils.PDCompositionUtils;
import applicationUtils.PDPropertiesUtils;
import applicationUtils.RMPrerequisiteUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

/**
 * CommonSteps contains test steps that are used for any Selenium test suite.
 */
public class CommonSteps {
	public SharedState sharedState;
	public ReportScreenshots reportScreenshots;
	public static Properties properties = null;
	// public static final DRIVERS DRIVER_USED = DRIVERS.PHANTOMJS;
	public static final DRIVERS DRIVER_USED = DRIVERS.CHROMEDRIVER;
	private static String OS = System.getProperty("os.name").toLowerCase();
	public static ArrayList<String> _passedScenarios=new ArrayList<String>();
	public static ArrayList<String> _skippedScenarios=new ArrayList<String>();
	public static ArrayList<String> _failedScenarios=new ArrayList<String>();

	/**
	 * CommonSteps constructor used by PicoContainer to inject the SharedState instance being used by the suite.
	 * @param sharedState SharedState instance being injected into the constructor by PicoContainer.
	 */
	public CommonSteps(SharedState sharedState){
		this.sharedState = sharedState;
		CukeReporter.setSharedState(sharedState);
	}

	/**
	 * initTestEnvironment() instantiates and configures the Driver used for the test suite.
	 * @throws DriverNotConfiguredException if given Driver enum value has not been configured for the suite below.
	 * @throws IOException 
	 */
	@Given("^Test environment is initialized$")
	public void initTestEnvironment() throws DriverNotConfiguredException, IOException {
		DesiredCapabilities capabilities;
		switch(DRIVER_USED){
		case PHANTOMJS:
			capabilities = DesiredCapabilities.phantomjs();
			capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					TestConstants.PHANTOMJS_PATH);
			sharedState.driver = new PhantomJSDriver(capabilities);
			XrayUpload.setCapabilitiesStr("Test Execution");
			sharedState.driver.manage().window().setSize(new Dimension(1920, 1080));
			sharedState.driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			break;
		case CHROMEDRIVER:
			capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
			if(OS.indexOf("win") >= 0)
			{
				System.setProperty("webdriver.chrome.driver",TestConstants.USER_DIR+"//src//main//resources//chromedriver.exe" );
			}
			else if(OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 )
			{
				System.setProperty("webdriver.chrome.driver",TestConstants.USER_DIR+"//src//main//resources//chromedriver" );
			}

//			sharedState.driver = new ChromeDriver(capabilities);
//			sharedState.driver.manage().window().maximize();
//			sharedState.driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
//			sharedState.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			
			
			//
			
			
			ChromeOptions options = new ChromeOptions();
	        options.setExperimentalOption("useAutomationExtension", false);
	        options.addArguments(Arrays.asList("--start-maximized"));
	        options.setBinary("C://Program Files (x86)//Google//Chrome//Application//chrome.exe");
	        
	        
	       // options.addArguments("--window-size=1920, 1080");
	        options.addArguments("--window-size=1920,2160");
	        options.addArguments("--disable-gpu");
	        options.addArguments("--disable-extensions");
	        options.setExperimentalOption("useAutomationExtension", false);
	        options.addArguments("--proxy-server='direct://'");
	        options.addArguments("--proxy-bypass-list=*");
	        
	     //   options.addArguments("--headless");
	     //   sharedState.driver = new ChromeDriver(options);

	        
	        

	        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
	        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
	        desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

	        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, TestConstants.USER_DIR + "/target/chromedriver.log");
	        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, TestConstants.USER_DIR+"//src//main//resources//chromedriver.exe");
	        ChromeDriverService service = new ChromeDriverService.Builder()
	            .usingAnyFreePort()
	            .withVerbose(true)
	            .build();
	        service.start();
	        sharedState.driver = new RemoteWebDriver(service.getUrl(),desiredCapabilities);
	        sharedState.driver.manage().window().maximize();
			sharedState.driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			sharedState.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			//XrayUpload.setCapabilitiesStr("Test Execution");
	        
			
			
			
			
			
			//
			
			
			
			XrayUpload.setCapabilitiesStr("Test Execution");
			break;
		default:
			System.out.println("The given driver has not been configured for the framework." +
					"  Place a conditional clause in CommonSteps.initTestEnvironment() to handle the driver used.");
			throw new DriverNotConfiguredException();
		}
	}

	/**
	 * testIsCompleted() ensures every scenario run is marked as 'Completed' in Jira, and skips its execution if it is
	 * not so.
	 */
	@Before
	public void testIsCompleted(Scenario scenario){
		System.out.println("[INFO-Scenario Name]: "+scenario.getName());
		// COMMENTING THE BELOW CODE UNTIL THE TESTS MOVE TO COMPLETED STATUS
		/*Collection<String> tags = new ArrayList<String>();
		try {
			for (String tag : scenario.getSourceTagNames()) {
				if(tag.contains(TestConstants.XRAY_PROJECT_KEY))
					tags.add(tag);
			}
			XrayUpload.queryCompleteTests(tags.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (!XrayUpload.getCompletedTests().contains(CukeReporter.getReportString())) {
			if (sharedState.driver != null && sharedState.driver.getSessionId() != null) {
				sharedState.driver.close();
				sharedState.driver.quit();
			}
			_skippedScenarios.add(scenario.getName());
			throw new AssumptionViolatedException("Test '" + CukeReporter.getReportString() + "' is not marked as"
					+ " 'Completed' in Jira.  Its execution has been skipped.");
		} 
*/
		reportScreenshots = new ReportScreenshots(scenario);
	}

	/**
	 * shutdownDriver() kills the current Driver instance if not done so by prior steps.
	 */
	@After
	public void shutdownDriver(Scenario scenario){
		if (scenario.isFailed()) {
			ReportScreenshots.getScreenshot(sharedState);
			_failedScenarios.add(scenario.getName());
		}

		if(scenario.getStatus().equals("passed"))
		{
			_passedScenarios.add(scenario.getName());
		}

		if(scenario.getStatus().equals("skipped"))
		{
			_skippedScenarios.add(scenario.getName());
		}

		System.out.println("[INFO-Scenario Status]: "+scenario.getStatus().toUpperCase());
		if(sharedState.driver != null && sharedState.driver.getSessionId() != null) {
			sharedState.driver.close();
			sharedState.driver.quit();
			RMPreRequisiteStepDefinitions.RMID=null;
			CreateNewFormulaUtils.RMID=null;
			PDCompositionUtils.RMID=null;
			PDPropertiesUtils.RMID=null;
			RMPrerequisiteUtils.RMID=null;
			RMPreRequisiteStepDefinitions.RMid=new ArrayList<String>();
			
			
			
			
		}
	}
}