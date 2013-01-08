# ---------------------------------------------------------------------- #
# Script generated with: DeZign for Databases v6.3.3                     #
# Target DBMS:           MySQL 5                                         #
# Project file:          rbac_nist_.dez                                  #
# Project name:          nist rbac model                                 #
# Author:                m.e. post                                       #
# Script type:           Database creation script                        #
# Created on:            2011-06-11 21:01                                #
# ---------------------------------------------------------------------- #


# ---------------------------------------------------------------------- #
# Tables                                                                 #
# ---------------------------------------------------------------------- #

# ---------------------------------------------------------------------- #
# Add table "users"                                                      #
# ---------------------------------------------------------------------- #

CREATE TABLE `users` (
    `user_id` INTEGER NOT NULL,
    `username` VARCHAR(40) NOT NULL,
    `password` VARCHAR(64) NOT NULL,
    `nonce` DATETIME NOT NULL DEFAULT '0000-00-00 00:00:00',
    `first_name` VARCHAR(50) NOT NULL,
    `family_name` VARCHAR(100) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`user_id`)
);

CREATE INDEX `IDX_users_1` ON `users` (`username`);

# ---------------------------------------------------------------------- #
# Add table "roles"                                                      #
# ---------------------------------------------------------------------- #

CREATE TABLE `roles` (
    `role_id` INTEGER NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`role_id`)
);

CREATE INDEX `IDX_roles_1` ON `roles` (`name`);

# ---------------------------------------------------------------------- #
# Add table "user_role"                                                  #
# ---------------------------------------------------------------------- #

CREATE TABLE `user_role` (
    `user_id` INTEGER NOT NULL,
    `role_id` INTEGER NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`)
);

CREATE INDEX `IDX_user_role_1` ON `user_role` (`user_id`);

CREATE INDEX `IDX_user_role_2` ON `user_role` (`role_id`);

# ---------------------------------------------------------------------- #
# Add table "sessions"                                                   #
# ---------------------------------------------------------------------- #

CREATE TABLE `sessions` (
    `session_id` INTEGER NOT NULL,
    `user_id` INTEGER NOT NULL,
    `name` VARCHAR(64) NOT NULL,
    `created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`session_id`)
);

# ---------------------------------------------------------------------- #
# Add table "operations"                                                 #
# ---------------------------------------------------------------------- #

CREATE TABLE `operations` (
    `operation_id` INTEGER NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `_create` INTEGER DEFAULT NULL,
    `_read` INTEGER DEFAULT NULL,
    `_update` INTEGER DEFAULT NULL,
    `_delete` INTEGER DEFAULT NULL,
    `locked` INTEGER NOT NULL DEFAULT 0,
    PRIMARY KEY (`operation_id`)
);

# ---------------------------------------------------------------------- #
# Add table "objects"                                                    #
# ---------------------------------------------------------------------- #

CREATE TABLE `objects` (
    `object_id` INTEGER NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `locked` INTEGER NOT NULL DEFAULT 0,
    PRIMARY KEY (`object_id`)
);

# ---------------------------------------------------------------------- #
# Add table "permissions"                                                #
# ---------------------------------------------------------------------- #

CREATE TABLE `permissions` (
    `permission_id` INTEGER NOT NULL,
    `object_id` INTEGER NOT NULL,
    `operation_id` INTEGER NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`permission_id`, `object_id`, `operation_id`)
);

CREATE INDEX `IDX_permission_1` ON `permissions` (`object_id`);

CREATE INDEX `IDX_permission_2` ON `permissions` (`operation_id`);

# ---------------------------------------------------------------------- #
# Add table "role_permission"                                            #
# ---------------------------------------------------------------------- #

CREATE TABLE `role_permission` (
    `role_id` INTEGER NOT NULL,
    `permission_id` INTEGER NOT NULL,
    PRIMARY KEY (`role_id`, `permission_id`)
);

CREATE INDEX `IDX_role_permission_1` ON `role_permission` (`role_id`);

CREATE INDEX `IDX_role_permission_2` ON `role_permission` (`permission_id`);

# ---------------------------------------------------------------------- #
# Add table "session_role"                                               #
# ---------------------------------------------------------------------- #

CREATE TABLE `session_role` (
    `role_id` INTEGER NOT NULL,
    `session_id` INTEGER NOT NULL,
    PRIMARY KEY (`role_id`, `session_id`)
);

CREATE INDEX `IDX_session_role_1` ON `session_role` (`role_id`);

CREATE INDEX `IDX_session_role_2` ON `session_role` (`session_id`);

# ---------------------------------------------------------------------- #
# Foreign key constraints                                                #
# ---------------------------------------------------------------------- #

ALTER TABLE `user_role` ADD CONSTRAINT `user_user_role` 
    FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `user_role` ADD CONSTRAINT `role_user_role` 
    FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `sessions` ADD CONSTRAINT `users_sessions` 
    FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `permissions` ADD CONSTRAINT `object_permission` 
    FOREIGN KEY (`object_id`) REFERENCES `objects` (`object_id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `permissions` ADD CONSTRAINT `operation_permission` 
    FOREIGN KEY (`operation_id`) REFERENCES `operations` (`operation_id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `role_permission` ADD CONSTRAINT `role_role_permission` 
    FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `role_permission` ADD CONSTRAINT `permission_role_permission` 
    FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`permission_id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `session_role` ADD CONSTRAINT `role_session_role` 
    FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `session_role` ADD CONSTRAINT `session_session_role` 
    FOREIGN KEY (`session_id`) REFERENCES `sessions` (`session_id`) ON DELETE CASCADE ON UPDATE CASCADE;
