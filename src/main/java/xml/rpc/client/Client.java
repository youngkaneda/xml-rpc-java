/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.rpc.client;

import java.net.MalformedURLException;

import java.net.URL;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;

/**
 *
 * @author juan
 */
public class Client 
{
    public static void main(String[] args) throws MalformedURLException 
    {
        XmlRpcClient client = new XmlRpcClient();
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        try {
            config.setServerURL(new URL("http://127.0.0.1:3003/xmlrpc"));
            config.setEnabledForExtensions(true);
            config.setConnectionTimeout(60 * 1000);
            config.setReplyTimeout(60 * 1000);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        //usa Commons HtppCLient como transporte
        client.setTransportFactory(new XmlRpcCommonsTransportFactory(client));
        client.setConfig(config);
        
        Object[] params = new Object[] {new Integer(2), new Integer(5)};
        try {
            Integer result = (Integer) client.execute("sample.sum", params);
            
            System.out.printf("saída da soma [%s+%s] -> ", params[0], params[1]);
        } catch (XmlRpcException ex) {
            ex.printStackTrace();
        }
    }
}
