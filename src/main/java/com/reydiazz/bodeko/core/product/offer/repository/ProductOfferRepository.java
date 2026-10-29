package com.reydiazz.bodeko.core.product.offer.repository;

import com.reydiazz.bodeko.core.product.offer.model.entity.ProductOffer;
import com.reydiazz.bodeko.core.product.offer.model.entity.ProductOfferId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductOfferRepository extends JpaRepository<ProductOffer, ProductOfferId> {
}
