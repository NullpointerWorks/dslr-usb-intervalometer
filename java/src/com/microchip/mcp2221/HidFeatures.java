//©[2016] Microchip Technology Inc.and its subsidiaries.You may use this software and any derivatives exclusively with Microchip products.
//
//THIS SOFTWARE IS SUPPLIED BY MICROCHIP "AS IS".NO WARRANTIES, WHETHER EXPRESS, IMPLIED OR STATUTORY, APPLY TO THIS SOFTWARE, INCLUDING ANY IMPLIED 
//WARRANTIES OF NON - INFRINGEMENT, MERCHANTABILITY, AND FITNESS FOR A PARTICULAR PURPOSE, OR ITS INTERACTION WITH MICROCHIP PRODUCTS, COMBINATION WITH ANY 
//OTHER PRODUCTS, OR USE IN ANY APPLICATION.
//
//IN NO EVENT WILL MICROCHIP BE LIABLE FOR ANY INDIRECT, SPECIAL, PUNITIVE, INCIDENTAL OR CONSEQUENTIAL LOSS, DAMAGE, COST OR EXPENSE OF ANY KIND WHATSOEVER
//RELATED TO THE SOFTWARE, HOWEVER CAUSED, EVEN IF MICROCHIP HAS BEEN ADVISED OF THE POSSIBILITY OR THE DAMAGES ARE FORESEEABLE.TO THE FULLEST EXTENT ALLOWED
//BY LAW, MICROCHIP'S TOTAL LIABILITY ON ALL CLAIMS IN ANY WAY RELATED TO THIS SOFTWARE WILL NOT EXCEED THE AMOUNT OF FEES, IF ANY, THAT YOU HAVE PAID
//DIRECTLY TO MICROCHIP FOR THIS SOFTWARE.
//
//MICROCHIP PROVIDES THIS SOFTWARE CONDITIONALLY UPON YOUR ACCEPTANCE OF THESE TERMS.

package com.microchip.mcp2221;

public class HidFeatures 
{
    
    static
    {
        //check the system architecture
        if(System.getProperty("sun.arch.data.model").equals("32"))
        {
            try
            {
                System.loadLibrary("libmcp2221_jni_x86");   //load the native library at runtime
            }
            catch(Exception ex)
            {
                System.out.println("The specified library does not exist");
            }
        }
        else 
        if(System.getProperty("sun.arch.data.model").equals("64"))
        {
            try
            {
                System.loadLibrary("libmcp2221_jni_x64");   //load the native library at runtime
            }
            catch(Exception ex)
            {
                System.out.println("The specified library does not exist");
                        
            }
        }
    }
    
    
    /**
     * Load native C DLL and check the existence of every function
     * @return 0 for success; error code otherwise
     */
    public native int Mcp2221_LoadDll();

    //==========================================================================
    /**
     * Returns the version number of the DLL.
     * @return  Version number if the operation was successful or NULL if the operation failed.                                                   
     * 
     * <p>NOTE: If the operation failed, call the Mcp2221_GetLastError() method to get the error code.</p>
     */
    public native String Mcp2221_GetLibraryVersion();
    
    //==========================================================================
    /**
     * Gets the number of connected MCP2221s with the provided VID and PID.
     * @param VID   The vendor ID of the MCP2221 devices to count
     * @param PID   The product ID of the MCP2221 devices to count
     * @return      The number of connected MCP2221s matching the provided VID and PID, or if the operation failed, an error code.
     * <p>NOTE: If the operation failed, call the Mcp2221_GetLastError() method to get the error code.</p>
     * @see #Mcp2221_GetLastError()
     */
    public native int Mcp2221_GetConnectedDevices(int VID, int PID);
    
    //==========================================================================
    /**
     * Attempt to open a connection with MCP2221 with specific index.
     * @param VID       The vendor ID of the MCP2221 to connect to (Microchip default = 0x4D8).
     * @param PID       The product ID of the MCP2221 to connect to (Microchip default = 0xDD).
     * @param index     The index of the MCP2221 to connect to. This value ranges from 0 to n-1, where n is the number of connected devices.
     * @return          The handle value if the connection was successfully opened or INVALID_HANDLE_VALUE(-1) if not.
     * <p>NOTE: If the operation failed, call the Mcp2221_GetLastError() method to get the error code.</p>
     * @see #Mcp2221_GetLastError()
     */
    public native long Mcp2221_OpenByIndex(int VID, int PID, int index);
    
    //==========================================================================
    /**
     * Attempt to open a connection with a MCP2221 with the specific serial number.
     * @param VID           The vendor ID of the MCP2221 to connect to (Microchip default = 0x4D8).
     * @param PID           The product ID of the MCP2221 to connect to (Microchip default = 0xDD).
     * @param serialNumber  The serial number of the MCP2221 we want to connect to. Maximum 30 character value.
     * @return              The handle value if the connection was successfully opened or INVALID_HANDLE_VALUE(-1) if not.
     * <p>NOTE: If the operation failed, call the Mcp2221_GetLastError() method to get the error code.</p>
     *          <br>If a connection to a matching device is already open, the function will fail with the "device not found" error.
     * @see #Mcp2221_GetLastError()
     */
    public native long Mcp2221_OpenBySN(int VID, int PID, String serialNumber);
    
    //==========================================================================
    /**
     * Attempt to close a connection to a MCP2221.
     * @param handle    The handle for the device we'll close the connection to.
     * @return          0 for success; error code otherwise
     */
    public native int Mcp2221_Close(long handle);
    
