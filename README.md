# Nimitz

1- Utilizando a biblioteca https://jsoup.org/, você deve ser capaz de ler e armazenar em um banco de dados de sua escolha os status dos serviços de nota fiscal eletrônica por estado, acessando a página http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx.<br/>

2- Desenvolva um job que seja executado a cada 5 minutos para armazenar um histórico de status dos serviços.<br/>
R: A classe <em>VerifyStatusController</em> é responsável pela execução do <em>job</em>.

3- Retornar por rest os status atual dos serviços por estado.<br/>
http://localhost:8080/status/

4- Retornar por rest o status atual do serviço filtrando por estado.<br/>
http://localhost:8080/status/pr

5- Retornar por rest os status dos serviços por estado filtrando por data.<br/>
http://localhost:8080/status/data/17-11-2022

6- Retornar por rest qual estado teve mais indisponibilidade de serviço.<br/>
