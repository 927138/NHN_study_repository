-- Projects Table
CREATE TABLE `projects` (
                            `project_id` BIGINT NOT NULL AUTO_INCREMENT,
                            `project_name` VARCHAR(255) NULL,
                            `project_status` VARCHAR(255) NULL,
                            PRIMARY KEY (`project_id`)
);

-- Users Table
CREATE TABLE `Users` (
                         `user_id` VARCHAR(255) NOT NULL,
                         `user_password` VARCHAR(255) NULL,
                         `user_email` VARCHAR(255) NULL,
                         `user_state` VARCHAR(255) NULL,
                         `user_latest_login_at` DATETIME NULL,
                         PRIMARY KEY (`user_id`)
);

-- Members Table
CREATE TABLE `members` (
                           `member_number` BIGINT NOT NULL AUTO_INCREMENT,
                           `project_id` BIGINT NOT NULL,
                           `member_id` VARCHAR(255) NOT NULL,
                           `member_role` VARCHAR(255) NULL,
                           PRIMARY KEY (`member_number`),
                           FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`)
);

-- Milestones Table
CREATE TABLE `milestones` (
                              `mile_stone_id` BIGINT NOT NULL AUTO_INCREMENT,
                              `mile_stone_status` VARCHAR(255) NULL,
                              `project_id` BIGINT NOT NULL,
                              PRIMARY KEY (`mile_stone_id`),
                              FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`)
);

-- Tags Table
CREATE TABLE `tags` (
                        `tag_id` BIGINT NOT NULL AUTO_INCREMENT,
                        `tag_name` VARCHAR(255) NULL,
                        `project_id` BIGINT NOT NULL,
                        PRIMARY KEY (`tag_id`),
                        FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`)
);

-- Tasks Table
CREATE TABLE `tasks` (
                         `task_id` BIGINT NOT NULL AUTO_INCREMENT,
                         `task_title` VARCHAR(255) NULL,
                         `task_content` TEXT NULL,
                         `mile_stone_id` BIGINT NOT NULL,
                         `project_id` BIGINT NOT NULL,
                         PRIMARY KEY (`task_id`),
                         FOREIGN KEY (`mile_stone_id`) REFERENCES `milestones` (`mile_stone_id`),
                         FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`)
);

-- Task_Tag Table
CREATE TABLE `task_tag` (
                            `task_id` BIGINT NOT NULL,
                            `tag_id` BIGINT NOT NULL,
                            PRIMARY KEY (`task_id`, `tag_id`),
                            FOREIGN KEY (`task_id`) REFERENCES `tasks` (`task_id`),
                            FOREIGN KEY (`tag_id`) REFERENCES `tags` (`tag_id`)
);

-- Comments Table
CREATE TABLE `comments` (
                            `comment_id` BIGINT NOT NULL AUTO_INCREMENT,
                            `comment_content` TEXT NULL,
                            `task_id` BIGINT NOT NULL,
                            `member_number` BIGINT NOT NULL,
                            PRIMARY KEY (`comment_id`),
                            FOREIGN KEY (`task_id`) REFERENCES `tasks` (`task_id`),
                            FOREIGN KEY (`member_number`) REFERENCES `members` (`member_number`)
);