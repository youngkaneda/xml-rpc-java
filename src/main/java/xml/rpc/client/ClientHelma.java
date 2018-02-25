/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.rpc.client;

import helma.xmlrpc.XmlRpcClient;
import helma.xmlrpc.XmlRpcException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Vector;

/**
 *
 * @author juan
 */
public class ClientHelma 
{
    public static void main(String[] args) throws MalformedURLException, XmlRpcException, IOException 
    {
        XmlRpcClient client = new XmlRpcClient("http://localhost:8080/RPC2");
        Vector params = new Vector();
        params.add(1);
        params.add(3);
        Integer result = (Integer) client.execute("sample.sum", params);
        System.out.println(result.intValue());
    }
    
}
