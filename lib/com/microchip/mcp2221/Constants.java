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

public class Constants {
    
    /**
     * Operation was successful.
     */
    public static final int E_NO_ERR = 0;
    /**
     * Unknown error.
     * This can happen in the 'Mcp2221_GetConnectedDevic', 'Mcp2221_OpenByIndex' or 'Mcp2221_OpenBySN'
     * if searching through the connected hid devices fails.
     * Suggestion: This is a command failure indication. Depending on the application, the next step can be 
     * a device status check followed by command retry.
     */
    public static final int E_ERR_UNKNOWN_ERROR = -1;
    /**
     * Command failure indication.
     * The library indicates an unexpected device reply after being given a command:
     * neither successful operation not specific error code.
     * Suggestion: Depending on the application strategy, the next step can be a device status
     * check followed by command retry.
     */
    public static final int E_ERR_CMD_FAILED = -2;
    /**
     * Invalid device handle usage attempt.
     * The device is already closed or there is an issue with the device handles
     * management in the application.
     * Suggestion: Re-open the device, or exit the application.
     */
    public static final int E_ERR_INVALID_HANDLE = -3;
    /**
     * At least one API parameter is not valid.
     * Suggestion: Check the parameter validity and try again.
     */
    public static final int E_ERR_INVALID_PARAMETER = -4;
    /**
     * Invalid password (length {@literal <} 8).
     * Suggestion: Check the password string and try again.
     */
    public static final int E_ERR_INVALID_PASS = -5;
    /**
     * An incorrect password was sent 3 times.
     * Suggestion: Reset the device, check the password and try again.
     */
    public static final int E_ERR_PASSWORD_LIMIT_REACHED = -6;
    /**
     * The command cannot be executed because the device is password protected or locked.
     * Suggestion: Check the security settings (Mcp2221_GetSecuritySettings) and if device is not
     * permanently locked, send the current password before retrying the operation.
     */
    public static final int E_ERR_FLASH_WRITE_PROTECTED = -7;
    
    /**
     * Null pointer received.
     * Suggestion: Validate the input parameters.
     */
    public static final int E_ERR_NULL = -10;
    /**
     * Destination string too small.
     */
    public static final int E_ERR_DESTINATION_TOO_SMALL = -11;
    /**
     * The input string exceeds the maximum allowed size.
     * Suggestion: Check if the string length is within the range provided in the function documentation.
     */
    public static final int E_ERR_INPUT_TOO_LARGE = -12;
    /**
     * Flash write failed due to an unknown cause.
     */
    public static final int E_ERR_FLASH_WRITE_FAILED = -13;
    
    /**
     * An attempt was made to open a connection to a non existing index.
     * Usually index {@literal >}= number of connected devices.
     * Suggestion: Check the number of connected devices (with Mcp2221_GetConnectedDevices);
     * the index must be smaller.
     */
    public static final int E_ERR_NO_SUCH_INDEX = -101;
    /**
     * No device with provided vid/pid or serial must has been found.
     * This error can be also occur during I2C/SMBUS operations if the device is disconnected
     * from the USB before operation is complete. 
     * The Mcp2221_OpenBySN method will also return this code if a connection to a matching device is already opened.
     */
    public static final int E_ERR_DEVICE_NOT_FOUND = -103;
    /**
     * One of the internal buffers of the function was too small.
     * Suggestion: No action.
     */
    public static final int E_ERR_INTERNAL_BUFFER_TOO_SMALL = -104;
    /**
     * An error occurred when trying to get the device handle.
     * Suggestion: Retry operation.
     */
    public static final int E_ERR_OPEN_DEVICE_ERROR = -105;
    /**
     * Connection already opened.
     * Suggestion: Sharing mode is not allowed.
     */
    public static final int E_ERR_CONNECTION_ALREADY_OPENED = -106;
    /**
     * File close operation failed due to unknown reasons.
     * Suggestion: Try again or exit the application.
     */
    public static final int E_ERR_CLOSE_FAILED = -107;
    
