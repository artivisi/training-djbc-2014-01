-- Tabel Barang --
create sequence barang_id_seq start with 1 increment by 1;
create table t_barang (
    id INT PRIMARY KEY,
    kode VARCHAR2(10) NOT NULL,
    nama VARCHAR2(255) NOT NULL,
    keterangan VARCHAR2(255),
    CONSTRAINT kode_unique UNIQUE (kode)
);

-- Tabel Barang Masuk --

-- Tabel Pegawai --

-- Tabel Pemasok --
create sequence pemasok_id_seq start with 1 increment by 1;
CREATE TABLE  "PEMASOK" 
   (	"KDPEMASOK" NUMBER(5,0), 
	"NMPEMASOK" CHAR(20), 
	"TLP" NUMBER(10,0), 
	"ALAMAT" CHAR(2)
   )
;
-- Tabel RakGudang --

-- Tabel Transport --

