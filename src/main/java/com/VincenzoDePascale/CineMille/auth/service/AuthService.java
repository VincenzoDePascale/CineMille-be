package com.VincenzoDePascale.CineMille.auth.service;

import com.VincenzoDePascale.CineMille.auth.payload.LoginDto;
import com.VincenzoDePascale.CineMille.auth.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
