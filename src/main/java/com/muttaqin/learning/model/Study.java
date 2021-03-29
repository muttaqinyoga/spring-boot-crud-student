package com.muttaqin.learning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Study {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_jurusan;

    @Column(nullable = false)
    @NotEmpty(message = "Nama jurusan tidak boleh kosong")
    @Size(min=5, max = 30, message = "isi nama jurusan antara 5 - 30 karakter")
    private String nama_jurusan;
}
