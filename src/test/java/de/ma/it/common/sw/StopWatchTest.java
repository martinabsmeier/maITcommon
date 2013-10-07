package de.ma.it.common.sw;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StopWatchTest {

	private StopWatch sw;
	
	@Before
	public void setUp() throws Exception {
		this.sw = new StopWatch();
	}

	@After
	public void tearDown() throws Exception {
		this.sw = null;
	}

	@Test
	public void testStartException() {
		try {
			this.sw.start("TestTask1");
			this.sw.start("TestTask2");
			Assert.fail("IllegalStateException expected !");
		} catch (IllegalStateException ex) {
			Assert.assertTrue(ex instanceof IllegalStateException);
		}
	}

	@Test
	public void testStopException() {
		try {
			this.sw.stop();
			Assert.fail("IllegalStateException expected !");
		} catch (IllegalStateException ex) {
			Assert.assertTrue(ex instanceof IllegalStateException);
		}
	}

	@Test
	public void testStopWatch() {
		try {
			this.sw.start("TestTask1");
			Thread.sleep(565);
			this.sw.stop();
			this.sw.start("TestTask2");
			Thread.sleep(798);
			this.sw.stop();
			System.out.println(this.sw.prettyPrint());
		} catch (Exception ex) {
			Assert.fail("exception: " + ex.getMessage());
			ex.printStackTrace(System.err);
		}
	}

}
