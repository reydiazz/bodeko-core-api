package com.reydiazz.bodeko.core.user.store.exception;

public class StoreSubdomainAlreadyExistsException extends RuntimeException {
    public StoreSubdomainAlreadyExistsException(String subdomain) {
        super("Subdomain already exists: " + subdomain);
    }
}
