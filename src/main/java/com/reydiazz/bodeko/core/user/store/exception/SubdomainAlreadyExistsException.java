package com.reydiazz.bodeko.core.user.store.exception;

public class SubdomainAlreadyExistsException  extends RuntimeException {
    public SubdomainAlreadyExistsException(String subdomain) {
        super("Subdomain already exists: " + subdomain);
    }
}
