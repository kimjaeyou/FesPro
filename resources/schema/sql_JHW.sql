
commit;
rollback;

-- FES ============================================================

--조회
select * from FES;
select * from FES WHERE FES_STATE = '1' or FES_STATE ='3'; --승인완료 + 비활성화

select FES.SVCNM,FES.FES_STATE from FES WHERE SVCID='S240919144615203064';


--추가(더미)
INSERT INTO FES VALUES (
    'SVC001', '문화', '음악', '운영중', '서울재즈페스티벌', '현장결제', '서울 올림픽공원', '일반', '37.520454', '127.121788', 
    TO_DATE('2024-05-01', 'YYYY-MM-DD'), TO_DATE('2024-05-03', 'YYYY-MM-DD'), TO_DATE('2024-04-01', 'YYYY-MM-DD'), '서울', 
    'https://example.com/image1.jpg', '서울에서 열리는 재즈 페스티벌', '010-1234-5678', '30', '20', 
    TO_DATE('2024-05-02', 'YYYY-MM-DD'), '금요일', 1, TO_DATE('2024-04-10', 'YYYY-MM-DD'), 1000, 50000, 1
);

INSERT INTO FES VALUES (
    'SVC002', '문화', '영화', '운영예정', '부산국제영화제', '온라인결제', '부산 영화의전당', '영화 애호가', '35.181467', '129.074403', 
    TO_DATE('2024-10-01', 'YYYY-MM-DD'), TO_DATE('2024-10-10', 'YYYY-MM-DD'), TO_DATE('2024-09-01', 'YYYY-MM-DD'), '부산', 
    'https://example.com/image2.jpg', '부산에서 열리는 국제 영화제', '010-8765-4321', '28', '18', 
    TO_DATE('2024-10-05', 'YYYY-MM-DD'), '토요일', 0, TO_DATE('2024-09-15', 'YYYY-MM-DD'), 1500, 30000, 2
);

INSERT INTO FES VALUES (
    'SVC003', '스포츠', '축구', '운영중', 'K리그 결승전', '현장결제', '서울 월드컵경기장', '축구 팬', '37.568256', '126.897240', 
    TO_DATE('2024-11-15', 'YYYY-MM-DD'), TO_DATE('2024-11-15', 'YYYY-MM-DD'), TO_DATE('2024-10-01', 'YYYY-MM-DD'), '서울', 
    'https://example.com/image3.jpg', 'K리그 챔피언 결정전', '010-2222-3333', '22', '15', 
    TO_DATE('2024-11-15', 'YYYY-MM-DD'), '일요일', 1, TO_DATE('2024-10-20', 'YYYY-MM-DD'), 50000, 100000, 3
);

INSERT INTO FES VALUES (
    'SVC004', '문화', '공연', '운영중', '뮤지컬 레미제라블', '온라인결제', '대구 오페라하우스', '뮤지컬 팬', '35.872022', '128.601743', 
    TO_DATE('2024-12-20', 'YYYY-MM-DD'), TO_DATE('2024-12-31', 'YYYY-MM-DD'), TO_DATE('2024-12-01', 'YYYY-MM-DD'), '대구', 
    'https://example.com/image4.jpg', '레미제라블 공연', '010-4444-5555', '10', '5', 
    TO_DATE('2024-12-25', 'YYYY-MM-DD'), '목요일', 1, TO_DATE('2024-12-05', 'YYYY-MM-DD'), 800, 70000, 4
);

INSERT INTO FES VALUES (
    'SVC005', '축제', '음식', '운영중', '전주비빔밥축제', '현장결제', '전주 한옥마을', '미식가', '35.814027', '127.150750', 
    TO_DATE('2024-09-15', 'YYYY-MM-DD'), TO_DATE('2024-09-20', 'YYYY-MM-DD'), TO_DATE('2024-09-01', 'YYYY-MM-DD'), '전주', 
    'https://example.com/image5.jpg', '전통 비빔밥을 즐길 수 있는 축제', '010-5555-6666', '26', '16', 
    TO_DATE('2024-09-17', 'YYYY-MM-DD'), '수요일', 1, TO_DATE('2024-08-25', 'YYYY-MM-DD'), 3000, 10000, 5
);

INSERT INTO FES VALUES (
    'SVC006', '문화', '미술', '운영중', '서울 아트페어', '온라인결제', '서울 코엑스', '예술 애호가', '37.511274', '127.059188', 
    TO_DATE('2024-03-01', 'YYYY-MM-DD'), TO_DATE('2024-03-05', 'YYYY-MM-DD'), TO_DATE('2024-02-01', 'YYYY-MM-DD'), '서울', 
    'https://example.com/image6.jpg', '다양한 아트 작품을 감상할 수 있는 행사', '010-1111-2222', '15', '10', 
    TO_DATE('2024-03-02', 'YYYY-MM-DD'), '토요일', 1, TO_DATE('2024-02-10', 'YYYY-MM-DD'), 2000, 25000, 6
);

