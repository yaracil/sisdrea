/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CaseBaseModel;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author yoe
 */
public class REAs {

    private ArrayList<REA> REAs;

    public REAs() {
        REAs = new ArrayList();
    }

    public ArrayList<REA> getREAs() {
        return REAs;
    }

    public Iterator getIterator() {
        return REAs.iterator();
    }

    public void addREA(REA rea) throws Exception {
        if (rea.getEvaluation().isEmpty()) {
            rea.giveRandomEvaluation();
        }
        REAs.add(rea);
    }

    public void addReas(REAs reas) throws Exception {

        Iterator it = reas.getIterator();
        while (it.hasNext()) {
            REA toAdd = (REA) it.next();
            if (this.existRea(toAdd.getId())) {
                throw new Exception("Ya existe el recurso en la base de casos");
            } else {
                this.REAs.add(toAdd);
            }
        }
    }

    public REA getREA(int pos) {
        return REAs.get(pos);
    }

    public REA getById(String id) {
        if (id != null && !id.isEmpty()) {
            for (int i = 0; i < REAs.size(); i++) {
                REA rea = REAs.get(i);
                if (rea.getId().equals(id)) {
                    return REAs.get(i);
                }
            }
        }
        return null;
    }

    public boolean existRea(String id) {
        if (getById(id) != null) {
            return true;
        }
        return false;
    }

    public boolean deleteRea(String id) {
        if (existRea(id)) {
            return REAs.remove(getById(id));
        }
        return false;
    }
}
