package com.example.devbackend.security;

import com.example.devbackend.config.AppProperties;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.security.SignatureException;
import java.util.Date;

@Service
public class TokenProvider {

	private static final Logger logger=LoggerFactory.getLogger(TokenProvider.class);


	private AppProperties appProperties;
	
	
	public TokenProvider(AppProperties appProperties) {
        this.appProperties = appProperties;
    }
	
	public String createToken(Authentication authentication) {
		UserPrincipal userPrincipal=(UserPrincipal) authentication.getPrincipal();
		
		Date now=new Date();
		Date expiryDate=new Date(now.getTime()+appProperties.getAuth().getTokenExpirationMsec());
		
		return Jwts.builder()
				.setSubject(userPrincipal.getId())
				.setIssuedAt(new Date())
				.setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, appProperties.getAuth().getTokenSecret())
				.compact();
	}
	
	public String getUserIdFromToken(String token) {
		Claims claims=Jwts.parser()
				.setSigningKey(appProperties.getAuth().getTokenSecret())
				.parseClaimsJws(token)
				.getBody();
		
		return claims.getSubject();
	}
	
	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(appProperties.getAuth().getTokenSecret()).parse(authToken);
			return true;
		} catch (MalformedJwtException ex) {
			logger.error("Invalid Jwt token");
		} catch (ExpiredJwtException ex) {
			logger.error("Expired Jwt token");
		} catch (UnsupportedJwtException ex) {
			logger.error("Unsupported Jwt token");
		} catch (IllegalArgumentException ex) {
			logger.error("Jwt claims string is empty");
		}
		return false;
	}
}
