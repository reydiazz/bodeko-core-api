package com.reydiazz.bodeko.core.user.store.component;

import com.reydiazz.bodeko.core.user.store.model.entity.Store;
import com.reydiazz.bodeko.core.user.store.web.response.StoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreMapper {

    public StoreResponse toResponse(Store store){
        return  new StoreResponse(
                store.getId(),
                store.getName(),
                store.getSubdomain()
        );
    }
}
