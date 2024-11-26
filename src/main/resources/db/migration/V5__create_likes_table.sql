DROP TABLE IF EXISTS likes;

CREATE TABLE likes (
  id bigserial PRIMARY KEY,
  post_id BIGINT NOT NULL,
    CONSTRAINT fk_post
      FOREIGN KEY (post_id)
      REFERENCES posts(id)
      ON DELETE CASCADE,
  user_id INT NOT NULL,
    CONSTRAINT fk_user
      FOREIGN KEY (user_id)
      REFERENCES users(id)
      ON DELETE CASCADE
);
