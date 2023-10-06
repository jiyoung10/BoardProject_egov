package egovframework.example.sample.service.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UserVO implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String USER_ID;
	private String USER_NAME;
	private String USER_PASSWORD;
	private String USER_AUTHORITY;
	private int USER_ENABLED;
	
	
	// getter & setter

	
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String USER_NAME) {
		this.USER_NAME = USER_NAME;
	}
	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}
	public void setUSER_PASSWORD(String USER_PASSWORD) {
		this.USER_PASSWORD = USER_PASSWORD;
	}
	public String getUSER_AUTHORITY() {
		return USER_AUTHORITY;
	}
	public void setUSER_AUTHORITY(String USER_AUTHORITY) {
		this.USER_AUTHORITY = USER_AUTHORITY;
	}
	public int getUSER_ENABLED() {
		return USER_ENABLED;
	}
	public void setUSER_ENABLED(int USER_ENABLED) {
		this.USER_ENABLED = USER_ENABLED;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(USER_AUTHORITY));
		
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return USER_PASSWORD;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return USER_ID;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}



}
