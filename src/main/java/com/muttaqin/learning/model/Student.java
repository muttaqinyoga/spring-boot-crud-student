package com.muttaqin.learning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mahasiswa;

    @NotEmpty(message = "Nama mahasiswa tidak boleh kosong")
    @Size(min=5, max = 50, message = "isi nama mahasiswa antara 5 - 30 karakter")
    @Column(nullable = false)
    private String nama_mahasiswa;
    @Column(nullable = false)
    @NotEmpty(message = "NIM tidak boleh kosong")
    @Size(min=10, max = 10, message = "nim harus tepat 10 karakter angka")
    private String nim;
    @Column(nullable = false)
    @NotEmpty(message = "Alamat tidak boleh kosong")
    private String alamat_mahasiswa;
    @NotNull(message = "Pilih salah satu jurusan ")
    @ManyToOne
    @JoinColumn(name = "jurusan_id", nullable = false)
    private Study jurusan;
}