    //==========================================================================
    /**
     * Attempt to close all the currently opened MCP2221 connections. If successful, all existing handles will be set to INVALID_HANDLE_VALUE(-1).
     * @return      0 for success; error code otherwise
     */
    public native int Mcp2221_CloseAll();
    
    //==========================================================================
    /**
     * Reset the MCP2221 and close its associated handle.
     * @param handle    The handle for the device we'll reset. If successful, the handle will also be closed.
     * @return          0 for success, error code otherwise
     */
    public native int Mcp2221_Reset(long handle);
    
    //==========================================================================
    /**
     * Set the communication speed for I2C/SMBus operations.
     * @param handle    The handle for the device.
     * @param speed     The communication speed. Accepted values are between 46875 and 500000.   
     * @return          0 for success, error code otherwise
     * <p>NOTE: The speed may fail to be set if an I2C/SMBus operation is already in progress or in a timeout situation.</p>
     * The "Mcp2221_I2cCancelCurrentTransfer" function can be used to free the bus before retrying to set the speed.
     * @see             #Mcp2221_I2cCancelCurrentTransfer(long handle)
     */
    public native int Mcp2221_SetSpeed(long handle, int speed);
    
    //==========================================================================
    /**
     * Set the time the MCP2221 will wait after sending the "read" command before trying to read back the data
     *  from the I2C/SMBus slave and the maximum number of retries if data couldn't be read back.
     * @param handle        The handle for the device.
     * @param timeout       Amount of time (in ms) to wait for the slave to send back data. (Default = 3ms)
     * @param maxRetries    The maximum amount of times we'll try to read data back from a slave (default value = 5).
     * @return              0 for success; error code otherwise
     */
    public native int Mcp2221_SetAdvancedCommParams(long handle, short timeout, short maxRetries);
    
    //==========================================================================
    /**
     * Cancel the current transfer I2C/SMBus transfer.
     * @param handle    The handle for the device.
     * @return          0 for success; error code otherwise
     */
    public native int Mcp2221_I2cCancelCurrentTransfer(long handle);
    
    //==========================================================================
    /**
     * Read I2C data from a slave.
     * @param handle            The handle for the device.
     * @param bytesToRead       The number of bytes to read from the slave. Valid range is between 1 and 65535.
     * @param slaveAddress      7bit or 8bit I2C slave address, depending on the value of the "use7bitAddress" flag.
                    For 8 bit addresses, the R/W LSB of the address is set to 1 inside the function.
     * @param use7bitAddress    If 'true', 7 bit address will be used for the slave. If 'false', 8 bit is used.
     * @param i2cRxData         Buffer that will contain the data bytes read from the slave.
     * @return                  0 for success; error code otherwise
     * <p>NOTE: If the "Mcp2221_SetSpeed" function has not been called for the provided handle, the default speed of 100kbps will be configured and used.
     *          Otherwise, the speed will not be reconfigured.</p>
     */
    public native int Mcp2221_I2cRead(long handle, int bytesToRead, byte slaveAddress, boolean use7bitAddress, byte[] i2cRxData);
    
    //==========================================================================
    /**
     * Write I2C data to a slave.
     * @param handle            The handle for the device.
     * @param bytesToWrite      The number of bytes to write to the slave. Valid range is between 0 and 65535.
     * @param slaveAddress      7bit or 8bit I2C slave address, depending on the value of the "use7bitAddress" flag.
                    For 8 bit addresses, the R/W LSB of the address is set to 0 inside the function.
     * @param use7bitAddress    If 'true', 7 bit address will be used for the slave. If 'false', 8 bit is used.       
     * @param i2cTxData         Buffer that will contain the data bytes to be sent to the slave.
     * @return                  0 for success, error code otherwise
     * <p>NOTE: If the "Mcp2221_SetSpeed" function has not been called for the provided handle, the default speed of 100kbps will be configured and used. 
     *          Otherwise, the speed will not be reconfigured.</p>
     */
    public native int Mcp2221_I2cWrite(long handle, int bytesToWrite, byte slaveAddress, boolean use7bitAddress, byte[] i2cTxData);
    
    //==========================================================================
    /**
     * SMBus Write Byte. The first byte of a Write Byte operation is the command code. The next one is the data to be written.
     * @param handle            The handle for the device.
     * @param slaveAddress      7bit or 8bit SMBus slave address, depending on the value of the "use7bitAddress" flag.
                                    For 8 bit addresses, the R/W LSB of the address is set to 0 inside the function.
     * @param use7bitAddress    If true, 7 bit address will be used for the slave. If false, 8 bit is used.
     * @param usePec            If true, Packet Error Checking (PEC) will be used. A PEC byte containing the CRC8 value
     *                              for the sent message is appended after the data byte.
     * @param command           The command code byte.
     * @param dataToWrite       The data byte.
     * @return                  0 for success, error code otherwise
     * <p>NOTE: If the "Mcp2221_SetSpeed" function has not been called for the provided handle, the default speed of 100kbps will be configured and used. 
                Otherwise, the speed will not be reconfigured.</p>
     */
    public native int Mcp2221_SmbusWriteByte(long handle, byte slaveAddress, boolean use7bitAddress, boolean usePec, byte command, byte dataToWrite);
    
