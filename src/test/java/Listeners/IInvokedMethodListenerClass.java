package Listeners;

import Utilites.LogsUtils;
import Utilites.Utility;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import static DriverFactory.DriverFactory.getDriver;

public class IInvokedMethodListenerClass  implements IInvokedMethodListener {
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context){

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        if (testResult.getStatus()==ITestResult.FAILURE)
            LogsUtils.info("test Case "+ testResult.getName()+ " failed ");
        Utility.takeScreenShot(getDriver(),testResult.getName());



    }
}
