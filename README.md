# API de Gerenciamento de Alunos

Projeto desenvolvido com foco em boas práticas de desenvolvimento backend
utilizando Java e Spring Boot aprendidos em aulas da pós-graduação
pela UNIESP!

----

## 🚀 Funcionalidades

- CRUD completo de alunos
- Validação de dados com Bean Validation
- Buscas por:
    - ID
    - CPF (suporte a múltiplos formatos)
    - Nome (busca parcial ou completa)
- Cache com Spring Cache para otimização de desempenho
- Documentação automática da API com Swagger (OpenAPI)
- Configuração de banco de dados com Spring Data JPA e PostgreSQL
- Organização modular por feature (modules/aluno) para melhor manutenção e escalabilidade
- Uso de DTOs para entrada e saída de dados, garantindo encapsulamento e flexibilidade
- Tratamento de validações com annotations para garantir a integridade dos dados e fornecer feedback claro aos clientes da API
- Adoção de boas práticas REST para garantir uma API intuitiva e fácil de usar
- Implementação de testes unitários e de integração para garantir a qualidade do código e a confiabilidade da API
- Configuração de cache para otimizar o desempenho das operações de leitura, reduzindo a carga no banco de dados e melhorando a experiência do usuário
----

## 🧠 Conceitos aplicados

- Arquitetura em camadas (Controller, Service, Repository, DTO)
- Organização modular por feature (modules/aluno)
- Uso de DTO para entrada e saída de dados
- Tratamento de validações com annotations
- Boas práticas REST
- Testes unitários e de integração
- Configuração de cache para otimização de desempenho
- Documentação automática da API com Swagger (OpenAPI)
- Validação de dados com Bean Validation
- Normalização de CPF para garantir consistência e flexibilidade na entrada de dados
- Uso de Spring Data JPA para simplificar o acesso ao banco de dados e reduzir a quantidade de código boilerplate
- Configuração de banco de dados PostgreSQL para garantir persistência confiável e escalável dos dados dos alunos
- Adoção de Lombok para reduzir a verbosidade do código e melhorar a legibilidade, eliminando a necessidade de escrever getters, setters, construtores e outros métodos comuns manualmente
- Implementação de cache com Spring Cache para melhorar o desempenho das operações de leitura, reduzindo a latência e a carga no banco de dados, especialmente para consultas frequentes como busca por ID ou CPF
- Organização do projeto em módulos por feature (modules/aluno) para melhorar a manutenção e escalabilidade, permitindo que cada módulo seja desenvolvido, testado e implantado de forma independente, facilitando a adição de novas funcionalidades no futuro sem impactar outras partes do sistema
- Uso de DTOs para entrada e saída de dados, garantindo encapsulamento e flexibilidade, permitindo que a estrutura interna do modelo de dados seja separada da representação externa, facilitando a evolução da API sem quebrar contratos com os clientes
- tratamento de validações com annotations para garantir a integridade dos dados e fornecer feedback claro aos clientes da API, utilizando as capacidades do Bean Validation para definir regras de validação diretamente nas classes de modelo ou DTO, melhorando a robustez e a confiabilidade da API
- adoção de boas práticas REST para garantir uma API intuitiva e fácil de usar, seguindo convenções de nomenclatura, uso adequado dos métodos HTTP, e fornecendo respostas claras e consistentes para os clientes da API

----
## 🛠️ Tecnologias

- Java 21
- Spring Boot
- Spring Data JPA
- Swagger (OpenAPI)
- Hibernate Validator
- PostgreSQL
- Lombok
- Spring Cache
- JUnit e Mockito para testes
- Maven para gerenciamento de dependências e build
- Git para controle de versão e colaboração
- IntelliJ IDEA como ambiente de desenvolvimento integrado (IDE)

-----
## 📌 Próximos passos
- Implementar tratamento global de exceções
- Padronizar respostas de erro
- Melhorar documentação com Swagger
- Criar modules de professores e manter o padrão da API com todos os conceitos aplicados no módulo de alunos
- ... Em desenvolvimento! Fique ligado para mais atualizações e melhorias contínuas no projeto!