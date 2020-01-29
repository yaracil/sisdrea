/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecoveryModule;

import CaseBaseModel.REA;

/**
 *
 * @author yoe
 */
public class SimilarityDescription implements Comparable<SimilarityDescription> {

    //-----------------------------------------------------------------------------
// Attributes
//-----------------------------------------------------------------------------
    private REA itemBeingDescribed;
    private int rank;
    private float percentMatch;
    private float targetDistance;

//-----------------------------------------------------------------------------
// Methods
//-----------------------------------------------------------------------------
    /**
     * Implements the compareTo method required by the Comparable interface
     * We're gonna compare items based on their percent similarity Used by
     * SimilarItems.rankItems() The stupid argument name (o) is Sun's fault, not
     * mine
     *
     * Return codes: me > arg = -1 (better % match means we go first) me = arg =
     * 0 me < arg = +1 (it's a better match, it goes first)
     */
    @Override
    public int compareTo(SimilarityDescription arg) {
        //--- If this fails, it'll throw a ClassCastException, which we
        //---   expect the idiot who pass us this argument to handle       

        int result = 0;	//--- default to being equal

        if (this.getTargetDistance() < arg.getTargetDistance()) {
            result = -1;
        }
        if (this.getTargetDistance() > arg.getTargetDistance()) {
            result = 1;
        }
        return result;
    }  //--- compareTo

    public String toString() {
        String resp = "\n" + rank + "---->Recurso: ";
        resp += itemBeingDescribed.getTitulo() + "----> % similitud: " + percentMatch;
        return resp;
    }

//-----------------------------------------------------------------------------
// Accessors
//-----------------------------------------------------------------------------
    public REA getItem() {
        return itemBeingDescribed;
    }

    public int getRank() {
        return rank;
    }

    public float getPercentSimilarity() {
        return percentMatch;
    }

    protected void setItem(REA newItem) {
        itemBeingDescribed = newItem;
    }

    protected void setPercentSimilarity(float newPercentMatch) {
        percentMatch = newPercentMatch;
    }

    protected void setRank(int newRank) {
        rank = newRank;
    }

    public float getTargetDistance() {
        return targetDistance;
    }

    public void setTargetDistance(float targetDistance) {
        this.targetDistance = targetDistance;
    }

}
