package tests;

import java.util.logging.Handler;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith((JUnitPlatform.class))
@SelectClasses({  MethodTest.class, RuleTest.class,MethodTest.class,Handler.class,PrecisionTest.class ,ReadExcelTest.class,MyActionListenerTest.class })
public class AllTests {

}

