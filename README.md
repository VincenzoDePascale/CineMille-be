# CineMille-be

Questo progetto è un backend sviluppato in Java Spring Boot  che consiste nell'implementazione del lato backend di un'applicazione web per la gestione di un cinema proposto per un colloquio con l'azienda Lascaux.

## Gestione del Backend

Entity:
- **Sala**, **Film**, **Programmazione**: queste sono la base del progetto, sia sala che film sono stati collegati con un @OneToMany a programmazione, in modo da creare quest'ultimo oggetto con tutti i dati utili. Programmazione invece include questi due elementi ed aggiunge i dati di inizio e fine programmazione, ed un orario.

I ruoli presenti in auth sono 3 in vista di future implementezioni, attualmente viene utilizzato solo l'Admin, che consente di accedere all'area riservata per questo all'avvio dell'applicazione viene generato, se non è presente, un ADMIN con questi dati:

username: admin;
email: admin@ex.it;
password: PW_admin;

## Come avviare l'applicazione

Segui questi passaggi per utilizzare l'applicazione:

1. Scarica entrambe le repository.
2. Avvia il tuo IDE. (è stato scritto in Eclipse).

Per continuare, segui le istruzioni presenti nella parte frontend. Puoi trovare il frontend del progetto a questo [link](https://github.com/VincenzoDePascale/cinemille-fe).

## Collection Postman

è presente nella cartella "PostmanCollection" l'intera collezione di endPoint creati per questo progetto, non tutti sono stati implementati nella parte frontend.

## Tecnologie utilizzate

- java, spring boot
- postgrSQL
