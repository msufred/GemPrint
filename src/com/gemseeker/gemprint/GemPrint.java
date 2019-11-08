package com.gemseeker.gemprint;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

/**
 *
 * @author gemini1991
 */
public class GemPrint {

    // jSSC test
    public static void main(String[] args) {
        // list all serial ports
        String[] portNames = SerialPortList.getPortNames();
        for (String port: portNames) {
            System.out.println(port);
        }
        
        // writing data to serial port
//        SerialPort serialPort = new SerialPort("COM1");
//        try {
//            serialPort.openPort();
//            serialPort.setParams(SerialPort.BAUDRATE_115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
//            serialPort.writeBytes("This is a test.".getBytes());
//            serialPort.closePort();
//        } catch (SerialPortException ex) {
//            System.out.println(ex);
//        }

        // reading data from serial port
        SerialPort serialPort = new SerialPort("COM1");
        try {
            serialPort.openPort();//Open serial port
            serialPort.setParams(9600, 8, 1, 0);//Set params.
            byte[] buffer = serialPort.readBytes(10);//Read 10 bytes from serial port
            serialPort.closePort();//Close serial port
        } catch (SerialPortException ex) {
            System.out.println(ex);
        }

    }
    
}
