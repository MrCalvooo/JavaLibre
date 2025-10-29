import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Map<String, String[]> modelosPorMarca = new HashMap<>();
        modelosPorMarca.put("Toyota", new String[]{"Corolla", "Camry", "Yaris", "RAV4"});
        modelosPorMarca.put("Ford", new String[]{"Focus", "Mustang", "Explorer"});
        modelosPorMarca.put("Honda", new String[]{"Civic", "Accord", "CR-V"});
        modelosPorMarca.put("Volkswagen", new String[]{"Golf", "Passat", "Tiguan"});

        // Preparar el XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "vehiculos.xml",
                    null);
            document.setXmlVersion("1.0");

            for (String marca : modelosPorMarca.keySet()) {
                Element e = registrarMarca(document, marca);
                for (int i = 0; i < modelosPorMarca.size(); i++) {
                    crearCoche(document, e, modelosPorMarca.get(marca)[i], 0);
                }
            }

        } catch (ParserConfigurationException e) {
            System.err.println("Error al preparar el XML: " + e.getLocalizedMessage());
        }
    }

    public static Element registrarMarca(Document d, String marca) {
        Element e = d.createElement("marca");
        e.setAttribute("name", marca);
        return e;
    }

    public static void crearCoche(Document d, Element marca, String modelo, int precio) {

    }
}