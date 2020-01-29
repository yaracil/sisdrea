/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CaseBaseModel;

import CaseBaseModel.LomStandar_Rasgo;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import javax.print.attribute.Attribute;
import javax.print.attribute.HashAttributeSet;
import sun.awt.image.ImageWatched;

/**
 *
 * @author Yoe
 */
public class LomStandar_Rasgos {

    private LinkedHashMap rasgos;

    public LomStandar_Rasgos() {
        rasgos = new LinkedHashMap<Integer, LomStandar_Rasgo>();
    }

    public void addRasgo(String nombSubCat, String valSubCat) {
        String name = nombSubCat.toLowerCase();
        LomStandar_Rasgo rasgo = null;

        if (!name.isEmpty()) {
            if (name.contains("general")) {
                rasgo = new LomStandar_SubCategory_General(nombSubCat, valSubCat);
            } else if (name.contains("lifecycle")) {
                rasgo = new LomStandar_SubCategory_LifeCycle(nombSubCat, valSubCat);
            } else if (name.contains("technical")) {

                rasgo = new LomStandar_SubCategory_Technical(nombSubCat, valSubCat);
            } else if (name.contains("educational")) {

                rasgo = new LomStandar_SubCategory_Educational(nombSubCat, valSubCat);
            } else if (name.contains("rights")) {

                rasgo = new LomStandar_SubCategory_Rights(nombSubCat, valSubCat);
            } else if (name.contains("relation")) {

                rasgo = new LomStandar_SubCategory_Relation(nombSubCat, valSubCat);
            } else if (name.contains("annotation")) {

                rasgo = new LomStandar_SubCategory_Annotation(nombSubCat, valSubCat);
            } else if (name.contains("classification")) {

                rasgo = new LomStandar_SubCategory_Classification(nombSubCat, valSubCat);
            } else if (!name.contains("metadata")) {
                throw new ExceptionInInitializerError("No se reconoce la categoría " + name);
            }
            if (!name.contains("metadata") && rasgo != null&&rasgo.getId()!=-1) {
                addRasgoIfMult(rasgo);
            }
        } else {
            throw new NullPointerException("Categoría vacía " + name);
        }
    }

    public void addRasgoIfMult(LomStandar_Rasgo rasgo) {
        int key = rasgo.getId();
        String val = rasgo.getNormalSubCatValue();
        LomStandar_Rasgo old = (LomStandar_Rasgo) rasgos.get(key);

        if (old != null && val != null) {
            String oldVal = old.getNormalSubCatValue();

            if (oldVal != null && !oldVal.contains(val)) {
                String newVal = oldVal + ", " + val;
                old.setNormValue(newVal);
                newVal = old.getValue() + ", " + rasgo.getValue();
                old.setValue(newVal);
//            rasgos.put(key, old);
            }
        } else {
            rasgos.put(key, rasgo);
        }
    }

    public LinkedHashMap getRasgos() {
        return rasgos;
    }
    
    public LomStandar_Rasgo getRasgo(int key) {
        return (LomStandar_Rasgo) rasgos.get(key);
    }

    public int rasgosSize() {
        return rasgos.size();
    }

    public Iterator iterator() {
        return rasgos.values().iterator();
    }

}
