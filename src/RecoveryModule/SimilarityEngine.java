/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecoveryModule;

import CaseBaseModel.REA;
import CaseBaseModel.REAs;
import CaseBaseModel.LomStandar_Rasgo;
import java.util.Iterator;

/**
 *
 * @author yoe
 */
public class SimilarityEngine {

//-----------------------------------------------------------------------------
// Methods
//-----------------------------------------------------------------------------
    /**
     * Get compute Distance between Target values and Item values
     *
     * @param SimilarityCriterionScores targetValues Values of target
     * @param SimilarityCriterionScores itemValues Values of item
     * @return Float Distance distance between they
     * @exceptions Not Exceptions
     */
    private float computeDistance(REA item,
            REA itemTarget) throws Exception {
        float sum = 0;

        Iterator targetValueList = itemTarget.getIterator();
        while (targetValueList.hasNext()) {
            //--- This is the score for one of the several criteria we measured
            LomStandar_Rasgo targetScore
                    = (LomStandar_Rasgo) targetValueList.next();
            //por default no son similares
            float similarity = 0;
            if (item.getRasgo(targetScore.getId()) != null) {
                similarity = targetScore.compareTo(item.getRasgo(targetScore.getId()));
            }
            float traitDistance = 1 - similarity;
            float delta = traitDistance * targetScore.getPeso();

            float squaredDelta = (delta * delta);
            sum += squaredDelta;            
            //--- while targetValueList.hasNext                        
        }
//        System.out.println(sum);
        float distMax=this.maxDistance(itemTarget);
//        System.out.println(distMax);
        float raizSum=(float)Math.sqrt(sum);
//        System.out.println(raizSum);
        float distance =raizSum/distMax;
//        System.out.println(distance);
        return distance;
    } //--- computeDistance (from one item to target)

    public float maxDistance(REA target) {
        Iterator targetValueList = target.getIterator();
        float sum = 0;
        while (targetValueList.hasNext()) {
            //--- This is the score for one of the several criteria we measured
            LomStandar_Rasgo targetScore
                    = (LomStandar_Rasgo) targetValueList.next();
            float delta = 1 * targetScore.getPeso();
            float squaredDelta = (delta * delta);
            sum += squaredDelta;
        }
//        System.out.println(sum);
        float distance = (float) Math.sqrt(sum);
        return distance;
    }

    public SimilarItems computeSimilarity(REAs items, REA itemtarget) throws Exception {

        //--- This is the item that we want to compare ourselves to
        //---   to see how similar we are         
        //--- Create a similarity descriptor for each item
        SimilarItems similarItems = new SimilarItems();
        Iterator itemList = items.getIterator();
        while (itemList.hasNext()) {
            REA item = (REA) itemList.next();

            SimilarityDescription descriptor = new SimilarityDescription();
            descriptor.setItem(item);

            float distance = computeDistance(item, itemtarget);

            descriptor.setPercentSimilarity(1 - distance);
            descriptor.setTargetDistance(distance);

            similarItems.add(descriptor);
        }  //--- itemList.hasNext()

        //--- Now that we know how similar everyone is, let's go and
        //---   and rank them so that the caller has an easy way to sort
        //---   the items and so to make it easier to select the
        //---   k-best matches
        similarItems.rankItems();

        //--- OK, we're all done, hand the whole package back to the caller
        return similarItems;
    }  //--- computeSimilarity (multiple items)

    /**
     * To compute how similar two items are, we first create a
     * single-dimensional range from 0 to some max distance number. We then give
     * each item a score that falls somewhere in that range The perfect item
     * will score 0, meaning the difference between what we're looking for and
     * this item is nothing The worst possible choice will score the max
     * distance, meaning it is the opposite of everything we wanted We can give
     * every item a score without knowing the max distance, but we need it if we
     * want to compute percent similarity To get the max distance, figure out
     * the number of criteria we were measuring to compute similarity. Multiply
     * each by its weight. Square the weights, add them all together and then
     * take the square root of that. In other words, do the old Pythagorean
     * Theorem on the weights For those who don't remember 9th grade geometry
     * (thank god!) the Pythagorean Theorem is that, for right triangles, the
     * length of side c is (a^2 + b^2) = c^2, so the length of c = sqrt(a^2 +
     * b^2)
     */
//    SimilarityCriteria criteria,
//            SimilarityWeights weights
//    private SimilarityCriterionScores normalizeValues(
//            Item item,
//            SimilarityCriteria criteria,
//            SimilarityWeights weights,
//            DataSetStatistics statistics) {
//
////        SimilarityCriterionScores normalizedValues = new SimilarityCriterionScores();
////
////		//--- Compute the normalized and weighted values of each trait we're 
//        //---   measuring. 
//        //--- The normalized value will be between 0 and 1 
//        //---   where 1 means you had the max value that existed in the data set,
//        //---   0 means you had the minimum value and any other number is basically
//        //---   how close you were to the min and max
//        Iterator criteriaList = criteria.iterator();
//        while (criteriaList.hasNext()) {
//            SimilarityCriterion criterion = (SimilarityCriterion) criteriaList.next();
//
//            String traitName = criterion.getFieldName();
//            int traitDataType = item.getTraitDataType(traitName);
//            String criterionID = criterion.getID();
//            SimilarityCriterionScore score
//                    = new SimilarityCriterionScore(criterionID);
//            normalizedValues.add(score);
//
//            float position = 0;
//            if ((traitDataType != TraitDescriptor.TYPE_FLOAT)
//                    && (traitDataType != TraitDescriptor.TYPE_INTEGER)) {
//				//--- We have a string or boolean
//                //--- We only do "=" on those, so see if they're equal
//                String value = item.getTraitValue(traitName).toString();
//                String targetValue = criterion.getValue().toString();
//                if (value.equals(targetValue)) {
//                    position = 1;
//                } else {
//                    position = 0;
//                }
//            } else {
//				//--- We have numbers, so we want to calculate where this
//                //---   trait for this item falls on the continuum
//                //---   from min value to max value
//                //--- We also want it to normalized to a percentage
//                //---   format, which means a float between 0 and 1
//                //--- Ex. - Say we have an SAT score of 1,000
//                //---   The max score on the SAT is 1600, min=400
//                //---   Our 1000 is half way between 400 and 1600
//                //---   We'd normalize this value to 0.5 (50%) by doing
//                //---   (score - min) / range
//                //---   = (1000 - 400) / (1600 - 400)
//                //---   = 600 / 1200
//                //---   = 0.5
//                float itemValue = item.getTraitValue(traitName).toFloat();
//                TraitStatistics stats = statistics.get(traitName);
//                float min = stats.getMinimumValue();
//                float range = stats.getRange();
//
//                position = (itemValue - min) / range;
//            }  //--- if dataType = ...
//
//            score.setNormalizedValue(position);
//
//            float weightedValue = (position * weights.get(traitName));
//            score.setWeightedValue(weightedValue);
//        }  //--- criteriaList.hasNext()
//
//        return normalizedValues;
//    }  //--- normalizeValues
}
