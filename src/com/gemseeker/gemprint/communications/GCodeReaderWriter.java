package com.gemseeker.gemprint.communications;

import com.gemseeker.gemprint.Printer;

/**
 * GCodeReaderWriter is responsible for reading from and writing into the 3D printer
 * through serial connection.
 *
 * @author gemini1991
 */
public class GCodeReaderWriter {

    private final Printer printer;
    
    public GCodeReaderWriter(Printer printer) {
        this.printer = printer;
    }
    
    public void sendLine(String command) {
        
    }
    
}