    /**
     * Low level communication error.
     * It shouldn't appear during normal operation.
     * Suggestion: Restart application.
     */
    public static final int E_ERR_RAW_TX_TOO_LARGE = -301;
    /**
     * Low level communication error.
     * It shouldn't appear during normal operation.
     * Suggestion: Restart application.
     */
    public static final int E_ERR_RAW_TX_COPYFAILED = -302;
    /**
     * Low level communication error.
     * It shouldn't appear during normal operation.
     * Suggestion: Restart application.
     */
    public static final int E_ERR_RAW_RX_COPYFAILED = -303;
    
    //I2C ERRORS
    /**
     * I2C/SMBUS speed is not within accepted range of 46875 - 500000.
     */
    public static final int E_ERR_INVALID_SPEED = -401;
    /**
     * The speed may fail to be set if an I2C/SMBUS operation is already in progress or in a timeout situation.
     * The "Mcp2221_I2cCancelCurrentTransfer" function can be used to free the bus before retrying to set the speed.
     */
    public static final int E_ERR_SPEED_NOT_SET = -402;
    /**
     * The byte count is outside the accepted range for the attempted operation.
     * Suggestion: Check the valid range for desired operation and retry.
     */
    public static final int E_ERR_INVALID_BYTE_NUMBER = -403;
    /**
     * Invalid slave address. 
     * If 7 bit addressing is used, the maximum address value is 127.
     */
    public static final int E_ERR_INVALID_ADDRESS = -404;
    /**
     * The mcp2221 I2C/SMBUS engine currently busy.
     * Suggestion: Retry operation or call Mcp2221_I2cCancelCurrentTransfer before another retry.
     */
    public static final int E_ERR_I2C_BUSY = -405;
    
    /**
     * MCP2221 signaled an error during the I2C read operation.
     * Suggestion: Retry or reset device before retrying.
     */
    public static final int E_ERR_I2C_READ_ERROR = -406;
    /**
     * NACK received from the slave address used.
     * Suggestion: Check that the slave address is correct.
     */
    public static final int E_ERR_ADDRESS_NACK = -407;
    /**
     * Either the "timeout" or "retries" value has been exceeded and no reply was received from the slave.
     * Suggestion: I2C/SMBUS transfer is not working properly. Check the communication settings and try again.
     * The retries and timeout values can be also updated in the Mcp2221_SetAdvancedCommParameters.
     */
    public static final int E_ERR_I2C_TIMEOUT = -408;
    /**
     * The number of received data bytes is greater than requested.
     */
    public static final int E_ERR_TOO_MANY_RX_BYTES = -409;
    /**
     * Could not copy the data received from the slave into the provided buffer.
     * Suggestion: Check buffer size and retry operation.
     */
    public static final int E_ERR_COPY_RX_DATA_FAILED = -410;
    /**
     * The I2C engine (inside mcp2221) was already idle. The cancellation command had no effect.
     */
    public static final int E_ERR_NO_EFFECT = -411;
    /**
     * Failed to copy the data into the HID buffer.
     * Suggestion: Retry operation.
     */
    public static final int E_ERR_COPY_TX_DATA_FAILED = -412;
    /**
     * The slave replied with a PEC value different than the expected one.
     * Suggestion: Check that the SMBUS parameters used are supported by the slave.
     */
    public static final int E_ERR_INVALID_PEC = -413;
    /**
     * The slave sent a different value for the block size (byte count) that we expected.
     * Suggestion: Check that the SMBUS parameters used are supported by the slave.
     */
    public static final int E_ERR_BLOCK_SIZE_MISMATCH = -414;
    
    /**
     * Error code returned by Mcp2221_LoadDll if native C DLL has not been found.
     * Suggestion: Check the existence of the native DLL in current directory.
     */
    public static final int E_ERR_LOAD_DLL = -1000;
    /**
     * Error code returned by Mcp2221_LoadDll if any native methods has not been found in native C DLL.
     */
    public static final int E_ERR_FUNCTION_NOT_FOUND = -10000;
   
