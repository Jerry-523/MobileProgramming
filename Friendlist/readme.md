## **Funcionalidades Principais**

1. **Exibição da Lista de Amigos**:
   - Mostra uma lista de amigos com informações como nome, email e idade.
   - Os itens são exibidos em uma lista vertical utilizando `RecyclerView`.

2. **Adicionar Amigos**:
   - Botão na parte inferior que abre um diálogo para inserir as informações do novo amigo.
   - Formulário com os campos:
     - **Nome**
     - **Email**
     - **Idade**
   - Opções de "Criar" (adicionar à lista) e "Cancelar".

3. **Excluir ou Enviar Email**:
   - Clique em um amigo da lista para abrir um diálogo com as opções:
     - **Enviar Email** (não implementado nesta versão, mas pode ser expandido).
     - **Deletar Amigo** (remove o amigo da lista).

4. **Menu de Configurações**:
   - Menu de três pontinhos na parte superior direita com a opção "Settings".
   - Exibe um `Toast` indicando que a funcionalidade de configurações ainda não foi implementada.

---

## **Como Usar o Aplicativo**

1. **Inicializar o App**:
   - A lista de amigos é inicializada vazia ou com amigos de exemplo.

2. **Adicionar Amigo**:
   - Clique no botão "Adicionar Amigo" na parte inferior da tela.
   - Preencha os campos no formulário e clique em "Criar".
   - O novo amigo aparecerá na lista.

3. **Excluir ou Enviar Email**:
   - Clique em qualquer amigo da lista.
   - Escolha "Deletar" para remover o amigo ou "Enviar Email" (a implementar).

4. **Menu de Configurações**:
   - Clique no menu no canto superior direito e selecione "Settings".
   - Um `Toast` será exibido.

---

## **Estrutura do Projeto**

1. **MainActivity**:
   - Gerencia a interface principal, a lista de amigos e o botão de adição.

2. **Friend**:
   - Classe modelo para armazenar informações dos amigos (nome, email, idade).

3. **FriendAdapter**:
   - `RecyclerView.Adapter` que vincula os dados à lista exibida.
   - Gerencia eventos de clique nos itens.

4. **Layouts**:
   - `activity_main.xml`: Layout principal com RecyclerView e botão.
   - `item_friend.xml`: Layout de cada item da lista.
   - `dialog_add_friend.xml`: Formulário para adição de amigos.

5. **Menus**:
   - `main_menu.xml`: Menu de configurações com a opção "Settings".

---

## **Possíveis Expansões**

- Implementar a funcionalidade de envio de email.
- Adicionar persistência de dados (SQLite, Room ou SharedPreferences).
- Melhorar a interface do menu de configurações.
- Adicionar opções de edição de amigos.
- Implementar suporte a imagens para cada amigo.

---

## **Requisitos Técnicos**

- **Android Studio**: Versão 4.0 ou superior.
- **API Level**: Compatível com Android 5.0 (API 21) ou superior.

---
