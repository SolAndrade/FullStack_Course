package com.banking.controllers;

import com.banking.dto.AccountHolderDTO;
import com.banking.dto.AdminDTO;
import com.banking.models.users.AccountHolder;
import com.banking.models.users.Admin;
import com.banking.models.users.User;
import com.banking.services.interfaces.AppServiceInterface;
import com.banking.services.interfaces.AppUserServiceInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Arrays;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppServiceInterface appServiceInterface;

    @MockBean
    private AppUserServiceInterface appUserServiceInterface;

    @Test
    @WithMockUser
    public void showUsers_ShouldReturnListOfUsers() throws Exception {
        when(appUserServiceInterface.showUsers(any(UserDetails.class)))
                .thenReturn(Arrays.asList(new User(), new User()));

        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2));
    }

    @Test
    public void addAdmin_ShouldReturnCreatedAdmin() throws Exception {
        AdminDTO adminDTO = new AdminDTO();
        when(appUserServiceInterface.addAdmin(adminDTO)).thenReturn(new Admin());

        mockMvc.perform(MockMvcRequestBuilders.post("/users/admin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void addAccountHolder_ShouldReturnCreatedAccountHolder() throws Exception {
        AccountHolderDTO accountHolderDTO = new AccountHolderDTO();
        when(appUserServiceInterface.addAccountHolder(accountHolderDTO)).thenReturn(new AccountHolder());

        mockMvc.perform(MockMvcRequestBuilders.post("/users/client")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    // Add more tests for the remaining methods...

}
