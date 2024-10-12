-- FES

--업로드, 취소
commit;
rollback;

--조회
select * from FES;

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