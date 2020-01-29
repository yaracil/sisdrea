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
public class LomStandar_SubCategory_General extends LomStandar_Rasgo {

    public LomStandar_SubCategory_General(String name, String valSubCat) {
        super();
        this.catName = "general";
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
        if (name.contains("title")) {
//            setName(aux + "/title");
            super.value.setTipo(LomStandar_RasgoTypeValue.STRING);
            super.setId(1);

        } else if (name.contains("language")) {
//            setName(aux + "/language");
            setTipo(LomStandar_RasgoTypeValue.STRING);
            setNormValue(normalizeLanguage(val));
            super.setId(2);

        } else if (name.contains("description")) {
//            setName(aux + "/description");
            setTipo(LomStandar_RasgoTypeValue.STRING);
//            super.setId(3);

        } else if (name.contains("keyword")) {
//            setName(aux + "/keyword");
            setTipo(LomStandar_RasgoTypeValue.STRING);
            super.setId(4);

        } else if (name.contains("coverage")) {
//            setName(aux + "/coverage");
            setTipo(LomStandar_RasgoTypeValue.STRING);
            super.setId(5);

        } else if (name.contains("structure")) {
//            setName(aux + "/structure");
            setTipo(LomStandar_RasgoTypeValue.NOMINAL);
            setNormValue(normalizeStructure(val));
            super.setId(6);

        } else if (name.contains("aggregationlevel")) {
//            setName(aux + "/aggregationlevel");
            setTipo(LomStandar_RasgoTypeValue.NUMERIC);
            setNormValue(normalizeGetIntNumber(val));
            super.setId(7);
        }
    }

    private String normalizeStructure(String val) {
        if (val.contains("col")) {
            return "colección";
        } else if (val.contains("mix")) {
            return "mixta";
        } else if (val.contains("linea")) {
            return "lineal";
        } else if (val.contains("hierarchical") || val.contains("rquica")) {
            return "jerárquica";
        } else if (val.contains("networked") || val.contains("red")) {
            return "en_red";
        } else if (val.contains("branched") || val.contains("ramificada")) {
            return "ramificada";
        } else if (val.contains("parceled") || val.contains("compartimentada")) {
            return "compartimentada";
        } else if (val.contains("atomic") || val.contains("atómica")) {
            return "atómica";
        }
        return null;
    }

}
