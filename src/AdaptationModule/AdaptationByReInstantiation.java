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
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Yoe
 */
public class AdaptationByReInstantiation {

    public EvaluationResponseDescription AdaptationByReinstantiation(SimilarItems similares) {

        SimilarityDescription masParecido = similares.getBestMatch();
        REA k_1 = masParecido.getItem();
        LoriEvaluation evaluation = k_1.getEvaluation();
        float similaridad = masParecido.getPercentSimilarity();

        LinkedList<EvaluationResponseDescription> respuesta = new LinkedList<>();

        Set keys = evaluation.getCategories().keySet();
        Iterator it = keys.iterator();

        while (it.hasNext()) {
            Integer key = (Integer) it.next();
            String cat = evaluation.getCategoryName(key);
            LoriEvaluation.evaluation eval = evaluation.getEvaluation(key);
            respuesta.add(new EvaluationResponseDescription(cat, eval, similaridad));
        }
        Collections.sort(respuesta);

        return respuesta.getLast();
    }

    public String getProblemsResponse(EvaluationResponseDescription eval) {

        String cat = eval.getCatName();
        double similitud = eval.getCertidumbre();
        ProblemsDB problemas = null;
        try {
            problemas = new ProblemsDB();
        } catch (JDOMException ex) {
            Logger.getLogger(AdaptationByReInstantiation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdaptationByReInstantiation.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoriEvaluation aux = new LoriEvaluation();
        String resp = "Certidumbre de recomendación: " + similitud + "\n";
        resp += problemas.getCategoryProblems(aux.getCatNameIndex(cat));

        return resp+"\n";

    }
}