    //==========================================================================
    /**
     * SMBus Read Byte. First Write the command byte to the slave, then read one data byte back.
     * @param handle            The handle for the device.
     * @param slaveAddrress      7bit or 8bit SMBus slave address, depending on the value of the "use7bitAddress" flag.
                                    For 8 bit addresses, the R/W LSB of the address is set to 1 inside the function.
     * @param use7bitAddress    If true, 7 bit address will be used for the slave. If false, 8 bit is used.
     * @param usePec            If true, Packet Error Checking (PEC) will be used. The CRC8 value is computed for the SMBus packet and 
     *                              compared with PEC byte sent by the slave. If the two values differ, the function returns an error code.
     * @param command           The command byte.
     * @param dataToRead        The data byte received from the slave.
     * @return                  0 for success, error code otherwise
     * <p>NOTE: If the "Mcp2221_SetSpeed" function has not been called for the provided handle, the default speed of 100kbps will be configured and used.
                Otherwise, the speed will not be reconfigured.</p>
     */
    public native int Mcp2221_SmbusReadByte(long handle, byte slaveAddrress, boolean use7bitAddress, boolean usePec, byte command, byte[] dataToRead);
    
    //==========================================================================
    /**
     * SMBus Write Word. The first byte of a Write Byte operation is the command code, followed by the data_byte_low then data_byte_high.
     * @param handle            The handle for the device.
     * @param slaveAdrress      7bit or 8bit SMBus slave address, depending on the value of the "use7bitAddress" flag.
                                    For 8 bit addresses, the R/W LSB of the address is set to 0 inside the function.
     * @param use7bitAddress    If true, 7 bit address will be used for the slave. If false, 8 bit is used.
     * @param usePec            If true, Packet Error Checking (PEC) will be used. A PEC byte containing the CRC8 value
     *                              for the sent message is appended after the data byte.
     * @param command           The command code byte.
     * @param dataToWrite       Array containing the low and high data bytes to be sent to the slave
     *                              <br>* data[0] will be considered the data_byte_low
     *                              <br>* data[1] will be considered the data_byte_high
     * @return                  0 for success, error code otherwise
     * <p>NOTE: If the "Mcp2221_SetSpeed" function has not been called for the provided handle, the default speed of 100kbps will be configured and used. 
                Otherwise, the speed will not be reconfigured.</p>
     */
    public native int Mcp2221_SmbusWriteWord(long handle, byte slaveAdrress, boolean use7bitAddress, boolean usePec, byte command, byte[] dataToWrite);
    
    //==========================================================================
    /**
     * SMBus Read Word. First Write the command byte to the slave, then read one data byte back.
     * @param handle            The handle for the device.
     * @param slaveAddress      7bit or 8bit SMBus slave address, depending on the value of the "use7bitAddress" flag.
                                    For 8 bit addresses, the R/W LSB of the address is set to 1 inside the function.
     * @param use7bitAddress    If true, 7 bit address will be used for the slave. If 0, 8 bit is used.
     * @param usePec            If true, Packet Error Checking (PEC) will be used. The CRC8 value is computed for the SMBus packet and 
     *                              compared with the PEC byte sent by the slave. If the two values differ, the function returns an error code.
     * @param command           The command code byte.
     * @param dataToRead        Buffer that will store the read data word
     *                          <br>* readData[0] - data_byte_low
     *                          <br>* readData[1] - data_byte_high
     * @return                  0 for success, error code otherwise
     * <p>NOTE: If the "Mcp2221_SetSpeed" function has not been called for the provided handle, the default speed of 100kbps will be configured and used.
                Otherwise, the speed will not be reconfigured.</p>
     */
    public native int Mcp2221_SmbusReadWord(long handle, byte slaveAddress, boolean use7bitAddress, boolean usePec, byte command, byte[] dataToRead);
    
    //==========================================================================
    /**
     * SMBus Block Write. The first byte of a Write Block operation is the command code,followed by the number of data bytes, then data bytes.
     * @param handle            The handle for the device.
     * @param slaveAddress      7bit or 8bit SMBus slave address, depending on the value of the "use7bitAddress" flag.
     *                              For 8bit addresses, the R/W LSB of the address is set to 0 inside the function.
     * @param use7bitAddress    If true, 7bit address will be used for the slave. If false, 8bit is used.
     * @param usePec            If true, Packet Error Checking (PEC) will be used. A PEC byte containing the CRC8 value 
     *                              for the sent message is appended after the data byte.
     * @param command           The command code byte.
     * @param byteCount         The number of data bytes that will be sent to the slave. Valid range is between 0 and 255 bytes,
     *                              conforming to the SMBus v3 specification.
     * @param dataToWrite       Array containing the data bytes to be sent to the slave.
     * @return                  0 for success, error code otherwise
     * <p>NOTE: If the "Mcp2221_SetSpeed" function has not been called for the provided handle, the default speed of 100kbps will be configured and used.
     *          Otherwise, the speed will not be reconfigured.</p>
     */
    public native int Mcp2221_SmbusBlockWrite(long handle, byte slaveAddress, boolean use7bitAddress, boolean usePec, byte command, short byteCount, byte[] dataToWrite);
    
