-- Tabel Barang --

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

