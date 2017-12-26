package Examples;
import java.awt.BorderLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import javax.swing.JFrame;
import javax.swing.JTextField;


public class DragDrop extends JFrame implements DropTargetListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2634459465126041816L;
	DropTarget dt;
	JTextField tf;

	public DragDrop() {
		super("Drag & Drop Example");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tf = new JTextField();
		dt = new DropTarget(tf, this);
		
		this.getContentPane().add(tf, BorderLayout.CENTER);
		this.setSize(400, 60);
		this.setVisible(true);
	}

	public void dragEnter(DropTargetDragEvent dtde) {
		System.out.println("Drag Init");
	}

	public void dragExit(DropTargetEvent dte) {
		System.out.println("Drag End");
	}

	public void dragOver(DropTargetDragEvent dtde) {
		System.out.println("Drag Over");
	}

	public void dropActionChanged(DropTargetDragEvent dtde) {
		System.out.println("Drop Action Changed");
	}

	public void drop(DropTargetDropEvent dtde) {
		try {
			/* Get the dropped object */
			Transferable tr = dtde.getTransferable();
			DataFlavor[] flavors = tr.getTransferDataFlavors();
			for (int i = 0; i < flavors.length; i++) {
				System.out.println("Possible flavor: " + flavors[i].getMimeType());
				/* Check for file lists specifically */
				if (flavors[i].isFlavorJavaFileListType()) {
					/*  Drop Accepted */
					dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
					/* ta.setText("Successful file list drop.\n\n"); */

					/* And add the list of file name to our text field */
					@SuppressWarnings("rawtypes")
					java.util.List list = (java.util.List)tr.getTransferData(flavors[i]);
					/* The program allows to take a folder at time */
					/* if i want more folders/files at time, change the tf into jTexarea and use list.get(j) below */
					for (int j = 0; j < list.size(); j++) {
						tf.setText(list.get(0) + "\n");
					}

					/* Everything worked */
					dtde.dropComplete(true);
					return;
				}
			}

			/* the user must not have dropped a file/folder list */
			System.out.println("Drop failed: " + dtde);
			dtde.rejectDrop();
		} catch (Exception e) {
			e.printStackTrace();
			dtde.rejectDrop();
		}
	}

	public static void main(String args[]) {
		new DragDrop();
	}
	
} 
