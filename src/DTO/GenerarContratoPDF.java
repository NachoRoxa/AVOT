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
import com.sun.glass.ui.SystemClipboard;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;

/**
 *
 * @author Seba
 */
public class GenerarContratoPDF {
    
    private Font fuenteBold = new Font(Font.FontFamily.HELVETICA,18,Font.BOLD);
    private Font fuentesubtitulo = new Font(Font.FontFamily.HELVETICA,14,Font.ITALIC);
    private Font fuenteNormal = new Font(Font.FontFamily.HELVETICA,11,Font.NORMAL);
    private String titulo,saltoLinea,subtitulo1,subtitulo2,logo,salida;
    private String parrafo1,parrafo2,parrafo3,parrafo4,parrafo5,parrafo6,parrafo7,parrafo8,parrafo9;
    private String parrafo10,parrafo11,parrafo12,parrafo13,parrafo14,parrafo15,parrafo16,parrafo17;
    private String parrafo18,parrafo19,parrafo20,parrafo21,parrafo22,parrafo23,parrafo24,parrafo25;
    private String parrafo26,parrafo27,parrafo28,parrafo29,parrafo30,parrafo31,parrafo32,parrafo33;
    private String parrafo34,parrafo35,parrafo36,parrafo37,parrafo38,parrafo39,parrafo40,parrafo41;
    private String parrafo42,parrafo43,parrafo44,parrafo45,parrafo46,parrafo47,firmaAVOT,firmaCliente;
    Date date = new Date();
    String dateFormat = new SimpleDateFormat("dd/MM/yyyy").format(date);
    
