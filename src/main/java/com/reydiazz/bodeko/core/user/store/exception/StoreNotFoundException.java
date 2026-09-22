package com.reydiazz.bodeko.core.user.store.exception;

import java.util.UUID;

public class StoreNotFoundException  extends  RuntimeException{

    public StoreNotFoundException(UUID id){
        super("Store not found with id: " + id);
    }
}
