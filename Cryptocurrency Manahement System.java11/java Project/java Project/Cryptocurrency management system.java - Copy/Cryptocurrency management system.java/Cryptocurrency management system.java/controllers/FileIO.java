
package controllers;

import java.io.*;
import java.util.*;

public class FileIO {

    public String[] readFile(String fileName) {
        String[] data = new String[10];
        try (BufferedReader bfr = new BufferedReader(new FileReader(new File(fileName)))) {
            String flage;
            int i = 0;
            while ((flage = bfr.readLine()) != null) {
                if (i >= data.length) {
                    data = expandArray(data);
                }
                data[i] = flage;
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new String[0];
        }
        return data;
    }

    public void writeFile(String fileName, String[] data) {
        try (FileWriter fwr = new FileWriter(new File(fileName))) {
            for (String str : data) {
                if (str != null) {
                    fwr.write(str);
                    fwr.write(System.lineSeparator());
                    fwr.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String[] expandArray(String[] original) {
        String[] newArray = new String[original.length * 2];
        System.arraycopy(original, 0, newArray, 0, original.length);
        return newArray;
    }
}






































































































































































/*package controllers;

import java.lang.*;
import java.io.*;

public class FileIO 
{
    
    public String[] readFile(String fileName) {
        String[] data = new String[100];
        try (BufferedReader bfr = new BufferedReader(new FileReader(new File(fileName)))) {
            String flage;
            int i = 0;
            while ((flage = bfr.readLine()) != null) {
                if (i >= data.length) {
                    data = expandArray(data);
                }
                data[i] = flage;
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public void writeFile(String fileName, String[] data) {
        try (FileWriter fwr = new FileWriter(new File(fileName))) {
            for (String str : data) {
                if (str != null) {
                    fwr.write(str);
                    fwr.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private String[] expandArray(String[] original) {
        String[] newArray = new String[original.length * 2];
        System.arraycopy(original, 0, newArray, 0, original.length);
        return newArray;
    }
}
*/