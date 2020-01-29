/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CaseBaseModel;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

/**
 *
 * @author Yoe
 */
public class LoriEvaluation {

    private static final String[] categoryNames
            = {"Calidad de los contenidos", "Adecuación de los objetivos de aprendizaje", "Feedback (Retroalimentación) y Adaptabilidad",
                "Motivación", "Diseño y presentación", "Usabilidad", "Accesibilidad", "Reusabilidad", "Cumplimiento de estándares"};

    public enum evaluation {

        NO_PROCEDE, MAL, REGULAR, BIEN, MUY_BIEN, EXCELENTE
    };

    private HashMap<Integer, evaluation> categories;

    public LoriEvaluation() {
        categories = new HashMap<>();
    }

    public evaluation getCategoryEvaluation(String cat) {
        int k = getCatNameIndex(cat);
        if (k != -1) {
            return categories.get(k);
        }
        return null;
    }

    public boolean isEmpty() {
        return categories.isEmpty();
    }

    public HashMap<Integer, evaluation> getCategories() {
        return categories;
    }

    public String getCategoryName(int i) {
        return categoryNames[i];
    }

    public int getCategoryId(String i) {
        for (int j = 0; j < categoryNames.length; j++) {
            if (categoryNames[j].equals(i)) {
                return j;
            }
        }
        return -1;
    }

    public evaluation getEvaluation(int key) {
        return categories.get(key);
    }

    public Iterator getIterator() {
        return categories.values().iterator();

    }

    public void addEvaluation(int cat, evaluation value) {
        categories.put(cat, value);
    }

    public void addEvaluation(String cat, int eval) throws Exception {
        int catIndex = getCatNameIndex(cat);
        if (catIndex != -1) {
            addEvaluation(catIndex, eval);
        } else {
            throw new Exception("No se reconoce el nombre de la categoría: " + cat);
        }
    }

    public int getCatNameIndex(String cat) {
        int k = -1;
        for (int i = 0; i < categoryNames.length; i++) {
            if (categoryNames[i].equals(cat)) {
                k = i;
                break;
            }
        }
        return k;

    }

    public void addEvaluation(int cat, int value) throws Exception {
        if (value == 0) {
            categories.put(cat, evaluation.NO_PROCEDE);
        } else if (value == 1) {
            categories.put(cat, evaluation.MAL);
        } else if (value == 2) {
            categories.put(cat, evaluation.REGULAR);
        } else if (value == 3) {
            categories.put(cat, evaluation.BIEN);
        } else if (value == 4) {
            categories.put(cat, evaluation.MUY_BIEN);
        } else if (value == 5) {
            categories.put(cat, evaluation.EXCELENTE);
        } else {
            throw new Exception("Evaluación fuera de rango: " + value);
        }
    }
}
