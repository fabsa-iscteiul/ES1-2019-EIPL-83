package tests;

import java.util.logging.Handler;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith((JUnitPlatform.class))
@SelectClasses({ WindowTest.class, MethodTest.class, RuleTest.class,MethodTest.class,HandlerTest.class,PrecisionTest.class ,ReadExcelTest.class,MyActionListenerTest.class })
public class AllTests {

}

