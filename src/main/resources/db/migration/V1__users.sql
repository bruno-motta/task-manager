CREATE TABLE users(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(155) NOT NULL,
    email VARCHAR(155) NOT NULL UNIQUE,
    password VARCHAR(155) NOT NULL,
    role VARCHAR(50) NOT NULL,
    create_at TIMESTAMP NOT NULL
)