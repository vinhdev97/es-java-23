CREATE TABLE IF NOT EXISTS `service` (
  `id` BIGINT NOT NULL AUTO_INCREMENT
  , `name` VARCHAR(256) NOT NULL UNIQUE
  , `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP
  , `created_by` VARCHAR(36) DEFAULT NULL
  , `updated_at` DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
  , `updated_by` VARCHAR(36) DEFAULT NULL
  , `deleted_at` DATETIME DEFAULT NULL
  , `deleted_by` VARCHAR(36) DEFAULT NULL
  , PRIMARY KEY (`id`)
);