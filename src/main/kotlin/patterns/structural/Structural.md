## Decorator

[Problem kompozycji funkcjonalności](decorator%2FDecoratorProblem.kt)

[Rozwiązanie przy użyciu wzorca](decorator%2FDecoratorSolution.kt)

## Adapter

Adapter przydaje się wtedy, gdy chcemy dostosować kod jednej części systemu, do drugiej. Przykładowo w momencie,
gdy nasza klasa nie jest kompatybilna z jakąś otwartką biblioteką, lub kodem Legacy. W przypadku
kodu legacy, często nazywa się ten wzorzec ACL czyli Anti corrupion layer

[Przykład w Kodzie](adapter%2FNavigationAttraction.kt)

## Bridge

Wzorzec Brdige przydaje się w przypadku źle zaprojektowanych struktur dziedziczenia.
Przede wszystkim w przypadku tak zwanej eksplozji kombinatorycznej, czyli sytuacji, w której
dodatkowa jedna funkcjonalność biznesowa wymaga stworzenia kilku lub nawet kilkunastu dodatkowych klas

#### Gwiezdne wojny

[Pokaz problemu](bridge%2FinRealLife%2FMessWithoutBridge.kt)

[Pokaz rozwiązania](bridge%2FinRealLife%2FBridgeImplementation.kt)

#### Prawdziwy kod

[Pokaz problemu](bridge%2FinRealCode%2FMessWithoutBridge.kt)

[Diagram problemu](bridge%2FBridgeProblem.uml)

[Pokaz rozwiązania](bridge%2FinRealCode%2FBridgeImplementation.kt)

[Diagram rozwiązania](bridge%2FBridgeResult.uml)

## Composite

[Composite dla ulepszenia walidacji z poprzedniego kroku](composite%2FPaymentCompositeValidation.kt)

[Zaawansowane opcje komponowania](composite%2FPaymentComplexCompositeValidation.kt)

[DSL ze wzorca Composite](composite%2FCompositeToDSL.kt)

