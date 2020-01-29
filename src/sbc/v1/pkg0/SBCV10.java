/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbc.v1.pkg0;

import AdaptationModule.AdaptationByReInstantiation;
import CaseBaseModel.REA;
import CaseBaseModel.REAs;
import ClassifierEvaluationModule.arffBuild;
import ConectionInterface.RestConectionUser;
import ConectionInterface.XmlLomReader;
import GUI_SBC.Principal;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import org.jdom2.JDOMException;

/**
 *
 * @author yoe
 */
public class SBCV10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        try {
            //        try {
            // TODO code application logic here
//        MatchingItemsManager programa = new MatchingItemsManager();
//        programa.load();
//        Items todos =programa.getItems();
//        Items filtrados=programa.getFilteredItems();
//       
//        Iterator aux;
//        aux = todos.iterator();
//        
//        while (aux.hasNext()) {
//            System.out.println(aux.next().toString());            
//        }
//        aux= filtrados.iterator();
//        System.out.println("*************************************************");
//        while (aux.hasNext()) {
//            System.out.println(aux.next().toString());            
//        }
//    }
        Principal nuevo=null;
            try {
                nuevo = new Principal();
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(SBCV10.class.getName()).log(Level.SEVERE, null, ex);
            }
        nuevo.setVisible(true);
//            Principal princ = null;
//        try {
//            princ = new Principal();
//        } catch (UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(SBCV10.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            princ.setVisible(true);
//            
//        XmlLomReader nuev = null;
//        try {
//            nuev = new XmlLomReader(new File(new URI("file:///Users/Yoe/Documents/NetBeansProjects/SBC.V7/Español.xml")));
//        } catch (Exception ex) {
//            Logger.getLogger(SBCV10.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        REA target = nuev.toREA();
////        
////        System.out.println(target.toString());
//            RestConectionUser con = new RestConectionUser();
//            REAs casos = null;
//        try {
//            casos = con.getReas();
//        } catch (IOException ex) {
//            Logger.getLogger(SBCV10.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (Exception ex) {
//            Logger.getLogger(SBCV10.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            arffBuild nuev = new arffBuild(casos);
//        } catch (IOException ex) {
//            Logger.getLogger(SBCV10.class.getName()).log(Level.SEVERE, null, ex);
//        }
            
       

    }
}
