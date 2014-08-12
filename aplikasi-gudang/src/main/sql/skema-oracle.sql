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

-- Tabel RakGudang --

-- Tabel Transport --

-- Tabel Vendor --
create sequence vendor_id_seq start with 1 increment by 1;
create table t_vendor (
id INT PRIMARY KEY,
nama VARCHAR2 (255),
alamat VARCHAR2 (255),
produk VARCHAR2 (255),
CONSTRAINT nama_unique UNIQUE (nama)
);
