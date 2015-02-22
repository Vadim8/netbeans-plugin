/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeigniter.netbeans.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import org.openide.util.Exceptions;
import org.openide.util.NbPreferences;

final class CiLocationVersionPanel extends javax.swing.JPanel {

    private final CiLocationVersionOptionsPanelController controller;

    CiLocationVersionPanel(CiLocationVersionOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
        // TODO listen to changes in form fields and call controller.changed()
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CiPathLabel = new javax.swing.JLabel();
        CiPath = new javax.swing.JLabel();
        CiVersion = new javax.swing.JLabel();
        CiVersionLabel = new javax.swing.JLabel();
        CiUpdateButton = new javax.swing.JButton();

        org.openide.awt.Mnemonics.setLocalizedText(CiPathLabel, org.openide.util.NbBundle.getMessage(CiLocationVersionPanel.class, "CiLocationVersionPanel.CiPathLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(CiPath, org.openide.util.NbBundle.getMessage(CiLocationVersionPanel.class, "CiLocationVersionPanel.CiPath.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(CiVersion, org.openide.util.NbBundle.getMessage(CiLocationVersionPanel.class, "CiLocationVersionPanel.CiVersion.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(CiVersionLabel, org.openide.util.NbBundle.getMessage(CiLocationVersionPanel.class, "CiLocationVersionPanel.CiVersionLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(CiUpdateButton, org.openide.util.NbBundle.getMessage(CiLocationVersionPanel.class, "CiLocationVersionPanel.CiUpdateButton.text")); // NOI18N
        CiUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CiUpdateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CiPathLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CiPath))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CiVersionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CiVersion))
                    .addComponent(CiUpdateButton))
                .addContainerGap(380, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CiPath)
                    .addComponent(CiPathLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CiVersionLabel)
                    .addComponent(CiVersion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CiUpdateButton)
                .addContainerGap(336, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CiUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CiUpdateButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        if (CiPath.getText().compareTo("None") == 0)
            chooser.setCurrentDirectory(new java.io.File(CiPath.getText()));
        else
            chooser.setCurrentDirectory(new java.io.File(CiPath.getText()));
        chooser.setDialogTitle("Select CodeIgniter Project Folder..");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String location = chooser.getSelectedFile().toString();
            // check framework exists
            String coreCi = location + "/system/core/CodeIgniter.php";
            String version = "None";
            try {
                version = loadCiVersion(coreCi);
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
            CiPath.setText(location);
            CiVersion.setText(version);
        }
    }//GEN-LAST:event_CiUpdateButtonActionPerformed

    void load() {
        // TODO read settings and initialize GUI
        // Example:        
        // someCheckBox.setSelected(Preferences.userNodeForPackage(CiLocationVersionPanel.class).getBoolean("someFlag", false));
        // or for org.openide.util with API spec. version >= 7.4:
        // someCheckBox.setSelected(NbPreferences.forModule(CiLocationVersionPanel.class).getBoolean("someFlag", false));
        // or:
        // someTextField.setText(SomeSystemOption.getDefault().getSomeStringProperty());
        CiPath.setText((NbPreferences.forModule(AvailablePluginsPanel.class).get("CiPath", CiPath.getText())));
        CiVersion.setText((NbPreferences.forModule(AvailablePluginsPanel.class).get("CiVersion", CiPath.getText())));
    }

    void store() {
        // TODO store modified settings
        // Example:
        // Preferences.userNodeForPackage(CiLocationVersionPanel.class).putBoolean("someFlag", someCheckBox.isSelected());
        // or for org.openide.util with API spec. version >= 7.4:
        // NbPreferences.forModule(CiLocationVersionPanel.class).putBoolean("someFlag", someCheckBox.isSelected());
        // or:
        // SomeSystemOption.getDefault().setSomeStringProperty(someTextField.getText());
        NbPreferences.forModule(AvailablePluginsPanel.class).put("CiPath", CiPath.getText());
        NbPreferences.forModule(AvailablePluginsPanel.class).put("CiVersion", CiVersion.getText());
    }

    boolean valid() {
        // TODO check whether form is consistent and complete
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CiPath;
    private javax.swing.JLabel CiPathLabel;
    private javax.swing.JButton CiUpdateButton;
    private javax.swing.JLabel CiVersion;
    private javax.swing.JLabel CiVersionLabel;
    // End of variables declaration//GEN-END:variables

    private String loadCiVersion(String coreCi) throws IOException {
        String version = "None";
        FileInputStream fis = new FileInputStream(new File(coreCi));
	BufferedReader br = new BufferedReader(new InputStreamReader(fis));
 
	String line = null;
	while ((line = br.readLine()) != null) {
            if (line.toLowerCase().contains("CI_VERSION".toLowerCase()))
            {
                String[] tokens = line.split("[,]");
                tokens = tokens[1].split("[']");
                version = tokens[1];
                break;
            }
	}
	br.close();
        
        return version;
    }
}
