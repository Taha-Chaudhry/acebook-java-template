DROP TABLE IF EXISTS friends;

CREATE TABLE friends (
    id bigserial PRIMARY KEY,
    user_id1 bigserial NOT NULL,
    user_id2 bigserial NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT fk_user1 FOREIGN KEY (user_id1) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_user2 FOREIGN KEY (user_id2) REFERENCES users(id) ON DELETE CASCADE
);
