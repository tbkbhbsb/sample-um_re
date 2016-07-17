/* define the schemas. */
CREATE TABLE UserTable (
  userId nchar(4),
  name nchar(255),
  birthday nchar(255),
  address nchar(255),
  tel nchar(255),
  password nchar(255),
  state nchar(255),
  lastUpdate nchar(255)
);

CREATE TABLE RoleTable (
  userId nchar(4),
  role nchar(255)
);