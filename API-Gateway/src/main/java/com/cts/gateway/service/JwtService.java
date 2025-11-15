package com.cts.gateway.service;

import java.util.Date;

import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {
	
	@Value("${jwt.secret}")
	private String secretKey;

	private SecretKey getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	
	private Claims extractAllClaims(String token) { 
		return Jwts.parser()
				.verifyWith(getKey())
				.build()
				.parseSignedClaims(token)
				.getPayload();
		}
	
	private <T> T extractClaim(String token, Function<Claims, T> claimResolver) { 
		final Claims claims = extractAllClaims(token); 
		return claimResolver.apply(claims); 
		}

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	public String extractRole(String token) {
		return extractAllClaims(token).get("roles", String.class);
	}

	public boolean validate(String token) {
		//final String userName = extractUsername(token); 
		return !isTokenExpired(token); 
	}

	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	private Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	
}
