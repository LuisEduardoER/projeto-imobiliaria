package Relatorios;

import Modelo.Venda;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


public class ImprimeRelatorioVenda {

    public static ArrayList<Venda> l;
    public static String modelo;

    public ImprimeRelatorioVenda(ArrayList<Venda> lista, String arquivo) {

        this.l = lista;

        String fileName = arquivo + ".jasper";
        String outFileName = arquivo + ".pdf";

        try {
            if ("rVenda".equals(arquivo)) {
                JasperPrint print = JasperFillManager.fillReport(fileName, null, new VendaDS(l));
                JRExporter exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileName);
                exporter.exportReport();
            } 

        } catch (JRException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Desktop.getDesktop().open(new File(outFileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new ImprimeRelatorioVenda(l, modelo);
    }
}
