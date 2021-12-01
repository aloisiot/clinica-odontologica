# Clínica Odontologica

Aplicação desenvolvida em **Java** para a disciplina Back End i, consiste em uma **REST API** para um sistema de cadastro de uma clinica odontológica.

## Ferramentas
- **Spring MVC**: Framework usado na construção da Web API com uso dos padrões **MVC**;
- **MySQL**: Banco de dados relacional escolhido para persistir os dados;
## Endpoints
- **Consulta**:
  - **consulta/pacienteId/{pacienteId}/dentistaId/{dentistaId}** -> Cadastra uma nova consulta usando o ID de um paciente e o ID de um dentista expecificados no path da URL;
  - **/consulta** - > \[ GET \] Retorna uma lista contendo  todas as consultas registradas;
  -  **/consulta/{id}** - > \[ GET \] Retorna uma consulta com base no Id expecificado no path da URL;
  -  **/consulta/{id}** - > \[ DELETE \] Remove o registro de uma consulta com base no Id expecificado no path da URL;

- **Paciente**:
  - **/paciente** -> \[ POST \] Cadastra um novo paciente (requer um json no corpo da requisição com os dados do paciente);
  - **/paciente** -> \[ GET \] Retorna uma lista contendo todos os pacientes registrados;
  - **/paciente/{id}** -> \[ GET \] Retorna um paciente com base no Id expecificado no path da URL;
  - **/paciente** -> \[ PUT \] Atualiza o registro de um paciente (requer um json no corpo da requisição com os dados do paciente);
  - **/paciente/{id}** -> \[ DELETE \] Remove o registro de um paciente com base no Id expecificado no path da URL;

- **Dentista**:
  - **/dentista** -> \[ POST \] Cadastra um novo dentista (requer um json no corpo da requisição com os dados do dentista);
  - **/dentista** -> \[ GET \] Retorna uma lista contendo todos os dentistas registrados;
  - **/dentista/{id}** -> \[ GET \] Retorna um dentista com base no Id expecificado no path da URL;
  - **/dentista** -> \[ PUT \] Atualiza o registro de um dentista (requer um json no corpo da requisição com os dados do paciente);
  - **/dentista/{id}** -> \[ DELETE \] Remove o registro de um dentista com base no Id expecificado no path da URL;