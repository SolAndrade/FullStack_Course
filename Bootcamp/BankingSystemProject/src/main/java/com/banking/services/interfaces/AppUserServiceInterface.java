package com.banking.services.interfaces;

import com.banking.dto.AccountHolderDTO;
import com.banking.dto.AdminDTO;
import com.banking.dto.ThirdPartyDTO;
import com.banking.models.users.AccountHolder;
import com.banking.models.users.Admin;
import com.banking.models.users.ThirdParty;
import com.banking.models.users.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface AppUserServiceInterface {
    Admin addAdmin(AdminDTO admin);
    AccountHolder addAccountHolder(AccountHolderDTO accountHolder);
    ThirdParty addThirdParty(ThirdPartyDTO thirdParty);
    List<User> showUsers(UserDetails userDetails);
}
