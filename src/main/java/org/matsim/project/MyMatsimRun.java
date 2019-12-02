/* *********************************************************************** *
 * project: org.matsim.*												   *
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 * copyright       : (C) 2008 by the members listed in the COPYING,        *
 *                   LICENSE and WARRANTY file.                            *
 * email           : info at matsim dot org                                *
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *   See also COPYING, LICENSE and WARRANTY file                           *
 *                                                                         *
 * *********************************************************************** */
package org.matsim.project;


import org.matsim.api.core.v01.Scenario;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.Controler;
import org.matsim.core.scenario.ScenarioUtils;

import static org.matsim.core.controler.OutputDirectoryHierarchy.OverwriteFileSetting.*;

/**
 * @author billyc
 *
 */
public class MyMatsimRun {
    public static void main(String[] args) {
        // config
	Config config = ConfigUtils.loadConfig("scenarios/equil/config.xml");
	config.controler().setOverwriteFileSetting(deleteDirectoryIfExists);
	config.controler().setLastIteration(2);

	// scenario
	Scenario scenario = ScenarioUtils.loadScenario(config);

	// controler
	Controler controler = new Controler(scenario);
	controler.run();
    }
}
