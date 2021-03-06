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

package org.opennms.karaf.featuremgr.cmd;

import jline.internal.Log;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.opennms.karaf.featuremgr.PluginFeatureManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Command(scope = "plugin-feature-mgr", name = "scheduleManifestDownload", description="Lists or sets parameters for schedulling automatic manifest download. With no options existing paramaters are listed.")
public class SetScheduleManifestDownloadCommand extends OsgiCommandSupport {
	private static final Logger LOG = LoggerFactory.getLogger(SetScheduleManifestDownloadCommand.class);

	private PluginFeatureManagerService _pluginFeatureManagerService;

	public PluginFeatureManagerService getPluginFeatureManagerService() {
		return _pluginFeatureManagerService;
	}

	public void setPluginFeatureManagerService( PluginFeatureManagerService pluginFeatureManager) {
		_pluginFeatureManagerService = pluginFeatureManager;
	}
	
	@Option(name = "-e", aliases =  "--enableRemotePluginManagers", description = "(true or false) If true, will try to download manifest feature list from remote urls", required = false, multiValued = false)
	String useRemotePluginManagersStr;
	
	@Option(name = "-i", aliases =  "--retryInterval", description = "(integer ms) Interval before retrying unsuccessful download of manifests ", required = false, multiValued = false)
	String retryIntervalStr;
	
	@Option(name = "-r", aliases =  "--retryNumber", description = "(integer) unsuccessful number of retrys -1 = forever until successful", required = false, multiValued = false)
	String retryNumberStr;
	
	@Option(name = "-u", aliases =  "--updateInterval", description = "(integer ms) long term update interval before attempting to reload config. -1= only try on startup", required = false, multiValued = false)
	String updateIntervalStr;

	@Override
	protected Object doExecute() throws Exception {
		try{
			Boolean useRemotePluginManagers =  (useRemotePluginManagersStr==null || "".equals(useRemotePluginManagersStr)) ? null : Boolean.parseBoolean(useRemotePluginManagersStr);
			Integer retryInterval= (retryIntervalStr==null || "".equals(retryIntervalStr)) ? null : Integer.parseInt(retryIntervalStr);
			Integer retryNumber= (retryNumberStr==null || "".equals(retryNumberStr)) ? null : Integer.parseInt(retryNumberStr);
			Integer updateInterval = (updateIntervalStr==null || "".equals(updateIntervalStr)) ? null : Integer.parseInt(updateIntervalStr);
			
			String schedule = getPluginFeatureManagerService().updateSchedule(useRemotePluginManagers, retryInterval, retryNumber, updateInterval);;

			String msg="manifest schedule command result: "+schedule;
			LOG.info(msg);
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("error updating manifest schedule. Exception="+e);
			LOG.error("error updating manifest schedule. Exception=",e);
		}
		return null;
	}
}