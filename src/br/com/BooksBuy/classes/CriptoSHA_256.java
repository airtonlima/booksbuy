package br.com.BooksBuy.classes;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptoSHA_256 {

		public String criptString(String senhaUsuario) throws IOException{
			
			MessageDigest algorithm = null;
			
			try {
				
				algorithm = MessageDigest.getInstance("SHA-256");
				
			} catch (NoSuchAlgorithmException e) {
				
				e.printStackTrace();
			}
			
			byte messageDigest[] = algorithm.digest(senhaUsuario.getBytes("UTF-8"));
			 
			StringBuilder hexString = new StringBuilder();

			for (byte b : messageDigest) {
				
			  hexString.append(String.format("%02X", 0xFF & b));
			}
			
			String senhaCriptografada = hexString.toString();
			
			return senhaCriptografada;	
		}
}