    //==========================================================================
    /**
     * SMBus Block Read.
     * @param handle            The handle for the device.
     * @param slaveAddress      7bit or 8bit SMBus slave address, depending on the value of the "use7bitAddress" flag.
     *                              For 8bit addresses, the R/W LSB of the address is set to 1 inside the function.
     * @param use7bitAddress    If true, 7bit address will be used for the slave. If false, 8bit is used.
     * @param usePec            If true, Packet Error Checking (PEC) will be used. The CRC8 value is computed for the SMBus packet and
     *                              compared with the PEC byte sent by the slave. If the two values differ, the function returns an error code.
     * @param command           The command code byte.
     * @param byteCount         The number of data bytes that the slave will send to the master. Valid range is between 1 and 255 bytes. If there is a mismatch
     *                              between this value and the byteCount, the slave reports that it will send, an error will be returned.
     * @param dataToRead        Array containing the data bytes read from the slave. If PEC is used, the last data byte will be the PEC byte received from the slave,
     *                              so the array should have a length of n+1, where n is the block size.
     * @return                  0 for success; error code otherwise
     * <p>NOTE: If the "Mcp2221_SetSpeed" function has not been called for the provided handle, the default speed of 100kbps will be configured and used.
     *          Otherwise, the speed will not be reconfigured.
     */
    public native int Mcp2221_SmbusBlockRead(long handle, byte slaveAddress, boolean use7bitAddress, boolean usePec, byte command, short byteCount, byte[] dataToRead);
    
    //==========================================================================
    /**
     * Read USB Manufacturer Descriptor string from device.
     * @param handle        The handle for the device.
     * @return              String which contains the value of the USB Manufacturer Descriptor String, if the operation was successful, or NULL if not. 
     *                          <br>The output string can contain up to 30 characters.
     * <p>NOTE: If the operation failed, call the Mcp2221_GetLastError() method to get the error code.</p>
     * @see                 #Mcp2221_GetLastError()
     */
    public native String Mcp2221_GetManufacturerDescriptor(long handle);
    
    //==========================================================================
    /**
     * Write USB Manufacturer Descriptor string to the device.
     * @param handle                The handle for the device
     * @param manufacturerString    The value of the USB Manufacturer Descriptor String. The input string can contain a maximum of 30 characters
     * @return                      0 for success; error code otherwise
     */
    public native int Mcp2221_SetManufacturerDescriptor(long handle, String manufacturerString);
    
    //==========================================================================
    /**
     * Read USB Product Descriptor string from device.
     * @param handle    The handle for the device.
     * @return          String which contains the value of the USB Product Descriptor, if the operation was successful, or NULL if not.
     *                      <br>The output string can contain up to 30 characters.
     * <p>NOTE: If the operation failed, call the Mcp2221_GetLastError() method to get the error code.</p>
     * @see             #Mcp2221_GetLastError()
     */
    public native String Mcp2221_GetProductDescriptor(long handle);
    
    //==========================================================================
    /**
     * Write USB Product Descriptor string to the device.
     * @param handle            The handle for the device.
     * @param productString     The value of the USB Product Descriptor String. The input string can contain a maximum of 30 characters.
     * @return                  0 for success, error code otherwise
     */
    public native int Mcp2221_SetProductDescriptor(long handle, String productString);
    
    //==========================================================================
    /**
     * Read USB Serial Number Descriptor string from device.
     * @param handle    The handle for the device.
     * @return          String which contains the value of the Serial Number Descriptor, if the operation was successful, or NULL if not. 
     *                      <br>The output string can contain up to 30 characters.
     * <p>NOTE: If the operation failed, call the Mcp2221_GetLastError() method to get the error code.</p>
     * @see             #Mcp2221_GetLastError()
     */
    public native String Mcp2221_GetSerialNumberDescriptor(long handle);
    
    //==========================================================================
    /**
     * Write USB Serial Number Descriptor string to device.
     * @param handle            The handle for the device.
     * @param serialNumber      The value of the USB Serial Number Descriptor String. The input string can contain a maximum of 30 characters.
     * @return                  0 for success; error code otherwise
     */
    public native int Mcp2221_SetSerialNumberDescriptor(long handle, String serialNumber);
    
    //==========================================================================
    /**
     * Read the factory serial number of the device.
     * @param handle        The handle for the device.
     * @return              String which contains the value of the factory serial number of the device, if the operation was successful, or NULL if not.
     *                          <br>The output string can contain a maximum of 30 characters.
     * <p>NOTE: If the operation failed, call the Mcp2221_GetLastError() method to get the error code.</p>
     * @see                 #Mcp2221_GetLastError()
     */
    public native String Mcp2221_GetFactorySerialNumber(long handle);
    
    //==========================================================================
    /**
     * Gets the VID and PID for the selected device.
     * @param handle    The handle for the device.
     * @param vid       Buffer containing the value for the vendor id of the MCP2221 device.
     * @param pid       Buffer containing the value for the product id of the MCP2221 device.
     * @return          o for success; error code otherwise
     * <p>NOTE: All output arrays must have a minimum length of 1.</p>
     */
    public native int Mcp2221_GetVidPid(long handle, int[] vid, int[] pid);
    
    //==========================================================================
    /**
     * Sets the VID and PID for the selected device.
     * @param handle    The handle for the device.
     * @param vid       The vendor id to be set.
     * @param pid       The product id to be set.
     * @return          0 for success; error code otherwise
     * <p>NOTE: The new VID/PID values will be take effect after a device reset.
     */
    public native int Mcp2221_SetVidPid(long handle, int vid, int pid);
    
