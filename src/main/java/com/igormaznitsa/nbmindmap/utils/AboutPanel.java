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
package com.igormaznitsa.nbmindmap.utils;

import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.View;
import javax.swing.text.html.HTMLDocument;
import org.openide.modules.ModuleInfo;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;

public class AboutPanel extends javax.swing.JPanel {

  private static final long serialVersionUID = -3231534203788095969L;

  public AboutPanel() {
    initComponents();

    final ModuleInfo info = Lookup.getDefault().lookup(ModuleInfo.class);
    final String version;
    if (info == null) {
      version = "UNKNOWN";
    }
    else {
      version = info.getImplementationVersion();
    }

    this.labelText.setText(this.labelText.getText().replace("${version}", version));
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    labelIcon = new javax.swing.JLabel();
    labelText = new javax.swing.JLabel();

    labelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/igormaznitsa/nbmindmap/icons/logo/logo32.png"))); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(labelText, "<html>\n<b>NB MindMap plugin</b>\n<hr>\n<p>Version: ${version}</p>\n<br>\n<p>Author: Igor Maznitsa (<a href=\"http://www.igormaznitsa.com\">http://www.igormaznitsa.com</a>)</p>\n<br>\n<hr>\n<p>The Project page: <a href=\"https://github.com/raydac/netbeans-mmd-plugin\">https://github.com/raydac/netbeans-mmd-plugin</a>\n<p>The Project uses icons from the FatCow free web icon set <a href=\"http://www.fatcow.com/free-icons\">http://www.fatcow.com/free-icons</a></p>\n<br>\n</html>"); // NOI18N
    labelText.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    labelText.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        labelTextMouseClicked(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelIcon)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(labelText)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelIcon)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(layout.createSequentialGroup()
        .addGap(28, 28, 28)
        .addComponent(labelText, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void labelTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTextMouseClicked
    final String link = extractLinkForPoint(evt.getPoint(), this.labelText);
    if (link != null) {
      try {
        NbUtils.browseURI(new URI(link), false);
      }
      catch (URISyntaxException ex) {
        Logger.error("Can't make URI " + link, ex);
      }
    }
  }//GEN-LAST:event_labelTextMouseClicked

  private String extractLinkForPoint(final Point pont, final JLabel label) {
    final int position = getIndexAtPoint(pont, label);
    if (position < 0) {
      return null;
    }
    final HTMLDocument doc = (HTMLDocument) (((View) label.getClientProperty("html")).getDocument());
    try {
      final String text = doc.getText(0, doc.getLength());
      final int start = text.lastIndexOf("http", position);
      if (start >= 0) {
        int nextIndex = -1;
        for (int i = start; i < text.length(); i++) {
          if (text.charAt(i) == ')' || Character.isSpaceChar(text.charAt(i)) || Character.isISOControl(text.charAt(i))) {
            nextIndex = i;
            break;
          }
        }
        if (nextIndex >= 0 && nextIndex >= position) {
          return text.substring(start, nextIndex).trim();
        }
      }
    }
    catch (BadLocationException ex) {
      Exceptions.printStackTrace(ex);
    }
    return null;
  }

  private static int getIndexAtPoint(final Point p, final JLabel label) {
    View view = (View) label.getClientProperty("html");

    if (view != null) {
      Rectangle r = getTextRectangle(label);
      if (r == null) {
        return -1;
      }
      Rectangle2D.Float shape
              = new Rectangle2D.Float(r.x, r.y, r.width, r.height);
      Position.Bias bias[] = new Position.Bias[1];
      return view.viewToModel(p.x, p.y, shape, bias);
    }
    else {
      return -1;
    }
  }

  private static Rectangle getTextRectangle(final JLabel label) {

    String text = label.getText();
    Icon icon = (label.isEnabled()) ? label.getIcon() : label.getDisabledIcon();

    if ((icon == null) && (text == null)) {
      return null;
    }

    Rectangle paintIconR = new Rectangle();
    Rectangle paintTextR = new Rectangle();
    Rectangle paintViewR = new Rectangle();
    Insets paintViewInsets = new Insets(0, 0, 0, 0);

    paintViewInsets = label.getInsets(paintViewInsets);
    paintViewR.x = paintViewInsets.left;
    paintViewR.y = paintViewInsets.top;
    paintViewR.width = label.getWidth() - (paintViewInsets.left + paintViewInsets.right);
    paintViewR.height = label.getHeight() - (paintViewInsets.top + paintViewInsets.bottom);

    String clippedText = SwingUtilities.layoutCompoundLabel(
            (JComponent) label,
            label.getFontMetrics(label.getFont()),
            text,
            icon,
            label.getVerticalAlignment(),
            label.getHorizontalAlignment(),
            label.getVerticalTextPosition(),
            label.getHorizontalTextPosition(),
            paintViewR,
            paintIconR,
            paintTextR,
            label.getIconTextGap());

    return paintTextR;
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel labelIcon;
  private javax.swing.JLabel labelText;
  // End of variables declaration//GEN-END:variables
}