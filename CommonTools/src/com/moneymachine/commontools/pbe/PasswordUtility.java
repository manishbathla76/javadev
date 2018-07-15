package com.moneymachine.commontools.pbe;

public class PasswordUtility {
	public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
 
		EncryptDecrypt d = new EncryptDecrypt();
             
        System.out.println("Encrypted string:" + d.encrypt("PasswordTest#123"));           
        String encryptedText = d.encrypt("PasswordTest#123");
        System.out.println("Decrypted string:" + d.decrypt(encryptedText));         
 
    }
}
