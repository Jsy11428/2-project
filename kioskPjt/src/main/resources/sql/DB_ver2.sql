CREATE DATABASE DB_KIOSK;

USE DB_KIOSK;

-- ADMIN 테이블
CREATE TABLE TBL_ADMIN_MEMBER(
	AM_NO 		INT AUTO_INCREMENT,				-- 어드민 NO
    AM_NAME 	VARCHAR(30) NOT NULL,			-- 어드민 이름
	AM_ID		VARCHAR(30) NOT NULL,			-- 어드민 ID
	AM_PW		VARCHAR(100) NOT NULL,			-- 어드민  PW
	AM_PHONE 	VARCHAR(30) NOT NULL,			-- 어드민 연락처
	AM_MAIL		VARCHAR(50) NOT NULL,			-- 어드민 메일
	AM_APPROVAL	TINYINT DEFAULT 0,				-- 어드민 승인여부 (0:미승인, 1:승인)
	AM_REG_DATE	DATETIME,						-- 어드민 등록일
	AM_MOD_DATE	DATETIME,						-- 어드민 수정일
    PRIMARY KEY(AM_NO)
);

SELECT * FROM TBL_ADMIN_MEMBER;
DELETE FROM TBL_ADMIN_MEMBER;
DROP TABLE TBL_ADMIN_MEMBER;


-- FRANCHISEE MEMBER 테이블
CREATE TABLE TBL_FC_MEMBER(
	FCM_NO 			INT AUTO_INCREMENT,			-- 가맹멤버 NO
	FCM_ID			VARCHAR(30) NOT NULL,		-- 가맹멤버 ID
	FCM_PW			VARCHAR(100) NOT NULL,		-- 가맹멤버 PW
    FCM_NAME		VARCHAR(30) NOT NULL,		-- 가맹멤버 NAME
	FCM_PHONE		VARCHAR(30) NOT NULL,		-- 가맹멤버 연락처
	FCM_MAIL		VARCHAR(50) NOT NULL,		-- 가맹멤버 메일
	FCM_APPROVAL	TINYINT DEFAULT 0,			-- 가맹멤버 승인여부 (0:미승인, 1:승인)
	FCM_REG_DATE	DATETIME,					-- 가맹멤버 등록일
	FCM_MOD_DATE	DATETIME,					-- 가맹멤버 수정일
	PRIMARY KEY(FCM_NO)
);

SELECT * FROM TBL_FC_MEMBER;
DELETE FROM TBL_FC_MEMBER;
DROP TABLE TBL_FC_MEMBER;


-- FRANCHISEE STORE 테이블
CREATE TABLE TBL_FC_STORE(
	FCS_NO 			INT AUTO_INCREMENT,			-- 가맹점 NO
    FCS_LOCATION 	VARCHAR(100) NOT NULL,		-- 가맹점 위치
	FCS_PHONE		VARCHAR(30) NOT NULL,		-- 가맹점 연락처
	FCM_ID			VARCHAR(30),				-- 가맹 멤버 ID (TBL_FC_MEMBER) 
	FCS_REG_DATE	DATETIME,					-- 가맹점 등록일
	FCS_MOD_DATE	DATETIME,					-- 가맹점 수정일
	PRIMARY KEY(FCS_NO)
);

SELECT * FROM TBL_FC_STORE;
DELETE FROM TBL_FC_STORE;
DROP TABLE TBL_FC_STORE;

SELECT * FROM TBL_PAYMENT_METHOD;

-- FRANCHISEE SALES 테이블
CREATE TABLE TBL_FC_SALES(
	FCSA_NO			INT AUTO_INCREMENT,			-- 매출 NO
	FCSA_ORDER_NO	INT NOT NULL,				-- 오더 NO	
	FC_MENU_NO		INT NOT NULL,				-- 메뉴 NO
	FCSA_MENU_CNT	INT NOT NULL,				-- 메뉴 수량 (TBL_FC_MENU)
	FCS_NO			INT,						-- 가맹점 NO (TBL_FC_STORE)
	FCS_REG__DATE	DATETIME,					-- 등록일
	FCS_MOD_DATE	DATETIME,					-- 수정일
	PRIMARY KEY(FCSA_NO)
);

SELECT * FROM TBL_FC_SALES;
DELETE FROM TBL_FC_SALES;
DROP TABLE TBL_FC_SALES;

INSERT INTO TBL_FC_SALES(FCO_ORI_NO, FCSA_PRICE, PM_TYPE, FCS_NO, FCSA_RTBL_ADMIN_MEMBEREG_DATE, FCSA_MOD_DATE) VALUES(2, 9999, '카드', 5, NOW(), NOW());
INSERT INTO TBL_FC_SALES(FCO_ORI_NO, FCSA_PRICE, PM_TYPE, FCS_NO, FCSA_REG_DATE, FCSA_MOD_DATE) 
VALUES (1, 5000, '카드', 6, NOW(), NOW());


