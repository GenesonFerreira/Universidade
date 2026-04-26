package com.portifolio.api.modules.aluno.service;

import com.portifolio.api.modules.aluno.dto.AlunoRequestDTO;
import com.portifolio.api.modules.aluno.dto.AlunoResponseDTO;
import com.portifolio.api.modules.aluno.model.Aluno;
import com.portifolio.api.modules.aluno.repository.AlunoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    //Cadastrar aluno no banco de dados
    @CacheEvict(value = "listaAlunos", allEntries = true)
    public AlunoResponseDTO cadastrarAluno(AlunoRequestDTO dto) {

        String cpfLimpo = limparCpf(dto.getCpf());

        if (alunoRepository.findByCpf(cpfLimpo).isPresent()) {
            throw new RuntimeException("CPF já cadastrado");
        }

        Aluno aluno = new Aluno();
        aluno.setNomeCompleto(dto.getNomeCompleto());
        aluno.setCpf(cpfLimpo); // 🔥 SALVA SEM FORMATAÇÃO
        aluno.setEmail(dto.getEmail());
        aluno.setTelefone(dto.getTelefone());
        aluno.setDataNascimento(dto.getDataNascimento());

        return toResponse(alunoRepository.save(aluno));
    }

    //Listar todos os alunos
    @Cacheable(value = "listaAlunos")
    public List<AlunoResponseDTO> listarTodosAlunos() {
        return alunoRepository.findAll().stream().map(this::toResponse).toList();
    }

    // Buscar aluno por ID
    @Cacheable(value = "alunos", key = "#id")
    public AlunoResponseDTO buscarAlunoPorId(Long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return toResponse(aluno);
    }

    // Buscar aluno por CPF
    @Cacheable(value = "alunosCpf", key = "#cpf")
    public AlunoResponseDTO buscarPorCpf(String cpf) {
        String cpfLimpo = limparCpf(cpf);
        Aluno aluno = alunoRepository.findByCpf(cpfLimpo).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return toResponse(aluno);
    }

    //Buscar por Nome
    public List<AlunoResponseDTO> buscarPorNome(String nome) {
        List<Aluno> alunos = alunoRepository.findByNomeCompletoContainingIgnoreCase(nome);
        if (alunos.isEmpty()) {
            throw new RuntimeException("Nenhum aluno encontrado");
        }
        return alunos.stream().map(this::toResponse).toList();
    }

    //Atualizar aluno passando o ID
    @Caching(evict = {
            @CacheEvict(value = "alunos", key = "#id"),
            @CacheEvict(value = "listaAlunos", allEntries = true)
    })
    public AlunoResponseDTO atualizarAlunoPorId(Long id, AlunoRequestDTO dto) {

        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        aluno.setNomeCompleto(dto.getNomeCompleto());
        aluno.setCpf(dto.getCpf());
        aluno.setEmail(dto.getEmail());
        aluno.setTelefone(dto.getTelefone());
        aluno.setDataNascimento(dto.getDataNascimento());

        return toResponse(alunoRepository.save(aluno));
    }

    //Deletar aluno passando ID
    @Caching(evict = {
            @CacheEvict(value = "alunos", key = "#id"),
            @CacheEvict(value = "listaAlunos", allEntries = true)
    })
    public void deletarAlunoPorId(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno não encontrado");
        }
        alunoRepository.deleteById(id);
    }

    //Conversão simples
    private AlunoResponseDTO toResponse(Aluno aluno) {
        return AlunoResponseDTO.builder()
                .id(aluno.getId())
                .nomeCompleto(aluno.getNomeCompleto())
                .cpf(aluno.getCpf())
                .email(aluno.getEmail())
                .telefone(aluno.getTelefone())
                .dataNascimento(aluno.getDataNascimento())
                .build();
    }

    private String limparCpf(String cpf) {
        return cpf.replaceAll("[^0-9]", "");
    }
}