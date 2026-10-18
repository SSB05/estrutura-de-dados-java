# Trabalho Prático de Estruturas de Dados

Este repositório contém a implementação das atividades práticas propostas na disciplina, desenvolvidas em Java puro.

## 📂 Organização dos Ficheiros

O projeto está dividido em três ficheiros principais, correspondendo aos exercícios exigidos:

### 1. TAD Fila Circular (`Fila.java`)
Implementação de um Tipo Abstrato de Dados (TAD) Fila utilizando uma representação circular num array de inteiros. 
* **Operações implementadas:** `cheia()`, `vazia()`, `insere()`, `remove()`, `primeiro()` e `ultimo()`.
* A estrutura de controlo baseia-se num sistema de índices (`primeiro` e `ultimo`) que regressam à posição 0 quando atingem o limite do vetor, otimizando o uso do espaço.

### 2. Operação de Merge (`Merge.java`)
Implementação de um método que recebe duas filas ordenadas e gera uma terceira fila (Fila R) perfeitamente ordenada.
* **Nota técnica:** O algoritmo foi construído respeitando rigorosamente a regra de encapsulamento, utilizando **apenas** as operações básicas do TAD Fila (sem acesso direto ao vetor de dados).

### 3. Árvore Binária Morse (`ArvoreBinariaMorse.java`)
Implementação de uma árvore binária para codificação e descodificação do Código Morse.
* O nó raiz inicia vazio (`*`).
* Movimentos para a subárvore à **esquerda** representam pontos (`.`).
* Movimentos para a subárvore à **direita** representam traços (`-`).
* O código processa as leituras e traduções através de iterações manuais clássicas (`while` e `charAt()`), sem o uso de bibliotecas de coleções ou métodos avançados de manipulação de Strings da API do Java, cumprindo os requisitos de restrição do enunciado.

## 🚀 Como Executar

Para testar qualquer um dos exercícios, basta compilar o ficheiro pretendido numa IDE ou através do terminal e executar a sua classe `main`.
Na execução da Árvore Binária Morse, o programa fará testes automáticos pré-definidos e, em seguida, solicitará a introdução de uma frase em Código Morse (letras separadas por espaços) para realizar a tradução em tempo real.
