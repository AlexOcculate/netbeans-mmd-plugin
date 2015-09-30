package com.igormaznitsa.nbmindmap.nb.explorer;

import com.igormaznitsa.nbmindmap.utils.BadgeIcons;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.swing.Action;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.support.CommonProjectActions;
import org.openide.actions.FileSystemAction;
import org.openide.actions.FindAction;
import org.openide.actions.PasteAction;
import org.openide.actions.ToolsAction;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataFilter;
import org.openide.loaders.DataFolder;
import org.openide.nodes.FilterNode;
import org.openide.util.actions.SystemAction;
import org.openide.util.lookup.ProxyLookup;

class SourceNode extends AbstractMMFilter {

  private final Project project;
  private final FileObject fo;
  private volatile Image icon;
  private volatile Image iconOpen;
  
  SourceNode(final Project project, final DataFolder folder, final DataFilter filter, final String name) {
    this(project, folder, new FilterNode(folder.getNodeDelegate(), folder.createNodeChildren(filter)), name);
  }

  private SourceNode(final Project project, final DataFolder folder, final FilterNode node, final String name) {
    super(node, org.openide.nodes.Children.createLazy(new Callable<org.openide.nodes.Children>() {
      @Override
      public org.openide.nodes.Children call() throws Exception {
        return new FolderChildren(project, node);
      }
    }), new ProxyLookup(folder.getNodeDelegate().getLookup()));

    this.project = project;
    fo = folder.getPrimaryFile();
    
    disableDelegation(DELEGATE_GET_DISPLAY_NAME | DELEGATE_SET_DISPLAY_NAME | DELEGATE_GET_SHORT_DESCRIPTION | DELEGATE_GET_ACTIONS);
    setDisplayName(name);
  }

  public void setIcons(final Image icon, final Image iconOpen){
    this.icon = icon;
    this.iconOpen = iconOpen;
  }
  
  @Override
  public String getShortDescription() {
    return this.getOriginal().getShortDescription();
  }

  @Override
  public Image getIcon(final int type) {
    return  this.icon == null ? BadgeIcons.getTreeFolderIcon(false) : this.icon;
  }

  @Override
  public Image getOpenedIcon(final int type) {
    return this.iconOpen == null ? BadgeIcons.getTreeFolderIcon(true) : this.iconOpen;
  }

  @Override
  public boolean canCopy() {
    return false;
  }

  @Override
  public boolean canCut() {
    return false;
  }

  @Override
  public boolean canRename() {
    return false;
  }

  @Override
  public boolean canDestroy() {
    return false;
  }

  @Override 
  public Action[] getActions(final boolean context) {
    final List<Action> actions = new ArrayList<>();
    actions.add(CommonProjectActions.newFileAction());
    actions.add(null);
    actions.add(SystemAction.get(FileSystemAction.class));
    actions.add(null);
    actions.add(SystemAction.get(FindAction.class));
    actions.add(null);
    actions.add(SystemAction.get(PasteAction.class));
    actions.add(null);
    actions.add(SystemAction.get(ToolsAction.class));
    actions.add(null);
    // customizer - open sources for source node, testing for test node
    Action customizeAction;
    customizeAction = CommonProjectActions.customizeProjectAction();
    if (customizeAction != null) {
      actions.add(customizeAction);
    }
    return actions.toArray(new Action[actions.size()]);
  }

}