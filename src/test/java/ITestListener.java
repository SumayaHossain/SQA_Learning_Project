import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.IOException;

public class ITestListener implements org.testng.ITestListener {
    @Override
    public void onFinish(ITestContext Result){

    }
    @Override
    public void onStart(ITestContext Result){

    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
    {

    }

    //When test case get failed this method is called
    @Override
    public void onTestFailure(ITestResult Result)
    {
        try {
            GetScreenShots.capture(OrangeHRM.driver, Result.getName());
        } catch (IOException e ){
            e.printStackTrace();

        }
        System.out.println("The name of the failed testcase is :" + Result.getName());
    }

    //When test case get skipped this method is called
    @Override
    public void onTestSkipped(ITestResult Result){
        System.out.println("The name of the skipped testcase is :" + Result.getName());
    }
    //When test case get started this method is called
    @Override
    public void onTestStart(ITestResult Result){
        System.out.println(Result.getName()+"test case started");
    }
    //When test case get passed this method is called
    @Override
    public void onTestSuccess(ITestResult Result){
        System.out.println("The name of the testcase passed is :" + Result.getName());
    }

}
