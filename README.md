# 💙 HealthHelp – Plataforma Web de Bem-Estar com Spring Boot + IA

## 📘 Descrição do Projeto
O **HealthHelp** é uma aplicação Web desenvolvida com **Spring Boot** para apoiar usuários no cuidado diário com saúde, bem-estar e rotina.  
O sistema permite registrar atividades diárias, avaliar equilíbrio pessoal e **gerar recomendações inteligentes** usando *Spring AI + OpenAI GPT*.

Inclui:
- Autenticação e cadastro avançado (Spring Security + BCrypt)
- Interface web moderna com Thymeleaf + Bootstrap
- Armazenamento no Oracle Cloud
- Registro de atividades e rotina
- Geração automática de recomendações com IA
- Histórico completo do usuário

---

## 🎯 Objetivos
* Permitir que usuários registrem sua rotina diária
* Registrar atividades por categoria, horário e descrição
* Calcular pontuação diária de equilíbrio
* Integrar IA para gerar **recomendações personalizadas**
* Exibir histórico, detalhes e análises
* Suportar cadastro/login por **email ou nome de usuário**
* Fornecer interface web clara e responsiva

---

## 🧱 Arquitetura

### Camadas
| Camada | Função |
|---|---|
| **Controller (Web + REST)** | Lida com rotas Thymeleaf e endpoints JSON |
| **Service** | Regras de negócio, lógica da IA, validações |
| **Repository** | DAO com Spring Data JPA |
| **DTO** | Comunicação entre camadas e formulários |
| **Model** | Entidades JPA |
| **Security** | Autenticação, autorização, senha criptografada |
| **Templates** | HTML web views (Thymeleaf) |

---

## ⚙️ Tecnologias

* **Java 21**
* **Spring Boot 3.3.x**
* **Spring Web (MVC + REST)**
* **Spring Data JPA**
* **Spring Security + BCrypt**
* **Spring AI (OpenAI Client)**
* **Thymeleaf + Bootstrap 5**
* **Oracle Database**
* **Jakarta Bean Validation**
* **Gradle**

---

## 🗄️ Banco de Dados – Oracle

