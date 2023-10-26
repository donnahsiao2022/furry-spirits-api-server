-- 後台 側邊欄
INSERT INTO back_stage_side_bar (id,name,parent_id,path,seq,is_display) VALUES (1, '會員中心', 0,'MemberCenterView',  99, true);
INSERT INTO back_stage_side_bar (id,name,parent_id,path,seq,is_display) VALUES (2, '後台使用者', 0,'UserCenterView', 99, true);
INSERT INTO back_stage_side_bar (id,name,parent_id,path,seq,is_display) VALUES (3, '訂單記錄', 0,'OrderListView', 99, true);
INSERT INTO back_stage_side_bar (id,name,parent_id,path,seq,is_display) VALUES (4, '商城管理', 0,'ShopCenterView', 99, true);

-- 產品
INSERT INTO product (name,price) VALUES ('iphone15',45000);
INSERT INTO product (name,price) VALUES ('Mac',60000);
INSERT INTO product (name,price) VALUES ('iPad',25000);