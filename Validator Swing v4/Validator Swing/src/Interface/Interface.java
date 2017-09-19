/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

package Interface;

/*
 * TextSamplerDemo.java requires the following files:
 *   TextSamplerDemoHelp.html (which references images/dukeWaveRed.gif)
 *   images/Pig.gif
 *   images/sound.gif
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import Business.CRM;
import Business.GED;
import Business.Generic;
import Business.NovoAtlas;
import Model.AvailableTechData;
import Model.GedData;

public class Interface extends JPanel
                             implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String CBPtextFieldString = "CBP white list";
    protected static final String CPFCNPJtextFieldString = "CPF/CNPJ";
    protected static final String AddresstextFieldString = "Address ID";
    protected static final String SerialtextFieldString = "Serial Number";
    protected static final String techIdtextFieldString = "Tech Id";
    protected static final String searchAddtextFieldString = "Search Addresses";
    protected static final String EMTA2D20C1 = "EMTA:2:D2.0:C1:";
    protected static final String EMTA2D30C8W = "EMTA:2:D3.0:C8:W";
    protected static final String EMTA2D20C1W = "EMTA:2:D2.0:C1:W";
    protected static final String SMARTCARD = "SMART CARD";
    protected static final String DigitalSTBSD1 = "DigitalSTB:SD:1";
    protected static final String DigitalSTBHD1 = "DigitalSTB:HD:1";
    protected static final String DigitalSTBHDDVR1 = "DigitalSTB:HDDVR:1";
    //added 2T and 3P
	protected static final String DigitalSTB2T = "DigitalSTB:2T:1";
    protected static final String Digital3PHD1 = "3P:HD:1:D3.0:F2.X:W";  
    protected static final String Digital3PHD2 = "3P:HD:2:D3.0:F5.X:W";  
    protected static final String buttonString = "JButton";
    protected static final String envComboBoxChanged = "envComboBoxChanged";
    protected static final String equipmentQuantityComboBoxChanged = "equipmentQuantityComboBoxChanged";
    protected static final String help = "help";
    protected JTextField textField;
    protected JTextField addresstextField;
    protected JTextField serialtextField;
    protected JTextField techIdtextField;
    protected JTextField cbptextField;
    protected JLabel actionLabel;
    protected JTextArea textArea;
    protected JRadioButton EMTA2D20C1radio;
    protected JRadioButton EMTA2D30C8Wradio;
    protected JRadioButton EMTA2D20C1Wradio;
    protected JRadioButton SMARTCARDradio;
    protected JRadioButton DigitalSTBSD1radio;
    protected JRadioButton DigitalSTBHD1radio;
    protected JRadioButton DigitalSTBHDDVR1radio;
    protected JRadioButton DigitalSTB2Tradio;
    protected JRadioButton Digital3PHD1radio;
    protected JRadioButton Digital3PHD2radio;
    protected JComboBox envComboBox;
    protected JComboBox equipmentQuantityComboBox;
    protected JComboBox addressesQuantityComboBox;
    protected JComboBox codeNodeComboBox;
    protected String env = "Env A";
    protected JLabel envLabel;

    @SuppressWarnings("unchecked")
	public Interface() throws Exception {
        setLayout(new BorderLayout());
        
      //Create equipments combo box quantity
        String[] equipmentQuantityString = {"1", "2-10","11-20","21-50","51-100"};
        equipmentQuantityComboBox = new JComboBox(equipmentQuantityString);
        equipmentQuantityComboBox.setPreferredSize(new Dimension(60, 30));
        equipmentQuantityComboBox.addActionListener(this);
        JLabel equipmentQuantityLabel = new JLabel("Select desired quantity: ");
        
        // Create addresses combo box quantity
        String[] addressesQuantityString = {"1", "5","10","15","20"};
        addressesQuantityComboBox = new JComboBox(addressesQuantityString);
        addressesQuantityComboBox.setPreferredSize(new Dimension(60, 30));
        addressesQuantityComboBox.addActionListener(this);
        JLabel addressesQuantityLabel = new JLabel("Select desired quantity: ");
        
        // Code Node combo box quantity
        String[] codeNodeString = {"B", "C","G"};
        codeNodeComboBox = new JComboBox(codeNodeString);
        codeNodeComboBox.setPreferredSize(new Dimension(60, 30));
        codeNodeComboBox.addActionListener(this);
        JLabel codeNodeLabel = new JLabel("Select code node: ");        
        
        
        //Create info labels
        JLabel versionLabel = new JLabel("   Validator program for NET project v1.1 - Created by Thiago Alves Pinto");
        envLabel = new JLabel("        |       Validator Working on " + env + " and FVT3.9     ");
        
        //Create environment combo box
        String[] envStrings = {"Env A","Env B", "Env C", "Env T03", "Env T06", "Env T01"};
        envComboBox = new JComboBox(envStrings);
        envComboBox.setPreferredSize(new Dimension(60, 30));
        envComboBox.setActionCommand(envComboBoxChanged);
        envComboBox.addActionListener(this);
        JLabel envSelectionLabel = new JLabel("Select desired environment: ");
        
        //Radio buttons for equipment
        EMTA2D20C1radio = new JRadioButton(EMTA2D20C1);
        EMTA2D30C8Wradio = new JRadioButton(EMTA2D30C8W);
        EMTA2D20C1Wradio = new JRadioButton(EMTA2D20C1W);
        SMARTCARDradio = new JRadioButton(SMARTCARD);
        DigitalSTBSD1radio = new JRadioButton(DigitalSTBSD1);
        DigitalSTBHD1radio = new JRadioButton(DigitalSTBHD1);
        DigitalSTBHDDVR1radio = new JRadioButton(DigitalSTBHDDVR1);
        DigitalSTB2Tradio = new JRadioButton(DigitalSTB2T);
        Digital3PHD1radio = new JRadioButton(Digital3PHD1);
        Digital3PHD2radio = new JRadioButton(Digital3PHD2);
      //Create CPF/CNPJ text field.
        cbptextField = new JTextField(10);
        
        //Create CPF/CNPJ text field.
        textField = new JTextField(10);
        //JTextField textField = new JTextField(10);
        //textField.setActionCommand(CPFCNPJtextFieldString);
        //textField.addActionListener(this);
    
        //Create serial number text field.
        //serialtextField = new JTextField(10);
        //JTextField textField = new JTextField(10);
        //textField.setActionCommand(CPFCNPJtextFieldString);
        //textField.addActionListener(this);

      //Create Address ID text field.
        addresstextField = new JTextField(10);
        //JTextField addresstextField = new JTextField(10);
       // textField.setActionCommand(AddresstextFieldString);
       // textField.addActionListener(this);
        
        //Create Tech ID text field.
        techIdtextField = new JTextField(10);
        
        //Create some labels for the fields.
        JLabel textFieldLabel = new JLabel(CPFCNPJtextFieldString + ": ");
        textFieldLabel.setLabelFor(textField);
        JLabel addresstextFieldLabel = new JLabel(AddresstextFieldString + ": ");
        addresstextFieldLabel.setLabelFor(addresstextField);
        //JLabel serialtextFieldLabel = new JLabel(SerialtextFieldString + ": ");
        //serialtextFieldLabel.setLabelFor(serialtextField);
        JLabel techIdtextFieldLabel = new JLabel(techIdtextFieldString + ": ");
        techIdtextFieldLabel.setLabelFor(techIdtextField);
        JLabel cbptextFieldLabel = new JLabel(CBPtextFieldString + ": ");
        cbptextFieldLabel.setLabelFor(techIdtextField);
        
        //Button for help
        JButton helpButton = new JButton("Help");
        helpButton.setActionCommand(help);
        helpButton.addActionListener(this);
        
      //Create buttons for CPB white list search action
        JButton cbpButton = new JButton("Check CBP white list details");
        cbpButton.setActionCommand(CBPtextFieldString);
        cbpButton.addActionListener(this);
        
        //Create buttons for CPF CNPJ search action
        JButton cpfButton = new JButton("          Check CPN/CNPJ   	     ");
        cpfButton.setActionCommand(CPFCNPJtextFieldString);
        cpfButton.addActionListener(this);
        
        //Create buttons for address search action        
        JButton addressButton = new JButton("          Check Address ID        ");
        addressButton.setActionCommand(AddresstextFieldString);
        addressButton.addActionListener(this);
       
        //Create buttons for serial validation        
        //JButton serialButton = new JButton("      Check Serial Number      ");
        //serialButton.setActionCommand(SerialtextFieldString);
        //serialButton.addActionListener(this);
       
        /*
        //Create buttons for EMTA2D20C1 check        
        JButton EMTA2D20C1button = new JButton("             EMTA2D20C1            ");
        EMTA2D20C1button.setActionCommand(EMTA2D20C1);
        EMTA2D20C1button.addActionListener(this);
        
        //Create buttons for EMTA2D30C8W check        
        JButton EMTA2D30C8Wbutton = new JButton("          EMTA2D30C8W           ");
        EMTA2D30C8Wbutton.setActionCommand(EMTA2D30C8W);
        EMTA2D30C8Wbutton.addActionListener(this);
        
        //Create buttons for EMTA2D20C1W check        
        JButton EMTA2D20C1Wbutton = new JButton("          EMTA2D20C1W           ");
        EMTA2D20C1Wbutton.setActionCommand(EMTA2D20C1W);
        EMTA2D20C1Wbutton.addActionListener(this);
        
        //Create buttons for SMARTCARD check        
        JButton SMARTCARDbutton = new JButton("             SMARTCARD             ");
        SMARTCARDbutton.setActionCommand(SMARTCARD);
        SMARTCARDbutton.addActionListener(this);
        
        //Create buttons for DigitalSTBSD1 check        
        JButton DigitalSTBSD1button = new JButton("            DigitalSTBSD1           ");
        DigitalSTBSD1button.setActionCommand(DigitalSTBSD1);
        DigitalSTBSD1button.addActionListener(this);
        
        //Create buttons for DigitalSTBSD1 check        
        JButton DigitalSTBHD1button = new JButton("             DigitalSTBHD1          ");
        DigitalSTBHD1button.setActionCommand(DigitalSTBHD1);
        DigitalSTBHD1button.addActionListener(this);
        
        //Create buttons for DigitalSTBSD1 check        
        JButton DigitalSTBHDDVR1button = new JButton("        DigitalSTBHDDVR1       ");
        DigitalSTBHDDVR1button.setActionCommand(DigitalSTBHDDVR1);
        DigitalSTBHDDVR1button.addActionListener(this);
        */
        
      //Create buttons for Tech Id equipment validation        
        JButton techIdButton = new JButton("Check equips. for TechId");
        techIdButton.setActionCommand(techIdtextFieldString);
        techIdButton.addActionListener(this);

        //Create buttons for Tech Id equipment validation        
        JButton addressButtonSearch = new JButton("Check available addresses");
        addressButtonSearch.setActionCommand(searchAddtextFieldString);
        addressButtonSearch.addActionListener(this);
        
      //Lay out the text controls and the labels.
        JPanel textControlsPane = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        
        JPanel radioControlPane = new JPanel();
        JPanel radioControlAddPane = new JPanel();
        
        GridBagLayout gridbagRight = new GridBagLayout();
        GridBagConstraints cRight = new GridBagConstraints();

        JPanel envPane = new JPanel();
        GridBagLayout gridbagLeftTop = new GridBagLayout();
        //GridBagConstraints cLeftTop = new GridBagConstraints();
        
        textControlsPane.setLayout(gridbag);
        radioControlPane.setLayout(gridbagRight);
        radioControlAddPane.setLayout(gridbagRight);
        envPane.setLayout(gridbagLeftTop);
        textControlsPane.setPreferredSize(new Dimension(500, 400));
        radioControlPane.setPreferredSize(new Dimension(500, 450));
        radioControlAddPane.setPreferredSize(new Dimension(200, 100));
        envPane.setPreferredSize(new Dimension(100,100));
        
        JLabel[] labels = {textFieldLabel, addresstextFieldLabel, cbptextFieldLabel, techIdtextFieldLabel};
        JTextField[] textFields = {textField, addresstextField, cbptextField, techIdtextField};
        JButton[] buttons = {cpfButton, addressButton, cbpButton, techIdButton,addressButtonSearch};
        //JButton[] buttonsEquip = {EMTA2D20C1button, EMTA2D30C8Wbutton, EMTA2D20C1Wbutton, SMARTCARDbutton, DigitalSTBSD1button, DigitalSTBHD1button, DigitalSTBHDDVR1button};
        JRadioButton[] radios = {EMTA2D20C1radio, EMTA2D30C8Wradio,EMTA2D20C1Wradio, SMARTCARDradio, DigitalSTBSD1radio,  DigitalSTBHD1radio, DigitalSTBHDDVR1radio, DigitalSTB2Tradio, Digital3PHD1radio, Digital3PHD2radio};
        addLabelTextRows(labels, textFields, gridbag, textControlsPane, buttons);
        addRadio(techIdtextFieldLabel, techIdtextField, techIdButton, radios, gridbagRight, radioControlPane, equipmentQuantityLabel, equipmentQuantityComboBox);
        
        addRadio2(techIdtextFieldLabel, techIdtextField, addressButtonSearch, radios, gridbagRight, radioControlAddPane, addressesQuantityLabel, addressesQuantityComboBox, codeNodeLabel, codeNodeComboBox);
        
        addComboBoxs(envSelectionLabel, envComboBox, gridbag, envPane);
        
        c.gridwidth = GridBagConstraints.REMAINDER; //last
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1.0;
      
        cRight.gridwidth = GridBagConstraints.REMAINDER; //last
        cRight.anchor = GridBagConstraints.EAST;
        cRight.weightx = 1.0;
        
        textControlsPane.setBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Check your customer data"),
                                BorderFactory.createEmptyBorder(5,5,5,5)));

        radioControlPane.setBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Search your equipment"),
                                BorderFactory.createEmptyBorder(5,5,5,5)));        
        radioControlAddPane.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Search address"),
                        BorderFactory.createEmptyBorder(5,5,5,5)));
        
        envPane.setBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Select the environment"),
                                BorderFactory.createEmptyBorder(5,5,5,5)));

        //Create a text area.
        textArea = new JTextArea("...");
        textArea.setFont(new Font("Serif", Font.BOLD, 12));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane areaScrollPane = new JScrollPane(textArea);
        areaScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(300, 300));
        areaScrollPane.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Results"),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                areaScrollPane.getBorder()));

        //Put everything together.
        JPanel leftPane = new JPanel(new BorderLayout());
        JPanel rightPane = new JPanel(new BorderLayout());
        JPanel centerPane = new JPanel(new BorderLayout());
        JPanel bottonPane = new JPanel(new BorderLayout());
        
        leftPane.add(envPane, 
                BorderLayout.PAGE_START);
        leftPane.add(textControlsPane, 
                     BorderLayout.CENTER);
        leftPane.add(areaScrollPane,
                     BorderLayout.LINE_END);
        add(leftPane, BorderLayout.LINE_START);
        
        rightPane.add(radioControlPane, 
                     BorderLayout.PAGE_START);
        add(rightPane, BorderLayout.EAST);

        centerPane.add(radioControlAddPane, 
                BorderLayout.CENTER);
        add(centerPane, BorderLayout.CENTER);
   
        bottonPane.add(areaScrollPane, 
                BorderLayout.PAGE_START);
        bottonPane.add(versionLabel, BorderLayout.WEST);
        bottonPane.add(envLabel);
        bottonPane.add(helpButton, BorderLayout.EAST);
        add(bottonPane, BorderLayout.SOUTH);
       
    }

    private void addLabelTextRows(JLabel[] labels,
                                  JTextField[] textFields,
                                  GridBagLayout gridbag,
                                  Container container,
                                  JButton[] buttons) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.EAST;
        int numLabels = labels.length;

        for (int i = 0; i < numLabels; i++) {
            c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
            c.fill = GridBagConstraints.NONE;      //reset to default
            c.weightx = 0.0;                       //reset to default
            container.add(labels[i], c);

            c.gridwidth = GridBagConstraints.REMAINDER;     //end row
            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 1.0;
            container.add(textFields[i], c);
            
            c.gridwidth = GridBagConstraints.REMAINDER;     //end row
	        c.fill = GridBagConstraints.NONE;
	        c.weightx = 1.0;
	        container.add(buttons[i], c);
        }
        
    }
    
    /**
     * 
     * @param envSelectLabel
     * @param envComboBox
     * @param gridbag
     * @param container
     */
    private void addComboBoxs(JLabel envSelectLabel, JComboBox envComboBox, GridBagLayout gridbag, Container container) {
			GridBagConstraints c = new GridBagConstraints();
			c.anchor = GridBagConstraints.EAST;
			
			c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
            c.fill = GridBagConstraints.NONE;      //reset to default
            c.weightx = 0.0; 
            container.add(envSelectLabel, c);
            container.add(envComboBox, c);

    }
    
    /**
     * 
     * @param techIdtextFieldLabel
     * @param techIdtextField
     * @param techIdButton
     * @param radios
     * @param gridbag
     * @param container
     * @param equipmentQuantityLabel
     * @param equipmentQuantityComboBox
     */
    private void addRadio (JLabel techIdtextFieldLabel, JTextField techIdtextField, JButton techIdButton, JRadioButton[] radios, GridBagLayout gridbag,Container container, JLabel equipmentQuantityLabel, JComboBox equipmentQuantityComboBox) {
				GridBagConstraints c = new GridBagConstraints();
				c.anchor = GridBagConstraints.LINE_START;
				int numLabels = radios.length;
				
				c.gridwidth = GridBagConstraints.LINE_START; //next-to-last
	            c.fill = GridBagConstraints.HORIZONTAL;      //reset to default
	            c.weightx = 10.0;                       //reset to default
				container.add(techIdtextFieldLabel,c);
				c.gridwidth = GridBagConstraints.LINE_START; //next-to-last
	            c.fill = GridBagConstraints.NONE;      //reset to default
	            c.weightx = 10.0;                       //reset to default
				container.add(techIdtextField,c);
				c.gridwidth = GridBagConstraints.REMAINDER; //next-to-last
	            c.fill = GridBagConstraints.NONE;      //reset to default
	            c.weightx = 10.0;                       //reset to default
				container.add(techIdButton,c);
				
				for (int i = 0; i < numLabels; i++) {
					c.gridwidth = GridBagConstraints.REMAINDER; //next-to-last
					c.fill = GridBagConstraints.NONE;      //reset to default
					c.weightx = 0.0;                       //reset to default
					container.add(radios[i], c);
				}
				
				c.gridwidth = GridBagConstraints.LINE_START; //next-to-last
	            c.fill = GridBagConstraints.NONE;      //reset to default
	            c.weightx = 10.0;                       //reset to default
				container.add(equipmentQuantityLabel,c);
				
				c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
	            c.fill = GridBagConstraints.NONE;      //reset to default
	            c.weightx = 10.0;                       //reset to default
				container.add(equipmentQuantityComboBox,c);
    }

    private void addRadio2 (JLabel techIdtextFieldLabel, JTextField techIdtextField, JButton techIdButton, JRadioButton[] radios, GridBagLayout gridbag,Container container, JLabel addressesQuantityLabel, JComboBox addressesQuantityComboBox, JLabel codeNodeLabel, JComboBox codeNodeComboBox) {
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.LINE_START;

		c.gridwidth = GridBagConstraints.EAST; //next-to-last
        c.fill = GridBagConstraints.NONE;      //reset to default
        c.weightx = 0.0;                       //reset to default
		container.add(addressesQuantityLabel,c);
		
		c.gridwidth = GridBagConstraints.CENTER; //next-to-last
        c.fill = GridBagConstraints.NONE;      //reset to default
        c.weightx = 10.0;                       //reset to default
		container.add(addressesQuantityComboBox,c);

		c.gridwidth = GridBagConstraints.EAST; //next-to-last
        c.fill = GridBagConstraints.NONE;      //reset to default
        c.gridx = 5;
        c.gridy = 2;
        c.weightx = 1.0;                       //reset to default
		container.add(codeNodeLabel,c);
		
		c.gridwidth = GridBagConstraints.CENTER; //next-to-last
        c.fill = GridBagConstraints.NONE;      //reset to default
        c.gridx = 20;
        c.gridy = 2;
        c.weightx = 10.0;                       //reset to default
		container.add(codeNodeComboBox,c);
		
		c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
        c.fill = GridBagConstraints.NORTH; //reset to default
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 10;
        c.gridy = 4;
        c.weightx = 1.0;  		
		container.add(techIdButton,c);
		
}

    public void actionPerformed(ActionEvent e) {
    	try {
    		System.out.println(e.getActionCommand());
    		if (help.equals(e.getActionCommand())){
    			textArea.setText(Generic.printHelp());
    		} else if (envComboBoxChanged.equals(e.getActionCommand())){
    			env = (String) envComboBox.getSelectedItem();
    			System.out.println("Environment: " + env + " selected");
    			textArea.setText("***Environment: " + env + " selected***");
    			envLabel.setText("        |       Validator Working on " + env + "     ");
    		//Start action to search CBP on white list
    		} else if (CBPtextFieldString.equals(e.getActionCommand())) {
    			if (!cbptextField.getText().isEmpty())
        			textArea.setText(CRM.SearchCBPWhiteList(cbptextField.getText(), env));
        		else
        			textArea.setText("You did not provide the imput value...");
    		//End action to search CBP on white list
        	//Start action to search CPF/CNPJ on CRM
    		} else if (CPFCNPJtextFieldString.equals(e.getActionCommand())) {
    			if (!textField.getText().isEmpty())
        			textArea.setText(CRM.SearchCPFCNPJbyID(textField.getText(), env));
        		else
        			textArea.setText("You did not provide the imput value...");
    		//End action to search CPF/CNPJ on CRM
            //Start action to search address on CRM and SMP
    		} else if (AddresstextFieldString.equals(e.getActionCommand())) {
				if (!addresstextField.getText().isEmpty()){
					textArea.setText(CRM.SearchAddressbyID(addresstextField.getText(), env));
					//textArea.append (SMP.validateAddressId(addresstextField.getText(), env));
				}
				else
        			textArea.setText("You did not provide the imput value...");
			//End action to search address on CRM and SMP
			//Start action to search serial number on SMP
			} 
    		//else if (SerialtextFieldString.equals(e.getActionCommand())) {
//					if (!serialtextField.getText().isEmpty())
//					textArea.setText(SMP.validateSerialnumber(serialtextField.getText(), env));
//				else
//        			textArea.setText("You did not provide the imput value...");
			//End action to search serial number on SMP
			//Start action to search serial numbers by tech on SMP and novo atlas
//			} 
    	else if (techIdtextFieldString.equals(e.getActionCommand())) {
				if (techIdtextField.getText().isEmpty())
					textArea.setText("You did not provide the imput value...");
				else{
					//Function to check the quantity selected for equipment
					String quantityOption = (String) equipmentQuantityComboBox.getSelectedItem();
					Integer quantity = 100;
					if (quantityOption.equals("1")){
						quantity = 1; 
					}
					if (quantityOption.equals("2-10")){
						quantity = 10; 
					}
					if (quantityOption.equals("11-20")){
						quantity = 20; 
					}
					if (quantityOption.equals("21-50")){
						quantity = 50; 
					}
					if (quantityOption.equals("51-100")){
						quantity = 100; 
					}
					//End of funtion to check the quantity selected for equipment
					textArea.setText("***Starting search for selected equipment types for tech id: " + techIdtextField.getText() + "***\n");
					if(EMTA2D20C1radio.isSelected()){
						textArea.append("\nStarting search for EMTA2D20C1 available for tech id: " + techIdtextField.getText() + "...");
						ResultSet resultSet = NovoAtlas.SerialNumberByTechAndEquipType(techIdtextField.getText(), EMTA2D20C1, env); 
	       		 		Integer quantityLocal = quantity;
						while (resultSet.next() && quantityLocal > 0) {
	       		 			String equipment = resultSet.getString("CD_ENDERECAVEL");
//	       		 			String text = SMP.validateSerialnumber(equipment, env);
//	       		 			if (!text.equals("EquipExist")){
//	       		 				System.out.println(text);
	       		 				textArea.append("\n" + resultSet.getString("TP_MODEL_TYPE_DAM"));
	       		 				textArea.append("\n" + resultSet.getString("nr_serie"));
	       		 				quantityLocal--;
//	       		 			}
	       		 		}
	       		 		textArea.append("\n...Search finished\n");
					}
					if(EMTA2D30C8Wradio.isSelected()){
						textArea.append("\nStarting search for EMTA2D30C8W available for tech id: " + techIdtextField.getText() + "...");
						ResultSet resultSet = NovoAtlas.SerialNumberByTechAndEquipType(techIdtextField.getText(), EMTA2D30C8W, env);
						Integer quantityLocal = quantity;
	       		 		while (resultSet.next()  && quantityLocal > 0) {
	       		 			String equipment = resultSet.getString("CD_ENDERECAVEL");
//	       		 			String text = SMP.validateSerialnumber(equipment, env);
//	       		 			if (!text.equals("EquipExist")){
//	       		 				System.out.println(text);
	       		 				textArea.append("\n" + resultSet.getString("TP_MODEL_TYPE_DAM"));
	       		 				textArea.append("\n" + resultSet.getString("nr_serie"));
	       		 				quantityLocal--;
//	       		 			}
	       		 		}
	       		 		textArea.append("\n...Search finished\n");
					}
					if(EMTA2D20C1Wradio.isSelected()){
						textArea.append("\nStarting search for EMTA2D20C1W available for tech id: " + techIdtextField.getText() + "...");
						ResultSet resultSet = NovoAtlas.SerialNumberByTechAndEquipType(techIdtextField.getText(), EMTA2D20C1W, env);
						Integer quantityLocal = quantity;
	       		 		while (resultSet.next() && quantityLocal > 0) {
	       		 			String equipment = resultSet.getString("CD_ENDERECAVEL");
//	       		 			String text = SMP.validateSerialnumber(equipment, env);
//	       		 			if (!text.equals("EquipExist")){
//	       		 					System.out.println(text);
	       		 				textArea.append("\n" + resultSet.getString("TP_MODEL_TYPE_DAM"));
	       		 				textArea.append("\n" + resultSet.getString("nr_serie"));
	       		 					quantityLocal--;
//	       		 			}
	       		 		}
	       		 		textArea.append("\n...Search finished\n");
					}
					if(SMARTCARDradio.isSelected()){
						textArea.append("\nStarting search for SMARTCARD available for tech id: " + techIdtextField.getText() + "...");
						ResultSet resultSet = NovoAtlas.SerialNumberByTechAndEquipType(techIdtextField.getText(), SMARTCARD, env);
						Integer quantityLocal = quantity;
	       		 		while (resultSet.next() && quantityLocal > 0) {
	       		 			String equipment = resultSet.getString("CD_ENDERECAVEL");
//	       		 			String text = SMP.validateSerialnumber(equipment, env);
//	       		 			if (!text.equals("EquipExist")){
//	       		 				System.out.println(text);
	       		 				textArea.append("\n" + resultSet.getString("TP_MODEL_TYPE_DAM"));
	       		 				textArea.append("\n" + resultSet.getString("nr_serie"));
	       		 				quantityLocal--;
//	       		 			}
	       		 		}
	       		 		textArea.append("\n...Search finished\n");
					}
					if(DigitalSTBSD1radio.isSelected()){
						textArea.append("\nStarting search for DigitalSTBSD1 available for tech id: " + techIdtextField.getText() + "...");
						ResultSet resultSet = NovoAtlas.SerialNumberByTechAndEquipType(techIdtextField.getText(), DigitalSTBSD1, env);
						Integer quantityLocal = quantity;
	       		 		while (resultSet.next() && quantityLocal > 0) {
	       		 			String equipment = resultSet.getString("CD_ENDERECAVEL");
//	       		 			String text = SMP.validateSerialnumber(equipment, env);
//	       		 			if (!text.equals("EquipExist")){
//	       		 				System.out.println(text);
	       		 				textArea.append("\n" + resultSet.getString("TP_MODEL_TYPE_DAM"));
	       		 				textArea.append("\n" + resultSet.getString("nr_serie"));
	       		 				quantityLocal--;
//	       		 			}
	       		 		}
	       		 		textArea.append("\n...Search finished\n");
					}
					if(DigitalSTBHD1radio.isSelected()){
						textArea.append("\nStarting search for DigitalSTBHD1 available for tech id: " + techIdtextField.getText() + "...");
						ResultSet resultSet = NovoAtlas.SerialNumberByTechAndEquipType(techIdtextField.getText(), DigitalSTBHD1, env);
						Integer quantityLocal = quantity;
	       		 		while (resultSet.next() && quantityLocal > 0) {
	       		 			String equipment = resultSet.getString("CD_ENDERECAVEL");
//	       		 			String text = SMP.validateSerialnumber(equipment, env);
//	       		 			if (!text.equals("EquipExist")){
//	       		 				System.out.println(text);
	       		 				textArea.append("\n" + resultSet.getString("TP_MODEL_TYPE_DAM"));
	       		 				textArea.append("\n" + resultSet.getString("nr_serie"));
	       		 				quantityLocal--;
//	       		 			}
	       		 		}
	       		 		textArea.append("\n...Search finished\n");
					}
					if(DigitalSTBHDDVR1radio.isSelected()){
						textArea.append("\nStarting search for DigitalSTBHDDVR1 available for tech id: " + techIdtextField.getText() + "...");
						ResultSet resultSet = NovoAtlas.SerialNumberByTechAndEquipType(techIdtextField.getText(), DigitalSTBHDDVR1, env);
						Integer quantityLocal = quantity;
	       		 		while (resultSet.next() && quantityLocal > 0) {
	       		 			String equipment = resultSet.getString("CD_ENDERECAVEL");
//	       		 			String text = SMP.validateSerialnumber(equipment, env);
//	       		 			if (!text.equals("EquipExist")){
//	       		 				System.out.println(text);
	       		 				textArea.append("\n" + resultSet.getString("TP_MODEL_TYPE_DAM"));
	       		 				textArea.append("\n" + resultSet.getString("nr_serie"));
	       		 				quantityLocal--;
//	       		 			}
	       		 		}
	       		 		textArea.append("\n...Search finished\n");
					}
					if(DigitalSTB2Tradio.isSelected()){
						textArea.append("\nStarting search for DigitalSTB2T available for tech id: " + techIdtextField.getText() + "...");
						ResultSet resultSet = NovoAtlas.SerialNumberByTechAndEquipType(techIdtextField.getText(), DigitalSTB2T, env);
						Integer quantityLocal = quantity;
	       		 		while (resultSet.next() && quantityLocal > 0) {
	       		 			String equipment = resultSet.getString("CD_ENDERECAVEL");
//	       		 			String text = SMP.validateSerialnumber(equipment, env);
//	       		 			if (!text.equals("EquipExist")){
//	       		 				System.out.println(text);
	       		 				textArea.append("\n" + resultSet.getString("TP_MODEL_TYPE_DAM"));
	       		 				textArea.append("\n" + resultSet.getString("nr_serie"));
	       		 				quantityLocal--;
//	       		 			}
	       		 		}
	       		 		textArea.append("\n...Search finished\n");
					}
					if(Digital3PHD1radio.isSelected()){
						textArea.append("\nStarting search for Digital3PHD1 available for tech id: " + techIdtextField.getText() + "...");
						ResultSet resultSet = NovoAtlas.SerialNumberByTechAndEquipType(techIdtextField.getText(), Digital3PHD1, env);
						Integer quantityLocal = quantity;
	       		 		while (resultSet.next() && quantityLocal > 0) {
	       		 			String equipment = resultSet.getString("CD_ENDERECAVEL");
//	       		 			String text = SMP.validateSerialnumber(equipment, env);
//	       		 			if (!text.equals("EquipExist")){
//	       		 				System.out.println(text);
	       		 				textArea.append("\n" + resultSet.getString("TP_MODEL_TYPE_DAM"));
	       		 				textArea.append("\n" + resultSet.getString("nr_serie"));
	       		 				quantityLocal--;
//	       		 			}
	       		 		}
	       		 		textArea.append("\n...Search finished\n");
					}
					if(Digital3PHD2radio.isSelected()){
						textArea.append("\nStarting search for Digital3PHD2 available for tech id: " + techIdtextField.getText() + "...");
						ResultSet resultSet = NovoAtlas.SerialNumberByTechAndEquipType(techIdtextField.getText(), Digital3PHD2, env);
						Integer quantityLocal = quantity;
	       		 		while (resultSet.next() && quantityLocal > 0) {
	       		 			String equipment = resultSet.getString("CD_ENDERECAVEL");
//	       		 			String text = SMP.validateSerialnumber(equipment, env);
//	       		 			if (!text.equals("EquipExist")){
//	       		 				System.out.println(text);
	       		 				textArea.append("\n" + resultSet.getString("TP_MODEL_TYPE_DAM"));
	       		 				textArea.append("\n" + resultSet.getString("nr_serie"));
	       		 				quantityLocal--;
//	       		 			}
	       		 		}
					textArea.append("\n***Search finished for techId: " + techIdtextField.getText() + "***");
				}
				//END action to search serial numbers by tech on SMP and novo atlas
			}
			} else if (searchAddtextFieldString.equals(e.getActionCommand())) {
									//Function to check the quantity selected for equipment
							
					String nodeOption = (String) codeNodeComboBox.getSelectedItem();
					String quantityOption = (String) addressesQuantityComboBox.getSelectedItem();
					Integer quantity = 0;
					if (quantityOption.equals("1")){
						quantity = 10; 
					}
					if (quantityOption.equals("5")){
						quantity = 50; 
					}
					if (quantityOption.equals("10")){
						quantity = 100; 
					}
					if (quantityOption.equals("15")){
						quantity = 150; 
					}
					if (quantityOption.equals("20")){
						quantity = 200; 
					}
								
					textArea.setText("*** Environment: " + env + " selected***" + " Addresses to search: " + quantityOption + " ***" + " Code Node: " + nodeOption + " ***");
					//String headers =  " || COD_ENDERECO || "+ " || COD_BAIRRO || "+ " || NUM_CEP|| "+ " || NOM_COMPLETO || " 
					//+ " || NUM_LOGRADOURO || " + " || COD_TIPO_COMPL1 || " + " TXT_TIPO_COMPL1 || " 
					//+ " || COD_TIPO_COMPL2 || " + " || TXT_TIPO_COMPL2 || " ;
					//textArea.setText("\n" + headers);
								
					List<GedData> getData = new ArrayList<GedData>();
					int j;
					int i;
					
					getData = GED.GEDSearchAddresses(quantity, env, nodeOption);
					
					for (j = 0; j < getData.size(); j++) {
						int cod_endereco = getData.get(j).getCod_Endereco();
						int num_ordem = getData.get(j).getNum_Ordem();
						int cod_bairro = getData.get(j).getCod_Bairro();
						int cod_logradouro = getData.get(j).getCod_Logradouro();
						int cod_cidade = getData.get(j).getCod_Cidade();
						int IdElemento_Servico = getData.get(j).getIdElemento_Servico();
						String Nom_Completo = getData.get(j).getNom_Completo();
						int Num_CEP = getData.get(j).getNum_CEP();
						int Num_Logradouro = getData.get(j).getNum_Logradouro();
						String Nom_Complement1 = getData.get(j).getNom_Complement1();
						String Txt_Complement1 = getData.get(j).getTxt_Complement1();
						String Nom_Complement2 = getData.get(j).getNom_Complement2();
						String Txt_Complement2 = getData.get(j).getTxt_Complement1();
						
						//getting values for available technologies
						List<AvailableTechData> availableTechs = getData.get(j).getAvailableTechs();
						String avTech = new String();
						for (i = 0; i < availableTechs.size(); i++) {
							String Linha_Negocio = availableTechs.get(i).getLinha_Negocio();
							String Tecnologia = availableTechs.get(i).getTecnologia();
							String Caracteristica = availableTechs.get(i).getCaracteristica();
							String SubCaracteristca = availableTechs.get(i).getSubCaracteristca();
							avTech = avTech + " [ " + Linha_Negocio + " | " + Tecnologia + " |" + Caracteristica + " |" + SubCaracteristca + " ]\n ";
						}
						
						String headers =  " || COD_ENDERECO || "+ " || COD_BAIRRO || "+ " || NUM_CEP|| "+ " || NOM_COMPLETO || " 
						+ " || NUM_LOGRADOURO || " + " || COD_TIPO_COMPL1 || " + " TXT_TIPO_COMPL1 || " 
						+ " || COD_TIPO_COMPL2 || " + " || TXT_TIPO_COMPL2 || " ;
						
						String str =  " || "+ cod_endereco + " || "+ cod_bairro + " || "+ Num_CEP + " || " + Nom_Completo + " || " + Num_Logradouro
									 + " || " + Nom_Complement1 + " || " + Txt_Complement1
									 + " || " + Nom_Complement2 + " || " + Txt_Complement2;
						//String str =  " COD_ENDERECO: "+ cod_endereco + " COD_BAIRRO: "+ cod_bairro + " NUM_CEP: "+ Num_CEP + " NOM_COMPLETO: " + Nom_Completo + " --> NUM_LOGRADOURO: " + Num_Logradouro
						// + " COD_TIPO_COMPL1: " + Nom_Complement1 + " TXT_TIPO_COMPL1: " + Txt_Complement1
						// + " COD_TIPO_COMPL2: " + Nom_Complement2 + " TXT_TIPO_COMPL2: " + Txt_Complement2;

						//String str =  " Cod_Endereco: "+ cod_endereco + " Num_Ordem: "+ num_ordem + " Cod Bairro: "+ cod_bairro + " Cod Logradouro: "+ cod_logradouro + " Cod cidade: "+ cod_cidade + " Nom_Completo: " + Nom_Completo;
						//String str =  " Cod_Endereco: "+ cod_endereco + " Cod Bairro: "+ cod_bairro + " Cod cidade: "+ cod_cidade + " Nom_Completo: " + Nom_Completo;
						
						System.out.println(str);
						textArea.append("\n" + headers +"\n" + str + "\n"+ " [AvailableTech | Linha_Negocio | Caracteristica | SubCaracteristica]: \n " + avTech + "\n");
						//textArea.append("\n" + str + " ---> ID [Servicio]: " + IdElemento_Servico + " \n" + " [AvailableTech | Linha_Negocio]: " + avTech);
					}
					
					/*
					ResultSet rs  = GED.SearchAddresses(quantity, env);
										
       		 		while (rs.next()) {
       		 			int num_ordem 		= rs.getInt(1);
       		 			int cod_bairro 		= rs.getInt(2);
       		 			int cod_logradouro 	= rs.getInt(3);
       		 			int cod_cidade		= rs.getInt(4);
   		 				String str = " Num_Ordem: "+ num_ordem + " Cod Bairro: "+ cod_bairro + " Cod Logradouro: "+ cod_logradouro + " Cod cidade: "+ cod_cidade;
   		 				System.out.println(str);
       		 			textArea.append("\n" + str + " - ");
       		 		}
					//textArea.append("\n" + str + " - ");
					 
					 */
					
			}
			else {
				System.out.println("Other action");
			}
    	} catch (Exception e1) {
			// TODO Auto-generated catch block
    		textArea.setText(e1.getLocalizedMessage());
    		e1.printStackTrace();
		} 
}
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     * @throws Exception 
     */
    private static void createAndShowGUI() throws Exception {
        //Create and set up the window.
        JFrame frame = new JFrame("Validator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new Interface());
        frame.add(new Interface());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                 //Turn off metal's use of bold fonts
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		try {
			createAndShowGUI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            }
        });
    }
}
