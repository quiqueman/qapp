package emgc.qapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppRunnerTest {

	@Test
	void testRun() {
		Application appTest = new DummyApp();
		AppRunner.run(appTest, new String [] {});
		
		fail("Not yet implemented");
	}

}
