/*
 * Copyright 2014 OpenNMS Group Inc., Entimoss ltd.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opennms.karaf.licencemgr.cmd;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.opennms.karaf.licencemgr.LicenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Command(scope = "licence-mgr", name = "removelicence", description="Removes licence for selected productId")
public class RemoveLicenceCommand extends OsgiCommandSupport {
	private static final Logger LOG = LoggerFactory.getLogger(RemoveLicenceCommand.class);

	private LicenceService _licenceService;

	public LicenceService getLicenceService() {
		return _licenceService;
	}

	public void setLicenceService( LicenceService licenceService) {
		_licenceService = licenceService;
	} 

	@Argument(index = 0, name = "productId", description = "ProductId to remove licence", required = true, multiValued = false)
	String productId = null;

	@Override
	protected Object doExecute() throws Exception {
		try{
			if (getLicenceService().removeLicence(productId)){
				System.out.println("Removed licence for productId=" + productId);
				LOG.info("Removed licence for productId=" + productId);
			}else {
				System.out.println("No licence installed for productId='" + productId+"'");
				LOG.info("No licence installed for productId='" + productId+"'");
			}
		} catch (Exception e) {
			System.err.println("error removing licence for productId. Exception="+e);
			LOG.error("error removing licence for productId. Exception=",e);
		}

		return null;
	}
}