/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package se.pmdit.clipboardmanager;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import se.pmdit.clipboardmanager.ClipboardHandler.Type;

/**
 *
 * @author pmd
 */
public class ClipboardData implements Transferable {

  private Transferable data;
  private Type type;
  private DataFlavor flavor;
  private String mimeType;


  public ClipboardData(Transferable data, DataFlavor flavor) throws UnsupportedFlavorException, IOException {
    this.data = data;
    this.flavor = flavor;
    readMimeType();
    verifyFlavor();
  }

  private void verifyFlavor() throws UnsupportedFlavorException, IOException {
    this.data.getTransferData(this.flavor);
  }

  private void readMimeType() {
    DataFlavor[] flavours = data.getTransferDataFlavors();
    this.mimeType = flavours[flavours.length - 1].getHumanPresentableName();

    updateType();
  }

  private void updateType() {
    if(mimeType.startsWith("text/")) {
      type = Type.TEXT;
    }
    else if(mimeType.startsWith("image/")) {
      type = Type.IMAGE;
    }
    else if(mimeType.endsWith("file-list")) {
      type = Type.FILE_LIST;
    }
  }

  public Object getValue() {
    try {
      return data.getTransferData(this.flavor);
    }
    catch (UnsupportedFlavorException e) {
      System.out.println("Really should NEVER happen since this Transferable has been verified in the constructor!");
      e.printStackTrace();
    }
    catch (IOException e) {
      System.out.println("Really should NEVER happen since this Transferable has been verified in the constructor!");
      e.printStackTrace();
    }

    return null;
  }

  public Transferable getDataTransferable() {
    return data;
  }

  public Type getType() {
    return this.type;
  }

  public String getMimeType() {
    return this.mimeType;
  }

  @Override
  public DataFlavor[] getTransferDataFlavors() {
    return data.getTransferDataFlavors();
  }

  @Override
  public boolean isDataFlavorSupported(DataFlavor flavor) {
    return data.isDataFlavorSupported(flavor);
  }

  @Override
  public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
    return data.getTransferData(flavor);
  }

  @Override
  public boolean equals(Object other) {
    if(other instanceof ClipboardData) {
      return this.getValue().equals( ((ClipboardData)other).getValue() );
    }

    return false;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 47 * hash + (this.data != null ? this.data.hashCode() : 0);
    return hash;
  }
}
