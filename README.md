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
- **NetBeans 19**: Ambiente de desenvolvimento integrado (IDE) utilizado.
- **JDK 23**: Versão do Java Development Kit.
- **Java Swing**: Biblioteca gráfica utilizada para o desenvolvimento da interface.
- **Spring Boot (Servidor)**: Para o backend da aplicação.
- **MySQL**: Banco de dados utilizado para armazenar informações.

<div align="left">
    <img src="https://skillicons.dev/icons?i=java" title="Java" width="50"/>
    <img src="https://skillicons.dev/icons?i=spring" title="Spring Framework" width="50"/>
    <img src="https://skillicons.dev/icons?i=postman" title="Postman" width="50"/>
    <img src="https://skillicons.dev/icons?i=mysql" title="MySQL" width="50"/>
    <img src="https://github.com/user-attachments/assets/d252c929-411f-4b84-87ee-9ffdda5e6386" title="NetBeans" width="55"/>
    <img src="https://skillicons.dev/icons?i=idea" title="IntelliJ IDEA" width="50"/>
    <img src="https://skillicons.dev/icons?i=git" title="Git" width="50"/>
</div>

> **Link para o repositório do servidor**: [PetTopia - Servidor Spring Boot](https://github.com/GabsFns/pettopia-ongveterinanaria-server)

## **Algumas fotos do sistema**
### Tela de login  
![Tela de Login](https://github.com/user-attachments/assets/665fbe2c-5f6d-4c55-ad3a-e4e987f7ebbe)

### Dashboard  
![Dashboard](https://github.com/user-attachments/assets/ecfb6887-db11-4376-90a9-ba9ebd3ed66c)

### Cadastrar Cliente  
![Cadastrar Cliente](https://github.com/user-attachments/assets/d022c87f-8d94-425d-a256-6a416fb1129d)

### Registro de Clientes  
![Registro de Clientes](https://github.com/user-attachments/assets/825042bc-c979-43f7-bf72-6031eef10c3a)

## **Documentação**
Para obter mais detalhes e orientações completas sobre o sistema, acesse o documento completo:
[Documentação](https://github.com/daeldev/PetTopia-Sistema-Desktop/blob/main/Documenta%C3%A7%C3%A3o/PetTopia%20Documenta%C3%A7%C3%A3o.pdf)
