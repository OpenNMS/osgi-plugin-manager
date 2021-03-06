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

package org.opennms.karaf.licencemgr.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.opennms.karaf.licencemgr.metadata.jaxb.LicenceMetadata;
import org.opennms.karaf.licencemgr.metadata.jaxb.OptionMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LicenceMetadataTest {
	private static final Logger LOG = LoggerFactory.getLogger(LicenceMetadataTest.class);

	public static LicenceMetadata metadata=null;
	public static String licenceMetadataHexStr=null;
	public static String licenceMetadataHashStr=null;
	
    @Test
    public void LicenceMetadataTestTests(){
    	a_metadataTest();
    	b_metadataTest();
    	c_metadataTest();
    	d_metadataTest();
    	e_metadataTest();
    }
    
    public void a_metadataTest(){
    	LOG.debug("@Test AmetadataTest() Start");
    	metadata=new LicenceMetadata();
    	printMetadata(metadata);
    	LOG.debug("@Test AmetadataTest() End");
    }
    

    public void b_metadataTest(){
    	LOG.debug("@Test BmetadataTest() Start");
    	metadata=new LicenceMetadata();
    	
    	metadata.setExpiryDate(new Date());
    	metadata.setStartDate(new Date());
    	metadata.setLicensee("Mr Craig Gallen");
    	metadata.setLicensor("OpenNMS UK");
    	metadata.setProductId("product id");
    	metadata.setMaxSizeSystemIds("2");
    	metadata.getSystemIds().add("system id");
    	metadata.setFeatureRepository("mvn:org.opennms.licencemgr/licence.manager.example/2.10.0/xml/features");
    	
    	
    	OptionMetadata option1 = new OptionMetadata("newname1", "newvalue1", "this is the description1");
		metadata.getOptions().add(option1);
		
    	OptionMetadata option2 = new OptionMetadata("newname2", "newvalue2", "this is the description2");
		metadata.getOptions().add(option2);
		
		// should add only one instance of each unique object
		metadata.getOptions().add(option1);
		assertEquals (metadata.getOptions().size(),2);
		
    	licenceMetadataHexStr=metadata.toHexString();
    	licenceMetadataHashStr=metadata.sha256Hash();
    	
    	LOG.debug("@Test BmetadataTest() Original Metadata Object");
    	printMetadata(metadata);
    	LOG.debug("@Test BmetadataTest() End");
    }
    
    public void c_metadataTest(){
    	LOG.debug("@Test CmetadataTest() Start");
    	
    	LicenceMetadata newMetadata = new LicenceMetadata();
    	newMetadata.fromHexString(licenceMetadataHexStr);
    	String newHash=newMetadata.sha256Hash();
    	
    	LOG.debug("@Test CmetadataTest() Original Metadata Object");
    	printMetadata(metadata);
    	LOG.debug("@Test CmetadataTest() New Metadata Object");
    	printMetadata(newMetadata);
    	
    	assertEquals(licenceMetadataHashStr,newHash);
    	
    	LOG.debug("@Test CmetadataTest() End");
    }
    
    /**
     * Test of secret properties
     */
    public void d_metadataTest(){
    	LOG.debug("@Test DmetadataTest() Start");
    	metadata=new LicenceMetadata();
    	
    	metadata.setExpiryDate(new Date());
    	metadata.setStartDate(new Date());
    	metadata.setLicensee("Mr Craig Gallen");
    	metadata.setLicensor("OpenNMS UK");
    	metadata.setProductId("product id");
    	metadata.setMaxSizeSystemIds("2");
    	metadata.getSystemIds().add("system id");
    	metadata.setFeatureRepository("mvn:org.opennms.licencemgr/licence.manager.example/2.10.0/xml/features");
    	
    	
    	OptionMetadata option1 = new OptionMetadata("newname1", "newvalue1", "this is the description1");
		metadata.getOptions().add(option1);
		
    	OptionMetadata option2 = new OptionMetadata("newname2", "newvalue2", "this is the description2");
		metadata.getOptions().add(option2);
		
		// should add only one instance of each unique object
		metadata.getOptions().add(option1);
		assertEquals (metadata.getOptions().size(),2);
		
		// secret properties
		OptionMetadata secretProperty1 = new OptionMetadata("secret1", "secret2", "secret metadata1");
		OptionMetadata secretProperty2 = new OptionMetadata("secret2", "secret2", "secret metadata2");
		Set<OptionMetadata> secretProperties = new HashSet<OptionMetadata>();
		secretProperties.add(secretProperty1);
		secretProperties.add(secretProperty2);
		metadata.setSecretProperties(secretProperties);
		
    	licenceMetadataHexStr=metadata.toHexString();
    	licenceMetadataHashStr=metadata.sha256Hash();
    	
    	LOG.debug("@Test DmetadataTest() Original Metadata Object");
    	printMetadata(metadata);
    	LOG.debug("@Test DmetadataTest() End");
    }
    
    public void e_metadataTest(){
    	LOG.debug("@Test EmetadataTest() Start");
    	
    	LicenceMetadata newMetadata = new LicenceMetadata();
    	newMetadata.fromHexString(licenceMetadataHexStr);
    	String newHash=newMetadata.sha256Hash();
    	
    	LOG.debug("@Test EmetadataTest() Original Metadata Object");
    	printMetadata(metadata);
    	LOG.debug("@Test EmetadataTest() New Metadata Object");
    	printMetadata(newMetadata);
    	
    	assertEquals(licenceMetadataHashStr,newHash);
    	
    	LOG.debug("@Test EmetadataTest() End");
    }
    
    
    public void printMetadata(LicenceMetadata metadata){
    	
    	String xml = metadata.toXml();
    	LOG.debug("@Test metadataTest1() MetadataXML="+xml);
    	String MetadataHex = metadata.toHexString();
    	LOG.debug("@Test metadataTest1() MetadataHex="+MetadataHex);
    	String hash = metadata.sha256Hash();
    	LOG.debug("@Test metadataTest1() Metadatasha256Hash="+hash);
    	
    }
    
    
    
    
    
    
}
