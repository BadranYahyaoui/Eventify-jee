package tn.esprit.twin1.brogrammers.eventify.Eventify.util;

import java.security.Key;
import java.util.HashMap;

import com.auth0.jwt.JWTSigner;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class AuthJWT {

	public static String SignJWT() {
		final String issuer = "https://mydomain.com/";
		final String secret = "123456";

		final long iat = System.currentTimeMillis() / 1000L; // issued at claim 
		final long exp = iat + 60L; // expires claim. In this case the token expires in 60 seconds

		final JWTSigner signer = new JWTSigner(secret);
		final HashMap<String, Object> claims = new HashMap<String, Object>();
		claims.put("iss", issuer);
		claims.put("exp", exp);
		claims.put("iat", iat);

		final String jwt = signer.sign(claims);
		return jwt;
	}

}
