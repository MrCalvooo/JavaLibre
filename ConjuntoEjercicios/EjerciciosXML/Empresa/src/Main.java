import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Empleado[] empleados = {
                new Empleado("Juan", "Desarrollador", 50000),
                new Empleado("Ana", "Diseñadora", 45000),
                new Empleado("Luis", "Gerente", 60000)
        };

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation domImplementation = builder.getDOMImplementation();
            Document document = domImplementation.createDocument(null, "empresa", null);
            document.setXmlVersion("1.0");

            Element emples = document.createElement("empleados");
            document.getDocumentElement().appendChild(emples);

            for (int i = 0; i < empleados.length; i++) {
                Element emple = document.createElement("empleado");
                emple.setAttribute("id", String.valueOf(empleados[i].getId()));
                Element nombre = document.createElement("Nombre");
                nombre.setTextContent(empleados[i].getNombre());
                Element puesto = document.createElement("Puesto");
                puesto.setTextContent(empleados[i].getPuesto());
                Element salario = document.createElement("Salario");
                salario.setTextContent(String.valueOf(empleados[i].getSalario()));

                emple.appendChild(nombre);
                emple.appendChild(puesto);
                emple.appendChild(salario);

                emples.appendChild(emple);
            }

            Source source = new DOMSource(document);
            Result result = new StreamResult(new File("empresa.xml"));

            Transformer transformer = TransformerFactory.newDefaultInstance().newTransformer();
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}