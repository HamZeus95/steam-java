package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.List;

public class Level2 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /* TO DO 1: Retourner le nombre des enseignants dont le nom commence avec s */
        long nbr = teachers.stream().filter(t->t.getName().startsWith("s")).count();
        System.out.println("le nombre des enseignants dont le nom commence avec s : "+nbr);

        /* TO DO 2: Retourner la somme des salaires de tous les enseignants Flutter (hint: mapToInt) */
        long sum = teachers.stream().filter(t->t.getSubject().equals(Subject.FLUTTER)).mapToInt(t->t.getSalary()).sum();
        System.out.println("la somme des salaires de tous les enseignants Flutter : "+sum);

        /* TO DO 3: Retourner la moyenne des salaires des enseignants dont le nom commence avec a */
        double average = teachers.stream().filter(t->t.getName().startsWith("a")).mapToInt(Teacher::getSalary).average().orElse(0.0);
        System.out.println("la moyenne des salaires des enseignants dont le nom commence avec a :"+average);

        /* TO DO 4: Retourner la liste des enseignants dont le nom commence par f */
        List<Teacher> teachers1 = teachers.stream().filter(t->t.getName().startsWith("f")).toList();
        System.out.println("la liste des enseignants dont le nom commence par f : " +teachers1);

        /* TO DO 5: Retourner la liste des enseignants dont le nom commence par s */
        List<Teacher> teachers2 = teachers.stream().filter(t->t.getName().startsWith("s")).toList();
        System.out.println("la liste des enseignants dont le nom commence par s : " +teachers2);


        /* TO DO 5: Retourner true si il y a au min un enseignants dont le salaire > 100000, false si non */
        boolean test = teachers.stream().anyMatch(t->t.getSalary() >100000);
        System.out.println("exist il des enseignants dont le salaire > 100000 : " +test);

        /* TO DO 6: Afficher le premier enseignant Unity le nom commence avec g avec 2 manières différentes */
        /*First way*/
        Teacher teacherTest =  teachers.stream().filter(t->t.getSubject().equals(Subject.UNITY))
                .filter(t->t.getName().startsWith("g"))
                .findFirst()
                .orElse(null);
        System.out.println("<First way> le premier enseignant Unity le nom commence avec g : " +teacherTest);

        /*Second way*/
        teachers.stream().filter(t->t.getSubject().equals(Subject.UNITY))
                .filter(t->t.getName().startsWith("g"))
                .findFirst()
                .ifPresentOrElse(
                        teacher -> System.out.println("Premier enseignant Unity dont le nom commence par 'g': " + teacher),
                        () -> System.out.println("Aucun enseignant Unity dont le nom commence par 'g' n'a été trouvé.")
                );

        /* TO DO 7: Afficher le deuxième enseignant dont le nom commence avec s */
        teachers.stream().filter(t->t.getName().startsWith("s")).skip(1).findFirst().ifPresentOrElse(
                teacher -> System.out.println("Deuxième enseignant dont le nom commence par 's': " + teacher),
                () -> System.out.println("Aucun deuxième enseignant dont le nom commence par 's' n'a été trouvé.")
        );

    }
}
