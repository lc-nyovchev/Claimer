
package org.athend.claimer.service;

import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class InviteGeneratorServiceImpl implements InviteGeneratorService {
	
	private char[] symbols;
	private final Random random = new Random();
	
	public InviteGeneratorServiceImpl(){
		StringBuilder tmp = new StringBuilder();
		for (char ch = '0'; ch <= '9'; ++ch) {
			tmp.append(ch);
		}
		for (char ch = 'A'; ch <= 'Z'; ++ch) {
			tmp.append(ch);
		}
		 symbols = tmp.toString().toCharArray();
	}
	
	@Override
	public String getRandomInvite() {
		StringBuilder sb = new StringBuilder();
		for ( int i = 0; i < 16; i ++ ){
			sb.append(symbols[random.nextInt(32)]);
			if ( i == 3 || i == 7 || i == 11 ){
				sb.append("-");
			}
		}
		return sb.toString();
	}

}
