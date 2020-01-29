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
public class LomStandar_SubCategory_Relation extends LomStandar_Rasgo {

    public LomStandar_SubCategory_Relation(String name, String valSubCat) {
        super();
        setCatName("relation");
        setName(name.toLowerCase());
        setValue(valSubCat);
        setNormValue(valSubCat.toLowerCase());
        normalize();
        noReconocido();
    }

    @Override
    protected void normalize() {
        String val=this.value.getNormValue();
        name = name.toLowerCase();
        if (name.contains("kind")) {
//            setName(aux + "/kind");
            setTipo(LomStandar_RasgoTypeValue.STRING);
            setNormValue(normalizeKind(val));
            super.setId(30);

        }
    }

    private String normalizeKind(String val) {
        if (val.contains("part")) {
            return "es parte de";
        } else if (val.contains("requ")) {
            return "es requerido por";
        } else if (val.contains("isreferenc") || val.contains("is referenc") || val.contains("es referenciado")) {
            return "es referenciado por";
        } else if (val.contains("isreferenc") || val.contains("is referenc") || val.contains("es referenciado")) {
            return "es referenciado por";
        } else if (val.contains("references") || val.contains("referencia")) {
            return "referencia a";
        } else if (val.contains("is version") || val.contains("isversion") || val.contains("es versi")) {
            return "es versión de";
        } else if (val.contains("hasversion") || val.contains("has version") || val.contains("tiene versi")) {
            return "tiene version con";
        } else if (val.contains("isformat") || val.contains("is format") || val.contains("tiene parte")) {
            return "es formato de";
        } else if (val.contains("hasformat") || val.contains("has format") || val.contains("tiene formato")) {
            return "tiene formato con";
        } else if (val.contains("isbased") || val.contains("is based") || val.contains("es basado")) {
            return "es basado en";
        } else if (val.contains("isbasis") || val.contains("is basis") || val.contains("es base")) {
            return "es base para";
        } else if (val.contains("isrequired") || val.contains("is required") || val.contains("es requerido")) {
            return "es requerido por";
        } else if (val.contains("requi")) {
            return "requiere de";
        }
        return null;
    }

}
