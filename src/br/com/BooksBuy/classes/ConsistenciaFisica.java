package br.com.BooksBuy.classes;

import java.util.InputMismatchException; 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsistenciaFisica { 
	public boolean validaCPF(String CPF) { 
		 
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") ||
			CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555") ||
			CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888") ||
			CPF.equals("99999999999") || CPF.length() != 11) { 
			
			return false; 
		}
		
		char dig10, dig11;
		
		int sm, i, r, num, peso;
		
		// "try" - protege o codigo para eventuais erros de conversao de tipo (int) 
		try { 
			// Calculo do 1o. Digito Verificador 
		
			sm = 0; peso = 10; 
			for (i = 0; i < 9; i++) { 
				// converte o i-esimo caractere do CPF em um numero: 
				// por exemplo, transforma o caractere '0' no inteiro 0 
				// (48 eh a posicao de '0' na tabela ASCII) 
				num = (int)(CPF.charAt(i) - 48); 
				sm = sm + (num * peso);
				peso = peso - 1; 
			} 
			
			r = 11 - (sm % 11); 
			
			if (r == 10 || r == 11) 
				dig10 = '0'; 
			else 
				dig10 = (char)(r + 48);
			
			// converte no respectivo caractere numerico 
			// Calculo do 2o. Digito Verificador 
			sm = 0; 
			peso = 11; 
			for(i=0; i<10; i++) { 
				num = (int)(CPF.charAt(i) - 48); 
				sm = sm + (num * peso); 
				peso = peso - 1; 
			} 
			
			r = 11 - (sm % 11); 
			if (r == 10 || r == 11) 
				dig11 = '0'; 
			else 
				dig11 = (char)(r + 48);
			// Verifica se os digitos calculados conferem com os digitos informados. 
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) 
				return true; 
			else 
				return false; 
			
		} catch (InputMismatchException erro) { 
			return false; 
		} 
	}
	
	public boolean validaEmail(String email){
		
		Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$"); 
	    Matcher m = p.matcher(email); 
	    
	    if (m.find())
	    	return true;
	    
	    return false;
	}
	
	
    public boolean ValidaCep(String cep){
        if (cep.length() == 8){
            cep = cep.substring(0, 5) + "-" + cep.substring(5, 3);
            
            
           // System.Text.RegularExpressions.Regex.IsMatch(cep, ("[0-9]{5}-[0-9]{3}"));
            
        }
        return false;
    }

}

/*

O c�lculo dos DVs � executado em duas etapas usando para isto o m�dulo de divis�o 11 (m�dulo de divis�o � a parte inteira do resultado de uma divis�o):
Para calcular o 1� d�gito verificador:
a) cada um dos nove primeiros n�meros do CPF � multiplicado por um peso que come�a de 10 e que vai sendo diminuido de 1 a cada passo, somando-se as parcelas calculadas:
 	sm = (5*10)+(4*9)+(6*8)+(4*7)+(7*6)+(1*5)+(4*4)+(2*3)+(9*2) = 249;
b) calcula-se o d�gito atrav�s da seguinte express�o:
 	11 - (sm % 11) = 11 - (249 % 11) = 11 - 7 = 4
obs. se o resto da divis�o (operador %) calculado for 10 ou 11, o d�gito verificador ser� 0; nos outros casos, o d�gito verificador � o pr�prio resto.

Para calcular o 2� d�gito verificador:
a) cada um dos dez primeiros n�meros do CPF, considerando-se aqui o primeiro DV, � multiplicado por um peso que come�a de 11 e que vai sendo diminuido de 1 a cada passo, somando-se as parcelas calculadas:
 	sm = (5*11)+(4*10)+(6*9)+(4*8)+(7*7)+(1*6)+(4*5)+(2*4)+(9*3)+(4*2) = 299;
b) calcula-se o d�gito atrav�s da seguinte express�o:
 	11 - (sm % 11) = 11 - (299 % 11) = 11 - 2 = 9
obs. se o resto da divis�o (operador %) calculado for 10 ou 11, o d�gito verificador ser� 0; nos outros casos, o d�gito verificador � o pr�prio resto.

Leia mais em: Validando o CPF em uma Aplica��o Java http://www.devmedia.com.br/validando-o-cpf-em-uma-aplicacao-java/22097#ixzz2zgQvONOt
 */
	
			

