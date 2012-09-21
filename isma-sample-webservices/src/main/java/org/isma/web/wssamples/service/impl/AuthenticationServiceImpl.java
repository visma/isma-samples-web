package org.isma.web.wssamples.service.impl;

import org.isma.web.wssamples.service.AuthenticationService;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(
        endpointInterface = "org.isma.web.wssamples.service.AuthenticationService",
        serviceName = "authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public Boolean getAccess(@WebParam(name = "login") String login, @WebParam(name = "password") String password) {
        if (login.equals("tarzan") && password.equals("jane")) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
