/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.utils;

import com.circuit.obj.BarangayClearance;
import static com.circuit.utils.ReportConnection.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Marvin
 */
public class ReportUtility {
    
    public static void generateBarangayClearanceReport(BarangayClearance barangayClearance)
    {
        try
        {
            FileInputStream fis = new FileInputStream(ReportUtility.class.getResource(REPORT_LOCATION + CLEARANCE_REPORT).getFile());
            BufferedInputStream bis = new BufferedInputStream(fis);
            
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("SAMPLE1", "SAMPLE1");
            map.put("SAMPLE2", "SAMPLE2");
            
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(bis);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map);
            JasperViewer.viewReport(jasperPrint);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReportUtility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(ReportUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public static JasperPrint generateJasperPrintReport(BarangayClearance barangayClearance)
    {
        try
        {
            FileInputStream fis = new FileInputStream(new File(REPORT_LOCATION + CLEARANCE_REPORT));
            BufferedInputStream bis = new BufferedInputStream(fis);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(bis);
            System.out.println(jasperReport);
            System.out.println(REPORT_LOCATION + CLEARANCE_REPORT);
            System.out.println(barangayClearance.getData());
            JasperPrint jasperPrint = (JasperPrint)JasperFillManager.fillReport(jasperReport,barangayClearance.getData(), new JREmptyDataSource());
            
            
            return jasperPrint;
            
        } catch (Exception ex) {
           ex.printStackTrace();
            return null;
        }
       
    }
    
    public static JasperPrint generateJasperPrintReportReciept(BarangayClearance barangayClearance)
    {
        try
        {
            FileInputStream fis = new FileInputStream(new File(REPORT_LOCATION + CLEARANCE_RECIEPT));
            BufferedInputStream bis = new BufferedInputStream(fis);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(bis);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, barangayClearance.getData(), new JREmptyDataSource());
            return jasperPrint;
        } catch (Exception ex) {
           ex.printStackTrace();
            return null;
        }
      
    }
    
}
