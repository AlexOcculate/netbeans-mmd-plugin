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

import com.igormaznitsa.sciareto.ui.editors.mmeditors.UriEditPanel;
import com.igormaznitsa.sciareto.ui.misc.ColorChooserButton;
import com.igormaznitsa.sciareto.ui.editors.mmeditors.NoteEditor;
import com.igormaznitsa.sciareto.ui.editors.mmeditors.FileEditPanel;
import static com.igormaznitsa.mindmap.swing.panel.utils.Utils.html2color;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.apache.commons.lang.SystemUtils;
import com.igormaznitsa.meta.annotation.MustNotContainNull;
import com.igormaznitsa.meta.common.utils.IOUtils;
import com.igormaznitsa.mindmap.model.MMapURI;
import com.igormaznitsa.mindmap.model.Topic;
import com.igormaznitsa.mindmap.model.logger.Logger;
import com.igormaznitsa.mindmap.model.logger.LoggerFactory;
import com.igormaznitsa.sciareto.Main;

public final class UiUtils {

  private static final Logger LOGGER = LoggerFactory.getLogger(UiUtils.class);
  public static final ResourceBundle BUNDLE = java.util.ResourceBundle.getBundle("com/igormaznitsa/nbmindmap/i18n/Bundle");

  public static final MMapURI EMPTY_URI;
  public static final boolean DARK_THEME;

  static {
    try {
      EMPTY_URI = new MMapURI("http://igormaznitsa.com/specialuri#empty"); //NOI18N
    } catch (URISyntaxException ex) {
      throw new Error("Unexpected exception", ex); //NOI18N
    }
    final Color color = UIManager.getColor("Panel.background");
    if (color == null) {
      DARK_THEME = false;
    } else {
      DARK_THEME = calculateBrightness(color) < 150;
    }
  }

  private UiUtils() {
  }

  @Nullable
  @MustNotContainNull
  public static List<File> showSelectAffectedFiles(@Nonnull @MustNotContainNull final List<File> files) {
    final FileListPanel panel = new FileListPanel(files);
    if (DialogProviderManager.getInstance().getDialogProvider().msgOkCancel("Affected files", panel)) {
      return panel.getSelectedFiles();
    }
    return null;
  }

  public static int calculateBrightness(@Nonnull final Color color) {
    return (int) Math.sqrt(
        color.getRed() * color.getRed() * .241d
        + color.getGreen() * color.getGreen() * .691d
        + color.getBlue() * color.getBlue() * .068d);
  }

  @Nonnull
  public static Image iconToImage(@Nonnull Component context, @Nullable final Icon icon) {
    if (icon instanceof ImageIcon) {
      return ((ImageIcon) icon).getImage();
    }
    final int width = icon == null ? 16 : icon.getIconWidth();
    final int height = icon == null ? 16 : icon.getIconHeight();
    final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    if (icon != null) {
      final Graphics g = image.getGraphics();
      try {
        icon.paintIcon(context, g, 0, 0);
      } finally {
        g.dispose();
      }
    }
    return image;
  }

  @Nonnull
  public static Image makeBadgedRightBottom(@Nonnull final Image base, @Nonnull final Image badge) {
    final int width = Math.max(base.getWidth(null), badge.getWidth(null));
    final int height = Math.max(base.getHeight(null), badge.getHeight(null));
    final BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    final Graphics gfx = result.getGraphics();
    try {
      gfx.drawImage(base, (width - base.getWidth(null)) / 2, (height - base.getHeight(null)) / 2, null);
      gfx.drawImage(badge, width - badge.getWidth(null) - 1, height - badge.getHeight(null) - 1, null);
    } finally {
      gfx.dispose();
    }
    return result;
  }

  @Nonnull
  public static Image makeBadgedRightTop(@Nonnull final Image base, @Nonnull final Image badge) {
    final int width = Math.max(base.getWidth(null), badge.getWidth(null));
    final int height = Math.max(base.getHeight(null), badge.getHeight(null));
    final BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    final Graphics gfx = result.getGraphics();
    try {
      gfx.drawImage(base, (width - base.getWidth(null)) / 2, (height - base.getHeight(null)) / 2, null);
      gfx.drawImage(badge, width - badge.getWidth(null) - 1, 1, null);
    } finally {
      gfx.dispose();
    }
    return result;
  }

  @Nullable
  public static Image loadImage(@Nonnull final String name) {
    final InputStream inStream = UiUtils.class.getClassLoader().getResourceAsStream("icons/" + name);
    Image result = null;
    if (inStream != null) {
      try {
        result = ImageIO.read(inStream);
      } catch (IOException ex) {
        result = null;
      } finally {
        IOUtils.closeQuetly(inStream);
      }
    }
    return result;
  }

