package tn.esprit.twin1.brogrammers.eventify.Eventify.util;

import java.security.Key;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class AuthJWT {

	public static String SignJWT() {
		Key key = MacProvider.generateKey();

		String compactJws = Jwts.builder().setSubject("Joe").signWith(SignatureAlgorithm.HS512, key).compact();
		return compactJws;
	}

}
