/*
 * Copyright 2016 Igor Maznitsa.
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
package com.igormaznitsa.sciareto.ui;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import com.igormaznitsa.meta.annotation.MustNotContainNull;

public class FileListPanel extends javax.swing.JPanel implements TableModel {

  private static final long serialVersionUID = 2901921029860574818L;

  private static final class FileSelector {

    private boolean selected;
    private final File file;
    
    public FileSelector(final File file) {
      this.selected = true;
      this.file = file;
    }
    
    public void setSelected(final boolean flag){
      this.selected = flag;
    }
    
    public boolean isSelected(){
      return this.selected;
    }
    
    public File getFile(){
      return this.file;
    }
    
  }
  
  private final List<FileSelector> files = new ArrayList<>();
  private final List<TableModelListener> listeners = new ArrayList<>();
  
  public FileListPanel(@Nonnull @MustNotContainNull final List<File> files) {
    initComponents();
    for(final File f : files){
      this.files.add(new FileSelector(f));
    }
    this.tableFiles.setModel(this);
    this.tableFiles.setTableHeader(null);
    this.tableFiles.getColumnModel().getColumn(0).setMaxWidth(24);
    
    this.setMinimumSize(new Dimension(300,300));
    this.setPreferredSize(new Dimension(480,400));
  }

  @Nonnull
  @MustNotContainNull
  public List<File> getSelectedFiles(){
    final List<File> result = new ArrayList<>();
    for(final FileSelector s : this.files){
      if (s.isSelected()){
        result.add(s.getFile());
      }
    }
    return result;
  }
  
  @Override
  public int getRowCount() {
    return this.files.size();
  }

  @Override
  public int getColumnCount() {
    return 2;
  }

  @Override
  @Nonnull
  public String getColumnName(final int columnIndex) {
    switch(columnIndex){
      case 0 : return "...";
      case 1 : return "File";
      default : throw new Error("Unexpected index");
    }
  }

  @Override
  @Nonnull
  public Class<?> getColumnClass(final int columnIndex) {
    return columnIndex == 0 ? Boolean.class : String.class;
  }

  @Override
  public boolean isCellEditable(final int rowIndex, final int columnIndex) {
    return columnIndex == 0;
  }

  @Override
  @Nonnull
  public Object getValueAt(final int rowIndex, final int columnIndex) {
    final FileSelector selector = this.files.get(rowIndex);
    switch(columnIndex){
      case 0 : return selector.isSelected();
      case 1 : return selector.getFile().getName();
      default: throw new Error("unexpected column");
    }
  }

  @Override
  public void setValueAt(@Nonnull final Object aValue, final int rowIndex, final int columnIndex) {
    final FileSelector selector = this.files.get(rowIndex);
    switch (columnIndex) {
      case 0: selector.setSelected((Boolean)aValue);break;
      default: throw new Error("unexpected column index");
    }
    final TableModelEvent event = new TableModelEvent(this, rowIndex,rowIndex,columnIndex);
    for(final TableModelListener l : this.listeners){
      l.tableChanged(event);
    }
  }

  @Override
  public void addTableModelListener(@Nonnull final TableModelListener l) {
    this.listeners.add(l);
  }

  @Override
  public void removeTableModelListener(@Nonnull final TableModelListener l) {
    this.listeners.remove(l);
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form
   * Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane2 = new javax.swing.JScrollPane();
    tableFiles = new javax.swing.JTable();
    jPanel1 = new javax.swing.JPanel();
    jHtmlLabel1 = new com.igormaznitsa.sciareto.ui.misc.JHtmlLabel();

    setLayout(new java.awt.BorderLayout(0, 8));

    tableFiles.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String [] {
        "Title 1", "Title 2", "Title 3", "Title 4"
      }
    ));
    tableFiles.setFillsViewportHeight(true);
    tableFiles.setShowHorizontalLines(false);
    tableFiles.setShowVerticalLines(false);
    jScrollPane2.setViewportView(tableFiles);

    add(jScrollPane2, java.awt.BorderLayout.CENTER);

    jPanel1.setLayout(new java.awt.GridBagLayout());
    add(jPanel1, java.awt.BorderLayout.NORTH);

    jHtmlLabel1.setText("<html>The Files contain links affected by the operation. You can uncheck them to prevent changes.</html>"); // NOI18N
    add(jHtmlLabel1, java.awt.BorderLayout.NORTH);
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private com.igormaznitsa.sciareto.ui.misc.JHtmlLabel jHtmlLabel1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTable tableFiles;
  // End of variables declaration//GEN-END:variables
}
