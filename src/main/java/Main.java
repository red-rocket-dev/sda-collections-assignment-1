import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        1. Utworz liste (dowolna implementacja) przechowujaca String
        2. Dodaj do niej elementy: Ania, Kasia, Ania, Tomek, Michal, Kasia, Paweł, Zbych
        3. Wstaw pomiedzy Anie i Tomka Klaudię (policz, który to indeks i w to miejsce wstaw imię)
           - pomocna bedzie metoda lista.add(<indeks pod ktorym wstawic>, <co wstawic>
        4. Przenieś elementy do innej kolekcji, która nie przechowuje duplikatów
           - przydatna będzie metoda addAll z tej "innej kolekcji"
        5. Usuń element Ania
        6. Wypisz tylko elementy, których ostatnia litera to "a"
         */
        List<String> names = new LinkedList<>();

        names.add("Ania");
        names.add("Kasia");
        names.add("Ania");
        names.add("Tomek");
        names.add("Michal");
        names.add("Kasia");
        names.add("Paweł");
        names.add("Zbych");

        //names.add(3, "Klaudia");
        //albo tak (indexOf nie mozemy uzyc, bo tylko znalazloby wystapienie Tomka albo Ani, nie ich oboje)
        ListIterator<String> namesListIterator = names.listIterator();
        String previous = null;
        String next;
        while (namesListIterator.hasNext()) {
            next = namesListIterator.next();
            if("Ania".equals(previous) && "Tomek".equals(next) ) {
                namesListIterator.previous();
                namesListIterator.add("Klaudia");
                break;
            }
            previous = next;
        }


        System.out.println(names);
        Set<String> uniqueNames = new HashSet<>(names);
        //uniqueNames.addAll(names); <- tak też się da, ale lepiej użyć konstruktora
        System.out.println(uniqueNames);
        uniqueNames.remove("Ania");
        System.out.println(uniqueNames);

        for (String name : uniqueNames) {
            if (name.endsWith("a")) {
                System.out.println(name);
            }
        }
    }
}