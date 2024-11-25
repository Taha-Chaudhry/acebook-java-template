DROP TABLE IF EXISTS comments;

CREATE TABLE comments (
  id bigserial PRIMARY KEY,
  content TEXT NOT NULL,
  post_id INT,
    CONSTRAINT fk_post
      FOREIGN KEY (post_id)
      REFERENCES posts(id)
      ON DELETE CASCADE,
  user_id INT,
  CONSTRAINT fk_user
    FOREIGN KEY (user_id)
    REFERENCES users(id)
    ON DELETE CASCADE
);
