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

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.opennms.karaf.licencemgr.GeneratedKeys;
import org.opennms.karaf.licencemgr.metadata.Licence;
import org.opennms.karaf.licencemgr.metadata.jaxb.LicenceMetadata;
import org.opennms.karaf.licencemgr.metadata.jaxb.OptionMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LicenceTest {
	private static final Logger LOG = LoggerFactory.getLogger(LicenceTest.class);
	
	/*
	 * test data - (generated using TestEncodeDecodeLicenceComplete)
	 * @Test AgenerateKeys() aesSecretKeyStr=0A66FB8BB04432B7E3DE8F28CE283888
	 * @Test generateKeys() publicKeyStr=895fc6bf25d559d5ff83d6dee4862b60abed6d56bd79957a8525a116e8755e7f807dcc6aaa489df0264872c42152237e2cc5a4a9e812882ecb65b5db0ccec27fe7a7d717997e64452d85db0dbef1636f317fb95e8229f4b813929b5442494efa402bd7252710de3ca21d9c0ed5cfaddaaa1914a2361ccd28690ab14cc9853d1d366c8d802c0bd61468b36f32d47fb2361a6ac7531ad8be465080d2b7cfee69f7cafbaf46c37ef9818dfd9586f1d18a388546add7d3ad1fcb0b206887aaff08e7fd8b1250d3e5dcc01cdaea43037fbc2345450233fce14eb938fbbd7fbaa23009fa4d5945835a9e46e1f34e5f5f682a52648902ee97595ba7880820ea6c058921-10001
	 * @Test generateKeys() privateKeyEnryptedStr=B7C017FAC106801C852A5687E26F03839C585E702C4DFA597C324EFBB8875A94D4A3B2D0DB9C777FD51D1393E7E56703516A42F21BAE247F7CEB3E7DE2B38128F517AD5F29D0CF2832DC14D87F810E6CAC238787E7165BFF06CC89676B33B451D6B7FECAEC34DDE468E114C42D4790AFC18589D4E354B62BD598D508871E4D12CB9223C5ADCA8DA58E396E7F8B599838AAB2A1ACDAC8266A9DC8D2716266BF16DC3CE8E51BB511A6ADBB2E1ED32710ECFFE496FF9419DA53ABF3A19A6ADE0F062C3754B81190C0BE11DA1D683D2B7FAAE6870BAABEB5A23ECA9417370B8EA7CC96B67613FA3179FE16E9BE1F774CFAA0402D5197633370C326F179450C3C35B7107AA9E945008E9CCD60783EBBE2E156336F90B6CE3D26F82A343FB90150923B20A462C8F091DE3F87CACB1A53048A738353C36A8D8776B4DAF9B0AD17D717B12BB6D15F1F348118D43D6A8EB5AA7C26A573A0C90C260E611AC992336EF15AA83A91FEA3456DFAE21DAF903E5B6E79E434271E7F9852BAD6F6C4EFE8945E1ECE5BAD43D0B2CE19F2BFD5C910284FF1FB62D1F06C21A728BCC341DCC5AEB475BE8D64B0157364834798231DA38146285844E8C9A8C51766927FB1EACC4F73A6440E0ABC1D3706CF5AA7B56F3060C19C1B39DA6F345903B9A556D44C31D09FD2147F2DDBB8F4049C4D5AFAC62D0E94D0C949040191BC53E928D2D730BC850502E53ED82072D91AA5E179C77E50575863DE5AD4D2CE198C6E8AFF5FF6AE270B72ECA294AF1EA407087DF84424D790055A785CDCE4F7939C5FA9A429E031E84A9FAB4C8CEC90C01258A63BECBE55F9D589A1F611E77C5CF36FD48F208A5C716A7C16468ECD855E7D6F22EECADBEE1BD11F354E8903B4C2EEF3D7FBB0FAF3858B0ADF423EC12A8A147C9C8551594D0CD439B3D1F733F7D2DB1811E9A2BBFBE3ABFBB3BA316863145B0A8703BB96D4440267E46A182C87E4CC1C458071DE92C07BD77FBDCD6B0A8823F8DE464A034CE07F0A49477042C85E98BA3D71185E01B038CA5072F2CFC1DD3C4ADF55C050F6DA8003787E78110091D201B2557AA111247008CF37B2A2A41C5513D61DC397BE869083D544F8D5565D8D07663487CC6D302FF908AB472EE3A2085BB8B2FEA966A5CA12CABD517A10AD42FFC9EC2FB6B8AA138466C1277352FC6381606553DE1DF58C31EE54CD809FBE9045E6A7C68FFDDE5571132D7095B65CFA8A76A0639D7EC22F9E91F9D85799CF117C57D97A97CA780E47BC1488FECA6BF8DE1D2C06C1FB44960FA59CCA0B8B1895E22791EA339703C78FAB6D92D1B865438D15CD1C1B865A3F9A5F216BC2FA96BDF5F83A01F1D4C28F36C420913B309DA614F66B65916C6A5677A52B15F6BDD8433C6822038CEF6C0E8F435FD1FEFE8661345AC6067E95BB04347C2636113E94413FEBAF605305BC32DE85AA4960775D48DAB12ECACE950D001E2C2A5D93D0ECE20CD523CBDCDBDD715F0E
	 * @Test BencodeLicence LicenceStringPlusCrc=3C3F786D6C2076657273696F6E3D22312E302220656E636F64696E673D225554462D3822207374616E64616C6F6E653D22796573223F3E3C4C6963656E63654D657461646174613E3C70726F6475637449643E6F72672E6F70656E6E6D732F6F72672E6F70656E6E6D732E6B617261662E6C6963656E63656D616E616765722E7465737462756E646C652F312E302D534E415053484F543C2F70726F6475637449643E3C6C697363656E6365653E4D722043726169672047616C6C656E3C2F6C697363656E6365653E3C6C697363656E636F723E4F70656E4E4D5320554B3C2F6C697363656E636F723E3C73797374656D49643E346164373261333465333633356331622D39396461333332333C2F73797374656D49643E3C7374617274446174653E323031342D31322D33305431313A32383A34332E3533305A3C2F7374617274446174653E3C657870697279446174653E323031342D31322D33305431313A32383A34332E3533305A3C2F657870697279446174653E3C6F7074696F6E733E3C6F7074696F6E3E3C6465736372697074696F6E3E7468697320697320746865206465736372697074696F6E3C2F6465736372697074696F6E3E3C6E616D653E6E65776E616D653C2F6E616D653E3C76616C75653E6E657776616C75653C2F76616C75653E3C2F6F7074696F6E3E3C2F6F7074696F6E733E3C2F4C6963656E63654D657461646174613E:4DAA51FB2F1E96D2ECDB1D23A7F2BF15C5FB39F6504E70DF93B4771CA85DF7E23A6E34CB1546315C60CCB771853E5261566E75D0460BAA6B9E71A459344CF3EEDBC485C4810CB1EA31949F486226200017EEA2EE466283CF1A5685864FAC4773AB6053E57BAC709121B03D1524EB1CA2676AFE6FA8A38A6C21B0939DC6AF34C6502951C8CB762800DB3BACA8819998D588EE68B63491A939CBC54A5761D078F4FBAB0477BCB49FB12D27E9427BA8E5748AAF1A9477B5F4C519D7F4CACBD3F57E4273A371ECD0A93D526B20E07C5318167FFEA64B1374F24D03B1739B429E773F343C21CD96A6BABDBC54516413F65532E738C97348BAE289E0BB3126FB58B1E2:0A66FB8BB04432B7E3DE8F28CE283888-851217b7
	 */
//	private static final String aesSecretKeyStr="0A66FB8BB04432B7E3DE8F28CE283888";
//	private static final String privateKeyEnryptedStr="B7C017FAC106801C852A5687E26F03839C585E702C4DFA597C324EFBB8875A94D4A3B2D0DB9C777FD51D1393E7E56703516A42F21BAE247F7CEB3E7DE2B38128F517AD5F29D0CF2832DC14D87F810E6CAC238787E7165BFF06CC89676B33B451D6B7FECAEC34DDE468E114C42D4790AFC18589D4E354B62BD598D508871E4D12CB9223C5ADCA8DA58E396E7F8B599838AAB2A1ACDAC8266A9DC8D2716266BF16DC3CE8E51BB511A6ADBB2E1ED32710ECFFE496FF9419DA53ABF3A19A6ADE0F062C3754B81190C0BE11DA1D683D2B7FAAE6870BAABEB5A23ECA9417370B8EA7CC96B67613FA3179FE16E9BE1F774CFAA0402D5197633370C326F179450C3C35B7107AA9E945008E9CCD60783EBBE2E156336F90B6CE3D26F82A343FB90150923B20A462C8F091DE3F87CACB1A53048A738353C36A8D8776B4DAF9B0AD17D717B12BB6D15F1F348118D43D6A8EB5AA7C26A573A0C90C260E611AC992336EF15AA83A91FEA3456DFAE21DAF903E5B6E79E434271E7F9852BAD6F6C4EFE8945E1ECE5BAD43D0B2CE19F2BFD5C910284FF1FB62D1F06C21A728BCC341DCC5AEB475BE8D64B0157364834798231DA38146285844E8C9A8C51766927FB1EACC4F73A6440E0ABC1D3706CF5AA7B56F3060C19C1B39DA6F345903B9A556D44C31D09FD2147F2DDBB8F4049C4D5AFAC62D0E94D0C949040191BC53E928D2D730BC850502E53ED82072D91AA5E179C77E50575863DE5AD4D2CE198C6E8AFF5FF6AE270B72ECA294AF1EA407087DF84424D790055A785CDCE4F7939C5FA9A429E031E84A9FAB4C8CEC90C01258A63BECBE55F9D589A1F611E77C5CF36FD48F208A5C716A7C16468ECD855E7D6F22EECADBEE1BD11F354E8903B4C2EEF3D7FBB0FAF3858B0ADF423EC12A8A147C9C8551594D0CD439B3D1F733F7D2DB1811E9A2BBFBE3ABFBB3BA316863145B0A8703BB96D4440267E46A182C87E4CC1C458071DE92C07BD77FBDCD6B0A8823F8DE464A034CE07F0A49477042C85E98BA3D71185E01B038CA5072F2CFC1DD3C4ADF55C050F6DA8003787E78110091D201B2557AA111247008CF37B2A2A41C5513D61DC397BE869083D544F8D5565D8D07663487CC6D302FF908AB472EE3A2085BB8B2FEA966A5CA12CABD517A10AD42FFC9EC2FB6B8AA138466C1277352FC6381606553DE1DF58C31EE54CD809FBE9045E6A7C68FFDDE5571132D7095B65CFA8A76A0639D7EC22F9E91F9D85799CF117C57D97A97CA780E47BC1488FECA6BF8DE1D2C06C1FB44960FA59CCA0B8B1895E22791EA339703C78FAB6D92D1B865438D15CD1C1B865A3F9A5F216BC2FA96BDF5F83A01F1D4C28F36C420913B309DA614F66B65916C6A5677A52B15F6BDD8433C6822038CEF6C0E8F435FD1FEFE8661345AC6067E95BB04347C2636113E94413FEBAF605305BC32DE85AA4960775D48DAB12ECACE950D001E2C2A5D93D0ECE20CD523CBDCDBDD715F0E";
//	private static final String publicKeyStr="895fc6bf25d559d5ff83d6dee4862b60abed6d56bd79957a8525a116e8755e7f807dcc6aaa489df0264872c42152237e2cc5a4a9e812882ecb65b5db0ccec27fe7a7d717997e64452d85db0dbef1636f317fb95e8229f4b813929b5442494efa402bd7252710de3ca21d9c0ed5cfaddaaa1914a2361ccd28690ab14cc9853d1d366c8d802c0bd61468b36f32d47fb2361a6ac7531ad8be465080d2b7cfee69f7cafbaf46c37ef9818dfd9586f1d18a388546add7d3ad1fcb0b206887aaff08e7fd8b1250d3e5dcc01cdaea43037fbc2345450233fce14eb938fbbd7fbaa23009fa4d5945835a9e46e1f34e5f5f682a52648902ee97595ba7880820ea6c058921-10001";
//	private static final String licenceStringPlusCrc="3C3F786D6C2076657273696F6E3D22312E302220656E636F64696E673D225554462D3822207374616E64616C6F6E653D22796573223F3E3C4C6963656E63654D657461646174613E3C70726F6475637449643E6F72672E6F70656E6E6D732F6F72672E6F70656E6E6D732E6B617261662E6C6963656E63656D616E616765722E7465737462756E646C652F312E302D534E415053484F543C2F70726F6475637449643E3C6C697363656E6365653E4D722043726169672047616C6C656E3C2F6C697363656E6365653E3C6C697363656E636F723E4F70656E4E4D5320554B3C2F6C697363656E636F723E3C73797374656D49643E346164373261333465333633356331622D39396461333332333C2F73797374656D49643E3C7374617274446174653E323031342D31322D33305431313A32383A34332E3533305A3C2F7374617274446174653E3C657870697279446174653E323031342D31322D33305431313A32383A34332E3533305A3C2F657870697279446174653E3C6F7074696F6E733E3C6F7074696F6E3E3C6465736372697074696F6E3E7468697320697320746865206465736372697074696F6E3C2F6465736372697074696F6E3E3C6E616D653E6E65776E616D653C2F6E616D653E3C76616C75653E6E657776616C75653C2F76616C75653E3C2F6F7074696F6E3E3C2F6F7074696F6E733E3C2F4C6963656E63654D657461646174613E:4DAA51FB2F1E96D2ECDB1D23A7F2BF15C5FB39F6504E70DF93B4771CA85DF7E23A6E34CB1546315C60CCB771853E5261566E75D0460BAA6B9E71A459344CF3EEDBC485C4810CB1EA31949F486226200017EEA2EE466283CF1A5685864FAC4773AB6053E57BAC709121B03D1524EB1CA2676AFE6FA8A38A6C21B0939DC6AF34C6502951C8CB762800DB3BACA8819998D588EE68B63491A939CBC54A5761D078F4FBAB0477BCB49FB12D27E9427BA8E5748AAF1A9477B5F4C519D7F4CACBD3F57E4273A371ECD0A93D526B20E07C5318167FFEA64B1374F24D03B1739B429E773F343C21CD96A6BABDBC54516413F65532E738C97348BAE289E0BB3126FB58B1E2:0A66FB8BB04432B7E3DE8F28CE283888-851217b7";

	private static String aesSecretKeyStr=null;
	private static String privateKeyEnryptedStr=null;
	private static String publicKeyStr=null;
	private static String privateKeyStr=null;

	@Test 
	public void testLicence(){

		LOG.debug("@Test testLicence Start");
		
		GeneratedKeys generatedKeys = new GeneratedKeys();
		aesSecretKeyStr=generatedKeys.getAesSecretKeyStr();
		privateKeyEnryptedStr=generatedKeys.getPrivateKeyEnryptedStr();
		privateKeyStr=generatedKeys.getPrivateKeyStr();
		publicKeyStr=generatedKeys.getPublicKeyStr();
		
		LOG.debug("@Test testLicence aesSecretKeyStr="+aesSecretKeyStr);
		LOG.debug("@Test testLicence privateKeyStr="+privateKeyStr);
		LOG.debug("@Test testLicence privateKeyEnryptedStr="+privateKeyEnryptedStr);
		LOG.debug("@Test testLicence publicKeyStrr="+publicKeyStr);
		
		// create licence metadata
		LicenceMetadata createLicenceMetadata = new LicenceMetadata();

		createLicenceMetadata.setExpiryDate(new Date());
		createLicenceMetadata.setStartDate(new Date());
		createLicenceMetadata.setLicensee("Mr Craig Gallen");
		createLicenceMetadata.setLicensor("OpenNMS UK");
		createLicenceMetadata.setProductId("org.opennms/org.opennms.karaf.licencemanager.testbundle/1.0-SNAPSHOT");
		createLicenceMetadata.setFeatureRepository("mvn:org.opennms.licencemgr/licence.manager.example/2.10.0/xml/features");
		
		createLicenceMetadata.setMaxSizeSystemIds("1");
		createLicenceMetadata.getSystemIds().add("4ad72a34e3635c1b-99da3323");


		OptionMetadata option1 = new OptionMetadata("newname", "newvalue", "this is the description");
		createLicenceMetadata.getOptions().add(option1);

		// create new licence
		Licence licence = new Licence(createLicenceMetadata, publicKeyStr, aesSecretKeyStr, null);
		String licenceStrPlusCrc = licence.getLicenceStrPlusCrc();
		LOG.debug("@Test testLicence licenceStrPlusCrc="+licenceStrPlusCrc);
		
		// get metadata from licence		
		LicenceMetadata licenceManagerLicenceMetadata;
		try {
			licenceManagerLicenceMetadata = Licence.getUnverifiedMetadata(licenceStrPlusCrc);
		} catch (Exception e) {
			throw new RuntimeException("cannot decode licence string",e);
		}
		
		// check that metadata matches original
		String metadata2xml=licenceManagerLicenceMetadata.toXml();
		String metadataxml=createLicenceMetadata.toXml();
		assertEquals(metadata2xml,metadataxml);
		
		// also testing that equals works
		assertEquals(licenceManagerLicenceMetadata,createLicenceMetadata);
		
		// test decode licence
		Licence receivedLicence=new Licence(licenceStrPlusCrc, privateKeyEnryptedStr);
		LicenceMetadata receivedLicenceMetadata = receivedLicence.getLicenceMetadata();
		assertEquals(receivedLicenceMetadata,createLicenceMetadata);
		
		// check that metadata matches original
		String receivedLicenceMetadataxml=receivedLicenceMetadata.toXml();
		assertEquals(receivedLicenceMetadataxml,metadataxml);
		
		LOG.debug("@Test testLicence receivedLicenceMetadataxml="+receivedLicenceMetadataxml);
		LOG.debug("@Test testLicence receivedLicenceMetadata.getProductId()="+receivedLicenceMetadata.getProductId());
		LOG.debug("@Test testLicence receivedLicenceMetadata.getMaxSizeSystemIds()="+receivedLicenceMetadata.getMaxSizeSystemIds());
		
		String msgStr="@Test testLicence receivedLicenceMetadata.getSystemIds() contains ";
		for (String systemId :receivedLicenceMetadata.getSystemIds() ){
			msgStr=msgStr+"'"+systemId+"'  ";
		}
		LOG.debug(msgStr);
		
		
		LOG.debug("@Test testLicence End");
	}
	
	
	@Test 
	public void testExpiryDate() throws Exception{

		LOG.debug("@Test testExpiryDate Start");
		
		SimpleDateFormat sdfmt = new SimpleDateFormat("dd/MM/yyyy");
		
		Date startDate = sdfmt.parse("15/10/2016");
		LOG.debug("startDate="+sdfmt.format( startDate));
		
		Date expiryDate = sdfmt.parse("14/10/2017");
		LOG.debug("expiryDate="+sdfmt.format( expiryDate));
		
		Date currentDate = sdfmt.parse("14/7/2017");
		LOG.debug("currentDate="+sdfmt.format( currentDate));
		
		
		// generating licence keys
		GeneratedKeys generatedKeys = new GeneratedKeys();
		aesSecretKeyStr=generatedKeys.getAesSecretKeyStr();
		privateKeyEnryptedStr=generatedKeys.getPrivateKeyEnryptedStr();
		privateKeyStr=generatedKeys.getPrivateKeyStr();
		publicKeyStr=generatedKeys.getPublicKeyStr();
		
		LOG.debug("@Test testExpiryDate aesSecretKeyStr="+aesSecretKeyStr);
		LOG.debug("@Test testExpiryDate privateKeyStr="+privateKeyStr);
		LOG.debug("@Test testExpiryDate privateKeyEnryptedStr="+privateKeyEnryptedStr);
		LOG.debug("@Test testExpiryDate publicKeyStrr="+publicKeyStr);
		
		// create licence metadata
		LicenceMetadata createLicenceMetadata = new LicenceMetadata();
		
		createLicenceMetadata.setLicensee("Mr Craig Gallen");
		createLicenceMetadata.setLicensor("OpenNMS UK");
		createLicenceMetadata.setProductId("org.opennms/org.opennms.karaf.licencemanager.testbundle/1.0-SNAPSHOT");
		createLicenceMetadata.setFeatureRepository("mvn:org.opennms.licencemgr/licence.manager.example/2.10.0/xml/features");
		
		createLicenceMetadata.setMaxSizeSystemIds("1");
		createLicenceMetadata.getSystemIds().add("4ad72a34e3635c1b-99da3323");

		OptionMetadata option1 = new OptionMetadata("newname", "newvalue", "this is the description");
		createLicenceMetadata.getOptions().add(option1);
		
		// *****************************************************
		// test create new licence with start and expiry dates set
		createLicenceMetadata.setExpiryDate(expiryDate);
		createLicenceMetadata.setStartDate(startDate);

		Licence licence = new Licence(createLicenceMetadata, publicKeyStr, aesSecretKeyStr, null);
		String licenceStrPlusCrc = licence.getLicenceStrPlusCrc();
		LOG.debug("@Test testExpiryDate licenceStrPlusCrc="+licenceStrPlusCrc);
		
		Date calculatedExpiry=null;
		Long daysToExpiry=null;
		
		try {
			calculatedExpiry = Licence.calculateExpiryDate(licenceStrPlusCrc);
			daysToExpiry = Licence.daysToExpiry(licenceStrPlusCrc,currentDate);
		} catch (Exception e) {
			throw new RuntimeException("cannot decode licence string",e);
		}
		
		LOG.debug("@Test testExpiryDate start and expiry dates calculatedExpiry: "+((calculatedExpiry==null) ? "null": sdfmt.format(calculatedExpiry)));
		LOG.debug("@Test testExpiryDate start and expiry dates daysToExpiry: "+((daysToExpiry==null) ? "": daysToExpiry));
		
		assertNotNull(calculatedExpiry);
		assertEquals(daysToExpiry,Long.valueOf(92));
		
		// *****************************************************
		// test create new licence with start and duration 0 set
		createLicenceMetadata.setExpiryDate(expiryDate);
		createLicenceMetadata.setStartDate(startDate);
		createLicenceMetadata.setDuration("0");

		licence = new Licence(createLicenceMetadata, publicKeyStr, aesSecretKeyStr, null);
		licenceStrPlusCrc = licence.getLicenceStrPlusCrc();
		LOG.debug("@Test testExpiryDate licenceStrPlusCrc="+licenceStrPlusCrc);
		
		try {
			calculatedExpiry = Licence.calculateExpiryDate(licenceStrPlusCrc);
			daysToExpiry = Licence.daysToExpiry(licenceStrPlusCrc,currentDate);
		} catch (Exception e) {
			throw new RuntimeException("cannot decode licence string",e);
		}
		
     	LOG.debug("@Test testExpiryDate start and duration 0 set calculatedExpiry: "+ ((calculatedExpiry==null) ? "null": sdfmt.format(calculatedExpiry)));
		LOG.debug("@Test testExpiryDate start and duration 0 set daysToExpiry: "+ ((daysToExpiry==null) ? "null": daysToExpiry));
		
		assertNull(calculatedExpiry);
		assertNull(daysToExpiry);
		// *****************************************************
		// test create new licence with start and duration set
		createLicenceMetadata.setExpiryDate(null);
		createLicenceMetadata.setStartDate(startDate);
		createLicenceMetadata.setDuration("365");

		licence = new Licence(createLicenceMetadata, publicKeyStr, aesSecretKeyStr, null);
		licenceStrPlusCrc = licence.getLicenceStrPlusCrc();
		LOG.debug("@Test testExpiryDate licenceStrPlusCrc="+licenceStrPlusCrc);
		
		try {
			calculatedExpiry = Licence.calculateExpiryDate(licenceStrPlusCrc);
			daysToExpiry = Licence.daysToExpiry(licenceStrPlusCrc,currentDate);
		} catch (Exception e) {
			throw new RuntimeException("cannot decode licence string",e);
		}
		
		LOG.debug("@Test testExpiryDate start and duration set calculatedExpiry: "+((calculatedExpiry==null) ? "null": sdfmt.format(calculatedExpiry)));
		LOG.debug("@Test testExpiryDate start and duration set daysToExpiry: "+((daysToExpiry==null) ? "": daysToExpiry));
		
		assertNotNull(calculatedExpiry);
		assertEquals(Long.valueOf(93),daysToExpiry);
		
		// *****************************************************
		// test create new licence with start and duration set so long expired
		createLicenceMetadata.setExpiryDate(null);
		createLicenceMetadata.setStartDate(startDate);
		createLicenceMetadata.setDuration("30");

		licence = new Licence(createLicenceMetadata, publicKeyStr, aesSecretKeyStr, null);
		licenceStrPlusCrc = licence.getLicenceStrPlusCrc();
		LOG.debug("@Test testExpiryDate licenceStrPlusCrc="+licenceStrPlusCrc);
		
		try {
			calculatedExpiry = Licence.calculateExpiryDate(licenceStrPlusCrc);
			daysToExpiry = Licence.daysToExpiry(licenceStrPlusCrc,currentDate);
		} catch (Exception e) {
			throw new RuntimeException("cannot decode licence string",e);
		}
		
		LOG.debug("@Test testExpiryDate start and duration set long expired calculatedExpiry: "+((calculatedExpiry==null) ? "null": sdfmt.format(calculatedExpiry)));
		LOG.debug("@Test testExpiryDate start and duration set long expired daysToExpiry: "+((daysToExpiry==null) ? "": daysToExpiry));
		
		assertNotNull(calculatedExpiry);
		assertEquals(Long.valueOf(-241),daysToExpiry);
		
		LOG.debug("@Test testExpiryDate End");
	}
}
