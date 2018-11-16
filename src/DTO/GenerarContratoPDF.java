/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Seba
 */
public class GenerarContratoPDF {
    
    private Font fuenteBold = new Font(Font.FontFamily.COURIER,24,Font.BOLD);
    private Font fuenteNormal = new Font(Font.FontFamily.COURIER,17,Font.NORMAL);
    private Font fuenteItalic = new Font(Font.FontFamily.COURIER,10,Font.ITALIC);
    private String titulo;
    private String contenido;
    private String footer;
    private String rutaImagen;
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public void generarPDF(String salida){
        titulo = "CONTRATO DE  PRESTACION DE SERVICIOS TURISTICOS N° ";
        contenido =   ""
                    + "------------------------------------------------------------------------------------------------------------------------"
                    + ""
                    + "                                                                           Lugar:Antonio Varas 666     fecha :"+dateFormat.toString()
                    + ""
                    + "                                                                           Estabecimiento educativo :"
                    + ""
                    + ""
                    + ""
                    + "     Servicios a Prestar por la empresa de viajes On Tour:"
                    + ""
                    + ""
                    + "     Destino: blabla Duración: 15 Salida: Dias:   Noches: 	"
                    + "     Mes:     Quincena:   Año:";
        footer = "Esto es el footer";
        rutaImagen = "C:\\Users\\Seba\\Documents\\NetBeansProjects\\AVOT.LOCAL\\src\\IMG\\icono-login-png-6.png";
        try{
            Document documento = new Document(PageSize.LETTER,36,36,10,10);
            PdfWriter.getInstance(documento, new FileOutputStream(salida));
            documento.open();
            Image imagen = Image.getInstance(rutaImagen);
            imagen.scaleAbsolute(100,100);
            imagen.setAlignment(Element.ALIGN_CENTER);
            documento.add(imagen);
            documento.add(getTitulo(titulo));
            documento.add(getContenido(""));
            documento.add(getContenido(contenido));
            documento.add(getContenido(""));
            documento.add(getContenido(""));
            documento.add(getFooter(footer));
            documento.close();
        }catch(Exception e){
        }
        
    }
    private Paragraph getTitulo(String Texto){
        Paragraph titulo = new Paragraph();
        Chunk c = new Chunk();
        titulo.setAlignment(Element.ALIGN_CENTER);
        c.append(Texto);
        c.setFont(fuenteBold);
        titulo.add(c);
        return titulo;
    }
    private Paragraph getContenido(String Texto){
        Paragraph contenido = new Paragraph();
        Chunk c = new Chunk();
        contenido.setAlignment(Element.ALIGN_JUSTIFIED_ALL);
        c.append(Texto);
        c.setFont(fuenteNormal);
        contenido.add(c);
        return contenido;
    }
    private Paragraph getFooter(String Texto){
        Paragraph footer = new Paragraph();
        Chunk c = new Chunk();
        footer.setAlignment(Element.ALIGN_JUSTIFIED);
        c.append(Texto);
        c.setFont(fuenteItalic);
        footer.add(c);
        return footer;
    }
    
}

