/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConectionInterface;

import CaseBaseModel.REA;
import CaseBaseModel.REAs;
import GUI_SBC.Principal;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Yoe
 */
public class RestConectionUser {

    /**
     * @param args the command line arguments
     */
    public RestConectionUser() {
    }

    public REAs getReas() throws JDOMException, IOException, Exception {
        //        try {
//
//            BufferedReader response = responseToDocument("http://10.55.11.230/roa/web/roa_dev.php/interoperability/request?verb=ListRecords&metadataPrefix=oai_imsmd&from=2015-04-15&until=2015-05-15", "GET", null);
//
//            if (response.ready()) {
//                org.jdom2.Document xml = toDocument(response);
//                Element root=xml.getRootElement();
//                Namespace namespace=root.getNamespace();
//                List<Element> records=root.getChildren();
//                System.out.println(records.get(0).getName());
////                System.out.println(.getValue());
//            }
////            
//
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(RestConectionUser.class.getName()).log(Level.SEVERE, null, ex);
//        }

        File response = new File("C:\\Users\\Yoe\\Documents\\!!TESIS\\Base de Casos\\request.xml");
        SAXBuilder builder = new SAXBuilder();
        org.jdom2.Document doc = null;

        doc = builder.build(response);

        Element root = doc.getRootElement();

        Namespace namespace = root.getNamespace();
        root = root.getChild("ListRecords", namespace);

        List<Element> records = root.getChildren("record", namespace);
        REAs reas = new REAs();

        for (Element record : records) {
            String id = record.getChild("header", namespace).getChildText("identifier", namespace);
            XmlLomReader xml = new XmlLomReader(record.getChild("metadata", namespace));
            REA rea = xml.toREA();
            rea.setId(id);
            reas.addREA(rea);
        }
        return reas;
    }

    public static HttpURLConnection getHttpConnection(String url, String type) throws ProtocolException, IOException {
        URL uri = null;
        HttpURLConnection con = null;

        uri = new URL(url);
        con = (HttpURLConnection) uri.openConnection();
        con.setRequestMethod(type); //type: POST, PUT, DELETE, GET
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setConnectTimeout(60000); //60 secs
        con.setReadTimeout(60000); //60 secs
        con.setRequestProperty("Accept-Encoding", "Your Encoding");
//            con.setRequestProperty("Content-Type", "Your Encoding");

        return con;
    }

    public static BufferedReader responseToDocument(String url, String type, String reqbody) throws IOException, JDOMException {

        HttpURLConnection con = null;

        con = getHttpConnection(url, type);
        //you can add any request body here if you want to post            

        if (reqbody != null) {

            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(reqbody);
            out.flush();
            out.close();
        }
        con.connect();
//            Document xml= new DefaultStyledDocument((AbstractDocument.Content) con.getContent(), StyleContext.getDefaultStyleContext());

        System.out.println(con.getContentType());

        InputStream content = con.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(content));

//        String temp = null;
//        StringBuilder sb = new StringBuilder();
//        while ((temp = in.readLine()) != null) {
//            sb.append(temp);
//            sb.append("\n");
//        }
//      String result result = sb.toString();       
//result is the response you get from the remote side
        return in;
    }

    public static org.jdom2.Document toDocument(BufferedReader in) throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        org.jdom2.Document doc;

        doc = builder.build(in);
        in.close();
        return doc;
    }

    public static String toString(BufferedReader response) throws IOException {

        String temp = null;
        StringBuilder sb = new StringBuilder();
        while ((temp = response.readLine()) != null) {
            sb.append(temp);
            sb.append("\n");
        }
        response.close();
        return sb.toString();
    }
}
