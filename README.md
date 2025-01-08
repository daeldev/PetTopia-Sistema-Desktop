# **PetTopia - Sistema Desktop**

## **Descrição do Projeto**
O **PetTopia - Sistema Desktop** é uma aplicação desenvolvida para auxiliar ONGs no gerenciamento de animais e pedidos. Voltada para uso exclusivo de administradores e funcionários, a aplicação permite cadastrar e gerenciar informações de clientes, animais e pedidos, garantindo uma gestão eficiente das operações internas.

---

## **Funcionalidades**

### **Ações Disponíveis**
- Efetuar Login
- Efetuar Cadastro
- Cadastrar Animal
- Gerenciar Cadastros
- Solicitar Pedido
- Concluir Pedidos
- Gerenciar Pedidos
- Gerar Relatórios

### **Atores e Suas Ações**
#### **Administrador**
- **Efetuar Login**: Inicia uma sessão com credenciais cadastradas.
- **Efetuar Cadastro**: Registra novos funcionários e animais. O primeiro administrador deve ser cadastrado para habilitar o sistema.
- **Gerenciar Cadastros**: Cria, edita ou exclui registros de clientes, funcionários e animais.
- **Gerenciar Pedidos**: Revisar, aceitar ou negar solicitações de adoção, doação ou denúncias, além de alterar o status de pedidos.
- **Gerar Relatórios**: Gera relatórios mensais e gerais sobre:
  - Funcionários
  - Clientes
  - Animais
  - Pedidos (adoções, doações e denúncias)

#### **Funcionário**
- **Efetuar Login**: Acessa o sistema com credenciais exclusivas.
- **Efetuar Cadastro**: Registra novos clientes e animais, especialmente durante atendimentos presenciais.
- **Cadastrar Animal**: Registra informações de animais resgatados ou vinculados a clientes, criando um banco de dados completo.
- **Gerenciar Cadastros**: Atualiza ou exclui dados de clientes e animais.
- **Solicitar Pedido**: Realiza pedidos de adoção, doação ou denúncias feitos pelos clientes.
- **Concluir Pedidos**: Finaliza processos de adoção e doação presencialmente.
- **Gerenciar Pedidos**: Edita ou cancela denúncias e organiza o andamento de adoções e doações.

> **Nota:** Todas as ações relacionadas a clientes no sistema desktop, como cadastros e solicitações, são realizadas exclusivamente pelos funcionários.

---

## **Como Usar**

### **Login Inicial**
1. Use as credenciais fornecidas pelo administrador para acessar o sistema.  
2. O administrador inicial deve ser cadastrado manualmente.

### **Cadastro de Clientes e Animais**
- Os funcionários são responsáveis por registrar clientes e animais durante atendimentos presenciais.

### **Gestão de Pedidos e Relatórios**
- Administradores e funcionários gerenciam todas as solicitações e relatórios por meio do sistema.

---


## **Tecnologias Utilizadas**
<br/>
<div align="center">
    <img src="https://skillicons.dev/icons?i=java" title="Java"/>
    <img src="https://skillicons.dev/icons?i=spring" title="Spring Framework"/>
    <img src="https://skillicons.dev/icons?i=postman" title="Postman"/>
    <img src = "https://skillicons.dev/icons?i=mysql" title="MySQL"/>
    <img src="https://skillicons.dev/icons?i=idea" title="IntelliJ IDEA"/>
</div>

> **Link para o repositório do servidor**: [PetTopia - Servidor Spring Boot][([https://github.com/seu-repositorio-servidor](https://github.com/GabsFns/pettopia-ongveterinanaria-server))](https://github.com/GabsFns/pettopia-ongveterinanaria-server)
