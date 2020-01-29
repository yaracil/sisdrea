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
public class LomStandar_SubCategory_Educational extends LomStandar_Rasgo {

    public LomStandar_SubCategory_Educational(String name, String valSubCat) {
        super();
        setCatName("educational");
        setName(name.toLowerCase());
        setValue(valSubCat);
        setNormValue(valSubCat.toLowerCase());
        normalize();
        noReconocido();
    }

    @Override
    protected void normalize() {
        String val = this.value.getNormValue();
        if (name.endsWith("interactivitytype")) {
//            setName(aux + "/interactivitytype");
            setTipo(LomStandar_RasgoTypeValue.NOMINAL);
            setNormValue(normalizeInteractivitytype(val));
            super.setId(16);

        } else if (name.endsWith("learningresourcetype")) {
//            setName(aux + "/learningresourcetype");
            setTipo(LomStandar_RasgoTypeValue.STRING);
            setNormValue(normalizeLearningresourcetype(val));
            super.setId(17);

        } else if (name.endsWith("interactivitylevel")) {
//            setName(aux + "/interactivitylevel");
            setTipo(LomStandar_RasgoTypeValue.NOMINAL);
            setNormValue(normalizeStandarLow_Hihg(val));
            super.setId(18);

        } else if (name.endsWith("semanticdensity")) {
//            setName(aux + "/semanticdensity");
            setTipo(LomStandar_RasgoTypeValue.NOMINAL);
            setNormValue(normalizeStandarLow_Hihg(val));
            super.setId(19);

        } else if (name.endsWith("intendedenduserrole")) {
//            setName(aux + "/intendedenduserrole");
            setTipo(LomStandar_RasgoTypeValue.STRING);
            setNormValue(normalizeIntendedenduserrole(val));
            super.setId(20);

        } else if (name.endsWith("context")) {
//            setName(aux + "/context");
            setTipo(LomStandar_RasgoTypeValue.STRING);
            setNormValue(normalizeContext(val));
            super.setId(21);

        } else if (name.contains("typicalagerange")) {
//            setName(aux + "/typicalagerange");
            setTipo(LomStandar_RasgoTypeValue.NOMINAL);
            setNormValue(normalizeTypicalagerange(val));
            super.setId(22);

        } else if (name.contains("difficulty")) {
//            setName(aux + "/difficulty");
            setTipo(LomStandar_RasgoTypeValue.NOMINAL);
            setNormValue(normalizeDifficulty(val));
            super.setId(23);

        } else if (name.contains("typicallearningtime")) {
//            setName(aux + "/typicalLearningTime");
            setTipo(LomStandar_RasgoTypeValue.NUMERIC);
            setNormValue(normalizeGetDoubleNumber(val));
            super.setId(24);

        } else if (name.contains("description")) {
//            setName(aux + "/description");
            setTipo(LomStandar_RasgoTypeValue.STRING);
            setNormValue(val);
//            super.setId(25);

        } else if (name.contains("language")) {
//            setName(aux + "/language");
            setTipo(LomStandar_RasgoTypeValue.STRING);
            setNormValue(normalizeLanguage(val));
            super.setId(26);
        }
    }

    private String normalizeInteractivitytype(String val) {

        if (val.contains("activ")) {
            return "interactivo";
        } else if (val.contains("expositiv") || val.contains("pasivo")) {
            return "pasivos";
        } else if (val.contains("mix")) {
            return "mixto";
        }
        return null;
    }

    private String normalizeLearningresourcetype(String val) {
        if (val.contains("exercise") || val.contains("ejercicio")) {
            return "ejercicio";
        } else if (val.contains("simula")) {
            return "simulación";
        } else if (val.contains("uestion")) {
            return "cuestionario";
        } else if (val.contains("diagram")) {
            return "diagrama";
        } else if (val.contains("figur")) {
            return "figura";
        } else if (val.contains("graph") || val.contains("gráfico") || val.contains("grafico")) {
            return "gráfico";
        } else if (val.contains("index") || val.contains("ndice")) {
            return "índice";
        } else if (val.contains("slide") || val.contains("diapositiva")) {
            return "diapositiva";
        } else if (val.contains("tabl")) {
            return "tabla";
        } else if (val.contains("narrativ")) {
            return "texto narrativo";
        } else if (val.contains("exam")) {
            return "examen";
        } else if (val.contains("experiment")) {
            return "experimento";
        } else if (val.contains("problem")) {
            return "enunciado de problema";
        } else if (val.contains("autoevaluaci") || val.contains("asessment")) {
            return "autoevaluación";
        }
        return null;
    }

    private String normalizeStandarLow_Hihg(String val) {
        if (val.contains("very low") || val.contains("muy bajo")) {
            return "muy_bajo";
        } else if (val.contains("low") || val.contains("bajo")) {
            return "bajo";
        } else if (val.contains("medi")) {
            return "medio";
        } else if (val.contains("very high") || val.contains("muy alto")) {
            return "muy_alto";
        } else if (val.contains("high") || val.contains("alto")) {
            return "alto";
        }
        return null;
    }

    private String normalizeIntendedenduserrole(String val) {
        if (val.contains("teacher") || val.contains("maestro")) {
            return "maestro";
        } else if (val.contains("learner") || val.contains("aprendiz") || val.contains("est")) {
            return "aprendiz";
        } else if (val.contains("aut")) {
            return "autor";
        } else if (val.contains("manager") || val.contains("gestor")) {
            return "gestor";
        }
        return null;
    }

    private String normalizeContext(String val) {
        if (val.contains("primar")) {
            return "educación primaria";
        } else if (val.contains("secondary") || val.contains("secundaria")) {
            return "educación secundaria";
        } else if (val.contains("higher") || val.contains("superior")) {
            return "educación superior";
        } else if (val.contains("university first") || val.contains("primer ciclo universitario")) {
            return "primer ciclo universitario";
        } else if (val.contains("university second") || val.contains("segundo ciclo universitario")) {
            return "segundo ciclo universitario";
        } else if (val.contains("postgrad") || val.contains("postgrad")) {
            return "postgrado";
        } else if (val.contains("technical school first") || val.contains("primer ciclo de escuela técnica")) {
            return "primer ciclo de escuela técnica";
        } else if (val.contains("technical school second") || val.contains("segundo ciclo de escuela técnica")) {
            return "segundo ciclo de escuela técnica";
        } else if (val.contains("profes")) {
            return "profesional";
        } else if (val.contains("continu")) {
            return "formación continua";
        } else if (val.contains("voca") || val.contains("training")) {
            return "formación vocacional";
        }
        return null;
    }

    private String normalizeTypicalagerange(String val) {
        String[] edades = val.split("-");
        int edad;
        for (String edade : edades) {
            if (!edade.isEmpty()) {
                edade = edade.trim();
                edad = Integer.parseInt(normalizeGetDoubleNumber(edade));
                if (edad < 18) {
                    return "adolescente";
                } else if (edad > 24) {
                    return "adulto";
                }
            }

        }
        return "jóven";
    }

    private String normalizeDifficulty(String val) {
        if (val.contains("very easy") || val.contains("muy f")) {
            return "muy_fácil";
        } else if (val.contains("easy") || val.contains("fácil")) {
            return "fácil";
        } else if (val.contains("medi")) {
            return "medio";
        } else if (val.contains("very difficult") || val.contains("muy difícil")) {
            return "muy_difícil";
        } else if (val.contains("dif")) {
            return "difícil";
        }
        return null;
    }

}
