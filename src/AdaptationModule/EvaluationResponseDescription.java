/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdaptationModule;

import CaseBaseModel.LoriEvaluation;
import RecoveryModule.SimilarityDescription;
import java.io.Serializable;

/**
 *
 * @author Yoe
 */
public class EvaluationResponseDescription implements Comparable<EvaluationResponseDescription>,Serializable{

    /*
     Con el objetivo de estandarizar los datos la variable certidumbre
     guardar el valor de pertenencia a la clasificacion MAL teniendo en cuenta la siguiente distribucion:
     Excelente---->0
     Muy bien----->0.1
     Bien--------->0.3
     Regular------>0.6
     Mal---------->1
    
     */
    float certidumbre;
    String catName;

    public EvaluationResponseDescription(String cat, LoriEvaluation.evaluation eval, float similaridad) {
        catName = cat;
        System.out.println(fuzzificarEval(eval));
        
        certidumbre = fuzzificarEval(eval) * similaridad;
    }

    //get
    public String getCatName() {
        return catName;
    }

    public float getCertidumbre() {
        return certidumbre;
    }

    //set
    public void setCatName(String catName) {
        this.catName = catName;
    }

    public void setCertidumbre(float certidumbre) {
        this.certidumbre = certidumbre;
    }

    private float fuzzificarEval(LoriEvaluation.evaluation eval) {
        if (0 == eval.compareTo(LoriEvaluation.evaluation.EXCELENTE)) {
            return 0;
        } else if (0 == eval.compareTo(LoriEvaluation.evaluation.MUY_BIEN)) {
            return 0.1f;
        } else if (0 == eval.compareTo(LoriEvaluation.evaluation.BIEN)) {
            return 0.3f;
        } else if (0 == eval.compareTo(LoriEvaluation.evaluation.REGULAR)) {
            return 0.6f;
        } else if (0 == eval.compareTo(LoriEvaluation.evaluation.MAL)) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int compareTo(EvaluationResponseDescription o) {

        int result = 0;	//--- default to being equal

        if (this.getCertidumbre() < o.getCertidumbre()) {
            result = -1;
        }
        if (this.getCertidumbre() > o.getCertidumbre()) {
            result = 1;
        }
        return result;
    }

}
