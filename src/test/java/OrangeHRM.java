import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

@Listeners (ITestListener.class)

public class OrangeHRM {
    public static WebDriver driver;
    //Upload Video
    //static String BaseURL ="https://spark.adobe.com/tools/resize-video";
    //Upload Photo
    //static String BaseURL ="https://jpg2pdf.com/";
    static String BaseURL ="https://opensource-demo.orangehrmlive.com/";
    //static String BaseURL = "https://opensource-demo.orangehrmlive.com/index.php/pim/viewPhotograph/empNumber/7";
    static JavascriptExecutor js;
    @BeforeTest
    public static void WebSetup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\sqa_course\\Chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BaseURL);
        Thread.sleep(3000);
        Assert.assertTrue((driver.getTitle().contains("OrangeHRM")));
    }

    @Test(priority = 0)
    public static void LandingPageVerification() {

        Assert.assertTrue(driver.getPageSource().contains("LOGIN Panel"));
        //System.out.println("Landing page verified");
    }

    @Test(priority = 1)
    public static void UserLogin() throws Exception {
        MyScreenRecorder.startRecording("");
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        Thread.sleep(3000);
        //System.out.println("Login Succeed");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MyScreenRecorder.stopRecording();
    }

    // @Test(priority = 1)
    public static void UserLoginFailed_Invalid_Name() throws Exception {
        MyScreenRecorder.startRecording("");
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admina");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        Thread.sleep(3000);
        System.out.println("Login Failed");
        MyScreenRecorder.stopRecording();
    }
    //@Test(priority = 1)
    public static void UserLoginFailed_Invalid_Pass() throws Exception {
        MyScreenRecorder.startRecording("");
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("adin13");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        Thread.sleep(3000);
        System.out.println("Login Failed");
        MyScreenRecorder.stopRecording();
    }

    //@Test (priority = 2)
    public static void Admin_Add_Failed() throws Exception {
        MyScreenRecorder.startRecording("");
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
        Thread.sleep(2000);
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='systemUser_userType']")));
        dropdown.selectByValue("1");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']")).sendKeys("fio");
        Thread.sleep(2000);
        Robot r = new Robot();
        int keyCode = KeyEvent.VK_ENTER;
        r.keyPress(keyCode);
        r.keyRelease(keyCode);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='systemUser_userName']")).sendKeys("test.admin");
        Thread.sleep(1000);
        dropdown = new Select(driver.findElement(By.xpath("//select[@id='systemUser_status']")));
        dropdown.selectByValue("1");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='systemUser_password']")).sendKeys("admin123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='systemUser_confirmPassword']")).sendKeys("ad,oml123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Thread.sleep(3000);
        MyScreenRecorder.stopRecording();
    }
    //@Test (priority = 2)
    public static void Admin_Add() throws Exception {
        MyScreenRecorder.startRecording("");
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
        Thread.sleep(2000);
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='systemUser_userType']")));
        dropdown.selectByValue("1");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']")).sendKeys("fio");
        Thread.sleep(2000);
        Robot r = new Robot();
        int keyCode = KeyEvent.VK_ENTER;
        r.keyPress(keyCode);
        r.keyRelease(keyCode);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='systemUser_userName']")).sendKeys("test.admin");
        Thread.sleep(1000);
        dropdown = new Select(driver.findElement(By.xpath("//select[@id='systemUser_status']")));
        dropdown.selectByValue("1");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='systemUser_password']")).sendKeys("ad,oml123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='systemUser_confirmPassword']")).sendKeys("ad,oml123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
        Thread.sleep(5000);
        Assert.assertTrue(driver.getPageSource().contains("test.admin"));
        Thread.sleep(3000);
        MyScreenRecorder.stopRecording();
    }
    //@Test (priority = 2)
    public static void Admin_Delete() throws Exception {
        MyScreenRecorder.startRecording("");
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-900)", "");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='ohrmList_chkSelectRecord_12']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
        Thread.sleep(3000);
        MyScreenRecorder.stopRecording();
    }

    //@Test (priority = 3)
    public static void Admin_Search() throws Exception {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys("Test Admin");
        Thread.sleep(1000);
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='searchSystemUser_userType']")));
        dropdown.selectByValue("2");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='searchSystemUser_employeeName_empName']")).sendKeys("fio");
        Thread.sleep(2000);
        Robot r = new Robot();
        int keyCode = KeyEvent.VK_ENTER;
        r.keyPress(keyCode);
        r.keyRelease(keyCode);
        Thread.sleep(2000);
        dropdown = new Select(driver.findElement(By.xpath("//select[@id='searchSystemUser_status']")));
        dropdown.selectByValue("1");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getPageSource().contains("No Records Found"));
    }

    //@Test (priority = 3)
    public static void Admin_Reset() throws Exception {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys("Test Admin");
        Thread.sleep(1000);
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='searchSystemUser_userType']")));
        dropdown.selectByValue("2");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='searchSystemUser_employeeName_empName']")).sendKeys("fio");
        Thread.sleep(2000);
        Robot r = new Robot();
        int keyCode = KeyEvent.VK_ENTER;
        r.keyPress(keyCode);
        r.keyRelease(keyCode);
        Thread.sleep(2000);
        dropdown = new Select(driver.findElement(By.xpath("//select[@id='searchSystemUser_status']")));
        dropdown.selectByValue("1");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getPageSource().contains("No Records Found"));
        driver.findElement(By.xpath("//input[@id='resetBtn']")).click();
        Thread.sleep(3000);

    }

    //@Test (priority = 2)
    public static void Admin_Job_titles_Add() throws Exception {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//a[@id='menu_admin_Job']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='menu_admin_viewJobTitleList']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='jobTitle_jobTitle']")).sendKeys("Chief Technical Officer");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//textarea[@id='jobTitle_jobDescription']")).sendKeys("Responsible for overseeing the development and dissemination of technology for external customers, vendors, and other clients to help improve and increase business");
        Thread.sleep(2000);
        //Upload a doc file
        WebElement uploadElement = driver.findElement(By.xpath("//input[@id='jobTitle_jobSpec']"));
        uploadElement.sendKeys("D:\\sqa_course\\Jobtitle_CTO.docx");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//textarea[@id='jobTitle_note']")).sendKeys("They may also deal with internal IT operations if a company is small and doesn't have a chief information officer.");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Thread.sleep(3000);

    }
    //@Test (priority = 4)
    public static void Admin_Job_titles_Edit() throws InterruptedException {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//a[@id='menu_admin_Job']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='menu_admin_viewJobTitleList']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Chief Technical Officer')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='jobTitle_jobSpecUpdate_3']")).click();
        Thread.sleep(2000);
        WebElement uploadElement = driver.findElement(By.xpath("//input[@id='jobTitle_jobSpec']"));
        uploadElement.sendKeys("D:\\sqa_course\\CTO_edit.docx");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)", "");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Thread.sleep(2000);
    }
    //@Test (priority = 5)
    public static void Admin_Job_titles_Delete() throws Exception {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//a[@id='menu_admin_Job']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='menu_admin_viewJobTitleList']")).click();
        Thread.sleep(2000);
        //select particular job title
        driver.findElement(By.xpath("//input[@id='ohrmList_chkSelectRecord_33']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
        Thread.sleep(2000);
        //For deleting
        driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
        Thread.sleep(2000);




    }

    //@Test (priority = 2)
    public static void Admin_PayGrades_Add() throws Exception {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//a[@id='menu_admin_Job']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='menu_admin_viewPayGrades']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='payGrade_name']")).sendKeys("Grade 6");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Thread.sleep(1000);
        //Assign Currencies
        driver.findElement(By.xpath("//input[@id='btnAddCurrency']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='payGradeCurrency_currencyName']")).sendKeys("Au");
        Thread.sleep(2000);
        Robot r = new Robot();
        int keyCode = KeyEvent.VK_ENTER;
        r.keyPress(keyCode);
        r.keyRelease(keyCode);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='payGradeCurrency_minSalary']")).sendKeys("20000");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='payGradeCurrency_maxSalary']")).sendKeys("30000");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnSaveCurrency']")).click();
        Thread.sleep(2000);
    }

    //@Test (priority = 2)
    public static void Admin_PayGrades_Edit() throws Exception {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//a[@id='menu_admin_Job']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='menu_admin_viewPayGrades']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Grade 1')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='payGrade_name']")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='payGrade_name']")).sendKeys("Grade 18");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Thread.sleep(1000);
        //Edit Currencies
        driver.findElement(By.xpath("//a[contains(text(),'United States Dollar')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='payGradeCurrency_maxSalary']")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='payGradeCurrency_maxSalary']")).sendKeys("70000");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnSaveCurrency']")).click();
        Thread.sleep(2000);
    }
    //@Test (priority = 2)
    public static void Admin_PayGrades_Edit_Add() throws Exception {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//a[@id='menu_admin_Job']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='menu_admin_viewPayGrades']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Grade 4')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnAddCurrency']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='payGradeCurrency_currencyName']")).sendKeys("AR");
        Robot r = new Robot();
        int keyCode = KeyEvent.VK_ENTER;
        r.keyPress(keyCode);
        r.keyRelease(keyCode);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='payGradeCurrency_minSalary']")).sendKeys("1987954.00");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='payGradeCurrency_maxSalary']")).sendKeys("2981931.00");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnSaveCurrency']")).click();
        Thread.sleep(2000);
    }
    //@Test (priority = 2)
    public static void Admin_PayGrades_Edit_Delete() throws Exception {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//a[@id='menu_admin_Job']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@id='menu_admin_viewPayGrades']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Grade 4')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[3]/div[2]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnDeleteCurrency']")).click();
        Thread.sleep(1000);
    }

    //@Test (priority = 2)
    public static void Admin_PayGrades_Delete() throws Exception {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//a[@id='menu_admin_Job']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='menu_admin_viewPayGrades']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='ohrmList_chkSelectRecord_3']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
        Thread.sleep(2000);
    }
    //Employment Status
    //@Test (priority = 2)
    public static void Admin_EmploymentStatus_Add() throws Exception {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//a[@id='menu_admin_Job']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='menu_admin_employmentStatus']")).click();
        driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
        driver.findElement(By.xpath("//input[@id='empStatus_name']")).sendKeys("Temporary");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Thread.sleep(1000);
    }
    //@Test (priority = 2)
    public static void Admin_EmploymentStatus_Delete() throws Exception {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//a[@id='menu_admin_Job']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='menu_admin_employmentStatus']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='ohrmList_chkSelectRecord_1']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
        Thread.sleep(1000);
    }
    //@Test (priority = 2)
    public static void Admin_EmploymentStatus_Edit() throws Exception {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//a[@id='menu_admin_Job']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='menu_admin_employmentStatus']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Freelance')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='empStatus_name']")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='empStatus_name']")).sendKeys("Freelance Contract");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Thread.sleep(1000);
    }
    //Job Categories
    //@Test (priority = 2)
    public static void Admin_JobCategories_Add() throws Exception {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//a[@id='menu_admin_Job']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='menu_admin_jobCategory']")).click();
        driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
        driver.findElement(By.xpath("//input[@id='jobCategory_name']")).sendKeys("Customer Support");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Thread.sleep(1000);
    }
    //@Test (priority = 2)
    public static void Admin_JobCategories_Delete() throws Exception {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//a[@id='menu_admin_Job']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='menu_admin_jobCategory']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='ohrmList_chkSelectRecord_9']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
        Thread.sleep(1000);
    }
    //@Test (priority = 2)
    public static void Admin_JobCategories_Edit() throws Exception {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//a[@id='menu_admin_Job']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='menu_admin_jobCategory']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Laborers and Helpers')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='jobCategory_name']")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='jobCategory_name']")).sendKeys("Labourer");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Thread.sleep(1000);
    }

    //Work Shifts
    //@Test (priority = 2)
    public static void Admin_WorkShifts_Add() throws Exception {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//a[@id='menu_admin_Job']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='menu_admin_workShift']")).click();
        driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
        driver.findElement(By.xpath("//input[@id='workShift_name']")).sendKeys("Rotating shift");
        //from
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='workShift_workHours_from']")));
        dropdown.selectByValue("09:30");
        Thread.sleep(1000);
        // to
        dropdown = new Select(driver.findElement(By.xpath("//select[@id='workShift_workHours_to']")));
        dropdown.selectByValue("19:30");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//option[contains(text(),'Linda Jane Anderson')]")).click();
        //driver.findElement(By.xpath("//a[@id='btnAssignEmployee']")).click();
        driver.findElement(By.xpath("//option[contains(text(),'Peter Mac Anderson')]")).click();
        driver.findElement(By.xpath("//a[@id='btnAssignEmployee']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Thread.sleep(1000);
    }
    //@Test (priority = 2)
    public static void Admin_WorkShifts_Edit() throws Exception {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//a[@id='menu_admin_Job']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='menu_admin_workShift']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Rotating shift')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='workShift_name']")).clear();
        driver.findElement(By.xpath("//input[@id='workShift_name']")).sendKeys("Rotating Shift Edited");
        Thread.sleep(1000);
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='workShift_workHours_from']")));
        dropdown.selectByValue("08:30");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//option[contains(text(),'Peter Mac Anderson')]")).click();
        driver.findElement(By.xpath("//a[@id='btnRemoveEmployee']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Thread.sleep(1000);
    }
    //@Test (priority = 2)
    public static void Admin_WorkShifts_Delete() throws Exception {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//a[@id='menu_admin_Job']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='menu_admin_workShift']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='ohrmList_chkSelectRecord_3']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
        Thread.sleep(1000);
    }

    /* Admin Page
     * Organization
     */
    //General Information
    @Test (priority = 2)
    public static void Admin_Organization_GeneralInformation_Edit() throws Exception {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//a[@id='menu_admin_Organization']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@id='menu_admin_viewOrganizationGeneralInformation']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnSaveGenInfo']")).click();
        Thread.sleep(1000);
        /*
        driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
        Thread.sleep(1000);
         */

    }
    //Locations
    //@Test (priority = 2)
    public static void Admin_Organization_Locations_Search() throws Exception {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//a[@id='menu_admin_Organization']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@id='menu_admin_viewLocations']")).click();
        Thread.sleep(1000);
    }
    //Structure




    @AfterTest
    public static void TestClosure(){
        driver.quit();
    }
}
