package xml.rpc.server;

import java.io.IOException;
import org.apache.xmlrpc.XmlRpcException;;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.server.XmlRpcStreamServer;
import org.apache.xmlrpc.webserver.WebServer;
import xml.rpc.Sample;

/**
 * Hello world!
 *
 */
public class Server 
{
    public static void main( String[] args ) throws IOException
    {
        WebServer server = new WebServer(3003);
        XmlRpcStreamServer xmlRpcServer = server.getXmlRpcServer();
        PropertyHandlerMapping phm = new PropertyHandlerMapping();
        try {
            phm.addHandler("sample", Sample.class);
        } catch (XmlRpcException ex) {
            ex.printStackTrace();
        }
        xmlRpcServer.setHandlerMapping(phm);
        XmlRpcServerConfigImpl config = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
        config.setEnabledForExtensions(true);
        config.setContentLengthOptional(false);
        try {
            server.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
