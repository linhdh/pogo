//+======================================================================
// $Source:  $
//
// Project:   Tango
//
// Description:  Basic Dialog Class to display info
//
// $Author: pascal_verdier $
//
// Copyright (C) :      2004,2005,2006,2007,2008,2009,2009
//						European Synchrotron Radiation Facility
//                      BP 220, Grenoble 38043
//                      FRANCE
//
// This file is part of Tango.
//
// Tango is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
// 
// Tango is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
// 
// You should have received a copy of the GNU General Public License
// along with Tango.  If not, see <http://www.gnu.org/licenses/>.
//
// $Revision:  $
//
// $Log:  $
//
//-======================================================================

package org.tango.pogo.pogo_gui.packaging;

import fr.esrf.tango.pogo.pogoDsl.PogoDeviceClass;
import fr.esrf.tango.pogo.pogoDsl.PogoMultiClasses;
import fr.esrf.tangoatk.widget.util.ATKGraphicsUtils;
import org.tango.pogo.pogo_gui.tools.PogoException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


//===============================================================
/**
 *	JDialog Class to display info
 *
 *	@author  Pascal Verdier
 */
//===============================================================


@SuppressWarnings("MagicConstant")
public class ConfigurePackagingDialog extends JDialog {

    private PogoDeviceClass deviceClass = null;
    private PogoMultiClasses    multiClasses = null;
    private List<String>   headers = new ArrayList<>();
    private List<String>   functions = new ArrayList<>();

    private static final String[]   defaultHeaders = {
            "string.h", "sys/time.h", "sys/timeb.h", "unistd.h",
    };
    private static final Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    private static final Cursor waitCursor = new Cursor(Cursor.WAIT_CURSOR);

    //===============================================================
	/**
	 *	Creates new form ConfigurePackagingDialog
	 */
	//===============================================================
	public ConfigurePackagingDialog(JFrame parent, final PogoDeviceClass deviceClass) {
		super(parent, true);
        this.deviceClass = deviceClass;
		initOwnComponent(PackUtils.buildMailAddress(deviceClass.getDescription()),
                deviceClass.getDescription().getSourcePath());
	}
	//===============================================================
	/**
	 *	Creates new form ConfigurePackagingDialog
	 */
	//===============================================================
	public ConfigurePackagingDialog(JFrame parent, final PogoMultiClasses multiClasses, String author) {
		super(parent, true);
        this.multiClasses = multiClasses;
        initOwnComponent(author, multiClasses.getSourcePath());
    }
    //===============================================================
    //===============================================================
    private void initOwnComponent(String author, String path) {
		initComponents();
        Collections.addAll(headers, defaultHeaders);
        headerList.setListData(toArray(headers));

        authorText.setText(author);
        boolean b = !PackUtils.authorFileExists(path);
        authorText.setEnabled(b);

		pack();
 		ATKGraphicsUtils.centerDialog(this);
	}
    //===============================================================
    //===============================================================
    private String[] toArray(List<String> list) {
        String[] array = new String[list.size()];
        for (int i=0 ; i<list.size() ; i++)
            array[i] = list.get(i);
        return array;
    }
    //===============================================================
    //===============================================================

	//===============================================================
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
	//===============================================================
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        javax.swing.JPanel topPanel = new javax.swing.JPanel();
        javax.swing.JLabel titleLabel = new javax.swing.JLabel();
        javax.swing.JPanel centerPanel = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        headerList = new javax.swing.JList<String>();
        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        functionList = new javax.swing.JList<String>();
        javax.swing.JPanel btnPanel1 = new javax.swing.JPanel();
        javax.swing.JButton addHeaderButton = new javax.swing.JButton();
        removeHeaderButton = new javax.swing.JButton();
        javax.swing.JPanel btnPanel2 = new javax.swing.JPanel();
        javax.swing.JButton addFunctionButton = new javax.swing.JButton();
        removeFunctionButton = new javax.swing.JButton();
        javax.swing.JLabel versionLabel = new javax.swing.JLabel();
        versionText = new javax.swing.JTextField();
        javax.swing.JLabel authorLabel = new javax.swing.JLabel();
        authorText = new javax.swing.JTextField();
        javax.swing.JPanel bottomPanel = new javax.swing.JPanel();
        javax.swing.JButton okBtn = new javax.swing.JButton();
        javax.swing.JButton cancelBtn = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        titleLabel.setText("Packaging Check Configuration");
        topPanel.add(titleLabel);

        getContentPane().add(topPanel, java.awt.BorderLayout.NORTH);

        centerPanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Headers to be checked");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        centerPanel.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Functions to be checked");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        centerPanel.add(jLabel2, gridBagConstraints);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(35, 250));

        headerList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                headerListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(headerList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        centerPanel.add(jScrollPane1, gridBagConstraints);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(35, 250));

        functionList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                functionListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(functionList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        centerPanel.add(jScrollPane2, gridBagConstraints);

        btnPanel1.setLayout(new java.awt.GridBagLayout());

        addHeaderButton.setText("Add Header");
        addHeaderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHeaderButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        btnPanel1.add(addHeaderButton, gridBagConstraints);

        removeHeaderButton.setText("Remove");
        removeHeaderButton.setEnabled(false);
        removeHeaderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeHeaderButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        btnPanel1.add(removeHeaderButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 40);
        centerPanel.add(btnPanel1, gridBagConstraints);

        btnPanel2.setLayout(new java.awt.GridBagLayout());

        addFunctionButton.setText("Add Function");
        addFunctionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFunctionButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        btnPanel2.add(addFunctionButton, gridBagConstraints);

        removeFunctionButton.setText("Remove");
        removeFunctionButton.setEnabled(false);
        removeFunctionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFunctionButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        btnPanel2.add(removeFunctionButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        centerPanel.add(btnPanel2, gridBagConstraints);

        versionLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        versionLabel.setText("Version number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 20, 0);
        centerPanel.add(versionLabel, gridBagConstraints);

        versionText.setColumns(8);
        versionText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        versionText.setText("1.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 20, 0);
        centerPanel.add(versionText, gridBagConstraints);

        authorLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        authorLabel.setText("Author");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        centerPanel.add(authorLabel, gridBagConstraints);

        authorText.setColumns(8);
        authorText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        centerPanel.add(authorText, gridBagConstraints);

        getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);

        okBtn.setText("OK");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });
        bottomPanel.add(okBtn);

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        bottomPanel.add(cancelBtn);

        getContentPane().add(bottomPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

	//===============================================================
	//===============================================================
	@SuppressWarnings("UnusedParameters")
    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed

        try {
            setCursor(waitCursor);

            String  author = authorText.getText();
            String  version = versionText.getText();
            //  Generate the packaging
            Packaging   packaging;
            if (multiClasses!=null)
                packaging = new Packaging(multiClasses, version, author);
            else
                packaging = new Packaging(deviceClass, version, author);
            packaging.generate(headers, functions);

            //  Build message to display results
            StringBuilder message = new StringBuilder("Packaging for " +
                    packaging.getPackageName() + " has been created in:\n" + packaging.getPackagePath());
            //  With a help on checked functions
            message.append("\n\n\n");
            message.append("After configure command the following file will be generated.\n")
                    .append(packaging.getPackagePath()).append("/build/config.h\n");
            message.append("\n")
                    .append("You will be able to include it in your source files\n")
                    .append("to check headers/functions availability with:\n");
            for (String header : headers) {
                message.append("  #ifdef HAVE_").append(PackUtils.buildConfigureDefine(header)).append("\n");
            }
            message.append("\n");
            for (String function : functions) {
                message.append("  #ifdef HAVE_").append(PackUtils.buildConfigureDefine(function)).append("\n");
            }

            //  And display it
            setCursor(defaultCursor);
            JOptionPane.showMessageDialog(this,
                    message, "Packaging", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (PogoException e) {
            setCursor(defaultCursor);
            e.popup(this);
        }
		doClose();
	}//GEN-LAST:event_okBtnActionPerformed

	//===============================================================
	//===============================================================
    @SuppressWarnings("UnusedParameters")
	private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
		doClose();
	}//GEN-LAST:event_cancelBtnActionPerformed

	//===============================================================
	//===============================================================
    @SuppressWarnings("UnusedParameters")
	private void closeDialog(java.awt.event.WindowEvent evt) {                                                                  
		doClose();
	}                            

    //===============================================================
    //===============================================================
    @SuppressWarnings("UnusedParameters")
    private void addHeaderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHeaderButtonActionPerformed
        String header = (String) JOptionPane.showInputDialog(this,
                "Header name ?", "Input Dialog", JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if (header!=null && header.length()>0) {
            headers.add(header);
            headerList.setListData(toArray(headers));
        }
    }//GEN-LAST:event_addHeaderButtonActionPerformed

    //===============================================================
    //===============================================================
    @SuppressWarnings("UnusedParameters")
    private void removeHeaderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeHeaderButtonActionPerformed
        String  header =  headerList.getSelectedValue();
        headers.remove(header);
        headerList.setListData(toArray(headers));
    }//GEN-LAST:event_removeHeaderButtonActionPerformed

    //===============================================================
    //===============================================================
    @SuppressWarnings("UnusedParameters")
    private void addFunctionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFunctionButtonActionPerformed
        String function = (String) JOptionPane.showInputDialog(this,
                "Function name ?", "Input Dialog", JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if (function!=null && function.length()>0) {
            functions.add(function);
            functionList.setListData(toArray(functions));
        }
    }//GEN-LAST:event_addFunctionButtonActionPerformed

    //===============================================================
    //===============================================================
    @SuppressWarnings("UnusedParameters")
    private void removeFunctionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFunctionButtonActionPerformed
        String  function = functionList.getSelectedValue();
        functions.remove(function);
        functionList.setListData(toArray(functions));
    }//GEN-LAST:event_removeFunctionButtonActionPerformed

    //===============================================================
    //===============================================================
    @SuppressWarnings("UnusedParameters")
    private void headerListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_headerListValueChanged
        removeHeaderButton.setEnabled(true);
    }//GEN-LAST:event_headerListValueChanged

    //===============================================================
    //===============================================================
    @SuppressWarnings("UnusedParameters")
    private void functionListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_functionListValueChanged
        removeFunctionButton.setEnabled(true);
    }//GEN-LAST:event_functionListValueChanged

    //===============================================================
    //===============================================================
    @SuppressWarnings("UnusedParameters")
	//===============================================================
	/**
	 *	Closes the dialog
	 */
	//===============================================================
	private void doClose() {
		setVisible(false);
		dispose();
	}
	//===============================================================
	//===============================================================


	//===============================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField authorText;
    private javax.swing.JList<String> functionList;
    private javax.swing.JList<String> headerList;
    private javax.swing.JButton removeFunctionButton;
    private javax.swing.JButton removeHeaderButton;
    private javax.swing.JTextField versionText;
    // End of variables declaration//GEN-END:variables
	//===============================================================

}
