/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CaseBaseModel;

import CaseBaseModel.LoriEvaluation.evaluation;
import java.util.Iterator;

/**
 *
 * @author yoe
 */
public class REA {

    private String titulo;
    private String id;
    private LomStandar_Rasgos metadatos;
    private LoriEvaluation evaluation;

    public REA(LomStandar_Rasgos meta) {
        LomStandar_Rasgo title = meta.getRasgo(1);
        if (title != null) {
            this.titulo = title.getValue();
        } else {
            this.titulo = "sin titulo";
        }

        this.id = "";
        this.metadatos = meta;
        evaluation = new LoriEvaluation();
    }

    public REA(String id, LomStandar_Rasgos metadatos) {
        this.id = id;
        this.metadatos = metadatos;
        evaluation = new LoriEvaluation();
    }

    public LomStandar_Rasgos getMetadatos() {
        return metadatos;
    }

    public String getTitulo() {
        return titulo;
    }

    public Iterator getIterator() {
        return metadatos.iterator();
    }

    public String getId() {
        return id;
    }

    public LoriEvaluation getEvaluation() {
        return evaluation;
    }

    public LomStandar_Rasgo getRasgo(int trait) {
        return metadatos.getRasgo(trait);
    }

    public void setMetadatos(LomStandar_Rasgos metadatos) {
        this.metadatos = metadatos;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEvaluation(LoriEvaluation evaluation) {
        this.evaluation = evaluation;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String ret = "";
        ret += ("\n" + "Titulo: " + titulo);
        Iterator rasgos = metadatos.iterator();
        while (rasgos.hasNext()) {
            LomStandar_Rasgo rasgo = (LomStandar_Rasgo) rasgos.next();
            ret += "\n" + rasgo.toString();
        }
//        if (evaluation != null) {
//            ret += "\n" + "***Evaluación***";
//            for (int i = 0; i < 9; i++) {
//                String eval = evaluation.getEvaluation(i).name();
//                String cat = evaluation.getCategoryName(i);
//                ret += "\n" + cat + "----> " + eval;
//            }
//        }
        return ret;
    }

    public String toStringWithEvaluation() {
        String ret = "";
        ret += ("\n" + "Titulo: " + titulo);
        Iterator rasgos = metadatos.iterator();
        while (rasgos.hasNext()) {
            LomStandar_Rasgo rasgo = (LomStandar_Rasgo) rasgos.next();
            ret += "\n" + rasgo.toString();
        }
        if (evaluation != null) {
            ret += "\n" + "***Evaluación***";
            for (int i = 0; i < 9; i++) {
                LoriEvaluation.evaluation evalu = evaluation.getEvaluation(i);
                String eval = "";
                if (evalu == null) {
                    evalu = LoriEvaluation.evaluation.NO_PROCEDE;
                }
                eval = evalu.name();

                String cat = evaluation.getCategoryName(i);
                ret += "\n" + cat + "----> " + eval;
            }
        }
        return ret;
    }

    public void giveRandomEvaluation() throws Exception {
        int random;
        int i = 0;
        while (i != 9) {
            random = (int) (Math.random() * 10);
            if (random <= 5) {
                if (random != 0) {
                    evaluation.addEvaluation(i, random);
                }
                i++;
            }
        }
    }
}
