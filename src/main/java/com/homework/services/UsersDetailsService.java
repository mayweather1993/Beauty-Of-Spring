package com.homework.services;

import com.homework.dao.UserRepository;
import com.homework.models.AppUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UsersDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final GrantedAuthoritiesMapper grantedAuthoritiesMapper;

    @Override
    public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
        final AppUser user = userRepository.findByEmail(userName).orElseThrow(() -> new UsernameNotFoundException(userName));

        final List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name()));
        final Collection<? extends GrantedAuthority> grantedAuthorities = grantedAuthoritiesMapper.mapAuthorities(authorities);
        return new User(userName, user.getPassword(), grantedAuthorities);
    }
}
