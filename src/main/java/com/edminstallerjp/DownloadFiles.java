package com.edminstallerjp;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zach
 */
import java.io.*;
import java.net.*;

public class DownloadFiles {
    
    public static void download(String address, String localFileName) {
        OutputStream out = null;
        URLConnection conn = null;
        InputStream in = null;

        try {
            URL url = new URL(address);
            out = new BufferedOutputStream(new FileOutputStream(localFileName));
            conn = url.openConnection();
            in = conn.getInputStream();
            byte[] buffer = new byte[1024];

            int numRead;
            long numWritten = 0;

            while ((numRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, numRead);
                numWritten += numRead;
            }

            System.out.println(localFileName + "\t" + numWritten);
        } 
        catch (Exception exception) { 
            exception.printStackTrace();
        } 
        finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } 
            catch (IOException ioe) {
            }
        }
    }

    public static void download(String address) {
        int lastSlashIndex = address.lastIndexOf('/');
        if (lastSlashIndex >= 0 &&
        lastSlashIndex < address.length() - 1) {
            download(address, address.substring(lastSlashIndex + 1));
        } 
        else {
            System.out.println("Could not figure out local file name for "+address);
        }
    }
}
