<<<<<<< HEAD
-- Tabel Barang --
create sequence barang_id_seq start with 1 increment by 1;
create table t_barang (
    id INT PRIMARY KEY,
    kode VARCHAR2(10) NOT NULL,
    nama VARCHAR2(255) NOT NULL,
    keterangan VARCHAR2(255),
    CONSTRAINT kode_unique UNIQUE (kode)
);

-- Tabel Gedung --
create sequence gedung_id_seq start with 1 increment by 1;
create table t_gedung (
    id INT PRIMARY KEY,
    kode VARCHAR2(10) NOT NULL,
    nama VARCHAR2(255) NOT NULL,
    alamat VARCHAR2(255) NOT NULL,
    keterangan VARCHAR2(255),
    CONSTRAINT kode_gedun_unique UNIQUE (kode)
);

-- Tabel Barang Masuk --

-- Tabel Pegawai --
create sequence pegawai_id_seq start with 1 increment by 1;
create table t_pegawai (
    id INT PRIMARY KEY,
    nama VARCHAR2(255) NOT NULL,
    divisi VARCHAR2(255)
);
-- Tabel Pemasok --

-- Tabel RakGudang --
create sequence rakgudang_id_seq start with 1 increment by 1;
create table rakgudang (
    id INT PRIMARY KEY,
    namarak VARCHAR2(10) NOT NULL,
    norak VARCHAR2(255) NOT NULL,
    keterangan VARCHAR2(255),
   CONSTRAINT kode_norak_unique UNIQUE (norak)
);

-- Tabel Transport --

-- Tabel JasaPengiriman --
create sequence jasaPengiriman_id_seq start with 1 increment by 1;
create table t_jasaPengiriman(
    id INT PRIMARY KEY,
    kodeJasaPengiriman VARCHAR2(5) NOT NULL,
    namaJasaPengiriman VARCHAR2 (100) NOT NULL,
    tipePengiriman VARCHAR2 (100),
    keterangan VARCHAR2 (100),
    CONSTRAINT kode_jasa_unique UNIQUE (kodeJasaPengiriman)
);