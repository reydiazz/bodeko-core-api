package com.reydiazz.bodeko.core.user.core.service;

import com.reydiazz.bodeko.core.user.core.model.entity.User;
import com.reydiazz.bodeko.security.auth.web.request.RegisterCustomerRequest;
import com.reydiazz.bodeko.security.auth.web.request.RegisterOwnerRequest;

public interface UserService {

    User createCustomerEntity(RegisterCustomerRequest request);

    User createOwnerEntity(RegisterOwnerRequest request);

}
