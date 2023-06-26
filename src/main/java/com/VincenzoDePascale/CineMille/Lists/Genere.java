package com.VincenzoDePascale.CineMille.Lists;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Genere {
	
	ANIMAZIONE("animazione", "Film di animazione, indipendentemente dall’oggetto animato (disegni o pupazzi) (es.: Nightmare before Christmas; La spada nella roccia); include i film a tecnica mista."),
	AVVENTURA("avventura", "Genere cinematografico incentrato sull’avventura e sull’azione, dove l’importante non è la trama in sé, bensì il ritmo della narrazione. Generalmente i protagonisti si trovano a vivere avventure paradossali, talvolta irreali, impersonando l’eroe di turno (es.: Alla ricerca della pietra verde; Trappola di cristallo; Indiana Jones). Sono compresi quei film d’avventura non riconducibili ad altri generi (es. fantascienza, western…). In questi casi si utilizza il genere specifico."),
	BIOGRAFICO("biografico", "Genere cinematografico incentrato sulla figura di un uomo e/o di una donna realmente esistiti. L’intento è quello di narrare la vita, le imprese di un personaggio che si è distinto durante la propria esistenza. Personaggi che hanno segnato, o talvolta cambiato la storia; siano essi uomini politici, sportivi, scienziati ecc. Possono rientrare in questo genere film quali Alì, Michael Collins."),
	CAPPA_E_SPADA("cappa e spada", "Genere cinematografico incentrato sulle avventure di un protagonista particolarmente abile nel destreggiarsi con la spada e quindi in grado di imporre i principi della giustizia e della morale trasgrediti dal cattivo di turno. Il Cappa e spada abbraccia un periodo storico assai vasto, che solitamente va dal Medioevo al Settecento, ma si distingue dal genere storico perché tende apertamente a privilegiare l'immaginazione e l'invenzione rispetto alla ricostruzione storica. Lo sfondo e gli avvenimenti storici, che possono essere presenti, diventano un puro pretesto narrativo, un semplice supporto su cui inserire gesta e imprese che non hanno nulla di verosimile.\r\n"
			+ "Sin dall'epoca del muto Hollywood ha ampiamente sfruttato questo genere. Citiamo Il segno di Zorro (1920), Robin Hood (1926) e La maschera di ferro (1929).\r\n"
			+ "Coll'avvento del sonoro il genere continua a prosperare con successo. Citiamo Capitan Blood (1935) e La leggenda di Robin Hood (1938), Il segno di Zorro (1940) (dai quali si coglie la tendenza tipica del Cappa e spada a riproporre gli stessi personaggi), La rosa nera (1950), Scaramouche, Il prigioniero di Zenda (1952).\r\n"
			+ "A cominciare dagli anni Sessanta il genere va incontro ad una crisi che negli anni Ottanta lo porta praticamente all'estinzione (non si può però non ricordare l'ironica versione di R. Lester della saga dumasiana: I tre moschettieri, 1973, e Milady, 1975). Solo nel decennio Novanta si assiste ad una parziale ripresa, più episodica che legata ad una vera e propria rinascita del genere: Corsari (1994), La maschera di ferro (1998)."),
	CATASTROFICO("catastrofico", "Genere cinematografico incentrato su una catastrofe naturale o su un disastro provocato, più o meno volontariamente, dall'intervento dell'uomo. Spesso questo genere subisce delle interferenze da parte di altri, quali il Fantasy e l'Horror, anche se a rigore bisognerebbe considerare appartenente al Catastrofico solo quei film che rispettano i canoni della verosimiglianza.\r\n"
			+ "Alla fine si ristabilisce sempre l'ordine turbato dalla catastrofe, costringendo tuttavia lo spettatore ad una riflessione sui pericoli insiti in una gestione della tecnologia e in un rapporto con la natura privo di limiti e cautele.\r\n"
			+ "Fra i titoli più significativi di questo genere, che comporta spesso un notevole investimento economico per garantire il necessario livello spettacolare, ricordiamo Uragano, Il diavolo alle quattro (1961), L'avventura del Poseidon (1972), L'inferno di cristallo (1974), Lo squalo (1975), Dante's Peak (1997), Titanic (1997)."),
	COMICO("comico", "Genere finalizzato a causare la risata e il divertimento dello spettatore attraverso il ricorso al cosiddetto gag gestuale e/o verbale. Vengono cioè proposte situazioni e dialoghi assolutamente inconsueti e improbabili nella quotidianità, intesi a sovvertire le normali modalità di comportamento e espressione. Il genere comico poi, a differenza della Commedia, cui per certi versi è imparentato, infrange spesso le leggi della verosimiglianza, facendo ricorso a figure quali l'iperbole e la reiterazione e privilegiando il gusto del ridicolo e del paradosso.\r\n"
			+ "Questo genere nasce con il Cinema stesso (il primo film dei Lumière, L’arroseur arrosé, è un comico) e nei suoi primi anni di vita, all'epoca del muto, il comico gode di grande diffusione e popolarità (pensiamo alle famose comiche finali).\r\n"
			+ "Esso è da sempre collegato ad attori specializzati nel ruolo comico e che nella loro carriera difficilmente hanno interpretato personaggi seri. Citiamo su tutti B. Keaton, C. Chaplin, H. Langdon, S. Laurel e O. Hardy, I fratelli Marx, J. Lewis, M. Brooks in America, J. Tati e L. de Funès in Francia, Totò e R. Benigni in Italia.\r\n"
			+ "Rientra a pieno titolo nel comico la parodia, che propone un capovolgimento in chiave grottesca di generi seri. E' il caso di film come Le folli notti del Dottor Jerryll (1963), Frankenstein Junior (M. Brooks)."),
	COMMEDIA("commedia", "Genere cinematografico privo di asprezze drammatiche e caratterizzato da dialoghi brillanti e situazioni divertenti, la commedia cinematografica affonda le proprie radici nell'antica commedia greca per arrivare al repertorio shakespeariano (La bisbetica domata è considerata una specie di prototipo) e al Vaudeville francese.\r\n"
			+ "Essa ha conosciuto un grande sviluppo nella Hollywood degli anni trenta e quaranta, dove ha incontrato una particolare fortuna il sottogenere della Commedia sofisticata, ambientata nell'alta società, fra ricchi, aristocratici, gran dame, in un'atmosfera di raffinatezza e artificio, di cui spesso viene smascherata la vacuità (tra i maestri di questo genere ricordiamo E. Lubitsch, G. Cukor, F. Capra).\r\n"
			+ "In Italia ad imitazione di questo modello si affermò negli anni trenta la Commedia dei telefoni bianchi (spesso ispirata a pièce teatrali ungheresi) senza mai raggiungere però il livello dei film d'oltreoceano. Di maggior rilievo invece la Commedia piccolo-borghese di M. Camerini che durante il ventennio fascista si contrappose alla retorica altisonante del Cinema di regime.\r\n"
			+ "Un discorso a parte merita infine la Commedia all'italiana, sorta nel nostro paese all'inizio degli anni sessanta, nella quale il tema amoroso perde la sua centralità per lasciar posto ad una satira di costume sapida e pungente, che rende sovente amaro e malinconico il sorriso (tra i maestri di questo genere ricordiamo M. Monicelli, D. Risi, E. Scola, A. Pietrangeli).\r\n"
			+ "In questi ultimi anni si è affermata negli Stati Uniti un nuovo tipo di commedia, che potremmo definire Commedia giovanile, basata sulle traversie sentimentali e i dilemmi esistenziali di giovani protagonisti che si affacciano alla vita dopo le scuole o l'università. Pur esprimendo spesso il disagio vissuto dalle nuove generazioni, questo genere non sconfina mai, se non raramente, nella drammaticità e propone dialoghi arguti e situazioni divertenti, comunicando un senso di leggerezza narrativa (Singles. L'amore è un gioco, 1992, Giovani, carini, disoccupati, 1994, Parlando e sparlando, 1995)."),
	DRAMMATICO("drammatico", "Genere basato sui rapporti umani, caratterizzati da vicende tragiche, quasi mai a lieto fine (es.: La signora della porta accanto; Film Blu; La stanza del figlio)."),
	EROTICO("erotico", "Genere nel quale la rappresentazione dell'atto sessuale non è necessariamente esplicita, ma suggerita dal contesto."),
	FANTASCIENZA("fantascienza", "Genere cinematografico basato su vicende ambientate in un futuro lontano o imprecisato, sulla Terra o su altri pianeti, dominato da macchine e congegni tecnologici frutto di fantasia e al presente inesistenti, ma la cui realizzazione futura non può essere esclusa a priori (uno dei primi film di Fantascienza Il viaggio nella luna, ispirato ad un romanzo di Jules Verne, di G. Méliès del 1902 immaginava uno sbarco umano sul nostro satellite che si è poi verificato sessantasette anni dopo). In In qualche caso il genere ha subito interferenze da parte dell'Horror (L'invasione degli Ultracorpi 1956, La cosa 1982, Indipendence Day, 1997) e da parte del Horror e del Cappa e spada (Guerre stellari, 1978, e L'impero colpisce ancora, 1980). Solo di recente con film come Incontri ravvicinati del terzo tipo (1977) e E.T. L'extraterrestre (1982), la figura dell' extraterrestre è stata profondamente umanizzata, presentandosi addirittura come migliore rispetto all'uomo.\r\n"
			+ "Una particolare articolazione del genere è costituita dalla cosiddetta Fantascienza filosofico-esistenziale, nella quale sull'intreccio appassionante e avvincente prevale la riflessione sul senso della vita e il destino dell'uomo. E' il caso di film come 2001: Odissea nello spazio (1968), Solaris (1971), Blade Runner (1982)."),
	FANTASY("fantasy", "Genere cinematografico dai numerosi filoni, tutti accomunati da una costante: il soprannaturale e l'inverosimile non irrompono minacciosi e sconvolgenti in un contesto realistico (come nell'Horror), ma costituiscono elementi universalmente accettati come normali di un contesto realistico oppure s'identificano essi stessi con un contesto nel quale tutto può accadere, che perde in questo caso ogni parvenza di realismo (pensiamo, per esempio, ad animali che parlano, tappeti che volano, bacchette magiche, ecc., il tutto senza suscitare stupore o meraviglia fra i personaggi, anzi accettato come assolutamente normale). Il fine non è più spaventare lo spettatore, ma suscitare in lui stupore e meraviglia.\r\n"
			+ "I film attribuibili a questo genere possono essere raggruppati in 3 filoni.\r\n"
			+ "\r\n"
			+ "Il Fantastico fiabesco, spesso ispirato a classici della letteratura fiabesca, dove tutto risulta inserito in una dimensione inverosimile e nulla risulta reale (Il mago di Oz, 1939; La storia infinita, 1985; Il barone di Munchaushen, 1989, Legend, 1985).\r\n"
			+ "Il Fantastico commedia, dove una commedia d'ambientazione realista o quasi si apre a situazioni irreali, che convivono con fatti e personaggi plausibili sul piano della verosimiglianza (Accadde domani, 1944; Il cielo può attendere, 1943; Miracolo a Milano, 1951; Harry Potter e la pietra filosofale, 2001).\r\n"
			+ "Il Fantastico mitologico-epico, ispirato alla tradizione mitologica antica o al repertorio epico-cavalleresco medioevale, filone questo assai simile al precedente e caratterizzato dall’intreccio tra Storia e Leggenda risolto a favore di quest’ultima (Maciste nella valle dei re, 1960; Excalibur, 1980; Conan, il barbaro, 1982; Lady Hawke)."),
	GANGSTER("gangster", "Genere cinematografico tipicamente statunitense, nato dopo il 1929 all’inizio della grande crisi economica che sconvolge l’America. Esso s’ispira alle imprese della malavita organizzata che a cominciare dagli anni venti aveva imperversato nelle metropoli, corrompendo profondamente il tessuto morale e civile della società.\r\n"
			+ "Possiamo essenzialmente distinguere due tipi di film gangster. In entrambi il protagonista (o i protagonisti) è un delinquente, verso cui si indirizzano le simpatie del pubblico e la cui parabola si conclude con la morte, ma con una differenza che concerne la natura e la finalità della sua attività delinquenziale:\r\n"
			+ "\r\n"
			+ "l’eroe (o se si preferisce l’antieroe) è il boss di una banda gangsteristica che si arricchisce con attività illecite (contrabbando, spaccio, racket, ecc..) giovandosi di una vasta rete di complicità. L’antagonista non è rappresentato tanto dalle forze dell’ordine, spesso complici e corrotte, quanto dalle gang rivali con cui lotta per il controllo del territorio. Citiamo tra i tanti i seguenti titoli: Piccolo Cesare (1930), Pericolo pubblico (1931), Scarface (1932) e in anni più recenti la trilogia del Padrino (I, II e III, 1972, 1974, 1992;\r\n"
			+ "L’eroe non è un boss mafioso e quindi non è a capo di nessuna organizzazione, ma è un isolato che agisce individualmente e la sua attività criminosa non si basa sui traffici, ma su colpi più o meno audaci, prevalentemente rapine alle banche, per svolgere le quali può unirsi ad altri malviventi, costituendo una banda che però e destinata a sciogliersi una volta finita l’impresa criminosa; in altri film instaura un connubio amoroso con una compagna che lo aiuta nelle sue azioni. In questo caso l’antagonista è la polizia.\r\n"
			+ "Citiamo tra i tanti film: Rapina a mano armata (1956), Gangster Story (1967), Getaway (1972), Heat (1995). Questa versione del Gangster ha trovato epigoni soprattutto in Francia. Citiamo: Grisbi (1954), Bob, Le Flambeur (1956) e Le cercle rouge (1970).\r\n"
			+ "Il genere Gangster per le sue caratteristiche presenta parecchi punti di contatto con il Giallo, specie in versione Noir e Thriller, e in alcuni casi si ibrida e confonde con esso."),
	GIALLO("giallo", "(giudiziario, poliziesco, thriller, noir) Con questo termine si designa in Italia un genere cinematografico (ma anche letterario) incentrato su un' azione criminosa il cui responsabile viene scoperto e variamente punito da un uomo della legge o più genericamente dalle forze dell'ordine. Negli altri paesi del mondo al termine giallo si sostituisce quello di Poliziesco.\r\n"
			+ "Si distinguono più sottogeneri accorpabili in tre grandi categorie:\r\n"
			+ "\r\n"
			+ "Il Giallo ad enigma, legato al romanzo poliziesco di scuola anglosassone (Agatha Christie, Conan Doyle, etc.), dove l'identità del colpevole, le sue motivazioni e le circostanze dell'atto criminoso vengono svelate solo alla fine. L'accento è posto soprattutto sull'intreccio e sulla capacità di intuizione e deduzione di chi investiga (Assassinio sull'Orient Express, 1974; Assassinio sul Nilo, 1978).\r\n"
			+ "Il Giallo-noir, legato al romanzo poliziesco di scuola statunitense (Raymond Chandler, Dashiell Hammett, etc.), dove pure può esistere un enigma da svelare, ma l'accento è posto sull'ambiente, quasi sempre moralmente corrotto e degradato, che fa da sfondo alla vicenda, e sulle psicologie dei personaggi (Il mistero del falco, 1941, Il grande sonno, 1946; Chinatown, 1974; Brivido caldo, 1981; L.A. Confidential, 1997).\r\n"
			+ "Il Giallo-suspence, privo di illustri riferimenti letterari e creazione prevalentemente cinematografica, dove viene svelata subito, o quasi, l'identità del colpevole, determinando un forte sentimento di apprensione nello spettatore relativo a ciò che di criminoso egli può ancora compiere o di incertezza relativo alla sua sorte finale. E' questo il meccanismo narrativo privilegiato da un maestro del genere come A. Hitchcock (suoi Nodo alla gola, 1948, Delitto per Delitto, 1954, La finestra sul cortile, 1954).\r\n"
			+ "Strettamente collegato con quest'ultima versione del giallo, di cui porta alle estreme conseguenze alcune caratteristiche, è il Thriller (che certuni considerano un genere a parte). In esso la soluzione dell'enigma appare del tutto secondaria rispetto alle azioni e agli eventi, sovente incentrati sulle vicissitudini di uno o più protagonisti la cui vita è messa a repentaglio da criminali, killer, pazzi omicidi ecc.. Ciò che coinvolge è la sorte di chi si trova vittima di una situazione di eccezionale pericolosità. E' il caso di film come Duel (1971), Shining (1980), Distretto 13: le brigate della morte (1976), Il maratoneta (1976); appartengono a questa filiazione del giallo molti film dell'italiano D. Argento.\r\n"
			+ "Altra derivazione è il film giudiziario, che si svolge quasi interamente in un'aula di giustizia e che ha come protagonisti avvocati e pubblici ministeri, soprattutto i primi, intelligenti e acuti oltre il comune nel salvare clienti che sembrano condannati in partenza. Si tratta di un genere prevalentemente statunitense, ispirato ad un'ottimistica fiducia nel trionfo finale della giustizia. Tra i maggiori esemplari ricordiamo titoli come La parola ai giurati (1957), Testimone d'accusa (1957), Anatomia di un omicidio (1959), Il buio oltre la siepe (1963), Il verdetto (1982) Pazza (1987). Negli anni Novanta si è affermato un genere giudiziario di tipo particolare, nel quale non si tratta più di salvare un innocente ingiustamente accusato smascherando il vero colpevole, ma di garantire un equo risarcimento a chi ha subito danni da grandi industrie o non è stato adeguatamente risarcito dalle compagnie di assicurazione (Philadelphia, 1994, L'uomo della pioggia, 1998), tale tipologia non è da considerare GIALLO, ma gli si attribuirà il genere opportuno."),
	GUERRA("guerra", "Genere cinematografico incentrato sulla ricostruzione di eventi guerreschi appartenenti alla storia del Novecento, in particolare i due conflitti mondiali e quelli della Corea e del Vietnam. E’ proprio questo riferimento ad eventi storici relativamente recenti a far sì che il genere bellico si distingua da quello storico propriamente detto, anche se ovviamente pure i film bellici hanno un carattere storico e potrebbero essere ascritti a questo genere. All’interno del bellico è necessario operare una fondamentale distinzione tra un bellico epico-eroico e un bellico antimilitarista. Il bellico epico-eroico propone una netta distinzione fra chi combatte in nome del bene e della giustizia, ed è fortemente motivato al cambiamento e portato ad atti di estrema audacia e coraggio, e un nemico rappresentato in termini molto negativi. All’interno di questo indirizzo sarebbe bene però distinguere tra due tendenze: una di aperta propaganda militarista, intrisa di retorica ed enfasi (Lo squadrone bianco, 1936 e L’assedio dell’Alcatraz, 1940, L’uomo della croce, 1942, Berretti verdi, 1968) e l’altra orientata, pur senza mettere in discussione la logica della guerra e manifestando ammirazione per il valore mostrato dai combattenti e il loro spirito di sacrificio, verso qualche inflessione di dolore e sgomento per le sofferenze che il conflitto comporta (La grande parata, 1925, Iwo Jima, 1949, Attack!, I giovani leoni, 1958, La grande guerra, 1959, Quell’ultimo ponte, 1977, Il grande uno rosso, 1980, Salvate il soldato Ryan, 1998).\r\n"
			+ "Il bellico antimilitarista, pur nel differenziarsi negli approcci e nelle posizioni ideologiche, esprime una condanna della guerra, di cui mette in evidenza l’assurdità e l’insensatezza (All’ovest niente di nuovo, 1930, Westfront, 1930, L’arpa birmana, 1956, Orizzonti di gloria, 1957, Per il re e per la patria, 1964, Uomini contro, 1970, Full metal jacket, 1987, La sottile linea rossa, 1998)."),
	HORROR("horror", "(Orrifico). Genere cinematografico finalizzato a suscitare sentimenti di paura e angoscia nello spettatore e basato sull'irrompere nella normalità quotidiana di esseri e fatti sovrumani e sconvolgenti che minacciano l'esistenza della comunità. L'elemento sovrumano si presenta quasi sempre sottoforma di mostro irreale, ripugnante nell'aspetto fisico e malvagio nelle intenzioni (un vampiro, un licantropo, uno zombie, un demone, ecc..), in continuità con la tradizione della letteratura gotica dell'Ottocento. Genere erroneamente considerato secondario e di minor valore rispetto ad altri, l'Horror è stato ampiamente rivalutato in questi ultimi anni, specie per quel che riguarda la sua ricchezza di significati e allusioni relativamente alla compresenza nella natura umana di Bene e Male e alla materializzazione dei lati più oscuri e inesplorati del nostro inconscio.\r\n"
			+ "Dopo i primi esemplari europei (Il carretto fantasma, 1921, Il gabinetto del Dottor Caligari, 1920, Nosferatu il vampiro, 1922, ecc..) il genere si consolida e sviluppa negli Stati Uniti negli anni Trenta e Quaranta (Dracula, 1930, Frankenstein, 1935, Il bacio della pantera,1942, ecc..).\r\n"
			+ "E' questa la stagione più gloriosa dell'Horror, che si caratterizza spesso per film a basso costo di produzione (i cosiddetti B-Movies), con registi e soprattutto attori specializzati in questo settore del brivido (tra i secondi ricordiamo B. Karloff, B. Lugosi, L. Chaney).\r\n"
			+ "Negli anni Settanta e Ottanta si afferma una versione del genere Horror particolarmente truculenta e macabra, basata in gran parte sugli effetti speciali (il cosiddetto gore o anche splatter) e finalizzata a creare il massimo del raccapriccio nel pubblico (citiamo tra i tanti titoli i cicli della Casa e di Nightmare, anche se il capostipite del genere potrebbe esser considerato L'esorcista, 1973).\r\n"
			+ "Tipico degli ultimi anni è il fenomeno della cosiddetta ibridazione dell'Horror con altri generi, quali il Thriller e il Giallo, non saltuariamente incentrati sull'inverosimiglianza e la trasgressione delle leggi fisico-biologiche (è il caso di film quali Halloween, 1978)."),
	MUSICALE("musicale", "Genere cinematografico basato su testi che danno ampio spazio a brani cantati e/o danzati da attori (che sono prevalentemente cantanti e/o ballerini professionisti). Nato con il sonoro (il primo film sonoro, Il cantante di Jazz, 1927, appartiene a questo genere) il musical conosce il suo periodo d’oro negli anni ’40 e ’50 per poi decadere e gradualmente scomparire, tranne qualche eccezione, alla fine dei ’70.\r\n"
			+ "Se ne conoscono essenzialmente 3 variazioni:\r\n"
			+ "\r\n"
			+ "i brani cantati e/o danzati si inseriscono all’interno di un contesto di relativo realismo (dove cioè non si canta, ma si parla normalmente, e non si danza, ma ci si muove normalmente). Il canto e la danza sono credibili sul piano della verosimiglianza in quanto manifestazioni di personaggi che sono cantanti e ballerini di professione e che in determinati momenti della storia si esibiscono in quanto tali. Citiamo tra i tanti titoli: Scarpette rosse (1948), Gli uomini preferiscono le bionde (1953), Cabaret (1972), Chorus line (1985).\r\n"
			+ "I brani cantati e/o danzati si inseriscono all’interno di un contesto di relativo realismo, ma il canto e la danza non sono credibili sul piano della verosimiglianza, in quanto sono strumenti di comunicazione che i personaggi usano al posto della parola e della normale gestualità (all’improvviso, senza alcuna giustificazione narrativa, uno o più personaggi si mettono a cantare e/o danzare senza che ciò susciti il minimo stupore nei presenti, anzi la cosa viene considerata assolutamente normale). Citiamo tra i tanti titoli: La vedova allegra (1934), Un americano a Parigi (1951), Cantando sotto la pioggia (1952), My fair lady (1964), Grease (1978), Hair (1979), Tutti dicono I love you (1997).\r\n"
			+ "L’intero film è costituito da brani cantati e/o danzati, la parola e/o la normale gestualità è completamente abolita, il contesto perde ogni parvenza di realismo. E’ il tipo di musical che più si avvicina al modello ottocentesco del melodramma musicale. Tra i non tanti titoli citiamo: Jesus Christ Superstar (1973), Tommy (1975), Evita (1996).\r\n"
			+ "In Italia si segnala negli anni ’60 il filone dei cosiddetti musicarielli, film musicali appartenenti al caso 1 e 2 e incentrati sul protagonismo di cantanti di musica leggera molta in voga in quel periodo (Gianni Morandi, Rita Pavone, Al Bano, Caterina Caselli, ecc.) ai quali l’esile trama della sceneggiatura forniva spazi perché potessero esibirsi nelle loro performances canore.\r\n"
			+ "Nella categoria sono compresi i film incentrati su vicende legate all’ambiente della musica, purché considerati come fiction. Vanno distinti sia dai documentari, sia dai concerti e video musicali.\r\n"
			+ "Possiamo citare alcuni esempi abbastanza recenti che rientrano in questa categoria: The rose (1979), La grande truffa del rock’n’roll (1980), The Commitments (1991), The Doors (1991), Buena Vista Social Club (1998)."),
	POLITICO_SOCIALE("politico-sociale", "Genere cinematografico più italiano ed europeo che americano, che pone al centro del proprio interesse temi di attualità politica o storici.\r\n"
			+ "Quasi mai il Cinema politico (chiamato anche Cinema di impegno, politico o civile indifferentemente) è neutrale e nemmeno vuole esserlo, anzi esplicita con molta chiarezza la propria tesi, in alcuni casi si può parlare proprio di Cinema a tesi, la cui finalità è cioè quella di dimostrare una precisa posizione (vedi in proposito il Cinema del Realismo socialista e il Cinema di propaganda in generale). Strettamente collegato con il Cinema politico è il cosiddetto Cinema militante, in tutto simile al primo, se non fosse per il suo carattere prevalentemente documentarista, anziché di finzione, per una accentuata propensione propagandistica e soprattutto per il fatto che esso si muove al di fuori del circuito commerciale, indirizzandosi verso canali alternativi legati alle organizzazioni partitiche e politiche che hanno prodotto o commissionato il singolo film. Il Cinema militante ha conosciuto il suo periodo di maggior diffusione negli anni a cavallo del 1968.\r\n"
			+ "Il Cinema politico propriamente detto, invece, privilegia il film di finzione, spesso giovandosi di grandi budget e attori e registi di fama e senza mai dimenticare la dimensione spettacolare. Anch'esso ha conosciuto una stagione felice in coincidenza con gli anni sessanta e settanta, anche se i suoi antecedenti sono rinvenibili nel movimento del Neorealismo e del Realismo poetico francese.\r\n"
			+ "Tra i migliori esempi di Cinema politico italiano ricordiamo Le mani sulla città (1963) e Il caso Mattei (1971), La battaglia di Algeri (1966), La Cina è vicina (1967), Indagine su un cittadino al di sopra di ogni sospetto (1970), Trevico-Torino (1972), Maledetti vi amerò (1980), Il caso Moro (1986), Lamerica (1994), La seconda volta (1995).\r\n"
			+ "In Francia il Cinema politico ha avuto negli anni sessanta e settanta in J. L. Godard uno dei massimi interpreti (vedi Nouvelle Vague). Da ricordare anche, sempre a proposito del Cinema transalpino, ma nell'alveo di una tradizionale convenzionalità espressiva, C. Costa Gavras con i suoi Z. L'orgia del potere (1969), La confessione (1970), Missing (1982) e Music Box (1989).\r\n"
			+ "Per la Gran Bretagna un nome su tutti, quello di K. Loach, con Riff-Raff (1991), Piovono pietre (1993), Terra e Libertà (1995).\r\n"
			+ "Negli Stati Uniti il Cinema politico ha vissuto il suo periodo d'oro in coincidenza con la stagione della New Hollywood degli anni Settanta. Oggi il maggior regista politico americano è O. Stone, di cui ricordiamo Salvador (1986), Platoon (1986), Nato il quattro luglio (1989), JFK. Un caso ancora aperto (1991), Nixon. Gli intrighi del potere (1995)."),
	SPIONAGGIO("spionaggio", "(Spy story). Genere cinematografico che ha come protagonisti agenti segreti e le loro azioni, sullo sfondo di complessi intrighi internazionali nei quali ogni mezzo diventa lecito. La nascita del genere si lega al profilarsi della minaccia nazista e alla successiva guerra mondiale (Il club dei trentanove, 1935, Il prigioniero di Amsterdam, 1940, e Notorius, 1946, tutti di A. Hitchcock, La casa della novantaduesima strada, 1945), per trovare negli anni Cinquanta e Sessanta uno scenario ideale nel clima politico della guerra fredda (La spia che venne dal freddo, 1965, Lettera al Cremlino, 1970, I tre giorni del Condor, 1975).\r\n"
			+ "Una considerazione a parte meritano due agenti speciali creati dal genere spionistico, che hanno dato vita a due famosi personaggi con tanto di ciclo personalizzato: James Bond, l'agente 007 e il suo opposto Harry Palmer (Ipcress, 1965, Funerale a Berlino, 1966).\r\n"
			+ "Recentemente è apparso sugli schermi Ronin (1998), una malinconica riflessione sul tramonto inesorabile del genere spionistico."),
	SPORTIVO("sportivo", "Genere cinematografico basato su storie di campioni dello sport, che dedica ampio spazio a sequenze che mostrano performances sportive.\r\n"
			+ "E' utile dividere i film appartenenti a questo genere in due categorie: quelli di pugili e tutti gli altri, dedicati a sport diversi.\r\n"
			+ "I film di pugili sono accomunati da precise caratteristiche: un giovane, prevalentemente proveniente dai bassifondi o comunque di umili origini, si afferma come campione del ring, passando di vittoria in vittoria, finché non s'imbatte nelle dure leggi del business sportivo che gli impongono di accettare incontri truccati. A questo punto, così come è stata rapida l'ascesa, altrettanto fulminea è la caduta. Il film di pugilato così diventa spesso metafora del cosiddetto sogno americano.\r\n"
			+ "Tra i classici del genere che, più o meno, propongono questo schema ricordiamo Il campione (1931), Il sentiero della gloria (1942), Anima e corpo (1947), Il grande campione (1949), Toro scatenato (1980). Anomalo rispetto a quest'impostazione il ciclo di Rocky.\r\n"
			+ "Vi sono poi i film dedicati ad altri sport, che sono prevalentemente destinati ad un lieto fine, risolvendosi in un'esaltazione delle virtù atletiche e morali dei protagonisti sportivi. Citiamo in proposito All American Boys (1979), Momenti di gloria (1979) e anche l'italiano Il ragazzo di Calabria (1987)."),
	STORICO("storico", "Genere cinematografico incentrato su eventi e personaggi storici. A volte l'intento è quello di una ricostruzione il più possibile vicino alla realtà dei fatti, più spesso invece prevale una libera rivisitazione degli avvenimenti, che sovente finiscono per intrecciarsi con elementi del tutto immaginari e romanzeschi.\r\n"
			+ "Alle origini è stato proprio il Cinema italiano a distinguersi in questo genere, con prodotti di grandi dimensioni spettacolari, come Quo vadis? (1912), Gli ultimi giorni di Pompei (1913), Cabiria (1914).\r\n"
			+ "Sarà il grande regista americano D. W. Griffith ad imitare l'esempio italiano con grandi kolossal come Nascita di una nazione (1914) e Intolerance (1916).\r\n"
			+ "Questi film aprono la strada alla politica hollywoodiana dei grandi investimenti nel genere storico, le cui caratteristiche diventano l'alto livello di spettacolarità e la grandiosità delle ricostruzioni d'epoca. Pensiamo a titoli come La regina Cristina (1933), La carica dei Seicento (1936) e soprattutto Via col vento (1939); nel dopoguerra a titoli come Guerra e pace (1956), Spartacus (1960) e Cleopatra (1963) e in questi ultimi anni Braveheart (1994), Schindler's List (1994), Michael Collins (1996).\r\n"
			+ "Per quel che riguarda il Cinema italiano possiamo ricordare la superproduzione del regime fascista Scipione l'Africano (1937), i due film di R. Rossellini Viva L'Italia (1960) e La presa di potere di Luigi XIV (1966) e la grande saga Novecento I-II (1976).\r\n"
			+ "Possono trovare inserimento in questo genere i film d'argomento biblico-religioso, come Sansone e Dalila (1948) e I dieci comandamenti (1956), La tunica (1953), Sodoma e Gomorra (1961), La Bibbia (1966) ecc.."),
	WESTERN("western", "Genere tipico del Cinema americano e quasi esclusivamente cinematografico, nasce come rielaborazione mitica di un fatto storico: la conquista dei territori dell'Ovest e la nascita della nazione americana.\r\n"
			+ "A cominciare dagli anni Cinquanta, pur nella fedeltà ai suoi presupposti di fondo, il genere acquista inflessioni più malinconiche e problematiche (c'è chi parla di Western del crepuscolo), E' questo il caso di registi come A. Mann, W. Wellman, N. Ray, F. Zinneman, G. Stevens ed altri.\r\n"
			+ "Negli anni sessanta e settanta un genere già in aperta crisi viene rivitalizzato da una polemica rivisitazione alimentata dal clima di contestazione di quegli anni. Il genere si confronta così maggiormente con la verità storica, senza per altro abbondare la dimensione leggendaria, e si finisce per mettere l'accento sulle brutalità, le violenze, le ingiustizie e lo sfruttamento di cui è intrisa la conquista del West. In particolare si riconosce che gli indiani sono stati vittime di uno spietato genocidio.\r\n"
			+ "Tra i tanti emerge soprattutto il nome del regista S. Peckinpah.\r\n"
			+ "Al di fuori degli Stati Uniti si segnala nell'Italia degli anni sessanta lo sviluppo del Western all'italiana (citiamo per tutti S. Leone), che riutilizza i materiali del genere secondo un'ottica nuova e decisamente rivoluzionaria: alla base dell'agire dell'eroe non c'è più la fedeltà a precisi imperativi morali, ma la sete di guadagno, la violenza viene di molto esplicitata ed enfatizzata, sul tutto serpeggia una vena vagamente parodistica e un gusto accentuato per l'eccesso.\r\n"
			+ "Di rilievo negli ultimi decenni la riproposta in chiave crepuscolare-romantica dell'attore-regista C.Eastwood, con film come Il cavaliere pallido (1985) e Gli spietati (1993), dove la nostalgia per l'epopea del genere Western si mescola alla malinconica consapevolezza del suo tramonto definitivo.");
	
	private String genere;
	private String descrizione;
	
	private Genere(String genere, String descrizione) {
		this.genere = genere;
		this.descrizione = descrizione;
	}
	
	@JsonValue
    public Map<String, Object> createTecnologiaSala() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("genere", genere);
        result.put("descrizione", descrizione);
        return result;
    }
	
	public static Genere getEnumByData(String data) {
        for (Genere gen : Genere.values()) {
            if (gen.getGenere().equalsIgnoreCase(data)) {
                return gen;
            }
        }
        throw new IllegalArgumentException("Nessun genere trovato con questo nome: " + data);
    }
	
	private String getGenere() {
		return genere;
	}
	
	private String getDescrizione() {
		return descrizione;
	}

}