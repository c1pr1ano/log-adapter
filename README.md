# Sistema de Logging - Projeto Final de Sistemas

Este repositório contém a implementação de um sistema de logging desenvolvido como parte do trabalho final da disciplina de **Projetos de Sistemas** da Universidade Federal do Espírito Santo (UFES). O objetivo deste sistema é permitir a gravação de logs em diferentes formatos de arquivo, utilizando o padrão de projeto **Adapter** para alternar entre os formatos CSV e JSON de maneira flexível.

## Estrutura do Projeto

O projeto está organizado no pacote `br.ufes.log` e inclui as seguintes classes principais:

- **LogWriter**: Interface que define o contrato para escrita de logs.
- **CsvLogWriter**: Implementa a interface `LogWriter` para gravar logs no formato CSV.
- **JsonLogWriter**: Implementa a interface `LogWriter` para gravar logs no formato JSON.
- **LogAdapter**: Atua como um adaptador, permitindo a seleção dinâmica do formato de log desejado. Ele gerencia a criação de logs e formata as mensagens de acordo com a operação realizada.

## Funcionalidades

- **Suporte a múltiplos formatos de log**: O sistema permite a gravação de logs em arquivos CSV ou JSON, escolhidos no momento da configuração.
- **Log de operações de sucesso e falha**: Registra tanto operações bem-sucedidas quanto falhas, incluindo informações como operação realizada, nome do usuário, e timestamp.
- **Facilidade de extensão**: O sistema pode ser facilmente estendido para suportar novos formatos de log, implementando a interface `LogWriter`.

## Estrutura das Classes

### Interface `LogWriter`
Define o método `writeLog(String mensagem)` que deve ser implementado pelas classes que gravam os logs em diferentes formatos.

### Classe `CsvLogWriter`
Implementa a gravação de logs no formato CSV. Usa `FileWriter` e `PrintWriter` para escrever mensagens em um arquivo CSV especificado.

### Classe `JsonLogWriter`
Implementa a gravação de logs no formato JSON. Usa `FileWriter` para escrever as mensagens em formato JSON em um arquivo especificado, incluindo a data e hora do log.

### Classe `LogAdapter`
Responsável por adaptar a escrita de logs para o formato escolhido (CSV ou JSON). Ele formata a mensagem e delega a gravação para a classe correspondente (CSV ou JSON) com base no formato especificado no momento da configuração.

## Como Usar

1. **Configuração**: A instância do `LogAdapter` deve ser inicializada com o formato desejado (CSV ou JSON) e o caminho do arquivo onde os logs serão armazenados.

   ```java
   LogAdapter logAdapter = new LogAdapter("CSV", "caminho_para_o_arquivo.csv");

2. **Registro de Log**: Para registrar uma operação, basta chamar o método 'log' do 'LogAdapter', passando os detalhes da operação.

   ```java
   logAdapter.log("Inclusão", "João da Silva", "admin", true, "");

3. **Exemplo de Log em CSV**:+

   ```java
   Inclusão: João da Silva, (10/09/2024 14:35:00, e admin);

4. **Exemplo de Log em JSON:**:
   ```java
    {
    "mensagem": "Inclusão: João da Silva, (10/09/2024 14:35:00, e admin);",
    "timestamp": "2024-09-10T14:35:00"
    }

## Instalação
git clone https://github.com/c1pr1ano/log-adapter