    //==========================================================================
    /**
     * Gets the initial values for the special function pins: LEDUARTRX, LEDUARTTX, LEDI2C, SSPND, USBCFG
     * @param handle            The handle for the device.
     * @param ledUtxInitVal     Buffer containing the value that represents the logical level signaled when no Uart Rx activity takes place (inactive level).
     * @param ledUrxInitVal     Buffer containing the value that represents the logical level signaled when no Uart Tx activity takex place (inactive level).
     * @param ledI2cInitVal     Buffer containing the value that represents the logical level signaled when no I2C traffic occurs (inactive level).
     * @param sspndInitVal      Buffer containing the value that represents the logical level signaled when the device is not in suspend mode (inactive level).
     * @param usbCfgInitVal     Buffer containing the value that represents the logical level signaled when the device is not usb configured (inactive level).
     * @return                  0 for success; error code otherwise
     * <p>NOTE: All output arrays must have a minimum length of 1.</p>
     */
    public native int Mcp2221_GetInitialPinValues(long handle, byte[] ledUtxInitVal, byte[] ledUrxInitVal, byte[] ledI2cInitVal, byte[] sspndInitVal, byte[] usbCfgInitVal);
    
    //==========================================================================
    /**
     * Set the initial values for the special function pins: LEDUARTRX, LEDUARTTX, LEDI2C, SSPND and USBCFG
     * @param handle            The handle for the device.
     * @param ledUtxInitVal     The value which represents the logical level signaled when no Uart Rx activity takes place (inactive level).
     * @param ledUrxInitVal     The value which represents the logical level signaled when no Uart Tx activity takes place (inactive level).
     * @param ledI2cInitVal     The value which represents the logical level signaled when no I2C traffic occurs (inactive level).
     * @param sspndInitVal      The value which represents the logical level signaled when the device is not in suspend mode (inactive level).
     * @param usbCfgInitVal     The value which represents the logical level signaled when the device is not usb configured (inactive level).
     * @return                  0 for success; error code otherwise
     */
    public native int Mcp2221_SetInitialPinValues(long handle, byte ledUtxInitVal, byte ledUrxInitVal, byte ledI2cInitVal, byte sspndInitVal, byte usbCfgInitVal);
    
    //==========================================================================
    /**
     * Get the USB power attribute values.
     * @param handle                The handle for the device.
     * @param powerAttributes       Buffer containing the value which represents the power attributes value from the USB descriptor.
     *                                  <br>Bit meanings, based on the USB 2.0 spec:
     *                                      <br>* bit 7 - Reserved (Set to 1) (equivalent to Bus Powered)
     *                                      <br>* bit 6 - Self Powered
     *                                      <br>* bit 5 - Remote Wakeup
     *                                      <br>* bits4..0 Reserved (reset to 0)
     * @param currentReq            Buffer containing the value which represents the requested current value(mA). This value is expressed in multiples of 2mA.
     * @return                      0 for success; error code otherwise
     * <p>NOTE: All output arrays must have a minimum length of 1.</p>
     */
    public native int Mcp2221_GetUsbPowerAttributes(long handle, short[] powerAttributes, int[] currentReq);
    
    //==========================================================================
    /**
     * Sets the USB power attribute values.
     * @param handle            The handle for the device.
     * @param powerAttributes   The power attributes value from the USB descriptor.
     *                              <br>Bit meanings, based on the USB 2.0 spec:
     *                                  <br>* bit 7 - Reserved (Set to 1) (equivalent to Bus Powered)
     *                                  <br>* bit 6 - Self Powered
     *                                  <br>* bit 5 - Remote Wakeup
     *                                  <br>* bits4..0 Reserved (reset to 0)
     * @param currentReq        The requested current value (mA). This value is expressed in multiples of 2mA.
     * @return                  0 for success; error code otherwise
     */
    public native int Mcp2221_SetUsbPowerAttributes(long handle, short powerAttributes, int currentReq);
    
    //==========================================================================
    /**
     * Gets the status of the Serial number enumeration bit.
     * @param handle            The handle for the device.
     * @param snEnumEnabled     Buffer containing the value which determines if the serial number descriptor will be used during the USB enumeration of the CDC interface.
     *                          <br> If 1 - the serial number descriptor is used; if 0 - no serial number descriptor will be present during enumeration.
     * @return                  0 for success; error code otherwise
     * <p>NOTE: All output arrays must have a minimum length of 1.</p>
     */
    public native int Mcp2221_GetSerialNumberEnumerationEnable(long handle, byte[] snEnumEnabled);
    
    //==========================================================================
    /**
     * Sets the status of the Serial number enumeration bit.
     * @param handle            The handle for the device.
     * @param snEnumEnabled     The value which determines if the serial number descriptor will be used during the USB enumeration of the CDC interface.
     *                          <br>If 1 - the serial number descriptor is used; if 0 - no serial number descriptor will be present during enumeration.
     * @return                  0 for success; error code otherwise
     */
    public native int Mcp2221_SetSerialNumberEnumerationEnable(long handle, byte snEnumEnabled);
    
    //==========================================================================
    /**
     * Gets the state of flash protection for the device.
     * @param handle            The handle for the device.
     * @param securitySetting   Buffer containing the value which represents the chip security option
     *                              <br>* 0 - unsecured
     *                              <br>* 1 - password protected
     *                              <br>* 2 - permanently locked
     * @return                  0 for success; error code otherwise
     * <p>NOTE: All output arrays must have a minimum length of 1.</p>
     */
    public native int Mcp2221_GetSecuritySetting(long handle, byte[] securitySetting);
    
