/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdaptationModule;

import CaseBaseModel.LoriEvaluation;
import CaseBaseModel.REA;
import RecoveryModule.SimilarItems;
import RecoveryModule.SimilarityDescription;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

/**
 *
 * @author Yoe
 */
public class AdaptationByFuzzyLogic {

    public EvaluationResponseDescription AdaptationByFuzzyLogic(SimilarItems similares) {
        List<HashMap<String, EvaluationResponseDescription>> primeros5 = new LinkedList<>();

        for (int i = 1; i < 6; i++) {
            primeros5.add(getSimilarEvaluation(similares.getByRelativeRank(i)));

        }

        LoriEvaluation lori = new LoriEvaluation();

        LinkedList<EvaluationResponseDescription> _final = new LinkedList<>();

        float sum = 0;
        int cont = 0;
        float avg = 0;
        String cat;

        Iterator it = primeros5.iterator();

        for (int i = 0; i < 9; i++) {
            cat = lori.getCategoryName(i);

            while (it.hasNext()) {
                HashMap<String, EvaluationResponseDescription> rea = (HashMap<String, EvaluationResponseDescription>) it.next();
                if (rea.get(cat) != null) {
                    float cert = (float) rea.get(cat).getCertidumbre();
                    sum += cert;
                    cont++;
                    
                    System.out.println(cert + "----" + cont+"---sum: "+sum);
                }
            }
            avg = sum / cont;

            System.out.println(cat + "----avg- " + avg);
            _final.add(new EvaluationResponseDescription(cat, LoriEvaluation.evaluation.MAL, avg));
            sum = 0;
            cont = 0;
            avg = 0;
            it = primeros5.iterator();
        }
        Collections.sort(_final);
        return _final.getLast();
    }

    public HashMap<String, EvaluationResponseDescription> getSimilarEvaluation(SimilarityDescription similar) {

        REA k_1 = similar.getItem();
        LoriEvaluation evaluation = k_1.getEvaluation();
        float similaridad = similar.getPercentSimilarity();

        HashMap<String, EvaluationResponseDescription> ret = new LinkedHashMap<>();

        Set keys = evaluation.getCategories().keySet();
        Iterator it = keys.iterator();

        while (it.hasNext()) {
            Integer key = (Integer) it.next();
            String cat = evaluation.getCategoryName(key);
            LoriEvaluation.evaluation eval = evaluation.getEvaluation(key);
            ret.put(cat, new EvaluationResponseDescription(cat, eval, similaridad));
        }
        return ret;
    }

    public String getProblemsResponse(EvaluationResponseDescription eval) {

        String cat = eval.getCatName();
        float similitud = eval.getCertidumbre();
        ProblemsDB problemas = null;
        try {
            problemas = new ProblemsDB();
        } catch (JDOMException ex) {
            Logger.getLogger(AdaptationByReInstantiation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdaptationByReInstantiation.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoriEvaluation aux = new LoriEvaluation();
        String resp = " de recomendación: " + similitud + "\n";
        resp += problemas.getCategoryProblems(aux.getCatNameIndex(cat));

        return resp;

    }
}
