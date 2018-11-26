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

package org.opennms.features.pluginmgr.vaadin.pluginmanager;

import org.opennms.karaf.licencemgr.metadata.jaxb.ProductMetadata;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.v7.shared.ui.label.ContentMode;
import com.vaadin.v7.ui.CheckBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.v7.ui.HorizontalLayout;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.TextArea;
import com.vaadin.v7.ui.TextField;
import com.vaadin.v7.ui.VerticalLayout;

public class ProductDescriptorPanel extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,5","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private VerticalLayout verticalLayout_2;
	@AutoGenerated
	private TextField organizationTextField;
	@AutoGenerated
	private TextField licenceTypeTextField;
	@AutoGenerated
	private TextField productUrlTextField;
	@AutoGenerated
	private TextArea productDescriptionTextArea;
	@AutoGenerated
	private TextField packageingDescriptorTextField;
	@AutoGenerated
	private TextField featureRepositoryTextField;
	@AutoGenerated
	private TextField productIdTextField;
	@AutoGenerated
	private TextField productNameTextField;
	@AutoGenerated
	private CheckBox systemPluginCheckBox;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private Label licenceAuthenticatedLabel;
	@AutoGenerated
	private Label spacelabel_1;
	@AutoGenerated
	private CheckBox licenceRequiredCheckBox;
	private static final long serialVersionUID = 1L;
	
	private boolean noUpdate=true; // sets field to read only
	
	public boolean getNoUpdate() {
		return noUpdate;
	}

	public void setNoUpdate(boolean noUpdate) {
		this.noUpdate = noUpdate;
	}

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */

	public ProductDescriptorPanel() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// manually add user code here
		
		spacelabel_1.setValue("   ");
		spacelabel_1.setReadOnly(true);
		
		licenceAuthenticatedLabel.setContentMode(ContentMode.HTML);
		licenceAuthenticatedLabel.setValue("");
		
		// set first instance readonly
		productIdTextField.setReadOnly(true);
		productNameTextField.setReadOnly(true);
		featureRepositoryTextField.setReadOnly(true);
		packageingDescriptorTextField.setReadOnly(true);
		licenceTypeTextField.setReadOnly(true);
		organizationTextField.setReadOnly(true);
		productDescriptionTextArea.setReadOnly(true);
		productUrlTextField.setReadOnly(true);
		systemPluginCheckBox.setReadOnly(true);
		licenceRequiredCheckBox.setReadOnly(true);

	}
	
	public synchronized void setProductMetadata(ProductMetadata productMetadata){
		productIdTextField.setReadOnly(false);
		productIdTextField.setValue( (productMetadata.getProductId()==null )?  "":productMetadata.getProductId());
		productIdTextField.setReadOnly(noUpdate);
		
		productNameTextField.setReadOnly(false);
		productNameTextField.setValue( (productMetadata.getProductName()==null )?  "":productMetadata.getProductName());
		productNameTextField.setReadOnly(noUpdate);
		
		featureRepositoryTextField.setReadOnly(false);
		featureRepositoryTextField.setValue(( productMetadata.getFeatureRepository()== null ) ? "": productMetadata.getFeatureRepository());
		featureRepositoryTextField.setReadOnly(noUpdate);

		packageingDescriptorTextField.setReadOnly(false);
		packageingDescriptorTextField.setValue(( productMetadata.getPackageingDescriptor()== null ) ? "": productMetadata.getPackageingDescriptor());
		packageingDescriptorTextField.setReadOnly(noUpdate);
	
		licenceTypeTextField.setReadOnly(false);
		licenceTypeTextField.setValue( (productMetadata.getLicenceType()==null )?  "":productMetadata.getLicenceType());
		licenceTypeTextField.setReadOnly(noUpdate);
		
		organizationTextField.setReadOnly(false);
		organizationTextField.setValue( (productMetadata.getOrganization()==null ) ? "":productMetadata.getOrganization());
		organizationTextField.setReadOnly(noUpdate);
		
		productDescriptionTextArea.setReadOnly(false);
		productDescriptionTextArea.setValue( (productMetadata.getProductDescription()==null ) ? "":productMetadata.getProductDescription());
		productDescriptionTextArea.setReadOnly(noUpdate);
		
		productUrlTextField.setReadOnly(false);
		productUrlTextField.setValue( (productMetadata.getProductUrl()==null ) ? "":productMetadata.getProductUrl());
		productUrlTextField.setReadOnly(noUpdate);

		systemPluginCheckBox.setReadOnly(false);
		systemPluginCheckBox.setValue( (productMetadata.getSystemPlugin()==null ) ? false :productMetadata.getSystemPlugin());
		systemPluginCheckBox.setReadOnly(noUpdate);

		licenceRequiredCheckBox.setReadOnly(false);
		licenceRequiredCheckBox.setValue( (productMetadata.getLicenceKeyRequired()==null ) ? false :productMetadata.getLicenceKeyRequired());
		licenceRequiredCheckBox.setReadOnly(noUpdate);
		
		licenceAuthenticatedLabel.setVisible(false);
		if (productMetadata.getLicenceKeyRequired()!=null && productMetadata.getLicenceKeyRequired()==true){
			// only generate label if licenceKeyAuthenticated is not null
			if (productMetadata.getLicenceKeyAuthenticated()!=null){
				if ( productMetadata.getLicenceKeyAuthenticated()==true ){
					licenceAuthenticatedLabel.setValue("<div style=\"color: green;\">licence is authenticated</div>");
				} else {
					licenceAuthenticatedLabel.setValue("<div style=\"color: red;\">licence is not authenticated</div>");
				}
				licenceAuthenticatedLabel.setVisible(true);
			}

		}
		
	}
	
	public synchronized ProductMetadata getProductMetadata(){

		ProductMetadata productMetadata= new ProductMetadata();

		productMetadata.setProductId(productIdTextField.getValue());

		productMetadata.setProductName(productNameTextField.getValue());

		productMetadata.setFeatureRepository(featureRepositoryTextField.getValue());
		
		productMetadata.setPackageingDescriptor(packageingDescriptorTextField.getValue());

		productMetadata.setLicenceType(licenceTypeTextField.getValue());

		productMetadata.setOrganization(organizationTextField.getValue());

		productMetadata.setProductDescription(productDescriptionTextArea.getValue());

		productMetadata.setProductUrl(productUrlTextField.getValue());

		productMetadata.setLicenceKeyRequired(licenceRequiredCheckBox.getValue());
		
		productMetadata.setSystemPlugin(systemPluginCheckBox.getValue());

		return productMetadata;
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setWidth("15.0cm");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true);
		
		// top-level component properties
		setWidth("10.0cm");
		setHeight("100.0%");
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		mainLayout.addComponent(horizontalLayout_2);
		mainLayout.setExpandRatio(horizontalLayout_2, 1.0f);
		
		return mainLayout;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_2() {
		// common part: create layout
		horizontalLayout_2 = new HorizontalLayout();
		horizontalLayout_2.setWidth("100.0%");
		horizontalLayout_2.setHeight("100.0%");
		horizontalLayout_2.setMargin(false);
		
		// verticalLayout_2
		verticalLayout_2 = buildVerticalLayout_2();
		horizontalLayout_2.addComponent(verticalLayout_2);
		horizontalLayout_2.setExpandRatio(verticalLayout_2, 1.0f);
		
		return horizontalLayout_2;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_2() {
		// common part: create layout
		verticalLayout_2 = new VerticalLayout();
		verticalLayout_2.setWidth("100.0%");
		verticalLayout_2.setHeight("100.0%");
		verticalLayout_2.setMargin(false);
		verticalLayout_2.setSpacing(true);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		verticalLayout_2.addComponent(horizontalLayout_1);
		
		// systemPluginCheckBox
		systemPluginCheckBox = new CheckBox();
		systemPluginCheckBox.setCaption("System Plugin");
		systemPluginCheckBox.setImmediate(true);
		systemPluginCheckBox
				.setDescription("System Plugins cannot be removed by the plugin manager");
		systemPluginCheckBox.setWidth("-1px");
		systemPluginCheckBox.setHeight("-1px");
		verticalLayout_2.addComponent(systemPluginCheckBox);
		
		// productNameTextField
		productNameTextField = new TextField();
		productNameTextField.setCaption("Product Name");
		productNameTextField.setImmediate(true);
		productNameTextField.setWidth("100.0%");
		productNameTextField.setHeight("-1px");
		verticalLayout_2.addComponent(productNameTextField);
		verticalLayout_2.setExpandRatio(productNameTextField, 1.0f);
		
		// productIdTextField
		productIdTextField = new TextField();
		productIdTextField.setCaption("Product Id");
		productIdTextField.setImmediate(true);
		productIdTextField.setWidth("100.0%");
		productIdTextField.setHeight("-1px");
		verticalLayout_2.addComponent(productIdTextField);
		verticalLayout_2.setExpandRatio(productIdTextField, 1.0f);
		
		// featureRepositoryTextField
		featureRepositoryTextField = new TextField();
		featureRepositoryTextField.setCaption("Feature Repository URL");
		featureRepositoryTextField.setImmediate(true);
		featureRepositoryTextField.setWidth("100.0%");
		featureRepositoryTextField.setHeight("-1px");
		verticalLayout_2.addComponent(featureRepositoryTextField);
		verticalLayout_2.setExpandRatio(featureRepositoryTextField, 1.0f);
		
		// packageingDescriptorTextField
		packageingDescriptorTextField = new TextField();
		packageingDescriptorTextField.setCaption("Packaging Descriptor");
		packageingDescriptorTextField.setImmediate(true);
		packageingDescriptorTextField
				.setDescription("Provides a locator for the Karaf kar or rpm which delivered this feature");
		packageingDescriptorTextField.setWidth("100.0%");
		packageingDescriptorTextField.setHeight("-1px");
		verticalLayout_2.addComponent(packageingDescriptorTextField);
		verticalLayout_2.setExpandRatio(packageingDescriptorTextField, 1.0f);
		
		// productDescriptionTextArea
		productDescriptionTextArea = new TextArea();
		productDescriptionTextArea.setCaption("Product Description");
		productDescriptionTextArea.setImmediate(true);
		productDescriptionTextArea.setWidth("100.0%");
		productDescriptionTextArea.setHeight("6.0em");
		verticalLayout_2.addComponent(productDescriptionTextArea);
		verticalLayout_2.setExpandRatio(productDescriptionTextArea, 1.0f);
		
		// productUrlTextField
		productUrlTextField = new TextField();
		productUrlTextField.setCaption("Product URL");
		productUrlTextField.setImmediate(true);
		productUrlTextField.setWidth("100.0%");
		productUrlTextField.setHeight("-1px");
		verticalLayout_2.addComponent(productUrlTextField);
		verticalLayout_2.setExpandRatio(productUrlTextField, 1.0f);
		
		// licenceTypeTextField
		licenceTypeTextField = new TextField();
		licenceTypeTextField.setCaption("Licence Type");
		licenceTypeTextField.setImmediate(true);
		licenceTypeTextField.setWidth("100.0%");
		licenceTypeTextField.setHeight("-1px");
		licenceTypeTextField.setNullSettingAllowed(true);
		verticalLayout_2.addComponent(licenceTypeTextField);
		verticalLayout_2.setExpandRatio(licenceTypeTextField, 1.0f);
		
		// organizationTextField
		organizationTextField = new TextField();
		organizationTextField.setCaption("Organization");
		organizationTextField.setImmediate(true);
		organizationTextField.setWidth("100.0%");
		organizationTextField.setHeight("-1px");
		organizationTextField.setNullSettingAllowed(true);
		verticalLayout_2.addComponent(organizationTextField);
		verticalLayout_2.setExpandRatio(organizationTextField, 1.0f);
		
		return verticalLayout_2;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setWidth("100.0%");
		horizontalLayout_1.setHeight("100.0%");
		horizontalLayout_1.setMargin(false);
		horizontalLayout_1.setSpacing(true);
		
		// licenceRequiredCheckBox
		licenceRequiredCheckBox = new CheckBox();
		licenceRequiredCheckBox.setCaption("Licence Key Required");
		licenceRequiredCheckBox.setDescription("If a Licence Key is required the module will not start without a valid licence installed");
		licenceRequiredCheckBox.setImmediate(true);
		licenceRequiredCheckBox.setWidth("-1px");
		licenceRequiredCheckBox.setHeight("-1px");
		horizontalLayout_1.addComponent(licenceRequiredCheckBox);
		
		// spacelabel_1
		spacelabel_1 = new Label();
		spacelabel_1.setImmediate(false);
		spacelabel_1.setWidth("-1px");
		spacelabel_1.setHeight("-1px");
		spacelabel_1.setValue("Label");
		horizontalLayout_1.addComponent(spacelabel_1);
		horizontalLayout_1.setExpandRatio(spacelabel_1, 1.0f);
		
		// licenceAuthenticatedLabel
		licenceAuthenticatedLabel = new Label();
		licenceAuthenticatedLabel.setImmediate(true);
		licenceAuthenticatedLabel
				.setDescription("State of licence authentication  for the systemId of this karaf instance");
		licenceAuthenticatedLabel.setWidth("-1px");
		licenceAuthenticatedLabel.setHeight("-1px");
		licenceAuthenticatedLabel.setValue("Label");
		horizontalLayout_1.addComponent(licenceAuthenticatedLabel);
		
		return horizontalLayout_1;
	}


}
