<p align="center">
  <img src="https://iili.io/3FFO5cF.png" alt="Universidade Católica de Brasília">
</p>

## PROJETO PESSOAL - SISTEMA DE GESTÃO DE BIBLIOTECA 📚:

#### 📖 Descrição:
Projeto voltado para a criação de um sistema de gerenciamento de biblioteca, permitindo o cadastro e controle de livros, usuários e empréstimos. O sistema inclui funcionalidades para realizar operações como registro de empréstimos, devoluções e controle de multas.

#### ⚡ Funcionalidades:
1. 📚 Cadastro de livros;
2. 📋 Listagem de livros;
3. 🆔 Busca de livros por título, autor e categoria;
4. 👤 Cadastro de clientes e funcionários;
5. 📜 Listagem de usuários cadastrados;
6. 📖 Registro de empréstimos de livros;
7. 🔄 Registro de devoluções e cálculo de multas;
8. 📝 Relatórios de livros emprestados.

#### 🛠️ Tecnologias utilizadas:
- ☕ Java 17;
- 🍃 Spring Boot;
- 🐘 Gradle;
- 🗃️ JPA;
- 🐬 MySQL;

---

## 📌 Endpoints e exemplos de uso:

### 📚 1 - Cadastro de Livro:
```cmd
curl --request POST \
  --url http://localhost:8080/v1/livros/cadastrar \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/10.3.1' \
  --data '{
  "titulo": "Dom Casmurro",
  "autor": "Machado de Assis",
  "categoria": "Romance",
  "isbn": "978-85-359-0277-7"
}'
```

### 📋 2 - Listagem de Livros:
```cmd
curl --request GET \
  --url http://localhost:8080/v1/livros/listar \
  --header 'User-Agent: insomnia/10.3.1'
```

### 🔍 3 - Busca de Livros por Título:
```cmd
curl --request GET \
  --url http://localhost:8080/v1/livros/buscar/titulo/Dom Casmurro \
  --header 'User-Agent: insomnia/10.3.1'
```

### 🆕 4 - Busca de Livros por Autor:
```cmd
curl --request POST \
  --url http://localhost:8080/v1/usuarios/cadastrar \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/10.3.1' \
  --data '{
  "nome": "João da Silva",
  "cpf": "12345678900",
  "email": "joao.silva@example.com",
  "telefone": "11987654321",
  "tipoUsuario": "CLIENTE"
}'
```

### 📜 5 - Registro de Empréstimo:
```cmd
curl --request GET \
  --url http://localhost:8080/v1/usuarios/listar \
  --header 'User-Agent: insomnia/10.3.1'
```

### 📖 6 - Registro de Devolução:
```cmd
curl --request POST \
  --url http://localhost:8080/v1/emprestimos/registrar \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/10.3.1' \
  --data '{
  "clienteId": 1,
  "livroId": 3,
  "dataEmprestimo": "2025-03-05"
}'
```

### 🔄 7 - Devolução de Livro:
```cmd
curl --request PUT \
  --url http://localhost:8080/v1/emprestimos/devolver/1 \
  --header 'User-Agent: insomnia/10.3.1'
```

### 💰 8 - Relatório de Livros Emprestados:
```cmd
curl --request GET \
  --url http://localhost:8080/v1/emprestimos/multa/1 \
  --header 'User-Agent: insomnia/10.3.1'
```

## 🛺 Autor

<table>
  <tr>
    <td align="center">
      <a href="https://www.linkedin.com/in/wesley-lima-244405251/" title="Wesley Lima">
        <img src="https://media.licdn.com/dms/image/v2/D4D03AQEVAsL2UL6A0w/profile-displayphoto-shrink_400_400/profile-displayphoto-shrink_400_400/0/1721323972268?e=1746662400&v=beta&t=4_2RDPgz5FqJ2G-yRQk3y0vWMVRpSeAPKMAO7IOFXeE" width="100px;" alt="Foto do Wesley Lima"/><br>
        <sub>
          <b>Wesley Lima</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
