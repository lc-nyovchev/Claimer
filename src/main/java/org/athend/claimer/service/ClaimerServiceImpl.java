
package org.athend.claimer.service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
public class ClaimerServiceImpl implements ClaimerService {
	
	private final String INVITE_URL = "https://account.oneplus.net/invite/claim/";

	@Override
	public boolean claimInvite(String inviteCode) {
		Connection connect = Jsoup.connect(INVITE_URL + inviteCode);
		try {
			Document document = connect.get();
			if ( document.getElementsContainingOwnText("An error occurred").isEmpty() ){
				return true;
			}
		} catch (IOException ex) {
			Logger.getLogger(ClaimerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

}
