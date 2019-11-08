package com.gemseeker.gemprint;

import jssc.SerialPortException;

/**
 *
 * Printer interface represents your 3D printer. This interface contains methods
 * for retrieving current positions of each carriage (coordinates in x, y and z),
 * for moving carriage in desired position, for extruding and retracting filament,
 * and for starting, pausing, resuming and stopping printing operations.
 * 
 * @author gemini1991
 */
public interface Printer {
    
    /*============================
        PRINTER CONNECTION METHODS
    ==============================*/
    
    void connect(String portName);
    void disconnect();
    
    
    /*============================
        PRINTER SETTER METHODS
    ==============================*/
    
    void setPort(String port);
    void setBaudrate(int baudrate);
    
    void setX(double x);
    void setY(double y);
    void setZ(double z);
    
    void setExtruderTemp(double temp);
    void setBedTemp(double temp);
    
    
    /*============================
        PRINTER GETTER METHODS
    ==============================*/

    boolean isConnected();
    boolean isPrinting();
    
    double getX();
    double getY();
    double getZ();
    double[] getCoordinates();
    
    double getExtruderTemp();
    double getBedTemp();
    
    
    /*============================
        PRINTER ACTIONS METHODS
    ==============================*/
    
    void home();
    void homeToZeroX();
    void homeToZeroY();
    void homeToZeroZ();
    
    void zeroX();
    void zeroY();
    void zeroZ();
    void zeroExtruder();
    
    void moveTo(double x, double y, double z, double feedRate,
            boolean startUp, boolean endUp);
    
    void singleMove(double x, double y, double z, double feedRate);
    
    void extrudeFilament(double length, double feedRate);
    void retractFilament(double length, double feedRate);
    
    void stopMotors();
    
    void pause();
    void resume();
}