    public void generarPDF(Tour tour, Colegio colegio, Apoderado apJefe){
        String ruta = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
        String rutaLogo = System.getProperty("user.dir");
        salida=ruta+"\\contrato"+tour.getId_tour()+".pdf";
        logo = rutaLogo+"\\src\\IMG\\icono-login-png-6.png";
        titulo ="CONTRATO DE PRESTACION DE SERVICIOS";
        saltoLinea="                                                                                      ";
        parrafo1 ="En ciudad de Santiago de Chile,"+dateFormat+" entre Agencia de viajes on Tour Operador "
                + "Turístico, Rol Único Tributario N°xx.xxx.xxx-x, empresa del giro de su denominación,rep"
                + "resentada legalmente por el Sr.John Snow, Cédula de Identidad Nº xx.xxx.xxx-x, nacional"
                + "idad chilena y con domicilio comercial en esta ciudad, Avda. Antonio Varas N°666, local"
                + " 15, comuna de Providencia, en adelante “AVOT” y el señor (a) "+apJefe.getNombre()+"   "
                + apJefe.getApellido()+", Cédula de Identidad Nº: "+apJefe.getRun()+", fono Móvil : "
                + ""+apJefe.getTelefono()+" GADO DEL GRUPO”,quien en calidad de representante de la Comisi"
                + "ón de apoderados, convienen en celebrar el siguiente contrato de prestación de servicio"
                + "s, para la Gira de Estudios, que se regirá por las siguientes cláusulas:";
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
                + "eros, es personalmente responsable de su compromiso depago con AVOT, por lo que la f"
                + "irma de este contrato por parte del DELEGADO(S) DEL GRUPO no implica corresponsabilidad"
                + " o solidaridad con los compromisoseconómicos adquiridos por parte de los apoderados que"
                + " suscriben este contrato vía su representación; ellos son solo los representantes del g"
                + "rupo ante AVOT. Sinembargo, su firma valida este contrato en relación a los compromi"
                + "sos mutuos y el programa de viaje de la gira de estudios contratada.";
        subtitulo2="CLAUSULAS";
        parrafo4 ="PRIMERA: EL DELEGADO DEL GRUPO que suscribe el presente contrato, declara pertenecer al"
                + " curso: , del Establecimiento:Y contrata con AVOT, un viaje Gira de Estudios, denominad"
                + "o: ,a realizarse entre el:"+tour.getFecha_inicio()+" y el "+tour.getFecha_inicio()+" La"
                + "s características e inclusos de este viaje se indican con detalle enel Anexo Nº 1, adju"
                + "nto, denominado Programa de Viaje, el cual se considera parte integral de este contrato"
                + " para todos los efectos legales.";
        parrafo5 ="SEGUNDA: En virtud de este contrato AVOT se obliga a operar el programa contratado en l"
                + "as condiciones señaladas en el Anexo Nº 1, por tanto, seencargará de realizar todas las"
                + " acciones necesarias para el adecuado desarrollo del programa, acorde con la calidad pa"
                + "ctada y los servicios AVOT podrá introducir cambios en las rutas y horarios previamente"
                + " establecidos, por razones de seguridad o fuerza mayor, dando pleno cumplimiento al pro"
                + "grama contratado.";
        parrafo6 ="TERCERA: El transporte del grupo se realizará en los medios descritos en Anexo N.º 1 (p"
                + "rograma de viaje). En el evento de que el vehículo de transportesufriera un desperfecto"
                + " mecánico que impidiera la continuación del programa, AVOT, se obliga a reemplazarlo po"
                + "r otro de características similares,en el menor plazo posible";
        parrafo7 = "CUARTA: AVOT asignará al grupo un guía coordinador, el cual velará por dar pleno cumpl"
                + "imiento del viaje contratado y mantendrá informado algrupo del desarrollo del viaje y l"
                + "as actividades pertinentes, para tales efectos el Profesor y/o Apoderado que acompañe a"
                + "l grupo, se reunirá diariamentecon el Guía Coordinador enviado por AVOT para tomar cono"
                + "cimiento de las actividades a realizar el día siguiente. Para ello, el Profesor/Apodera"
                + "dodeberá firmar el itinerario presentado en ese mismo momento. En caso de no firmar el "
                + "itinerario, se tendrá como aceptado y en conformidad con lasactividades realizadas ese "
                + "(esos) día(s).";
        parrafo8 = "QUINTA: El programa deberá cumplirse en los términos estipulados, sin embargo, podrá s"
                + "ufrir modificaciones por razones de fuerza mayor o por acuerdo entre el responsable del "
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
        parrafo25 = "DECIMO PRIMERA: El desistimiento de un(os) pasajero(s) una vez iniciado el proceso de"
                + " Reserva de Cupo, da origen a cargos por concepto de Anulación,sobre lo efectivamente p"
                + "agado (no documentado), según la siguiente tabla, siempre más los gastos adicionales en"
                + " que se haya incurrido, como, porejemplo, Tasas de Embarque Aéreas";
        parrafo26 = "a) Entre el pago de Reservas de Cupo y hasta 90 días antes de la fecha de viaje, se r"
                + "etendrá el 70%, saldo por ítem ANY REASON Seguro Asistencia.";
        parrafo27 = "b) Entre 89 y hasta 60 días antes de la fecha de viaje, se retendrá el 80%.";
        parrafo28 = "c) Entre 59 y hasta 30 días antes de la fecha de viaje, se retendrá el 90%.";
        parrafo29 = "d) Entre 29 días o menos, antes de la fecha de viaje, se retendrá el 100%.";
        parrafo30 = "DECIMO SEGUNDA: En el caso de que AVOT deba realizar devolución de pagos efectuados,"
                + " según lo mencionado en punto anterior, estos seránrestituidos a los respectivos girado"
                + "res, en un plazo máximo de 45 días hábiles, después de aceptada la Anulación o Desistim"
                + "iento de viaje";
        parrafo31 = "Es importante recordar que para hacer efectiva la condición de ANY REASON, la que gen"
                + "era un reembolso de un 75% del valor pagado con un tope de Usd 375.-, debe estar ya pag"
                + "ado como mínimo un 70% del valor de viaje: Esta condición de porcentaje permite que est"
                + "e desistimiento no afecte elvalor comprometido como pago para el resto del grupo. El de"
                + "sistimiento, se debe formalizar por escrito, con una antelación máxima de 90 días y mín"
                + "imo de 15 días previos a la fecha de inicio del viaje";
        parrafo32 = "De similar forma, para hacer efectiva la condición de Anulación o Interrupción de via"
                + "je, CON CAUSA JUSTIFICADA, de ser aceptada, genera un reembolsode un 100% del valor pag"
                + "ado con un tope de Usd 1.000.-. Al igual que el punto anterior, para hacer efectivo est"
                + "e beneficio se debe tener pagado comomínimo un 70% del valor del viaje. Esta condición "
                + "de porcentaje permite que este desistimiento no afecte el valor comprometido como pago "
                + "para el resto del grupo. El desistimiento, se debe formalizar por escrito, con una anti"
                + "cipación máxima de 15 días y hasta la ocurrencia del evento.";
        parrafo33 = "DECIMO TERCERA: Los pasajeros que tengan algún impedimento para realizar el viaje, po"
                + "drán hasta cuarenta y cinco (45) días antes de la salida, cedersu reserva a quien reúna"
                + " similares condiciones de viaje, con notificación por escrito a AVOT. En tal supuesto, "
                + "el cedente y el cesionario sonsolidariamente responsables por el pago de las sumas adeu"
                + "dadas a AVOT, así como de los importes adicionales ocasionados por la cesión. Si la ces"
                + "iónes posterior al plazo indicado, ATUI.CL, podrá retener hasta el veinte por ciento (2"
                + "0%) de la suma total pagada correspondiente al viaje.";
        parrafo34 = "DECIMO CUARTA: Toda modificación, cesión o desistimiento al viaje, debe ser solicitad"
                + "o formalmente por Email, al correo electrónico:contacto@avot.cl, indicando las razones "
                + "del mismo, anexando la documentación de rigor (si procede).";
        parrafo35 = "DECIMO QUINTA: Si AVOT por alguna razón de fuerza mayor ajena a su voluntad, tales co"
                + "mo: condiciones climáticas, catástrofes naturales, accionesterroristas, Actos de Dios, "
                + "eventos de la naturaleza y/o cualquier otro evento que le imposibilite poder dar inicio"
                + " al servicio contratado, o bien, no podercumplir con la totalidad del servicio, se proc"
                + "ederá de la siguiente forma:";
        parrafo36 = "a) Reprogramar el viaje para una fecha en que cambien las condiciones que impidieron "
                + "dar inicio a este y permitan su normal ejecución.";
        parrafo37 = "b) Reprogramar el destino del viaje a otro destino, según valor pagado y/o acuerdo co"
                + "n el grupo.";
        parrafo38 = "c) Realizar devolución del total de lo pagado, a excepción de la Reserva de Cupo.";
        parrafo39 = "DECIMO SEXTA: AVOT proveerá a los integrantes del grupo una Ficha Médica que deberá e"
                + "star completa y subscrita con firma aclarada, por unmédico o el Representante Legal del"
                + " pasajero, donde se acepta condición de salud apta para realizar todas las actividades "
                + "y/o servicios que componenel viaje. En caso contrario, la empresa se reserva el derecho"
                + " de no prestar el servicio al viajante/pasajero, haciéndole devolución de lo pagado, en"
                + " lostérminos de la cláusula Décimo Tercera.";
        parrafo40 = "Por otro lado, el grupo asignará a una persona específica a cargo de reunir y hacer l"
                + "legar a AVOT (a lo menos 45 días antes de la fecha de viaje), todala documentación requ"
                + "erida para efectuar la Gira de Estudios (Permisos Notariales de ambos padres en triplic"
                + "ado y originales, 01 Copia de la CédulaIdentidad, vigente por ambos lados, 01 certifica"
                + "do de nacimiento de asignación familiar y 01 ficha medica llenada y firmada, por un méd"
                + "ico o en sudefecto firmada por su representante legal) en la eventualidad del fallecimi"
                + "ento de alguno de los padres se debe acompañar el respectivo certificadode defunción, e"
                + "n el caso de ausencia de alguno de ellos la autorización debe ser otorgada por un tribu"
                + "nal de familia.";
        parrafo41 = "DECIMO SEPTIMA: En el caso de MENORES DE EDAD, chilenos o extranjeros que requieran a"
                + "utorización para salir del país, será absoluta responsabilidadde su Apoderado o Represe"
                + "ntante Legal, informarse o consultar por la documentación necesaria para abandonar Chil"
                + "e e ingresar a los países quesean parte del programa de viaje. Es responsabilidad del p"
                + "asajero mayor de 18 años el tener vigente y en buen estado la documentación necesaria p"
                + "ara su viaje: Cédula de Identidad, Pasaporte o similar, con vigencia mínima de 6 meses "
                + "y Visa, si se requiere. AVOT no se hace responsable porpasajeros que razones legales im"
                + "pidan su salida del país.";
        parrafo42 = "DECIMO OCTAVA: Se acuerda entre las partes que AVOT, no se hace responsable por el ex"
                + "travío, pérdida, hurto o robo de los efectos personales,como: dinero, documentos person"
                + "ales, cédulas de identidad, tarjetas de crédito, joyas, relojes, equipos de uso persona"
                + "l, filmadoras, máquinasfotográficas y en general, cualquier otra especie de uso o de pr"
                + "opiedad personal de los pasajeros, sea que éstos ocurran por hechos propios, ajenos o d"
                + "e la naturaleza y sucedan en medios de transportes, hoteles o lugares de hospedaje, de "
                + "detención o de visita. Se presume que todos los bienes que porte consigo cada alumno, s"
                + "on de su propiedad. Asimismo, AVOT no es responsable por casos fortuitos o fuerza mayor"
                + ".";
        parrafo43 = "DECIMO NOVENA: AVOT siendo una empresa prestadora de servicios debe contratar y subco"
                + "ntratar los servicios propios de su giro, tales como pasajes";
        parrafo44 = "terrestres o aéreos, buses, hoteles y hospedaje, servicios de alimentación y otros si"
                + "milares. Por lo anterior, de existir algún cambio imprevisto y deúltima hora en los ser"
                + "vicios ofrecidos, sea por cambio de hotel, transporte y otros, AVOT se obliga a reempla"
                + "zarlos por otros similares, de la mismacalidad e informar de estos cambios tan pronto c"
                + "omo sea posible, por cualquier medio, incluso verbal, dentro de las circunstancias del "
                + "viaje o tourcontratado; por otro lado, los apoderados y/o profesores acompañantes, lo a"
                + "ceptarán expresamente.";
        parrafo45 = "VIGESIMO: Todo reclamo referente al tour debe ser formulado previamente en las oficin"
                + "as de AVOT mediante carta certificada y dentro de un plazono mayor a 30 días contados d"
                + "esde la fecha de regreso del viaje.";
        parrafo46 ="Se conviene expresamente que cualquier dificultad que surja entre las partes, sea ella"
                + " relativa a la validez, aplicación, interpretación o incumplimientodel presente contrat"
                + "o o cualquier otra materia relacionada, las partes fijan su domicilio en la ciudad de S"
                + "antiago y otorgan competencia a los tribunalesordinarios de justicia, con renuncia expr"
                + "esa a cualquier otra acción de divulgación de la controversia, incluyendo medios de com"
                + "unicación sin que el origen de esta, este debidamente sentenciado y ejecutoriada por lo"
                + "s tribunales competentes";
        parrafo47 ="VIGESIMO PRIMERO: Este contrato se firma en dos ejemplares del mismo tenor y data, que"
                + "dando uno en poder de cada parte.";
        firmaAVOT ="En Representación de AVOT Santiago, Chile";
        firmaCliente ="En Representación (Colegio y Curso)Comuna, Chile";
        
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
            documento.add(getContenido(parrafo26));
            documento.add(getContenido(parrafo27));
            documento.add(getContenido(parrafo28));
            documento.add(getContenido(parrafo29));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo30));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo31));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo32));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo33));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo34));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo35));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo36));
            documento.add(getContenido(parrafo37));
            documento.add(getContenido(parrafo38));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo39));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo40));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo41));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo42));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo43));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo44));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo45));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo46));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(parrafo47));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(saltoLinea));
            documento.add(getFirmaAVOT(firmaAVOT));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(saltoLinea));
            documento.add(getContenido(firmaCliente));
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
    private Paragraph getFirmaAVOT(String Texto){
        Paragraph firmaAVOT = new Paragraph();
        Chunk c = new Chunk();
        firmaAVOT.setAlignment(Element.ALIGN_LEFT);
        c.append(Texto);
        c.setFont(fuenteNormal);
        firmaAVOT.add(c);
        return firmaAVOT;
    }
    private Paragraph getFirmaCliente(String Texto){
        Paragraph firmaCliente = new Paragraph();
        Chunk c = new Chunk();
        firmaCliente.setAlignment(Element.ALIGN_RIGHT);
        c.append(Texto);
        c.setFont(fuenteNormal);
        firmaCliente.add(c);
        return firmaCliente;
    }
    
}