    /******************** DLL CONSTANTS *******************************/
    /**
     * Read/Write chip flash settings.
     */
    public static final int FLASH_SETTINGS = 0;
    /**
     * Read/Write chip runtime settings.
     */
    public static final int RUNTIME_SETTINGS = 1;
    /**
     * Do not change the existing value.
     * For example, you can alter a pin's function and mark the rest as "no_change" to maintain their existing configuration.
     */
    public static final int NO_CHANGE = 0xFF;
    
    /**
     * Pin configured as Input/Output.
     */
    public static final int MCP2221_GPFUNC_IO = 0;
    /**
     * Pin configured as SSPND.
     */
    public static final int MCP2221_GP_SSPND = 1;
    /**
     * Pin configured as Clock Out.
     */
    public static final int MCP2221_GP_CLOCK_OUT = 1;
    /**
     * Pin configured for USBCFG.
     */
    public static final int MCP2221_GP_USBCFG = 1;
    /**
     * Pin configured for I2C LED.
     */
    public static final int MCP2221_GP_LED_I2C = 1;
    /**
     * Pin configured for UART RX LED.
     */
    public static final int MCP2221_GP_LED_UART_RX = 2;
    /**
     * Pin configured for ADC.
     */
    public static final int MCP2221_GP_ADC = 2;
    /**
     * Pin configured for UART TX LED.
     */
    public static final int MCP2221_GP_LED_UART_TX = 3;
    /**
     * Pin configured for DAC function.
     */
    public static final int MCP2221_GP_DAC = 3;
    /**
     * Pin configured for Interrupt On Change.
     */
    public static final int MCP2221_GP_IOC = 4;
    
    /**
     * GPIO pin configured as input.
     */
    public static final int MCP2221_GPDIR_INPUT = 1;
    /**
     * GPIO pin configured as output.
     */
    public static final int MCP2221_GPDIR_OUTPUT = 0;
    
    /**
     * Logic high value for I/O pins.
     */
    public static final int MCP2221_GPVAL_HIGH = 1;
    /**
     * Logic low value for I/O pins.
     */
    public static final int MCP2221_GPVAL_LOW = 0;
    
    /**
     * Interrupt on change trigger = none.
     */
    public static final int INTERRUPT_NONE = 0;
    /**
     * Interrupt on change trigger = positive edge.
     */
    public static final int INTERRUPT_POSITIVE_EDGE = 1;
    /**
     * Interrupt on change trigger = negative edge.
     */
    public static final int INTERRUPT_NEGATIVE_EDGE = 2;
    /**
     * Interrupt on change trigger = both edges.
     */
    public static final int INTERRUPT_BOTH_EDGES = 3;
    
    /**
     * ADC/DAC voltage reference = Vdd.
     */
    public static final int VREF_VDD = 0;
    /**
     * ADC/DAC voltage reference = 1.024V.
     */
    public static final int VREF_1024V = 1;
    /**
     * ADC/DAC voltage reference = 2.048V.
     */
    public static final int VREF_2048V = 2;
    /**
     * ADC/DAC voltage reference = 4.096V.
     */
    public static final int VREF_4096V = 3;
    
    /**
     * USB bus powered.
     */
    public static final int MCP2221_USB_BUS = 0x80;
    /**
     * USB self powered.
     */
    public static final int MCP2221_USB_SELF = 0x40;
    /**
     * USB remote wakeup enable.
     */
    public static final int MCP2221_USB_REMOTE = 0x20;
    
    /**
     * Enable password protection.
     */
    public static final int MCP2221_PASS_ENABLE = 1;
    /**
     * Disable password protection.
     */
    public static final int MCP2221_PASS_DISABLE = 0;
    /**
     * Change current password.
     */
    public static final int MCP2221_PASS_CHANGE = 0xFF;
    
}
