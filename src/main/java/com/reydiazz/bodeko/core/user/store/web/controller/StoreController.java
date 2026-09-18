package com.reydiazz.bodeko.core.user.store.web.controller;

import com.reydiazz.bodeko.core.user.store.service.StoreService;
import com.reydiazz.bodeko.core.user.store.web.request.CreateStoreRequest;
import com.reydiazz.bodeko.core.user.store.web.request.UpdateStoreRequest;
import com.reydiazz.bodeko.core.user.store.web.response.StoreResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/{id}")
    public StoreResponse getById(@PathVariable UUID id) {
        return storeService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StoreResponse create(
            @Valid @RequestBody CreateStoreRequest request
    ) {
        return storeService.create(request);
    }

    @PutMapping("/{id}")
    public StoreResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateStoreRequest request
    ) {
        return storeService.update(id, request);
    }
}

