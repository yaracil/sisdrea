/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdaptationModule;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Yoe
 */
public class ProblemsDB {

    private final String UriXmlLori = "XML Database/Instrumento_LORI.xml";
    private Element xmlLoriDatabase;

    public ProblemsDB() throws JDOMException, IOException {
        File f = new File(UriXmlLori);
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(f);
        xmlLoriDatabase = doc.getRootElement();
    }

    public String getCategoryProblems(int category) {
        category += 1;

        Element cat = xmlLoriDatabase.getChild("indicador" + category);

        List<Element> problems = cat.getChildren("problema");

        String resp = "Revise el aspecto: " + cat.getAttributeValue("nombre") + "\n";
        resp += "\n" + "***Posibles problemas****" + "\n";

        for (Element problema : problems) {
            resp += "\n" + "  - " + problema.getAttributeValue("value") + ".";
        }
        return resp;
    }

    public List<String> listCategoryProblems(int category) {
        category += 1;

        Element cat = xmlLoriDatabase.getChild("indicador" + category);

        List<Element> problems = cat.getChildren("problema");

        List<String> problemas = new LinkedList<>();

        for (Element problema : problems) {
            problemas.add(problema.getAttributeValue("value") + ".");
        }
        return problemas;
    }
}
