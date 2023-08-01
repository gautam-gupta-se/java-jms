package com.springjms.javajms.service.serviceImpl;

import com.springjms.javajms.entity.CustomerEntity;
import com.springjms.javajms.repository.CustomerRepository;
import com.springjms.javajms.service.CustomerSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerSecurityServiceImpl implements CustomerSecurityService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password = null;
        List<GrantedAuthority> authorities = null;

        List<CustomerEntity> customer = customerRepository.findByEmail(username);
        if (customer.size() == 0) {
            System.out.println("user not found");
            throw new UsernameNotFoundException("Provide User not found user : " + username);
        } else{
            userName = customer.get(0).getEmail();
            password = customer.get(0).getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
        }
        System.out.println(username+"   \n"+userName+"   \n"+password+"  \n"+authorities);

        return new User(username,password,authorities);
    }
}