`properties
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521/ORCL
spring.datasource.username=RM558024
spring.datasource.password=270605
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.open-in-view=false
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.OracleDialect
spring.jpa.properties.hibernate.default_schema=RM558024

content = """# 🚀 Como Executar

## 📦 Pré-requisitos
- **JDK 21+**
- **Gradle** ou `./gradlew`
- **Banco Oracle ativo**

---

## ▶️ Passos
bash
git clone https://github.com/CauaMachad0/HealthHelp.git
cd HealthHelp
./gradlew bootRun   # Windows: gradlew.bat bootRun

## 🌐 Acesso

- **Web:** http://localhost:8081  
- **API:** http://localhost:8081/api/**

---

## 🔐 Login

O cadastro aceita:

- **E-mail**
- **Nome de usuário**

Ambos funcionam para login.  
Senhas são armazenadas com **BCrypt**.

---

## 🧩 Interface Web (Thymeleaf)

### Rotas Principais

| Rota | Descrição |
|------|-----------|
| `/` | Dashboard / Home |
| `/login` | Login (email ou usuário) |
| `/register` | Cadastre-se |
| `/historico` | Histórico diário |
| `/registro/novo` | Criar registro diário |
| `/recomendacoes` | Listar recomendações IA |
| `/recomendacoes/{id}` | Detalhes da recomendação |

---

## 🧠 IA – Recomendação Automática (Spring AI)

O sistema coleta:

- Registros diários  
- Atividades do dia  
- Observações  
- Pontuação de equilíbrio  

Envia tudo ao **Spring AI (OpenAI GPT)** e retorna:

✔ Regras personalizadas  
✔ Recomendações em tópicos  
✔ Sugestões de rotina  
✔ Orientações saudáveis  

---

### 🔧 Exemplo do prompt gerado

- Você é um especialista em saúde e bem-estar
- Analise a rotina e gere recomendações práticas.
- Responda em português brasileiro.

---

## 🔑 Configurando a API Key no IntelliJ IDEA (Variável de Ambiente)

Para que o sistema gere recomendações via **Spring AI + OpenAI GPT**, é necessário configurar a variável de ambiente no IntelliJ IDEA.

### 📌 Passo a passo

1. Abra o **IntelliJ IDEA**  
2. Vá em:  
   **Run › Edit Configurations…**  
3. Selecione a configuração **HealthHelpApplication**  
4. Role até a seção **Environment Variables**  
5. Clique no botão **...** (ícone de três pontos)  
6. Adicione a variável:

- SPRING_AI_OPENAI_API_KEY = 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

7. Salve e execute o projeto normalmente.

### ✔️ O que isso faz?

O IntelliJ injeta a variável no ambiente da aplicação.  
No seu `application.properties`, basta referenciar assim:


Com isso, a IA estará habilitada e funcionando.

---

## 🧠 API REST

### Convenções

- **Base:** `/api/**`
- **Formato:** `application/json`
- **Validação automática:** Bean Validation  
- **Erros comuns:** `400`, `404`, `422`, `500`

---

## 📅 Registros Diários (REST)

| Método | Endpoint | Descrição |
|--------|-----------|------------|
| POST | `/api/registros` | Criar registro diário |
| GET  | `/api/registros` | Listar registros |
| GET  | `/api/registros/{id}` | Buscar por ID |

### Exemplo – RegistroDiarioDTO

json
{
  "dataRef": "2025-11-15",
  "pontuacaoEquilibrio": 7,
  "observacoes": "Dia produtivo e equilibrado."
}

## ⏱️ Atividades (REST)

### Endpoints
| Método | Endpoint                         | Descrição            |
|--------|----------------------------------|----------------------|
| POST   | `/api/atividades`                | Criar atividade     |
| GET    | `/api/atividades?registroId=1`   | Listar por registro |
| DELETE | `/api/atividades/{id}`           | Remover atividade   |

### Exemplo – **AtividadeDTO**
json
{
  "categoriaId": 2,
  "descricao": "Treino funcional",
  "inicio": "2025-11-15T09:00",
  "fim": "2025-11-15T10:00",
  "registroId": 1
}

## ✨ Recomendações (REST)

### Endpoints
| Método | Endpoint                      | Descrição |
|--------|-------------------------------|-----------|
| POST   | `/api/recomendacoes/gerar`    | Gerar IA  |
| GET    | `/api/recomendacoes`          | Listar    |
| GET    | `/api/recomendacoes/{id}`     | Detalhes  |

### Exemplo – **RecomendacaoDTO**
json
{
  "id": 4,
  "mensagem": "Sugestões da IA",
  "texto": "• Durma mais cedo...\\n• Faça alongamentos...",
  "pontuacaoRelevancia": 85,
  "criadaEm": "2025-11-18T21:00:00"
}

## 👤 Entidade Usuário

### Campos
- Nome (login)
- Email
- Senha (BCrypt)
- Altura (cm)
- Peso (kg)
- Gênero
- Data de nascimento
- Data de cadastro

### ✔️ Validações
- **Email válido**
- **Senha:** 8–30 caracteres, contendo:
  - letra maiúscula
  - letra minúscula
  - número
  - caractere especial
- **Altura:** 120–240 cm
- **Peso:** 30–400 kg

---

## 💅 UI/UX
- Bootstrap 5  
- Tema: `#121310` (dark) + `#f0f2f5` (clean)  
- Layout responsivo  
- Navbar: **Home • Histórico • Recomendações • Logout**

---

## 🛠️ Notas de Implementação
- Spring Security + BCrypt  
- Login por **email** ou **nome de usuário**  
- CSRF habilitado (automático no Thymeleaf)  
- Tratamento global de erros com `@ControllerAdvice`  
- Integração com **Spring AI** para geração de recomendações  
- Views organizadas por módulos (registros, atividades, recomendações, login etc.)

---

## 🚧 Melhorias Futuras
- Dashboard com gráficos  
- Gamificação  
- Regras personalizadas de saúde  

---

## 👨‍💻 Autor
Feito com 💙 por **Cauã Marcelo Machado**
Colaboradores Marcos Ramalho e Gabriel Lima