-- 메뉴 테이블TBL_FC_MENU
CREATE TABLE TBL_FC_MENU(
	FC_MENU_NO			INT AUTO_INCREMENT,		-- 메뉴 NO
	FC_MENU_NAME		VARCHAR(30) NOT NULL,	-- 메뉴 이름
	FCMC_NO				INT NOT NULL,			-- 메뉴 대분류(TBL_FC_MENU_CATEGORY)
	FC_MENU_TEXT		VARCHAR(200) NOT NULL,	-- 메뉴 설명
	FC_MENU_PRICE		INT NOT NULL,			-- 메뉴 가격
    FC_MENU_IMG_NAME	VARCHAR(300),			-- 메뉴 이미지파일이름
    FC_MENU_QUANTITY	INT,					-- 메뉴 수량
	FC_MENU_REG_DATE	DATETIME,				-- 메뉴 등록일
	FC_MENU_MOD_DATE	DATETIME,				-- 메뉴 수정일
	PRIMARY KEY(FC_MENU_NO)
);

-- 커피메뉴 (FCMC_NO == 1)
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("에스프레소", 1 , "브라질 원두 블렌딩으로 다크초콜릿, 카라멜, 견과류의 고소함을 느낄 수 있는 에스프레소", 1500, "\\img\\1_coffee\\1_espresso.png", NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("아메리카노(HOT)", 1 , "100% 아라비카 로스팅 원두로 뽑아내 깊고 진한 맛의 아메리카노", 1500, "\\img\\1_coffee\\2_americano_hot.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("아메리카노(ICE)", 1 , "100% 아라비카 로스팅 원두로 뽑아내 깊고 진한 맛의 아메리카노", 2000, "\\img\\1_coffee\\3_americano_ice.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("다방커피(HOT)", 1 , "달콤한 믹스커피 종결자!", 1500, "\\img\\1_coffee\\4_mix_coffee_hot.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("다방커피(ICE)", 1 , "달콤한 믹스커피 종결자!", 2000, "\\img\\1_coffee\\5_mix_coffee_ice.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("연유라떼(HOT)", 1 , "달달하고 향긋한 베트남식 연유라떼", 2500, "\\img\\1_coffee\\6_cmilk_latte_hot.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("연유라떼(ICE)", 1 , "달달하고 향긋한 베트남식 연유라떼", 3000, "\\img\\1_coffee\\7_cmilk_latte_ice.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("카페라떼(HOT)", 1 , "진한 에스프레소와 우유가 어우려져 탄생한 부드러운 라떼", 2500, "\\img\\1_coffee\\8_latte_hot.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE)  
VALUES("카페라떼(ICE)", 1 , "진한 에스프레소와 우유가 어우려져 탄생한 부드러운 라떼", 3000, "\\img\\1_coffee\\9_latte_ice.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("바닐라라떼(HOT)", 1 , "부드러운 우유와 달콤하고 은은한 바닐라가 조화를 이루는 음료", 2500, "\\img\\1_coffee\\10_vanilla_latte_hot.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("바닐라라떼(ICE)", 1 , "부드러운 우유와 달콤하고 은은한 바닐라가 조화를 이루는 음료", 3000, "\\img\\1_coffee\\11_vanilla_latte_ice.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("카페모카(HOT)", 1 , "초콜릿과 진한 에스프레소, 부드러운 우유가 더해진 달콤한 맛의 커피", 2500, "\\img\\1_coffee\\12_caffe_mocha_hot.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("카페모카(ICE)", 1 , "초콜릿과 진한 에스프레소, 부드러운 우유가 더해진 달콤한 맛의 커피", 3000, "\\img\\1_coffee\\13_caffe_mocha_ice.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("카라멜마끼아또(HOT)", 1 , "카라멜소스와 신선한 우유, 에스프레소로 맛을 낸 달콤한 인기메뉴", 3000, "\\img\\1_coffee\\14_caramel_macchiato_hot.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("카라멜마끼아또(ICE)", 1 , "카라멜소스와 신선한 우유, 에스프레소로 맛을 낸 달콤한 인기메뉴", 3500, "\\img\\1_coffee\\15_caramel_macchiato_ice.png" , NOW(), NOW());

-- 차 메뉴 (FCMC_NO == 2)
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("미숫가루(ONLY ICE)", 2 , "고소하고 진한 맛의 미숫가루!", 2500, "\\img\\2_tea\\16_grain_powder.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("밀크티(HOT)", 2 , "얼그레이의 향긋함을 더한 부드러운 밀크티", 2500, "\\img\\2_tea\\17_milk_tea_hot.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("밀크티(ICE)", 2 , "얼그레이의 향긋함을 더한 부드러운 밀크티", 3000, "\\img\\2_tea\\18_milk_tea_ice.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("페퍼민트티(HOT)", 2 , "입안 가득 퍼지는 페퍼민트 향으로 기분까지 상쾌해지는 메뉴", 2000, "\\img\\2_tea\\19_peppermint_tea_hot.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("페퍼민트티(ICE)", 2 , "입안 가득 퍼지는 페퍼민트 향으로 기분까지 상쾌해지는 메뉴", 2500, "\\img\\2_tea\\20_peppermint_tea_ice.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("캐모마일티(HOT)", 2 , "부드럽고 은은한 향으로 마음을 진정시켜주는 허브티", 2000, "\\img\\2_tea\\21_chamomile_tea_hot.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("캐모마일티(ICE)", 2 , "부드럽고 은은한 향으로 마음을 진정시켜주는 허브티", 2500, "\\img\\2_tea\\22_chamomile_tea_ice.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("깔라만시티(ONLY ICE)", 2 , "입안가득 전해지는 새콤함! 새콤 톡톡 깔라만시티", 3500, "\\img\\2_tea\\23_calamansi_tea_ice.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("아이스티(ONLY ICE)", 2 , "시원하게 즐기는 복숭아 맛 아이스티", 2500, "\\img\\2_tea\\24_ice_tea.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("우롱티(HOT)", 2 , "직접 우려 깊고 진한 풍미와 깔끔한 맛의 우롱티", 3000, "\\img\\2_tea\\25_oolong_tea_hot.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("우롱티(ICE)", 2 , "직접 우려 깊고 진한 풍미와 깔끔한 맛의 우롱티", 3500, "\\img\\2_tea\\26_oolong_tea_ice.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("유자티(HOT)", 2 , "진하게 전해지는 향긋함! 달콤한 유자티", 3000, "\\img\\2_tea\\27_citron_tea_hot.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("유자티(ICE)", 2 , "진하게 전해지는 향긋함! 달콤한 유자티", 3500, "\\img\\2_tea\\28_citron_tea_ice.png" , NOW(), NOW());

-- 스무디 메뉴 (FCMC_NO == 3)
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("딸기바나나스무디", 3 , "상큼한 딸기와 달달한 바나나의 완전 시원한 만남!", 4500, "\\img\\3_smoothie\\29_strawberry_banana_smoothie.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("초코바나나스무디", 3 , "달콤한 초코와 달달한 바나나의 완전 시원한 만남!", 4500, "\\img\\3_smoothie\\30_choco_banana_smoothie.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("녹차스무디", 3 , "100% 국내산 녹차를 사용하여 부드럽고 진한 맛의 스무디!", 4000, "\\img\\3_smoothie\\31_green_tea_smoothie.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("민트초코스무디", 3 , "초코칩으로 더한 깊은 초콜릿의 맛과 민트의 상쾌함이 어우러진 진한 민트초코 스무디", 5000, "\\img\\3_smoothie\\32_mint_choco_smoothie.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("쿠앤크스무디", 3 , "달콤한 쿠키 크런치가 듬뿍 들어간 스무디", 5500, "\\img\\3_smoothie\\33_cookie_and_crunch_smoothie.png" , NOW(), NOW());

-- 에이드 메뉴 (FCMC_NO == 4)
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("딸기에이드", 4 , "톡 쏘는 탄산수에 딸기 과육을 듬뿍 넣어 달콤한 청량감이 입안 가득!", 4500, "\\img\\4_ade\\34_strawberry_ade.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("레몬에이드", 4 , "레몬 과육이 듬뿍! 더욱 상큼하게 즐기는 레모네이드", 4500, "\\img\\4_ade\\35_lemon_ade.png"  , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("청포도에이드", 4 , "청포도의 상큼함과 향긋한 꽃향기가 퍼지는 상큼 달콤한 에이드 음료", 4500, "\\img\\4_ade\\36_green_grape_ade.png"  , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("자몽에이드", 4 , "달콤 쌉쌀한 자몽에이드", 4500, "\\img\\4_ade\\37_grapefruit_ade.png"  , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("복숭아에이드", 4 , "청량감 가득 달콤상큼 에이드!", 4500, "\\img\\4_ade\\38_peach_ade.png" , NOW(), NOW());

-- 아이스크림/디저트 메뉴 (FCMC_NO == 5)
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("감자빵", 5 , "국내산 감자가 들어있는 짭짤하고 고소한 감자빵", 3500, "\\img\\5_desert\\39_potato_bread.png" , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("고구마빵", 5 , "국내산 고구마(앙금 내 수입산 혼용)가 들어있는 달달하고 고소한 고구마빵", 3500, "\\img\\5_desert\\40_sweet__potato_bread.png"  , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("황치즈 크럼블 머핀", 5 , "짭짤하고 고소한 황치즈 머핀에 달콤한 크럼블을 곁들인 단짠 디저트", 4500, "\\img\\5_desert\\41_cheese_muffin.png"  , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("크룽지", 5 , "황설탕 카라멜라이징으로 더 달콤고소한 빅사이즈 크룽지", 3500, "\\img\\5_desert\\42_croonggi.png"  , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("크리미슈", 5 , "비스킷과 부드러운 크림의 환상 조합!", 1500, "\\img\\5_desert\\43_creamy_puff.png"  , NOW(), NOW());
INSERT INTO TBL_FC_MENU(FC_MENU_NAME, FCMC_NO, FC_MENU_TEXT, FC_MENU_PRICE, FC_MENU_IMG_NAME, FC_MENU_REG_DATE, FC_MENU_MOD_DATE) 
VALUES("소프트콘", 5 , "입안에서 부드럽게 사르륵 녹는 마성의 아이스크림", 2000, "\\img\\5_desert\\44_soft_ice_cream.png"  , NOW(), NOW());


SELECT * FROM TBL_FC_MENU;
DELETE FROM TBL_FC_MENU;
DROP TABLE TBL_FC_MENU;

DELETE FROM TBL_FC_MENU WHERE FC_MENU_NO >= 44;


-- 메뉴 카테고리 테이블
CREATE TABLE TBL_FC_MENU_CATEGORY(
	FCMC_NO			INT AUTO_INCREMENT,			-- 메뉴 대분류
	FCMC_P_NO		INT DEFAULT 0,				-- 부모여부(0:대분류, ELSE 소분류)
	FCMC_NAME		VARCHAR(30) NOT NULL,		-- 메뉴분류 이름
	FCMC_REG_DATE	DATETIME,					-- 메뉴분류 등록일
	FCMC_MOD_DATE	DATETIME,					-- 메뉴분류 수정일
	PRIMARY KEY(FCMC_NO)
);

INSERT INTO TBL_FC_MENU_CATEGORY(FCMC_NAME, FCMC_REG_DATE, FCMC_MOD_DATE) 
VALUES("커피(COFFEE)", NOW(), NOW());
INSERT INTO TBL_FC_MENU_CATEGORY(FCMC_NAME, FCMC_REG_DATE, FCMC_MOD_DATE) 
VALUES("차(TEA)", NOW(), NOW());
INSERT INTO TBL_FC_MENU_CATEGORY(FCMC_NAME, FCMC_REG_DATE, FCMC_MOD_DATE) 
VALUES("스무디(SMOOTHIE)", NOW(), NOW());
INSERT INTO TBL_FC_MENU_CATEGORY(FCMC_NAME, FCMC_REG_DATE, FCMC_MOD_DATE) 
VALUES("에이드(ADE)", NOW(), NOW());
INSERT INTO TBL_FC_MENU_CATEGORY(FCMC_NAME, FCMC_REG_DATE, FCMC_MOD_DATE) 
VALUES("아이스크림/디저트(DESERT)", NOW(), NOW());


SELECT * FROM TBL_FC_MENU_CATEGORY;
DELETE FROM TBL_FC_MENU_CATEGORY;

DELETE FROM TBL_FC_MENU_CATEGORY WHERE FCMC_NO >= 6;

DROP TABLE TBL_FC_MENU_CATEGORY;



-- 이 밑은 안씀! --------------------------------------------------------------------------------------------


-- 메뉴 추가 요청 테이블
CREATE TABLE TBL_FC_ADD_MENU(
	FC_ADD_MENU_NO 				INT AUTO_INCREMENT,				-- 추가 요청 메뉴 NO
    FCMC_NO						INT NOT NULL,					-- 추가 요청 메뉴 대분류
    FC_ADD_MENU_NAME			VARCHAR(30) NOT NULL,			-- 추가 요청 메뉴 이름
    FC_ADD_MENU_TEXT			VARCHAR(200) NOT NULL,			-- 추가 요청 메뉴 설명
    FC_ADD_MENU_PRICE			INT NOT NULL,					-- 추가 요청 메뉴 가격
    FC_ADD_MENU_IMG_NAME		VARCHAR(50),					-- 추가 요청 메뉴 이미지파일 이름
    FC_ADD_MENU_APPROVAL		TINYINT DEFAULT 0,				-- 추가 요청 메뉴 승인여부(0:미승인, 1:승인)
    FC_ADD_MENU_REG_DATE		DATETIME,						-- 추가 요청 메뉴 등록일
	FC_ADD_MENU_MOD_DATE		DATETIME,						-- 추가 요청 메뉴 수정일
	PRIMARY KEY(FC_ADD_MENU_NO)
);

SELECT * FROM TBL_FC_ADD_MENU;
DELETE FROM TBL_FC_ADD_MENU;
DROP TABLE TBL_FC_ADD_MENU;

