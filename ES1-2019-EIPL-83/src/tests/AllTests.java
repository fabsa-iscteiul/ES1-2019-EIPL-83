package tests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith((JUnitPlatform.class))
@SelectClasses({  MethodTest.class, RuleTest.class })
public class AllTests {

}

