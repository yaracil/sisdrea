/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecoveryModule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author yoe
 */
public class SimilarItems {
    //-----------------------------------------------------------------------------
// Attributes
//-----------------------------------------------------------------------------
    //--- Sorted list of SimilarityDescription objects
    private ArrayList descriptions = new ArrayList();

//-----------------------------------------------------------------------------
// Methods
//-----------------------------------------------------------------------------
    protected void add(SimilarityDescription descriptor) {
        descriptions.add(descriptor);
    }  //--- add

    public ArrayList getDescriptions() {
        return descriptions;
    }

    public SimilarityDescription getBestMatch() {
        SimilarityDescription descriptor
                = (SimilarityDescription) descriptions.get(0);

        return descriptor;
    }  //--- getBestMatch

    public SimilarItems getBestMatches(int numberOfMatches) {
        SimilarItems subset = new SimilarItems();

        if (numberOfMatches > descriptions.size()) {
            numberOfMatches = descriptions.size();
        }

        for (int i = 0; i < numberOfMatches; i++) {
            SimilarityDescription description
                    = (SimilarityDescription) descriptions.get(i);

            subset.add(description);
        }

        return subset;
    }  //--- getBestMatches

    public SimilarItems getByPercentSimilarity(float percentSimilar) {
        SimilarItems subset = new SimilarItems();

        for (int i = 0; i < descriptions.size(); i++) {
            SimilarityDescription description
                    = (SimilarityDescription) descriptions.get(i);

            if (description.getPercentSimilarity() == percentSimilar) {
                subset.add(description);
            }
        }

        return subset;
    }  //--- getByPercentSimilarity

    public SimilarItems getByRank(int rank) {
        SimilarItems subset = new SimilarItems();

        for (int i = 0; i < descriptions.size(); i++) {
            SimilarityDescription description
                    = (SimilarityDescription) descriptions.get(i);

            if (description.getRank() == rank) {
                subset.add(description);
            }
        }

        return subset;
    }  //--- getByRank

    public SimilarityDescription getByRelativeRank(int rank) {
        int index = rank - 1;	//--- 0 based array

        SimilarityDescription descriptor
                = (SimilarityDescription) descriptions.get(index);

        return descriptor;
    }  //--- getByRelativeRank

    public SimilarItems getByThreshold(float minimumPercentSimilar) {
        SimilarItems subset = new SimilarItems();

        for (int i = 0; i < descriptions.size(); i++) {
            SimilarityDescription description
                    = (SimilarityDescription) descriptions.get(i);

            if (description.getPercentSimilarity() >= minimumPercentSimilar) {
                subset.add(description);
            }
        }

        return subset;
    }  //--- getByThreshold

    public boolean isEmpty() {
        return false;
    }

    public Iterator iterator() {
        return descriptions.iterator();
    }

    public void rankItems() {
        try {
            Collections.sort(this.descriptions);

			//--- Hopefully now the index is the also the sort order of the item
            //---   so we'll use it for our ranking
            for (int i = 0; i < descriptions.size(); i++) {
                SimilarityDescription description
                        = (SimilarityDescription) descriptions.get(i);

                int rank = i + 1;  //--- +1 to compensate for 0-based arrays
                description.setRank(rank);
            }  //--- for i=0 to fields.size		

        } catch (Exception e) {
            System.out.println("exception: " + e);
            e.printStackTrace();
        }  //--- catch

    }  //--- rankItems

    public int size() {
        return descriptions.size();
    }  //--- size

}
