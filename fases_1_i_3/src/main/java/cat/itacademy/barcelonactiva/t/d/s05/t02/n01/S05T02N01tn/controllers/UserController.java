package cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.controllers;


import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.dto.UserDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
    @PostMapping("user")
	public UserDto login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		/*
		 *  username and password is no authenticated, use any value.
		 */
		String token = getJWTToken(username);
		UserDto user = new UserDto();
		user.setUser(username);
		user.setToken(token);		
		return user;
		
	}

	private String getJWTToken(String username) {
		String secretKey = "holaAtots!";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROL_USER");
		
		String token = Jwts
				.builder()
				.setId("dtn_jwt")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
		/*
		 * 
		 *  Exemple payload:
		 * 
		 */
		/*
		 * {
				"jti": "dtn_jwt",
				"sub": "test",
				"authorities": [
					"ROL_USER"
				],
				"iat": 1665254076,
				"exp": 1665254676
			}
			*  if token is expired:
		 	{
				"timestamp": "2022-10-08T19:52:29.449+00:00",
				"status": 403,
				"error": "Forbidden",
				"message": "JWT expired at 2022-10-08T20:44:36Z. Current time: 2022-10-08T21:52:29Z, a difference of 4073441 milliseconds.  Allowed clock skew: 0 milliseconds.",
				"path": "/players/ranking"
			}
		 */
	}
}
