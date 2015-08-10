/*
 * Copyright 2015 Igor Maznitsa.
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
package com.igormaznitsa.nbmindmap.nb;

import com.igormaznitsa.nbmindmap.mmgui.Configuration;
import com.igormaznitsa.nbmindmap.mmgui.MindMapPanel;
import com.igormaznitsa.nbmindmap.utils.NbUtils;
import java.awt.Color;

final class MMDCfgPanel extends javax.swing.JPanel {

  private static final long serialVersionUID = -1090601330630026253L;

  private final MMDCfgOptionsPanelController controller;

  private volatile boolean changeNotificationAllowed = true;

  private static final Configuration etalon = new Configuration();
  
  MMDCfgPanel(final MMDCfgOptionsPanelController controller) {
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

    jPanel3 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    spinnerConnectorWidth = new javax.swing.JSpinner();
    colorChooserConnectorColor = new com.igormaznitsa.nbmindmap.nb.ColorChoosingButton();
    jPanel4 = new javax.swing.JPanel();
    colorChooserPaperColor = new com.igormaznitsa.nbmindmap.nb.ColorChoosingButton();
    checkBoxShowGrid = new javax.swing.JCheckBox();
    colorChooserGridColor = new com.igormaznitsa.nbmindmap.nb.ColorChoosingButton();
    spinnerGridStep = new javax.swing.JSpinner();
    jLabel1 = new javax.swing.JLabel();
    jPanel2 = new javax.swing.JPanel();
    checkBoxDropShadow = new javax.swing.JCheckBox();
    colorChooserRootBackground = new com.igormaznitsa.nbmindmap.nb.ColorChoosingButton();
    colorChooserRootText = new com.igormaznitsa.nbmindmap.nb.ColorChoosingButton();
    colorChooser1stBackground = new com.igormaznitsa.nbmindmap.nb.ColorChoosingButton();
    colorChooser1stText = new com.igormaznitsa.nbmindmap.nb.ColorChoosingButton();
    colorChooser2ndBackground = new com.igormaznitsa.nbmindmap.nb.ColorChoosingButton();
    colorChooser2ndText = new com.igormaznitsa.nbmindmap.nb.ColorChoosingButton();
    jPanel1 = new javax.swing.JPanel();
    checkboxOpenLinkINInsideBrowser = new javax.swing.JCheckBox();
    checkboxRelativePathsForFilesInTheProject = new javax.swing.JCheckBox();
    jPanel5 = new javax.swing.JPanel();
    colorChooserSelectLine = new com.igormaznitsa.nbmindmap.nb.ColorChoosingButton();
    jLabel3 = new javax.swing.JLabel();
    spinnerSelectLineWidth = new javax.swing.JSpinner();
    jLabel4 = new javax.swing.JLabel();
    spinnerSelectLineGap = new javax.swing.JSpinner();

    jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.jPanel3.border.title"))); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.jLabel2.text")); // NOI18N

    spinnerConnectorWidth.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.1f), Float.valueOf(0.05f), Float.valueOf(20.0f), Float.valueOf(0.01f)));
    spinnerConnectorWidth.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        spinnerConnectorWidthStateChanged(evt);
      }
    });

    org.openide.awt.Mnemonics.setLocalizedText(colorChooserConnectorColor, org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.colorChooserConnectorColor.text")); // NOI18N
    colorChooserConnectorColor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    colorChooserConnectorColor.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        colorChooserConnectorColorActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(spinnerConnectorWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(colorChooserConnectorColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(spinnerConnectorWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(colorChooserConnectorColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.jPanel4.border.title"))); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(colorChooserPaperColor, org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.colorChooserPaperColor.text")); // NOI18N
    colorChooserPaperColor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    colorChooserPaperColor.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        colorChooserPaperColorActionPerformed(evt);
      }
    });

    org.openide.awt.Mnemonics.setLocalizedText(checkBoxShowGrid, org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.checkBoxShowGrid.text")); // NOI18N
    checkBoxShowGrid.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        checkBoxShowGridActionPerformed(evt);
      }
    });

    org.openide.awt.Mnemonics.setLocalizedText(colorChooserGridColor, org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.colorChooserGridColor.text")); // NOI18N
    colorChooserGridColor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    colorChooserGridColor.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        colorChooserGridColorActionPerformed(evt);
      }
    });

    spinnerGridStep.setModel(new javax.swing.SpinnerNumberModel(15, 2, 500, 1));
    spinnerGridStep.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        spinnerGridStepStateChanged(evt);
      }
    });

    org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.jLabel1.text")); // NOI18N

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel4Layout.createSequentialGroup()
            .addGap(11, 11, 11)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(spinnerGridStep, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(colorChooserGridColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(checkBoxShowGrid)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(colorChooserPaperColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );

    jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {colorChooserGridColor, colorChooserPaperColor});

    jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(spinnerGridStep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel1)
          .addComponent(colorChooserGridColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(colorChooserPaperColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(checkBoxShowGrid))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.jPanel2.border.title"))); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(checkBoxDropShadow, org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.checkBoxDropShadow.text")); // NOI18N
    checkBoxDropShadow.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        checkBoxDropShadowActionPerformed(evt);
      }
    });

    org.openide.awt.Mnemonics.setLocalizedText(colorChooserRootBackground, org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.colorChooserRootBackground.text")); // NOI18N
    colorChooserRootBackground.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    colorChooserRootBackground.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        colorChooserRootBackgroundActionPerformed(evt);
      }
    });

    org.openide.awt.Mnemonics.setLocalizedText(colorChooserRootText, org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.colorChooserRootText.text")); // NOI18N
    colorChooserRootText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    colorChooserRootText.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        colorChooserRootTextActionPerformed(evt);
      }
    });

    org.openide.awt.Mnemonics.setLocalizedText(colorChooser1stBackground, org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.colorChooser1stBackground.text")); // NOI18N
    colorChooser1stBackground.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    colorChooser1stBackground.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        colorChooser1stBackgroundActionPerformed(evt);
      }
    });

    org.openide.awt.Mnemonics.setLocalizedText(colorChooser1stText, org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.colorChooser1stText.text")); // NOI18N
    colorChooser1stText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    colorChooser1stText.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        colorChooser1stTextActionPerformed(evt);
      }
    });

    org.openide.awt.Mnemonics.setLocalizedText(colorChooser2ndBackground, org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.colorChooser2ndBackground.text")); // NOI18N
    colorChooser2ndBackground.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    colorChooser2ndBackground.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        colorChooser2ndBackgroundActionPerformed(evt);
      }
    });

    org.openide.awt.Mnemonics.setLocalizedText(colorChooser2ndText, org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.colorChooser2ndText.text")); // NOI18N
    colorChooser2ndText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    colorChooser2ndText.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        colorChooser2ndTextActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(colorChooserRootBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(colorChooserRootText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(colorChooser1stBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colorChooser1stText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(checkBoxDropShadow)
              .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(colorChooser2ndBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colorChooser2ndText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );

    jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {colorChooser1stBackground, colorChooser1stText, colorChooser2ndBackground, colorChooser2ndText, colorChooserRootBackground, colorChooserRootText});

    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(checkBoxDropShadow)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(colorChooserRootBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(colorChooserRootText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(colorChooser1stText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(colorChooser1stBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(colorChooser2ndText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(colorChooser2ndBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.jPanel1.border.title"))); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(checkboxOpenLinkINInsideBrowser, org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.checkboxOpenLinkINInsideBrowser.text")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(checkboxRelativePathsForFilesInTheProject, org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.checkboxRelativePathsForFilesInTheProject.text")); // NOI18N

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(checkboxOpenLinkINInsideBrowser)
          .addComponent(checkboxRelativePathsForFilesInTheProject))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(checkboxOpenLinkINInsideBrowser)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(checkboxRelativePathsForFilesInTheProject)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.jPanel5.border.title"))); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(colorChooserSelectLine, org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.colorChooserSelectLine.text")); // NOI18N
    colorChooserSelectLine.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    colorChooserSelectLine.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        colorChooserSelectLineActionPerformed(evt);
      }
    });

    org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.jLabel3.text")); // NOI18N

    spinnerSelectLineWidth.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(1.0f), Float.valueOf(0.02f), Float.valueOf(100.0f), Float.valueOf(0.1f)));

    org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(MMDCfgPanel.class, "MMDCfgPanel.jLabel4.text")); // NOI18N

    spinnerSelectLineGap.setModel(new javax.swing.SpinnerNumberModel(1, 1, 500, 1));

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel5Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(colorChooserSelectLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanel5Layout.createSequentialGroup()
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jLabel3)
              .addComponent(jLabel4))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(spinnerSelectLineGap)
              .addComponent(spinnerSelectLineWidth, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel5Layout.setVerticalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel5Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(colorChooserSelectLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(spinnerSelectLineWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(spinnerSelectLineGap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void checkBoxShowGridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxShowGridActionPerformed
    if (changeNotificationAllowed) {
      this.controller.changed();
    }
  }//GEN-LAST:event_checkBoxShowGridActionPerformed

  private void checkBoxDropShadowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxDropShadowActionPerformed
    if (changeNotificationAllowed){
      this.controller.changed();
    }
  }//GEN-LAST:event_checkBoxDropShadowActionPerformed

  private void colorChooserPaperColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorChooserPaperColorActionPerformed
    if (this.colorChooserPaperColor.isLastOkPressed() && changeNotificationAllowed){
      this.controller.changed();
    }
  }//GEN-LAST:event_colorChooserPaperColorActionPerformed

  private void colorChooserGridColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorChooserGridColorActionPerformed
    if (this.colorChooserGridColor.isLastOkPressed() && changeNotificationAllowed) {
      this.controller.changed();
    }
  }//GEN-LAST:event_colorChooserGridColorActionPerformed

  private void spinnerGridStepStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerGridStepStateChanged
    if (changeNotificationAllowed){
      this.controller.changed();
    }
  }//GEN-LAST:event_spinnerGridStepStateChanged

  private void spinnerConnectorWidthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerConnectorWidthStateChanged
    if (changeNotificationAllowed){
      this.controller.changed();
    }
  }//GEN-LAST:event_spinnerConnectorWidthStateChanged

  private void colorChooserConnectorColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorChooserConnectorColorActionPerformed
    if (this.colorChooserConnectorColor.isLastOkPressed() && changeNotificationAllowed) {
      this.controller.changed();
    }
  }//GEN-LAST:event_colorChooserConnectorColorActionPerformed

  private void colorChooserRootBackgroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorChooserRootBackgroundActionPerformed
    if (this.colorChooserRootBackground.isLastOkPressed() && changeNotificationAllowed) {
      this.controller.changed();
    }
  }//GEN-LAST:event_colorChooserRootBackgroundActionPerformed

  private void colorChooserRootTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorChooserRootTextActionPerformed
    if (this.colorChooserRootText.isLastOkPressed() && changeNotificationAllowed) {
      this.controller.changed();
    }
  }//GEN-LAST:event_colorChooserRootTextActionPerformed

  private void colorChooser1stBackgroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorChooser1stBackgroundActionPerformed
    if (this.colorChooser1stBackground.isLastOkPressed() && changeNotificationAllowed) {
      this.controller.changed();
    }
  }//GEN-LAST:event_colorChooser1stBackgroundActionPerformed

  private void colorChooser1stTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorChooser1stTextActionPerformed
    if (this.colorChooser1stText.isLastOkPressed() && changeNotificationAllowed) {
      this.controller.changed();
    }
  }//GEN-LAST:event_colorChooser1stTextActionPerformed

  private void colorChooser2ndBackgroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorChooser2ndBackgroundActionPerformed
    if (this.colorChooser2ndBackground.isLastOkPressed() && changeNotificationAllowed) {
      this.controller.changed();
    }
  }//GEN-LAST:event_colorChooser2ndBackgroundActionPerformed

  private void colorChooser2ndTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorChooser2ndTextActionPerformed
    if (this.colorChooser2ndText.isLastOkPressed() && changeNotificationAllowed) {
      this.controller.changed();
    }
  }//GEN-LAST:event_colorChooser2ndTextActionPerformed

  private void colorChooserSelectLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorChooserSelectLineActionPerformed
    if (this.colorChooserSelectLine.isLastOkPressed() && changeNotificationAllowed) {
      this.controller.changed();
    }
  }//GEN-LAST:event_colorChooserSelectLineActionPerformed

  void load() {
    changeNotificationAllowed = false;
    try {
      this.checkBoxShowGrid.setSelected(NbUtils.getPreferences().getBoolean("showGrid", etalon.isShowGrid()));
      this.checkBoxDropShadow.setSelected(NbUtils.getPreferences().getBoolean("dropShadow", etalon.isDropShadow()));
      this.colorChooserPaperColor.setValue(new Color(NbUtils.getPreferences().getInt("paperColor", etalon.getPaperColor().getRGB())));
      this.colorChooserGridColor.setValue(new Color(NbUtils.getPreferences().getInt("gridColor", etalon.getGridColor().getRGB())));
      this.colorChooserConnectorColor.setValue(new Color(NbUtils.getPreferences().getInt("connectorColor", etalon.getConnectorColor().getRGB())));

      this.colorChooserRootBackground.setValue(new Color(NbUtils.getPreferences().getInt("rootBackColor", etalon.getRootBackgroundColor().getRGB())));
      this.colorChooserRootText.setValue(new Color(NbUtils.getPreferences().getInt("rootTextColor", etalon.getRootTextColor().getRGB())));

      this.colorChooser1stBackground.setValue(new Color(NbUtils.getPreferences().getInt("1stBackColor", etalon.getFirstLevelBackgroundColor().getRGB())));
      this.colorChooser1stText.setValue(new Color(NbUtils.getPreferences().getInt("1stTextColor", etalon.getFirstLevelTextColor().getRGB())));

      this.colorChooser2ndBackground.setValue(new Color(NbUtils.getPreferences().getInt("2stBackColor", etalon.getOtherLevelBackgroundColor().getRGB())));
      this.colorChooser2ndText.setValue(new Color(NbUtils.getPreferences().getInt("2stTextColor", etalon.getOtherLevelTextColor().getRGB())));
      
      this.colorChooserSelectLine.setValue(new Color(NbUtils.getPreferences().getInt("selectLineColor", etalon.getSelectLineColor().getRGB())));

      this.spinnerGridStep.setValue(NbUtils.getPreferences().getInt("gridStep",etalon.getGridStep()));
      this.spinnerSelectLineGap.setValue(NbUtils.getPreferences().getInt("selectLineGap",etalon.getSelectLineGap()));
      this.spinnerConnectorWidth.setValue(NbUtils.getPreferences().getFloat("connectorWidth",etalon.getConnectorWidth()));
      this.spinnerSelectLineWidth.setValue(NbUtils.getPreferences().getFloat("selectLineWidth",etalon.getSelectLineWidth()));
    }
    finally {
      changeNotificationAllowed = true;
    }
  }

  void store() {
    try {
      NbUtils.getPreferences().putBoolean("showGrid", this.checkBoxShowGrid.isSelected());
      NbUtils.getPreferences().putBoolean("dropShadow", this.checkBoxDropShadow.isSelected());
      NbUtils.getPreferences().putInt("paperColor", this.colorChooserPaperColor.getValue().getRGB());
      NbUtils.getPreferences().putInt("gridColor", this.colorChooserGridColor.getValue().getRGB());
      NbUtils.getPreferences().putInt("connectorColor", this.colorChooserConnectorColor.getValue().getRGB());
      NbUtils.getPreferences().putInt("rootBackColor", this.colorChooserRootBackground.getValue().getRGB());
      NbUtils.getPreferences().putInt("rootTextColor", this.colorChooserRootText.getValue().getRGB());
      NbUtils.getPreferences().putInt("1stBackColor", this.colorChooser1stBackground.getValue().getRGB());
      NbUtils.getPreferences().putInt("1stTextColor", this.colorChooser1stText.getValue().getRGB());
      NbUtils.getPreferences().putInt("2stBackColor", this.colorChooser2ndBackground.getValue().getRGB());
      NbUtils.getPreferences().putInt("2stTextColor", this.colorChooser2ndText.getValue().getRGB());
      NbUtils.getPreferences().putInt("selectLineColor", this.colorChooserSelectLine.getValue().getRGB());
      
      NbUtils.getPreferences().putInt("gridStep", (Integer)this.spinnerGridStep.getValue());
      NbUtils.getPreferences().putInt("selectLineGap", (Integer)this.spinnerSelectLineGap.getValue());
      NbUtils.getPreferences().putFloat("connectorWidth", (Float)this.spinnerConnectorWidth.getValue());
      NbUtils.getPreferences().putFloat("selectLineWidth", (Float)this.spinnerSelectLineWidth.getValue());
    }
    finally {
      MindMapPanel.loadCommonConfig();
    }
  }

  boolean valid() {
    return true;
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JCheckBox checkBoxDropShadow;
  private javax.swing.JCheckBox checkBoxShowGrid;
  private javax.swing.JCheckBox checkboxOpenLinkINInsideBrowser;
  private javax.swing.JCheckBox checkboxRelativePathsForFilesInTheProject;
  private com.igormaznitsa.nbmindmap.nb.ColorChoosingButton colorChooser1stBackground;
  private com.igormaznitsa.nbmindmap.nb.ColorChoosingButton colorChooser1stText;
  private com.igormaznitsa.nbmindmap.nb.ColorChoosingButton colorChooser2ndBackground;
  private com.igormaznitsa.nbmindmap.nb.ColorChoosingButton colorChooser2ndText;
  private com.igormaznitsa.nbmindmap.nb.ColorChoosingButton colorChooserConnectorColor;
  private com.igormaznitsa.nbmindmap.nb.ColorChoosingButton colorChooserGridColor;
  private com.igormaznitsa.nbmindmap.nb.ColorChoosingButton colorChooserPaperColor;
  private com.igormaznitsa.nbmindmap.nb.ColorChoosingButton colorChooserRootBackground;
  private com.igormaznitsa.nbmindmap.nb.ColorChoosingButton colorChooserRootText;
  private com.igormaznitsa.nbmindmap.nb.ColorChoosingButton colorChooserSelectLine;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JPanel jPanel5;
  private javax.swing.JSpinner spinnerConnectorWidth;
  private javax.swing.JSpinner spinnerGridStep;
  private javax.swing.JSpinner spinnerSelectLineGap;
  private javax.swing.JSpinner spinnerSelectLineWidth;
  // End of variables declaration//GEN-END:variables
}
