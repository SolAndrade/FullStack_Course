package com.banking.services;

import com.banking.dto.AccountHolderDTO;
import com.banking.dto.AdminDTO;
import com.banking.dto.ThirdPartyDTO;
import com.banking.repositories.*;
import com.banking.services.interfaces.AppUserServiceInterface;
import com.banking.models.Address;
import com.banking.models.users.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppUserService implements AppUserServiceInterface {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    ThirdPartyRepository thirdPartyRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Admin addAdmin(AdminDTO admin) {
        String username = admin.getUsername();
        String password = passwordEncoder.encode(admin.getPassword());
        String name = admin.getName();
        Admin newAdmin = adminRepository.save(new Admin(username, password, name));
        roleRepository.save(new Role("ADMIN", newAdmin));
        return newAdmin;
    }

    public AccountHolder addAccountHolder(AccountHolderDTO accountHolder) {
        String username = accountHolder.getUsername();
        String password = passwordEncoder.encode(accountHolder.getPassword());
        String name = accountHolder.getName();
        LocalDate dateOfBirth = accountHolder.getDateOfBirth();
        Address address = createAddress(accountHolder);
        Address mailingAddress = createMailingAddress(accountHolder);
        AccountHolder newAccountHolder = saveAccountHolder(username, password, name, dateOfBirth, address, mailingAddress);
        createClientRole(newAccountHolder);
        return newAccountHolder;
    }

    private Address createAddress(AccountHolderDTO accountHolder) {
        String streetAddress = accountHolder.getStreetAddress();
        String city = accountHolder.getCity();
        String postalCode = accountHolder.getPostalCode();
        String provinceState = accountHolder.getProvinceState();
        String country = accountHolder.getCountry();
        return new Address(streetAddress, city, postalCode, provinceState, country);
    }

    private Address createMailingAddress(AccountHolderDTO accountHolder) {
        if (accountHolder.getMailStreetAddress() != null && !accountHolder.getMailStreetAddress().isEmpty()) {
            String mailStreetAddress = accountHolder.getMailStreetAddress();
            String mailCity = accountHolder.getMailCity();
            String mailPostalCode = accountHolder.getMailPostalCode();
            String mailProvinceState = accountHolder.getMailProvinceState();
            String mailCountry = accountHolder.getMailCountry();
            return new Address(mailStreetAddress, mailCity, mailPostalCode, mailProvinceState, mailCountry);
        }
        return null;
    }

    private AccountHolder saveAccountHolder(String username, String password, String name, LocalDate dateOfBirth, Address address, Address mailingAddress) {
        AccountHolder newAccountHolder = new AccountHolder(username, password, name, dateOfBirth, address, mailingAddress);
        return accountHolderRepository.save(newAccountHolder);
    }

    private void createClientRole(AccountHolder accountHolder) {
        Role clientRole = new Role("CLIENT", accountHolder);
        roleRepository.save(clientRole);
    }

    public ThirdParty addThirdParty(ThirdPartyDTO thirdParty) {
        String name = thirdParty.getName();
        String hashedKey = thirdParty.getHashedKey();
        ThirdParty newThirdParty = thirdPartyRepository.save(new ThirdParty(name, hashedKey));
        roleRepository.save(new Role("THIRD_PARTY", newThirdParty));
        return newThirdParty;
    }

    @Override
    public List<User> showUsers(UserDetails userDetails) {
        return userRepository.findAll();
    }
}
