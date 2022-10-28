import coldfusion.util.PasswordUtils;

import java.io.*;
import java.util.Properties;

import fr.prados.xpath4sax.*;

import org.xml.sax.*;

import javax.xml.parsers.*;

public class decryptCf11Dsn {

static String pass="";

public static void main(String[] args) throws FileNotFoundException,IOException,XPathSyntaxException,ParserConfigurationException,SAXException{

	String pth=args[0] + File.separatorChar + "lib" + File.separatorChar + "seed.properties";
	File seedFile = new File( pth );
	Properties prop = new Properties();
	prop.load(new FileInputStream(seedFile));

	if( args[1].indexOf("-p") == -1 ){
	     XPathXMLHandler handler=new XPathXMLHandler()
        {
            @Override
            public void findXpathNode(SAXXPath xpath, Object node)
            {
            	pass= ((ElementWrapper)node).getFirstChild().getTextContent();
            }
        };

		handler.setXPaths(XPathXMLHandler.toXPaths("//var[@name='"+args[1]+"']/struct/var[@name='password']/string"));
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		parser.parse(new FileInputStream( new File( args[0] + File.separatorChar + "lib" + File.separatorChar + "neo-datasource.xml" ) ) , handler);
	}else{
		pass=args[2];
	}

    String str= PasswordUtils.decryptPassword( pass, prop.getProperty("seed") );

    System.out.println( str );
}

}
