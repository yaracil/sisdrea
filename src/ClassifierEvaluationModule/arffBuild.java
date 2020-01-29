/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template relationText, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassifierEvaluationModule;

import CaseBaseModel.LomStandar_Rasgo;
import CaseBaseModel.REA;
import CaseBaseModel.REAs;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 *
 * @author Yoe
 */
public class arffBuild {

    String uri = ".arff";
    String relationText;
    String attributeText;
    String dataText;

    public arffBuild(REAs casos) throws IOException {
        relationText = "@relation RHODA" + "\n"+"\n";
        loadAttributeText();
        dataText = "\n" + "@data";
        loadDataText(casos);
        
        System.out.println(relationText+attributeText+dataText);

    }

    public void loadAttributeText() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("C:\\Users\\Yoe\\Documents\\NetBeansProjects\\utiles\\attribute.txt");
        //Leemos el fichero y lo mostramos por pantalla
        int valor = fr.read();
        while (valor != -1) {
            relationText += (char) valor;
            valor = fr.read();
        }
    }

    public void loadDataText(REAs casos) {

        Iterator it = casos.getIterator();

        while (it.hasNext()) {
            REA rea = (REA) it.next();
            dataText+="\n";
            for (int i = 1; i <= 35; i++) {
                LomStandar_Rasgo aux = rea.getRasgo(i);
                if (aux != null) {
                    dataText += aux.getNormalSubCatValue() + ",";
                } else {
                    dataText += "?,";
                }
            }
            int aux = dataText.lastIndexOf(",");
            dataText = dataText.substring(0, aux);            
        }
    }

//    public String buildAttributes(REAs casos) {
//
//    }
    public String getAttributeText() {
        return attributeText;
    }

    public String getRelationText() {
        return relationText;
    }

}
