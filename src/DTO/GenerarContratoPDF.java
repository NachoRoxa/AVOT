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
    
    private Font fuenteBold = new Font(Font.FontFamily.HELVETICA,18,Font.BOLD);
    private Font fuentesubtitulo = new Font(Font.FontFamily.HELVETICA,14,Font.ITALIC);
    private Font fuenteNormal = new Font(Font.FontFamily.HELVETICA,11,Font.NORMAL);
    private Font fuenteItalic = new Font(Font.FontFamily.HELVETICA,9,Font.ITALIC);
    private String titulo,saltoLinea,subtitulo1,subtitulo2,subtitulo3,subtitulo4,subtitulo5,subtitulo6;
    private String parrafo1,parrafo2,parrafo3,parrafo4,parrafo5,parrafo6,parrafo7,parrafo8,parrafo9;
    private String parrafo10,parrafo11,parrafo12,parrafo13,parrafo14,parrafo15,parrafo16,parrafo17;
    private String parrafo18,parrafo19,parrafo20,parrafo21,parrafo22,parrafo23,parrafo24,parrafo25;
    private String footer;
    private String logo;
    private String salida;
    private int numero = (int) (Math.random() * 150000) + 1;
    Date date = new Date();
    String dateFormat = new SimpleDateFormat("dd/MM/yyyy").format(date);
    
    public void generarPDF(){
        salida="C:\\Users\\Seba\\Documents\\PDF\\contrato"+numero+".pdf";
        logo = "C:\\Users\\Seba\\Documents\\NetBeansProjects\\AVOT.LOCAL\\src\\IMG\\icono-login-png-6.png";
        titulo ="CONTRATO DE PRESTACION DE SERVICIOS";
        saltoLinea="                                                                                      ";
        parrafo1 ="En ciudad de Santiago de Chile,"+dateFormat+" entre Agencia de viajes on Tout Operador Turí"
                + "stico,Rol Único Tributario N°(00.000.000-0), empresa del giro de su denominación,repres"
                + "entada legalmente por el (Sr. Jefe de la empresa), Cédula de Identidad (Nº 0.000.000-0)"
                + ", nacionalidad chilena y con domicilio comercial en esta ciudad,Avda. Antonio Varas N° "
                + "666, local (x), comuna de Providencia, en adelante “AVOT” y el señor (a) , Cédula de Ide"
                + "ntidad Nº : , nacionalidad: , de profesión: , con domicilio en : , comuna de: , fono Mó"
                + "vil:, fono red Fija: ,Correo Electrónico: ,en adelante, “DELEGADO DEL GRUPO”,quien en c"
                + "alidadde representante de la Comisión de apoderados, convienen en celebrar el siguiente"
                + " contrato de prestación de servicios, para la Gira de Estudios, quese regirá por las si"
                + "guientes cláusulas:";
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
                + "eros, es personalmente responsable de su compromiso depago con AVOT.CL, por lo que la f"
                + "irma de este contrato por parte del DELEGADO(S) DEL GRUPO no implica corresponsabilidad"
                + " o solidaridad con los compromisoseconómicos adquiridos por parte de los apoderados que"
                + " suscriben este contrato vía su representación; ellos son solo los representantes del g"
                + "rupo ante AVOT.CL. Sinembargo, su firma valida este contrato en relación a los compromi"
                + "sos mutuos y el programa de viaje de la gira de estudios contratada.";
        subtitulo2="CLAUSULAS";
        parrafo4 ="PRIMERA: EL DELEGADO DEL GRUPO que suscribe el presente contrato, declara pertenecer al"
                + " curso: , del Establecimiento:Y contrata con AVOT.CL, un viaje Gira de Estudios, denomi"
                + "nado: ,a realizarse entre el: de: y el de: de 20 Las características e inclusos de este"
                + " viaje se indican con detalle enel Anexo Nº 1, adjunto, denominado Programa de Viaje, e"
                + "l cual se considera parte integral de este contrato para todos los efectos legales.";
        parrafo5 ="SEGUNDA: En virtud de este contrato AVOT se obliga a operar el programa contratado e"
                + "n las condiciones señaladas en el Anexo Nº 1, por tanto, seencargará de realizar todas "
                + "las acciones necesarias para el adecuado desarrollo del programa, acorde con la calidad"
                + " pactada y los servicios AVOT podrá introducir cambios en las rutas y horarios previ"
                + "amente establecidos, por razones de seguridad o fuerza mayor, dando pleno cumplimiento "
                + "al programa contratado.";
        parrafo6 ="TERCERA: El transporte del grupo se realizará en los medios descritos en Anexo N.º 1 (p"
                + "rograma de viaje). En el evento de que el vehículo de transportesufriera un desperfecto"
                + " mecánico que impidiera la continuación del programa, AVOT, se obliga a reemplazarlo po"
                + "r otro de características similares,en el menor plazo posible";
        parrafo7 = "CUARTA: AVOT asignará al grupo un guía coordinador, el cual velará por dar pleno cu"
                + "mplimiento del viaje contratado y mantendrá informado algrupo del desarrollo del viaje "
                + "y las actividades pertinentes, para tales efectos el Profesor y/o Apoderado que acompañ"
                + "e al grupo, se reunirá diariamentecon el Guía Coordinador enviado por AVOT para tomar c"
                + "onocimiento de las actividades a realizar el día siguiente. Para ello, el Profesor/Apod"
                + "eradodeberá firmar el itinerario presentado en ese mismo momento. En caso de no firmar "
                + "el itinerario, se tendrá como aceptado y en conformidad con lasactividades realizadas e"
                + "se (esos) día(s).";
        parrafo8 = "QUINTA: El programa deberá cumplirse en los términos estipulados, sin embargo, podrá s"
                + "ufrir modificaciones por razones de fuerza mayor o poracuerdo entre el responsable del "
                + "grupo y AVOT.";
        parrafo9 = "Se hace presente que los horarios y tiempos de viaje, tratándose de operaciones terres"
                + "tres, son estimativas ya que su exacto cumplimiento dependede múltiples factores, entre"
                + " otros: clima, condiciones de las carreteras, caminos en reparación, desvíos, Aduanas y"
                + " condiciones generales de seguridad.En el caso de transporte aéreo, los horarios, cance"
                + "laciones y conexiones, por disposiciones tanto nacionales como internacionales, son de "
                + "exclusiva responsabilidad de la línea aérea. Sin perjuicio de ello, AVOT, exigirá en lo"
                + " que fuere procedente, de la línea aérea todas las rectificaciones que fuerannecesarias"
                + " para dar cumplimiento al servicio contratado.";
        parrafo10 = "En el caso de que alguna actividad no se pudiera realizar por motivos de fuerza mayor"
                + " (condiciones climáticas, etc.) se conversará con los acompañantesde la gira de estudio"
                + " y se concordará una nueva actividad de reemplazo.";
        parrafo11 = "SEXTA: Los servicios de viaje ofrecidos por AVOT, tienen el carácter de grupal, por l"
                + "o que los apoderados y/o Representantes Legales autorizanexpresamente a sus hijos y/o p"
                + "upilos a viajar, haciéndose responsables por sus actos y hechos, lícitos e ilícitos que"
                + " puedan causar daño a la empresa y/o a terceros.";
        parrafo12 = "Para dichos efectos deberán designar un DELEGADO DEL GRUPO, entre los profesores y/o "
                + "apoderados acompañantes del viaje, el cual velaráexclusivamente por el comportamiento a"
                + "propiado de los alumnos, según lo detallado en Protocolo de Adultos Liberados acompañan"
                + "do al grupo.";
        parrafo13 = "Cualquier daño o desperfecto, causado por imprudencia temeraria o negligencia, sea es"
                + "te total o parcial en partes, piezas, instalaciones y/o accesorios de los vehículos de "
                + "transporte, de los establecimientos comerciales, hoteles, restaurantes o cualquier otro"
                + " prestador de servicios del programa Gira de Estudios contratada, ocasionado por un hec"
                + "ho o culpa de alguno de los integrantes del grupo, será de responsabilidad exclusiva de"
                + " sus autores, si estos se pueden identificar, a quienes corresponderá hacerse cargo en "
                + "términos económicos de los perjuicios causados; en caso de no ser posible suidentificac"
                + "ión, corresponderá al grupo y/o los representantes indemnizar inmediatamente a los afec"
                + "tados.";
        parrafo14 = "AVOT no se hace responsable de dichos perjuicios o daños, no obstante, cooperará, med"
                + "iará y/o propondrá alternativas de solución a la problemáticagenerada, a objeto de no a"
                + "lterar el cumplimiento de la agenda preestablecida del viaje.";
        parrafo15 = "En caso de alteración de la agenda de viaje a consecuencia de las acciones descritas "
                + "anteriormente, AVOT no se responsabilizará tanto de los cambiosque pueda tener el itine"
                + "rario como de las consecuencias directa e indirectas derivadas de los mismos.";
        parrafo16 = "Se deja expresado en el presente instrumento, que no está permitido el consumo de beb"
                + "idas alcohólicas y/o de alguna otra sustancia y/o porte deobjetos indebidos prohibidos "
                + "por Ley, durante la Gira de Estudio, siendo este punto de exclusiva responsabilidad del"
                + " (los) Profesor(es) y/o Apoderado(s),que acompañe(n) al curso, si éstas son adquiridas "
                + "y/o consumidas por alguno de los integrantes del viaje.";
        parrafo17 = "AVOT no vende, distribuye, proporciona, facilita o promueve de ninguna manera, el uso"
                + " de alcohol en pasajeros y/o menores de edad. Dicho actoserá penalizado por parte de AV"
                + "OT y quedará a disposición de los coordinadores generales representantes de la empresa "
                + "en destino.";
        parrafo18 = "Por su parte, EL DELEGADO DEL GRUPO se compromete expresamente en dar cuenta de esta "
                + "cláusula en particular a sus respectivos apoderados";
        parrafo19 = "SEPTIMA: AVOT no prestará los siguientes servicios que serán de exclusiva responsabil"
                + "idad y costo del grupo. Estos son, entre otros:";
        parrafo20 = "a) Todo tipo de extras en comidas o bebidas no especificadas en el programa, excursio"
                + "nes opcionales y extensiones no descritas en Anexo Nº 1, asícomo cualquier otro tipo de"
                + " servicios que sean responsabilidad directa de cada pasajero.";
        parrafo21 = "b) Entradas adicionales a Parques, Museos, Recintos de entretenimiento o similares, n"
                + "o expresamente mencionados en Anexo Nº 1.";
        parrafo22 = "OCTAVA: El Seguro de Asistencia en Viaje asignado al grupo, su cobertura y otros, for"
                + "man parte integral de este contrato, según se explicita en el AnexoNº 2 del presente do"
                + "cumento. Del mismo modo los pasajeros quedan protegidos por los seguros adicionales que"
                + " correspondan a los medios detransporte. Las condiciones generales y específicas del Se"
                + "guro de Asistencia se declaran conocidas y tenidas a la vista por EL DELEGADO DEL GRUPO"
                + ",en representación del mismo.";
        parrafo23 = "NOVENA: Este contrato se firma en base a un acuerdo de pasajeros efectivamente pagado"
                + "s, más Libres de pago o Liberados, en base a unmínimo de pasajeros efectivamente pagado"
                + "s.El valor a pagar por cada pasajero es de $ ( EN LETRAS : ), monto no canjeable, ni pr"
                + "orrateable y que ha de ser pagado según lo acordado directamente con el apoderado y/o r"
                + "epresentante de cada uno de los pasajeros.";
        parrafo24 = "DECIMA: El grupo quedará conformado de acuerdo a lo especificado en la Reserva de Cup"
                + "o y ratificado en clausula anterior; las solicitudes de adhesiónal grupo que se efectúe"
                + "n con posterioridad a la Reserva de Cupo, quedarán sujetas a disponibilidad de plaza; e"
                + "n términos tarifarios, esta condición de aceptación de nuevo(s) integrante(s), no alter"
                + "ará en modo alguno la condición de tarifa pactada inicialmente por el grupo, según la c"
                + "antidad deintegrantes acordados al momento del cierre de la Reserva de Cupo y ratificad"
                + "a en clausula Décima.";
        parrafo25 = "";
                
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
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo5));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo6));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo7));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo8));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo9));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo10));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo11));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo12));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo13));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo14));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo15));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo16));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo17));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo18));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo19));
            documento.add(getContenido(parrafo20));
            documento.add(getContenido(parrafo21));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo22));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo23));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo24));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo25));
            documento.add(getContenido(saltoLinea));
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

