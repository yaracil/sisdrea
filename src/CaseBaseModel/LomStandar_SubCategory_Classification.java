/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CaseBaseModel;

import CaseBaseModel.LomStandar_Rasgo;

/**
 *
 * @author Yoe
 */
public class LomStandar_SubCategory_Classification extends LomStandar_Rasgo {

    public LomStandar_SubCategory_Classification(String name, String valSubCat) {
        super();
        setCatName("classification");
        setName(name.toLowerCase());
        setValue(valSubCat);
        setNormValue(valSubCat.toLowerCase());
        normalize();
        noReconocido();
    }

    @Override
    protected void normalize() {
        String val = this.value.getNormValue();
        if (name.endsWith("purpose")) {
//            setName(aux + "/purpose");
            setTipo(LomStandar_RasgoTypeValue.STRING);
            setNormValue(normalizePorpose(val));
            super.setId(32);

        } else if (name.endsWith("taxonpath")) {
//            setName(aux + "/taxonpath");
            setTipo(LomStandar_RasgoTypeValue.STRING);
            super.setId(33);

        } else if (name.endsWith("description")) {
//            setName(aux + "/description");
            setTipo(LomStandar_RasgoTypeValue.STRING);
            super.setId(34);

        } else if (name.endsWith("keyword")) {
//            setName(aux + "/keyword");
            setTipo(LomStandar_RasgoTypeValue.STRING);
            super.setId(35);
        }
    }

    private String normalizePorpose(String val) {
        if (val.contains("disciplin")) {
            return "disciplina";
        } else if (val.contains("idea")) {
            return "idea";
        } else if (val.contains("prer")) {
            return "prerrequisito";
        } else if (val.contains("obje")) {
            return "objetivo educativo";
        } else if (val.contains("acces")) {
            return "restricciones de acceso";
        } else if (val.contains("educational level") || val.contains("nivel educativo")) {
            return "nivel educativo";
        } else if (val.contains("skill") || val.contains("destreza") || val.contains("habilidad")) {
            return "nivel de destreza";
        } else if (val.contains("security") || val.contains("seguridad")) {
            return "nivel de seguridad";
        }
        return null;
    }

}
