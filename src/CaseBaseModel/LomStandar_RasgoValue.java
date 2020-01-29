/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CaseBaseModel;

/**
 *
 * @author Yoe
 */
public class LomStandar_RasgoValue {

    private String value;
    private String normValue;

    private LomStandar_RasgoTypeValue tipo;

//GET
    protected String getValue() {
        return value;
    }

    protected LomStandar_RasgoTypeValue getTipo() {
        return tipo;
    }

    protected String getNormValue() {
        return normValue;
    }

//SET
    protected void setNormValue(String normValue) {
        this.normValue = normValue;
    }

    protected void setValue(String value) {
        this.value = value;
    }

    protected void setTipo(LomStandar_RasgoTypeValue tipo) {
        this.tipo = tipo;
    }
}
