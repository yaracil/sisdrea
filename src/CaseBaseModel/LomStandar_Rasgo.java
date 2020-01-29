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
public abstract class LomStandar_Rasgo {

    protected String catName;

    protected String name;

    protected LomStandar_RasgoValue value;

    protected int id;

    final protected int peso = 1;

    public LomStandar_Rasgo() {
        value = new LomStandar_RasgoValue();
        catName = "";
        name = "";
        id=-1;
    }

    protected abstract void normalize();

    protected String normalizeLanguage(String val) {
        if (val.contains("esp") || !val.contains("span")) {
            return "es";
        } else if (val.contains("en") || val.contains("ing")) {
            return "en";
        } else if (val.contains("fr")) {
            return "fr";
        }
        return null;
    }

    protected void noReconocido() {
        if (getName().isEmpty()) {
            throw new NullPointerException("No se reconoce el rasgo " + getName());
        }
    }

    protected String normalizeGetDoubleNumber(String val) {
        String numb = "";
        int num = 0;
        if (!val.isEmpty()) {
            for (int i = 0; i < val.length() && num != 3; i++) {
                char k = val.charAt(i);
                if (numb.isEmpty() && (Character.isLetter(k) || k == ' ')) {

                } else if ((Character.isLetter(k))) {
                    break;
                } else {
                    numb += val.charAt(i);
                }
            }
            if (Double.valueOf(numb) != 0) {
                return numb.trim();
            }
        }
        return null;
    }

    protected String normalizeGetIntNumber(String val) {
        if (!val.isEmpty()) {
            return (Integer.valueOf(val)).toString();
        }
        return null;
    }

    protected String normalizeBinaryY_N(String val) {
        if (val.contains("y") || val.contains("s")) {
            return "si";
        } else {
            return "no";
        }
    }

// SETERS
    protected void setTipo(LomStandar_RasgoTypeValue tipo) {
        this.value.setTipo(tipo);
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setValue(String value) {
        this.value.setValue(value);
    }

    protected void setNormValue(String value) {
        this.value.setNormValue(value);
    }

    protected void setCatName(String catName) {
        this.catName = catName;
    }

    public void setId(int id) {
        this.id = id;
    }

//GETERS
    public String getName() {
        return name;
    }

    public String getCatName() {
        return catName;
    }

    public String getNormalSubCatValue() {
        return value.getNormValue();
    }

    public int getPeso() {
        return peso;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value.getValue();
    }

    public String toString() {
        return "id: "+id+" rasgo---" + name + "-------valor real: " + getValue() + "    valor normalizado: " + getNormalSubCatValue();
    }
//    public String toString() {
//        String resp = "rasgo: " + name;
//        String resp3="";  
//        int valcont=40-name.length();
//        
//        for (int i = 0; i < valcont; i++) {
//            resp3+="~";            
//        }
//        return resp+resp3+">> "+getValue();
//    }

    public float compareTo(LomStandar_Rasgo trait) throws Exception {
        if (!name.equals(trait.getName())) {
            throw new Exception("No se puede comparar, los rasgos no coinciden");
        }
        String traitVal = trait.getNormalSubCatValue();
        if (traitVal == null || traitVal.isEmpty()) {
            traitVal = trait.getValue();
        }
        String targetVal = value.getNormValue();
        if (targetVal == null || targetVal.isEmpty()) {
            targetVal = value.getValue();
        }
//        float similarity = 0;
        if ((traitVal).equals(targetVal)) {
            return 1;
        } else {
            return 0;
        }
    }
}
