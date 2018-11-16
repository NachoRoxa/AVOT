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
    
    private Font fuenteBold = new Font(Font.FontFamily.COURIER,20,Font.BOLD);
    private Font fuenteNormal = new Font(Font.FontFamily.COURIER,12,Font.NORMAL);
    private Font fuenteItalic = new Font(Font.FontFamily.COURIER,10,Font.ITALIC);
    private String titulo;
    private String contenido;
    private String footer;
    private String rutaImagen;
    private String salida;
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public void generarPDF(){
        salida="C:\\Users\\Seba\\Documents\\PDF\\contrato.pdf";
        titulo ="CONTRATO DE ejemplo PRESTACION DE SERVICIOS TURISTICOS N°XXXX";
        contenido =  "                                                                             "
                    + "                                                                             "
                    + "----------------------------------------------------------------------------"
                    + "                                                                             "
                    + "                                         Antonio Varas 666     16/11/2018   "
                    + "                                         Estabecimiento         Colegio X   "
                    + "                                                                             "
                    + "                                                                             "
                    + "                                                                             "
                    + "Servicios a Prestar:                                                         "
                    + "Destino: Bariloche Duración: 15 dias Salida: XXXX                           "
                    + "Dias: XXXX    Noches: XXXX   Mes: XXXX   Año: XD                            "
                    + "                                                                             "
                    + "                                                                             "
                    + "                                                                             "
                    + "                                                                             "
                    + "Agencia de viajes On Tour que gira bajo la denominación                     "
                    + "comercial de xxxxxxxxxxxxxxxxxxxxxxx , Legajo Nº___(*)___,run Nºxx.xxx.xxx-k"
                    + " , con Certificado Nacional de Autorización para agencias                   "
                    + " de Turismo Estudiantil otorgado por Disp. Nº XX/2018, y los representantes "
                    + " legales de los turistas usuarios, convienen en celebrar el presente        "
                    + "Contrato de Prestación de Servicios Turísticos de  VIAJES DE ESTUDIOS       "
                    + "acuerdo a las condiciones generales expresadas al dorso del presente.       "
                    + "                                                                             "
                    + "                                                                             "
                    + "                                                                             "
                    + "                                                                             "
                    + "PRIMERA: El presente contrato de prestación de servicios turísticos, que de "
                    + "conformidad al art. 7° del Reglamento de Turismo Estudiantil aprobado por Res. "
                    + "Nº 23/2014,  comprende exclusivamente  aquellas prestaciones que resulten   "
                    + "esenciales en relación a la naturaleza de los viajes; es decir, el hospedaje"
                    + "el transporte, la gastronomía, las excursiones diurnas -a excepción de las de"
                    + "turismo activo y/o de aventura- y los seguros exigidos por el mencionado    "
                    + "Reglamento.                                                                 "
                    + "                                                                            "
                    + "                                                                            "
                    + "                                                                            "
                    + "                                                                            "
                    + "                                                                            "
                    + "                                                                            "
                    + "                                                                            "
                    + "                                                                            "
                    + "                                                                            "
                    + "                                                                            "
                    + "                                                                            "
                    + "                                                                            "
                    + "                                                                            "
                    + "                                                                            "
                    + "                                                                            "
                    + "                                                                            "
                    + "                                                                            "
                    + "                                                                            ";
        footer = "Esto es el footer";
        rutaImagen = "C:\\Users\\Seba\\Documents\\NetBeansProjects\\AVOT.LOCAL\\src\\IMG\\icono-login-png-6.png";
        try{
            Document documento = new Document(PageSize.LETTER,30,30,25,25);
            PdfWriter.getInstance(documento, new FileOutputStream(salida));
            documento.open();
            Image imagen = Image.getInstance(rutaImagen);
            imagen.scaleAbsolute(100,100);
            imagen.setAlignment(Element.ALIGN_LEFT);
            documento.add(imagen);
            documento.add(getTitulo(titulo));
            documento.add(getContenido(contenido));
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
        c.append(Texto);
        c.setFont(fuenteNormal);
        contenido.add(c);
        return contenido;
    }
    private Paragraph getFooter(String Texto){
        Paragraph footer = new Paragraph();
        Chunk c = new Chunk();
        footer.setAlignment(Element.ALIGN_CENTER);
        c.append(Texto);
        c.setFont(fuenteItalic);
        footer.add(c);
        return footer;
    }
    
}

