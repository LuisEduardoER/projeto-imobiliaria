package Relatorios;

import Modelo.ImovelN;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


public class ImprimeRelatorio {

    public static ArrayList<ImovelN> l;
    public static String modelo;

    public ImprimeRelatorio(ArrayList<ImovelN> lista, String arquivo) {
//        ArrayList<MProcesso> l = new ArrayList<MProcesso>();
//        for (int i = 0; i < 10; i++) {
//            MProcesso p = new MProcesso();
//            p.setCliente("aaaaaaaaaa");
//            p.setVara("aaaaaaaaaaa");
//            p.setProcesso("aaaaaaaaaaa");
//            p.setRef("aaaaaaaaaaa");
//            p.setReusAtor("aaaaaaaaaaa");
//            p.setResponsavel("aaaaaaaaaaa");
//            l.add(p);
//        }
        this.l = lista;

        String fileName = arquivo + ".jasper";
        String outFileName = arquivo + ".pdf";

        try {
            if ("rImovel".equals(arquivo)) {
                JasperPrint print = JasperFillManager.fillReport(fileName, null, new ImovelNDS(l));
                JRExporter exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileName);
                exporter.exportReport();
            } 
//            else if ("rEtiquetasSicredi".equals(arquivo)) {
//                JasperPrint print = JasperFillManager.fillReport(fileName, null, new EtiquetasSICREDIDS(l));
//                JRExporter exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
//                exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
//                exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileName);
//                exporter.exportReport();
//            } else if ("rEtiquetasReembolso".equals(arquivo)) {
//                JasperPrint print = JasperFillManager.fillReport(fileName, null, new EtiquetasReembolsoDS(l));
//                JRExporter exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
//                exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
//                exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileName);
//                exporter.exportReport();
//            } else if ("rEtiquetasCaixas".equals(arquivo)) {
//                JasperPrint print = JasperFillManager.fillReport(fileName, null, new ImovelNDS(l));
//                JRExporter exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
//                exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
//                exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileName);
//                exporter.exportReport();
//            }

//            JRExporter exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
//            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
//            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileName);
//            exporter.exportReport();

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
