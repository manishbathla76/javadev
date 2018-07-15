import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Base64;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;


public class MyHttpsClient {
		public static void main(String[] a){
			try {

				SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

				String name = "admin";
				String password = "password";

				String authString = name + ":" + password;
				System.out.println("auth string: " + authString);
				byte[] authEncBytes = Base64.getEncoder().encode(authString.getBytes());
				String authStringEnc = new String(authEncBytes);
				System.out.println("Base64 encoded auth string: " + authStringEnc);
				URL url = new URL("https://localhost:8000/test");
				HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
				conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
				conn.setSSLSocketFactory(sslsocketfactory);
				InputStream inputstream = conn.getInputStream();
				InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
				BufferedReader bufferedreader = new BufferedReader(inputstreamreader);

				String string = null;
				while ((string = bufferedreader.readLine()) != null) {
				    System.out.println("Received " + string);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
}
