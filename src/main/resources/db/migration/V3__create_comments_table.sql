DROP TABLE IF EXISTS comments;

CREATE TABLE comments (
  id bigserial PRIMARY KEY,
  content TEXT NOT NULL,
  user_id INT,
  CONSTRAINT fk_user
    FOREIGN KEY (user_id)
    REFERENCES users(id)
    ON DELETE CASCADE
);
