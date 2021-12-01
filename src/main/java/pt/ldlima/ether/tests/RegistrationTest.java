package pt.ldlima.ether.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import pt.ldlima.ether.controllers.RegistrationController;

public class RegistrationTest  extends BaseTest{
	private RegistrationController control;
	
	public RegistrationTest() {
		control = new RegistrationController();
	}
	
	@Before
	public void getFreeOfCookies() {
		control.clickCookies();
	}
	
	@Test
	public void test1_fewCaractersUsername(){
		control.readJSONData("test1");
		control.selectTearmsAndConditionsCheckbox();
		control.clickButtonCreatAccount();
		List<String> errors = control.catchErrors();
		Assert.assertTrue(errors.containsAll(Arrays.asList(
				"Username is invalid."
		)));
	}
	
	@Test
	public void test2_especialCaractersUsername(){
		control.readJSONData("test2");
		control.selectTearmsAndConditionsCheckbox();
		control.clickButtonCreatAccount();
		List<String> errors = control.catchErrors();
		Assert.assertTrue(errors.containsAll(Arrays.asList(
				"Username is invalid."
		)));
	}
	
	@Test
	public void test3_incorretEmail(){
		control.readJSONData("test3");
		control.selectTearmsAndConditionsCheckbox();
		control.clickButtonCreatAccount();
		List<String> errors = control.catchErrors();
		Assert.assertTrue(errors.containsAll(Arrays.asList(
				"Please enter a valid email address."
		)));
	}
	
	@Test
	public void test4_lessPasswordCaracteres(){
		control.readJSONData("test4");
		control.selectTearmsAndConditionsCheckbox();
		control.clickButtonCreatAccount();
		List<String> errors = control.catchErrors();
		Assert.assertTrue(errors.containsAll(Arrays.asList(
				"Your password must be at least 5 characters long."
		)));
	}
	
	@Test
	public void test5_differentPassword(){
		control.readJSONData("test5");
		control.selectTearmsAndConditionsCheckbox();
		List<String> errors = control.catchErrors();
		Assert.assertTrue(errors.containsAll(Arrays.asList(
				"Password does not match, please check again."
		)));
	}
	
	@Test
	public void test6_checkPasswordWeak(){
		control.readJSONData("test6");
		control.selectTearmsAndConditionsCheckbox();
		Assert.assertEquals("Strength: Weak!", control.getPasswordStrengthText());
	}
	
	@Test
	public void test7_checkPasswordMedium(){
		control.readJSONData("test7");
		control.selectTearmsAndConditionsCheckbox();
		Assert.assertEquals("Strength: Medium!", control.getPasswordStrengthText());
	}
	
	@Test
	public void test8_checkPasswordStrong(){
		control.readJSONData("test8");
		control.selectTearmsAndConditionsCheckbox();
		Assert.assertEquals("Strength: Strong!", control.getPasswordStrengthText());
	}
	
	@Test
	public void test9_checkObligatedFields() {
		control.clickButtonCreatAccount();
		List<String> errors = control.catchErrors();
		Assert.assertTrue(errors.containsAll(Arrays.asList(
				"Username is invalid.",
				"Please enter a valid email address.",
				"Your password must be at least 5 characters long.",//Twice
				"Please accept our Terms and Conditions."
		)));//Check if contains it all
		Assert.assertEquals(5, errors.size());//Check if I recieve the number correct and not something more
	}
	
	
	@Test
	public void test10_enterTermsConditionLink(){
		control.viewTermsConditions();
		Assert.assertEquals("Terms of Service", control.getTextTile());//Check if I recieve the number correct and not something more
	}
	
	@Test
	public void test11_enterUnsubscribeNewsletterLink(){
		control.viewUnsubscribeNewsletter();
		Assert.assertEquals("How to Subscribe & Unsubscribe From the Etherscan Newsletter", control.getTextTile());//Check if I recieve the number correct and not something more
	}
	
	@Test
	@Ignore
	public void testFinal_createAccount(){//FIX THE ROBOT
		control.readJSONData("test77");
		control.clickNotARobot();
		control.clickButtonCreatAccount();
	}
}
