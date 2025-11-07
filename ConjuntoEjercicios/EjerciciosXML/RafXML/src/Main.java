import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        File file = new File("personas.dat");

        if (file.exists()) {
            file.delete();
        }

        // Cada persona ocupará 68 bytes
        // 12 * 2 bytes el nombre, 10 * 2 bytes apellido1, 10 * 2 bytes apellido2, 4 bytes edad
        Persona[] personas = {
                new Persona(String.format("%-12s", "Brais"), String.format("%-10s", "Moure"), String.format("%-10s", "Dev"), 30),
                new Persona(String.format("%-12s", "Samuel"), String.format("%-10s", "Blas"), String.format("%-10s", "Garcia"), 20),
                new Persona(String.format("%-12s", "Miriam"), String.format("%-10s", "Moreno"), String.format("%-10s", "Torres"), 22)
        };
        try {
            RandomAccessFile raf = new RandomAccessFile("personas.dat", "rw");

            for (Persona p : personas) {
                //byte[] bufferNombre = p.getNombre().getBytes();
                raf.writeChars(p.getNombre());
                raf.writeChars(p.getApellido1());
                raf.writeChars(p.getApellido2());
                raf.writeInt(p.getEdad());
            }

            System.out.println("Personas insertadas en el fichero correctamente");

            raf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-----------------------------------------------------------");
        System.out.println("Activando modo lectura para meter dicha información en un XML");
        try {
            RandomAccessFile raf = new RandomAccessFile("personas.dat", "r");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element root = document.createElement("personas");
            document.appendChild(root);

            raf.seek(0);

            System.out.println("---------------------------------------------------");
            System.out.println("Preparando datos para insertar en el XML");
            while (raf.getFilePointer() < raf.length()) {
                Element persona = document.createElement("persona");
                char[] charNombre = new char[12];
                for (int i = 0; i < charNombre.length; i++) {
                    charNombre[i] = raf.readChar();
                }
                String nombre = new String(charNombre).trim();
                Element nombreE = document.createElement("nombre");
                nombreE.setTextContent(nombre);
                persona.appendChild(nombreE);

                char[] charApellidos = new char[10];
                for (int i = 0; i < charApellidos.length; i++) {
                    charApellidos[i] = raf.readChar();
                }
                String apellido1 = new String(charApellidos).trim();
                Element apellido1E = document.createElement("apellido1");
                apellido1E.setTextContent(apellido1);
                persona.appendChild(apellido1E);

                charApellidos = new char[10];
                for (int i = 0; i < charApellidos.length; i++) {
                    charApellidos[i] = raf.readChar();
                }
                String apellido2 = new String(charApellidos).trim();
                Element apellido2E = document.createElement("apellido2");
                apellido2E.setTextContent(apellido2);
                persona.appendChild(apellido2E);

                int edad = raf.readInt();
                Element edadE = document.createElement("edad");
                edadE.setTextContent(String.valueOf(edad));
                persona.appendChild(edadE);

                root.appendChild(persona);
            }

            DOMSource domSource = new DOMSource(document);
            StreamResult result = new StreamResult("personas.xml");

            System.out.println("--------------------------------------------------------------------");
            System.out.println("Creando XML");
            Transformer transformer = TransformerFactory.newDefaultInstance().newTransformer();

            transformer.transform(domSource, result);
            System.out.println("XML CREADO");

            System.out.println("-------------------------------------------------------------------");
            System.out.println("Lectura del fichero XML");

            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            document = builder.parse(new File("personas.xml"));

            // Normalizamos
            document.getDocumentElement().normalize();

            // Root
            String nombreRoot = document.getDocumentElement().getNodeName();
            System.out.println("Raiz del elemento: " + nombreRoot);

            // Obtenemos los hijos de raiz
            NodeList listaNodos = document.getElementsByTagName("persona");

            System.out.println("Datos de las personas");

            for (int i = 0; i < listaNodos.getLength(); i++) {
                Node personaNodo = listaNodos.item(i);

                if (personaNodo.getNodeType() == Node.ELEMENT_NODE){
                    Element persona = (Element) personaNodo;

                    String nombre = persona.getElementsByTagName("nombre").item(0).getTextContent();
                    String apellido1 = persona.getElementsByTagName("apellido1").item(0).getTextContent();
                    String apellido2 = persona.getElementsByTagName("apellido2").item(0).getTextContent();
                    String edad = persona.getElementsByTagName("edad").item(0).getTextContent();

                    System.out.println("Datos persona: " + nombre + " " + apellido1 + " " + apellido2 + " " + edad + " años");
                }
            }
        } catch (ParserConfigurationException | IOException | TransformerException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
}