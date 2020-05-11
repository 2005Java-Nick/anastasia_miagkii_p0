package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import authorization.CloseVoting;
import authorization.Logging;
import authorization.Registration;
import authorization.Welcome;
import file.ReadFile;
import file.SaveVoter;
import logic.AdminPassword;
import logic.VoterLogic;
import menu.AdminMenu;
import menu.Voting;
import voter.Voter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class EVSTesting {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/////////////////////////CREATING OBJECTS////////////////////////////
	
	private static final CloseVoting closeVoting = new CloseVoting();
	private static final Logging logging = new Logging();
	private static final Registration registration = new Registration();
	private static final Welcome welcome = new Welcome();
	
	private static final ReadFile readFile = new ReadFile();
	private static final SaveVoter saveVoter = new SaveVoter();
	
	private static final AdminPassword adminPassword = new AdminPassword();
	private static final VoterLogic voterLogic = new VoterLogic();
	
	private static final AdminMenu adminMenu = new AdminMenu();
	private static final Voting voting = new Voting();
	private static final Voter voter = new Voter();
	

	/////////////////////////////////////TESTING/////////////////////////////////////
	
	
	////EXAMPLE////
	//	@Test
	//	public void testAWord() {
	//		assertEquals("tobor", evaluationService.reverse("robot"));
	//	}
	
	
	@Test
	public void testAgeUnder18() throws ParseException {
		assertEquals(false, voterLogic.CalculateAge("2010/01/01"));
	}
	
	@Test
	public void testAgeAbove18() throws ParseException {
		assertEquals(true, voterLogic.CalculateAge("1980/01/01"));
	}
	
	@Test
	public void testAgeIs18() throws ParseException {
		assertEquals(true, voterLogic.CalculateAge("2002/05/11"));
	}
	
	@Test
	public void checkIdLengthMoreThanFive() {
		assertEquals(false, voterLogic.IdLength("1234567"));
	}
	
	@Test
	public void checkIdLengthLessThanFive() {
		assertEquals(false, voterLogic.IdLength("1234"));
	}
	
	@Test
	public void checkIdContainsDigits() {
		assertEquals(false, voterLogic.IdLength("ABCDE"));
	}
	
	@Test
	public void checkIdLengthIsFive() {
		assertEquals(true, voterLogic.IdLength("12345"));
	}
	
	@Test
	public void doesNotHaveSpace() {
		assertEquals(false, voterLogic.hasSpace("Anastasia"));
	}
	
	@Test
	public void doesHaveSpace() {
		assertEquals(true, voterLogic.hasSpace("Anastasia Miagkii"));
	}
	
	@Test
	public void isAdmin() {
		assertEquals(true, voterLogic.checkAdmin("admin"));
	}
	
	@Test
	public void isNotAdmin() {
		assertEquals(false, voterLogic.checkAdmin("Anastasia"));
	}

}
