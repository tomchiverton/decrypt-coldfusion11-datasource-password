import coldfusion.util.PasswordUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;

public class decryptCf11Dsn {

public static void main(String[] args) throws FileNotFoundException,IOException {

	String pth=args[0] + File.separatorChar + "lib" + File.separatorChar + "seed.properties";
	File seedFile = new File( pth );
	Properties prop = new Properties();
	prop.load(new FileInputStream(seedFile));

    String str= PasswordUtils.decryptPassword( args[1], prop.getProperty("seed") ); //encryption method string probably goes here

    System.out.println( str );
}

}