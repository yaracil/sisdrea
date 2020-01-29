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
public class LomStandar_SubCategory_Rights extends LomStandar_Rasgo {

    public LomStandar_SubCategory_Rights(String name, String valSubCat) {
        super();
        setCatName("rights");
        setName(name.toLowerCase());
        setValue(valSubCat);
        setNormValue(valSubCat.toLowerCase());
        normalize();
        noReconocido();
    }

    @Override
    protected void normalize() {
        String val=this.value.getNormValue();
        if (name.contains("cost")) {
//            setName(aux + "/cost");
            setTipo(LomStandar_RasgoTypeValue.BINARIO);
            setNormValue(normalizeBinaryY_N(val));
            super.setId(27);

        } else if (name.contains("copyrightandotherrestrictions")) {
//            setName(aux + "/copyrightandotherrestrictions");
            setTipo(LomStandar_RasgoTypeValue.BINARIO);
            setNormValue(normalizeBinaryY_N(val));
            super.setId(28);

        } else if (name.contains("description")) {
//            setName(aux + "/description");
            setTipo(LomStandar_RasgoTypeValue.STRING);
            super.setId(29);
        }
    }

}