  @Nullable
  public static MMapURI editURI(@Nonnull final String title, @Nullable final MMapURI uri) {
    final UriEditPanel textEditor = new UriEditPanel(uri == null ? null : uri.asString(false, false));

    textEditor.doLayout();
    textEditor.setPreferredSize(new Dimension(450, textEditor.getPreferredSize().height));

    if (DialogProviderManager.getInstance().getDialogProvider().msgOkCancel(title, textEditor)) {
      final String text = textEditor.getText();
      if (text.isEmpty()) {
        return EMPTY_URI;
      }
      try {
        return new MMapURI(text.trim());
      } catch (URISyntaxException ex) {
        DialogProviderManager.getInstance().getDialogProvider().msgError(String.format(BUNDLE.getString("NbUtils.errMsgIllegalURI"), text));
        return null;
      }
    } else {
      return null;
    }
  }

  public static boolean msgOkCancel(@Nonnull final String title, @Nonnull final Object component) {
    return JOptionPane.showConfirmDialog(Main.getApplicationFrame(), component, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null) == JOptionPane.OK_OPTION;
  }

  @Nullable
  public static Color extractCommonColorForColorChooserButton(@Nonnull final String colorAttribute, @Nonnull @MustNotContainNull final Topic[] topics) {
    Color result = null;
    for (final Topic t : topics) {
      final Color color = html2color(t.getAttribute(colorAttribute), false);
      if (result == null) {
        result = color;
      } else if (!result.equals(color)) {
        return ColorChooserButton.DIFF_COLORS;
      }
    }
    return result;
  }

  @Nullable
  public static FileEditPanel.DataContainer editFilePath(@Nonnull final String title, @Nullable final File projectFolder, @Nullable final FileEditPanel.DataContainer data) {
    final FileEditPanel filePathEditor = new FileEditPanel(projectFolder, data);

    filePathEditor.doLayout();
    filePathEditor.setPreferredSize(new Dimension(450, filePathEditor.getPreferredSize().height));

    FileEditPanel.DataContainer result = null;
    if (DialogProviderManager.getInstance().getDialogProvider().msgOkCancel(title, filePathEditor)) {
      result = filePathEditor.getData();
      if (!result.isValid()) {
        DialogProviderManager.getInstance().getDialogProvider().msgError(String.format(BUNDLE.getString("MMDGraphEditor.editFileLinkForTopic.errorCantFindFile"), result.getPath()));
        result = null;
      }
    }
    return result;
  }

  @Nullable
  public static String editText(@Nonnull final String title, @Nonnull final String text) {
    final NoteEditor textEditor = new NoteEditor(text);
    try {
      if (DialogProviderManager.getInstance().getDialogProvider().msgOkCancel(title, textEditor)) {
        return textEditor.getText();
      } else {
        return null;
      }
    } finally {
      textEditor.dispose();
    }
  }

  public static void openInSystemViewer(@Nonnull final File file) {
    final Runnable startEdit = new Runnable() {
      @Override
      public void run() {
        boolean ok = false;
        if (Desktop.isDesktopSupported()) {
          final Desktop dsk = Desktop.getDesktop();
          if (dsk.isSupported(Desktop.Action.OPEN)) {
            try {
              dsk.open(file);
              ok = true;
            } catch (Throwable ex) {
              LOGGER.error("Can't open file in system viewer : " + file, ex);//NOI18N
            }
          }
        }
        if (!ok) {
          SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
              DialogProviderManager.getInstance().getDialogProvider().msgError("Can't open file in system viewer! See the log!");//NOI18N
              Toolkit.getDefaultToolkit().beep();
            }
          });
        }
      }
    };
    final Thread thr = new Thread(startEdit, " MMDStartFileEdit");//NOI18N
    thr.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
      @Override
      public void uncaughtException(final Thread t, final Throwable e) {
        LOGGER.error("Detected uncaught exception in openInSystemViewer() for file " + file, e);
      }
    });

    thr.setDaemon(true);
    thr.start();
  }

  private static void showURL(@Nonnull final URL url) {
    showURLExternal(url);
  }

  private static void showURLExternal(@Nonnull final URL url) {
    if (Desktop.isDesktopSupported()) {
      final Desktop desktop = Desktop.getDesktop();
      if (desktop.isSupported(Desktop.Action.BROWSE)) {
        try {
          desktop.browse(url.toURI());
        } catch (Exception x) {
          LOGGER.error("Can't browse URL in Desktop", x);
        }
      } else if (SystemUtils.IS_OS_LINUX) {
        final Runtime runtime = Runtime.getRuntime();
        try {
          runtime.exec("xdg-open " + url);
        } catch (IOException e) {
          LOGGER.error("Can't browse URL under Linux", e);
        }
      } else if (SystemUtils.IS_OS_MAC) {
        final Runtime runtime = Runtime.getRuntime();
        try {
          runtime.exec("open " + url);
        } catch (IOException e) {
          LOGGER.error("Can't browse URL on MAC", e);
        }
      }
    }

  }

  public static boolean browseURI(@Nonnull final URI uri, final boolean preferInsideBrowserIfPossible) {
    try {
      if (preferInsideBrowserIfPossible) {
        showURL(uri.toURL());
      } else {
        showURLExternal(uri.toURL());
      }
      return true;
    } catch (MalformedURLException ex) {
      LOGGER.error("MalformedURLException", ex); //NOI18N
      return false;
    }
  }

}
