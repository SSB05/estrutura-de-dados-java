# Trabalho Prático de Estruturas de Dados

Este repositório contém a implementação das atividades do TDE 2 propostos na disciplina de Resolução de Problemas Estruturados em Computação

## Organização dos Arquivos

O projeto está dividido em três arquivos principais, correspondendo aos exercícios exigidos:

### 1. TAD Fila Circular (`Fila.java`)
Implementação de um Tipo Abstrato de Dados (TAD) Fila utilizando uma representação circular num array de inteiros. 
* **Operações implementadas:** `cheia()`, `vazia()`, `insere()`, `remove()`, `primeiro()` e `ultimo()`.

### 2. Operação de Merge (`Merge.java`)
Implementação de um método que recebe duas filas ordenadas e gera uma terceira fila (Fila R) também ordenada.
* **Nota técnica:** foi realizado utilizando **apenas** as operações básicas do TAD Fila (sem acesso direto ao vetor de dados).

### 3. Árvore Binária Morse (`ArvoreBinariaMorse.java`)
Implementação de uma árvore binária para tradução de Código Morse.
* O nó raiz inicia vazio (`*`).
* Movimentos para a subárvore à **esquerda** representam pontos (`.`).
* Movimentos para a subárvore à **direita** representam traços (`-`).
* O código processa as leituras e traduções através de iterações manuais clássicas (`while` e `charAt()`), sem o uso de bibliotecas de coleções ou métodos avançados de manipulação de Strings da API do Java.