    //==========================================================================
    /**
     * Sets the state of flash protection for the device.
     * @param handle            The handle of the device.
     * @param securitySetting   The value of the chip security option. If any other values are used, The E_ERR_INVALID_PARAMETER(-4) error is returned.
     *                              <br>*    0 - disable password protection
     *                              <br>*    1 - enable password protection
     *                              <br>* 0xFF - change the current password
     * @param currentPassword   The value for the currently set password. This is used for when the password "disable" or "change" operations are taking place.
     * @param newPassword       The value for the new password. Must be an 8 character string. This is only for the "enable" or "change" operations.
     * @return                  0 for success; error code otherwise
     */
    public native int Mcp2221_SetSecuritySetting(long handle, byte securitySetting, String currentPassword, String newPassword);
    
    //==========================================================================
    /**
     * Permanently lock the device flash settings -- this action CAN'T be undone.
     * @param handle    The handle for the device.
     * @return          0 for success; error code otherwise
     * <p>!!! WARNING !!! -- USE THIS FUNCTION WITH GREAT CAUTION.  THE CHIP FLASH SETTINGS (boot-up defaults) CANNOT BE
                CONFIGURED AFTER THIS FUNCTION HAS BEEN INVOKED!!</p>
     */
    public native int Mcp2221_SetPermanentLock(long handle);
    
    //==========================================================================
    /**
     * Sends the access password to the device.
     * @param handle        The handle for the device.
     * @param password      The password that will be sent to the device to unlock writing to flash. Must be an 8 character string.
     * @return              0 for success; error code otherwise
     * <p>NOTE: If 3 flash writes are attempted with an incorrect password, the chip won't accept any more passwords. This function doesn't validate the password, it just sends it to the device. 
     *          The password is checked only during a flash write.</p>
     */
    public native int Mcp2221_SendPassword(long handle, String password);
    
    //==========================================================================
    /**
     * Gets the interrupt pin trigger configuration.
     * @param handle            The handle for the device.
     * @param whichToGet        0 to read Flash settings, greater than 0 to read SRAM (runtime) settings
     * @param interruptPinMode  Buffer containing the value representing which edge will trigger the interrupt.
     *                              <br>* 0 - none
     *                              <br>* 1 - positive edge
     *                              <br>* 2 - negative edge
     *                              <br>* 3 - both
     * @return                  0 for success; error code otherwise
     * <p>NOTE: All output arrays must have a minimum length of 1.</p>
     */
    public native int Mcp2221_GetInterruptEdgeSetting(long handle, byte whichToGet, byte[] interruptPinMode);
    
    //==========================================================================
    /**
     * Sets the interrupt pin trigger configuration.
     * @param handle            The handle for the device.
     * @param whichToSet        0 to write Flash settings; greater than 0 to write SRAM (runtime) settings
     * @param interruptPinMode  The value representing which edge will trigger the interrupt
     *                              <br>* 0 -none
     *                              <br>* 1 - positive edge
     *                              <br>* 2 - negative edge
     *                              <br>* 3 - both
     * @return                  0 for success; error code otherwise
     */
    public native int Mcp2221_SetInterruptEdgeSetting(long handle, byte whichToSet, byte interruptPinMode);
    
    //==========================================================================
    /**
     * Clears the interrupt pin flag of a device.
     * @param handle    The handle for the device.
     * @return          0 for success; error code otherwise
     */
    public native int Mcp2221_ClearInterruptPinFlag(long handle);
    
    //==========================================================================
    /**
     * Reads the interrupt pin flag value of a device.
     * @param handle        The handle for the device.
     * @param flagValue     Buffer containing the value of the interrupt on change flag.
     * @return              0 for success; error code otherwise
     * <p>NOTE: All output arrays must have a minimum length of 1.</p>
     */
    public native int Mcp2221_GetInterruptPinFlag(long handle, byte[] flagValue);
    
    //==========================================================================
    /**
     * Reads the hardware revision value from the device.
     * @param handle    The handle for the device.
     * @return          String containing the hardware revision string if the operation was successful, or NULL if not.
     * <p>NOTE: If the operation failed, call the Mcp2221_GetLastError() method to get the error code.</p>
     * @see             #Mcp2221_GetLastError()
     */
    public native String Mcp2221_GetHardwareRevision(long handle);
    
    //==========================================================================
    /**
     * Reads the firmware revision value from the device.
     * @param handle    The handle for the device.
     * @return          String containing the firmware revision string if the operation was successful, or NULL if not.
     * <p>NOTE: If the operation failed, call the Mcp2221_GetLastError() method to get the error code.</p>
     * @see             #Mcp2221_GetLastError()
     */
    public native String Mcp2221_GetFirmwareRevision(long handle);
    
    //==========================================================================
    /**
     * Gets the duty cycle and clock divider values for the clock out pin (if configured for this operation).
     * @param handle            The handle for the device.
     * @param whichToGet        0 to read Flash settings, greater than 0 to read SRAM (runtime) settings
     * @param dutyCycle         Buffer containing the value of the duty cycle of the waveform on clock pin
     *                              <br>* 0 - 0%
     *                              <br>* 1 - 25%
     *                              <br>* 2 - 50%
     *                              <br>* 3 - 75%
     * @param clockDivider      Buffer containing the value of the clock divider. The value provided is a power of 2. The 48MHz internal clock is divided by 2^value to obtain the output waveform frequency.
     *                              The correspondence between the divider values and output frequencies are as follows:
     *                                  <br>* 1 - 24 MHz
     *                                  <br>* 2 - 12 MHz
     *                                  <br>* 3 - 6 MHz
     *                                  <br>* 4 - 3 MHz
     *                                  <br>* 5 - 1.5 MHz
     *                                  <br>* 6 - 750 kHz
     *                                  <br>* 7 - 375 kHz
     * @return                  0 for success; error code otherwise
     * <p>NOTE: All output arrays must have a minimum length of 1.</p>
     */
    public native int Mcp2221_GetClockSettings(long handle, byte whichToGet, byte[] dutyCycle, byte[] clockDivider);
    
