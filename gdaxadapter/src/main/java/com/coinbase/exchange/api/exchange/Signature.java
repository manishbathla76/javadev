package com.coinbase.exchange.api.exchange;

import com.coinbase.exchange.api.constants.GdaxConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.management.RuntimeErrorException;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.util.Base64;

/**
 * Created by robevansuk on 17/03/2017.
 */
@Component
public class Signature {

    private String secretKey;

    public Signature() { }

    @Autowired
    public Signature(@Value("${gdax.secret}") String secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * The CB-ACCESS-SIGN header is generated by creating a sha256 HMAC using
     * the base64-decoded secret key on the prehash string for:
     * timestamp + method + requestPath + body (where + represents string concatenation)
     * and base64-encode the output.
     * The timestamp value is the same as the CB-ACCESS-TIMESTAMP header.
     * @param requestPath
     * @param method
     * @param body
     * @param timestamp
     * @return
     */
    public String generate(String requestPath, String method, String body, String timestamp) {
        
            String prehash = timestamp + method.toUpperCase() + requestPath + body;
            byte[] secretDecoded;
			try {
				secretDecoded = Base64.getDecoder().decode(secretKey.getBytes("UTF-8"));
				SecretKeySpec keyspec = new SecretKeySpec(secretDecoded, "HmacSHA256");
				Mac sha256;
				sha256 = (Mac) GdaxConstants.SHARED_MAC.clone();
				sha256.init(keyspec);
				return Base64.getEncoder().encodeToString(sha256.doFinal(prehash.getBytes()));
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("CloneNotSupportedException ==> Error with encoder");
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("InvalidKeyException ==> Error with encoder");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				throw new RuntimeException("UnsupportedEncodingException ==> Error with encoder");
			}
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
