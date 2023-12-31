package org.warehouse.controllers.users;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.warehouse.configs.models.mapper.UserMapper;
import org.warehouse.models.user.User;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserInfoService implements UserDetailsService {
	private final UserMapper userMapper;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMapper.getUserById(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}

		List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getUserType()));

		return UserInfo.builder()
				.userId(user.getUserId())
				.userPw(user.getUserPw())
				.userNm(user.getUserNm())
				.userType(user.getUserType())
				.clntCd(user.getClntCd())
				.custCtrCd(user.getCustCtrCd())
				.custCd(user.getCustCd())
				.position(user.getPosition())
				.tel(user.getTel())
				.email(user.getEmail())
				.authorities(authorities)
				.build();
	}
}