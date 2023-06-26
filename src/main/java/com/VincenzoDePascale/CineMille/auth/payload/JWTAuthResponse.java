package com.VincenzoDePascale.CineMille.auth.payload;



import java.util.Set;

import com.VincenzoDePascale.CineMille.auth.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JWTAuthResponse {
	private String username;
	private String email;
    private String accessToken;
    private String tokenType = "Bearer";
    private Set<Role> roles;
}
