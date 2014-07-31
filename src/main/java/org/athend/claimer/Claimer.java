
package org.athend.claimer;

import org.athend.claimer.service.ClaimerService;
import org.athend.claimer.service.ClaimerServiceImpl;
import org.athend.claimer.service.InviteGeneratorService;
import org.athend.claimer.service.InviteGeneratorServiceImpl;

public class Claimer {
	public static void main(String[]args){
		ClaimerService service = new ClaimerServiceImpl();
		InviteGeneratorService inviteGeneratorService = new InviteGeneratorServiceImpl();
		long i;
		long currentTime = System.currentTimeMillis();
		for ( i = 0; i < Long.MAX_VALUE; i ++ ){
			String randomInvite = inviteGeneratorService.getRandomInvite();
			boolean claimInvite = service.claimInvite(randomInvite);
			if ( claimInvite ){
				System.out.println(randomInvite);
				System.exit(1);
			}
			if ( i % 1000 == 0 ){
				long newCurrentTime = System.currentTimeMillis();
				System.out.println(i + " attempts so far, took " +  ((newCurrentTime - currentTime) / 1000) + " seconds");
				currentTime = newCurrentTime;
			}
		}
	}
}
