package com.cts.auth.service;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.cts.auth.enums.UserRole;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	@Value("${jwt.secret}")
	private String secretKey;
	
	
//	public JwtService() {
//		secretKey = generateSecretKey();
//	}
//	
//	public String generateSecretKey() { 
//		try { 
//			KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256"); 
//			SecretKey secretKey = keyGen.generateKey(); 
//			System.out.println("Secret Key : " + secretKey.toString()); 
//			return Base64.getEncoder().encodeToString(secretKey.getEncoded()); 
//		} catch (NoSuchAlgorithmException e) { 
//			throw new RuntimeException("Error generating secret key", e); 
//		}
//	}

	public String generateToken(String email, UserRole role) {
		
		Map<String, Object> claims = new HashMap<>();
		claims.put("roles", "ROLE_"+role);
		
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
	
	
	
	
//	private Claims extractAllClaims(String token) { 
//		return Jwts.parser()
//				.verifyWith(getKey())
//				.build()
//				.parseSignedClaims(token)
//				.getPayload();
//		}
//	
//	private <T> T extractClaim(String token, Function<Claims, T> claimResolver) { 
//		final Claims claims = extractAllClaims(token); 
//		return claimResolver.apply(claims); 
//		}
//
//	public String extractUsername(String token) {
//		return extractClaim(token, Claims::getSubject);
//	}
//
//	public boolean validate(String token, UserDetails userDetails) {
//		final String userName = extractUsername(token); 
//		return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token)); 
//	}
//
//	private boolean isTokenExpired(String token) {
//		return extractExpiration(token).before(new Date());
//	}
//
//	private Date extractExpiration(String token) {
//		return extractClaim(token, Claims::getExpiration);
//	}

	
}
