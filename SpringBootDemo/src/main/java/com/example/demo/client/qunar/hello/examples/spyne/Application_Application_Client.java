
package com.example.demo.client.qunar.hello.examples.spyne;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import com.example.demo.client.qunar.project.*;

/**
 * This class was generated by Apache CXF 3.3.2
 * 2019-06-14T20:39:12.511+08:00
 * Generated source version: 3.3.2
 *
 */
public final class Application_Application_Client {

    private static final QName SERVICE_NAME = new QName("spyne.examples.hello", "QunarService");

    private Application_Application_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = QunarService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        QunarService ss = new QunarService(wsdlURL, SERVICE_NAME);
        Application port = ss.getApplication();

        {
        System.out.println("Invoking getTicketsData...");
        java.lang.String _getTicketsData_city = "";
        TicketArray _getTicketsData__return = port.getTicketsData(_getTicketsData_city);
        System.out.println("getTicketsData.result=" + _getTicketsData__return);


        }

        System.exit(0);
    }

}