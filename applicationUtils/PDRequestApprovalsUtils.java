package applicationUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.NotSupportedException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PDRequestApprovalsUtils {

	// CONSTANTS
	static final String CHECKED = "Checked";
	static final String UNCHECKED = "Unchecked";
	static final String SELECT = "Select";
	static final String UNSELECT = "Unselect";
	static final String HUT = "HUT";
	static final String SHOWCOMPLETEDFIELDS = "Show Completed Fields";
	static final String NOTAPPLICABLE = "Not Applicable";
	static final String PFSPECNO = "PF Spec No.*";
	static final String PRSPECNO = "PR Spec No.*";
	static final String PRODUCTNAME = "Product Name (Proposed)*";
	static final String ASSOCIATETOCHASSIS = "Associate to Chassis";
	static final String RMCEXCEPTIONREASON = "RMC Exception Reason*";
	static final String PH = "pH*";
	static final String SPECIFICGRAVITY = "Specific Gravity*";
	static final String APPEARANCE = "Appearance*";
	static final String DEVELOPMENTSITE = "Development Site";
	static final String MANUFACTURINGLOCATION = "Manufacturing Location";
	static final String LEGALPRODUCTCATEGORY = "Legal Product Category*";
	static final String PRODUCTFUNCTION = "Product Function*";
	static final String DELIVERYSYSTEM = "Delivery System*";
	static final String ENDUSE = "End Use*";
	static final String ENDUSER = "End User*";
	static final String USECONDITION = "Use Condition*";
	static final String PRODUCTTYPE = "Product Type*";
	static final String REGION = "Region*";
	static final String REVIEWREQUESTEDBY = "Review Requested by*";
	static final String ADDITIONALINFORMATION = "Additional Information";
	static final String RMCADMIN = "RMC Admin*";
	static final String TOXICOLOGYCLINICALSAFETYFULLHUT = "Toxicology/Clinical Safety Full/HUT*";
	static final String TOXICOLOGYCLINICALSAFETYFULL = "Toxicology/Clinical Safety Full*";
	static final String TOXICOLOGYCLINICALSAFETYPRELIMINARY = "Toxicology/Clinical Safety Preliminary*";
	static final String TOXICOLOGYCLINICALSAFETYPRELIMINARYHUT = "Toxicology/Clinical Safety Preliminary/HUT*";
	static final String TOXICOLOGYFULL = "Toxicology Full*";
	static final String CLINICALRISKASSESSMENTFULL = "Clinical Risk Assessment Full*";
	static final String RDPRELIMINARY = "R&D Preliminary*";
	static final String RDFULL = "R&D Full*";
	static final String EMEAREGULATORYPRELIMINARY = "EMEA Regulatory Preliminary *";
	static final String APACREGULATORYPRELIMINARY = "APAC Regulatory Preliminary *";
	static final String NAREGULATORYPRELIMINARY = "NA Regulatory Preliminary *";
	static final String LATAMREGULATORYPRELIMINARY = "LATAM Regulatory Preliminary *";
	static final String EMEAREGULATORYPRELIMINARYHUT = "EMEA Regulatory Preliminary/HUT *";
	static final String APACREGULATORYPRELIMINARYHUT = "APAC Regulatory Preliminary/HUT *";
	static final String NAREGULATORYPRELIMINARYHUT = "NA Regulatory Preliminary/HUT *";
	static final String LATAMREGULATORYPRELIMINARYHUT = "LATAM Regulatory Preliminary/HUT *";
	static final String EMEAREGULATORYFULLHUT = "EMEA Regulatory Full/HUT *";
	static final String APACREGULATORYFULLHUT = "APAC Regulatory Full/HUT *";
	static final String NAREGULATORYFULLHUT = "NA Regulatory Full/HUT *";
	static final String LATAMREGULATORYFULLHUT = "LATAM Regulatory Full/HUT *";
	static final String EMEAREGULATORYFULL = "EMEA Regulatory Full *";
	static final String APACREGULATORYFULL = "APAC Regulatory Full *";
	static final String NAREGULATORYFULL = "NA Regulatory Full *";
	static final String LATAMREGULATORYFULL = "LATAM Regulatory Full *";
	static final String LEGAL = "Legal*";
	static final String ENVIRONMENTALASSESSMENT = "Environmental Assessment*";
	static final String COMMENNTRATIONALE = "Comment/Rationale";
	static final String HUTDESCRITION = "HUT Description*";
	static final String HUTREGION = "HUT Region*";
	static final String LEGALPRODUCTCATEGORYINHUTREGION = "Legal Product Category in HUT Region*";
	static final String HUTCLAIMSUPPORT = "Unsupervised HUT for Claim Support (excluding patch tests)?*";
	static final String REGULATORY = "Regulatory";
	static final String TOXICOLOGYCLINICALSAFETY = "Toxicology/Clinical Safety";
	static final String ASSOCIATED = "Associate to Chassis";
	static final String RMCFORMULAEXCEPTION = "RMC Formula Exception";
	static final String TOXICOLOGY = "Toxicology/Clinical Safety Preliminary";
	static final String EMEA = "EMEA Regulatory Preliminary";
	static final String EMEAPRELIMINARYHUT = "EMEA Regulatory Preliminary/HUT";
	static final String EMEAREGFULL = "EMEA Regulatory Full";
	static final String APAC = "APAC Regulatory Preliminary";
	static final String APREGULATORYFULL = "APAC Regulatory Full";
	static final String RANDD = "R&D Preliminary";
	static final String LATAMREGULATORYHUTPRILIMINARY="LATAM Regulatory Preliminary/HUT";
	static final String TOXICOLOGYFULLHUT="Toxicology/Clinical Safety Full/HUT";
	static final String TOXICOLOGYCLINICALSAFTYFULL="Toxicology/Clinical Safety Full";
	static final String TOXICOLOGYPRELIMINARYHUT="Toxicology/Clinical Safety Preliminary/HUT";
	static final String NAPRILIMINARY="NA Regulatory Preliminary";
	static final String NAHUTPRILIMINARY="NA Regulatory Preliminary/HUT";
	static final String LATAMPRILIMINARY="LATAM Regulatory Preliminary";
	static final String APACHUT="APAC Regulatory Preliminary/HUT";
	static final String TABNAME= "Request Approvals";
	static final String HUTSUBSECTION="HUT";
	static final String RANDDFULL = "R&D Full";
	static final String APACREGFULLHUT = "APAC Regulatory Full/HUT";
	static final String NAREGFULLHUT = "NA Regulatory Full/HUT";
	static final String NAREGFULL = "NA Regulatory Full";
	static final String LATAMREGFULL = "LATAM Regulatory Full";
	static final String LEGALAF = "Legal";
	static final String ENVIRONMENTASSESSMENT = "Environmental Assessment";
	static final String DATETOBESELECTED="Current Date";
	static final String NONE="None";
	static final String LAUNCHWORKFLOW="Launch Workflow";
	static final String SAVEBUTTON="Save";
	static final String APPROVALFORLAUNCH="Approval for Launch";
	static final String APPROVALFORSCALEUP="Approval for Scale Up";
	static final String APPROVEDFORSCALEUP="Approved for Scale Up";
	static final String RMCSTATUS= "Exception Required";
	static final String COMPOSITION="Composition";
	static final String ATTRIBUTE="Attributes";
	static final String PROPERTIES="Properties";
	static final String COMPLETEDAPPROVALS="Completed Approvals";
	static final String CHEMICALCOMPOSITION="Chemical Composition";
	static final String INPROGRESS="In Progress";
	public String rmcstatus= "Exception Required";
	public static String approvalrequesttype=null;
	static final String REQUESTREVISION="Request Revision";
	static final String RESOLVEREVISION="Resolve Revision";

	// VARIABLES
	private Properties properties;
	WebDriver driver;
	static WebDriverWait wait;
	private ApplicationUtils applicationUtils;
	private RMPrerequisiteUtils rmprerequisiteUtils;
	public static String radioButton="";
	public static String hUTapprover="";
	CreateNewFormulaUtils createNewFormulaUtils;


	// CONSTRUCTOR
	public PDRequestApprovalsUtils(WebDriver driver, Properties elementProperties) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
		properties = elementProperties;
		applicationUtils = new ApplicationUtils(driver);
		rmprerequisiteUtils = new RMPrerequisiteUtils(driver, elementProperties);
		createNewFormulaUtils = new CreateNewFormulaUtils(driver, elementProperties);
	}

	// METHODS
