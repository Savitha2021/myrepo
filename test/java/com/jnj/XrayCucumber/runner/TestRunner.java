package com.jnj.XrayCucumber.runner;

import applicationUtils.RMPrerequisiteUtils;

import com.jnj.XrayCucumber.libraries.TestConstants;
import com.jnj.XrayCucumber.libraries.CukeReporter;
import com.jnj.XrayCucumber.testcase.CommonSteps;
import com.jnj.XrayCucumber.testcase.RMPreRequisiteStepDefinitions;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestRunner {
	public static Properties properties = null;
	private static String sPath=System.getProperty("user.dir")+ File.separator +"XrayConfig.properties";
	public static Properties elementProperties=null;

	/**
	 * This performs the primary workflow of the Cucumber framework.
	 * - Downloads and unzips any features files that are specified
	 * - Queries the Jira server to ensure the features to be executed are 'Completed'.
	 * - Executes the Test Suite via the Cucumber CLI runner.
	 * - Uploads the results of the suite to the Jira server.
	 * @param args unusued String array of CLI arguments.
	 */
	public static void main(String[] args) {
		try{
			/*** EXECUTE AUTOMATION SCRIPTS  */
			execute();

			/*** PRINT PASSED, FAILED AND SKIPPED SCENARIO NAMES IN CONSOLE  */
			PrintScenariosExecutionStatus();

			if(CommonSteps._failedScenarios.size()<=0)
			{
				/*** UPLOAD AUTOMATION SCRIPTS RESULTS TO JIRA  */
			//	CukeReporter.startUpload();
			} 
		}catch (IOException e){
			System.out.println("[EXCEPTION]: Failed to run cucumber tests runner.  Stacktrace follows.");
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * Creates the String arguments for the Cucumber CLI runner, and executes said runner.
	 * @throws IOException
	 */
	private static void execute() throws IOException{
		// Build base args.
		StringBuilder args = new StringBuilder("--glue com.jnj.XrayCucumber -p html:target/cucumber-reports " +"-p json:target/cucumber.json "+
				"-p com.jnj.XrayCucumber.libraries.CukeReporter ");

		args.append("--tags ").append(TestConstants.CUCUMBER_TAGS).append(" ");
		args.append(TestConstants.USER_DIR).append(File.separator).append("Feature");

		// Transform into argv String[].
		String[] argv = args.toString().trim().split(" ");
		System.out.println(args);
		cucumber.api.cli.Main.run(argv, Thread.currentThread().getContextClassLoader());
	}

	/**
	 * Below method is used to read load config properties.
	 */
	public void loadConfigProperties(String sPath)
	{
		try
		{
			File file = new File(sPath);
			FileInputStream fileInput = new FileInputStream(file);
			properties = new Properties(); 
			properties.load(fileInput);
		}
		catch(Exception ex)
		{
			System.out.println("[EXCEPTION]: Failed to load config properties : " + ex);
		}
	}

	/**
	 * Below method is used to read Element config properties.
	 */
	public void loadElementConfigProperties()
	{
		File loginPage = new File("" + System.getProperty("user.dir")+ "\\ObjectRepository\\LoginPage.properties");
		File rmprerequisitePage = new File("" + System.getProperty("user.dir")+ "\\ObjectRepository\\RMPreRequisite.properties");
		File homePage = new File("" + System.getProperty("user.dir")+ "\\ObjectRepository\\HomePage.properties");
		File createNewFormulaPage = new File("" + System.getProperty("user.dir")+ "\\ObjectRepository\\CreateNewFormulaPage.properties");
		File pdCompositionPage = new File("" + System.getProperty("user.dir")+ "\\ObjectRepository\\PDCompositionPage.properties");
		File pdRequestApprovalPage = new File("" + System.getProperty("user.dir")+ "\\ObjectRepository\\PDRequestApprovalsPage.properties");
		File commonApproverModulepage = new File(""+System.getProperty("user.dir")+ "\\ObjectRepository\\CommonApprovalModule.properties");		
		File pDAttributesTab = new File("" + System.getProperty("user.dir")+ "\\ObjectRepository\\PDAttributesTab.properties");
		File pDPropertiesTab = new File("" + System.getProperty("user.dir")+ "\\ObjectRepository\\PDPropertiesTab.properties");
		File pDCommentsSection = new File("" + System.getProperty("user.dir")+ "\\ObjectRepository\\PDCommentsSection.properties");
		File testGoogle = new File("" + System.getProperty("user.dir")+ "\\ObjectRepository\\testGoogle.properties");
		
		try
		{
			FileInputStream loginPageFileInput = new FileInputStream(loginPage);
			FileInputStream rmprerequisitePageFileInput = new FileInputStream(rmprerequisitePage);
			FileInputStream homePageFileInput = new FileInputStream(homePage);
			FileInputStream createNewFormulaPageFileInput = new FileInputStream(createNewFormulaPage);
			FileInputStream pdCompositionPageFileInput = new FileInputStream(pdCompositionPage);
			FileInputStream pdRequestApprovalPageFileInput = new FileInputStream(pdRequestApprovalPage);
			FileInputStream commonApproverModulepageFileInput = new FileInputStream(commonApproverModulepage);
			FileInputStream pDAttributesTabFileInput = new FileInputStream(pDAttributesTab);
			FileInputStream pDPropertiesTabFileInput = new FileInputStream(pDPropertiesTab);
			FileInputStream pDCommentsSectionFileInput = new FileInputStream(pDCommentsSection);
			FileInputStream testGoogleFileInput = new FileInputStream(testGoogle);
			elementProperties = new Properties();
			elementProperties.load(loginPageFileInput);
			elementProperties.load(rmprerequisitePageFileInput);
			elementProperties.load(homePageFileInput);
			elementProperties.load(createNewFormulaPageFileInput);
			elementProperties.load(pdCompositionPageFileInput);
			elementProperties.load(pdRequestApprovalPageFileInput);
			elementProperties.load(commonApproverModulepageFileInput);
			elementProperties.load(pDAttributesTabFileInput);
			elementProperties.load(pDPropertiesTabFileInput);
			elementProperties.load(pDCommentsSectionFileInput);
			elementProperties.load(testGoogleFileInput);
		}
		catch(Exception ex)
		{
			System.out.println("Failed to load element config properties : " + ex);
		}
	}

	/**
	 * Helper method for Maven that allows the test suite to be run from the 'test' lifecycle.
	 */
	@Test
	public void jUnitTest(){
		loadConfigProperties(sPath);
		loadElementConfigProperties();
	main(null);
	}

	private static void PrintScenariosExecutionStatus()
	{	
		if(CommonSteps._passedScenarios.size()>0)
		{
			System.out.println("");
			System.out.println("************************************************************");
			System.out.println("************************* PASSED ***************************");
			for(int i=0;i<CommonSteps._passedScenarios.size();i++)
			{
				System.out.println((i+1)+". "+CommonSteps._passedScenarios.get(i).toString());
			}
			System.out.println("************************************************************");
		}

		if(CommonSteps._skippedScenarios.size()>0)
		{
			System.out.println("");
			System.out.println("************************************************************");
			System.out.println("************************* SKIPPED ***************************");
			for(int i=0;i<CommonSteps._skippedScenarios.size();i++)
			{
				System.out.println((i+1)+". "+CommonSteps._skippedScenarios.get(i).toString());
			}
			System.out.println("************************************************************");
		}

		if(CommonSteps._failedScenarios.size()>0)
		{
			System.out.println("");
			System.out.println("************************************************************");
			System.out.println("************************* FAILED ***************************");
			for(int i=0;i<CommonSteps._failedScenarios.size();i++)
			{
				System.out.println((i+1)+". "+CommonSteps._failedScenarios.get(i).toString());
			}
			System.out.println("************************************************************");
		}
	}
	
}