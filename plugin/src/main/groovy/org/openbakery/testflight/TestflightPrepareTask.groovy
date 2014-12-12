/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openbakery.testflight

import org.gradle.api.tasks.TaskAction
import org.openbakery.AbstractDistributeTask

class TestFlightPrepareTask extends AbstractDistributeTask {

	TestFlightPrepareTask() {
		super()
		dependsOn("package")
		this.description = "Prepare the app bundle and dSYM to publish with using testflight"
	}


	@TaskAction
	def archive() {
		copyIpaToDirectory(project.testflight.outputDirectory)
		copyDsymToDirectory(project.testflight.outputDirectory)
		createDsymZip(project.testflight.outputDirectory)
	}
}
