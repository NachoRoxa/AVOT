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
    
    private Font fuenteBold = new Font(Font.FontFamily.HELVETICA,20,Font.BOLD);
    private Font fuentesubtitulo = new Font(Font.FontFamily.HELVETICA,18,Font.ITALIC);
    private Font fuenteNormal = new Font(Font.FontFamily.HELVETICA,12,Font.NORMAL);
    private Font fuenteItalic = new Font(Font.FontFamily.HELVETICA,10,Font.ITALIC);
    private String titulo;
    private String saltoLinea;
    private String subtitulo1;
    private String subtitulo2;
    private String subtitulo3;
    private String subtitulo4;
    private String subtitulo5;
    private String subtitulo6;
    private String parrafo1;
    private String parrafo2;
    private String parrafo3;
    private String parrafo4;
    private String parrafo5;
    private String parrafo6;
    private String parrafo7;
    private String parrafo8;
    private String parrafo9;
    private String parrafo10;
    private String parrafo11;
    private String parrafo12;
    private String footer;
    private String logo;
    private String salida;
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public void generarPDF(){
        salida="C:\\Users\\Seba\\Documents\\PDF\\contrato.pdf";
        logo = "C:\\Users\\Seba\\Documents\\NetBeansProjects\\AVOT.LOCAL\\src\\IMG\\icono-login-png-6.png";
        titulo ="CONTRATO DE PRESTACION DE SERVICIOS";
        saltoLinea="                                                                                      ";
        parrafo1 ="En ciudad de Santiago de Chile,(fecha) entre On Tout Operador Turístico,Rol Único Tribu"
                + "tario N°(00.000.000-0), empresa del giro de su denominación,representada legalmente por"
                + " el (Sr. Jefe de la empresa), Cédula de Identidad (Nº 0.000.000-0), nacionalidad chilen"
                + "a y con domicilio comercial en esta ciudad,Avda. Antonio Varas N° 666, local (x), comun"
                + "a de Providencia, en adelante “AVOT”y el señor (a) , Cédula de Identidad Nº : , naciona"
                + "lidad: , de profesión: , con domicilio en : , comuna de: , fono Móvil:, fono red Fija: "
                + ",Correo Electrónico: ,en adelante, “DELEGADO DEL GRUPO”,quien en calidadde representant"
                + "e de la Comisión de apoderados, convienen en celebrar el siguiente contrato de prestaci"
                + "ón de servicios, para la Gira de Estudios, quese regirá por las siguientes cláusulas";
        subtitulo1="CONSIDERACIONES GENERALES";
        parrafo2 ="UNO: Se entiende por Operador Turístico, la empresa intermediaria, de carácter privado,"
                + " dedicada al giro de agencia de viaje y actividades relacionadas, que prestaservicios p"
                + "rovenientes de tercero o los suyos propios, y teniendo como finalidad el esparcimiento "
                + "y recreación.";
        parrafo3 ="DOS: EL DELEGADO DEL GRUPO se compromete en forma exclusiva a dar aviso íntegro y en fo"
                + "rma clara de las cláusulas contenidas en el presente contrato a sus respectivosapoderad"
                + "os, eximiendo totalmente de responsabilidad a la empresa sobre este aspecto. No obstant"
                + "e, lo anterior, la empresa se compromete a mantener copia íntegradel contrato suscrito,"
                + " en formato digital en su página web. Cada apoderado o Representante Legal de los pasaj"
                + "eros, es personalmente responsable de su compromiso depago con ATUI.CL, por lo que la f"
                + "irma de este contrato por parte del DELEGADO(S) DEL GRUPO no implica corresponsabilidad"
                + " o solidaridad con los compromisoseconómicos adquiridos por parte de los apoderados que"
                + " suscriben este contrato vía su representación; ellos son solo los representantes del g"
                + "rupo ante ATUI.CL. Sinembargo, su firma valida este contrato en relación a los compromi"
                + "sos mutuos y el programa de viaje de la gira de estudios contratada.";
        subtitulo2="CLAUSULAS";
        parrafo4 ="PRIMERA: EL DELEGADO DEL GRUPO que suscribe el presente contrato, declara pertenecer al"
                + " curso: , del Establecimiento:Y contrata con ATUI.CL, un viaje Gira de Estudios, denomi"
                + "nado: ,a realizarse entre el: de: y el de: de 20 Las características e inclusos de este"
                + " viaje se indican con detalle enel Anexo Nº 1, adjunto, denominado Programa de Viaje, e"
                + "l cual se considera parte integral de este contrato para todos los efectos legales.";
        parrafo5 ="SEGUNDA: En virtud de este contrato ATUI.CL se obliga a operar el programa contratado e"
                + "n las condiciones señaladas en el Anexo Nº 1, por tanto, seencargará de realizar todas "
                + "las acciones necesarias para el adecuado desarrollo del programa, acorde con la calidad"
                + " pactada y los servicios ofrecidos.ATUI.CL podrá introducir cambios en las rutas y hora"
                + "rios previamente establecidos, por razones de seguridad o fuerza mayor, dando pleno cum"
                + "plimientoal programa contratado";
        parrafo6 ="TERCERA: El transporte del grupo se realizará en los medios descritos en Anexo N.º 1 (p"
                + "rograma de viaje). En el evento de que el vehículo de transportesufriera un desperfecto"
                + " mecánico que impidiera la continuación del programa, ATUI.CL, se obliga a reemplazarlo"
                + " por otro de características similares,en el menor plazo posible";
        footer = "Esto es el footer";
        
        try{
            Document documento = new Document(PageSize.LETTER,30,30,25,25);
            PdfWriter.getInstance(documento, new FileOutputStream(salida));
            documento.open();
            Image imagen = Image.getInstance(logo);
            imagen.scaleAbsolute(100,100);
            imagen.setAlignment(Element.ALIGN_LEFT);
            documento.add(imagen);
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(saltoLinea));
            documento.add(getTitulo(titulo));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo1));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(saltoLinea));
            documento.add(getSubTitulo(subtitulo1));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo2));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo3));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(saltoLinea));
            documento.add(getSubTitulo(subtitulo2));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo4));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo5));
            documento.add(getContenido(parrafo6));
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
    private Paragraph getSubTitulo(String Texto){
        Paragraph subtitulo = new Paragraph();
        Chunk c = new Chunk();
        subtitulo.setAlignment(Element.ALIGN_LEFT);
        c.append(Texto);
        c.setFont(fuentesubtitulo);
        subtitulo.add(c);
        return subtitulo;
    }
    private Paragraph getContenido(String Texto){
        Paragraph contenido = new Paragraph();
        Chunk c = new Chunk();
        contenido.setAlignment(Element.ALIGN_JUSTIFIED);
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

