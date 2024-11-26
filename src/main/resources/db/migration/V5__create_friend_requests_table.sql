DROP TABLE IF EXISTS friend_requests;

CREATE TABLE friend_requests (
    id bigserial PRIMARY KEY,
    sender_id bigserial NOT NULL,
    receiver_id bigserial NOT NULL,
    is_accepted BOOLEAN DEFAULT FALSE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT fk_sender FOREIGN KEY (sender_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_receiver FOREIGN KEY (receiver_id) REFERENCES users(id) ON DELETE CASCADE
);