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
public class LomStandar_SubCategory_Annotation extends LomStandar_Rasgo {

    public LomStandar_SubCategory_Annotation(String name, String valSubCat) {
        super();
        setCatName("annotation");
        setName(name.toLowerCase());
        setValue(valSubCat);
        setNormValue(valSubCat.toLowerCase());
        normalize();
        noReconocido();
    }

    @Override
    protected void normalize() {
        name = name.toLowerCase();
        if (name.endsWith("description")) {
//            setName(aux + "/description");
            setTipo(LomStandar_RasgoTypeValue.STRING);
            super.setId(31);
        }
    }
}
