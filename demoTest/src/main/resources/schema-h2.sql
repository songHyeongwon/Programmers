DROP TABLE IF EXISTS greeting;
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS transactions;
DROP TABLE IF EXISTS account_sync_logs;

CREATE TABLE greeting
(
    `id`         bigint       NOT NULL AUTO_INCREMENT COMMENT 'PK',
    `message`    varchar(255) NOT NULL COMMENT '메시지',
    `created_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '생성 일자',
    PRIMARY KEY (`id`)
);

CREATE TABLE accounts
(
    `id`         bigint       NOT NULL AUTO_INCREMENT COMMENT 'PK',
    `user_id`    bigint       NOT NULL COMMENT '사용자 ID',
    `name`       varchar(255) NOT NULL COMMENT '계좌 명칭',
    `created_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '생성 일자',
    PRIMARY KEY (`id`),
    INDEX        `idx_accounts_user_id` (`user_id`)
);

CREATE TABLE transactions
(
    `id`         bigint   NOT NULL AUTO_INCREMENT COMMENT 'PK',
    `account_id` bigint   NOT NULL COMMENT '계좌 ID',
    `user_id`    bigint   NOT NULL COMMENT '사용자 ID',
    `amount`     bigint   NOT NULL COMMENT '거래 금액',
    `type`       enum ('DEPOSIT','WITHDRAW') NOT NULL COMMENT '거래 구분',
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '생성 일자',
    PRIMARY KEY (`id`),
    INDEX        `idx_transactions_account_id` (`account_id`),
    INDEX        `idx_transactions_user_id` (`user_id`)
);

CREATE TABLE account_sync_logs
(
    `id`                  bigint       NOT NULL AUTO_INCREMENT COMMENT 'PK',
    `account_id`          bigint       NOT NULL COMMENT '계좌 ID',
    `last_transaction_id` bigint       NOT NULL COMMENT '동기화 시점 계좌의 마지막 거래 ID',
    `balance`             bigint       NOT NULL COMMENT '계좌 잔액',
    `uuid`                varchar(255) NOT NULL COMMENT '동기화 UUID',
    `created_at`          datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '생성 일자',
    PRIMARY KEY (`id`),
    INDEX                 `idx_account_sync_logs_uuid_account_id` (`uuid`, `account_id`)
);
