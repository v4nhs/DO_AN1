create database webbanquanao;
use webbanquanao;

create table roles
(
	id_role int primary key auto_increment,
    name nvarchar(255) not null
);
create table profile
(
	id_profile int auto_increment primary key,
    full_name nvarchar(255),
    address nvarchar(255),
    email nvarchar(255) unique,
    avt nvarchar(255),
	phone nvarchar(255) unique,
    dof date
);
create table accounts
(
	user_name nvarchar(255) primary key,
    pass_word nvarchar(255) not null,
    id_role int not null,
    id_profile int unique,
    status bit,
    foreign key(id_role) references roles(id_role),
    foreign key(id_profile) references profile(id_profile)
);
create table categories
(
	id_categories int auto_increment primary key,
    cate_name nvarchar(255) not null,
    des nvarchar(255)
);
create table size
(
	id_size int auto_increment primary key,
    size_name nvarchar(255) not null,
    des nvarchar(255)
);
create table color
(
	id_color int auto_increment primary key,
    color_name nvarchar(255) not null,
    des nvarchar(255)
);
create table voucher
(
	id_voucher int auto_increment primary key,
    name_voucher nvarchar(255) not null,
    code nvarchar(255) not null,
    total_price_apply float not null,
    start_date datetime not null,
    end_date datetime not null,
    percent INT NOT NULL CHECK (percent  > 0 AND percent  < 100),
    quantity int not null 
);

create table sales
(
	id_sale int auto_increment primary key,
    name_sale nvarchar(255) not null,
    percent INT NOT NULL CHECK (percent > 0 AND percent < 100),
	start_date datetime not null,
    end_date datetime not null
);

create table product
(
	id_product int auto_increment primary key,
    product_name nvarchar(255) not null,
    product_des nvarchar(255),
    import_price float not null,
    export_price float not null,
    image_main nvarchar(255),
    choosing_size nvarchar(255),
    id_sale int,
    id_categories int,
    foreign key(id_sale) references sales(id_sale),
    foreign key(id_categories) references categories(id_categories)
);
create table imageproduct
(
	id_image int auto_increment primary key,
    image nvarchar(255) not null,
    id_product int not null,
	FOREIGN KEY (id_product) REFERENCES product(id_product)
);
create table product_details
(
	id_product_details int auto_increment primary key,
    id_product int not null,
    id_size int,
    id_color int,
    product_remain int not null,
    foreign key(id_product) references product(id_product),
    foreign key(id_size) references size(id_size),
	foreign key(id_color) references color(id_color)
);
CREATE TABLE comments (
    id_comment INT AUTO_INCREMENT PRIMARY KEY,
    content NVARCHAR(255) NOT NULL,
    create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    id_profile INT NOT NULL,
    id_product INT NOT NULL,
    FOREIGN KEY (id_profile) REFERENCES profile(id_profile),
    FOREIGN KEY (id_product) REFERENCES product(id_product)
);


create table reviews
(
	id_review int auto_increment primary key,
    content nvarchar(255) not null,
    start int not null,
    create_at datetime default current_timestamp,
    update_at datetime default current_timestamp,
    id_profile int not null,
    id_product int not null,
    foreign key(id_profile) references profile(id_profile),
	foreign key(id_product) references product(id_product)
);
create table orders
(
	id_order int auto_increment primary key,
    order_at datetime DEFAULT now(),
    ten_nguoi_nhan nvarchar(255),
    ghi_chu nvarchar(255),
    email nvarchar(255),
    phone nvarchar(255) not null,
    dia_chi_nhan_hang nvarchar(255) not null,
    thanh_pho nvarchar(255) not null,
    total_price float,
    total_item int,
    total_discount float,
    total_final float,
    id_profile int not null,
    foreign key(id_profile) references profile(id_profile),
    status_order nvarchar(255),
    order_type nvarchar(255),
    status_payment nvarchar(255),
    id_voucher int,
    foreign key(id_voucher) references voucher(id_voucher)
);

create table cart(
	id_cart int auto_increment primary key,
    id_profile int,
    id_product int,
    id_size int,
    id_color int,
    quantity int,
	foreign key(id_profile) references profile(id_profile),
    foreign key(id_product) references product(id_product),
    foreign key(id_size) references size(id_size),
	foreign key(id_color) references color(id_color)
);
create table order_details
(
	id_order_details int auto_increment primary key,
    id_product int,
    id_size int,
    id_color int,
    quantity int not null,
    total_price float not null,
    id_order int not null,
    foreign key(id_order) references orders(id_order)
);
-- trigeer áp mã voucher
DELIMITER //
CREATE TRIGGER before_order_insert_use_voucher
BEFORE INSERT ON orders
FOR EACH ROW
BEGIN
    DECLARE current_voucher_quantity INT; 

    -- Kiểm tra xem cột id_voucher có được chèn hay không
    IF NEW.id_voucher IS NOT NULL THEN
        -- Lấy số lượng voucher từ bảng voucher
        SELECT quantity INTO current_voucher_quantity
        FROM voucher
        WHERE id_voucher = NEW.id_voucher;

        -- Kiểm tra nếu số lượng voucher lớn hơn 0
        IF current_voucher_quantity > 0 THEN
            -- Giảm số lượng voucher đi 1
            UPDATE voucher
            SET quantity = quantity - 1
            WHERE id_voucher = NEW.id_voucher;

        ELSE
            -- Nếu số lượng voucher không đủ, không cho phép chèn và phát sinh lỗi
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cannot insert order because voucher quantity is insufficient';
        END IF;
    END IF;
END;
//
DELIMITER ;



CREATE TRIGGER myTable_OnInsert BEFORE INSERT ON `orders`
    FOR EACH ROW SET NEW.order_at = NOW();
    
    
-- Chèn dữ liệu vào bảng sản phẩm
-- Chèn dữ liệu vào bảng màu sắc
INSERT INTO color (color_name, des)
VALUES 
    ('Trắng', 'Màu trắng'),
    ('Xanh', 'Màu xanh'),
    ('Hồng', 'Màu hồng'),
    ('Đen', 'Màu đen'),
    ('Đỏ', 'Màu đỏ');
-- Chèn dữ liệu vào bảng kích thước
INSERT INTO size (size_name, des)
VALUES 
    ('S', 'Size nhỏ'),
    ('M', 'Size trung bình'),
    ('L', 'Size lớn'),
    ('XL', 'Size rất lớn'),
    ('39', 'Size 39'),
    ('40', 'Size 40'),
    ('41', 'Size 41'),
    ('42', 'Size 42');
-- Chèn dữ liệu vào bảng danh mục
INSERT INTO categories (cate_name, des)
VALUES 
    ('Áo', 'Danh mục áo'),
    ('Quần', 'Danh mục quần'),
    ('Giày dép', 'Danh mục giày dép'),
    ('Phụ kiện', 'Danh mục phụ kiện');
    
INSERT INTO roles (name) VALUES ('USER');
INSERT INTO roles (name) VALUES ('ADMIN');
