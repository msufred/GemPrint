package com.gemseeker.gemprint.machines;

import com.gemseeker.gemprint.Printer;
import jssc.SerialPort;
import jssc.SerialPortException;

/**
 * GenerixPrinter represents any 3D printer. This abstract class only implements
 * methods general to almost all kinds of 3D printer.
 * 
 * @author gemini1991
 */
public abstract class GenericPrinter implements Printer {

    protected String port;
    protected int baudrate;
    protected SerialPort serialPort;

    @Override
    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public void setBaudrate(int baudrate) {
        this.baudrate = baudrate;
    }
    
    @Override
    public void connect(String portName) {
        serialPort = new SerialPort(portName);
        
        // open port
        try {
            serialPort.openPort();
        } catch (SerialPortException e) {
            System.err.println("Can't open serial port.\n" + e);
        }
        
        // set baudrate
        try {
            serialPort.setParams(baudrate, 
                    SerialPort.DATABITS_8, 
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
        } catch (SerialPortException e) {
            System.err.println("Error setting baudrate and other parameters.\n" + e);
        }
        
        // get input and output stream...
    }

    @Override
    public void disconnect() {
        if (serialPort != null) {
            try {
                serialPort.closePort();
            } catch (SerialPortException e) {
                System.err.println("Failed to close serial port.\n" + e);
            }
        }
    }

    
}