    //==========================================================================
    /**
     * Sets the duty cycle and clock divider values for the clock out pin (if configured for this operation).
     * @param handle        The handle for the device.
     * @param whichToSet    0 to write Flash settings, greater than 0 to write SRAM (runtime) settings.
     * @param dutyCycle     The value of the duty cycle of the waveform on the clock pin
     *                          <br>* 0 - 0%
     *                          <br>* 1 - 25%
     *                          <br>* 2 - 50%
     *                          <br>* 3 - 75%
     * @param clockDivider  The value of the clock divider. The value provided is a power of 2. The 48MHz internal clock is divided by 2^value to obtain the output waveform frequency.
     *                          The correspondence between the clock divider values and the output frequencies are as follows:
     *                              <br>* 1 - 24 MHz
     *                              <br>* 2 - 12 MHz
     *                              <br>* 3 - 6 MHz
     *                              <br>* 4 - 3 MHz
     *                              <br>* 5 - 1.5 MHz
     *                              <br>* 6 - 750 kHz
     *                              <br>* 7 - 375 kHz
     * @return              0 for success; error code otherwise
     */
    public native int Mcp2221_SetClockSettings(long handle, byte whichToSet, byte dutyCycle, byte clockDivider);
    
    //==========================================================================
    /**
     * Gets the GPIO settings.
     * @param handle            The handle for the device.
     * @param whichToGet        0 to read Flash settings, greater than 0 to read SRAM (runtime) settings
     * @param pinFunctions      Array containing the values for the pin functions. pinFunctions[i] will contain the value for GP"i".
     *                              <br>Possible values: 0 to 3. 0 - GPIO; 1 - Dedicated function; 2 - Alternate function 0; 3 - alternate function 1, 4 - alternate function 2
     *                                  <br>* GP0: 0 - GPIO; 1 - SSPND; 2 - LED UART RX
     *                                  <br>* GP1: 0 - GPIO; 1 - Clock Out; 2 - ADC1; 3 - LED UART TX; 4 - Interrupt detection
     *                                  <br>* GP2: 0 - GPIO; 1 - USBCFG; 2 - ADC2; 3 - DAC1
     *                                  <br>* GP3: 0 - GPIO; 1 - LED I2C; 2 - ADC3; 3 - DAC2
     * @param pinDirections     Array containing the pin direction of the IO pins
     *                              <br>* 0 - output
     *                              <br>* 1 - input
     * @param outputValues      Array containing the value present on the output pins
     *                              <br>* 0 - logic low
     *                              <br>* 1 - logic high
     * @return                  0 for success; error code otherwise
     * <p>NOTE: All output arrays must have a minimum length of 4.</p>
     */
    public native int Mcp2221_GetGpioSettings(long handle, byte whichToGet, byte[] pinFunctions, byte[] pinDirections, byte[] outputValues);
    
    //==========================================================================
    /**
     * Sets the GPIO settings.
     * @param handle            The handle for the device.
     * @param whichToSet        0 to write Flash settings, greater than 0 to write SRAM (runtime) settings
     * @param pinFunctions      Array containing the values for the pin functions. pinFunctions[i] will contain the value for GP"i".
     *                              <br>Possible values: 0 to 3. 0 - GPIO; 1 - Dedicated function; 2 - Alternate function 0; 3 - alternate function 1, 4 - alternate function 2
     *                                  <br>* GP0: 0 - GPIO; 1 - SSPND; 2 - LED UART RX
     *                                  <br>* GP1: 0 - GPIO; 1 - Clock Out; 2 - ADC1; 3 - LED UART TX; 4 - Interrupt detection
     *                                  <br>* GP2: 0 - GPIO; 1 - USBCFG; 2 - ADC2; 3 - DAC1
     *                                  <br>* GP3: 0 - GPIO; 1 - LED I2C; 2 - ADC3; 3 - DAC2
     * @param pinDirections     Array containing the pin direction of the IO pins
     *                              <br>* 0    - output
     *                              <br>* 1    - input
     *                              <br>* 0xFF - leave unchanged
     * @param outputValues      Array containing the value present on the output pins
     *                              <br>* 0    - logic low
     *                              <br>* 1    - logic high
     *                              <br>* 0xFF - leave unchanged
     * @return                  0 for success; error code otherwise
     * <p>NOTE: All input arrays must have a minimum length of 4.</p>
     **/
    public native int Mcp2221_SetGpioSettings(long handle, byte whichToSet, byte[] pinFunctions, byte[] pinDirections, byte[] outputValues);
    
    //==========================================================================
    /**
     * Gets the GPIO pin values.
     * @param handle            The handle for the device.
     * @param gpioValues        Array containing the value present on the IO pins.
     *                              <br>* 0    - logic low
     *                              <br>* 1    - logic high
     *                              <br>* 0xEE - GPx not set for GPIO operation
     * @return                  0 for success; error code otherwise
     * <p>NOTE: The output array must have a minimum length of 4.</p>
     */
    public native int Mcp2221_GetGpioValues(long handle, byte[] gpioValues);
    
