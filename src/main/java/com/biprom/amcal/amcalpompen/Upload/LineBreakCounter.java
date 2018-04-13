package com.biprom.amcal.amcalpompen.Upload;

import com.vaadin.ui.Upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;


public class LineBreakCounter implements Upload.Receiver {
    private int counter;
    private int total;
    private boolean sleep;
    private  File file;

    // Callback method to begin receiving the upload.
    @Override
    public OutputStream receiveUpload(String filename,
                                      String MIMEType) {
        FileOutputStream fos = null; // Output stream to write to
        file = new File("/Users/bramvandenberghe/uplPicToDB/" + filename);
        try {
            // Open the file for writing.
            fos = new FileOutputStream(file);
        } catch (final java.io.FileNotFoundException e) {
            // Error while opening the file. Not reported here.
            e.printStackTrace();
            return null;
        }

        return fos; // Return the output stream to write to
    }

//    @Override
//    public OutputStream receiveUpload(final String filename, final String MIMEType) {

//
//        counter = 0;
//        total = 0;
//        return new OutputStream() {
//            private static final int searchedByte = '\n';
//
//
//            @Override
//            public void write(final int b) {
//                total++;
//                if (b == searchedByte) {
//                    counter++;
//                }
//                if (sleep && total % 1000 == 0) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (final InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//    }

    public int getLineBreakCount() {
        return counter;
    }

    public void setSlow(boolean value) {
        sleep = value;
    }
}


