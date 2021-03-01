package az.itcity.etaskify.testservice;

import az.itcity.etaskify.entity.Organization;
import az.itcity.etaskify.entity.User;
import az.itcity.etaskify.service.OrganizationService;
import az.itcity.etaskify.service.UserPrincipalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestOrganizationServiceImpl {

    @Autowired
    private OrganizationService organizationService;

    @MockBean
    private UserPrincipalService userPrincipalService;

    private List<User> users;
    private List<Organization> organizations;

    @BeforeEach
    public void setUp(){
        this.users = new  ArrayList<>();
        this.organizations = new ArrayList<>();

        Organization o1 = new Organization();
        o1.setId((long) 1);
        o1.setName("AAAMMC");
        o1.setAddress("MMMM NNNN aaaa 11");
        o1.setPhoneNumber("+994555555555");

        Organization o2 = new Organization();
        o2.setId((long) 2);
        o2.setName("BBBMMC");
        o2.setAddress("SSSSS NNNN aaaa 12");
        o2.setPhoneNumber("+994554444444");

        organizations.add(o1);
        organizations.add(o2);

        User u1 = new User();
        u1.setId((long) 1);
        u1.setName("Ali");
        u1.setSurname("Aliyev");
        u1.setEmail("alialiyev@mail.com");
        u1.setPassword("12345");
        u1.setOrganization(o1);

        User u2 = new User();
        u2.setId((long) 2);
        u2.setName("Vali");
        u2.setSurname("Valiyev");
        u2.setEmail("valivaliyev@mail.com");
        u2.setPassword("54321");
        u2.setOrganization(o1);

        users.add(u1);
        users.add(u2);
    }

    @Test
    public void testGetMyOrganization(){
        Mockito.when(userPrincipalService.getUser()).thenReturn(users.get(1));

        Organization organization = organizationService.getMyOrganization();

        assertEquals(users.get(1).getOrganization(), organization);

    }

}
