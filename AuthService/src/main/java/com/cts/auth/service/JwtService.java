package com.cts.auth.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cts.auth.enums.UserRole;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	@Value("${jwt.secret}")
	private String secretKey;

	public String generateToken(String email, UserRole role) {
		
//		Map<String, Object> claims = new HashMap<>();
//		claims.put("roles", "ROLE_"+role);
		
		Map<String, Object> claims = new HashMap<>();
		claims.put("roles", role);
		
		return Jwts.builder()
				.claims(claims)
				.subject(email)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 1000*60*5))
				.signWith(getKey(), Jwts.SIG.HS256).compact();
	}

	private SecretKey getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	
}