public boolean formulastatudataverification(String tab)
		{
			if(tab.equals(TABNAME))
			{
				if(approvalrequesttype==null)
				{
				return applicationUtils.isElementDisplayed(properties.getProperty("ExperimentalFormulaStatus"))&& applicationUtils.isElementDisplayed(properties.getProperty("ApprovedforScaleUpFormulaStatus"))
						&&applicationUtils.isElementDisplayed(properties.getProperty("ApprovedforLaunchFormulaStatus"))&& applicationUtils.isElementDisplayed(properties.getProperty("CommercialFormulaStatus"))
						&&applicationUtils.isElementDisplayed(properties.getProperty("ObsoleteFormulaStatus"));
				}
				else
				{
					System.out.println(applicationUtils.isElementDisplayed(properties.getProperty("ExperimentalFormulaStatusNonActive"))+""+ applicationUtils.isElementDisplayed(properties.getProperty("ApprovedforScaleUpFormulaStatusActive"))
							+""+applicationUtils.isElementDisplayed(properties.getProperty("ApprovedforLaunchFormulaStatus"))+""+ applicationUtils.isElementDisplayed(properties.getProperty("CommercialFormulaStatus"))
							+""+applicationUtils.isElementDisplayed(properties.getProperty("ObsoleteFormulaStatus")));
					return applicationUtils.isElementDisplayed(properties.getProperty("ExperimentalFormulaStatusNonActive"))&& applicationUtils.isElementDisplayed(properties.getProperty("ApprovedforScaleUpFormulaStatusActive"))
							&&applicationUtils.isElementDisplayed(properties.getProperty("ApprovedforLaunchFormulaStatus"))&& applicationUtils.isElementDisplayed(properties.getProperty("CommercialFormulaStatus"))
							&&applicationUtils.isElementDisplayed(properties.getProperty("ObsoleteFormulaStatus"));
				}
			}

			return false;
		}

	public boolean subsectionverification(String tab)
	{
		if(tab.equals(TABNAME))
		{			
			return applicationUtils.isElementDisplayed(properties.getProperty("DataRequiredSubsectionLabel"))
					&& applicationUtils.isElementDisplayed(properties.getProperty("InputsSubsectionLabel"))
					&&applicationUtils.isElementDisplayed(properties.getProperty("HUTSubsectionLabel"))
					&& applicationUtils.isElementDisplayed(properties.getProperty("RequiredApproversSubsectionLabel"));
		}

		return false;
	}

	public boolean verifyHUTDataRequiredfields(String tab)
	{
		if(tab.equals(TABNAME))
		{
			return applicationUtils.isElementDisplayed(properties.getProperty("ProductNameTextBox"))
					&& applicationUtils.isElementDisplayed(properties.getProperty("DevelopmentSiteDropDown"))
					&&applicationUtils.isElementDisplayed(properties.getProperty("ManufacturingLocationDropDown"))
					&& applicationUtils.isElementDisplayed(properties.getProperty("LegalProductCategoryDropDown"))
					&&applicationUtils.isElementDisplayed(properties.getProperty("ProductFunctionDropDown"))
					&& applicationUtils.isElementDisplayed(properties.getProperty("DeliverySystemDropDown"))
					&&applicationUtils.isElementDisplayed(properties.getProperty("EndUseDropDown"))
					&& applicationUtils.isElementDisplayed(properties.getProperty("EndUserDropDown"))
					&&applicationUtils.isElementDisplayed(properties.getProperty("UseConditionDropDown"))
					&& applicationUtils.isElementDisplayed(properties.getProperty("ProductTypeDropDown"));
		}

		return false;
	}

	public boolean verifyHUTInputfields(String tab)
	{
		if(tab.equals(TABNAME))
		{
			return applicationUtils.isElementDisplayed(properties.getProperty("RequestedByTextBox"));
		}

		return false;
	}

	public boolean verifyHUTmandatoryfields(String tab)
	{
		if(tab.equals(TABNAME))
		{
			return applicationUtils.isElementDisplayed(properties.getProperty("HUTDescriptionTextBox"))&&
					applicationUtils.isElementDisplayed(properties.getProperty("ConsultSOPLabel"))&&
					applicationUtils.isElementDisplayed(properties.getProperty("HUTRegionDropDown"))&&
					applicationUtils.isElementDisplayed(properties.getProperty("LegalProductDropDown"))&&
					applicationUtils.isElementDisplayed(properties.getProperty("AddAdditionalHUTIcon"));
		}

		return false;
	}

	public boolean verifyHUTInputNonmandatoryfields(String tab)
	{
		if(tab.equals(TABNAME))
		{
			return applicationUtils.isElementDisplayed(properties.getProperty("AdditionalInformationTextBox"));
		}

		return false;
	}

	public void enterdatarequiredsubsection(String approvaltype)
	{
		if(approvaltype.equals(HUT))
		{
			if(RMPrerequisiteUtils.RMCStatus.equals(rmcstatus))
			{
				enterRMCExceptionReason(approvaltype);
			}
			applicationUtils.enterText(properties.getProperty("PRSpecNo"), properties.getProperty("PRSpecNoValue"));
			applicationUtils.enterText(properties.getProperty("ProductNameTextBox"), properties.getProperty("ProductNameValue"));
			applicationUtils.moveToElementClick(properties.getProperty("DevelopmentSiteDropDown"));
			applicationUtils.enterText(properties.getProperty("DevelopmentSiteDropDown"), properties.getProperty("DevelopmentSiteValue"));
			applicationUtils.moveToElementClick(properties.getProperty("SelectActiveDropDownValue"));
			applicationUtils.moveToElementClick(properties.getProperty("ManufacturingLocationDropDown"));
			applicationUtils.enterText(properties.getProperty("ManufacturingLocationDropDown"), properties.getProperty("ManufacturingLocationValue"));
			applicationUtils.moveToElementClick(properties.getProperty("SelectActiveDropDownValue"));
			applicationUtils.selectbyVisibletext(properties.getProperty("LegalProductCategoryDropDown"), properties.getProperty("LegalProductCategoryValue"));
			applicationUtils.moveToElementClick(properties.getProperty("ProductFunctionDropDown"));
			applicationUtils.enterText(properties.getProperty("ProductFunctionDropDown"), properties.getProperty("ProductFunctionValue"));
			applicationUtils.moveToElementClick(properties.getProperty("SelectActiveDropDownValue"));
			applicationUtils.moveToElementClick(properties.getProperty("DeliverySystemDropDown"));
			applicationUtils.enterText(properties.getProperty("DeliverySystemDropDown"), properties.getProperty("DeliverySystemValue"));
			applicationUtils.moveToElementClick(properties.getProperty("SelectActiveDropDownValue"));
			applicationUtils.moveToElementClick(properties.getProperty("EndUseDropDown"));
			applicationUtils.enterText(properties.getProperty("EndUseDropDown"), properties.getProperty("EndUseValue"));
			applicationUtils.moveToElementClick(properties.getProperty("SelectActiveDropDownValue"));
			applicationUtils.moveToElementClick(properties.getProperty("EndUserDropDown"));
			applicationUtils.enterText(properties.getProperty("EndUserDropDown"), properties.getProperty("EndUserValue"));
			applicationUtils.moveToElementClick(properties.getProperty("SelectActiveDropDownValue"));
			applicationUtils.selectbyVisibletext(properties.getProperty("UseConditionDropDown"), properties.getProperty("UseConditionValue"));
			applicationUtils.selectbyVisibletext(properties.getProperty("ProductTypeDropDown"), properties.getProperty("ProductTypeValue"));
		}
		else
		{
			throw new NotSupportedException(approvaltype + "is not available");
		}
	}

	public void enterinputssubsection(String approvaltype) throws ParseException
	{
		if(approvaltype.equals(HUT))
		{
			rmprerequisiteUtils.selectDateRMWorkFlow(properties.getProperty("RequestedByInput_CalenderButton"), DATETOBESELECTED);
		}
		else
		{
			throw new NotSupportedException(approvaltype + "is not available");
		}
	}

	public void enterHUTsubsection()
	{
		applicationUtils.enterText(properties.getProperty("HUTDescriptionTextBox"), properties.getProperty("HUTDescriptionValue"));
		applicationUtils.selectbyVisibletext(properties.getProperty("HUTRegionDropDown"), properties.getProperty("HUTAPACRegionValue"));
		applicationUtils.selectbyVisibletext(properties.getProperty("LegalProductDropDown"), properties.getProperty("LegalProductValue"));
	}

	public void clickbuttonRequestApprovalstab(String button)
	{
		switch(button)
		{
		case LAUNCHWORKFLOW:
		case SAVEBUTTON:
			applicationUtils.moveToElementClick(String.format(properties.getProperty("RequestApprovalsButton"), button));
			applicationUtils.waitForLoadingImageDisappear();
			break;
		default:
			throw new NotSupportedException(button + "is not available");
		}
	}

	public void selectHUTUnsupervisedradiobutton(String radiobutton,String field,String subsection) throws InterruptedException
	{
		if(subsection.equals(HUTSUBSECTION))
		{
			Thread.sleep(2000);
			applicationUtils.moveToElementClick(String.format(properties.getProperty("UnsupervisedRadioButton"), field,radiobutton.toLowerCase()));
			Thread.sleep(2000);
		}
	}

	public void selectHUTRequiredApprovers(String subsection)
	{
		if(subsection.equals(HUTSUBSECTION))
		{
			if(PDRequestApprovalsUtils.radioButton.equals(NONE)&& PDRequestApprovalsUtils.hUTapprover.equals(TOXICOLOGYCLINICALSAFETY))
			{
				applicationUtils.selectbyVisibletext(properties.getProperty("RegulatoryPreliminaryDropDown"),properties.getProperty("APACRegulatoryValue"));
			}
			else
			{
				applicationUtils.selectbyVisibletext(properties.getProperty("ToxicologyDropDown"),properties.getProperty("ToxicologyValue"));
				applicationUtils.selectbyVisibletext(properties.getProperty("RegulatoryPreliminaryDropDown"),properties.getProperty("APACRegulatoryValue"));
			}
		}
		else
		{
			System.out.println(subsection + "is not available");
		}
	}

	public void enterRMCExceptionReason(String subsection)
	{
		if(subsection.equals(HUTSUBSECTION))
		{
			applicationUtils.enterText(properties.getProperty("RMCExceptionReason"),properties.getProperty("RMCExceptionValue"));
			applicationUtils.enterText(properties.getProperty("RMCAdminDropDown"),properties.getProperty("RMCAdminValue"));
		}
		else
		{
			System.out.println(subsection + "is not available");
		}
	}

	public boolean verifyRMCExeceptionadded()
	{
		applicationUtils.waitForLoadingImageDisappear();
		return applicationUtils.isElementDisplayed(String.format(properties.getProperty("RMCExceptionData"), RMPrerequisiteUtils.RMID))
				&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("RMCExceptionData"), RMPrerequisiteUtils.tradename))
				&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("RMCExceptionData"), RMPrerequisiteUtils.RMCStatus));
	}

	public boolean verifyInProgresstabRMCExceptiondata()
	{
		if(PDRequestApprovalsUtils.radioButton.equals(NONE)&& PDRequestApprovalsUtils.hUTapprover.equals(REGULATORY))
		{
			return applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"), properties.getProperty("Status")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"), properties.getProperty("PreliminatoryType")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"), properties.getProperty("ToxicologyApproverFunction")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"),properties.getProperty("InToxicologyValue")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"),applicationUtils.getCurrentDate("dd-MMM-yyyy")));
		}
		else if(PDRequestApprovalsUtils.radioButton.equals(NONE)&& PDRequestApprovalsUtils.hUTapprover.equals(TOXICOLOGYCLINICALSAFETY))
		{
			return applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"), properties.getProperty("Status")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"), properties.getProperty("PreliminatoryType")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"), properties.getProperty("ToxicologyApproverFunction")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"),properties.getProperty("InToxicologyValue")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"),applicationUtils.getCurrentDate("dd-MMM-yyyy")));
		}
		else
		{	
			return applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"), properties.getProperty("Status")))			
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"), properties.getProperty("TypeofReview")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"), properties.getProperty("ApproverFunction")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"),properties.getProperty("InRMCAdminValue")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"),applicationUtils.getCurrentDate("dd-MMM-yyyy")))
				    && applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressDataNext"),applicationUtils.getCurrentDate("dd-MMM-yyyy")));
		}
	}

	public boolean verifyInProgresstabApproverExceptiondata(String approvaltype)
	{
		if(approvaltype.equals(TOXICOLOGYFULLHUT))
		{
			return applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"),properties.getProperty("Status"))) 
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"),properties.getProperty("FullHUTType")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"),properties.getProperty("ToxicologyFullApproverFunction")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"),properties.getProperty("InToxicologyValue")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"),applicationUtils.getCurrentDate("dd-MMM-yyyy")))
			&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressDataNext"),applicationUtils.getCurrentDate("dd-MMM-yyyy")));
		}

		else if(approvaltype.equals(APACHUT))
		{
			return applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"),properties.getProperty("Status"))) 
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"),properties.getProperty("PreliminatoryType")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"),properties.getProperty("RegulatoryPrilimanaryAPACApproverFunction")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"),properties.getProperty("InAPACRegulatoryValue")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"),applicationUtils.getCurrentDate("dd-MMM-yyyy")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressDataFourth"),applicationUtils.getCurrentDate("dd-MMM-yyyy")));
		}
		
		else
		{
			return applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"),properties.getProperty("Status"))) 
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"),properties.getProperty("PreliminatoryType")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"),properties.getProperty("ToxicologyApproverFunction")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"),properties.getProperty("InToxicologyValue")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressData"),applicationUtils.getCurrentDate("dd-MMM-yyyy")))&& 
					applicationUtils.isElementDisplayed(String.format(properties.getProperty("InProgressDataNext"),applicationUtils.getCurrentDate("dd-MMM-yyyy")));
		}

	}

	public boolean verifyCompletedReviewtabApproverExceptiondata(String approvaltype)
	{
		if(approvaltype.equals(TOXICOLOGYFULLHUT))
		{
			if(applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ApprovedStatus"))) 
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ToxicologyFullApproverFunction")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ToxicologyValue")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("RegionGlobal")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),applicationUtils.getCurrentDate("dd-MMM-yyyy")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsFourth"),applicationUtils.getCurrentDate("dd-MMM-yyyy"))))
			
			{
				return true;
			}
			else if(applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ApprovedStatus"))) &&
					applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ToxicologyFullApproverFunction")))&&
					applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ExternalApprovalAcquired")))&&
					applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("RegionGlobal")))&&
					applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),applicationUtils.getCurrentDate("dd-MMM-yyyy"))))
			{
				return true;
			}
		}
		else if(approvaltype.equals(TOXICOLOGYCLINICALSAFTYFULL))
		{
			if(applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ApprovedStatus"))) &&
					applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),approvaltype))&&
					applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("HistoricalApprovalGranted")))&&
					applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("RegionGlobal")))&&
					applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),applicationUtils.getCurrentDate("dd-MMM-yyyy"))))
			{
				return true;
			}
		}
		
		else if(approvaltype.equals(TOXICOLOGYPRELIMINARYHUT))
		{
			return(applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ApprovedStatus"))) 
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ToxicologyApproverFunction")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ToxicologyValue")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("RegionGlobal")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),applicationUtils.getCurrentDate("dd-MMM-yyyy")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsFourth"),applicationUtils.getCurrentDate("dd-MMM-yyyy"))));
		}
		else if(approvaltype.equals(APACHUT))
		{
			return(applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ApprovedStatus")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("RegulatoryPrilimanaryAPACApproverFunction")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("APACRegulatoryValue")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("RegionAPAC")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),applicationUtils.getCurrentDate("dd-MMM-yyyy")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsNext"),applicationUtils.getCurrentDate("dd-MMM-yyyy"))));
		}
		else if(approvaltype.equals(APACREGULATORYPRELIMINARYHUT))
		{
			if(applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ApprovedStatus")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("RegulatoryPrilimanaryAPACApproverFunction")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("InAPACRegulatoryValue")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("RegionAPAC")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),applicationUtils.getCurrentDate("dd-MMM-yyyy"))))
			{
				return true;
			}
		}	
		else if(approvaltype.equals(APREGULATORYFULL))
		{
			if(applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ApprovedStatus"))) &&
					applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),approvaltype))&&
					applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ExternalApprovalAcquired")))&&
					applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("RegionAPAC")))&&
					applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),applicationUtils.getCurrentDate("dd-MMM-yyyy"))))
			{
				return true;
			}
		}
		else if(approvaltype.equals(APACREGULATORYFULLHUT))
		{
			if(applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ApprovedStatus")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),approvaltype))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("APACRegulatoryValue")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("RegionAPAC")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),applicationUtils.getCurrentDate("dd-MMM-yyyy"))))
			{
				return true;
			}
		}
		else if(approvaltype.equals(LATAMREGULATORYHUTPRILIMINARY))
		{
			if(applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ApprovedStatus"))) &&
					applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),approvaltype))&&
					applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ExternalApprovalAcquired")))&&
					applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("RegionLATAM")))&&
					applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),applicationUtils.getCurrentDate("dd-MMM-yyyy"))))
			{
				return true;
			}
		}
		else if(approvaltype.equals(EMEAREGULATORYPRELIMINARYHUT))
		{
			if(applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ApprovedStatus")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),approvaltype))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("EMEARegulatoryValue")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("RegionEMEA")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),applicationUtils.getCurrentDate("dd-MMM-yyyy"))))
			{
				return true;
			}
		}
		else if(approvaltype.equals(RDFULL))
		{
			if(applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ApprovedStatus")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),approvaltype))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("EMEARegulatoryValue")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("RDReviewType")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),applicationUtils.getCurrentDate("dd-MMM-yyyy"))))
			{
				return true;
			}
		}
		else if(approvaltype.equals(LEGAL))
		{
			if(applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ApprovedStatus")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),approvaltype))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("LegalValue")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),applicationUtils.getCurrentDate("dd-MMM-yyyy"))))
			{
				return true;
			}
		}
		else if(approvaltype.equals(ENVIRONMENTALASSESSMENT))
		{
			if(applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ApprovedStatus")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),approvaltype))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("EnvironmentalAssessmentValue")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),applicationUtils.getCurrentDate("dd-MMM-yyyy"))))
			{
				return true;
			}
		}		
		else if(approvaltype.equals(RMCFORMULAEXCEPTION))
		{
			if(applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("ApprovedStatus")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("TypeofReview")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("RMCAdminValue")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),properties.getProperty("RegionGlobal")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsData"),applicationUtils.getCurrentDate("dd-MMM-yyyy")))
					&& applicationUtils.isElementDisplayed(String.format(properties.getProperty("CompletedReviewsSixth"),applicationUtils.getCurrentDate("dd-MMM-yyyy"))))
			{
				return true;
			}
		}

		return false;
	}

	public boolean verifyUserOnRequestApprovalTab() 
	{
		return applicationUtils.isElementPresent(properties.getProperty("RequestApprovalTab"));
	}

	public boolean verifyStatusonLeftpane(String status) 
	{
		return applicationUtils.isElementPresent(String.format(properties.getProperty("LeftPaneStatus"), status));
	}

	public boolean verifyChevronStatusonLeftpane(String chevronStatus) 
	{
		return applicationUtils.isElementPresent(String.format(properties.getProperty("ChevronStatus"), chevronStatus));
	}

	public void selectValueforRequestTypefield(String value)
	{
		applicationUtils.selectbyVisibletext(properties.getProperty("ApprovalRequestType"), value);
	}

	public boolean verifyMandatorySubsection(String sectionName)
	{
		if (sectionName.equals("Required Approvers"))
		{
			applicationUtils.scrollToElement(properties.getProperty("CommentRationaleTextBoxScreenshot"));
			return applicationUtils.isElementPresent(properties.getProperty("RequiredApproverslink"));
		}
		else if(sectionName.equals("HUT"))
		{
			applicationUtils.scrollToElement(String.format(properties.getProperty("SpanWithSelect"), LEGALPRODUCTCATEGORYINHUTREGION));
			return applicationUtils.isElementPresent(String.format(properties.getProperty("SpanContainsText"), sectionName));
		}
		else
		{
			applicationUtils.scrollToElement(String.format(properties.getProperty("SpanContainsText"), sectionName));
			return applicationUtils.isElementPresent(String.format(properties.getProperty("SpanContainsText"), sectionName));
		}
	}

	public boolean verifyLinkOnRequestApproval(String linkName) 
	{
		applicationUtils.scrollToElement(String.format(properties.getProperty("SpanContainsLinkText"), linkName));
		return applicationUtils.isElementPresent(String.format(properties.getProperty("SpanContainsLinkText"), linkName));
	}

	public void clickLinkOnRequestApproval(String linkName)
	{
		applicationUtils.clickOnElement(String.format(properties.getProperty("SpanContainsLinkText"), linkName));
		applicationUtils.idleTime(3000);
	}

	public boolean verifyCheckBoxStatusOnRequestApprovalsTab(String field, String status)
	{
		boolean flag = false;
		boolean actStatus = applicationUtils.isElementSelected(String.format(properties.getProperty("SpanWithTextCheckbox"), field));
		applicationUtils.scrollToElement(String.format(properties.getProperty("SpanWithTextCheckbox"), field));
		applicationUtils.idleTime(3000);
		switch (status)
		{
		case UNCHECKED:
			if (!actStatus) 
			{
				flag = true;
			}
			break;
		case CHECKED:
			if (actStatus) {
				flag = true;
			}
			break;
		default:
			throw new NotSupportedException(status+" is not available");
		}

		return flag;
		
	}

	public void takeActionOnCheckBoxOnRequestApprovalstab(String field, String action)
	{
		if (action.equalsIgnoreCase("Selects"))
			action = "Select";
		else if (action.equalsIgnoreCase("Unselects"))
			action = "Unselect";

		switch (action)
		{
		case SELECT:
			if (field.equals("Not Applicable"))
			{
				applicationUtils.scrollToElement(properties.getProperty("NotApplicableCheckbox"));
				applicationUtils.selectCheckBox(properties.getProperty("NotApplicableCheckbox"));
			}
			else
			{
				applicationUtils.scrollToElement(String.format(properties.getProperty("SpanWithTextCheckbox"), field));
				applicationUtils.selectCheckBox(String.format(properties.getProperty("SpanWithTextCheckbox"), field));
			}
			break;
		case UNSELECT:
			if (field.equals("Not Applicable"))
			{
				applicationUtils.scrollToElement(properties.getProperty("NotApplicableCheckbox"));
				applicationUtils.unSelectCheckBox(properties.getProperty("NotApplicableCheckbox"));
			}
			else
			{
				applicationUtils.unSelectCheckBox(String.format(properties.getProperty("SpanWithTextCheckbox"), field));
			}
			break;
		default:
			throw new NotSupportedException(action+" is not available");
		}
	}

	public boolean verifyFieldDataRequiredSectionOnRequestApprovalsTab(String field)
	{
		if (field.equals(PFSPECNO) || field.equals(PRSPECNO) || field.equals(ASSOCIATETOCHASSIS) || field.equals(PH)
				|| field.equals(SPECIFICGRAVITY) || field.equals(APPEARANCE)) 
		{
			applicationUtils.scrollToElement(String.format(properties.getProperty("SpanContainsTextWithInput"), field));
			return applicationUtils.isElementPresent(String.format(properties.getProperty("SpanContainsTextWithInput"), field));
		}
		else if (field.equals(DEVELOPMENTSITE) || field.equals(MANUFACTURINGLOCATION))
		{
			applicationUtils.scrollToElement(String.format(properties.getProperty("RequestApprovalsButton"),ASSOCIATED));
			//applicationUtils.scrollToElement(String.format(properties.getProperty("SpanWithSelect"), DELIVERYSYSTEM));
			applicationUtils.idleTime(2000);
			return applicationUtils.isElementPresent(String.format(properties.getProperty("SpanWithSelect"), field));
		}
		else if(field.equals(LEGALPRODUCTCATEGORY) || field.equals(PRODUCTFUNCTION) || field.equals(DELIVERYSYSTEM)
				|| field.equals(ENDUSE) || field.equals(ENDUSER) || field.equals(USECONDITION)
				|| field.equals(PRODUCTTYPE)) 
		{
			applicationUtils.scrollToElement(String.format(properties.getProperty("RequestApprovalsButton"),ASSOCIATED));
			//applicationUtils.scrollToElement(String.format(properties.getProperty("SpanContainsTextWithInput"), PH));
			applicationUtils.idleTime(2000);
			return applicationUtils.isElementPresent(String.format(properties.getProperty("SpanWithSelect"), field));
		}
		else if (field.equals(PRODUCTNAME)) 
		{
			applicationUtils.scrollToElement(properties.getProperty("ProductNameProposed"));
			return applicationUtils.isElementPresent(properties.getProperty("ProductNameProposed"));
		}
		else if(field.equals(ASSOCIATED)) {
			applicationUtils.scrollToElement(String.format(properties.getProperty("RequestApprovalsButton"),field));
			return applicationUtils.isElementPresent(String.format(properties.getProperty("RequestApprovalsButton"),field));
		}
		else if(field.equals(RMCEXCEPTIONREASON)) {
			applicationUtils.scrollToElement(String.format(properties.getProperty("SpanContainsTextWithInput"), RMCEXCEPTIONREASON));
			return applicationUtils.isElementDisplayed(String.format(properties.getProperty("SpanContainsTextWithInput"), RMCEXCEPTIONREASON));
		}
		else
		{
			return false;
		}
	}

	public boolean verifyFieldInputsSectionOnRequestApprovalsTab(String field)
	{
		switch (field) 
		{
		case REGION:
			applicationUtils.scrollToElement(String.format(properties.getProperty("SpanContainsTextWithInput"), REVIEWREQUESTEDBY));
			return applicationUtils.isElementPresent(String.format(properties.getProperty("SpanWithSelect"), field));
		case REVIEWREQUESTEDBY:
			applicationUtils.scrollToElement(String.format(properties.getProperty("SpanContainsTextWithInput"), field));
			return applicationUtils.isElementPresent(String.format(properties.getProperty("SpanContainsTextWithInput"), field));
		case ADDITIONALINFORMATION:
			applicationUtils.scrollToElement(String.format(properties.getProperty("SpanContainsTextWithInput"), field));
			return applicationUtils.isElementPresent(String.format(properties.getProperty("SpanContainsTextWithInput"), field));
		default:
			throw new NotSupportedException(field+" is not available");
		}
	}

	public boolean verifyFieldRequiredApprovalsSectionOnRequestApprovalsTab(String field)
	{
		if (field.equals(CLINICALRISKASSESSMENTFULL) || field.equals(LEGAL) || field.equals(ENVIRONMENTALASSESSMENT))
		{
			applicationUtils.scrollToElement(String.format(properties.getProperty("SpanWithSelect"), field));
			return applicationUtils.isElementPresent(String.format(properties.getProperty("SpanWithSelect"), field));
		}
		else if (field.equals(RMCADMIN))
		{
			applicationUtils.scrollToElement(properties.getProperty("RMCAdminSelect"));
			return applicationUtils.isElementPresent(properties.getProperty("RMCAdminSelect"));
		}
		else if (field.equals(TOXICOLOGYCLINICALSAFETYFULL) || field.equals(TOXICOLOGYCLINICALSAFETYPRELIMINARY))
		{
			String apprType = field.split(" ")[field.split(" ").length - 1];
			applicationUtils.scrollToElement(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeSelect"), apprType));
			return applicationUtils.isElementPresent(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeSelect"), apprType));
		}
		else if (field.equals(TOXICOLOGYCLINICALSAFETYFULLHUT) || field.equals(TOXICOLOGYCLINICALSAFETYPRELIMINARYHUT))
		{
			String apprType = field.split(" ")[field.split(" ").length - 1];
			applicationUtils.scrollToElement(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeSelect"), apprType));
			return applicationUtils.isElementPresent(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeSelect"), apprType));
		}
		else if (field.equals(RDFULL) || field.equals(RDPRELIMINARY))
		{
			String apprType = field.split(" ")[field.split(" ").length - 1];
			applicationUtils.scrollToElement(String.format(properties.getProperty("RDTypeSelect"), apprType));
			return applicationUtils.isElementPresent(String.format(properties.getProperty("RDTypeSelect"), apprType));
		} 
		else if (field.equals(APACREGULATORYPRELIMINARY) || field.equals(EMEAREGULATORYPRELIMINARY)
				|| field.equals(NAREGULATORYPRELIMINARY) || field.equals(LATAMREGULATORYPRELIMINARY)) 
		{
			String region = field.split(" ")[0];
			applicationUtils.scrollToElement(String.format(properties.getProperty("RegionRegulatoryPreliminarySelect"), region));
			return applicationUtils.isElementPresent(String.format(properties.getProperty("RegionRegulatoryPreliminarySelect"), region));
		} 
		else if (field.equals(APACREGULATORYPRELIMINARYHUT) || field.equals(EMEAREGULATORYPRELIMINARYHUT)
				|| field.equals(NAREGULATORYPRELIMINARYHUT) || field.equals(LATAMREGULATORYPRELIMINARYHUT)) 
		{
			String region = field.split(" ")[0];
			applicationUtils.scrollToElement(String.format(properties.getProperty("RegionRegulatoryPreliminaryHUTSelect"), region));
			return applicationUtils.isElementPresent(String.format(properties.getProperty("RegionRegulatoryPreliminaryHUTSelect"), region));
		} 
		else if (field.equals(APACREGULATORYFULL) || field.equals(EMEAREGULATORYFULL)
				|| field.equals(NAREGULATORYFULL) || field.equals(LATAMREGULATORYFULL)) 
		{
			String region = field.split(" ")[0];
			applicationUtils.scrollToElement(String.format(properties.getProperty("RegionRegulatoryFullSelect"), region));
			return applicationUtils.isElementPresent(String.format(properties.getProperty("RegionRegulatoryFullSelect"), region));
		} 
		else if (field.equals(APACREGULATORYFULLHUT) || field.equals(EMEAREGULATORYFULLHUT)
				|| field.equals(NAREGULATORYFULLHUT) || field.equals(LATAMREGULATORYFULLHUT)) 
		{
			String region = field.split(" ")[0];
			applicationUtils.scrollToElement(String.format(properties.getProperty("RegionRegulatoryFullHUTSelect"), region));
			return applicationUtils.isElementPresent(String.format(properties.getProperty("RegionRegulatoryFullHUTSelect"), region));
		} 
		else if (field.equals(COMMENNTRATIONALE)) {
			applicationUtils.scrollToElement(String.format(properties.getProperty("SpanContainsTextWithInput"), field));
			return applicationUtils.isElementPresent(String.format(properties.getProperty("SpanContainsTextWithInput"), field));
		}
		else
		{
			return false;
		}
	}

	public boolean verifyFieldHUTSectionOnRequestApprovalsTab(String field) 
	{
		if (field.equals(HUTDESCRITION)) 
		{
			applicationUtils.scrollToElement(String.format(properties.getProperty("SpanContainsTextWithInput"), field));
			return applicationUtils.isElementPresent(String.format(properties.getProperty("SpanContainsTextWithInput"), field));
		} 
		else if (field.equals(HUTREGION) || field.equals(LEGALPRODUCTCATEGORYINHUTREGION))
		{
			applicationUtils.scrollToElement(String.format(properties.getProperty("SpanWithSelect"), field));
			return applicationUtils.isElementPresent(String.format(properties.getProperty("SpanWithSelect"), field));
		}
		else if (field.equals("Select Required Functional Approval(s)*"))
		{
			applicationUtils.scrollToElement(String.format(properties.getProperty("SpanText"), field));
			return applicationUtils.isElementPresent(String.format(properties.getProperty("SpanText"), field));
		}
		else
		{
			return false;
		}
	}

	public void userSelectsValueforFieldOnRequestApprovalsTab(String value, String field)
	{
		switch (field) 
		{
		case REGION:
			applicationUtils.scrollToElement(properties.getProperty("InputsRegion"));
			applicationUtils.enterText(properties.getProperty("InputsRegion"), value);
			applicationUtils.idleTime(2000);
			applicationUtils.clickOnElement(String.format(properties.getProperty("ListWithText"), value));
			applicationUtils.idleTime(2000);
			break;
		case HUTREGION:
		case LEGALPRODUCTCATEGORYINHUTREGION:
			applicationUtils.scrollToElement(String.format(properties.getProperty("SpanWithSelect"), field));
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("SpanWithSelect"), field), value);
			break;
		default:
			throw new NotSupportedException(field+" is not available");
		}
	}

	public void enterFieldsOnInputsSectionOnRequestApprovalsTab(String field, String value) throws ParseException
	{
		applicationUtils.scrollToElement(properties.getProperty("InputsRegion"));
		switch (field) 
		{
		case REGION:
			applicationUtils.enterText(properties.getProperty("InputsRegion"), value);
			applicationUtils.idleTime(2000);
			applicationUtils.clickOnElement(String.format(properties.getProperty("ListWithText"), value));
			applicationUtils.idleTime(2000);
			break;
		case REVIEWREQUESTEDBY:
			rmprerequisiteUtils.selectDateRMWorkFlow(properties.getProperty("RequestedBy_CalenderButton"), value);
			break;
		case ADDITIONALINFORMATION:
			applicationUtils.enterText(String.format(properties.getProperty("SpanContainsTextWithInput"), field),value);
			break;
		default:
			throw new NotSupportedException(field+" is not available");
		}
	}

	public boolean userVerifiesRadioButtonOptionforFieldOnRequestApprovalsTab(String field, String options) 
	{
		boolean option1Flag = false;
		boolean option3Flag = false;
		boolean option2Flag = false;
		boolean labelFlag = false;
		String[] optionlist;
		optionlist = options.split(",");
		if (field.equals(HUTCLAIMSUPPORT))
		{
			applicationUtils.scrollToElement(String.format(properties.getProperty("SpanText"), field));
			labelFlag = applicationUtils.isElementPresent(String.format(properties.getProperty("SpanText"), field));
			for (String option : optionlist) 
			{
				if (option.equals("Yes"))
				{
					option1Flag = applicationUtils.isElementPresent(properties.getProperty("HutforClaimSupportYes"));
				} 
				else if (option.equals("No")) 
				{
					option2Flag = applicationUtils.isElementPresent(properties.getProperty("HutforClaimSupportNo"));
				}
			}

			return labelFlag & option1Flag & option2Flag;
		} 
		else if (field.equals(REGULATORY)) 
		{
			applicationUtils.scrollToElement(String.format(properties.getProperty("SpanText"), field));
			labelFlag = applicationUtils.isElementPresent(String.format(properties.getProperty("SpanText"), field));
			for (String option : optionlist) 
			{
				if (option.equals("Preliminary")) 
				{
					option1Flag = applicationUtils.isElementPresent(properties.getProperty("RegulatoryPreliminary"));
				}
				else if (option.equals("None")) 
				{
					option2Flag = applicationUtils.isElementPresent(properties.getProperty("RegulatoryNone"));
				}
			}

			return labelFlag & option1Flag & option2Flag;
		} 
		else if (field.equals(TOXICOLOGYCLINICALSAFETY)) 
		{
			applicationUtils.scrollToElement(String.format(properties.getProperty("SpanText"), field));
			labelFlag = applicationUtils.isElementPresent(String.format(properties.getProperty("SpanText"), field));
			for (String option : optionlist) 
			{
				if (option.equals("Preliminary")) 
				{
					option1Flag = applicationUtils.isElementPresent(properties.getProperty("ToxicologyClinicalSafetyPreliminary"));
				}
				else if (option.equals("Full")) 
				{
					option2Flag = applicationUtils.isElementPresent(properties.getProperty("ToxicologyClinicalSafetyFull"));
				}
				else if (option.equals("None")) 
				{
					option3Flag = applicationUtils.isElementPresent(properties.getProperty("ToxicologyClinicalSafetyNone"));
				}
			}

			return labelFlag & option1Flag & option2Flag & option3Flag;
		}
		else
		{
			return false;
		}
	}

	public void userSelectsOptionforRadioButtonOnRequestApprovalsTab(String option, String field)
	{
		if (field.equals(HUTCLAIMSUPPORT)) 
		{
			if (option.equals("Yes"))
			{
				applicationUtils.clickOnElement(properties.getProperty("HutforClaimSupportYes"));
			}
			else if (option.equals("No")) 
			{
				applicationUtils.clickOnElement(properties.getProperty("HutforClaimSupportNo"));
			}
			else
			{
				System.out.println(option+" is not available for field "+field);
			}
		} 
		else if (field.equals(REGULATORY)) 
		{
			if (option.equals("Priliminary"))
			{
				applicationUtils.clickOnElement(properties.getProperty("RegulatoryPreliminary"));
			}
			else if (option.equals("None"))
			{
				applicationUtils.clickOnElement(properties.getProperty("RegulatoryNone"));
			}
			else
			{
				System.out.println(option+" is not available for field "+field);
			}
		}
		else if (field.equals(TOXICOLOGYCLINICALSAFETY))
		{
			if (option.equals("Priliminary"))
			{
				applicationUtils.clickOnElement(properties.getProperty("ToxicologyClinicalSafetyPreliminary"));
			}
			else if (option.equals("Full"))
			{
				applicationUtils.clickOnElement(properties.getProperty("ToxicologyClinicalSafetyFull"));
			}
			else if (option.equals("None"))
			{
				applicationUtils.clickOnElement(properties.getProperty("ToxicologyClinicalSafetyNone"));
			}
			else
			{
				System.out.println(option+" is not available for field "+field);
			}
		}
		else
		{
			System.out.println(field+" is not available");
		}
	}

	public boolean userVerifiesSelectedRadioButtonOptionOnRequestApprovalsTab(String field, String option)
	{
		if (field.equals(HUTCLAIMSUPPORT))
		{
			if (option.equals("Yes")) 
			{
				return applicationUtils.isElementSelected(properties.getProperty("HutforClaimSupportYes"));
			} 
			else if (option.equals("No")) 
			{
				return applicationUtils.isElementSelected(properties.getProperty("HutforClaimSupportNo"));
			}
			else
			{
				System.out.println(option+" is not available for field "+field);
				return false;
			}
		} 
		else if (field.equals(REGULATORY)) 
		{
			if (option.equals("Preliminary")) 
			{
				return applicationUtils.isElementSelected(properties.getProperty("RegulatoryPreliminary"));
			}
			else if (option.equals("None")) 
			{
				return applicationUtils.isElementSelected(properties.getProperty("RegulatoryNone"));
			}
			else
			{
				System.out.println(option+" is not available for field "+field);
				return false;
			}
		} 
		else if (field.equals(TOXICOLOGYCLINICALSAFETY)) 
		{
			if (option.equals("Preliminary")) 
			{
				return applicationUtils.isElementSelected(properties.getProperty("ToxicologyClinicalSafetyPreliminary"));
			}
			else if (option.equals("Full"))
			{
				return applicationUtils.isElementSelected(properties.getProperty("ToxicologyClinicalSafetyFull"));
			} 
			else if (option.equals("None")) 
			{
				return applicationUtils.isElementSelected(properties.getProperty("ToxicologyClinicalSafetyNone"));
			}
			else
			{
				System.out.println(option+" is not available for field "+field);
				return false;
			}
		}
		else
		{
			System.out.println(field+" is not available");
			return false;
		}
	}

	public void userClicksoButtonOnRequestApprovalsTab(String btnName) 
	{
		if (btnName.equals(LAUNCHWORKFLOW))
		{
			applicationUtils.idleTime(40000);
		}

		applicationUtils.clickOnElement(String.format(properties.getProperty("SpanContainsText"), btnName));
	}

	public void enterValuesForMandatoryFieldsWithHUTOnRequestApprovalsTab(String reqType) throws ParseException
	{
		enterValuesMandatoryFieldsDataRequired(reqType);
		takeActionOnCheckBoxOnRequestApprovalstab("Not Applicable", "Selects");
		enterValuesMandatoryFieldsInputs(reqType);
		clickLinkOnRequestApproval("Add Additional Reviews");
		takeActionOnCheckBoxOnRequestApprovalstab("HUT", "Selects");
		enterValuesMandatoryFieldsHUT();
		enterValueMandatoryFieldsRequiredApproversWithHUT(reqType);
	}

	public void enterValuesForMandatoryFieldsOnRequestApprovalsTab(String reqType) throws ParseException
	{
		enterValuesMandatoryFieldsDataRequired(reqType);
		takeActionOnCheckBoxOnRequestApprovalstab("Not Applicable", "Selects");
		enterValuesMandatoryFieldsInputs(reqType);
		enterValueMandatoryFieldsRequiredApproversWithOutHUT(reqType);
	}

	public void enterValuesMandatoryFieldsDataRequired(String reqType)
	{
		String randValue = applicationUtils.getRandomName();
		approvalrequesttype=reqType;
		if (reqType.equals(APPROVALFORLAUNCH) || reqType.equals(APPROVALFORSCALEUP)|| reqType.equals(APPROVEDFORSCALEUP)) 
		{
			if(applicationUtils.isElementDisplayed(String.format(properties.getProperty("SpanContainsTextWithInput"), RMCEXCEPTIONREASON)))
			{
				applicationUtils.enterText(String.format(properties.getProperty("SpanContainsTextWithInput"), RMCEXCEPTIONREASON),randValue);
			}

			applicationUtils.enterText(String.format(properties.getProperty("SpanContainsTextWithInput"), PFSPECNO),randValue);
			applicationUtils.enterText(String.format(properties.getProperty("SpanContainsTextWithInput"), PRSPECNO),randValue);
			applicationUtils.enterText("//span[contains(text(),'Product Name') and contains(text(),'(Proposed)*')]/..//input", randValue);
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("SpanWithSelect"), LEGALPRODUCTCATEGORY), "Cosmetic");
			applicationUtils.enterText(String.format(properties.getProperty("SpanContainsTextWithInput"), PRODUCTFUNCTION), "Acne");
			applicationUtils.moveToElementClick(String.format(properties.getProperty("ListWithText"), "Acne"));
			applicationUtils.enterText(String.format(properties.getProperty("SpanContainsTextWithInput"), DELIVERYSYSTEM), "Aerosol Foam");
			applicationUtils.moveToElementClick(String.format(properties.getProperty("ListWithText"), "Aerosol Foam"));
			applicationUtils.enterText(String.format(properties.getProperty("SpanContainsTextWithInput"), ENDUSE),"Aerosol");
			applicationUtils.moveToElementClick(String.format(properties.getProperty("ListWithText"), "Aerosol"));
			applicationUtils.enterText(String.format(properties.getProperty("SpanContainsTextWithInput"), ENDUSER),"0-3 Years");
			applicationUtils.moveToElementClick(String.format(properties.getProperty("ListWithText"), "0-3 Years"));
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("SpanWithSelect"), USECONDITION),"Compromised");
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("SpanWithSelect"), PRODUCTTYPE),"Rinse Off");
		}

		if (reqType.equals(APPROVALFORLAUNCH)) 
		{
			applicationUtils.enterText(String.format(properties.getProperty("SpanContainsTextWithInput"), PH),randValue);
			applicationUtils.enterText(String.format(properties.getProperty("SpanContainsTextWithInput"), SPECIFICGRAVITY), randValue);
			applicationUtils.enterText(String.format(properties.getProperty("SpanContainsTextWithInput"), APPEARANCE),randValue);
		}
	}

	public void enterValuesMandatoryFieldsInputs(String reqType) throws ParseException 
	{
		if (reqType.equals(APPROVALFORLAUNCH) || reqType.equals(APPROVALFORSCALEUP)) 
		{
			applicationUtils.scrollToElement(properties.getProperty("InputsRegion"));
			applicationUtils.enterText(properties.getProperty("InputsRegion"), "Asia Pacific");
			applicationUtils.idleTime(2000);
			applicationUtils.moveToElementClick(String.format(properties.getProperty("ListWithText"), "Asia Pacific"));
			applicationUtils.idleTime(1000);
			rmprerequisiteUtils.selectDateRMWorkFlow(properties.getProperty("RequestedBy_CalenderButton"),"Current Date");
		}
	}

	@SuppressWarnings("null")
	public void unselectsValueForMultiSelect(String options, String field)
	{
		String[] ls = null;
		List<WebElement> regions = null;
		if (options.contains(";")) 
		{
			ls = options.split(";");
		} 
		else
		{
			ls[0] = options;
		}

		switch (field) 
		{
		case REGION:
			regions = driver.findElements(By.xpath("//div[@id='normalRegion_chosen']//li[@class='search-choice']"));
			if (!regions.isEmpty())
			{
				for (int i = 0; i < ls.length; i++) 
				{
					applicationUtils.clickOnElement("//div[@id='normalRegion_chosen']//span[text()='" + ls[i] + "']/following-sibling::a");
					applicationUtils.idleTime(1000);
				}
			}
			break;
		default:
			throw new NotSupportedException(field+" is not available");
		}
	}

	public void enterValuesFieldsOnHUT(String field, String value)
	{
		String randValue = applicationUtils.getRandomName();
		switch (field) 
		{
		case HUTDESCRITION:
			applicationUtils.enterText(String.format(properties.getProperty("SpanContainsTextWithInput"), HUTDESCRITION), randValue);
			break;
		case HUTREGION:
			applicationUtils.selectbyVisibletext(properties.getProperty("HUTRegionDropDown"),value);
			break;
		case LEGALPRODUCTCATEGORYINHUTREGION:
			applicationUtils.selectbyVisibletext(properties.getProperty("LegalProductDropDown"), value);
			break;
		default:
			throw new NotSupportedException(field+" is not available");
		}
	}

	public String getUserFullName(String userRole) 
	{
		String[] userDetails=properties.getProperty(userRole).split(";;");
		return userDetails[2].trim();
	}

	public void enterValueMandatoryFieldsRequiredApproversWithOutHUT(String reqType)
	{
		String apprType;
		if (reqType.equals(APPROVALFORSCALEUP)) 
		{
			apprType = TOXICOLOGYCLINICALSAFETYPRELIMINARY.split(" ")[TOXICOLOGYCLINICALSAFETYPRELIMINARY.split(" ").length - 1];
			applicationUtils.scrollToElement(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeSelect"), apprType));
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeSelect"), apprType),getUserFullName("ToxicologyApprover"));
			if (applicationUtils.isElementPresent(properties.getProperty("RMCAdminSelect"))) {
				applicationUtils.selectbyVisibletext(properties.getProperty("RMCAdminSelect"), getUserFullName("RMCuser"));
			}

			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RDTypeSelect"),
					RDPRELIMINARY.split(" ")[RDPRELIMINARY.split(" ").length - 1]), getUserFullName("RDApprover"));
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryPreliminarySelect"),
					APACREGULATORYPRELIMINARY.split(" ")[0]), getUserFullName("APACRegulatoryApprover"));
		}
		else if (reqType.equals(APPROVALFORLAUNCH)) 
		{
			apprType = TOXICOLOGYCLINICALSAFETYFULL.split(" ")[TOXICOLOGYCLINICALSAFETYFULL.split(" ").length - 1];
			applicationUtils.scrollToElement(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeSelect"), apprType));
			if (applicationUtils.isElementPresent(properties.getProperty("RMCAdminSelect"))) 
			{
				applicationUtils.selectbyVisibletext(properties.getProperty("RMCAdminSelect"), getUserFullName("RMCuser"));
			}

			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeSelect"), apprType),getUserFullName("ToxicologyApprover"));
			applicationUtils.scrollToElement(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeSelect"), apprType));
			apprType = RDFULL.split(" ")[RDFULL.split(" ").length - 1];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RDTypeSelect"), apprType),getUserFullName("RDApprover"));
			apprType = APACREGULATORYFULL.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryFullSelect"), apprType),getUserFullName("APACRegulatoryApprover"));
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("SpanWithSelect"), LEGAL),getUserFullName("LegalApprover"));
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("SpanWithSelect"), ENVIRONMENTALASSESSMENT), getUserFullName("EnvironmentalAssessmentApprover"));
		}
	}

	public void enterValueMandatoryFieldsRequiredApproversWithHUT(String reqType)
	{
		String apprType;
		if (reqType.equals(APPROVALFORSCALEUP)) 
		{
			if (applicationUtils.isElementPresent(properties.getProperty("RMCAdminSelect")))
			{
				applicationUtils.selectbyVisibletext(properties.getProperty("RMCAdminSelect"), getUserFullName("RMCuser"));
			}
			if(applicationUtils.isElementPresent(properties.getProperty("ToxicologyClinicalSafetyTypeHUTSelect"))) 
			{
				apprType = TOXICOLOGYCLINICALSAFETYFULLHUT.split(" ")[TOXICOLOGYCLINICALSAFETYFULLHUT.split(" ").length - 1];
				applicationUtils.scrollToElement(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeHUTSelect"), apprType));
				applicationUtils.selectbyVisibletext(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeHUTSelect"), apprType),getUserFullName("ToxicologyApprover"));
			}
			else 
			{
				apprType = TOXICOLOGYCLINICALSAFETYPRELIMINARYHUT.split(" ")[TOXICOLOGYCLINICALSAFETYPRELIMINARYHUT.split(" ").length - 1];
				applicationUtils.scrollToElement(String.format(properties.getProperty("ToxicologyClinicalSafetyTypePrliminaryHUTSelect"), apprType));
				applicationUtils.selectbyVisibletext(String.format(properties.getProperty("ToxicologyClinicalSafetyTypePrliminaryHUTSelect"), apprType),
						getUserFullName("ToxicologyApprover"));
			}

			if (applicationUtils.isElementPresent(properties.getProperty("RMCAdminSelect"))) 
			{
				applicationUtils.selectbyVisibletext(properties.getProperty("RMCAdminSelect"), getUserFullName("RMCuser"));
			}

			apprType = RDPRELIMINARY.split(" ")[RDPRELIMINARY.split(" ").length - 1];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RDTypeSelect"), apprType),getUserFullName("RDApprover"));
			apprType = APACREGULATORYPRELIMINARYHUT.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryPreliminarySelect"), apprType),getUserFullName("APACRegulatoryApprover"));
			apprType = EMEAREGULATORYPRELIMINARYHUT.split(" ")[0];

			if(applicationUtils.isElementPresent(String.format(properties.getProperty("RegionRegulatoryPreliminarySelect"), apprType)))
				applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryPreliminarySelect"), apprType),getUserFullName("EMEARegulatoryApprover"));
		} 
		else if (reqType.equals(APPROVALFORLAUNCH)) 
		{
			if (applicationUtils.isElementPresent(properties.getProperty("RMCAdminSelect")))
			{
				applicationUtils.selectbyVisibletext(properties.getProperty("RMCAdminSelect"), getUserFullName("RMCuser"));
			}
			apprType = TOXICOLOGYCLINICALSAFETYFULLHUT.split(" ")[TOXICOLOGYCLINICALSAFETYFULLHUT.split(" ").length-1];
			applicationUtils.scrollToElement(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeHUTSelect"), apprType));
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeHUTSelect"), apprType),getUserFullName("ToxicologyApprover"));
			apprType = RDFULL.split(" ")[RDFULL.split(" ").length - 1];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RDTypeSelect"), apprType),getUserFullName("RDApprover"));
			apprType = APACREGULATORYFULL.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryFullSelect"), apprType), getUserFullName("APACRegulatoryApprover"));
			apprType = EMEAREGULATORYPRELIMINARYHUT.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryPreliminaryHUTSelect"), apprType),getUserFullName("EMEARegulatoryApprover"));
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("SpanWithSelect"), LEGAL),getUserFullName("LegalApprover"));
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("SpanWithSelect"), ENVIRONMENTALASSESSMENT), getUserFullName("EnvironmentalAssessmentApprover"));
		}
		else
		{
			System.out.println(reqType+" is not available");
		}
	}

	public void enterValuesMandatoryFieldsHUT()
	{
		String randValue = applicationUtils.getRandomName();
		applicationUtils.enterText(String.format(properties.getProperty("SpanContainsTextWithInput"), HUTDESCRITION),randValue);
		userSelectsOptionforRadioButtonOnRequestApprovalsTab("Yes", HUTCLAIMSUPPORT);
		userSelectsOptionforRadioButtonOnRequestApprovalsTab("Preliminary", REGULATORY);
		userSelectsOptionforRadioButtonOnRequestApprovalsTab("Preliminary", TOXICOLOGYCLINICALSAFETY);
		applicationUtils.selectbyVisibletext(String.format(properties.getProperty("SpanWithSelect"), HUTREGION),"Europe, Middle East, Africa");
		applicationUtils.selectbyVisibletext(String.format(properties.getProperty("SpanWithSelect"), LEGALPRODUCTCATEGORYINHUTREGION), "Cosmetic");
	}

	public boolean verifyUserOnInProgressTab() {
		return applicationUtils.isElementPresent(String.format(properties.getProperty("SpanText"),INPROGRESS));
	}

	public boolean verifyUserOnCompletedReviewsTab() {
		return applicationUtils.isElementPresent(properties.getProperty("CompletedReviewsTab"));
	}

	public String getMessageOnPopup() {
		return applicationUtils.getText(properties.getProperty("ErrorMessageFirstText"));
	}

	public void searchforFMLIDCommonApprovals(String fmlid)
	{
		applicationUtils.enterText(properties.getProperty("SearchTextField_CAM"), fmlid);
		applicationUtils.moveToElementClick(properties.getProperty("SearchIcon_CAM"));
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.idleTime(2000);
	}

	public void enterValuesForMandatoryFieldsInScaleupWithoutHUT(String reqType) throws ParseException
	{
		enterValuesMandatoryFieldsDataRequired(reqType);
		enterValuesMandatoryFieldsInputs(reqType);
		enterValueMandatoryFieldsRequiredApproversWithOutHUT(reqType);
	}

	public void enterValuesMandatoryFieldsForHut()
	{
		String randValue = applicationUtils.getRandomName();
		applicationUtils.enterText(String.format(properties.getProperty("SpanContainsTextWithInput"), HUTDESCRITION),randValue);
		applicationUtils.selectbyVisibletext(String.format(properties.getProperty("SpanWithSelect"), HUTREGION),"Europe, Middle East, Africa");
		applicationUtils.selectbyVisibletext(String.format(properties.getProperty("SpanWithSelect"), LEGALPRODUCTCATEGORYINHUTREGION), "Cosmetic");
	}

	public void entervalueforMandatoryFieldswithHut(String reqType) throws ParseException 
	{
		enterValuesMandatoryFieldsDataRequired(reqType);
		enterValuesMandatoryFieldsInputs(reqType);
		enterValuesMandatoryFieldsForHut();
		enterValueMandatoryFieldsRequiredApproversWithHUT(reqType);
	}

	public boolean verifyinformationforAprroverFunctioninInProgress(String approverFunction)
	{
		boolean flag=false;
		switch (approverFunction) 
		{
		case RMCFORMULAEXCEPTION:
			if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
					&& applicationUtils.getText(String.format(properties.getProperty("InprogressTypeOfReview"), approverFunction)).equals(properties.getProperty("TypeofReview"))
					&& applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(getUserFullName("RMCuser"))
					&& applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
					&& applicationUtils.getText(String.format(properties.getProperty("Notification"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))) 
			{
				flag=true;;
			}
			break;
		case TOXICOLOGY:
			if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
					&& applicationUtils.getText(String.format(properties.getProperty("InprogressTypeOfReview"), approverFunction)).equals(properties.getProperty("TypeOfReviewValue"))
					&& applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(getUserFullName("ToxicologyApprover"))
					&& applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
					&& applicationUtils.getText(String.format(properties.getProperty("Notification"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))) 
			{
				flag=true;
			}
			break;
		case EMEA:
			if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
					&& applicationUtils.getText(String.format(properties.getProperty("InprogressTypeOfReview"), approverFunction)).equals(properties.getProperty("TypeOfReviewValue"))
					&& applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(getUserFullName("EMEARegulatoryApprover"))
					&& applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
					&& applicationUtils.getText(String.format(properties.getProperty("Notification"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))) {
				flag=true;
			}
			break;
		case EMEAPRELIMINARYHUT:
			if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
					&& applicationUtils.getText(String.format(properties.getProperty("InprogressTypeOfReview"), approverFunction)).equals(properties.getProperty("PreliminatoryType"))
					&& applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(getUserFullName("EMEARegulatoryApprover"))
					&& applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
					&& applicationUtils.getText(String.format(properties.getProperty("Notification"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))) 
			{
				flag=true;
			}
			break;
		case APAC:
			if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
					&& applicationUtils.getText(String.format(properties.getProperty("InprogressTypeOfReview"), approverFunction)).equals(properties.getProperty("TypeOfReviewValue"))
					&& applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(getUserFullName("APACRegulatoryApprover"))
					&& applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
					&& applicationUtils.getText(String.format(properties.getProperty("Notification"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))) 
			{
				flag=true;
			}
			break;
		case RANDD:
			if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
					&& applicationUtils.getText(String.format(properties.getProperty("InprogressTypeOfReview"), approverFunction)).equals(properties.getProperty("TypeOfReviewValue"))
					&& applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(getUserFullName("RDApprover"))
					&& applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
					&& applicationUtils.getText(String.format(properties.getProperty("Notification"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
			{
				flag=true;
			}
			break;
		case TOXICOLOGYFULLHUT:
			if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
					&& applicationUtils.getText(String.format(properties.getProperty("InprogressTypeOfReview"), approverFunction)).equals(properties.getProperty("FullHUTType"))
					&& applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(getUserFullName("ToxicologyApprover"))
					&& applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
					&& applicationUtils.getText(String.format(properties.getProperty("Notification"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
			{
				flag=true;
			}
			break;
		case TOXICOLOGYPRELIMINARYHUT:
			if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
					&& applicationUtils.getText(String.format(properties.getProperty("InprogressTypeOfReview"), approverFunction)).equals(properties.getProperty("PreliminatoryType"))
					&& applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(getUserFullName("ToxicologyApprover"))
					&& applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
					&& applicationUtils.getText(String.format(properties.getProperty("Notification"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
			{
				flag=true;
			}
			break;
		case APACHUT:
			if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
					&& applicationUtils.getText(String.format(properties.getProperty("InprogressTypeOfReview"), approverFunction)).equals(properties.getProperty("PreliminatoryType"))
					&& applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(getUserFullName("APACRegulatoryApprover"))
					&& applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
					&& applicationUtils.getText(String.format(properties.getProperty("Notification"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
			{
				flag=true;
			}
			break;
		case NAPRILIMINARY:
			if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
					&& applicationUtils.getText(String.format(properties.getProperty("InprogressTypeOfReview"), approverFunction)).equals(properties.getProperty("TypeOfReviewValue"))
					&& applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(getUserFullName("NARegulatoryApprover"))
					&& applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
					&& applicationUtils.getText(String.format(properties.getProperty("Notification"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
			{
				flag=true;
			}
			break;
		case NAHUTPRILIMINARY:
			if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
					&& applicationUtils.getText(String.format(properties.getProperty("InprogressTypeOfReview"), approverFunction)).equals(properties.getProperty("PreliminatoryType"))
					&& applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(getUserFullName("NARegulatoryApprover"))
					&& applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
					&& applicationUtils.getText(String.format(properties.getProperty("Notification"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
			{
				flag=true;
			}
			break;
		case LATAMPRILIMINARY:
			if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
					&& applicationUtils.getText(String.format(properties.getProperty("InprogressTypeOfReview"), approverFunction)).equals(properties.getProperty("TypeOfReviewValue"))
					&& applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(getUserFullName("LATAMRegulatoryApprover"))
					&& applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
					&& applicationUtils.getText(String.format(properties.getProperty("Notification"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
			{
				flag=true;
			}
			break;
			
		case NAREGFULL:
            if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
                         && applicationUtils.getText(String.format(properties.getProperty("InprogressTypeOfReview"), approverFunction)).equals(properties.getProperty("FullTypeVal"))
                         && applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(getUserFullName("NARegulatoryApprover"))
                         && applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                         && applicationUtils.getText(String.format(properties.getProperty("Notification"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
            {
                  flag=true;
            }
            break;
     case RANDDFULL:
            if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
                         && applicationUtils.getText(String.format(properties.getProperty("InprogressTypeOfReview"), approverFunction)).equals(properties.getProperty("FullTypeVal"))
                         && applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(getUserFullName("RDApprover"))
                         && applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                         && applicationUtils.getText(String.format(properties.getProperty("Notification"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
            {
                  flag=true;
            }
            break;
     case APACREGFULLHUT:
            if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
                         && applicationUtils.getText(String.format(properties.getProperty("InprogressTypeOfReview"), approverFunction)).equals(properties.getProperty("FullHUTTypeVal"))
                         && applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(getUserFullName("APACRegulatoryApprover"))
                         && applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                         && applicationUtils.getText(String.format(properties.getProperty("Notification"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
            {
                  flag=true;
            }
            break;
     case NAREGFULLHUT:
            if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
                         && applicationUtils.getText(String.format(properties.getProperty("InprogressTypeOfReview"), approverFunction)).equals(properties.getProperty("FullHUTTypeVal"))
                         && applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(getUserFullName("NARegulatoryApprover"))
                         && applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                         && applicationUtils.getText(String.format(properties.getProperty("Notification"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
            {
                  flag=true;
            }
            break;
     case EMEAREGFULL:
            if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
                         && applicationUtils.getText(String.format(properties.getProperty("InprogressTypeOfReview"), approverFunction)).equals(properties.getProperty("FullTypeVal"))
                         && applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(getUserFullName("EMEARegulatoryApprover"))
                         && applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                         && applicationUtils.getText(String.format(properties.getProperty("Notification"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
            {
                  flag=true;
            }
            break;
     case LATAMREGFULL:
            if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
                         && applicationUtils.getText(String.format(properties.getProperty("InprogressTypeOfReview"), approverFunction)).equals(properties.getProperty("FullTypeVal"))
                         && applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(getUserFullName("LATAMRegulatoryApprover"))
                         && applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                         && applicationUtils.getText(String.format(properties.getProperty("Notification"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
            {
                  flag=true;
            }
            break;
     case TOXICOLOGYCLINICALSAFTYFULL:
            if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
                         && applicationUtils.getText(String.format(properties.getProperty("InprogressTypeOfReview"), approverFunction)).equals(properties.getProperty("FullTypeVal"))
                         && applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(getUserFullName("ToxicologyApprover"))
                          && applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                         && applicationUtils.getText(String.format(properties.getProperty("Notification"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
            {
                  flag=true;
            }
            break;
     case APREGULATORYFULL:
            if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
                         && applicationUtils.getText(String.format(properties.getProperty("InprogressTypeOfReview"), approverFunction)).equals(properties.getProperty("FullTypeVal"))
                         && applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(getUserFullName("APACRegulatoryApprover"))
                         && applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                         && applicationUtils.getText(String.format(properties.getProperty("Notification"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
            {
                  flag=true;
            }
     case LEGALAF:
            if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
                         && applicationUtils.getText(String.format(properties.getProperty("LegalEAReviewer"), approverFunction)).equals(getUserFullName("LegalApprover"))
                         && applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                         && applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
            {
                  flag=true;
            }
            break;
     case ENVIRONMENTASSESSMENT:
            if (applicationUtils.getText(String.format(properties.getProperty("Inprogressstatus"), approverFunction)).equals(properties.getProperty("Status"))
                         && applicationUtils.getText(String.format(properties.getProperty("LegalEAReviewer"), approverFunction)).equals(getUserFullName("EnvironmentalAssessmentApprover"))
                         && applicationUtils.getText(String.format(properties.getProperty("Reviewer"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                         && applicationUtils.getText(String.format(properties.getProperty("DateSent"), approverFunction)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
            {
                  flag=true;
            }
            break;

		default:
			throw new java.lang.UnsupportedOperationException("Not supported.");

		}
		return flag;
	}
	
	public boolean verifyinformationforAprroverFunctioninCompletedReviews(String approvalType)
    {
           boolean flag=false;
           switch (approvalType) 
           {
           case TOXICOLOGYPRELIMINARYHUT:
           case TOXICOLOGYFULLHUT:
           case TOXICOLOGYCLINICALSAFTYFULL:
           case TOXICOLOGY:
                  if (applicationUtils.getText(String.format(properties.getProperty("CRStatus"), approvalType)).equals(properties.getProperty("ApprovedStatus"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRApprover"), approvalType)).equals(getUserFullName("ToxicologyApprover"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRRegion"), approvalType)).equals(properties.getProperty("RegionGlobal"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRDateClosed"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRNotification"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
                  {
                
                        flag=true;
                  }
                  else if (applicationUtils.getText(String.format(properties.getProperty("CRStatus"), approvalType)).equals(properties.getProperty("ApprovedStatus"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRApprover"), approvalType)).equals(properties.getProperty("ExternalApprovalAcquired").trim())
                          && applicationUtils.getText(String.format(properties.getProperty("CRRegion"), approvalType)).equals(properties.getProperty("RegionGlobal"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRDateClosed"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRNotification"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))) 
                  {
                   flag=true;
                  }
                  else if (applicationUtils.getText(String.format(properties.getProperty("CRStatus"), approvalType)).equals(properties.getProperty("ApprovedStatus"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRApprover"), approvalType)).equals(properties.getProperty("HistoricalApprovalGranted").trim())
                          && applicationUtils.getText(String.format(properties.getProperty("CRRegion"), approvalType)).equals(properties.getProperty("RegionGlobal"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRDateClosed"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRNotification"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))) 
                  {
                   flag=true;
                  }
                  break;
           case RANDD:
           case RANDDFULL:
                  if (applicationUtils.getText(String.format(properties.getProperty("CRStatus"), approvalType)).equals(properties.getProperty("ApprovedStatus"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRApprover"), approvalType)).equals(getUserFullName("RDApprover"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRRegion"), approvalType)).equals(properties.getProperty("RegionGlobal"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRDateClosed"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRNotification"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
                  {
                        flag=true;
                  }
                  else if (applicationUtils.getText(String.format(properties.getProperty("CRStatus"), approvalType)).equals(properties.getProperty("ApprovedStatus"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRApprover"), approvalType)).equals(properties.getProperty("HistoricalApprovalGranted").trim())
                          && applicationUtils.getText(String.format(properties.getProperty("CRRegion"), approvalType)).equals(properties.getProperty("RegionGlobal"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRDateClosed"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRNotification"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))) 
                  {
                   flag=true;
                  }
                  else if (applicationUtils.getText(String.format(properties.getProperty("CRStatus"), approvalType)).equals(properties.getProperty("ApprovedStatus"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRApprover"), approvalType)).equals(properties.getProperty("ExternalApprovalAcquired").trim())
                          && applicationUtils.getText(String.format(properties.getProperty("CRRegion"), approvalType)).equals(properties.getProperty("RegionGlobal"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRDateClosed"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRNotification"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))) 
                  {
                   flag=true;
                  }
                  break;
           case EMEAPRELIMINARYHUT:
                  if (applicationUtils.getText(String.format(properties.getProperty("CRStatus"), approvalType)).equals(properties.getProperty("ApprovedStatus"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRApprover"), approvalType)).equals(getUserFullName("EMEARegulatoryApprover"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRRegion"), approvalType)).equals(properties.getProperty("RegionEMEA"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRDateClosed"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRNotification"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
                  {
                        flag=true;
                  }
                  else if (applicationUtils.getText(String.format(properties.getProperty("CRStatus"), approvalType)).equals(properties.getProperty("ApprovedStatus"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRApprover"), approvalType)).equals(properties.getProperty("ExternalApprovalAcquired").trim())
                          && applicationUtils.getText(String.format(properties.getProperty("CRRegion"), approvalType)).equals(properties.getProperty("RegionEMEA"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRDateClosed"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRNotification"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))) 
                  {
                   flag=true;
                  }
           break;
           case LEGALAF:
                  if (applicationUtils.getText(String.format(properties.getProperty("CRStatus"), approvalType)).equals(properties.getProperty("ApprovedStatus"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRApprover"), approvalType)).equals(getUserFullName("LegalApprover"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRRegion"), approvalType)).equals(properties.getProperty("RegionGlobal"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRDateClosed"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRNotification"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))) 
                  {
                        flag=true;
                  }
                  else if (applicationUtils.getText(String.format(properties.getProperty("CRStatus"), approvalType)).equals(properties.getProperty("ApprovedStatus"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRApprover"), approvalType)).equals(properties.getProperty("ExternalApprovalAcquired").trim())
                          && applicationUtils.getText(String.format(properties.getProperty("CRRegion"), approvalType)).equals(properties.getProperty("RegionGlobal"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRDateClosed"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRNotification"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))) 
                  {
                   flag=true;
                  }
                  else if (applicationUtils.getText(String.format(properties.getProperty("CRStatus"), approvalType)).equals(properties.getProperty("ApprovedStatus"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRApprover"), approvalType)).equals(properties.getProperty("HistoricalApprovalGranted").trim())
                          && applicationUtils.getText(String.format(properties.getProperty("CRRegion"), approvalType)).equals(properties.getProperty("RegionGlobal"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRDateClosed"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRNotification"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
                  {
                   flag=true;
                  }
                  break;
           case ENVIRONMENTASSESSMENT:
                  if (applicationUtils.getText(String.format(properties.getProperty("CRStatus"), approvalType)).equals(properties.getProperty("ApprovedStatus"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRApprover"), approvalType)).equals(getUserFullName("EnvironmentalAssessmentApprover"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRRegion"), approvalType)).equals(properties.getProperty("RegionGlobal"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRDateClosed"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRNotification"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))) 
                  {
                        flag=true;
                  }
                  else if (applicationUtils.getText(String.format(properties.getProperty("CRStatus"), approvalType)).equals(properties.getProperty("ApprovedStatus"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRApprover"), approvalType)).equals(properties.getProperty("ExternalApprovalAcquired").trim())
                          && applicationUtils.getText(String.format(properties.getProperty("CRRegion"), approvalType)).equals(properties.getProperty("RegionGlobal"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRDateClosed"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRNotification"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
                  {
                   flag=true;
                  }
                  else if (applicationUtils.getText(String.format(properties.getProperty("CRStatus"), approvalType)).equals(properties.getProperty("ApprovedStatus"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRApprover"), approvalType)).equals(properties.getProperty("HistoricalApprovalGranted").trim())
                          && applicationUtils.getText(String.format(properties.getProperty("CRRegion"), approvalType)).equals(properties.getProperty("RegionGlobal"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRDateClosed"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRNotification"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))) 
                  {
                   flag=true;
                  }
                  break;
           case APAC:
           case APREGULATORYFULL:
           case APACREGFULLHUT:
                  if (applicationUtils.getText(String.format(properties.getProperty("CRStatus"), approvalType)).equals(properties.getProperty("ApprovedStatus"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRApprover"), approvalType)).equals(getUserFullName("APACRegulatoryApprover"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRRegion"), approvalType)).equals(properties.getProperty("RegionAPAC"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRDateClosed"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRNotification"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
                  {
                        flag=true;
                  }
                  else if (applicationUtils.getText(String.format(properties.getProperty("CRStatus"), approvalType)).equals(properties.getProperty("ApprovedStatus"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRApprover"), approvalType)).equals(properties.getProperty("ExternalApprovalAcquired").trim())
                          && applicationUtils.getText(String.format(properties.getProperty("CRRegion"), approvalType)).equals(properties.getProperty("RegionAPAC"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRDateClosed"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                          && applicationUtils.getText(String.format(properties.getProperty("CRNotification"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))) 
                  {
                   flag=true;
                  }
                  break;
           case NAPRILIMINARY:
               if (applicationUtils.getText(String.format(properties.getProperty("CRStatus"), approvalType)).equals(properties.getProperty("ApprovedStatus"))
                            && applicationUtils.getText(String.format(properties.getProperty("CRApprover"), approvalType)).equals(properties.getProperty("HistoricalApprovalGranted").trim())
                            && applicationUtils.getText(String.format(properties.getProperty("CRRegion"), approvalType)).equals(properties.getProperty("RegionNA"))
                            && applicationUtils.getText(String.format(properties.getProperty("CRDateClosed"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                            && applicationUtils.getText(String.format(properties.getProperty("CRNotification"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
               {
                     flag=true;
               }
               break;
           case LATAMREGULATORYHUTPRILIMINARY:
               if (applicationUtils.getText(String.format(properties.getProperty("CRStatus"), approvalType)).equals(properties.getProperty("ApprovedStatus"))
                            && applicationUtils.getText(String.format(properties.getProperty("CRApprover"), approvalType)).equals(properties.getProperty("ExternalApprovalAcquired").trim())
                            && applicationUtils.getText(String.format(properties.getProperty("CRRegion"), approvalType)).equals(properties.getProperty("RegionLATAM"))
                            && applicationUtils.getText(String.format(properties.getProperty("CRDateClosed"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                            && applicationUtils.getText(String.format(properties.getProperty("CRNotification"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))) 
               {
                     flag=true;
               }
               break;
           case EMEAREGFULL:
                  if (applicationUtils.getText(String.format(properties.getProperty("CRStatus"), approvalType)).equals(properties.getProperty("ApprovedStatus"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRApprover"), approvalType)).equals(getUserFullName("EMEARegulatoryApprover"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRRegion"), approvalType)).equals(properties.getProperty("RegionEMEA"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRDateClosed"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRNotification"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))) 
                  {
                        flag=true;
                  }
                  break;
           case RMCFORMULAEXCEPTION:
                  if (applicationUtils.getText(String.format(properties.getProperty("CRStatus"), approvalType)).equals(properties.getProperty("ApprovedStatus"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRApprover"), approvalType)).equals(getUserFullName("RMCAdmin"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRRegion"), approvalType)).equals(properties.getProperty("RegionGlobal"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRDateClosed"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy"))
                               && applicationUtils.getText(String.format(properties.getProperty("CRNotification"), approvalType)).equals(applicationUtils.getCurrentDate("dd-MMM-yyyy")))
                  {
                        flag=true;
                  }
                  break;
                  
           default:
        	   throw new java.lang.UnsupportedOperationException("Not supported.");
           }
           return flag;
    }

	public void userSelectsApproverOnRequestApprovalsTab(String field)
	{
		String apprType;
		// TOXICOLOGY APPROVER
		String toxiApprover = getUserFullName("ToxicologyApprover");
		if (field.equals(TOXICOLOGYCLINICALSAFETYPRELIMINARY) || field.equals(TOXICOLOGYCLINICALSAFETYFULL)) 
		{
			apprType = field.split(" ")[field.split(" ").length - 1];
			applicationUtils.scrollToElement(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeSelect"), apprType));
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeSelect"), apprType),toxiApprover);
		}
		else if (field.equals(TOXICOLOGYCLINICALSAFETYPRELIMINARYHUT) || field.equals(TOXICOLOGYCLINICALSAFETYFULLHUT)) 
		{
			apprType = field.split(" ")[field.split(" ").length - 1];
			applicationUtils.scrollToElement(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeSelect"), apprType));
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeSelect"), apprType),toxiApprover);
		}

		// RD APPROVER
		String rdApprover = getUserFullName("RDApprover");
		if (field.equals(RDFULL)||field.equals(RDPRELIMINARY)) 
		{
			apprType = field.split(" ")[field.split(" ").length - 1];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RDTypeSelect"), apprType),rdApprover);
		}

		// APAC REGULATORY
		String apacRegApprover = getUserFullName("APACRegulatoryApprover");
		if (field.equals(APACREGULATORYFULL)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryFullSelect"), apprType), apacRegApprover);
		}
		else if (field.equals(APACREGULATORYPRELIMINARY)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryPreliminarySelect"), apprType),apacRegApprover);
		}
		else if (field.equals(APACREGULATORYPRELIMINARYHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryPreliminaryHUTSelect"), apprType),apacRegApprover);
		} 
		else if (field.equals(APACREGULATORYFULLHUT))
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryFullHUTSelect"), apprType), apacRegApprover);
		}

		// NA REGULATORY
		String naRegApprover = getUserFullName("NARegulatoryApprover");
		if (field.equals(NAREGULATORYFULL)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryFullSelect"), apprType), naRegApprover);
		} 
		else if (field.equals(NAREGULATORYPRELIMINARY)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryPreliminarySelect"), apprType),naRegApprover);
		} 
		else if (field.equals(NAREGULATORYPRELIMINARYHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryPreliminaryHUTSelect"), apprType),naRegApprover);
		} 
		else if (field.equals(NAREGULATORYFULLHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryFullHUTSelect"), apprType), naRegApprover);
		}

		// LATAM REGULATORY
		String latamRegApprover = getUserFullName("LATAMRegulatoryApprover");
		if (field.equals(LATAMREGULATORYFULL)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryFullSelect"), apprType), latamRegApprover);
		}
		else if (field.equals(LATAMREGULATORYPRELIMINARY)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryPreliminarySelect"), apprType),latamRegApprover);
		}
		else if (field.equals(LATAMREGULATORYPRELIMINARYHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryPreliminaryHUTSelect"), apprType),latamRegApprover);
		}
		else if (field.equals(LATAMREGULATORYFULLHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryFullHUTSelect"), apprType), latamRegApprover);
		}

		// EMEA REGULATORY
		String emeaRegApprover = getUserFullName("EMEARegulatoryApprover");
		if (field.equals(EMEAREGULATORYFULL)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryFullSelect"), apprType), emeaRegApprover);
		}
		else if (field.equals(EMEAREGULATORYPRELIMINARY)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryPreliminarySelect"), apprType),emeaRegApprover);
		}
		else if (field.equals(EMEAREGULATORYPRELIMINARYHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryPreliminaryHUTSelect"), apprType),emeaRegApprover);
		} 
		else if (field.equals(EMEAREGULATORYFULLHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryFullHUTSelect"), apprType), emeaRegApprover);
		}
		else if (field.equals(RMCADMIN))
		{
			applicationUtils.scrollToElement(properties.getProperty("RMCAdminSelect"));
			applicationUtils.selectbyVisibletext(properties.getProperty("RMCAdminSelect"), getUserFullName("RMCuser"));
		}
		else if (field.equals(LEGAL)) 
		{
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("SpanWithSelect"), LEGAL),getUserFullName("LegalApprover"));
		} 
		else if (field.equals(ENVIRONMENTALASSESSMENT)) 
		{
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("SpanWithSelect"), ENVIRONMENTALASSESSMENT),getUserFullName("EnvironmentalAssessmentApprover"));
		}
	}

	public boolean verifyCommentrationalefield(String value)
	{
		boolean flag=false;
		if(value.equals("Not Mandatory"))
		{
			if(!(applicationUtils.isElementPresent(properties.getProperty("Commentsrationale"))))
			{
				flag=true;
			}
		}
		else
		{
			if(applicationUtils.isElementPresent(properties.getProperty("Commentsrationale")))
			{
				flag=true;
			}
		}

		return flag;
	}

	public void deselectApproverOnApproverrequest(String field) 
	{
		String apprType;
		if (field.equals(TOXICOLOGYCLINICALSAFETYPRELIMINARY) || field.equals(TOXICOLOGYCLINICALSAFETYFULL)) 
		{
			apprType = field.split(" ")[field.split(" ").length - 1];
			applicationUtils.scrollToElement(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeCheckbox"), apprType));
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeCheckbox"), apprType));
		} 
		else if (field.equals(TOXICOLOGYCLINICALSAFETYPRELIMINARYHUT) || field.equals(TOXICOLOGYCLINICALSAFETYFULLHUT)) 
		{
			apprType = field.split(" ")[field.split(" ").length - 1];
			applicationUtils.scrollToElement(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeCheckbox"), apprType));
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeCheckbox"), apprType));
		}

		// RD APPROVER
		if (field.equals(RDFULL)||field.equals(RDPRELIMINARY)) 
		{
			apprType = field.split(" ")[field.split(" ").length - 1];
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("RDTypeCheckBox"), apprType));
		}
		
		// APAC REGULATORY
		if (field.equals(APACREGULATORYFULL)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("RegionRegulatoryFullCheckBox"), apprType));
		}
		else if (field.equals(APACREGULATORYPRELIMINARY)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("RegionRegulatoryPreliminaryCheckBox"), apprType));
		}
		else if (field.equals(APACREGULATORYPRELIMINARYHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("RegionRegulatoryPreliminaryHUTCheckBox"), apprType));
		}
		else if (field.equals(APACREGULATORYFULLHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("RegionRegulatoryFullHUTCheckBox"), apprType));
		}

		// NA REGULATORY
		if (field.equals(NAREGULATORYFULL)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("RegionRegulatoryFullCheckBox"), apprType));
		} 
		else if (field.equals(NAREGULATORYPRELIMINARY)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("RegionRegulatoryPreliminaryCheckBox"), apprType));
		} 
		else if (field.equals(NAREGULATORYPRELIMINARYHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("RegionRegulatoryPreliminaryHUTCheckBox"), apprType));
		}
		else if (field.equals(NAREGULATORYFULLHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("RegionRegulatoryFullHUTCheckBox"), apprType));
		}

		// LATAM REGULATORY
		if (field.equals(LATAMREGULATORYFULL)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("RegionRegulatoryFullCheckBox"), apprType));
		}
		else if (field.equals(LATAMREGULATORYPRELIMINARY)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("RegionRegulatoryPreliminaryCheckBox"), apprType));
		}
		else if (field.equals(LATAMREGULATORYPRELIMINARYHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("RegionRegulatoryPreliminaryHUTCheckBox"), apprType));
		}
		else if (field.equals(LATAMREGULATORYFULLHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("RegionRegulatoryFullHUTCheckBox"), apprType));
		}

		// EMEA REGULATORY
		if (field.equals(EMEAREGULATORYFULL)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("RegionRegulatoryFullCheckBox"), apprType));
		} 
		else if (field.equals(EMEAREGULATORYPRELIMINARY)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("RegionRegulatoryPreliminaryCheckBox"), apprType));
		} 
		else if (field.equals(EMEAREGULATORYPRELIMINARYHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("RegionRegulatoryPreliminaryHUTCheckBox"), apprType));
		} 
		else if (field.equals(EMEAREGULATORYFULLHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("RegionRegulatoryFullHUTCheckBox"), apprType));
		} 
		else if (field.equals(RMCADMIN)) 
		{
			applicationUtils.unSelectCheckBox(properties.getProperty("RMCAdminCheckBox"));
		} 
		else if (field.equals(LEGAL)) 
		{
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("SpanWithInput"),LEGAL));
		} 
		else if (field.equals(ENVIRONMENTALASSESSMENT)) 
		{
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("SpanContainsTextWithInput"),ENVIRONMENTALASSESSMENT));
		}
	}
	
	public void SelectOptionForapproverOnApproverrequest(String field,String value) 
	{
		String apprType;
		if (field.equals(TOXICOLOGYCLINICALSAFETYPRELIMINARY) || field.equals(TOXICOLOGYCLINICALSAFETYFULL)) 
		{
			apprType = field.split(" ")[field.split(" ").length - 1];
			applicationUtils.scrollToElement(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeSelect"), apprType));
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeSelect"), apprType),value);
		} 
		else if (field.equals(TOXICOLOGYCLINICALSAFETYPRELIMINARYHUT) || field.equals(TOXICOLOGYCLINICALSAFETYFULLHUT)) 
		{
			apprType = field.split(" ")[field.split(" ").length - 1];
			applicationUtils.scrollToElement(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeSelect"), apprType));
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("ToxicologyClinicalSafetyTypeSelect"), apprType),value);
		}

		// RD APPROVER
		if (field.equals(RDFULL)||field.equals(RDPRELIMINARY)) 
		{
			apprType = field.split(" ")[field.split(" ").length - 1];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RDTypeSelect"), apprType),value);
		}

		// APAC REGULATORY
		if (field.equals(APACREGULATORYFULL)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryFullSelect"), apprType), value);
		}
		else if (field.equals(APACREGULATORYPRELIMINARY)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryPreliminarySelect"), apprType),value);
		}
		else if (field.equals(APACREGULATORYPRELIMINARYHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryPreliminaryHUTSelect"), apprType),value);
		}
		else if (field.equals(APACREGULATORYFULLHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryFullHUTSelect"), apprType), value);
		}

		// NA REGULATORY
		if (field.equals(NAREGULATORYFULL)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryFullSelect"), apprType), value);
		} 
		else if (field.equals(NAREGULATORYPRELIMINARY)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryPreliminarySelect"), apprType),value);
		} 
		else if (field.equals(NAREGULATORYPRELIMINARYHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryPreliminaryHUTSelect"), apprType),value);
		}
		else if (field.equals(NAREGULATORYFULLHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryFullHUTSelect"), apprType), value);
		}

		// LATAM REGULATORY
		if (field.equals(LATAMREGULATORYFULL)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryFullSelect"), apprType), value);
		}
		else if (field.equals(LATAMREGULATORYPRELIMINARY)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryPreliminarySelect"), apprType),value);
		}
		else if (field.equals(LATAMREGULATORYPRELIMINARYHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryPreliminaryHUTSelect"), apprType),value);
		}
		else if (field.equals(LATAMREGULATORYFULLHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryFullHUTSelect"), apprType), value);
		}

		// EMEA REGULATORY
		if (field.equals(EMEAREGULATORYFULL)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryFullSelect"), apprType), value);
		} 
		else if (field.equals(EMEAREGULATORYPRELIMINARY)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryPreliminarySelect"), apprType),value);
		} 
		else if (field.equals(EMEAREGULATORYPRELIMINARYHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("RegionRegulatoryPreliminaryHUTCheckBox"), apprType));
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryPreliminaryHUTSelect"), apprType),value);
		} 
		else if (field.equals(EMEAREGULATORYFULLHUT)) 
		{
			apprType = field.split(" ")[0];
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryFullHUTSelect"), apprType), value);
		} 
		else if (field.equals(RMCADMIN)) 
		{
			applicationUtils.selectbyVisibletext(properties.getProperty("RMCAdminSelect"), value);
		} 
		else if (field.equals(LEGAL)) 
		{
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("SpanWithSelect"), LEGAL),value);
		} 
		else if (field.equals(ENVIRONMENTALASSESSMENT)) 
		{
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("SpanWithSelect"), ENVIRONMENTALASSESSMENT),value);
		}
	}

	public boolean verifyUnselectedapprover(String field)
	{
		String apprType;
		boolean flag=false;
		if(field.equals(RDPRELIMINARY)||field.equals(RDFULL)) 
		{
			apprType = field.split(" ")[field.split(" ").length - 1];
			if(applicationUtils.isElementSelected(String.format(properties.getProperty("RDTypeCheckBox"), apprType))) 
			{
				flag=true;
			}
		}

		return flag;
	}

	public void selectApproverCheckBox(String field) 
	{	
		String apprType;
		if(field.equals(RMCADMIN)) 
		{
			applicationUtils.selectCheckBox(properties.getProperty("RMCAdminCheckBox"));
		}else if(field.equals(RDPRELIMINARY)||field.equals(RDFULL)) 
		{
			apprType = field.split(" ")[field.split(" ").length - 1];
			applicationUtils.selectCheckBox(String.format(properties.getProperty("RDTypeCheckBox"), apprType));
		}
	}

	public boolean verifySelectedapproverOnRightPane(String field) 
	{
		if(applicationUtils.isElementPresent(String.format(properties.getProperty("SpanText"), field))) {
			return true;		
		}

		return false;
	}
	
	public void entervalue(String field) 
	{
		applicationUtils.enterText(String.format(properties.getProperty("SpanWithInput"), field),applicationUtils.getRandomName() );
	}
	
	public boolean verifySelectedApproverOnRightPane(String rmcstatus,String field) {
		boolean flag=false;
		List<WebElement> checkboxselected=driver.findElements(By.xpath(properties.getProperty("SelectedApproverCheckBox")));
		List<String> selectedcheckboxdata=new ArrayList<>();
		List<WebElement> obtainedapproverlist=driver.findElements(By.xpath(properties.getProperty("ApproverNeededList")));
		if(rmcstatus.equals(RMCSTATUS))
		{
			selectedcheckboxdata.add(RMCFORMULAEXCEPTION);
		}
		else
		{}
		for(int i=0;i<checkboxselected.size();i++)
		{
			if(checkboxselected.get(i).isSelected())
			{
				int count = i+1;
				String elementxpath=properties.getProperty("SelectedApproverList")+ "[" + count + "]";
				selectedcheckboxdata.add(applicationUtils.getText(elementxpath));
			}
		}
		flag=applicationUtils.dataVerification(selectedcheckboxdata,obtainedapproverlist);
		return flag;
	}

	public void uncheckrequiredapprovers(String approver)
	{
		switch(approver)
		{
		case "Toxicology/Clinical Safety Full/HUT*":
		case "Toxicology/Clinical Safety Preliminary/HUT*":
			String[] requiredapprover= approver.split("/");
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("SelectedApproverCheckBox"), requiredapprover[0]));
			break;

		case "APAC Regulatory Preliminary/HUT*":
		case "EMEA Regulatory Preliminary/HUT*":
			String[] approverrequired= approver.split("/");
			String[] region=approverrequired[0].split(" ");
			applicationUtils.unSelectCheckBox(String.format(properties.getProperty("SelectedApproverCheckBox"), region[0]));
			break;

		default:
			throw new java.lang.UnsupportedOperationException("Not supported.");
		}
	}

	public void selectuncehckedapprovers(String value,String approver)
	{
		switch(approver)
		{
		case "Toxicology/Clinical Safety Full/HUT*":
		case "Toxicology/Clinical Safety Preliminary/HUT*":
			applicationUtils.selectbyVisibletext(properties.getProperty("ToxicologyDropDown"),value);
			break;

		case "APAC Regulatory Preliminary/HUT*":
		case "EMEA Regulatory Preliminary/HUT*":
			String[] approverrequired= approver.split("/");
			String[] region=approverrequired[0].split(" ");
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("RegionRegulatoryDropDown"), region[0]),value);
			break;

		default:
			throw new java.lang.UnsupportedOperationException("Not supported.");

		}
	}
	
	public void entersubsectiondata(String subsection, String approvaltype ) throws ParseException
	{
		switch(subsection)
		{
		case "Data Required":
			enterdatarequiredsubsection(approvaltype);
			break;

		case "Inputs":
			enterinputssubsection(approvaltype);
			break;

		default:
			throw new java.lang.UnsupportedOperationException("Not supported yet.");
		}
	}
	
	public void searchforexistingFMLIDInCommonApprovals(String type)
	{
		applicationUtils.enterText(properties.getProperty("SearchTextField_CAM"),getFMLid(type));
		applicationUtils.moveToElementClick(properties.getProperty("SearchIcon_CAM"));
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.idleTime(2000);
	}
	
	public String getFMLid(String formulatype)
	{
		String elementid="";
		applicationUtils.clickOnElement(properties.getProperty("Duedate"));
		List<WebElement> allid=driver.findElements(By.xpath(properties.getProperty("AllFMLid")));
		for (WebElement element : allid) 
		{
			elementid=element.getText().trim();
			if(formulatype.equals("Formula")) 
			{
				if(elementid.startsWith(properties.getProperty("Formula")))
				{
					break;
				}
			}
			else if(formulatype.equals("Formula - Custom Workflow"))
			{
				if(elementid.startsWith(properties.getProperty("FormulaCustomWorkflow")))
				{
					break;
				}
			}
			else if(formulatype.equals("Tablet"))
			{
				if(elementid.startsWith(properties.getProperty("Tablet")))
				{
					break;
				}
			}
			else if(formulatype.equals("PED Formula"))
			{
				if(elementid.startsWith(properties.getProperty("PEDFormula")))
				{
					break;
				}
			}
			else if(formulatype.equals("PED Tablet"))
			{
				if(elementid.startsWith(properties.getProperty("PEDTablet")))
				{
					break;
				}
			}
		}
		
		return elementid;
	}
	
	public boolean verifyDatacannotbeModified(String tabname)
	{
		boolean flag=false;
		if(tabname.equals(COMPOSITION)||tabname.equals(ATTRIBUTE)||tabname.equals(PROPERTIES)||tabname.equals(COMPLETEDAPPROVALS)||tabname.equals(CHEMICALCOMPOSITION))
		{
			if(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(String.format(properties.getProperty("ButtonText"), "Edit")))))
			{
				flag=true;
			}
		}
		else
		{
			throw new NotSupportedException(tabname + "is not available");
		}
		
		return flag;
	}
	
	public boolean verifyDatacannotbeDeleted(String tabname)
	{
		boolean flag=false;
		if(tabname.equals(COMPOSITION)||tabname.equals(ATTRIBUTE)||tabname.equals(PROPERTIES)||tabname.equals(COMPLETEDAPPROVALS)||tabname.equals(CHEMICALCOMPOSITION))
		{
			if(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(properties.getProperty("RemoveButton")))))
			{
				flag=true;
			}
		}
		else
		{
			throw new NotSupportedException(tabname + "is not available");
		}
		
		return flag;
	}
	
	public void clickonTabInGXPApproval(String tabname)
	{
		applicationUtils.clickOnElement(String.format(properties.getProperty("ListItemText"), tabname));
	}
	
	
	public void entervalueOnRevisionWindow(String revisionname)
	{
		if(revisionname.equals(REQUESTREVISION))
		{
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("SpanWithSelect"), properties.getProperty("Requestrevion")),properties.getProperty("RequestRevisionValue"));
			applicationUtils.enterText(String.format(properties.getProperty("RMCExceptionComments"), properties.getProperty("RequestMessage")),properties.getProperty("RMCExceptionCommentsData"));
		}
		else if(revisionname.equals(RESOLVEREVISION))
		{
			applicationUtils.enterText(String.format(properties.getProperty("RMCExceptionComments"), properties.getProperty("ResolutionSummary")),properties.getProperty("RMCExceptionCommentsData"));
		}
		else
		{
			throw new NotSupportedException(revisionname + "is not available");
		}
	}
}