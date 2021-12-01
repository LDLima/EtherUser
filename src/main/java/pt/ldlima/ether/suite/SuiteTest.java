package pt.ldlima.ether.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import pt.ldlima.ether.tests.MenuTest;
import pt.ldlima.ether.tests.RegistrationTest;

@RunWith(Suite.class)
@SuiteClasses({
	RegistrationTest.class,
	MenuTest.class
})
public class SuiteTest {
	
}
