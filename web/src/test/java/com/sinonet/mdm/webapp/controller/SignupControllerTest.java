package com.sinonet.mdm.webapp.controller;

import com.sinonet.mdm.Constants;
import com.sinonet.mdm.model.Address;
import com.sinonet.mdm.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.subethamail.wiser.Wiser;

import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;

public class SignupControllerTest extends BaseControllerTestCase {
    @Autowired
    private SignupController c = null;

    @Test
    public void testDisplayForm() throws Exception {
        User user = c.showForm();
        assertNotNull(user);
    }

    @Test
    public void testSignupUser() throws Exception {
        MockHttpServletRequest request = newPost("/signup.html");

        Address address = new Address();
        address.setCity("Denver");
        address.setProvince("Colorado");
        address.setCountry("USA");
        address.setPostalCode("80210");

        User user = new User();
        user.setAddress(address);

        user.setUsername("self-registered");
        user.setPassword("Password1");
        user.setConfirmPassword("Password1");
        user.setFirstName("First");
        user.setLastName("Last");
        user.setEmail("self-registered@raibledesigns.com");
        user.setWebsite("http://raibledesigns.com");
        user.setPasswordHint("Password is one with you.");

        HttpServletResponse response = new MockHttpServletResponse();

        // start SMTP Server
        Wiser wiser = new Wiser();
        wiser.setPort(getSmtpPort());
        wiser.start();

        BindingResult errors = new DataBinder(user).getBindingResult();
        c.onSubmit(user, errors, request, response);
        assertFalse("errors returned in model", errors.hasErrors());

        // verify an account information e-mail was sent
        wiser.stop();
        assertTrue(wiser.getMessages().size() == 1);

        // verify that success messages are in the request
        assertNotNull(request.getSession().getAttribute("successMessages"));
        assertNotNull(request.getSession().getAttribute(Constants.REGISTERED));

        SecurityContextHolder.getContext().setAuthentication(null);
    }
}
