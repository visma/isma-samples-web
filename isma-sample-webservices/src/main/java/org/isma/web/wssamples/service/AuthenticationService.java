package org.isma.web.wssamples.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface AuthenticationService {

    @WebMethod
    public Boolean getAccess(
            @WebParam(name="login") String login,
            @WebParam(name="password") String password);
}