/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.rpc.server;

import helma.xmlrpc.WebServer;
import java.io.IOException;
import java.net.UnknownHostException;
import xml.rpc.Sample;

/**
 *
 * @author juan
 */
public class ServerHelma 
{
    public static void main(String[] args) throws UnknownHostException, IOException 
    {
        WebServer server = new WebServer(8080);
        server.addHandler("sample", new Sample());
    }
    
}
