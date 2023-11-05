package edu.hw4;

import edu.hw4.Validators.Validation;
import edu.hw4.Validators.ValidationError;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings({"checkstyle:LineLength", "checkstyle:RegexpSingleline"}) public final class StreamTasks {
    private StreamTasks() {}

    public static List<Animal> sortAnimalsHeight(List<Animal> animals) {
        if (animals == null) {
            return List.of();
        }
        return animals.stream().sorted(Comparator.comparing(Animal::height)).toList();
    }

    public static  List<Animal> sortAnimalsWeight(List<Animal> animals, int amount) {
        return animals.stream()
            .sorted(Comparator
                .comparing(Animal::weight)
                .reversed())
            .limit(amount)
            .toList();
    }

    public static Map<Animal.Type, Integer> numberOfEachAnimal(List<Animal> animals) {
        Map<Animal.Type, Integer> result = new HashMap<>();
        return animals
            .stream()
            .collect(Collectors
                .groupingBy(Animal::type, Collectors
                    .reducing(0, add -> 1, Integer::sum)));
    }

    public static Animal animalWithBiggestName(List<Animal> animals) {
        return animals
            .stream()
            .max(Comparator
                .comparing(Animal::name, Comparator
                    .comparingInt(String::length)))
            .get();
    }

    public static Animal.Sex biggestAmountOfAnimalsBySex(List<Animal> animals) {
        long amountOfFemale = animals.stream().filter(animal -> animal.sex() == Animal.Sex.F).count();
        long amountOfMale = animals.size() - amountOfFemale;

        return amountOfFemale > amountOfMale ? Animal.Sex.F : Animal.Sex.M;
    }

    public static Map<Animal.Type, Animal> animalsByBiggestWeight(List<Animal> animals) {
        return animals
            .stream()
            .collect(Collectors
                .toMap(Animal::type, Function.identity(), BinaryOperator
                    .maxBy(Comparator
                        .comparing(Animal::weight))));
    }

    public static Animal kthOldAnimal(List<Animal> animals, long k) {
        return animals
            .stream()
            .sorted(Comparator
                .comparing(Animal::age)
                .reversed())
            .skip(k - 1)
            .findFirst()
            .get();
    }

    public static Optional<Animal> biggestWeightAnimalLowerThanK(List<Animal> animals, long k) {
        return animals
            .stream()
            .filter(animal -> animal
                .height() < k)
            .max(Comparator
                .comparing(Animal::weight));
    }

    public static Integer countPaws(List<Animal> animals) {
        return animals.stream().mapToInt(Animal::paws).sum();
    }

    public static List<Animal> animalsWherePawsNotEqualAge(List<Animal> animals) {
        return animals
            .stream()
            .filter(animal -> animal.age() != animal.paws())
            .toList();
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    public static  List<Animal> animalsThatCanBiteAndNeededHeight(List<Animal> animals) {
        return animals.stream().filter(animal -> (animal.bites() && animal.height() < 100)).toList();
    }

    public static Integer animalsWithWeightBiggerThanHeight(List<Animal> animals) {
        return Math
            .toIntExact(animals
                .stream()
                .filter(animal -> animal.weight() > animal.height())
                .count());
    }

    public static List<Animal> animalsWithNameOfMoreThanTwoWords(List<Animal> animals) {
        return animals
            .stream()
            .filter(animal -> animal.name().contains(" "))
            .toList();
    }

    public static Boolean isDogInList(List<Animal> animals, long k) {
        return animals
            .stream()
            .filter(animal -> (animal.type() == Animal.Type.DOG && animal.height() > k))
            .toList()
            .size() != 0;
    }

    /*public static Map<Animal.Type, Integer> summaryWeightOfEachAnimalOfNeededAge(List<Animal> animals, long k, long i) {
        return animals.stream().filter(animal -> animal.age() > k && animal.age() < i).collect(Collectors.toMap(Animal::type, 1,
        ))
    }*/

    public static List<Animal> animalsSortedByTypeSexName(List<Animal> animals) {
        return animals
            .stream()
            .sorted(Comparator
                .comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .toList();
    }

    public static Boolean isSpidersBiteMoreThanDogs(List<Animal> animals) {
        return animals
            .stream()
            .filter(animal -> (animal.type() == Animal.Type.SPIDER && animal.bites()))
            .count()
            >
            animals
                .stream()
                .filter(animal -> (animal.type() == Animal.Type.DOG && animal.bites()))
                .count();
    }

    public static Animal mostWeightedFish(List<List<Animal>> animals) {
        long maxWeight = 0;
        Animal res = null;
        for (var elem : animals) {
            Animal cur = elem.stream()
                .filter(animal -> animal.type() == Animal.Type.FISH)
                .max(Comparator.comparing(Animal::weight)).get();
            if (cur.weight() > maxWeight) {
                maxWeight = cur.weight();
                res = cur;
            }
        }

        return res;
    }

    public static Map<String, Set<ValidationError>> animalsWithErrors(List<Animal> animals, List<Validation> validations) {
        return animals
            .stream()
            .filter(animal -> !animal.validating(validations).isEmpty())
            .collect(Collectors.toMap(Animal::name, animal -> animal.validating(validations)));
    }

    public static Map<String, String> beautifulAnimalsWithErrors(List<Animal> animals, List<Validation> validations) {
        return animals
            .stream()
            .filter(animal -> !animal.validating(validations).isEmpty())
            .collect(Collectors.toMap(Animal::name, animal -> animal.validating(validations)
                .toString()));
    }
}
