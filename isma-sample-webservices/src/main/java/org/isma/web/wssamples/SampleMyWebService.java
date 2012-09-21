package org.isma.web.wssamples;

import org.isma.web.wssamples.service.AuthenticationService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SampleMyWebService {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-cxf-services-client.xml");
        AuthenticationService service = (AuthenticationService) context.getBean("authenticationClient");
        Boolean access = service.getAccess("monsieur", "garrison");
        Boolean access2 = service.getAccess("tarzan", "jane");
        System.out.println(access);
        System.out.println(access2);
    }
}
