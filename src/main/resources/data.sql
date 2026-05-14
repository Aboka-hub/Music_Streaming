-- 1. Genre
INSERT INTO genre (name) VALUES ('Pop'), ('Rock'), ('Jazz'), ('Hip-Hop'), ('Classical')
ON CONFLICT DO NOTHING;

-- 2. Users
INSERT INTO users (username, email, password, role, created_at) VALUES
                                                                    ('admin', 'admin@music.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'ADMIN', NOW()),
                                                                    ('john_doe', 'john@music.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'USER', NOW()),
                                                                    ('artist_bob', 'bob@music.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'ARTIST', NOW()),
                                                                    ('artist_alice', 'alice@music.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'ARTIST', NOW())
ON CONFLICT DO NOTHING;

-- 3. Artist
INSERT INTO artist (stage_name, bio, user_id) VALUES
                                                  ('Bob The Artist', 'Famous pop singer from Kazakhstan', 10),
                                                  ('Alice Wonder', 'Jazz and soul vocalist', 12)
ON CONFLICT DO NOTHING;

-- 4. Album
INSERT INTO album (title, release_date, artist_id, genre_id) VALUES
                                                                 ('First Steps', '2024-01-15', 5, 1),
                                                                 ('Jazz Nights', '2024-03-20', 6, 3),
                                                                 ('Rock Vibes', '2024-05-10', 5, 2)
ON CONFLICT DO NOTHING;

-- 5. Track
INSERT INTO track (title, duration, file_path, album_id) VALUES
                                                             ('Hello World', 180, null, 4),
                                                             ('Goodbye Summer', 210, null, 4),
                                                             ('Midnight Jazz', 240, null, 5),
                                                             ('Blue Moon', 195, null, 5),
                                                             ('Rock It', 220, null, 6)
ON CONFLICT DO NOTHING;

-- 6. Playlist
INSERT INTO playlist (name, user_id, created_date) VALUES
                                                       ('My Favorites', 7, NOW()),
                                                       ('Chill Vibes', 7, NOW()),
                                                       ('Morning Mix', 1, NOW())
ON CONFLICT DO NOTHING;

-- Сначала добавь недостающих users
INSERT INTO users (username, email, password, role, created_at) VALUES
                                                                    ('artist_alice', 'alice@music.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'ARTIST', NOW())
ON CONFLICT DO NOTHING;

