package util;
import java.sql.*;
import java.sql.Timestamp;
import java.util.*;
import java.io.*;
import java.security.*;

public class DLException extends Exception {
    private static final String USER_MESSAGE = "Unable to complete operation. Please contact the administrator or try again.";
    private PrintWriter pw = null;

    public DLException(Exception e) {
        super(USER_MESSAGE);
        log(e);
    }

    public DLException(Exception e, Map<String, String> m) {
        super(USER_MESSAGE);
        log(e, m);
    }
    void log(Exception e) {
        try {
            pw = new PrintWriter(new FileWriter(new File("ExceptionData.log"), true));
            pw.println("Exception at timestamp: " + new Timestamp(System.currentTimeMillis()));
            
            if(e instanceof SQLException){
                pw.println("SQLState: " + ((SQLException) e).getSQLState()); // getting SQLState
                pw.println("Error Code: " + ((SQLException) e).getErrorCode()); // getting error code
    
            } else if (e instanceof GeneralSecurityException) {
                pw.println("Security Exception: " + e.getClass()); // getting the security exception
                
            } else {
                pw.println("Class of exception: " + e.getClass());                
                
            }

            pw.println("Message: " + e.getMessage()); // getting the description
    
            Throwable t = e.getCause(); // getting the cause
            while (t != null) {
                pw.println("Cause: " + t);
                t = t.getCause();
            }
            
            pw.println();

        } catch (IOException e1) {
            new DLException(e1);

        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }

    void log(Exception e, Map<String, String> m) {
        log(e); // calling previous method -> no repeating the code
        try {
            pw = new PrintWriter(new FileWriter(new File("ExceptionData.log"), true));
            pw.println("------ ADDITIONAL INFORMATION ------");
            
            // going through the provided map of additional info
            for (String s : m.keySet()) {
                pw.println(s + ": " + m.get(s));
            }

            pw.println();

        } catch (IOException e1) {
            new DLException(e1);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }
}
