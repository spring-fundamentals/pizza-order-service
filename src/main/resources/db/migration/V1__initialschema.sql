CREATE TABLE pizza_menu_item
(
  id    VARCHAR(255) PRIMARY KEY,
  name  VARCHAR(255) NULL DEFAULT NULL,
  price DOUBLE       NULL DEFAULT NULL
);

CREATE TABLE pizza_order
(
  id BINARY(16) PRIMARY KEY
);

CREATE TABLE pizza_order_item
(
  id       BINARY(16) PRIMARY KEY,
  name     VARCHAR(255) NULL DEFAULT NULL,
  quantity INT          NULL DEFAULT NULL,
  pizza_order_id BINARY(16),
    CONSTRAINT fk_pizza_order
    FOREIGN KEY (pizza_order_id) REFERENCES pizza_order (id)
);
