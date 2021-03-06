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

package org.opennms.karaf.licencemgr.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.opennms.karaf.licencemgr.metadata.jaxb.LicenceMetadata;
import org.opennms.karaf.licencemgr.metadata.jaxb.LicenceMetadataList;
import org.opennms.karaf.licencemgr.metadata.jaxb.LicenceSpecification;

@Path("/licence-pub")
public interface LicencePublisherRest {
	
	@POST
	@Path("/addlicencespec")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addLicenceSpec(LicenceSpecification licenceSpec);
	
	
	@GET
	@Path("/removelicencespec")
	@Produces(MediaType.APPLICATION_XML)
	public Response removeLicenceSpec(@QueryParam("productId") String productId);
	
	@GET
	@Path("/getlicencespec")
	@Produces(MediaType.APPLICATION_XML)
	public Response getLicenceSpec(@QueryParam("productId") String productId);
	
	/**
	 * @return licence metadata spec (not the full license spec)
	 */
	@GET
	@Path("/getlicencemetadataspec")
	@Produces(MediaType.APPLICATION_XML)
	public Response getLicenceMetadata(@QueryParam("productId") String productId);
	
	@GET
	@Path("/listspecs")
	@Produces(MediaType.APPLICATION_XML)
	public Response getLicenceSpecList();

	
	/**
	 * @return list of licence metadata specs (not the full license spec)
	 */
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_XML)
	public Response getLicenceMetadataList();
	
	
	@GET
	@Path("/clearlicencespecs")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteLicenceSpecifications(@QueryParam("confirm") String confirm);
	
	
	@POST
	@Path("/createlicence")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response createLicenceInstanceStr(LicenceMetadata licenceMetadata, @Context UriInfo uriInfo);

	@POST
	@Path("/createmultilicence")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response createMultiLicenceInstance(LicenceMetadataList licenceMetadataList, @Context UriInfo uriInfo);
	
}
