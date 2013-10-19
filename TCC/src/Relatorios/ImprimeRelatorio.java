package Relatorios;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Venda;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


public class ImprimeRelatorio {

    public static ArrayList<Venda> l;
    public static String modelo;

    public ImprimeRelatorio(ArrayList<Venda> lista, String arquivo) {

        this.l = lista;

        String fileName = arquivo + ".jasper";
        String outFileName = arquivo + ".pdf";

        try {
            if ("rImovel".equals(arquivo)) {
                JasperPrint print = JasperFillManager.fillReport(fileName, null, new VendasDS(l));
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
        new ImprimeRelatorio(l, modelo);
    }
}
