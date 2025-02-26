Uppgift 1: Koppla på grafiskt gränssnitt

Börja med att forka och klona repot https://github.com/oopd-gu-chalmers/lab2

Links to an external site.. Där hittar ni bland annat några nya klassfiler. Notera att de nya klasserna har många allvarliga brister vad gäller både design och implementation. Se till att ni får med "pics"-mappen, bilderna och de nya klass-filer ni ser i repot.

CarController, CarView och DrawPanel utgör tillsammans ett grafiskt användargränssnitt till era fordonsklasser från laboration 1. Gränssnittet är skrivet av en tredje part som inte haft tillgång till vare sig kod, dokumentation eller designdokument för er lösning.

    Gör de eventuella (minimala) ändringar i CarController, CarView och DrawPanel som behövs för att det ska gå att använda tillsammans med er lösning från laboration 1. När ni är färdiga ska ni kunna köra CarController och se Volvo-bilen röra sig (genom att öka värdet på gasen och gasa).
    Notera att vi förutsätter att ni använder IntelliJ; se kommentarer i koden ifall ni vill använda något annat. Detta påverkar mest bilderna, eftersom ni måste skapa ett nytt package "pics" i "src"-mappen och lägga alla bilder där. För er som inte använder IntelliJ kan ni lägga bilderna i samma mapp som klass-filerna och ändra koden enligt instruktionerna.
    Se till att även bromsknappen är kopplad till bilen, så att den får effekt på er simulation (bromsvärdet får ni från samma snurra som gasen hämtar sitt värde ifrån). Ni måste se till att modellens tillstånd uppdateras, och sen anropar tillbaka till CarView via CarController.
    Volvon åker just nu ut ur rutan. Se till att när bilen nuddar en vägg så stoppar den helt, inverterar sin riktning och startar igen.
    Sätt in Saab95, Scania och deras respektive bilder med 100 pixlars avstånd i Y-led från varandra (alla avbildas ursprungligen med X=0). Koppla turbo-knapparna till Saaben och flakknapparna till Scania. Koppla "starta och stoppa alla bilar"-knapparna till bägge. Även dessa bilar ska förhindras att åka utanför rutan.
    Skapa en workshop för Volvo-bilar, och koppla denna till utritningen. Se till att när en Volvo-bil åker till (dvs "krockar med") verkstaden "lastas" den i verkstaden. Andra bilar ska inte lastas (välj själva hur ni vill hantera detta).

 Uppgift 2: Beroenden

    Rita upp ett UML-diagram över systemet i dess nuvarande skick, efter era förändringar ovan. Inkludera samtliga klasser, och samtliga interna beroenden mellan klasserna i UML-diagrammet. Skilj på association, usage dependency, generalisering och realisering. Ni behöver inte ha med alla metoder och fält, men inkludera det som behövs för att åskådliggöra designen; varför de beroenden som finns finns, och vilka ansvarsområden olika delar har. Ni får rita UML-diagrammet med vilket verktyg ni vill så länge resultatet är läsbart.
    Analysera de beroenden som finns med avseende på cohesion och coupling, och Dependency Inversion Principle.
        Vilka beroenden är nödvändiga?
        Vilka klasser är beroende av varandra som inte borde vara det?
        Finns det starkare beroenden än nödvändigt?
        Kan ni identifiera några brott mot övriga designprinciper vi pratat om i kursen?

 
Uppgift 3: Ansvarsområden

    Analysera era klasser med avseende på Separation of Concern (SoC) och Single Responsibility Principle (SRP).
        Vilka ansvarsområden har era klasser?
        Vilka anledningar har de att förändras?
        På vilka klasser skulle ni behöva tillämpa dekomposition för att bättre följa SoC och SRP?

 Uppgift 4: Ny design

    Rita ett UML-diagram över en ny design som åtgärdar de brister ni identifierat med avseende både på beroenden och ansvarsfördelning.
    Motivera, i termer av de principer vi gått igenom, varför era förbättringar verkligen är förbättringar.
    Skriv en refaktoriseringsplan. Planen bör bestå av en sekvens refaktoriseringssteg som tar er från det nuvarande programmet till ett som implementerar er nya design. Planen behöver inte vara enormt detaljerad. Se Övning 3: UML, static vs dynamic för ett exempel på en refaktoriseringsplan.
    Finns det några delar av planen som går att utföra parallellt, av olika utvecklare som arbetar oberoende av varandra? Om inte, finns det något sätt att omformulera planen så att en sådan arbetsdelning är möjlig?

 