    //==========================================================================
    /**
     * Sets the GPIO pin values.
     * @param handle        The handle for the device.
     * @param gpioValues    Array containing the value of the output IO pins
     *                          <br>* 0 - logic low
     *                          <br>* 1 - logic high
     * @return              0 for success; error code otherwise
     * <p>NOTE: The input array must have a minimum length of 4.</p>
     */
    public native int Mcp2221_SetGpioValues(long handle, byte[] gpioValues);
    
    //==========================================================================
    /**
     * Gets the GPIO pin directions.
     * @param handle    The handle for the device.
     * @param gpioDir   Array containing the direction of an IO pin.
     *                      <br>* 0    - output
     *                      <br>* 1    - input
     *                      <br>* 0xEF - GPx not set for GPIO operation
     * @return          0 for success; error code otherwise
     * <p>NOTE: The output array must have a minimum length of 4.</p>
     */
    public native int Mcp2221_GetGpioDirection(long handle, byte[] gpioDir);
    
    //==========================================================================
    /**
     * Sets the GPIO pin directions.
     * @param handle    The handle for the device.
     * @param gpioDir   Array containing the direction of an IO pin
     *                      <br>* 0 - output
     *                      <br>* 1 - input
     * @return          0 for success; error code otherwise
     * <p>NOTE: The input array must have a minimum length of 4.</p>
     */
    public native int Mcp2221_SetGpioDirection(long handle, byte[] gpioDir);
    
    //==========================================================================
    /**
     * Gets the DAC voltage reference.
     * @param handle        The handle of the device.
     * @param whichToGet    0 to read Flash settings, greater than 0 to read SRAM (runtime) settings.
     * @param dacVref       Buffer containing the value of voltage reference for the DAC:
     *                          <br>* 0 - Vdd
     *                          <br>* 1 - 1.024 V
     *                          <br>* 2 - 2.048 V
     *                          <br>* 3 - 4.096 V
     * @return              0 for success; error code otherwise
     * <p>NOTE: The output array must have a minimum length of 1.</p>
     */
    public native int Mcp2221_GetDacVref(long handle, byte whichToGet, byte[] dacVref);
    
    //==========================================================================
    /**
     * Sets the DAC voltage reference.
     * @param handle        The handle for the device.
     * @param whichToSet    0 to write Flash settings, greater than 0 to write SRAM (runtime) settings.
     * @param dacVref       The voltage reference for DAC:
     *                          <br>* 0 - Vdd
     *                          <br>* 1 - 1.024 V
     *                          <br>* 2 - 2.048 V
     *                          <br>* 3 - 4.096 V
     * @return              0 for success; error code otherwise
     */
    public native int Mcp2221_SetDacVref(long handle, byte whichToSet, byte dacVref);
    
    //==========================================================================
    /**
     * Gets the DAC values.
     * @param handle        The handle for the device.
     * @param whichToGet    0 to read Flash settings, greater than 0 to read SRAM (runtime) settings.
     * @param dacValue      Buffer containing the DAC output value. Valid range is between 0 and 31.
     * @return              0 for success; error code otherwise
     * <p>NOTE: The output array must have a minimum length of 1.</p>
     */
    public native int Mcp2221_GetDacValue(long handle, byte whichToGet, byte[] dacValue);
    
    //==========================================================================
    /**
     * Sets the DAC value.
     * @param handle        The handle for the device.
     * @param whichToSet    0 to write Flash settings, greater than 0 to write SRAM (runtime) settings.
     * @param dacValue      The DAC output value. Valid range is between 0 and 31.
     * @return              0 for success; error code otherwise
     */
    public native int Mcp2221_SetDacValue(long handle, byte whichToSet, byte dacValue);
    
    //==========================================================================
    /**
     * Gets the ADC voltage reference.
     * @param handle        The handle for the device.
     * @param whichToGet    0 to read Flash settings, greater than 0 to read SRAM (runtime) settings.
     * @param adcVref       Buffer containing the value for voltage reference for ADC:
     *                          <br>* 0 - Vdd
     *                          <br>* 1 - 1.024 V
     *                          <br>* 2 - 2.048 V
     *                          <br>* 3 - 4.096 V
     * @return              0 for success; error code otherwise
     * <p>NOTE: The output array must have a minimum length of 1.</p>
     */
    public native int Mcp2221_GetAdcVref(long handle, byte whichToGet, byte[] adcVref);
    
    //==========================================================================
    /**
     * Sets the ADC voltage reference.
     * @param handle        The handle for the device.
     * @param whichToSet    0 to write Flash settings, greater than 0 to write SRAM (runtime) settings.
     * @param adcVref       The voltage reference for the ADC:
     *                          <br>* 0 - Vdd
     *                          <br>* 1 - 1.024 V
     *                          <br>* 2 - 2.048 V
     *                          <br>* 3 - 4.096 V
     * @return              0 for success; error code otherwise
     */
    public native int Mcp2221_SetAdcVref(long handle, byte whichToSet, byte adcVref);
    
    //==========================================================================
    /**
     * Reads the ADC data for all 3 analog pins.
     * @param handle    The handle for the device.
     * @param adcData   Array containing the ADC values. Entry 0 will contain the value for ADC1, entry 1 - ADC2, entry 2 - ADC3
     * @return          0 for success; error code otherwise
     * <p>NOTE: The output array must have a minimum length of 3.</p>
     */
    public native int Mcp2221_GetAdcData(long handle, int[] adcData);
     
    /**
     * Gets the last error value.
     * @return      The value for the last error code.
     */
    public native int Mcp2221_GetLastError();
    
    
    
    
    
    
    
}
