CREATE TABLE users
(
    id                 UUID PRIMARY KEY,
    name               VARCHAR(255)        NOT NULL,
    email              VARCHAR(255) UNIQUE NOT NULL,
    password           VARCHAR(255)        NOT NULL,
    access             BOOLEAN                  DEFAULT TRUE,
    created_at         TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    subscription_limit TIMESTAMP WITH TIME ZONE
);

CREATE TABLE stores
(
    id        UUID PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    subdomain VARCHAR(255) UNIQUE,
    user_id   UUID         NOT NULL REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE categories
(
    id       UUID PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    store_id UUID         NOT NULL REFERENCES stores (id) ON DELETE CASCADE
);

CREATE TABLE products
(
    id          UUID PRIMARY KEY,
    name        VARCHAR(255)   NOT NULL,
    description TEXT,
    price       DECIMAL(10, 2) NOT NULL,
    stock       INTEGER        NOT NULL DEFAULT 0,
    image_url   TEXT,
    status      VARCHAR(50),
    store_id    UUID           NOT NULL REFERENCES stores (id) ON DELETE CASCADE,
    category_id UUID           NOT NULL REFERENCES categories (id)
);

CREATE TABLE orders
(
    id           UUID PRIMARY KEY,
    name         VARCHAR(255),
    client_email VARCHAR(255)   NOT NULL,
    client_name  VARCHAR(255)   NOT NULL,
    total        DECIMAL(10, 2) NOT NULL,
    status       VARCHAR(50)    NOT NULL,
    store_id     UUID           NOT NULL REFERENCES stores (id) ON DELETE CASCADE,
    created_at   TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE order_details
(
    id         UUID PRIMARY KEY,
    price      DECIMAL(10, 2) NOT NULL,
    quantity   INTEGER        NOT NULL,
    order_id   UUID           NOT NULL REFERENCES orders (id) ON DELETE CASCADE,
    product_id UUID           NOT NULL REFERENCES products (id)
);

CREATE TABLE payments
(
    id             UUID PRIMARY KEY,
    transaction_id VARCHAR(255)   NOT NULL,
    amount         DECIMAL(10, 2) NOT NULL,
    provider       VARCHAR(100),
    status         VARCHAR(50)    NOT NULL,
    order_id       UUID UNIQUE    NOT NULL REFERENCES orders (id) ON DELETE CASCADE,
    created_at     TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_stores_user_id ON stores (user_id);
CREATE INDEX idx_categories_store_id ON categories (store_id);
CREATE INDEX idx_products_store_id ON products (store_id);
CREATE INDEX idx_products_category_id ON products (category_id);
CREATE INDEX idx_orders_store_id ON orders (store_id);
CREATE INDEX idx_order_details_order_id ON order_details (order_id);
CREATE INDEX idx_order_details_product_id ON order_details (product_id);