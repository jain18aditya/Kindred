package com.hellofresh.hooks;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.hellofresh.utils.LoggerUtil;
import com.hellofresh.utils.WebUIUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	public static Logger s_logs = LoggerUtil.logger();

	@Before
	public void beforeScenario(Scenario scene) {
		s_logs.log(Level.INFO, "************Scenario " + scene.getName() + " is started************");
	}

	@After
	public void afterScenario(Scenario scene) {
		s_logs.log(Level.INFO, "Scenario " + scene.getName() + " is: " + scene.getStatus().toUpperCase());
		if (scene.isFailed()) {
			WebUIUtil.captureScreenShot(scene.getName().replace(" ", "") + System.currentTimeMillis());
		}
	}
}
