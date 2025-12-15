-- V1: Create carts and cart_items tables for Postgres
CREATE DATABASE orderdb;

CREATE TABLE orders (
    id                  BIGSERIAL PRIMARY KEY,
   	user_id             VARCHAR(50) NOT NULL,
    status              VARCHAR(30) NOT NULL,
    total_amount        NUMERIC(12, 2) NOT NULL,
    currency            VARCHAR(3) NOT NULL DEFAULT 'INR',
    payment_status      VARCHAR(30) NOT NULL,
    payment_method      VARCHAR(30),
	cart_items			JSONB NOT NULL,
    created_at          TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX IF NOT EXISTS idx_cart_user ON orders(user_id);

