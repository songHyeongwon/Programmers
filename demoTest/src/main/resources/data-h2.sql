-- Greeting 더미 데이터 생성
INSERT INTO greeting(`id`, `message`)
VALUES (1, '환영합니다.'),
       (2, '과제를 잘 풀어 봅시다!')
;

-- Account 더미 데이터 생성
INSERT INTO accounts(`id`, `user_id`, `name`)
VALUES (1, 1, '첫 번째 저금통'),
       (2, 1, '두 번째 저금통'),
       (3, 2, '첫 번째 저금통'),
       (4, 2, '두 번째 저금통'),
       (5, 2, '세 번째 저금통'),
       (6, 3, '첫 번째 저금통'),
       (7, 3, '두 번째 저금통'),
       (8, 4, '첫 번째 저금통')
;

-- Transaction 더미 데이터 생성
INSERT INTO transactions(`id`, `account_id`, `user_id`, `amount`, `type`)
VALUES (1, 1, 1, 1000, 'DEPOSIT'),
       (2, 1, 1, 500, 'WITHDRAW')
;
