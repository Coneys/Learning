## Static Factory Method

+ Używana zamiast konstruktora
+ Możliwość zwrócenia nulla
+ Możliwość zwrócenia podklasy danej klasy bazowej
+ Lepsze nazewnictwo dla wielu opcji utworzenia obiektu
  + Konwencja orNull w Kotlinie
+ Bardziej naturalne wykorzystanie wyjątków (konwencja nie rzucania wyjątku przez konstruktor)
+ Brak ograniczeń wydajnościowych (konwencja "szybkich" konstruktorów)
+ Ułatwione "cachowanie"
+ 