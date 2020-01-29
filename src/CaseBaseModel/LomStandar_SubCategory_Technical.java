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
public class LomStandar_SubCategory_Technical extends LomStandar_Rasgo {

    public LomStandar_SubCategory_Technical(String name, String valSubCat) {
        super();
        setCatName("technical");
        setName(name.toLowerCase());
        setValue(valSubCat);
        setNormValue(valSubCat.toLowerCase());
        normalize();
        noReconocido();
    }

    @Override
    protected void normalize() {
        String val = this.value.getNormValue();
        if (name.contains("format")) {
//            setName(aux + "/format");
            setTipo(LomStandar_RasgoTypeValue.STRING);
            super.setId(11);

        } else if (name.contains("size")) {
//            setName(aux + "/size");
            setTipo(LomStandar_RasgoTypeValue.NUMERIC);
            setNormValue(normalizeGetDoubleNumber(val));
            super.setId(12);

        } else if (name.contains("requeriment")) {
//            setName(aux + "/requeriment");
            setTipo(LomStandar_RasgoTypeValue.STRING);
            super.setId(13);

        } else if (name.contains("instalationremarks")) {
//            setName(aux + "/instalationremarks");
            setTipo(LomStandar_RasgoTypeValue.STRING);
            super.setId(14);

        } else if (name.contains("otherplatformsrequirements")) {
//            setName(aux + "/otherplatformsrequirements");
            setTipo(LomStandar_RasgoTypeValue.STRING);
            super.setId(15);
        }
    }

}
