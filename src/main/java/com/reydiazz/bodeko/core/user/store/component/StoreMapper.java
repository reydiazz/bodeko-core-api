package com.reydiazz.bodeko.core.user.store.component;

import com.reydiazz.bodeko.core.user.store.model.entity.Store;
import com.reydiazz.bodeko.core.user.store.web.response.StoreResponse;

public class StoreMapper {

    public StoreResponse toResponse(Store store){
        return  new StoreResponse(
                store.getId(),
                store.getName(),
                store.getSubdomain()
        );
    }
}
