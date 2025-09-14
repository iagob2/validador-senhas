# 🔐 Validador de Senhas em Java

Este projeto é uma aplicação em **Java** para validação de senhas, desenvolvida como atividade prática de programação e testes unitários.  
O objetivo é garantir que as senhas sejam **fortes, seguras e livres de padrões fracos ou datas conhecidas**.

---

# 🧩 Funcionalidades Principais

O sistema realiza **4 tipos de validação**:

| Critério | Descrição | Resultado Esperado |
|----------|-----------|------------------|
| 🎂 **Não pode ser uma data conhecida** | Verifica se a senha não corresponde a datas em formatos comuns (`ddMMyyyy`, `dd/MM/yyyy`, `yyyy-MM-dd`, etc.) | Senhas que parecem datas **não são seguras** |
| 📏 **Tamanho mínimo** | Garante que a senha tenha pelo menos 8 caracteres | Senhas menores que 8 caracteres **não passam** |
| 💪 **Senha forte** | Deve conter **letra maiúscula, letra minúscula, número e caractere especial** | Senhas que não atendem a todos os critérios **não são consideradas fortes** |
| 🚫 **Palavras proibidas** | Evita palavras comuns e fracas como: `senha`, `password`, `123456`, `admin`, etc. | Senhas com palavras proibidas **não são aceitas** |

---

# ☁️ Teste Online no Google Colab

Execute o projeto **sem instalar nada** na sua máquina:  
[![Abrir no Colab](https://colab.research.google.com/assets/colab-badge.svg)](https://colab.research.google.com/drive/1DKRyZY_nKJKtEI8-AYBp8mylv4b8Zdb3?usp=sharing)



---

# 🎯 Conclusão

Ao aplicar os critérios validados neste notebook, o sistema:

- Bloqueia **datas de aniversário** (qualquer formato).  
- Rejeita **palavras proibidas** (lista atualizada).  
- Elimina **padrões fracos** (sequências, repetições, etc.).

Resultado: senhas **exponencialmente mais seguras** em poucos segundos.
