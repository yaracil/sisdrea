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
public class LomStandar_SubCategory_LifeCycle extends LomStandar_Rasgo {

    public LomStandar_SubCategory_LifeCycle(String name, String valSubCat) {
        super();
        setCatName("lifecycle");
        setName(name.toLowerCase());
        setValue(valSubCat);
        setNormValue(valSubCat.toLowerCase());
        normalize();
        noReconocido();
    }

    @Override
    protected void normalize() {
        String val = this.value.getNormValue();
        name = name.toLowerCase();
        if (name.contains("version")) {
//            setName(aux + "/version");
            setTipo(LomStandar_RasgoTypeValue.NUMERIC);
            setNormValue(normalizeGetDoubleNumber(val));
            super.setId(8);

        } else if (name.contains("status")) {
//            setName(aux + "/status");
            setTipo(LomStandar_RasgoTypeValue.NOMINAL);
            setNormValue(normalizeStatus(val));
            super.setId(9);

        } else if (name.contains("role")) {
//            setName(aux + "/contribute");
            setTipo(LomStandar_RasgoTypeValue.STRING);
            setNormValue(normalizeContribute(val));
            super.setId(10);
        }
    }

    private String normalizeStatus(String val) {
        if (val.contains("draft") || val.contains("borrador")) {
            return "borrador";
        } else if (val.contains("final")) {
            return "final";
        } else if (val.contains("revis")) {
            return "revisado";
        } else if (val.contains("unavailable") || val.contains("no disponible")) {
            return "no_disponible";
        }
        return null;
    }

    private String normalizeContribute(String val) {
        if (val.contains("author") || val.contains("autor")) {
            return "autor";
        } else if (val.contains("publi")) {
            return "publicador";
        } else if (val.contains("unknown") || val.contains("desconocido")) {
            return "desconocido";
        } else if (val.contains("ini")) {
            return "iniciador";
        } else if (val.contains("terminator") || val.contains("finalizador")) {
            return "finalizador";
        } else if (val.contains("technical validator") || val.contains("validador técnico")) {
            return "validador técnico";
        } else if (val.contains("educational validator") || val.contains("validador pedagógico") || val.contains("validador educac")) {
            return "validador pedagógico";
        } else if (val.contains("valida")) {
            return "validador";
        } else if (val.contains("editor")) {
            return "editor";
        } else if (val.contains("gr")) {
            return "diseñador gráfico";
        } else if (val.contains("conten")) {
            return "proveedor de contenidos";
        } else if (val.contains("script") || val.contains("guiones")) {
            return "escritor de guiones";
        } else if (val.contains("instructional designer") || val.contains("diseñador pedag")) {
            return "diseñador pedagógico";
        }
        return null;
    }
}
