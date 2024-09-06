import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class Function_File {

    GUI gui;
    String fileName;
    String fileAddress;

    public Function_File(GUI gui) {
        this.gui = gui;
    }

    public void newFile() {
        gui.textArea.setText("");
        gui.window.setTitle("New");
        fileName = null;
        fileAddress = null;
    }

    public void open() {
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        // load the file
        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }
        System.out.println("File address and file name" + fileAddress + fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            gui.textArea.setText("");
            String line = null;
            while ((line = br.readLine()) != null) {
                gui.textArea.append(line + "\n");
            }
            br.close();

        } catch (Exception e) {
            System.out.println("FILE NOT OPENED");
        }
    }

    public void save() {
        if (fileName == null) {
            saveAs();
        } else {
            try {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fw.close();
            } catch (Exception e) {
                System.out.println("SOMETHING WRONG");
            }
        }
    }

    public void saveAs() {
        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);

            try {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.textArea.getText());
                fw.close();

            } catch (Exception e) {
                System.out.println("SOMETHING WRONG");
            }

        }
    }

    public void exit() {
        System.exit(0);
    }

    public void print() {
        try {
            // Create a PrinterJob
            PrinterJob printerJob = PrinterJob.getPrinterJob();

            // Set the printable object to the textArea's printable object
            printerJob.setPrintable(gui.textArea.getPrintable(null, null));

            // Show the print dialog
            if (printerJob.printDialog()) {
                // If the user clicks "Print" in the dialog, print the document
                printerJob.print();
            }
        } catch (PrinterException e) {
            System.out.println("Printing failed: " + e.getMessage());
        }
    }
}
