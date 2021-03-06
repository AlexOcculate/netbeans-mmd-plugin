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
package com.igormaznitsa.sciareto.ui.editors;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nonnull;
import javax.swing.JScrollPane;
import com.igormaznitsa.meta.common.interfaces.Disposable;
import com.igormaznitsa.sciareto.ui.DialogProviderManager;
import com.igormaznitsa.sciareto.ui.tabs.TabProvider;

public abstract class AbstractScrollPane extends JScrollPane implements TabProvider,Disposable {

  private static final long serialVersionUID = -6865229547826910048L;
  
  private final AtomicBoolean disposeFlag = new AtomicBoolean();
  
  public AbstractScrollPane(){
    super();

    final AdjustmentListener listener = new AdjustmentListener() {
      @Override
      public void adjustmentValueChanged(@Nonnull final AdjustmentEvent e) {
        onScrollBarAdjustment(e);
      }
    };

    this.getHorizontalScrollBar().addAdjustmentListener(listener);
    this.getVerticalScrollBar().addAdjustmentListener(listener);
  }

  protected void onScrollBarAdjustment(@Nonnull final AdjustmentEvent event) {

  }

  @Override
  public void updateConfiguration() {
  }

  @Override
  public boolean saveDocumentAs() throws IOException {
    final File file = this.getTabTitle().getAssociatedFile();
    final File fileToSave = DialogProviderManager.getInstance().getDialogProvider().msgSaveFileDialog("save-as", "Save as", file, true, getFileFilter(), "Save");
    if (fileToSave!=null){
      this.getTabTitle().setAssociatedFile(fileToSave);
      this.getTabTitle().setChanged(true);
      return this.saveDocument();
    }
    return false;
  }

  @Override
  public final void dispose() {
    if (disposeFlag.compareAndSet(false, true)){
      this.doDispose();
    }
  }

  protected void doDispose(){
    
  }

  @Override
  public boolean isDisposed() {
    return this.disposeFlag.get();
  }
}
