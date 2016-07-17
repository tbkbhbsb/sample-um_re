/* load the records. */

-- UserTable
INSERT INTO UserTable(userId, name, birthday, address, tel, password, state, lastUpdate) VALUES('0001', '山本尚美', '1965/06/30', '高知県', '0882733366', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'ACTV', '2016/07/17 0:12');
INSERT INTO UserTable(userId, name, birthday, address, tel, password, state, lastUpdate) VALUES('0002', '合田智也', '1972/06/15', '神奈川県', '0467321493', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'INIT', '2016/07/17 0:13');
INSERT INTO UserTable(userId, name, birthday, address, tel, password, state, lastUpdate) VALUES('0003', '砂川匠', '1979/02/05', '石川県', '076072914', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'INIT', '2016/07/17 0:14');
INSERT INTO UserTable(userId, name, birthday, address, tel, password, state, lastUpdate) VALUES('0004', '村上夏希', '1975/09/09', '福岡県', '0931839505', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'INIT', '2016/07/17 0:15');
INSERT INTO UserTable(userId, name, birthday, address, tel, password, state, lastUpdate) VALUES('0005', '白川雅信', '1960/01/22', '広島県', '0826428935', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'INIT', '2016/07/17 0:16');
INSERT INTO UserTable(userId, name, birthday, address, tel, password, state, lastUpdate) VALUES('0006', '佐竹梅吉', '1966/05/20', '高知県', '0883421842', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'INIT', '2016/07/17 0:17');
INSERT INTO UserTable(userId, name, birthday, address, tel, password, state, lastUpdate) VALUES('0007', '山下努', '1969/09/16', '栃木県', '0289596595', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'INIT', '2016/07/17 0:18');
INSERT INTO UserTable(userId, name, birthday, address, tel, password, state, lastUpdate) VALUES('0008', '下田裕美子', '1968/10/12', '愛媛県', '0898441472', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'INIT', '2016/07/17 0:19');
INSERT INTO UserTable(userId, name, birthday, address, tel, password, state, lastUpdate) VALUES('0009', '会田未来', '1965/06/10', '奈良県', '0742907263', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'INIT', '2016/07/17 0:20');
INSERT INTO UserTable(userId, name, birthday, address, tel, password, state, lastUpdate) VALUES('0010', '南部幸司', '1985/12/25', '山口県', '0832007942', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'INIT', '2016/07/17 0:21');

-- RoleTable
INSERT INTO RoleTable(userId, role) VALUES('0001', 'ADMIN');
INSERT INTO RoleTable(userId, role) VALUES('0002', 'USER');
INSERT INTO RoleTable(userId, role) VALUES('0003', 'USER');
INSERT INTO RoleTable(userId, role) VALUES('0004', 'USER');
INSERT INTO RoleTable(userId, role) VALUES('0005', 'USER');
INSERT INTO RoleTable(userId, role) VALUES('0006', 'USER');
INSERT INTO RoleTable(userId, role) VALUES('0007', 'USER');
INSERT INTO RoleTable(userId, role) VALUES('0008', 'USER');
INSERT INTO RoleTable(userId, role) VALUES('0009', 'USER');
INSERT INTO RoleTable(userId, role) VALUES('0010', 'USER');

commit;