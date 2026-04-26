package com.portifolio.api.modules.aluno.controller;

import com.portifolio.api.modules.aluno.dto.AlunoRequestDTO;
import com.portifolio.api.modules.aluno.dto.AlunoResponseDTO;
import com.portifolio.api.modules.aluno.service.AlunoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService service;

    //Cadastrar aluno
    @PostMapping
    public ResponseEntity<AlunoResponseDTO> cadastrarAluno(@RequestBody @Valid AlunoRequestDTO dto) {
        return ResponseEntity.ok(service.cadastrarAluno(dto));
    }

    //Listar todos os alunos
    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> listarTodosAlunos() {
        return ResponseEntity.ok(service.listarTodosAlunos());
    }

    //Buscar aluno pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> buscarAlunoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarAlunoPorId(id));
    }

    //Buscar aluno pelo CPF
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<AlunoResponseDTO> buscarPorCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(service.buscarPorCpf(cpf));
    }

    //Buscar aluno pelo nome
    @GetMapping("/nome")
    public ResponseEntity<List<AlunoResponseDTO>> buscarPorNome(
            @RequestParam String nome
    ) {
        return ResponseEntity.ok(service.buscarPorNome(nome));
    }

    //Atualizar passando o ID
    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> atualizarAlunoPorId(
            @PathVariable Long id,
            @RequestBody @Valid AlunoRequestDTO dto
    ) {
        return ResponseEntity.ok(service.atualizarAlunoPorId(id, dto));
    }

    //Deletar passando o ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        service.deletarAlunoPorId(id);
        return ResponseEntity.noContent().build();
    }
}