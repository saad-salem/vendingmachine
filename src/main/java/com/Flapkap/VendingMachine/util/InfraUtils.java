package com.Flapkap.VendingMachine.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class InfraUtils {
    static public String getStackTrace(Exception ex) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        return stringWriter.toString();
    }
}
