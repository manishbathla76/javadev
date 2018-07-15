import java.io.InputStream;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;


public class MySSLContext {
	
	public static SSLContext getSSLContext() throws Exception{
		 SSLContext sslContext = SSLContext.getInstance("TLS");

         // initialise the keystore
         char[] password = "manbat123".toCharArray();
         KeyStore ks = KeyStore.getInstance("JKS");
         InputStream fis = HttpsServerTest.class.getResourceAsStream("/keystore.jks");
         //FileInputStream fis = new FileInputStream(HttpServer.class.getResourceAsStream("/https.ks"));
         		//"https.ks");
         ks.load(fis, password);

         // setup the key manager factory
         KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
         kmf.init(ks, password);

         // setup the trust manager factory
         TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
         tmf.init(ks);

         // setup the HTTPS context and parameters
         sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
         return sslContext;
	}
	
}
