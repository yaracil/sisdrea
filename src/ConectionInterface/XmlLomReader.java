/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConectionInterface;

import CaseBaseModel.LomStandar_Rasgos;
import CaseBaseModel.REA;
import java.io.File;
import java.util.List;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Yoe
 */
public class XmlLomReader {

    org.jdom2.Element rootElement;
    Namespace nameSpace;
    LomStandar_Rasgos metadatos;

    public XmlLomReader(File fichero) throws Exception {
        SAXBuilder builder = new SAXBuilder();
        org.jdom2.Document doc = builder.build(fichero);
        rootElement = doc.getRootElement();
        if (rootElement.getChildren().get(0).getName().contains("metadata")) {
            rootElement = rootElement.getChildren().get(0).getChildren().get(0);
        }
        nameSpace = rootElement.getNamespace();
        metadatos = new LomStandar_Rasgos();

    }

    public Element getRootElement() {
        return rootElement;
    }

    public XmlLomReader(Element root) {
        rootElement = root;
        nameSpace = rootElement.getNamespace();
        metadatos = new LomStandar_Rasgos();
        if (rootElement.getChildren().get(0).getName().contains("lom")) {
            rootElement = rootElement.getChildren().get(0);
        }
        nameSpace = rootElement.getNamespace();
        metadatos = new LomStandar_Rasgos();
    }

    public REA toREA() {
        List<Element> categorias = rootElement.getChildren();
        String subCatName = "";
        String value = "";
        for (Element categoria : categorias) {
            List<Element> subCategorias = categoria.getChildren();

            for (Element subCategoria : subCategorias) {

                subCatName = categoria.getName() + "/" + subCategoria.getName();
                value = findValue(subCategoria);
                if (value != null && !value.isEmpty()) {
                    this.metadatos.addRasgo(subCatName, value);
//                    System.out.println(subCatName + "--------" + value);
                } else {
                    List<Element> subSubCategorias = subCategoria.getChildren();
                    for (Element subSubCategoria : subSubCategorias) {
                        String name = subCatName + "/" + subSubCategoria.getName();
                        String value2 = findValue(subSubCategoria);
                        if (value2 != null && !value2.isEmpty()) {
                            this.metadatos.addRasgo(name, value2);
//                            System.out.println(name + "--------" + value2);
                        }
                    }
                }
            }
        }
//         = rootElement.getChild("general", nameSpace).getChild("title", nameSpace).getValue().trim();

        REA rea = new REA(this.metadatos);
        return rea;
    }

    private String findValue(Element elem) {
        Element val = elem.getChild("value", nameSpace);
        if (val != null) {
            return val.getValue().trim();
        }
        String aux = elem.getChildText("langstring", nameSpace);
        if (aux != null) {
            return aux.trim();
        }
        aux = elem.getChildText("datetime", nameSpace);
        if (aux != null) {
            return aux.trim();
        }
        aux = elem.getChildText("string", nameSpace);
        if (aux != null) {
            return aux.trim();
        }
        aux = elem.getChildText("catalog", nameSpace);
        if (aux != null) {
            return aux.trim();
        }
        aux = elem.getChildText("dateTime", nameSpace);
        if (aux != null) {
            return aux.trim();
        }
        if (elem.getChildren().isEmpty()) {
            return elem.getText().trim();
        }
        return null;
    }

    private void listaToString(List<Element> list) {
        for (Element list1 : list) {
            System.out.println(list1.getName());
        }
    }
}