INSERT INTO FES VALUES (
    'SVC007', '축제', '음악', '운영중', '부산 락 페스티벌', '현장결제', '부산 해운대', '락 음악 팬', '35.158743', '129.160322', 
    TO_DATE('2024-08-10', 'YYYY-MM-DD'), TO_DATE('2024-08-12', 'YYYY-MM-DD'), TO_DATE('2024-07-15', 'YYYY-MM-DD'), '부산', 
    'https://example.com/image7.jpg', '다양한 락 밴드의 공연을 즐길 수 있는 축제', '010-3333-4444', '20', '12', 
    TO_DATE('2024-08-11', 'YYYY-MM-DD'), '일요일', 1, TO_DATE('2024-07-20', 'YYYY-MM-DD'), 5000, 60000, 7
);

INSERT INTO FES VALUES (
    'SVC008', '스포츠', '야구', '운영중', '한국시리즈', '현장결제', '고척스카이돔', '야구 팬', '37.550793', '126.885334', 
    TO_DATE('2024-10-20', 'YYYY-MM-DD'), TO_DATE('2024-10-20', 'YYYY-MM-DD'), TO_DATE('2024-09-01', 'YYYY-MM-DD'), '서울', 
    'https://example.com/image8.jpg', '연간 최고의 야구 대회', '010-5555-6666', '25', '18', 
    TO_DATE('2024-10-20', 'YYYY-MM-DD'), '일요일', 1, TO_DATE('2024-09-15', 'YYYY-MM-DD'), 20000, 150000, 8
);

INSERT INTO FES VALUES (
    'SVC009', '문화', '연극', '운영중', '햄릿', '온라인결제', '서울 예술의 전당', '연극 팬', '37.485484', '126.992303', 
    TO_DATE('2024-01-15', 'YYYY-MM-DD'), TO_DATE('2024-01-30', 'YYYY-MM-DD'), TO_DATE('2023-12-01', 'YYYY-MM-DD'), '서울', 
    'https://example.com/image9.jpg', '셰익스피어의 유명한 연극', '010-7777-8888', '5', '3', 
    TO_DATE('2024-01-25', 'YYYY-MM-DD'), '금요일', 1, TO_DATE('2023-12-20', 'YYYY-MM-DD'), 150, 50000, 9
);

INSERT INTO FES VALUES (
    'SVC010', '축제', '음식', '운영중', '김치 축제', '현장결제', '전주 한옥마을', '미식가', '35.814027', '127.150750', 
    TO_DATE('2024-10-10', 'YYYY-MM-DD'), TO_DATE('2024-10-15', 'YYYY-MM-DD'), TO_DATE('2024-09-01', 'YYYY-MM-DD'), '전주', 
    'https://example.com/image10.jpg', '다양한 김치를 맛볼 수 있는 축제', '010-8888-9999', '30', '20', 
    TO_DATE('2024-10-12', 'YYYY-MM-DD'), '토요일', 1, TO_DATE('2024-09-25', 'YYYY-MM-DD'), 1000, 20000, 10
);

--수정
UPDATE FES SET FES_STATE = 1 WHERE SVCID ='SVC001';


-- 통계 ============================================================

--유저 조회

--뷰 삭제
DROP VIEW FES_RESERV_USER_VIEW;

--뷰 생성
CREATE VIEW FES_RESERV_USER_VIEW AS
SELECT
    f.SVCID as SVCID,
    u.*
FROM 
    fes f
JOIN 
    reservation r ON f.SVCID = r.SVCID
JOIN 
    USERS u ON r.user_seq = u.user_seq
;

--뷰 조회
SELECT * FROM FES_RESERV_USER_VIEW WHERE SVCID = 1;

-- 리뷰 ============================================================
INSERT INTO REVIEW VALUES(REVIEW_SEQ.nextval,1,1,'좋아요1',3);
INSERT INTO REVIEW VALUES(REVIEW_SEQ.nextval,2,1,'좋아요2',2);
INSERT INTO REVIEW VALUES(REVIEW_SEQ.nextval,3,1,'좋아요3',5);

SELECT * FROM REVIEW WHERE SVCID=1;

-- 리뷰 쓴 유저 뷰생성

-- 뷰 삭제
DROP VIEW FES_REVIEW_USER_VIEW;

CREATE VIEW FES_REVIEW_USER_VIEW AS
SELECT
    u.*,
    r.SCORE
    r
FROM 
    fes f
JOIN 
    REVIEW r ON f.SVCID = r.SVCID
JOIN 
    USERS u ON r.user_seq = u.user_seq
;

--뷰 조회
SELECT * FROM FES_REVIEW_USER_VIEW;

-- Wait_FES ============================================================

--조회
select * from WAIT_FES;

--삭제
delete from WAIT_FES WHERE SVCID = '1';

-- FES + Wait_FES ============================================================
SELECT Null as WAIT_FES_SEQ, f.*
FROM fes f
WHERE FES_STATE = '1' or FES_STATE = '3'

UNION All

SELECT  w.* 
FROM WAIT_FES w;


