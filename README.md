Projeto LiterAlura
Este é o projeto LiterAlura, um catálogo de livros que interage com a API Gutendex para buscar metadados de livros de domínio público.

Funcionalidades
Integração com API Gutendex: Busca de metadados de livros.
Manipulação de Dados: Utilização de JSON e requisições HTTP.
Armazenamento em Banco de Dados: Utilização do Hibernate para persistência de dados.
Configuração do Ambiente
Pré-requisitos

Java Development Kit (JDK) 11 ou superior instalado.
Apache Maven instalado e configurado.
Configuração do Projeto

Clone este repositório para sua máquina local:
bash
git clone https://github.com/seu_usuario/literalura.git

Importação no IntelliJ IDEA
Abra o IntelliJ IDEA e importe o projeto como um projeto Maven existente.
Aguarde até que o IntelliJ importe todas as dependências definidas no arquivo pom.xml.
Configuração da API Gutendex

Você precisa obter uma chave de API da Gutendex para realizar requisições à API.
Configure a chave de API no arquivo apropriado (Config.java, por exemplo) antes de compilar e executar o projeto.
Execução
Compilação e Execução

Compile o projeto usando Maven no IntelliJ IDEA ou através da linha de comando:
mvn clean install

Execute a aplicação Java para interagir com o catálogo de livros:
mvn exec:java -Dexec.mainClass="com.literalura.Main"
Opções de Interatividade

Durante a execução, você poderá interagir com o catálogo de livros através do console.
Explore as opções disponíveis para buscar livros, listar autores e outras funcionalidades implementadas.
Autor
Julio P Ferreira TI
